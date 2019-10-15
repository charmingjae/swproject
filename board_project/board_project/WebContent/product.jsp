<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--  0924 append -->
<%@ page session="false" %> <!-- 0924 append -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	table.type11 {
	    border-collapse: separate;
	    border-spacing: 1px;
	    text-align: center;
	    line-height: 1.5;
	    margin: 20px 10px;
	}
	table.type11 th {
	    width: 155px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #303D4B ;
	}
	table.type11 td {
	    width: 155px;
	    padding: 10px;
	    vertical-align: top;
	    border-bottom: 1px solid #ccc;
	    background: #eee;
	}
	a:link { color: red; text-decoration: none;}
	a:visited { color: black; text-decoration: none;}
	a:hover { color: blue; text-decoration: none;}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script> <!--  0924 append -->
<script language = "javascript">




// SQL
// 0924 append


													// TEST1
/*       $(function() {
         
        $("#checkJson").click(function() {
          var form = document.writeform;
          //사람 정보
          var blockChain = new Array();
             
          var blockInfo = new Object();
           
          blockInfo.name = form.proname.value;
          blockInfo.location = form.proloc.value;
          blockInfo.count = form.pronumber.value;
             
          blockChain.push(blockInfo);
          
           
          //블록체인 정보를 넣음
          var totalInfo = new Object();
           
          totalInfo.block = blockChain;
           
          var jsonInfo = JSON.stringify(totalInfo);
          console.log(jsonInfo); //브라우저 f12개발자 모드에서 confole로 확인 가능
          alert(jsonInfo);
     
        });
         
      }); */
		
		
      
      
      												// TEST2
 	$(function() {
         
        $("#checkJson").click(function() {
          var form = document.writeform;
          //사람 정보
          var blockChain = new Array();
             
          var blockInfo = new Object();
           
          blockInfo.sender = form.proname.value;
          blockInfo.recipient = form.proloc.value;
          blockInfo.amount = form.pronumber.value;
             
          blockChain.push(blockInfo);
          
          
          //블록체인 정보를 넣음
          var totalInfo = new Object();
           
          totalInfo/* .transactions */ = blockChain;
           
          var jsonInfo = JSON.stringify(totalInfo);
          console.log(jsonInfo); //브라우저 f12개발자 모드에서 confole로 확인 가능
          alert(jsonInfo);
          
          $.ajax({
        	  type: "POST",
              dataType : "JSON",
              url : "http://localhost:8000/transactions/new/",
              data : jsonInfo,
              success : function(data){
            	  alert("SUCCESS");
              },
              error : function(e){
            	  alert("문제가 일어났습니다.");
              }
          });
        });
      });     												
	
//


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



function addRow(){
	 
	   mytable = document.getElementById("table1");  //행을 추가할 테이블
	   row = mytable.insertRow(mytable.rows.length);  //추가할 행

	   
	   cell1 = row.insertCell(0);  //실제 행 추가 여기서의 숫자는 컬럼 수
	   cell2 = row.insertCell(1);
	   cell3 = row.insertCell(2);

	   
       cell1.innerHTML = document.getElementsByName('proname')[0].value; //추가한 행에 원하는  요소추가
	   cell2.innerHTML = document.getElementsByName('proloc')[0].value;
	   cell3.innerHTML = document.getElementsByName('pronumber')[0].value;
	}
	
