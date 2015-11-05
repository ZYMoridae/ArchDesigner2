<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'combinationCentric.label', default: 'CombinationCentric')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>

    </head>
    <body>

    <h1 style="margin-top: 0px;padding-top: 20px;font-size: 36px;font-weight: 100;">Combination Centric</h1>

    <hr>

    <div class="row">
        <div class="col-md-6">
            <div id="cc-application" class="fieldcontain required"><label for="ccapp">Application
                <span class="required-indicator">*</span></label>
                <select class="form-control" style="width: 100%;" id="ccapplication" name="ccapplication">
                    <option value="-1" style="text-align: center;">------Select an Application entry------</option>
                    <g:each var="application" in="${userApp}" >
                        <option value="${application.id}">${application.appName}</option>
                    </g:each>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <div id="cc-decision" class="fieldcontain required"><label for="ccdec">Decision
                <span class="required-indicator">*</span></label>
                <select class="form-control" style="width: 100%;" id="ccdecision" name="ccdecision">
                    <option value="-1" style="text-align: center;">------Select an Decision entry------</option>
                    <g:each var="decision" in="${userDecision}" >
                        <option value="${decision.id}">${decision.decisionName}</option>
                    </g:each>
                </select>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="padding-top: 10px;padding-bottom: 10px;text-align: center;">
            <button name="generatePair" id="generatePair" class="btn -btn-primary btn-info" value="Score Alternatives" style="font-weight: 100;padding: 2% 20% 2% 20%;margin-top: 5%;" onclick="generateDiagram();">Score Alternatives</button>
        </div>
        <div class="col-md-2"></div>
    </div>

    <hr>

    <h3 id="diagram-header" style="margin-top: 0px;padding-top: 10px;padding-bottom: 10px;"></h3>

    <div style="padding-bottom: 50px;text-align: center;">
        <h3 style="font-weight: 100;" id="diagram-title"></h3>
        <canvas id="myChart"></canvas>
        <div style="text-align: center">
            <ul id="my-legend">

            </ul>
           %{--<div id="placeholder" style="text-align: left;padding-left: 50%;"></div>--}%
        </div>
    </div>

        <asset:javascript src="Chart.js"/>
        <asset:javascript src="legend.js"/>

        <script>



        function generateDiagram(){
            var selectedApp = $("#cc-application option:selected").val();
            var selectedDec = $("#cc-decision option:selected").val();
            var appTitle = $("#cc-application option:selected").text();
            var decTitle = $("#cc-decision option:selected").text();
            $.ajax({
                url: '/combinationCentric/executeReport',
                data: { applicationid : selectedApp, decisionid: selectedDec},
                dataType: 'json',
                contentType: 'application/json',
                success: function(data){
                   if(data!=null){
                       $('#diagram-header').text("Diagram");
                       $('#diagram-title').text(appTitle+" and "+decTitle + " Chart");
                       $('#diagram-header').fadeIn();
                       $('#diagram-title').fadeIn();
//                       $('#diagram-header').css("visibility","visible").fadeIn();
                       $('#myChart').replaceWith('<canvas id="myChart"></canvas>')
                       ctx = document.getElementById("myChart").getContext("2d");
//                    legend(document.getElementById('placeholder'), data);
                       myBarChart = new Chart(ctx).Bar(data, {
                           responsive: true,
                       });
                   }else{
                       $('#myChart').fadeOut();
                   }
                },
                error: function(data){
                    $('#myChart').fadeOut();
                    $('#diagram-header').fadeOut();
                    $('#diagram-title').fadeOut();
                }
            });
        }




        </script>
    </body>
</html>