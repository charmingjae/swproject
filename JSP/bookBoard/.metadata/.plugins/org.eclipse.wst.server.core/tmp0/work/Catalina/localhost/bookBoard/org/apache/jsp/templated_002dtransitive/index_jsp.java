/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2019-12-19 07:40:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.templated_002dtransitive;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
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
      out.write("    \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("\t\t<title>For Sale:</title>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("</head>\n");
      out.write("\t<body>\n");
      out.write("\n");
      out.write("\t\t<!-- Header -->\n");
      out.write("\t\t\t<header id=\"header\" class=\"alt\">\n");
      out.write("\t\t\t\t<div class=\"logo\"><a href=\"index.jsp\">For Sale: The Book, Never Used <span>inHaTc</span></a></div>\n");
      out.write("\t\t\t\t<a href=\"#menu\" class=\"toggle\"><span>Menu</span></a>\n");
      out.write("\t\t\t</header>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\n");
      out.write("\t\t<!-- Nav -->\n");
      out.write("\t\t\t<nav id=\"menu\">\n");
      out.write("\t\t\t\t<ul class=\"links\">\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t");

						String stu_no = "";
						String stu_name = "";
						try{
							stu_no = (String)session.getAttribute("stu_no");
							System.out.println(stu_no);
							
							
							
							 ////////////////////////
							
							
							//* * Class.forName("com.mysql.jdbc.Driver");
							
							Connection conn = null;
							Statement stat	= null;
							ResultSet rs 	= null;
							
							String jdbcDriver = "jdbc:mysql://localhost:3306/bookDB?"+
												"useSSl=false&serverTimezone=UTC";
							
							String dbUser = "root";
							String dbPass = "1234";
							
							String sql = "SELECT STU_NAME FROM MEMBER_INFO WHERE STU_NO = '" + stu_no + "'";
							
							//2. 데이터베이스 커넥션 생성
							conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
							
							//3. 쿼리를 위한 Statement 생성
							stat = conn.createStatement();
							
							//4. 쿼리 실행.
							rs = stat.executeQuery(sql);
							
							int stuCheck = 0;
							int result = 0;
							
							if(rs.next()){	
								stu_name = rs.getString("STU_NAME");
								
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../queryMyBook.jsp?stu_no=");
      out.print(stu_no);
      out.write("\"><font face=\"돋움\">");
      out.print( stu_name );
      out.write("님 환영합니다.</font></a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							
							stat.close();
							conn.close();
							
							
							if(stu_no == null || stu_no.equals("")){
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../login.jsp\"><font face=\"돋움\">로그인</font></a>\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							else{
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"../logout.jsp\"><font face=\"돋움\">로그아웃</font></a>\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
							////////////////////////
							
						}catch(Exception e){
							
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t\t\t\t\t\talert(\"SQLException : \" + e.getMessage());\n");
      out.write("\t\t\t\t\t\t\t</script>\n");
      out.write("\t\t\t\t\t\t\t");

							
						}
					
      out.write("\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<!-- <a href=\"../login.jsp\">로그인</a>\n");
      out.write("\t\t\t\t\t\t<a href=\"../logout.jsp\">로그아웃</a> -->\n");
      out.write("\t\t\t\t\t\t<a href=\"../register.jsp\"><font face=\"돋움\">회원가입</font></a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<ul class=\"links\">\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\"><font face=\"돋움\">HOME</font></a></li>\n");
      out.write("<!-- \t\t\t\t\t<li><a href=\"../login.jsp\">Log In</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"../register.jsp\">Register</a></li> -->\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\n");
      out.write("\t\t<!-- Banner -->\n");
      out.write("\t\t<!--\n");
      out.write("\t\t\tTo use a video as your background, set data-video to the name of your video without\n");
      out.write("\t\t\tits extension (eg. images/banner). Your video must be available in both .mp4 and .webm\n");
      out.write("\t\t\tformats to work correctly.\n");
      out.write("\t\t-->\n");
      out.write("\t\t\t<section id=\"banner\" data-video=\"images/banner\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\t\t\t\t\t<h1>For Sale: The Book, Never Used</h1>\n");
      out.write("\t\t\t\t\t<p><font face=\"돋움\">컴퓨터 정보과의 책 거래를 위한 장소입니다.<br />\n");
      out.write("\t\t\t\t\t당신의 <a href=\"../sessionChk.jsp\">책장</a>에 잠들어있는 책들을 깨워주세요.</font></p>\n");
      out.write("\t\t\t\t\t<!-- <a href=\"#one\" class=\"button special scrolly btn btn-light\">Get Started</a> -->\n");
      out.write("\t\t\t\t\t<a href=\"../sessionChk.jsp\" class=\"button btn-light\"><font face=\"돋움\">책 장 으 로</font></a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t<!-- One -->\n");
      out.write("\t\t\t<!-- <section id=\"one\" class=\"wrapper style2\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"image fit\">\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"images/pic01.jpg\" alt=\"\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t\t\t\t\t<header class=\"align-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h2>Lorem ipsum dolor</h2>\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>maecenas feugiat ex purus, quis volutpat lacus placerat</p>\n");
      out.write("\t\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t\t<hr />\n");
      out.write("\t\t\t\t\t\t\t\t<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>Vivamus fermentum nibh vel pharetra blandit. Cras a purus urna. Sed et libero ex. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse id hendrerit felis. Nulla viverra tempor dui at congue. Pellentesque quis nulla ornare, congue nisi id, finibus nulla. Aliquam sit amet hendrerit purus. Donec libero massa, posuere fermentum eros sit amet, maximus fringilla augue. Maecenas at rhoncus lorem. Vivamus ultricies consequat est, efficitur convallis libero. Vivamus rutrum semper mauris, vitae consequat eros tempor ac. Pellentesque et ornare sapien</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\tTwo\n");
      out.write("\t\t\t<section id=\"two\" class=\"wrapper style3\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\t\t\t\t\t<div id=\"flexgrid\">\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t\t\t<h3>Tempus Feugiat</h3>\n");
      out.write("\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t<p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu</p>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"actions\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button alt\">Learn More</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t\t\t<h3>Aliquam Nulla</h3>\n");
      out.write("\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t<p>Ut convallis, sem sit amet interdum consectetuer, odio augue aliquam leo, nec dapibus tortor nibh sed </p>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"actions\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button alt\">Learn More</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t\t\t<h3>Sed Magna</h3>\n");
      out.write("\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t<p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula.</p>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"actions\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button alt\">Learn More</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\tThree\n");
      out.write("\t\t\t<section id=\"three\" class=\"wrapper style2\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\t\t\t\t\t<div class=\"grid-style\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"image fit\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src=\"images/pic02.jpg\" alt=\"\" />\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<header class=\"align-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>Lorem ipsum dolor</h2>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>maecenas feugiat ex purus, quis volutpat lacus placerat</p>\n");
      out.write("\t\t\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t\t\t<hr />\n");
      out.write("\t\t\t\t\t\t\t\t\t<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"image fit\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src=\"images/pic03.jpg\" alt=\"\" />\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<header class=\"align-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>Vestibulum sit amet</h2>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>mattis sapien pretium tellus venenatis</p>\n");
      out.write("\t\t\t\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t\t\t\t<hr />\n");
      out.write("\t\t\t\t\t\t\t\t\t<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\tFour\n");
      out.write("\t\t\t<section id=\"four\" class=\"wrapper style3\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<header class=\"align-center\">\n");
      out.write("\t\t\t\t\t\t<h2>Morbi interdum mollis sapien</h2>\n");
      out.write("\t\t\t\t\t\t<p>Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>\n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\tFooter\n");
      out.write("\t\t\t<footer id=\"footer\" class=\"wrapper\">\n");
      out.write("\t\t\t\t<div class=\"inner\">\n");
      out.write("\t\t\t\t\t<section>\n");
      out.write("\t\t\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t\t\t\t\t<h2 class=\"align-center\">Get in Touch</h2>\n");
      out.write("\t\t\t\t\t\t\t\t<hr />\n");
      out.write("\t\t\t\t\t\t\t\t<form action=\"#\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"field half first\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"name\">Name</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input name=\"name\" id=\"name\" type=\"text\" placeholder=\"Name\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"field half\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"email\">Email</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input name=\"email\" id=\"email\" type=\"email\" placeholder=\"Email\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"field\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"dept\">Department</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"select-wrapper\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<select name=\"dept\" id=\"dept\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">- Category -</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Manufacturing</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Shipping</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Administration</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Human Resources</option>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"field\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"message\">Message</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<textarea name=\"message\" id=\"message\" rows=\"6\" placeholder=\"Message\"></textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"actions align-center\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><input value=\"Send Message\" class=\"button special\" type=\"submit\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t<div class=\"copyright\">\n");
      out.write("\t\t\t\t\t\t&copy; Untitled Design: <a href=\"https://templated.co/\">TEMPLATED</a>. Images <a href=\"https://unsplash.com/\">Unsplash</a>. Video <a href=\"http://coverr.co/\">Coverr</a>.\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</footer> -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Scripts -->\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.scrolly.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.scrollex.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/skel.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/util.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("\t</body>\n");
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
