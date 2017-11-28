/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mca
 */
public class list extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>list</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Read and Think</h1><center>");
           
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
         Statement st=conn.createStatement();
         String q="select * from books";
         ResultSet rs=st.executeQuery(q);
        out.println("<h1><center><u>Books Details</u></h1><br><br><br></center>");
        out.println("<center><table border=5><h2><tr><th>Id</th><th>Title</th><th>Type</th><th>Author</th><th>Price</th></tr></h2></center>");        
        while(rs.next())
        {
            int mid = rs.getInt("mid");
            String mtitle=rs.getString("mtitle");
            String mtype =rs.getString("mtype");
            String mauth=rs.getString("mauth");  
            int mprice=rs.getInt("mprice");
            out.println("<tr><td>"+mid+"</td><td>"+mtitle+"</td><td>"+mtype+"</td><td>"+mauth+"</td><td>"+mprice+"</td></tr>");
        }
//        out.println("<br>");
            out.println("</table>");
            out.println("<a href=\"index.html\">Back to Home</a></center>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);
        }catch(SQLException e){
        }catch(ClassNotFoundException e1){}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try{
        processRequest(request, response);
        }catch(SQLException e){
        }catch(ClassNotFoundException e1){}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
