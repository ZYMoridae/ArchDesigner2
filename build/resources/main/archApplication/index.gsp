<%@ page import="newgrails.ArchApplication" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'archApplication.label', default: 'ArchApplication')}" />
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

                    <div class="fieldcontain required">
                        <label for="appname">ApplicationName<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="appName" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="user">User
                        <span class="required-i ndicator">*</span></label>
                        <select class="form-control" name="user.id">
                            <g:each var="user" in="${newgrails.User.getAll()}" >
                                <option value="${user.id}">${user.fname}.${user.lname}</option>
                            </g:each>
                        </select>
                    </div>

                    <div class="fieldcontain required">
                        <label for="remark">Remark<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="remark" value="" required=""/>
                    </div>


                </fieldset>
            %{--End substitution--}%


                </div>
            %{--End modal-body--}%
                <div class="modal-footer">

                         <fieldset class="buttons">
                         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
        </div>
        %{--End modal-content--}%
    </div>
    %{--End modal-dialog--}%
</div>




<h1 class="ad-model-h1"><g:message code="default.list.label" args="[entityName]" /></h1>
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
                    <td>Application</td>
                    <td>User</td>
                    <td>Remark</td>
                    <td>Edit</td>
                    <td>Delete</td>
                    </thead>
                    <tbody>
                    <g:each in="${newgrails.ArchApplication.findAll("from ArchApplication as c where c.user=:myuser", [myuser: session.user], [cache: true])}" var="application" status="i">
                        <tr>
                            <td>${application.appName}</td>
                            <td>${newgrails.User.findById(application.userId).fname} ${newgrails.User.findById(application.userId).lname}</td>
                            <td>${application.remark}</td>
                            <td>
                                <div class="ad-model-edit modal fade" id="myuserModal-${application.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h2 class="modal-title" id="myModalLabel2">
                                                    Edit ${entityName}
                                                </h2>
                                            </div>
                                        <div class="modal-body">
                                            <g:form resource="${application}" method="PUT">
                                                <g:hiddenField name="version" value="${this.application?.version}" />

                                                <fieldset class="form">
                                                    <ad:sall entityid="${application.id}" entitytype="application"></ad:sall>
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



                                <a data-toggle="modal" data-target="#myuserModal-${application.id}">
                                    <i class="ad-edit fa fa-pencil fa-2x"></i>
                                </a>

                            </td>
                            <td>
                                <g:form resource="${application}" method="DELETE">
                                    <a onclick="$(this).closest('form').submit();">
                                        <i class="ad-delete fa fa-trash-o fa-2x"></i>
                                    </a>
                                </g:form>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>


                </table>

                <div class="pagination">
                    <g:paginate next="Next" prev="Prev" total="${archApplicationCount?: 0}" />
                </div>

            </div>
            %{--End panel-body--}%
            <div class="panel-footer" >
                <h3 class="panel-title">
                    MSEP Group2
                </h3>
            </div>
        </div>
        %{--End panel--}%
    </div>
    %{--End col-md-12--}%
</div>


<script>
    $(document).ready(function(){
        $("form input").addClass("form-control");
        $("form select").addClass("form-control");
    });
</script>

</body>
</html>