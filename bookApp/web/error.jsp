<%-- 
    Document   : error
    Created on : 22 Sep, 2017, 3:27:08 PM
    Author     : mca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%@page isErrorPage="true" %>
        <h2> Sorry An error</h2>
        Exception is:<%=exception%>
    </body>
</html>
