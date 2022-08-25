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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlineexam.dao.QuestionsDAO;
import onlineexam.dao.QuestionsDAOImpl;
import onlineexam.entity.Questions;
import onlineexam.entity.Users;
import org.json.JSONArray;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class QuestionsControllerServlet extends HttpServlet {

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
//        String str=request.getParameter("questionsObject");
//        System.out.println("from questionscontroller "+str);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Users userid=(Users)session.getAttribute("user");
        if(userid==null)
        {
            session.invalidate();
            out.println("Access Denied");
            return;
        }
        String subject=request.getParameter("subject");
        String totalQuestions=request.getParameter("totalquestions");
        String marks=request.getParameter("marks");
         
        RequestDispatcher rd=null;
//        String str=request.getParameter("examid");
//        if(str==null)
//        {
        ArrayList<Questions> questionList=new ArrayList<>();
        try{
             if(subject!=null && totalQuestions!=null && marks!=null)
        {
            System.out.println("exam from questions............................1111111111897674628736487364827468237658768734678");
            ExamControllerClass.getE().setSubjectId(subject);
            ExamControllerClass.getE().setTotalQuestions(Integer.parseInt(totalQuestions));
            ExamControllerClass.getE().setTotalMarks(Integer.parseInt(totalQuestions)*Integer.parseInt(marks));
            ExamControllerClass.setE(ExamControllerClass.getE());
            ExamControllerClass.getExam().setExam(ExamControllerClass.getE());
            out.println("success");
            return;
        }
//        else
//        {
//            out.println("failure");
//            return;
//        }
//         String getstr=request.getReader().readLine();
             String getstr=request.getParameter("allquestionsdata");
            System.out.println("eryiglbghebrguylweogluibvbjsbcberfbrguyvwebuovrybgvg============="+getstr);
            JSONArray obj=new JSONArray(getstr);
            System.out.println("obj="+obj);
            System.out.println("Lenght="+obj.length());
           Questions q;
            for(int i=0;i<obj.length();i++)
           {
               q=new Questions();
               q.setExamId(obj.getJSONObject(i).getInt("examid"));
               q.setSubjectId(obj.getJSONObject(i).getString("subjectid"));
               q.setQuestionNo(obj.getJSONObject(i).getInt("qno"));
               q.setQuestion(obj.getJSONObject(i).getString("question"));
               q.setOption1(obj.getJSONObject(i).getString("option1"));
               q.setOption2(obj.getJSONObject(i).getString("option2"));
               q.setOption3(obj.getJSONObject(i).getString("option3"));
               q.setOption4(obj.getJSONObject(i).getString("option4"));
               q.setCorrectOption(obj.getJSONObject(i).getString("correctoption"));
               q.setMarks(obj.getJSONObject(i).getInt("marks"));
               questionList.add(q);
           }
            for(Questions we:questionList)
            {
                System.out.println(we);
            }
            System.out.println("Size of arraylist ========"+questionList.size());
            QuestionsDAO qobj=new QuestionsDAOImpl();
    
            boolean result=qobj.addQuestionsList(questionList);
            if(result)
            {
                ExamControllerClass.getExam().commitExam();
                out.println("success");
            }
            else
                out.println("failed");
        }
        catch(ParseException pse)
        {
            pse.printStackTrace();
            System.out.println("Exception in parse11111111111111111111111111111111111222222222222222222222");
            rd=request.getRequestDispatcher("showexception.jsp");
          request.setAttribute("exception", pse);
        }
//        }
//       else
//        {
//            out.println("error");
//        }
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
