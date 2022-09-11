<%-- 
    Document   : performance
    Created on : 8 Jun, 2021, 9:21:25 PM
    Author     : SHUBHAM MANMOHAN
--%>

<%@page contentType="text/html" import="onlineexam.entity.Users" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Page</title>
<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>-->
        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>
    <script type="text/javascript" src="jsscript/mysweetalert.js"></script>
    </head>
    <body>
        <%
            HttpSession sess=request.getSession();
            Users user=(Users)sess.getAttribute("user");
            if(user==null || user.getUserType().equalsIgnoreCase("faculty"))
            {
             StringBuffer sb=new StringBuffer("");
             sb.append("<div class='container mt-3'>"+
                            " <div class='modal fade' id='errorModal' data-backdrop='static'>"+
                            " <div class='modal-dialog'>"+
                            "<div class='modal-content'>"+
                            " <div class='modal-header'>"+
                            " <h4 class='modal-title text-danger'>Error</h4>"+
                            "</div> <div class='modal-body'>"+"Sorry You are not logged in.....\n\n </div><div class='modal-footer'>"+
                            "<button type='button' class='btn btn-info' ><a href='home.html' style='color:white;text-decoration:none'>go to login page</a></button></div>"+
                            "</div> </div></div></div>");
             sb.append("<script>$('#errorModal').modal('toggle');"+"$('[data-toggle="+"\"tooltip\""+"]').tooltip()"+"</script>");
             sess.invalidate();
             out.println(sb);
             return;
            }
            
        %>    
        <table id="performance" class="nowrap table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Exam ID</th>
                <th>Subject</th>
                <th>Right</th>
                <th>Wrong</th>
                <th>Unattempted</th>
                <th>Marks Obtained</th>
                <th>Percentage</th>
                <th>Total Marks</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
        <script>
            $(document).ready(function() {
                $("tbody").html("");
                $.ajax({
                    url: "PerformanceControllerServlet",
                    method: "POST",
                    success: function(resp) {
                        console.log(resp);
                        if(resp.trim()==="norecordfound")
                        {
                            console.log("if runned")
                            swal("No Record Found","You haven't attended any exam yet..........","info");
                            setTimeout(function(){window.location="studentoptions.jsp";},3000);
                            return;
                        }
                        var score=JSON.parse(resp);
                        var i;
                        for (i = 0; i < score.length; i++) {
                            $("tbody").append("<tr><td>"+score[i].userid+"</td><td>" + score[i].examid + "</td><td>" + score[i].subject + " </td><td>"+score[i].right+"</td><td>"+score[i].wrong+"</td><td>"+score[i].unattempted+"</td><td>"+score[i].marksobtained+"</td><td>"+score[i].percentage+" %</td><td>"+score[i].totalmarks+"</td></tr>");
                        }
                        $('#performance').DataTable({
                            dom: 'Bfrtip',
                            buttons: [
                                'copy', 'csv', 'excel', 'pdf', 'print'
                            ]
                        });
                    }
                });
            });
         </script>
    </body>
</html>
