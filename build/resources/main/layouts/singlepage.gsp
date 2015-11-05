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
    %{--<link rel="stylesheet" href="/GrailsArchDesigner-0.1/assets/bootstrap.min.css">--}%
    <link  rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/bootstrap.min.css" />
    %{--<asset:stylesheet src="bootstrap.min.css"/>--}%

    <!-- Data tables with bootstrap theme  -->
    <link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css">

    <!-- MetisMenu CSS -->
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/metisMenu.min.css" />
    %{--<asset:stylesheet src="metisMenu.min.css"/>--}%

    <!-- Timeline CSS -->
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/timeline.css" />
    %{--<asset:stylesheet src="timeline.css"/>--}%

    <!-- Custom CSS -->
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/sb-admin-2.css" />
    %{--<asset:stylesheet src="sb-admin-2.css"/>--}%

    %{-- Animate CSS --}%
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/animate.css" />
    %{--<asset:stylesheet src="animate.css"/>--}%

    <!-- Morris Charts CSS -->
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/morris.css" />
    %{--<asset:stylesheet src="morris.css"/>--}%

    <!-- Custom Fonts -->
    <link  rel="stylesheet" type="text/css" href="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/stylesheets/font-awesome.min.css" />
    %{--<asset:stylesheet src="font-awesome.min.css"/>--}%

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
<script src="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/javascripts/jquery.min.js"></script>
%{--<asset:javascript src="jquery.min.js"/>--}%

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<!-- Datatable Javascript -->
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

<!-- Datatable with bootstrap theme Javascript -->
<script src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/javascripts/metisMenu.min.js"></script>
%{--<asset:javascript src="metisMenu.min.js"/>--}%

<!-- Morris Charts JavaScript -->
<script src="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/javascripts/raphael-min.js"></script>
<script src="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/javascripts/morris.min.js"></script>
%{--<asset:javascript src="raphael-min.js"/>--}%
%{--<asset:javascript src="morris.min.js"/>--}%

<!-- Custom Theme JavaScript -->
<script src="https://rawgit.com/ZYMoridae/ArchDesigner2/master/grails-app/assets/javascripts/sb-admin-2.js"></script>
%{--<asset:javascript src="sb-admin-2.js"/>--}%


<script type="text/javascript">
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>


</body>
</html>