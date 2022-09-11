<%-- 
    Document   : studentoptions
    Created on : 6 Jun, 2021, 12:07:53 AM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Options Page</title>
         <link rel="stylesheet" href="stylesheet/backgroundimage.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!--<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>-->
        <script type="text/javascript" src="jsscript/mysweetalert.js"></script>
        <link rel="stylesheet" href="stylesheet/mycss/facultyoptions.css">
        <script type="text/javascript" src="jsscript/studentoptions.js"></script>
    </head>
    <body>
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
                            " <h4 class='modal-title' style='color:red;'>Error</h4>"+
                            "</div> <div class='modal-body'>"+"Sorry You are not logged in.....\n\n </div><div class='modal-footer'>"+
                            "<button type='button' class='btn btn-info' ><a href='home.html' style='color:white;text-decoration:none'>go to login page</a></button></div>"+
                            "</div> </div></div></div>");
             sb.append("<script>$('#errorModal').modal('toggle');"+"$('[data-toggle="+"\"tooltip\""+"]').tooltip()"+"</script>");
             sess.invalidate();
             out.println(sb);
            }
            else
            {
                StringBuffer sb=new StringBuffer("");
                sb.append("<div class='media navbar-nav align-items-center  d-md-flex'><img class='avatar avatar-sm rounded-circle avatar-img' alt='User Profile' src='images/profile.jpg'><h3 class='mt-3 text-sm  font-weight-bold text-white'>Shubham Manmohan</h3></div>");
                sb.append("<div class='container'>");
                sb.append("<button type='button' class='btn btn-info btn-block btn-lg mybtn' onclick='takeTestModal()'><span>Take Test</span></button>");
                sb.append("<button type='button' class='btn btn-secondary btn-block btn-lg mybtn' onclick='viewScore()'><span>View Score</span></button>");
                sb.append("<button type='button' class='btn btn-warning btn-block btn-lg mybtn' onclick='changePasswordModal()'><span>Change Password</span></button>");
               sb.append("<button type='button' class='btn btn-danger btn-block btn-lg mybtn' onclick='logout()'><span>Logout</span></button><br>");
                sb.append("</div>");
                out.println(sb);
            }
            %>
    </body>
</html>
