<%@ page language="java" contentType="text/html; charset=EUC-KR"

    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%> 
<%-- <%@ page import="simpleChain.*" %> --%>
<%@ page import="simpleChain.PublicChain" %>
<%@ page import="simpleChain.PublicChain.*" %>
<%@ page import="simpleChain.Block" %>
<%
	request.setCharacterEncoding("euc-kr");

	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/pm?characterEncoding=UTF-8 & serverTimezone=UTC";
	String id = "root";
	String pass = "1234";
	String product_name = request.getParameter("proname");
	String nation = request.getParameter("proloc");
	String count = request.getParameter("pronumber");
	

	PublicChain chain = new PublicChain();
	
	/* out.println(chain.sender);
	out.println(chain.recipient);
	out.println(chain.amount); */
	
	chain.sender = product_name;
	chain.recipient = nation;
	chain.amount = count;
	
	chain.test();

	
	/* Block block = new Block(1, product_name, nation, product_name, nation, 1); */
	


	
	
	try {	
		Connection conn = DriverManager.getConnection(url,id,pass);
		
		String sql = "INSERT INTO product(PRODUCT_NAME, NATION, COUNT) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, product_name);
		pstmt.setString(2, nation);
		pstmt.setString(3, count);
		
		pstmt.execute();
		pstmt.close();
		
		conn.close();
		
		
	} catch(SQLException e) {
	out.println( e.toString() );
	}

	
%>
	<script language=javascript>
	
	
	self.window.alert("전송 완료.");

	location.href="product.jsp";
	</script>