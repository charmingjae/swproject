<%@ page language="java" contentType="text/html; charset=EUC-KR"

    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>  
<%
	request.setCharacterEncoding("euc-kr");

	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://localhost:3306/pm?characterEncoding=UTF-8 & serverTimezone=UTC";
	String id = "root";
	String pass = "ckalswosla1";
	String product_name = request.getParameter("proname");
	String nation = request.getParameter("proloc");
	String count = request.getParameter("pronumber");
	
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