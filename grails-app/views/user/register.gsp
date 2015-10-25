<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 9/10/2015
  Time: 3:05 PM
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

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <!-- Modal -->
            <div class="panel panel-default" style="margin-top: 10vh;">
                <div class="panel-heading">ArchDesigner v2.0</div>
            <div class="panel-body">
                <g:form action="registerUser">

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
                            <input class="form-control" type="text" name="${fieldFname}" value="" required=""/>
                        </div>


                        <div class="fieldcontain required"> <label for="${fieldLname}">
                            Last Name<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="text" name="${fieldLname}" value="" required=""/>
                        </div>

                        <div class="fieldcontain required"> <label for="${fieldPwd}">
                            Password<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="password" name="${fieldPwd}" value="" required=""/>
                        </div>


                        <div class="fieldcontain required"> <label for="${fieldLevel}">
                            User level<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="text" name="${fieldLevel}" value="" required=""/>
                        </div>


                        <div class="fieldcontain required"> <label for="${fieldEmail}">
                            Email<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="email" name="${fieldEmail}" value="" required=""/>
                        </div>

                        <div class="fieldcontain required"> <label for="${fieldRemark}">
                            Remark<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="text" name="${fieldRemark}" value="" required=""/>
                        </div>

                    </fieldset>
                %{--End substitution--}%


                    </div>
                %{--End modal-body--}%
                    <fieldset class="buttons" style="text-align: right;margin-right: 3%;margin-bottom: 3%;">
                        <g:submitButton name="register" class="save btn btn-primary btn-success" value="Register" />
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