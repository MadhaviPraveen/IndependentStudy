package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("    <title>Insert title here</title>\n");
      out.write("    <link href= \"styles.css\" rel=\"stylesheet\" type =\"text/css\">\n");
      out.write("<h1> Registration page</h1>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <form method=\"POST\" action=\"/IndStudy/RegistrationController\">\t\n");
      out.write("        <label for=\"cwid\">CWID</label> <input type=\"text\" name=\"cwid\" id=\"cwid\" autofocus required><br>\t\n");
      out.write("\t<label for=\"fname\">First Name</label><input type=\"text\" name=\"firstName\" id=\"firstName\"autofocus required><br>\n");
      out.write("\t<label for=\"lname\">Last Name</label><input type=\"text\" name=\"lastName\" id=\"lastName\"autofocus required><br>\n");
      out.write("\t<label for=\"uname\">User Name</label><input type=\"text\" name=\"userName\" id=\"userName\"autofocus required><br>\n");
      out.write("\t<label for=\"password\">Password</label><input type=\"password\" name=\"passWord\" id=\"passWord\"autofocus required><br>\n");
      out.write("\t<label for=\"stname\">Street Name</label><input type=\"text\" name=\"streetName\" id=\"streetName\"autofocus required><br>\n");
      out.write("\t<label for=\"hnumber\">House Number</label><input type=\"text\" name=\"houseNumber\" id=\"houseNumber\"autofocus required><br>\n");
      out.write("\t<label for=\"city\">City</label><input type=\"text\" name=\"city\" id=\"city\"><br>\n");
      out.write("\t<label for=\"zcode\">ZipCode</label><input type=\"text\" name=\"zipCode\" id=\"zipCode\"autofocus required><br>\n");
      out.write("        <label for=\"male\">Sex:  Male </label><input type=\"radio\" name=\"sex\" id=\"sex\" value=\"M\" checkedautofocus required>  \n");
      out.write("\tFemale: <input type=\"radio\" name=\"sex\" id=\"sex\" value=\"F\"autofocus required><br>\n");
      out.write("\t<label for=\"dob\">Date Of Birth</label> <input type=\"text\" name=\"dob\" value=\"\"autofocus required><br>\n");
      out.write("\t<input id=\"homePageSubmit\" type=\"Submit\" value=\"Register\"></input>\n");
      out.write("    </form>\n");
      out.write("    <div class=\"errormsgRegistration\">    \n");
      out.write("        ");
      out.print(request.getAttribute("errorMsg") == null ? "" : request.getAttribute("errorMsg") );
      out.write(" \n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
