<%@ page import="newgrails.User; newgrails.Decision; newgrails.ArchApplication" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'scoreAlternative.label', default: 'ScoreAlternative')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

    %{--ArchDesigner CSS--}%
    <asset:stylesheet src="archdesigner.css"/>
</head>
<body>
    <h1 style="margin-top: 0px;padding-top: 20px;font-size: 36px;font-weight: 100;">Generate Report</h1>

    <hr>

<div class="row" style="margin-bottom: 2%;">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="text-align: center;">
        <div id="gen-app" class="fieldcontain required">
            <select class="form-control" style="width: 100%;" id="generate-app" name="generate-app">
                <option value="-1" style="text-align: center;">------Select an Application entry------</option>
                <g:each var="application" in="${newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])}" >
                    <option value="${application.id}">${application.appName}</option>
                </g:each>
            </select>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>


<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="text-align: center;">
        <button name="generatePair" id="generatePair" class="btn btn-primary btn-info" value="Score Alternatives" style="font-weight: 100;margin-top: 5%;padding: 3% 20% 3% 20%;" onclick="generateDiagram();">Generate Report</button>
    </div>
    <div class="col-md-3"></div>
</div>


<div style="padding-bottom: 50px;">
    <canvas id="myChart"></canvas>
    <div style="text-align: center">
        <ul id="my-legend">

        </ul>
        %{--<div id="placeholder" style="text-align: left;padding-left: 50%;"></div>--}%
    </div>
</div>


<asset:javascript src="Chart.js"/>
<asset:javascript src="jspdf.js"/>
<asset:javascript src="jspdf.plugin.addimage.js"/>
<asset:javascript src="jspdf.plugin.from_html.js"/>
<asset:javascript src="FileSaver.js"/>

<script>
    function generateDiagram(){
        var selectedApp = $("#generate-app option:selected").val();
        $.ajax({
            url: '/combinationCentric/generateReport',
            data: { applicationid : selectedApp},
            dataType: 'json',
            contentType: 'application/json',
            success: function(data){

                $('#myChart').replaceWith('<canvas id="myChart" style="visibility: hidden;"></canvas>')
                var ctx = document.getElementById("myChart");
                var myBarChart = new Chart(ctx.getContext("2d")).Bar(data, {
                    responsive: true,
                });
                $('#myChart').load('/combinationCentric/generate #myChart');
                var imgData = ctx.toDataURL('image/jpeg');

                var doc = new jsPDF();
                doc.addImage(imgData, 'jpeg', 15, 40, 180, 160);
                doc.save('sample-file.pdf');

            },
            error: function(data){
                alert(data);
            }
        });
    }
</script>

</body>
</html>