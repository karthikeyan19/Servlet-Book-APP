<%-- 
    Document   : view
    Created on : 20 Sep, 2017, 10:10:12 AM
    Author     : mca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" java.io.*"%>
<%@page import="java.sql.*"%> 
<%@page import="java.util.*" %> 
<%@page errorPage="error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","");
        Statement st=conn.createStatement();
        String q="select * from movies";
        ResultSet rs=st.executeQuery(q);
        out.println("<h1><center><u>Current Movies Details</u></h1><br><br><br></center>");
        out.println("<center><table border=5><h2><tr><th>Id</th><th>Title</th><th>Type</th><th>Star</th><th>Price</th></tr></h2></center>");        
        while(rs.next())
{
int mid = rs.getInt("mid");
String mtitle=rs.getString("mtitle");
String mtype =rs.getString("mtype");
String mstar=rs.getString("mstar");  
int mprice=rs.getInt("mprice");
out.println("<tr><td>"+mid+"</td><td>"+mtitle+"</td><td>"+mtype+"</td><td>"+mstar+"</td><td>"+mprice+"</td></tr>");
}
//        out.println("<br>");
out.println("</table>");

%>
    </body>
</html>
