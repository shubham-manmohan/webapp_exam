package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import onlineexam.entity.Users;

public final class facultyoptions_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Faculty Options Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"stylesheet/backgroundimage.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"jsscript/facultyoptions.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"jsscript/facultyaction.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"stylesheet/mycss/facultyoptions.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession sess=request.getSession();
            Users user=(Users)sess.getAttribute("user");
            if(user==null)
            {
             StringBuffer sb=new StringBuffer("");
             sb.append("<div class='container mt-3'>"+
                            " <div class='modal fade' id='errorModal'>"+
                            " <div class='modal-dialog'>"+
                            "<div class='modal-content'>"+
                            " <div class='modal-header'>"+
                            " <h4 class='modal-title'>Error</h4>"+
                            "<button type='button' class='close' data-dismiss='modal'>×</button>"+
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
                sb.append("<div class='container modal-header'>");
                sb.append("<button type='button' class='btn btn-info' ><a href='#' onclick='setPaperModal()'>Set Paper</a></button><br>");
                sb.append("<button type='button' class='btn btn-success' ><a href='#' onclick='editPaperModal()'>Edit Paper</a></button><br>");
                sb.append("<button type='button' class='btn btn-warning' ><a href='#'  onclick='registerUserModal()'>Register User</a></button><br>");
                sb.append("<button type='button' class='btn btn-danger' ><a href='#'  onclick='viewScoresModal()'>View Scores</a></button><br>");
                sb.append("</div>");
                out.println(sb);
            }
         
      out.write("\n");
      out.write("       <div class=\"modal fade\" id=\"registerUserModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header border-bottom-0\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                  </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-title text-center\">\n");
      out.write("                        <h4>Register User</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-flex flex-column text-center\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userid\" placeholder=\"Enter user id...\" maxlength=\"12\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"cpassword\" placeholder=\"Confirm password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                               <label for=\"usertype\">Select User Type:</label>\n");
      out.write("                                    <input list=\"usertypelists\" name=\"usertype\" id=\"usertype\">\n");
      out.write("                                    <datalist id=\"usertypelists\">\n");
      out.write("                                    <option value=\"faculty\">\n");
      out.write("                                    <option value=\"student\">\n");
      out.write("                                    </datalist>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-info btn-block btn-round\" onclick=\"registerUser()\">Register</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       </div>\n");
      out.write("       <div class=\"modal fade\" id=\"setPaperModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header border-bottom-0\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                  </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-title text-center\">\n");
      out.write("                        <h4>Set Paper</h4>\n");
      out.write("                    </div>\n");
      out.write("<!--                    <div class=\"d-flex flex-column text-center\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userid\" placeholder=\"Enter user id...\" maxlength=\"12\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password1\" placeholder=\"Enter password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password2\" placeholder=\"Confirm password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                               <label for=\"usertype\">Select User Type:</label>\n");
      out.write("                                    <input list=\"usertypelists\" name=\"usertype\" id=\"usertype\">\n");
      out.write("                                    <datalist id=\"usertypelists\">\n");
      out.write("                                    <option value=\"Faculty\">\n");
      out.write("                                    <option value=\"Student\">\n");
      out.write("                                    </datalist>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-info btn-block btn-round\">Register</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       </div>\n");
      out.write("       <div class=\"modal fade\" id=\"editPaperModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header border-bottom-0\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                  </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-title text-center\">\n");
      out.write("                        <h4>Edit paper</h4>\n");
      out.write("                    </div>\n");
      out.write("<!--                    <div class=\"d-flex flex-column text-center\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userid\" placeholder=\"Enter user id...\" maxlength=\"12\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password1\" placeholder=\"Enter password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password2\" placeholder=\"Confirm password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                               <label for=\"usertype\">Select User Type:</label>\n");
      out.write("                                    <input list=\"usertypelists\" name=\"usertype\" id=\"usertype\">\n");
      out.write("                                    <datalist id=\"usertypelists\">\n");
      out.write("                                    <option value=\"Faculty\">\n");
      out.write("                                    <option value=\"Student\">\n");
      out.write("                                    </datalist>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-info btn-block btn-round\">Register</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       </div>\n");
      out.write("       <div class=\"modal fade\" id=\"viewScoresModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header border-bottom-0\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                  </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"form-title text-center\">\n");
      out.write("                        <h4>View Scores</h4>\n");
      out.write("                    </div>\n");
      out.write("<!--                    <div class=\"d-flex flex-column text-center\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userid\" placeholder=\"Enter user id...\" maxlength=\"12\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password1\" placeholder=\"Enter password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password2\" placeholder=\"Confirm password....\" maxlength=\"15\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                               <label for=\"usertype\">Select User Type:</label>\n");
      out.write("                                    <input list=\"usertypelists\" name=\"usertype\" id=\"usertype\">\n");
      out.write("                                    <datalist id=\"usertypelists\">\n");
      out.write("                                    <option value=\"Faculty\">\n");
      out.write("                                    <option value=\"Student\">\n");
      out.write("                                    </datalist>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-info btn-block btn-round\">Register</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
