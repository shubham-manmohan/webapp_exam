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
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlineexam.dao.QuestionsDAO;
import onlineexam.dao.QuestionsDAOImpl;
import onlineexam.entity.GetExamId;
import onlineexam.entity.Questions;
import onlineexam.entity.Users;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class EditQuestionsControllerServlet extends HttpServlet {

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
        RequestDispatcher rd;
        PrintWriter out = response.getWriter();
         HttpSession sess=request.getSession();
        Users user=(Users)sess.getAttribute("user");
        if(user==null)
            {
//                out.println("Sorry You are not logined");
                response.sendRedirect("home.html");
                return;
            }
        String str=request.getParameter("examid");
        String selectedexamid=request.getParameter("selectedexamid");
         if(str!=null && str.equalsIgnoreCase("getexamids"))
        {
            QuestionsDAO qdo=new QuestionsDAOImpl();
            List<GetExamId> list=qdo.getAllExamId();
            Iterator<GetExamId> it=list.iterator();
            JSONObject json=new JSONObject();
            StringBuffer sb=new StringBuffer();
            sb.append("<option value=''>[Select Exam ID]</option>");
            while(it.hasNext())
            {
                GetExamId id=it.next();
                sb.append("<option value='"+id.getExamId()+"'>["+id.getExamId()+"],["+id.getSubjectId()+"]</option>");
            }
            json.put("examid", sb.toString());
            System.out.println("exam id's data from database"+sb.toString());
            out.println(json);
        }
         else if(selectedexamid!=null)
         {
             int examid=Integer.parseInt(selectedexamid);
             System.out.println("This is from EditQuestionsControllerServlet data from browser is = "+examid);
             QuestionsDAO qdo=new QuestionsDAOImpl();
             List<Questions> allQuestions=qdo.getQuestionsByExam(examid);
             rd=request.getRequestDispatcher("editquestions.jsp");
             request.setAttribute("editquestionsdata", allQuestions);
             rd.forward(request, response);
             return;
         }
         else
         {
              String getstr=request.getParameter("allquestionsdata");
            System.out.println("eryiglbghebrguylweogluibvbjsbcberfbrguyvwebuovrybgvg============="+getstr);
            try{
            JSONArray obj=new JSONArray(getstr);
            System.out.println("obj="+obj);
            System.out.println("Lenght="+obj.length());
            List<Questions> questionList=new ArrayList<>();
           Questions q;
            for(int i=0;i<obj.length();i++)
           {
               q=new Questions();
               q.setExamId(obj.getJSONObject(i).getInt("examid"));
               q.setSubjectId(obj.getJSONObject(i).getString("subject"));
               q.setQuestionNo(obj.getJSONObject(i).getInt("qno"));
               q.setQuestion(obj.getJSONObject(i).getString("question"));
               q.setOption1(obj.getJSONObject(i).getString("option1"));
               q.setOption2(obj.getJSONObject(i).getString("option2"));
               q.setOption3(obj.getJSONObject(i).getString("option3"));
               q.setOption4(obj.getJSONObject(i).getString("option4"));
               q.setCorrectOption(obj.getJSONObject(i).getString("correctoption"));
               q.setMarks(obj.getJSONObject(i).getInt("marks"));
               q.setSno(obj.getJSONObject(i).getInt("sno"));
               questionList.add(q);
           }
            for(Questions we:questionList)
            {
                System.out.println(we);
            }
            System.out.println("Size of arraylist ========"+questionList.size());
            QuestionsDAO qobj=new QuestionsDAOImpl();
            boolean result=qobj.updateQuestions(questionList);
            if(result)
            {
                out.println("success");
            }
            }
            catch(ParseException ex)
            {
                ex.printStackTrace();
                 System.out.println("Exception in parse11111111111111111111111111111111111222222222222222222222");
            rd=request.getRequestDispatcher("showexception.jsp");
          request.setAttribute("exception", ex);
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
