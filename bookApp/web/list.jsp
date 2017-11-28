<%--
    Document   : list
    Created on : 15 Sep, 2017, 2:34:33 PM
    Author     : mca
--%>
<%@page import="java.util.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" java.io.*"%>
<%@page import="java.sql.*"%> 
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
            String s;
            s=request.getParameter("mstar");
            String q="select * from movies where mstar='"+s+"'";
            ResultSet rs=st.executeQuery(q);
            out.println("Id  Title     Type      Star      Price");
            out.println("<br>");
            while(rs.next())
            {
            int mid = rs.getInt("mid");
            String mtitle=rs.getString("mtitle");
            String mtype =rs.getString("mtype");
            String mstar=rs.getString("mstar");  
            int mprice=rs.getInt("mprice");
            
            out.println(mid+"   "+mtitle+"    "+mtype+"    "+mstar+"      "+mprice);
            out.println("<br>");  
            }
            %>
            
    </body>
</html>
