<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 17/09/15
  Time: 1:15 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
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
    </style>

    <g:layoutHead/>
</head>

<body>


<g:layoutBody/>

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


<script type="text/javascript">
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>


</body>
</html>