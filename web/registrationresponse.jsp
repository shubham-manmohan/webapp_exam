<%-- 
    Document   : registrationresponse
    Created on : 13 May, 2021, 3:58:21 PM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users" pageEncoding="UTF-8"%>
<%
    HttpSession sess=request.getSession();
        Users user=(Users)sess.getAttribute("user");
        if(user==null)
        {
            out.println("<html><head><script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script></head><body><script>swal('error','you are not logged in....redirecting to home page','error');setTimeout(function (){window.location='home.html'},5000)</script></body></html>");
        }
        else
        {
            String str=(String)request.getAttribute("result");
           if(str!=null)
           {
            if(str.equalsIgnoreCase("userfound"))
            {
                out.println("uap");
            }
            else if(str.equalsIgnoreCase("registrationsuccess"))
            {
                out.println("success");
            }
            else
            {
                out.println("failure");
            }
           }
           else
           {
//               out.println("<h3 style='color:red'>Please take action on register student</h3>");
               response.sendRedirect("facultyoptions.jsp");
           }
        }
    
    %>
