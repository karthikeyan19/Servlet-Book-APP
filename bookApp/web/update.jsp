<%-- 
    Document   : update
    Created on : 15 Sep, 2017, 2:34:45 PM
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
        <form method="post" action="update">
        <center>
        <h1>Update the Details</h1>
        Select Book to Update :<select name="selbook">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
            Statement st=conn.createStatement();
            String q="select * from books";
            ResultSet rs=st.executeQuery(q);
            
            while(rs.next()){
            %>   
            <option><%=rs.getString("mtitle")%></option>    
            <%
              }
            conn.close();
            %>         
        </select>
<!--        Enter Book Id:    <input type="number" name="mid"><br><br>-->
            
            <h2>Enter the new title:<input type="text" name="mtitle"><input type="submit" value="update Title"><br><br>
            Enter the new author:<input type="text" name="mauth"><input type="submit" value="update Star"><br><br>
            Enter the new Price:<input type="number" name="mprice"><input type="submit" value="update Price"><br><br>
            <input type="submit" value="UpdateAll"></h2>
    </center>
         </form>
            
    </body>
</html>
