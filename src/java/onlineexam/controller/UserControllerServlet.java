/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UserControllerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sess=request.getSession();
        Users user=(Users)sess.getAttribute("user");
        System.out.println("User details from UserController="+user.toString());
        if(user==null)
        {
            response.sendRedirect("accessdenied.html");
            return;
        }
        String cpwd=request.getParameter("currentpassword");
        String newpwd=request.getParameter("newpassword");
        if(cpwd!=null && newpwd!=null)
        {
            System.out.println("cpwd="+cpwd+"\tuserpwd="+user.getPassword()+"\tnewpwd="+newpwd);
            if(!user.getPassword().equals(cpwd))
            {
                System.out.println("RUnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
                out.println("currentpassworderror");
                return;
            }
            LoginUser update=new LoginUser(user.getUserId(),newpwd,user.getUserType());
            UsersDAO udo=new UsersDAOImpl();
            if(udo.changePassword(update))
                out.println("success");
            else
                out.println("failed");
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
