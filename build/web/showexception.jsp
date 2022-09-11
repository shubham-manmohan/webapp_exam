<%-- 
    Document   : showexception
    Created on : 11 May, 2021, 11:24:14 PM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
     Exception ex=(Exception)request.getAttribute("exception");
     if(ex!=null)
     {
    System.out.println("Exception is"+ex);
    out.println("some error occured"+ex.getMessage());
     }
     else
     {
         out.println("<h4 style='color:red'>Sorry you cannot access this page.........</h4><a href='home.html'>go to home page</a>");
     }
    %>
