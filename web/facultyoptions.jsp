<%-- 
    Document   : facultyoptions
    Created on : 13 May, 2021, 10:55:55 AM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Options Page</title>
        <link rel="stylesheet" href="stylesheet/backgroundimage.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!--<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>-->
        <script type="text/javascript" src="jsscript/facultyoptions.js"></script>
        <script type="text/javascript" src="jsscript/facultyaction.js"></script>
        <script type="text/javascript" src="jsscript/mysweetalert.js"></script>
        <link rel="stylesheet" href="stylesheet/mycss/facultyoptions.css">
        <link rel="stylesheet" href="stylesheet/mycss/setquestions.css">
        <style>
        div textarea {
            padding: 0.5% !important;
            resize: none;
            overflow: auto;
        }
        </style>
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
                            " <h4 class='modal-title'>Error</h4>"+
                            "</div> <div class='modal-body'>"+"Sorry You are not logged in.....\n\n </div><div class='modal-footer'>"+
                            "<button type='button' class='btn btn-info' ><a href='home.html' style='color:white;text-decoration:none'>go to login page</a></button></div>"+
                            "</div> </div></div></div>");
             sb.append("<script>$('#errorModal').modal('toggle');"+"$('[data-toggle="+"\"tooltip\""+"]').tooltip()"+"</script>");
             sess.invalidate();
             out.println(sb);
            }
            else
            {
                StringBuffer sb=new StringBuffer("<h3 style='color:#eb5a05'>Welcome User: "+user.getUserId()+"</h3>");
                sb.append("<div class='container'>");
                sb.append("<button type='button' class='btn btn-info btn-block btn-lg mybtn' onclick='setPaperModal()'><span>Set Paper</span></button>");
                sb.append("<button type='button' class='btn btn-secondary btn-block btn-lg mybtn' onclick='editPaperModal()'><span>Edit Paper</span></button>");
                sb.append("<button type='button' class='btn btn-warning btn-block btn-lg mybtn' onclick='registerUserModal()'><span>Register User</span></button>");
                sb.append("<button type='button' class='btn btn-primary btn-block btn-lg mybtn' onclick='viewScores()'><span>View Scores</span></button>");
                sb.append("<button type='button' class='btn btn-dark btn-block btn-lg mybtn' onclick='removeUserModal()'><span>Remove User</span></button>");
                sb.append("<button type='button' class='btn btn-danger btn-block btn-lg mybtn' onclick='logout()'><span>Logout</span></button><br>");
                sb.append("</div>");
                out.println(sb);
            }
         %>

    </body>
</html>
