<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="simpleChain.PublicChain" %>
<%@ page import="simpleChain.PublicChain.*" %>
<%@ page import="simpleChain.Block" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	request.setCharacterEncoding("euc-kr");

	PublicChain chain = new PublicChain();
	
	chain.test();
%>

<script language="javascript">
	
	
	self.window.alert("생성 완료..");

	location.href="product.jsp";
</script>
<body>

</body>
</html>