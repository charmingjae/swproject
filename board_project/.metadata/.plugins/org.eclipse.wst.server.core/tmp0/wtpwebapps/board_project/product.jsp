<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<script language = "javascript">

function writeCheck()
{
	var form = document.writeform;
	
	if(!form.proname.value)
	{
		alert("제품 명을 선택하세요.");
		form.name.focus();
		return;
	}
	
	if(!form.proloc.value)
	{
		alert("생산지를 적어주세요.");
		form.proloc.focus();
		return;
	}
	if(!form.pronumber.value)
	{
		alert("개수를 입력하세요.");
		form.pronumber.focus();
		return;
	}
	form.submit();
	
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
 		<title> 공산품 관리 </title>
	</head>
 	<body>
 		<table>
			 <center>
				 <form name=writeform method=post action="write_ok.jsp">
				 			<br /><br /><br /><br /><br /><br /><br /><br /><br />
<!-- 				 			제품 명 : <input name="proname" placeholder="공산품 제품명"/>
				 			생산지 : 	<input name="proloc" placeholder="생산지" />
							개수 : 	<input name="pronumber" placeholder="공산품 개수"/> -->
							
							<!-- 제품 명 : <select name="proname" size="1">
										<option value="" selected disabled hidden> 제품 명을 선택하세요.</option>
										<option value="AIR JORDAN 1">AIR JORDAN 1</option>
										<option value="YEEZY BOOST">YEEZY BOOST</option>
									</select>
									</select> -->
									
							제품 명 : <input autocomplete=off list="product" name="proname" placeholder="공산품 제품 명">
									<datalist id="product">
											<option value="AIR JORDAN1">AIR JORDAN1</option>
											<option value="YEEZY BOOST">YEEZY BOOST</option>
									</datalist>
							생산지 : 	<!-- <input autocomplete=off name="proloc" placeholder="생산지" /> -->
									<select name="proloc" size=1">
										<optgroup label="ASIA">
											<option value="" selected disabled hidden> 생산지를 선택하세요.</option>
											<option value="KR">KR(KOREA)</option>
											<option value="CH">CH(CHINA)</option>
										</optgroup>
									</select>
							개수 : 	<input autocomplete=off name="pronumber" placeholder="공산품 개수"/>
				 </form>
			 </center>
		</table>
 
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
  		<tr>
  			<td colspan="4" height="5"></td>
  		</tr>
  		<tr align="center">
   			<td>
   				<input type=button value="등록" OnClick = "javascript:writeCheck();">
   			</td>
  		</tr>
		</table>
	</body> 
</html>



