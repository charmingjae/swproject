<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>For Sale:</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
</head>
	<body>

		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo"><a href="index.jsp">For Sale: The Book, Never Used <span>inHaTc</span></a></div>
				<a href="#menu" class="toggle"><span>Menu</span></a>
			</header>
			
			

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li>
					<%
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
								%>

									<a href="../queryMyBook.jsp?stu_no=<%=stu_no%>"><font face="돋움"><%= stu_name %>님 환영합니다.</font></a>

									
								<%
							}
							
							stat.close();
							conn.close();
							
							
							if(stu_no == null || stu_no.equals("")){
								%>
									<a href="../login.jsp"><font face="돋움">로그인</font></a>
								<%
							}
							else{
								%>
									<a href="../logout.jsp"><font face="돋움">로그아웃</font></a>
								<%
							}
							////////////////////////
							
						}catch(Exception e){
							%>
							<script type="text/javascript">
								alert("SQLException : " + e.getMessage());
							</script>
							<%
							
						}
					%>
					
					
						<!-- <a href="../login.jsp">로그인</a>
						<a href="../logout.jsp">로그아웃</a> -->
						<a href="../register.jsp"><font face="돋움">회원가입</font></a>
					</li>
				</ul>
				
				<ul class="links">
					<li><a href="index.jsp"><font face="돋움">HOME</font></a></li>
<!-- 					<li><a href="../login.jsp">Log In</a></li>
					<li><a href="../register.jsp">Register</a></li> -->
				</ul>
			</nav>

		<!-- Banner -->
		<!--
			To use a video as your background, set data-video to the name of your video without
			its extension (eg. images/banner). Your video must be available in both .mp4 and .webm
			formats to work correctly.
		-->
			<section id="banner" data-video="images/banner">
				<div class="inner">
					<h1>For Sale: The Book, Never Used</h1>
					<p><font face="돋움">컴퓨터 정보과의 책 거래를 위한 장소입니다.<br />
					당신의 <a href="../sessionChk.jsp">책장</a>에 잠들어있는 책들을 깨워주세요.</font></p>
					<!-- <a href="#one" class="button special scrolly btn btn-light">Get Started</a> -->
					<a href="../sessionChk.jsp" class="button btn-light"><font face="돋움">책 장 으 로</font></a>
				</div>
			</section>

		<!-- One -->
			<!-- <section id="one" class="wrapper style2">
				<div class="inner">
					<div>
						<div class="box">
							<div class="image fit">
								<img src="images/pic01.jpg" alt="" />
							</div>
							<div class="content">
								<header class="align-center">
									<h2>Lorem ipsum dolor</h2>
									<p>maecenas feugiat ex purus, quis volutpat lacus placerat</p>
								</header>
								<hr />
								<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>
								<p>Vivamus fermentum nibh vel pharetra blandit. Cras a purus urna. Sed et libero ex. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse id hendrerit felis. Nulla viverra tempor dui at congue. Pellentesque quis nulla ornare, congue nisi id, finibus nulla. Aliquam sit amet hendrerit purus. Donec libero massa, posuere fermentum eros sit amet, maximus fringilla augue. Maecenas at rhoncus lorem. Vivamus ultricies consequat est, efficitur convallis libero. Vivamus rutrum semper mauris, vitae consequat eros tempor ac. Pellentesque et ornare sapien</p>
							</div>
						</div>
					</div>
				</div>
			</section>

		Two
			<section id="two" class="wrapper style3">
				<div class="inner">
					<div id="flexgrid">
						<div>
							<header>
								<h3>Tempus Feugiat</h3>
							</header>
							<p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu</p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
						<div>
							<header>
								<h3>Aliquam Nulla</h3>
							</header>
							<p>Ut convallis, sem sit amet interdum consectetuer, odio augue aliquam leo, nec dapibus tortor nibh sed </p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
						<div>
							<header>
								<h3>Sed Magna</h3>
							</header>
							<p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula.</p>
							<ul class="actions">
								<li><a href="#" class="button alt">Learn More</a></li>
							</ul>
						</div>
					</div>
				</div>
			</section>

		Three
			<section id="three" class="wrapper style2">
				<div class="inner">
					<div class="grid-style">

						<div>
							<div class="box">
								<div class="image fit">
									<img src="images/pic02.jpg" alt="" />
								</div>
								<div class="content">
									<header class="align-center">
										<h2>Lorem ipsum dolor</h2>
										<p>maecenas feugiat ex purus, quis volutpat lacus placerat</p>
									</header>
									<hr />
									<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>
								</div>
							</div>
						</div>

						<div>
							<div class="box">
								<div class="image fit">
									<img src="images/pic03.jpg" alt="" />
								</div>
								<div class="content">
									<header class="align-center">
										<h2>Vestibulum sit amet</h2>
										<p>mattis sapien pretium tellus venenatis</p>
									</header>
									<hr />
									<p> Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>

		Four
			<section id="four" class="wrapper style3">
				<div class="inner">

					<header class="align-center">
						<h2>Morbi interdum mollis sapien</h2>
						<p>Cras aliquet urna ut sapien tincidunt, quis malesuada elit facilisis. Vestibulum sit amet tortor velit. Nam elementum nibh a libero pharetra elementum. Maecenas feugiat ex purus, quis volutpat lacus placerat malesuada. Praesent in sem ex. Morbi mattis sapien pretium tellus venenatis, at egestas urna ornare.</p>
					</header>

				</div>
			</section>

		Footer
			<footer id="footer" class="wrapper">
				<div class="inner">
					<section>
						<div class="box">
							<div class="content">
								<h2 class="align-center">Get in Touch</h2>
								<hr />
								<form action="#" method="post">
									<div class="field half first">
										<label for="name">Name</label>
										<input name="name" id="name" type="text" placeholder="Name">
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input name="email" id="email" type="email" placeholder="Email">
									</div>
									<div class="field">
										<label for="dept">Department</label>
										<div class="select-wrapper">
											<select name="dept" id="dept">
												<option value="">- Category -</option>
												<option value="1">Manufacturing</option>
												<option value="1">Shipping</option>
												<option value="1">Administration</option>
												<option value="1">Human Resources</option>
											</select>
										</div>
									</div>
									<div class="field">
										<label for="message">Message</label>
										<textarea name="message" id="message" rows="6" placeholder="Message"></textarea>
									</div>
									<ul class="actions align-center">
										<li><input value="Send Message" class="button special" type="submit"></li>
									</ul>
								</form>
							</div>
						</div>
					</section>
					<div class="copyright">
						&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>. Images <a href="https://unsplash.com/">Unsplash</a>. Video <a href="http://coverr.co/">Coverr</a>.
					</div>
				</div>
			</footer> -->


		
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>