<%@ page import="newgrails.ArchApplication" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    %{--<asset:stylesheet src="application.css"/>--}%
    %{--<asset:javascript src="application.js"/>--}%


    <link rel="shortcut icon" href="/ArchDesigner/image/favicon.ico">
    <!-- Bootstrap Core CSS -->
    <asset:stylesheet src="bootstrap.min.css"/>

    <!-- Data tables with bootstrap theme  -->
    <link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">

    <!-- MetisMenu CSS -->
    <asset:stylesheet src="metisMenu.min.css"/>

    <!-- Timeline CSS -->
    <asset:stylesheet src="timeline.css"/>

    <!-- Custom CSS -->
    <asset:stylesheet src="sb-admin-2.css"/>

    %{-- Animate CSS --}%
    <asset:stylesheet src="animate.css"/>

    <!-- Morris Charts CSS -->
    <asset:stylesheet src="morris.css"/>

    <!-- Custom Fonts -->
    <asset:stylesheet src="font-awesome.min.css"/>

    %{--Custome Style--}%
    <style type="text/css">
    .chover{
        background-color: #4285F4;
        transition: background-color 0.5s ease;
    }
    .chover:hover{
        background-color: #3E72DE;
    }
    .tooltip {
        z-index: 2000 !important;
    }
    .logout-btn{
        border: 0px;
        background: transparent;
        padding: 3px 20px 3px 20px;
        width: 100%;
    }
    .logout-btn:hover{
        background: #F5F5F5;
    }
    .logout-btn:focus{
        outline: 0;
    }
    </style>

    <g:layoutHead/>
</head>


<body class="animated fadeIn">

<%
    if(session.user == null){
        response.sendRedirect("/user/login");
    }else{
        def targetApp = newgrails.ArchApplication.findAll("from ArchApplication as c where c.appName='" + session.user.id + "'")
        ArrayList<ArchApplication> userApplication = new ArrayList<>();
    }
%>

<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Personal Profile</h4>
            </div>
            <!-- End of modal-header -->
            <div class="modal-body">
                <table id="apptable" style="border: none;">
                    <tbody>
                    <tr>
                        <td style="border: none;"><label>Username</label></td>
                        <td style="border: none;"><input class="form-control" type="text" id="username"
                                                         name="username" value='' style="width: 250px;" /></td>
                        <td style="border: none;">&nbsp;&nbsp;<i class="fa fa-info-circle" data-toggle="tooltip" data-placement="right" title="Username must under 18 characters!"></i></td>
                    </tr>
                    <tr>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="border: none;"><label>Password</label></td>
                        <td style="border: none;">
                            <input class="form-control" type="password" id="password"
                                   style="width: 250px;">
                            </input>
                        </td>
                        <td style="border: none;">&nbsp;&nbsp;<i class="fa fa-info-circle" data-toggle="tooltip" data-placement="right" title="Password should include 10 characters!"></i></td>
                    </tr>
                    <tr>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="border: none;"><label>E-mail</label></td>
                        <td style="border: none;"><input class="form-control" type="text" id="email"
                                                         name="email" value='' style="width: 250px;" /></td>
                    </tr>
                    <tr>
                        <td style="border: none;">&nbsp;</td>
                        <td style="border: none;">&nbsp;</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- End of modal-body -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <input class="btn btn-info" value="Update"
                       type="button"
                />
            </div>
            <!-- End of modal-footer -->
        </div>
        <!-- End of modal-content -->
    </div>
    <!-- End of modal-dialog -->
</div>
<!-- End of modal -->

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;background-color: #4285F4;box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.3);border: none;">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div>
                <a class="navbar-brand" style="color:white;font-weight: 100;" href="/">ArchDesigner v2.0</a>
                %{--<a href="http://crest-centre.net"><img src="${assetPath(src: 'crest.png')}" style="height: 40px;margin-top: 1%;"/></a>--}%
            </div>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <div class="dropdown-toggle chover" data-toggle="dropdown" style="padding: 15px;" href="#">
                    <i class="fa fa-user fa-fw" style="color:white;"></i>  <i class="fa fa-caret-down" style="color:white;"></i>
                </div>
                <ul class="dropdown-menu dropdown-user animated fadeIn">
                    <form action="/user/logout">
                        <li>
                            <button class="logout-btn" onclick="submit()"><i class="fa fa-sign-out fa-fw"></i> Log out</button>
                        </li>
                    </form>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <!--Modify the side bar-->
                    <li>
                        <a href="#"><i class="fa fa-list-alt fa-fw"></i> Preparation<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            %{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--}%
                                %{--<li class="controller"><g:link--}%
                                        %{--controller="${c.logicalPropertyName}">${c.name}</g:link></li>--}%
                            %{--</g:each>--}%
                            <li>
                                <a href="/archApplication/index">Application</a>
                            </li>
                            <li>
                                <a href="/stakeholder/index">Stakeholder</a>
                            </li>
                            <li>
                                <a href="/quality/index">Quality</a>
                            </li>
                            <li>
                                <a href="/decision/index">Decision</a>
                            </li>
                            <li>
                                <a href="/alternative/index">Alternative</a>
                            </li>


                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-trophy fa-fw"></i> Scoring<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/pairwiseQuality/index">Pairwise Quality</a>
                            </li>
                            <li>
                                <a href="/pairwiseAlternative/index">Pairwise Alternative</a>
                            </li>
                            <li>
                                <a href="/scoreAlternative/index">Score Alternative</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart fa-fw"></i> Analysis<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/combinationCentric/index">Decision-Centric</a>
                            </li>
                            <li>
                                <a href="/combinationCentric/generate">Generate Report</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <%
                        if(session.user != null && session.username == "admin"){
                    %>
                    <li>
                        <a href="/user/index"><i class="fa fa-users fa-fw"></i> User Manager</a>
                    </li>
                    <%
                        }
                    %>
                    <li>
                        <a href="/404/">
                            <i class="fa fa-tasks fa-fw"></i> Others
                        </a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <!-- /#wrapper -->
    <!-- JQuery Javascript -->
    <asset:javascript src="jquery.min.js"/>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


    <!-- Datatable Javascript -->
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

    <!-- Datatable with bootstrap theme Javascript -->
    <script src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <asset:javascript src="metisMenu.min.js"/>

    <!-- Morris Charts JavaScript -->
    <asset:javascript src="raphael-min.js"/>
    <asset:javascript src="morris.min.js"/>

    <!-- Custom Theme JavaScript -->
    <asset:javascript src="sb-admin-2.js"/>
    <asset:javascript src="jquery-ui.js"/>


    <asset:javascript src="jquery.dataTables.columnFilter.js"/>
    <script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</div>

<div id="page-wrapper">
    <g:layoutBody/>
</div>

</body>
</html>
