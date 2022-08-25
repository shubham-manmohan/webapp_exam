/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlineexam.dao.PerformanceDAO;
import onlineexam.dao.PerformanceDAOImpl;
import onlineexam.entity.Performance;
import onlineexam.entity.Users;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class PerformanceControllerServlet extends HttpServlet {

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
       PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=null;
        HttpSession sess=request.getSession();
        Users user=(Users)sess.getAttribute("user");
        if(user==null)
        {
            response.sendRedirect("accessdenied.html");
            return;
        }
        String str=request.getParameter("allscores");
        PerformanceDAO pdo=new PerformanceDAOImpl();
        List<Performance> list=null;
        if(str==null){
        list=pdo.getPerformance(user.getUserId());
        if(list.isEmpty())
        {
            System.out.println("List is empty "+list);
            out.println("norecordfound");
            return;
        }
        }
        else
        {
            list=pdo.getAllPerformance();
            if(list.isEmpty())
        {
            System.out.println("List is empty "+list);
            out.println("norecordfound");
            return;
        }
        }
        JSONObject json;
        JSONArray jsonarr=new JSONArray();
        int i=0;
        for(Performance prf:list)
        {
            json=new JSONObject();
            json.put("userid", prf.getUserId());
            json.put("examid", prf.getExamId());
            json.put("subject", prf.getSubjectId());
            json.put("right", prf.getRight());
            json.put("wrong", prf.getWrong());
            json.put("unattempted", prf.getUnattempted());
            json.put("marksobtained", prf.getMarksObtained());
            json.put("percentage", prf.getPercentage());
            json.put("totalmarks", prf.getTotalMarks());
            jsonarr.put(i,json);
            i++;
        }
        System.out.println(jsonarr.toString());
        out.println(jsonarr.toString());
        
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
