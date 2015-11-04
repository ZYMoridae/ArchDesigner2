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
    <asset:stylesheet src="animate.css"/>
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
    .panel{
        border: none !important;
    }
    body{
        background: rgba(176,252,238,1);
        background: -moz-linear-gradient(-45deg, rgba(176,252,238,1) 0%, rgba(178,219,191,1) 50%, rgba(238,245,206,1) 100%);
        background: -webkit-linear-gradient(-45deg, rgba(176,252,238,1) 0%, rgba(178,219,191,1) 50%, rgba(238,245,206,1) 100%);
        background: -o-linear-gradient(-45deg, rgba(176,252,238,1) 0%, rgba(178,219,191,1) 50%, rgba(238,245,206,1) 100%);
        background: -ms-linear-gradient(-45deg, rgba(176,252,238,1) 0%, rgba(178,219,191,1) 50%, rgba(238,245,206,1) 100%);
        background: linear-gradient(135deg, rgba(176,252,238,1) 0%, rgba(178,219,191,1) 50%, rgba(238,245,206,1) 100%);
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#b0fcee', endColorstr='#eef5ce', GradientType=1 );
    }
    </style>
</head>

<body>

<div class="container animated fadeIn">
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
                        <g:set var="fieldcPwd" value="usercpwd" />
                        <g:set var="fieldLevel" value="userlevel" />
                        <g:set var="fieldEmail" value="email" />
                        <g:set var="fieldSessionid" value="sessionid" />
                        <g:set var="fiedlTimestamp" value="timestamp" />
                        <g:set var="fieldRemark" value="remark" />

                        <div class="fieldcontain required"> <label data-toggle="tooltip" data-placement="right" title="First name should less than 15 characters" for="${fieldFname}">
                            First Name<span class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="text" name="${fieldFname}" value="" required=""/>
                        </div>


                        <div class="fieldcontain required"> <label data-toggle="tooltip" data-placement="right" title="Last name should less than 15 charaters" for="${fieldLname}">
                            Last Name<span class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="text" name="${fieldLname}" value="" required=""/>
                        </div>

                        <div class="fieldcontain required"> <label data-toggle="tooltip" data-placement="right" title="The length of password should be controlled in 10-15 characters"for="${fieldPwd}">
                            Password<span class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="password" id="${fieldPwd}" name="${fieldPwd}" value="" required=""/>
                        </div>

                        <div class="fieldcontain required"> <label data-toggle="tooltip" data-placement="right" title="The length of password should be controlled in 10-15 characters"for="${fieldcPwd}">
                            Confirm your password Password<span id="tip-pwd" class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="password" id="${fieldcPwd}" name="${fieldcPwd}" value="" required=""/>
                        </div>


                        <div class="fieldcontain required" style="display: none;"> <label for="${fieldLevel}">
                            User level<span class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="text" name="${fieldLevel}" value="2" required=""/>
                        </div>


                        <div class="fieldcontain required"> <label data-toggle="tooltip" data-placement="right" title="Write your email address here" for="${fieldEmail}">
                            Email<span class="required-i\ndicator" style="color: red;">*</span></label>
                            <input class="form-control" type="email" name="${fieldEmail}" value="" required=""/>
                        </div>

                        <div class="fieldcontain required" style="display: none;"> <label for="${fieldRemark}">
                            Remark<span class="required-i\ndicator">*</span></label>
                            <input class="form-control" type="text" name="${fieldRemark}" value="23" required=""/>
                        </div>



                    </fieldset>
                %{--End substitution--}%


                    </div>
                %{--End modal-body--}%
                    <fieldset class="buttons" style="text-align: right;margin-right: 3%;margin-bottom: 3%;">
                        <g:submitButton name="register" class="save btn btn-primary btn-success" style="font-weight: 100;" value="Register" />
                    </fieldset>
                </g:form>
                <div class="panel-footer">MSEP Group2</div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

<asset:javascript src="jquery.min.js"/>
<script>
    $(document).ready(function(){
        $("form input").addClass("form-control");
    });
    $('#usercpwd').focusout(function(){
        var test1 = $('#usercpwd').val();
        var test2 = $('#userpwd').val();
        if(test1 != test2){
           $('#tip-pwd').text("* Please confirm your password again!");
        }else{
            $('#tip-pwd').text("*");
        }
    });
</script>
</body>
</html>