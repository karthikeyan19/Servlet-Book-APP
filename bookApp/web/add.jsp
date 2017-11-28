<%-- 
    Document   : add
    Created on : 15 Sep, 2017, 2:22:19 PM
    Author     : mca
--%>
<%@page import="java.util.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" java.io.*"%>
<%@page import="java.sql.*"%> 
<%@page import=" java.util.Scanner"%>
<%@page errorPage="error.jsp" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Details</title>
    </head>
    <body>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","");
            Statement st=conn.createStatement();
            int mid;
            double mprice;
            String mtitle;
            String mstar;
            String mtype;
            String b=request.getParameter("mtitle");
            String c=request.getParameter("mtype");
            String d=request.getParameter("mauth");
            double e=Double.parseDouble(request.getParameter("mprice"));
            String q="Insert into movies value('"+b+"','"+c+"','"+d+"',"+e+")";
            int i=st.executeUpdate(q);
            if (i>0)
            out.println(i+" Your Details is successfully added ");
            else
            out.println("Your Details is not added");
                      
        %>
       
    </body>
</html>