function statusChg(){
	
	
	
	if(confirm("상태를 변경하시겠습니까?")){
		
	}
	else{
		return;
	}
	
}
	
	<%

		final int ROWSIZE = 4;
		final int BLOCK = 5;
		
		int pg = 1;
		
		if(request.getParameter("pg")!=null){
			pg=Integer.parseInt(request.getParameter("pg"));
		}
		
		int start = (pg*ROWSIZE) - (ROWSIZE -1);
		int end = (pg*ROWSIZE);
		
		int allPage = 0;
		
		int startPage = ((pg-1)/BLOCK*BLOCK)+1;
		int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;
	%>
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
								<label>제품 명 </label>
								<input autocomplete=off list="product" id="prodname" name="proname" placeholder="공산품 제품 명">
									<datalist id="product">
											<option value="AIR JORDAN1">AIR JORDAN1</option>
											<option value="YEEZY BOOST">YEEZY BOOST</option>
									</datalist>
								&emsp;&emsp;&emsp;
								<label>생산지 </label>
							 	<!-- <input autocomplete=off name="proloc" placeholder="생산지" /> -->
									<select id="prodloc" name="proloc" size=1">
										<optgroup label="ASIA">
											<option value="" selected disabled hidden> 생산지를 선택하세요.</option>
											<option value="KR">KR(KOREA)</option>
											<option value="CH">CH(CHINA)</option>
										</optgroup>
									</select>
								&emsp;&emsp;&emsp;
								<label>개수 </label> 	
								<input autocomplete=off id="prodnumber" name="pronumber" placeholder="공산품 개수"/>
				 </form>
				 
				 
				 
			 </center>
		</table>
 		<br />
		<table width="100%" cellpadding="0" cellspacing="0" border="0" style="margin:auto; text-align:center">
		
		
	  		<tr>
	   			<td>
	   				<input type=button value="등록" OnClick = "javascript:writeCheck();">
	   				<input type=button value="json append" id="checkJson">
	   			</td>
	  		</tr>
  		<!-- <script type="text/javascript" src"./js/app.js"></script> -->
		</table>
		<br />
		
		<table width="1000px" cellpadding="0" cellspacing="0" border="0" style="margin:auto; text-align:center" class="type11">
		<tr>
			<th>번호</th>
			<th>생산품 명</th>
			<th>생산지</th>
			<th>개수</th>
			<th>생산일</th>
			<th>STATUS</th>
		</tr>
  			<% 
  			
  			request.setCharacterEncoding("euc-kr");
  			Class.forName("com.mysql.jdbc.Driver");
  			
  			String url = "jdbc:mysql://localhost:3306/pm?characterEncoding=UTF-8 & serverTimezone=UTC";
  			String id = "root";
  			String pass = "ckalswosla1";
  			String product_name = request.getParameter("proname");
  			String nation = request.getParameter("proloc");
  			String count = request.getParameter("pronumber");
  			
  			
  			
  			ResultSet rs = null;
  			ResultSet rs1 = null;
  			int total = 0;
  			/* Statement stmt = null; */
  			try {
  				
  	  			
  				Connection conn = DriverManager.getConnection(url,id,pass);
  				
  				/* final int ROWSIZE = 4;
  				final int BLOCK = 5;
  				
  				int pg = 1;
  				
  				if(request.getParameter("pg")!=null){
  					pg=Integer.parseInt(request.getParameter("pg"));
  				}
  				
  				int start = (pg*ROWSIZE) - (ROWSIZE -1);
  				int end = (pg*ROWSIZE);
  				
  				int allPage = 0;
  				
  				int startPage = ((pg-1)/BLOCK*BLOCK)+1;
  				int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK; */
  				
  				String sql = "SELECT * FROM PRODUCT WHERE NO >= " + start + " and NO <= " + end + " ORDER BY NO";
  				String sqlSort = "SELECT COUNT(*) FROM PRODUCT";
  				
  				Statement stmt = conn.createStatement();
  				Statement stmt1 = conn.createStatement();
  				
  				
  				rs1 = stmt1.executeQuery(sqlSort);
  				try{
  	  				if(rs1.next()){
  	  					total = rs1.getInt(1);
  	  				}
  				}catch(NullPointerException e){
  					out.println(e.toString());
  				}
  				
  				rs = stmt.executeQuery(sql);
  				
  				
  				while(rs.next())
  				{		
  			%>
  				<tr>
  					<td><%= rs.getString("NO") %></td>
  					<td><%= rs.getString("PRODUCT_NAME") %></td>
  					<td><%= rs.getString("NATION") %></td>
  					<td><%= rs.getString("COUNT") %></td>
  					<td><%= rs.getString("CREATE_DATE") %></td>
  					<td><a class="statusChg" href="javascript:statusChg();">
  					<%= rs.getString("STATUS") %></a>
  					</td>
  				</tr> 					
  			<%
  				}
  				
  				allPage = (int)Math.ceil(total/(double)ROWSIZE);
  				
  				if(endPage > allPage){
  					endPage = allPage;
  				}
  				
  				rs.close();
  				rs1.close();
				stmt.close();
  				stmt1.close();
  				conn.close();
  			} catch(SQLException e) {
  			out.println( e.toString() );
  			}
  			%>
  			</table>
  			
  			<table width="100%" cellpadding="0" cellspacing="0" border="0">
  				<tr><td colspan="4" height="5"></td></tr>
  				<tr>
  					<td align="center">
  						<%
  							if(pg>BLOCK){
  						%>
  							<a href="product.jsp?pg=1"> ◀◀ </a>
  							<a href="product.jsp?pg=<%=startPage-1%>"> ◀ </a>
  						<%
  							}
  						%>
  						
  						<%
  							for(int i=startPage;i<=endPage;i++){
  								if(i==pg){
  						%>
  								<b> <%= i %>&nbsp; </b>
  						<%
  								}else{
  						%>
  									<a href="product.jsp?pg=<%=i %>"><%= i %>&nbsp;</a>
  						<%
  								}
  							}
  						%>
  						
  						<%
  							if(endPage<allPage){
  						%>
  							<a href="product.jsp?pg=<%=endPage+1 %>"> ▶ </a>
  							<a href="product.jsp?pg=<%=allPage %>"> ▶▶ </a>
  						<%
  							}
  						%>
  						</td>
  						</tr>
  			</table>
	</body> 
</html>



