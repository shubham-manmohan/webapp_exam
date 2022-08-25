<%-- 
    Document   : loginresponse
    Created on : 11 May, 2021, 10:46:19 PM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users" pageEncoding="UTF-8"%>
<%
    Users user=(Users)request.getAttribute("result");
    String fromlcs=(String)request.getAttribute("fromlcs");
    if(user!=null)
    {
        HttpSession sess=request.getSession();
        if(user.getUserType().equalsIgnoreCase("faculty"))
        {
             sess.setAttribute("user", user);
            String url="FacultyControllerServlet;jsessionid="+sess.getId();
            out.println(url);
        }
        else if(user.getUserType().equalsIgnoreCase("student"))
        {
            sess.setAttribute("user", user);
            String url="studentoptions.jsp;jsessionid="+sess.getId();
            out.println(url);   
        }
    }
    else if(user==null&&fromlcs!=null)
    {
            out.println("error");
    }
    else
    {
        out.println("<html><head><script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script></head><body><script>swal('error','you are not logged in....','error');setTimeout(function (){window.location='home.html'},5000)</script></body></html>");
    }
    %>