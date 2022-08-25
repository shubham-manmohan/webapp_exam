<%-- 
    Document   : showquestions
    Created on : 7 Jun, 2021, 2:52:16 PM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users,java.util.List,onlineexam.entity.Questions,org.json.JSONObject,org.json.JSONArray" pageEncoding="UTF-8"%>
<%
     HttpSession sess=request.getSession();
            Users user=(Users)sess.getAttribute("user");
            if(user==null)
            {
             StringBuffer sb=new StringBuffer("");
             sb.append("<div class='container mt-3'>"+
                            " <div class='modal fade' id='errorModal' data-backdrop='static'>"+
                            " <div class='modal-dialog'>"+
                            "<div class='modal-content'>"+
                            " <div class='modal-header'>"+
                            " <h4 class='modal-title text-danger'>Error</h4>"+
                            "</div> <div class='modal-body'>"+"Sorry You are not logged in.....\n\n </div><div class='modal-footer'>"+
                            "<button type='button' class='btn btn-info' ><a class='text-decoration-none text-white' href='home.html'>go to login page</a></button></div>"+
                            "</div> </div></div></div>");
             sb.append("<script>$('#errorModal').modal('toggle');"+"$('[data-toggle="+"\"tooltip\""+"]').tooltip()"+"</script>");
             sess.invalidate();
             out.println(sb);
             return;
            }
            else
            {
                List<Questions> editQuestionsList=(List<Questions>)request.getAttribute("questions");
                if(editQuestionsList!=null){
                StringBuffer sb=new StringBuffer();
                
                JSONObject json;
                JSONArray jsonarr=new JSONArray();
                int i=0;
                for(Questions q:editQuestionsList)
                {
                    json=new JSONObject();
                    json.put("qno",q.getQuestionNo());
                    json.put("question", q.getQuestion());
                    json.put("option1", q.getOption1());
                    json.put("option2", q.getOption2());
                    json.put("option3", q.getOption3());
                    json.put("option4", q.getOption4());
                    json.put("examid", q.getExamId());
                    json.put("subject", q.getSubjectId());
                    jsonarr.put(i,json);
                    i++;
                }
                System.out.println(jsonarr.toString());
                out.println(jsonarr.toString());
                }
                else
                {
             out.println("<h3 style='color:red'>Error You are not select any paper to edit</h3><a href='facultyoptions.jsp'>go to options page</a>");
                }
            }
%>    
