 <%-- 
    Document   : Index
    Created on : 07/01/2023, 15:26:22
    Author     : adplascencia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%out.println("Mi usuario " + request.getParameter("user"));%>
    </body>
</html>

