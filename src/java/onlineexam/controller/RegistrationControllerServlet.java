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
import javax.servlet.http.HttpSession;
import onlineexam.dao.UsersDAO;
import onlineexam.dao.UsersDAOImpl;
import onlineexam.entity.LoginUser;
import onlineexam.entity.Users;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class RegistrationControllerServlet extends HttpServlet {

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
        HttpSession sess=request.getSession();
        Users user=(Users)sess.getAttribute("user");
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        if(user==null)
            {
//                out.println("<script>Sorry You are not logined");
               response.sendRedirect("home.html");
                return;
            }
        else{
        boolean searchResult,registerResult;
        LoginUser newuser=new LoginUser();
        newuser.setUserId(request.getParameter("userid"));
        newuser.setPassword(request.getParameter("password"));
        newuser.setUserType(request.getParameter("usertype"));
        UsersDAO search=new UsersDAOImpl();
        searchResult=search.searchUser(request.getParameter("userid"));
        if(searchResult)
        {
            rd=request.getRequestDispatcher("registrationresponse.jsp");
            request.setAttribute("result", "userfound");
            rd.forward(request, response);   
            return;
        }
        try
        {
          registerResult=search.registerUser(newuser);
          if(registerResult)
          {
          rd=request.getRequestDispatcher("registrationresponse.jsp");
          request.setAttribute("result", "registrationsuccess");
          }
          else
          {
          rd=request.getRequestDispatcher("registrationresponse.jsp");
          request.setAttribute("result", "registrationfailure");
          }
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
