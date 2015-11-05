<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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

                    <g:set var="fieldFname" value="fname" />
                    <g:set var="fieldLname" value="lname" />
                    <g:set var="fieldPwd" value="userpwd" />
                    <g:set var="fieldLevel" value="userlevel" />
                    <g:set var="fieldEmail" value="email" />
                    <g:set var="fieldSessionid" value="sessionid" />
                    <g:set var="fiedlTimestamp" value="timestamp" />
                    <g:set var="fieldRemark" value="remark" />

                    <div class="fieldcontain required"> <label for="${fieldFname}">
                        First Name<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="${fieldFname}" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="${fieldLname}">
                        Last Name<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="${fieldLname}" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="${fieldPwd}">
                        Password<span class="required-i\ndicator">*</span></label>
                        <input type="password" name="${fieldPwd}" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="${fieldLevel}">
                        User level<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="${fieldLevel}" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="${fieldEmail}">
                        Email<span class="required-i\ndicator">*</span></label>
                        <input type="email" name="${fieldEmail}" value="" required=""/>
                    </div>

                    <div class="fieldcontain required"> <label for="${fieldRemark}">
                        Remark<span class="required-i\ndicator">*</span></label>
                        <input type="text" name="${fieldRemark}" value="" required=""/>
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
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a data-toggle="modal" data-target="#myModal">
                    <i class="ad-add fa fa-plus-circle fa-2x"></i>
                </a>
            </div>
            <div class="panel-body" style="text-align: center;">
                <table id="userContent" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <td>First Name</td>
                            <td>Last Name</td>
                            %{--<td>Password</td>--}%
                            %{--<td>User Level</td>--}%
                            <td>Email</td>
                            %{--<td>Remark</td>--}%
                            <td>Edit</td>
                            <td>Delete</td>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${newgrails.User.getAll()}" var="user" status="i">
                        <tr>
                            <td>${user.fname}</td>
                            <td>${user.lname}</td>
                            %{--<td>${user.userpwd}</td>--}%
                            %{--<td>${user.userlevel}</td>--}%
                            <td>${user.email}</td>
                            %{--<td>${user.remark}</td>--}%
                            <td>
                                <div class="ad-model-edit modal fade" id="myuserModal-${user.id}" tabindex="-1"
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
                                            <g:form resource="${user}" method="PUT">
                                                <g:hiddenField name="version" value="${this.user?.version}" />

                                                <fieldset class="form">
                                                    <ad:sall entityid="${user.id}" entitytype="user"></ad:sall>
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

                                <a data-toggle="modal" data-target="#myuserModal-${user.id}">
                                    <i class="ad-edit fa fa-pencil fa-2x"></i>
                                </a>

                            </td>
                            <td>
                                <g:form resource="${user}" method="DELETE">
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
                    %{--<g:paginate next="Next" prev="Prev" total="${userCount ?: 0}" />--}%
                %{--</div>--}%

            </div>
            <div class="panel-footer" >
                <h3 class="panel-title">
                    MSEP Group2
                </h3>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("form input").addClass("form-control");
        $('#userContent').DataTable();
    });
</script>

</body>
</html>