<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<script language = "javascript">

function writeCheck()
{
	var form = document.writeform;
	
	if(!form.proname.value)
	{
		alert("��ǰ ���� �����ϼ���.");
		form.name.focus();
		return;
	}
	
	if(!form.proloc.value)
	{
		alert("�������� �����ּ���.");
		form.proloc.focus();
		return;
	}
	if(!form.pronumber.value)
	{
		alert("������ �Է��ϼ���.");
		form.pronumber.focus();
		return;
	}
	form.submit();
	
}
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
 		<title> ����ǰ ���� </title>
	</head>
 	<body>
 		<table>
			 <center>
				 <form name=writeform method=post action="write_ok.jsp">
				 			<br /><br /><br /><br /><br /><br /><br /><br /><br />
<!-- 				 			��ǰ �� : <input name="proname" placeholder="����ǰ ��ǰ��"/>
				 			������ : 	<input name="proloc" placeholder="������" />
							���� : 	<input name="pronumber" placeholder="����ǰ ����"/> -->
							
							<!-- ��ǰ �� : <select name="proname" size="1">
										<option value="" selected disabled hidden> ��ǰ ���� �����ϼ���.</option>
										<option value="AIR JORDAN 1">AIR JORDAN 1</option>
										<option value="YEEZY BOOST">YEEZY BOOST</option>
									</select>
									</select> -->
									
							��ǰ �� : <input autocomplete=off list="product" name="proname" placeholder="����ǰ ��ǰ ��">
									<datalist id="product">
											<option value="AIR JORDAN1">AIR JORDAN1</option>
											<option value="YEEZY BOOST">YEEZY BOOST</option>
									</datalist>
							������ : 	<!-- <input autocomplete=off name="proloc" placeholder="������" /> -->
									<select name="proloc" size=1">
										<optgroup label="ASIA">
											<option value="" selected disabled hidden> �������� �����ϼ���.</option>
											<option value="KR">KR(KOREA)</option>
											<option value="CH">CH(CHINA)</option>
										</optgroup>
									</select>
							���� : 	<input autocomplete=off name="pronumber" placeholder="����ǰ ����"/>
				 </form>
			 </center>
		</table>
 
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
  		<tr>
  			<td colspan="4" height="5"></td>
  		</tr>
  		<tr align="center">
   			<td>
   				<input type=button value="���" OnClick = "javascript:writeCheck();">
   			</td>
  		</tr>
		</table>
	</body> 
</html>


