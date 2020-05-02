<%-- 
    Document   : layout
    Created on : 2/05/2020, 05:25:07 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@tag description="Common layout" pageEncoding="UTF-8"%>

<%@attribute name="title" required="true"
             description="The current page title"%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Biblioteca Digital | ${title}</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-primary">
            <span class="navbar-brand mb-0 h1"> ${title} </span>
        </nav>

        <main class="container pt-2">
            <jsp:doBody />
        </main>
    </body>
</html>