/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import onlineexam.dao.ExamDAO;
import onlineexam.dao.ExamDAOImpl;
import onlineexam.entity.Exam;
import onlineexam.entity.Subjects;
import org.json.JSONObject;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class ExamControllerServlet extends HttpServlet {
//    private static Exam e=null;
//    private static ExamDAO exam=null;
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
        RequestDispatcher rd=null;
        String str=request.getParameter("examid");
//        String subject=request.getParameter("subject");
//        String totalQuestions=request.getParameter("totalquestions");
//        String marks=request.getParameter("marks");
        
        if(str!=null&&str.equalsIgnoreCase("getexamid"))
        {
            ExamDAO exam=new ExamDAOImpl();
        ExamControllerClass.setExam(exam);
        Exam e=ExamControllerClass.getE();
            try{
//            e=exam.getExamDetails();
            e=ExamControllerClass.getExam().getExamDetails();
            ExamControllerClass.setE(e);
            if(e!=null){
            JSONObject json=new JSONObject();
            
            json.put("newexamid",e.getExamId());
            ArrayList<Subjects> subjectList=exam.getSubjectDetails();
            StringBuffer sb=new StringBuffer();
            for(Subjects s:subjectList)
            {
                sb.append("<option value='"+s.getSubjectId()+"'>["+s.getSubjectId()+"]"+s.getSubjectName()+"</option>");
            }
            System.out.println(sb);
            json.put("subjects", sb.toString());
            out.println(json);
            }
            else
            {
                out.println("failure");
            }
            }
            catch(Exception ex)
            {
                 ex.printStackTrace();
            rd=request.getRequestDispatcher("showexception.jsp");
          request.setAttribute("exception", ex);
           rd.forward(request, response);
            }
        }
        else{
       
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
