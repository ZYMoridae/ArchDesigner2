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


<h1 class="ad-model-h1">${entityName}</h1>
<hr>
<div class="row" style="text-align: center;margin-bottom: 2%;font-size: 25px;font-weight: 100;">
   <div class="col-md-2"></div>
    <div class="col-md-8">
        <span>Select an application profile and click the button below to execute AHP</span>
    </div>
    <div class="col-md-2"></div>
</div>
<div class="row" style="margin-bottom: 2%;">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="text-align: center;">
        <div id="pwa-app" class="fieldcontain required">
            <select class="form-control" style="width: 100%;" id="pwalternativeapp" name="pwalternativeapp">
                <option value="" style="text-align: center;">------Select an Application entry------</option>
                <g:each var="application" in="${userApplication}" >
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
        %{--<g:formRemote name="subForm" url="[controller:'ScoreAlternativeController', action:'calCulate']" onSuccess="executeScoring(data)">--}%
            %{--<input type="hidden" name="selApp" id="selApp" value="123">--}%
            %{--<g:submitButton name="generatePair" class="btn btn-primary btn-info" value="Score Alternatives" style="font-weight: 100;"></g:submitButton>--}%
        %{--</g:formRemote>--}%
        <button name="generatePair" id="generatePair" class="btn -btn-primary btn-info" value="Score Alternatives" style="font-weight: 100;" onclick="executeScoring();">Score Alternatives</button>
    </div>
    <div class="col-md-3"></div>
</div>

<hr>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6" id="resultblock" style="text-align: center">
        <div class="col-md-12" id="resultalter" style="font-size: 20px;font-weight: 200;color: #4285F4;"></div>
        <div class="col-md-12" id="resultdec" style="font-size: 20px;font-weight: 200;color: #4285F4;"></div>
    </div>
    <div class="col-md-3"></div>
</div>

<script>
    $("form input").addClass("form-control");
    $("form select").addClass("form-control");
    $("#resultalter").hide();
    $("#resultdec").hide();

    function executeScoring(){
        var selectedApp = $("#pwalternativeapp option:selected").val();
        $.ajax({
            url: '/scoreAlternative/calculateScore',
            data: { applicationid : selectedApp},
            dataType: 'json',
            contentType: 'application/json',
            success: function(data){
                if(data!=""){
                    if(data.bestalter != "" && data.bestdec != ""){
                        $("#resultalter").text("The best Alternative is "+data.bestalter);
                        $("#resultdec").text("The best Decision is "+data.bestdec);
                        $("#resultalter").fadeIn();
                        $("#resultdec").fadeIn();
                    }
                }else{
                    $("#resultalter").text("");
                    $("#resultdec").text("");
                    $("#resultalter").fadeOut();
                    $("#resultdec").fadeOut();
                }
            },
            error: function(data){
                $("#resultalter").fadeOut();
                $("#resultdec").fadeOut();
//                $("#resultalter").text("");
//                $("#resultdec").text("");
            }
        });
    }

</script>




</body>
</html>