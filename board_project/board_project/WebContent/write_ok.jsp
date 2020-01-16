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
	

	
	
	System.out.println("product_name = " + product_name);
	System.out.println("nation = " + nation);
	System.out.println("count = " + count);

	PublicChain chain = new PublicChain();
	
	/* out.println(chain.product);
	out.println(chain.nation);
	out.println(chain.amount); */
	
	chain.product = product_name;
	chain.nation = nation;
	chain.amount = count;
	
	
	System.out.println("chain product_name = " + chain.product);
	System.out.println("chain nation = " + chain.nation);
	System.out.println("chain count = " + chain.amount);
	
	
	chain.addObject(chain.product, chain.nation, chain.amount);

	
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