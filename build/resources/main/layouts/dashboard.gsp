<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 10/09/15
  Time: 1:52 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link rel="shortcut icon" href="/ArchDesigner/image/favicon.ico">

    <!-- Bootstrap Core CSS -->
    <link href="/ArchDesigner/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Data tables with bootstrap theme  -->
    <link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">

    <!-- MetisMenu CSS -->
    <link href="/ArchDesigner/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="/ArchDesigner/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/ArchDesigner/dist/css/sb-admin-2.css" rel="stylesheet">

    <link href="/ArchDesigner/dist/css/animate.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/ArchDesigner/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/ArchDesigner/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
    </style>
</head>


<body>


<!-- Modal -->

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
            <a class="navbar-brand" style="color:white;font-weight: 100;" href="/ArchDesigner/Main/mainpage.jsp">ArchDesigner v2.0</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <div class="dropdown-toggle chover" data-toggle="dropdown" style="padding: 15px;" href="#">
                    <i class="fa fa-user fa-fw" style="color:white;"></i>  <i class="fa fa-caret-down" style="color:white;"></i>
                </div>
                <ul class="dropdown-menu dropdown-user animated fadeIn">
                    <li><a href="#profileModal" data-toggle="modal"><i class="fa fa-user fa-fw" ></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/ArchDesigner/Main/loginpage.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
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
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Preparation<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/ArchDesigner/Main/application.jsp">Application Profile</a>
                            <li>
                                <a href="/ArchDesigner/Main/decision.jsp">Decision</a>
                            </li>
                            <li>
                                <a href="/ArchDesigner/Main/stakeholder.jsp">Stakeholder</a>
                            </li>
                            <li>
                                <a href="/ArchDesigner/Main/quality.jsp">Quality</a>
                            </li>
                            <li>
                                <a href="/ArchDesigner/Main/alternative.jsp">Alternative</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> Scoring<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/ArchDesigner/Main/pairwisequality.jsp">Pairwise Quality</a>
                            </li>
                            <li>
                                <a href="/ArchDesigner/Main/pairwisealternative.jsp">Pairwise Alternative</a>
                            </li>
                            <li>
                                <a href="/ArchDesigner/Main/scorealternative.jsp">Score Alternative</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="/ArchDesigner/Main/combinationcentric.jsp"><i class="fa fa-table fa-fw"></i> Combination-Centric</a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <!-- /#wrapper -->


<script type="text/javascript">
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

<!-- JQuery Javascript -->
<script src="/ArchDesigner/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core Javascript -->
<script src="/ArchDesigner/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Datatable Javascript -->
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

<!-- Datatable with bootstrap theme Javascript -->
<script src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/ArchDesigner/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="/ArchDesigner/bower_components/raphael/raphael-min.js"></script>
<script src="/ArchDesigner/bower_components/morrisjs/morris.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/ArchDesigner/dist/js/sb-admin-2.js"></script>

</body>
</html>