/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class update extends HttpServlet {

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
            throws ServletException, IOException,SQLException, ClassNotFoundException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>Read & Think");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","");
            Statement st=conn.createStatement();
            String mid;
            String mprice;
            String mtitle;
            String mauth;
            mid=request.getParameter("selbook");
            
            mprice=request.getParameter("mprice");
            mtitle=request.getParameter("mtitle");
            mauth=request.getParameter("mauth");
            String q1="update books set"; 
            if(mid!=null){
              if(!mprice.equals("")){
                  q1+=" mprice="+mprice+",";
              }
              if(!mtitle.equals("")){
                 q1+=" mtitle='"+mtitle+"',"; 
              }
              if(!mauth.equals("")){
                 q1+=" mauth='"+mauth+"',";
              }
              q1=q1.substring(0,q1.length()-1);
              q1+=" where mtitle='"+mid+"'";
              int i=st.executeUpdate(q1);
              if (i>0){
                   
                   out.println("<h1>"+i+" Your Details are Updated</h1>");
              }
              else
               out.println("<h1>Your Details are not Updated</h1>");
     
            
            }else{
               out.println("<h1>ID:"+mid+"</h1>");
            }
            out.println("<a href=\"index.html\">Back to Home</a>");
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        
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
