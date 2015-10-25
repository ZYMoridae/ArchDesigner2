<!doctype html>
<html>
    <head>
        <title>Page Not Found</title>
        %{--<meta name="layout" content="main">--}%
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>

        <asset:stylesheet src="animate.css"/>
    </head>
    <body>
        <div class="container animated fadeIn">
            <div class="row">
                <div class="col-md-12" style="text-align: center;vertical-align: middle;height: 200px;margin-top: 5%;">
                    <h1 style="font-size: 120px;font-weight: 100;">OoPs!</h1>
                    <h3 style="font-size: 50px;margin-top: 5%;font-weight: 100;">Page Not Found</h3>
                    <a href="/">Back to ArchDesigner</a>
                </div>
            </div>
        </div>
        %{--<ul class="errors">--}%
            %{--<li>Error: Page Not Found (404)</li>--}%
            %{--<li>Path: ${request.forwardURI}</li>--}%
        %{--</ul>--}%
    </body>
</html>
