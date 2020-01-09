/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2019-12-16 08:38:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>회원 가입</title>\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>\n");
      out.write("<link href=\"//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t@import url(\"register.css\");\n");
      out.write("</style> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction check(){\n");
      out.write("\t\tif(!frm.stu_no.value){\n");
      out.write("\t\t\talert(\"학번을 입력하세요.\");\n");
      out.write("\t\t\tfrm.stu_no.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif(!frm.stu_name.value){\n");
      out.write("\t\t\talert(\"이름을 입력하세요.\");\n");
      out.write("\t\t\tfrm.stu_name.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif(!frm.stu_pw.value){\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요.\");\n");
      out.write("\t\t\tfrm.stu_pw.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif(!frm.stu_tel.value){\n");
      out.write("\t\t\talert(\"전화번호를 입력하세요.\");\n");
      out.write("\t\t\tfrm.stu_tel.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"testbox\">\n");
      out.write("  <h1>Register.</h1>\n");
      out.write("\n");
      out.write("  <form action=\"registerProc.jsp\" name=\"frm\" onsubmit=\"return check()\">\n");
      out.write("      <hr>\n");
      out.write("\t    <div class=\"grade\">\n");
      out.write("\t      <input type=\"radio\" value=\"1\" id=\"radioOne\" name=\"stu_grade\" checked/>\n");
      out.write("\t      <label for=\"radioOne\" class=\"radio\" chec>1학년</label>\n");
      out.write("\t      <input type=\"radio\" value=\"2\" id=\"radioTwo\" name=\"stu_grade\" />\n");
      out.write("\t      <label for=\"radioTwo\" class=\"radio\">2학년</label>\n");
      out.write("\t      <input type=\"radio\" value=\"3\" id=\"radioThree\" name=\"stu_grade\" />\n");
      out.write("\t      <label for=\"radioThree\" class=\"radio\">3학년</label>\n");
      out.write("\t    </div>\n");
      out.write("  \t\t<hr>\n");
      out.write("\t\t  <label id=\"icon\" for=\"stu_no\"><i class=\"icon-user \"></i></label>\n");
      out.write("\t\t  <input type=\"number\" name=\"stu_no\" id=\"stu_no\" placeholder=\"학번\" required/>\n");
      out.write("\t\t  \n");
      out.write("\t\t  <label id=\"icon\" for=\"stu_name\"><i class=\"icon-smile\"></i></label>\n");
      out.write("\t\t  <input type=\"text\" name=\"stu_name\" id=\"stu_name\" placeholder=\"이름\" required/>\n");
      out.write("\t\t  \n");
      out.write("\t\t  <label id=\"icon\" for=\"stu_pw\"><i class=\"icon-shield\"></i></label>\n");
      out.write("\t\t  <input type=\"password\" name=\"stu_pw\" id=\"stu_pw\" placeholder=\"비밀번호\" required/>\n");
      out.write("\t\t  \n");
      out.write("\t\t  <label id=\"icon\" for=\"stu_tel\"><i class=\"icon-terminal\"></i></label>\n");
      out.write("\t\t  <input type=\"text\" name=\"stu_tel\" id=\"stu_tel\" placeholder=\"전화번호\" required/>\n");
      out.write("\t\t  \n");
      out.write("\t\t  <br><br>\n");
      out.write("\t\t  \n");
      out.write("\t\t  \n");
      out.write("\t\t  \n");
      out.write("\t\t  \n");
      out.write("\t\t  <div class=\"class\">\n");
      out.write("\t\t    <input type=\"radio\" value=\"A\" id=\"classA\" name=\"stu_class\" checked/>\n");
      out.write("\t\t    <label for=\"classA\" class=\"radio\" chec>A반</label>\n");
      out.write("\t\t    \n");
      out.write("\t\t    <input type=\"radio\" value=\"B\" id=\"classB\" name=\"stu_class\" />\n");
      out.write("\t\t    <label for=\"classB\" class=\"radio\">B반</label>\n");
      out.write("\t\t    \n");
      out.write("\t\t    <input type=\"radio\" value=\"C\" id=\"classC\" name=\"stu_class\" />\n");
      out.write("\t\t    <label for=\"classC\" class=\"radio\">C반</label>\n");
      out.write("\t\t   </div> \n");
      out.write("<!--    \t\t<p>By clicking Register, you agree on our <a href=\"#\">terms and condition</a>.</p> -->\n");
      out.write("<!-- \t\t<a href=\"./registerProc.jsp\" class=\"button\" onclick =\"return check()\">Register</a> -->\n");
      out.write("\t\t<button type=\"submit\" class=\"buttonset\">회원가입</button>\n");
      out.write("  </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
