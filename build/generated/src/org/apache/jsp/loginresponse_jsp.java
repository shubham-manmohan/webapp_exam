package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import onlineexam.entity.Users;

public final class loginresponse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            String url="StudentControllerServlet;jsessionid="+sess.getId();
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
