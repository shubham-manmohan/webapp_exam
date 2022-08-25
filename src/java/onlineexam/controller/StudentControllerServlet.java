/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlineexam.dao.PerformanceDAO;
import onlineexam.dao.PerformanceDAOImpl;
import onlineexam.dao.QuestionsDAO;
import onlineexam.dao.QuestionsDAOImpl;
import onlineexam.entity.GetExamId;
import onlineexam.entity.Performance;
import onlineexam.entity.Questions;
import onlineexam.entity.Users;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class StudentControllerServlet extends HttpServlet {

    List<Questions> list=null;
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
//        System.out.println("Running..............");
        
        String examid=request.getParameter("examid");
        if(examid!=null)
        {    
                     if(examid.equalsIgnoreCase("getexamids"))
                        {
                            QuestionsDAO qdo=new QuestionsDAOImpl();
                            ArrayList<GetExamId> examId=qdo.getExamIdForStudent(user.getUserId());
                            JSONObject json=new JSONObject();
                            StringBuffer sb=new StringBuffer();
                            sb.append("<option value=''>Choose Exam</option>");
                            for(GetExamId exam:examId)
                            {
                                    sb.append("<option value='"+exam.getExamId()+"'>["+exam.getExamId()+"],["+exam.getSubjectId()+"]</option>");
                            }
                            System.out.println(sb);
                            json.put("examid", sb.toString());
                            out.println(json);
                         }
                     else
                     {
                         int examId=Integer.parseInt(examid);
                         System.out.println("Exam id from student take test is "+examId);
                         QuestionsDAO qdo=new QuestionsDAOImpl();
                         list=qdo.getQuestionsForStudentByExamId(examId);
                         rd=request.getRequestDispatcher("showquestions.jsp");
                         request.setAttribute("questions", list);
                         rd.forward(request, response);
                         System.out.println("called list initiallizaation "+list);
                     }
        }
        else
        {
        try
        {
            int right=0;
            int wrong=0;
            int unattempted=0;
            int totalMarks=0;
            double marksObtained=0;
            String userId=user.getUserId();
            int examId=Integer.parseInt(request.getParameter("qexamid"));
            String subjectId=request.getParameter("subject");
            String choosenOptions=request.getParameter("choosenoptions");
            JSONArray json=new JSONArray(choosenOptions);
            System.out.println("\n\n\n\n\n\n\nafter response of student");
            list.get(0).toString();
            for(int i=0;i<json.length();i++)
            {
                totalMarks=totalMarks+list.get(i).getMarks();
                    System.out.println("UserId="+userId+"\tExamId="+examId+"\tSubjectId="+subjectId+"\tChoosenOptions="+json.optString(i));
                    if(json.optString(i).equalsIgnoreCase(""))
                    {
                        unattempted=unattempted+1;
                    }
                    else if(list.get(i).getCorrectOption().equalsIgnoreCase(json.optString(i)))
                    {
                        right=right+1;
                        marksObtained=marksObtained+list.get(i).getMarks();
                    }
                    else
                    {
                        wrong=wrong+1;
                    }
            }
            double percentage=(double)(marksObtained/totalMarks)*100;
            Performance pr=new Performance(userId,examId,subjectId,right,wrong,unattempted,marksObtained,percentage,totalMarks);
            System.out.println("\n\n\n\n\nPerformance is "+pr.toString());
            PerformanceDAO pdo=new PerformanceDAOImpl();
            boolean result=pdo.addPerformance(pr);
            if(result)
            {
                out.println("success");
            }
            else
            {
                out.println("failed");
            }
        }
        catch(ParseException pse)
        {
            pse.printStackTrace();
            System.out.println("Exception in parse11111111111111111111111111111111111222222222222222222222");
            rd=request.getRequestDispatcher("showexception.jsp");
          request.setAttribute("exception", pse);
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
