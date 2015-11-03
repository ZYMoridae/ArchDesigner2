<%@ page import="newgrails.User; newgrails.Decision; newgrails.ArchApplication" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'pairwiseAlternative.label', default: 'PairwiseAlternative')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

    %{--ArchDesigner CSS--}%
    <asset:stylesheet src="archdesigner.css"/>
</head>
<body>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    %{--Begin modal-dialog--}%
    <div class="modal-dialog" role="document">
        %{--Begin modal-content--}%
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title" id="myModalLabel">Add ${entityName}</h2>
            </div>
            %{--Begin modal-body--}%
        <div class="modal-body">
            <g:form action="save">

            %{--Start substitution--}%
                <fieldset class="form">

                    <div class="fieldcontain required"> <label for="app">App<span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="app.id">
                            <g:each var="application" in="${newgrails.ArchApplication.getAll()}" >
                                <option value="${application.id}">${application.appName}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="fieldcontain required"> <label for="decision">Decision<span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="decision.id">
                            <g:each var="decision" in="${newgrails.Decision.getAll()}" >
                                <option value="${decision.id}">${decision.decisionName}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="fieldcontain required"> <label for="quality">Quality<span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="quality.id">
                            <g:each var="quality" in="${newgrails.Quality.getAll()}" >
                                <option value="${quality.id}">${quality.qualityName}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="fieldcontain required"> <label for="firstalter">First Alternative<span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="alternative.id">
                            <g:each var="alternative" in="${newgrails.Alternative.getAll()}" >
                                <option value="${alternative.id}">${alternative.alternativeName}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="fieldcontain required"> <label for="secondalter">Second Alternative<span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="alternative.id">
                            <g:each var="alternative" in="${newgrails.Alternative.getAll()}" >
                                <option value="${alternative.id}">${alternative.alternativeName}</option>
                            </g:each>
                        </select>
                    </div>


                    <div class="fieldcontain required"> <label for="weight">Weight<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="weight" value="" required=""/></div>


                    %{--<ad:all bean="user"></ad:all>--}%
                </fieldset>
            %{--End substitution--}%


                </div>
            %{--End modal-body--}%
                <div class="modal-footer">
                    <fieldset class="buttons">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
                </div>
            </g:form>
        </div>
        %{--End modal-content--}%
    </div>
    %{--End modal-dialog--}%
</div>




<h1 class="ad-model-h1"><g:message code="default.list.label" args="[entityName]" /></h1>
<hr>
<div class="row" style="margin-bottom: 2%;">
    <div class="col-md-4">
        <div id="pwa-app" class="fieldcontain required"><label for="pwapp">App
            <span class="required-indicator">*</span></label>
            <select class="form-control" style="width: 100%;" id="pwalternativeapp" name="pwalternativeapp">
                <option value="" style="text-align: center;">------Select an Application entry------</option>
                <g:each var="application" in="${userApplication}" >
                    <option value="${application.id}">${application.appName}</option>
                </g:each>
            </select>
        </div>
    </div>

</div>

<div class="row">
    <div class="col-md-6">
        <g:form action="generatePairwise">
            <input type="hidden" name="selApp" id="selApp">
            <g:submitButton name="generatePair" class="btn btn-primary btn-info" value="Generate Pairwise" style="font-weight: 100;"></g:submitButton>
        </g:form>
    </div>
    <div class="col-md-6">
        <g:form action="">
            <input type="hidden" name="delApp" id="delApp" value="123">
            <g:submitButton name="deletePair" class="btn btn-primary btn-danger" value="Delete Pairwise" style="font-weight: 100;">
            </g:submitButton>
        </g:form>
    </div>
</div>

<hr>
%{--Start row--}%
<div class="row">
    %{--Start col-md-12--}%
    <div class="col-md-12">
        %{--Start panel--}%
        <div class="panel panel-default">
            <div class="panel-heading">
                <a data-toggle="modal" data-target="#myModal">
                    <i class="ad-add fa fa-plus-circle fa-2x"></i>
                </a>
            </div>
            %{--Start panel-body--}%
            <div class="panel-body" style="text-align: center;">

                <table id="userContent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <td>ApplicationName</td>
                        <td>DecisionName</td>
                        <td>Alternative1</td>
                        <td>Alternative2</td>
                        <td>QualityName</td>
                        <td>Weight</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>
                    </thead>
                    <tbody id="pqdata">


                    <g:each in="${newgrails.PairwiseAlternative.getAll()}" var="pairwisealternative" status="i">
                        <tr>
                            <td>${newgrails.ArchApplication.findById(pairwisealternative.appId).appName}</td>
                            <td>${newgrails.Decision.findById(pairwisealternative.decisionId).decisionName}</td>
                            <td>${newgrails.Alternative.findById(pairwisealternative.firstalterId).alternativeName}</td>
                            <td>${newgrails.Alternative.findById(pairwisealternative.secondalterId).alternativeName}</td>
                            <td>${newgrails.Quality.findById(pairwisealternative.qualityId).qualityName}</td>
                            <td>${pairwisealternative.weight}</td>
                            <td>
                                <div class="ad-model-edit modal fade" id="myuserModal-${pairwisealternative.id}" tabindex="-1"
                                     role="dialog"
                                     aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h2 class="modal-title" id="myModalLabel2">Edit
                                                ${entityName}
                                                </h2>
                                            </div>
                                        <div class="modal-body">
                                            <g:form resource="${pairwisealternative}" method="PUT">
                                                <g:hiddenField name="version" value="${this.pairwisealternative?.version}" />


                                                <fieldset class="form">
                                                    <ad:sall entityid="${pairwisealternative.id}" entitytype="pairwiseAlternative"></ad:sall>
                                                </fieldset>

                                                </div>
                                                <div class="modal-footer">

                                                    <fieldset class="buttons">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                        <input class="save btn btn-primary" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                                                    </fieldset>
                                                </div>
                                            </g:form>
                                        </div>
                                    </div>
                                </div>



                                <a data-toggle="modal" data-target="#myuserModal-${pairwisealternative.id}">
                                    <i class="ad-edit fa fa-pencil fa-2x"></i>
                                </a>

                            </td>
                            <td>
                                <g:form resource="${pairwisealternative}" method="DELETE">
                                    <a onclick="$(this).closest('form').submit();">
                                        <i class="ad-delete fa fa-trash-o fa-2x"></i>
                                    </a>
                                </g:form>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>


                </table>

                %{--<div class="pagination">--}%
                %{--<g:paginate next="Next" prev="Prev" total="${pairwiseQualityCount?: 0}" />--}%
                %{--</div>--}%

            </div>
            %{--End panel-body--}%
            <div class="panel-footer" >
                <h3 class="panel-title">
                    MSEP Group1
                </h3>
            </div>
        </div>
        %{--End panel--}%
    </div>
    %{--End col-md-12--}%
</div>

<script>
    var selectedApp;
    var selectedStakeholder;
    var selectedDecision;

    $("#pwalternativeapp").change(function(){
        $("#selApp").val($("#pwalternativeapp option:selected").val());
    });

    $(document).ready(function(){
        $("form input").addClass("form-control");
        $("form select").addClass("form-control");
        $("#pwa-app").show();
        $('#userContent').DataTable();
        $('#userContent').dataTable().columnFilter({
            sPlaceHolder : 'head:before',
            aoColumns: [ { type: "select"},
                { type: "select" },
                { type: "select" },
                { type: "select" },
                { type: "select" },
                { type: "select" },
                null,
                null
            ]
        });
    });

</script>

</body>
</html>