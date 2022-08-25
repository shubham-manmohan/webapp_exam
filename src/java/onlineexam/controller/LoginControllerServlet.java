/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import onlineexam.dao.UsersDAO;
import onlineexam.dao.UsersDAOImpl;
import onlineexam.entity.LoginUser;
import onlineexam.entity.Users;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class LoginControllerServlet extends HttpServlet {

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
            throws ServletException, IOException {
       RequestDispatcher rd=null;
       String userId=request.getParameter("userid");
       String password=request.getParameter("password");
       String userType=request.getParameter("usertype");
       LoginUser user=new LoginUser(userId,password,userType);
       try
       {
              UsersDAO dao=new UsersDAOImpl();
              Users result=dao.validateUser(user);
              request.setAttribute("result",result);
              request.setAttribute("fromlcs", "fromlcs");
              rd=request.getRequestDispatcher("loginresponse.jsp");
           
       }
       catch(Exception ex)
       {
              ex.printStackTrace();
              rd=request.getRequestDispatcher("showexception.jsp");
              request.setAttribute("exception", ex);
       }
       finally
       {
           rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
