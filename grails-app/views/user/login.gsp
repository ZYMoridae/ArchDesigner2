<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 9/10/2015
  Time: 12:44 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="singlepage" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title>Login</title>

    %{--ArchDesigner CSS--}%
    <asset:stylesheet src="archdesigner.css"/>
    <style>
        .panel-heading{
            text-align: left;
            color: white !important;
            font-size: 20px;
            font-weight: 100;
        }
        .panel-footer{
            text-align: center;
            color: white;
            font-size: 15px;
            font-weight: 100;
        }
    </style>
</head>

<body>
    <g:if test="${session.user != null}">
        Hello ${session.user.fname}
    </g:if>

    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <!-- Modal -->
                <div class="panel panel-default" style="margin-top: 20vh;">
                    <div class="panel-heading">ArchDesigner v2.0</div>
                    <div class="panel-body">
                    <g:form action="loginValidate">

                    %{--Start substitution--}%
                        <fieldset class="form">

                            <g:set var="fieldPwd" value="userpwd" />
                            <g:set var="fieldEmail" value="email" />

                            <div class="fieldcontain required"> <label for="${fieldEmail}">
                                Email<span class="required-indicator">*</span></label>
                                <input class="form-control" type="email" name="${fieldEmail}" value="" required=""/>
                            </div>

                            <div class="fieldcontain required"> <label for="${fieldPwd}">
                                Password<span class="required-indicator">*</span></label>
                                <input class="form-control" type="password" name="${fieldPwd}" value="" required=""/>
                            </div>

                        </fieldset>
                    %{--End substitution--}%


                        </div>
                    %{--End modal-body--}%
                            <fieldset class="buttons" style="text-align: right;margin-right: 3%;margin-bottom: 3%;">
                                <a href="/user/register" class="btn btn-default btn-info" data-dismiss="modal">Register</a>
                                <g:submitButton name="login" class="save btn btn-primary btn-success" value="Login" />
                            </fieldset>
                    </g:form>
                    <div class="panel-footer">MSEP Group2</div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>

<script>
    $(document).ready(function(){
        $("form input").addClass("form-control");
    });
</script>

</body>
</html>