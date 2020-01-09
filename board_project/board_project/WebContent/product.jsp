<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!--  0924 append -->
<%@ page session="false" %> <!-- 0924 append -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="simpleChain.PublicChain" %>
<%@ page import="simpleChain.PublicChain.*" %>
<%@ page import="simpleChain.Block" %>

<style type="text/css"> /* css */
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

<script src="https://code.jquery.com/jquery-3.4.1.js"></script> <!--  0924 append -->
<script language = "javascript">
		
      
      
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

function addTran()
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



function generateBlock(){ //최초 블록 생성 함수
	location.href="./generateBlock.jsp";
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
	var form = document.chkform;
	if(confirm("상태를 변경하시겠습니까? index number : ")){
		form.submit();
	}
	else{
		return;
	}
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
				 	<table border = 0 width="15%" cellpadding="0" cellspacing="0" style="margin:auto; text-align:center">
				 		<tr>
				 			<td>제품명</td>
				 			<td>
				 				<input autocomplete=off list="product" id="prodname" name="proname" placeholder="공산품 제품 명">
									<datalist id="product">
											<option value="AIR JORDAN1">AIR JORDAN1</option>
											<option value="YEEZY BOOST">YEEZY BOOST</option>
									</datalist>
							</td>
				 		</tr>
				 		<tr>
				 			<td>생산지</td>
				 			<td>
				 				<!-- <input autocomplete=off name="proloc" placeholder="생산지" /> -->
				 				<select id="prodloc" name="proloc" size=1">
										<optgroup label="ASIA">
											<option value="" selected disabled hidden> 생산지를 선택하세요.</option>
											<option value="KR">KR(KOREA)</option>
											<option value="CH">CH(CHINA)</option>
										</optgroup>
									</select>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td>개수</td>
				 			<td>
				 				<input autocomplete=off id="prodnumber" name="pronumber" placeholder="공산품 개수"/>
				 			</td>
				 		</tr>
				 	</table>		
				 </form>
				 
				 
				 
			 </center>
		</table>
 		<br />
 		
 		
		<table width="100%" cellpadding="0" cellspacing="0" border="0" style="margin:auto; text-align:center">
		
		
	  		<tr>
	   			<td>
	   				<input type=button value="등록" OnClick ="generateBlock();">
	   				<!-- <input type=button value="수정" OnClick = "javascript:statusChg();"> -->
	   				<!-- <input type=button value="json append" id="checkJson"> -->
	   				<!-- input type=button value="TESTTEST" id="selectBtn"> -->
	   				<!-- <button type="button" id="selectBtn">선택</button> -->
	   				<input type="button" value="거래내역 추가" Onclick = "javascript:writeCheck();">
	   				<!-- <button type="button" value="최초 블록 생성" Onclick = "javascript:generateBlock();"> 최초 블록 생성 </button> -->
	   			</td>
	  		</tr>
  		<!-- <script type="text/javascript" src"./js/app.js"></script> -->
		</table>
		<br />
		
		
		
		<form name=chkform method=post action="edit.jsp">
		
		<table width="1200px" cellpadding="0" cellspacing="0" border="0" style="margin:auto; text-align:center" class="type11">
		
			<%
				final int ROWSIZE = 5; // 한 페이지에 보일 게시물 수
				final int BLOCK = 5; // 아래에 보일 페이지 최대 개수 1~5 / 6 ~ 10 / 11 ~ 15
				int pg = 1; // 기본 페이지 값
				
				if(request.getParameter("pg") != null) { // 받아온 pg 값이 있을 때 .
					pg = Integer.parseInt(request.getParameter("pg")); // pg 값 저장
				}
				int start = (pg*ROWSIZE) - (ROWSIZE -1); // 해당페이지에서 시작 번호 ( DB - SORT )
				int end = (pg*ROWSIZE); // 해당 페이지에서 끝 번호 ( DB - SORT )
				
				int allPage = 0; // 전체 페이지 수
				
				int startPage = ((pg-1)/BLOCK*BLOCK)+1; // 시작 블럭 숫자. 1~5번은 1, 6~10 6
				int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK; // 끝 블럭 숫자. 1~5번은 5, 6~10 10
			%>
			
			
  			<% 
  			
  				request.setCharacterEncoding("euc-kr");
  				Class.forName("com.mysql.jdbc.Driver");
  			
  				String url = "jdbc:mysql://localhost:3306/pm?characterEncoding=UTF-8 & serverTimezone=UTC";
  				String id = "root";
  				String pass = "1234";
  				int total = 0;
  				
  				try{
  					Connection conn = DriverManager.getConnection(url,id,pass);
  					Statement stmt = conn.createStatement(); // sqlCount에 할당.
  					Statement stmt1 = conn.createStatement(); // sql에 할당.
  					
  					String sqlCount = "SELECT COUNT(*) FROM product";
  					ResultSet rs = stmt.executeQuery(sqlCount);
  					
  					if(rs.next()){
  						total = rs.getInt(1);
  					}
  					int sort = 1;
  					String sqlSort = "SELECT NO FROM PRODUCT ORDER BY NO DESC";
  					rs = stmt.executeQuery(sqlSort);
  					
  					while(rs.next()){
  						int stepNum = rs.getInt(1);
  						String sqlColumnUpdate = "UPDATE PRODUCT SET SORT = " + sort + " WHERE NO = " + stepNum;
  						stmt1.executeUpdate(sqlColumnUpdate);
  						sort++;
  					}
  					
  					allPage = (int)Math.ceil(total/(double)ROWSIZE);
  					
  					if(endPage > allPage)
  					{
  						endPage = allPage;
  					}
  				
  					String sql = "SELECT NO, PRODUCT_NAME, NATION, COUNT, STATUS, CREATE_DATE,SORT FROM PRODUCT WHERE SORT >= " + start + " and SORT <= " + end + " ORDER BY SORT"; //데이터 출력
  					rs = stmt1.executeQuery(sql);
  			%>
  			<tr>
  				<th>관리</th>
				<th>번호</th>
				<th>생산품 명</th>
				<th>생산지</th>
				<th>개수</th>
				<th>생산일</th>
				<th>STATUS</th>
			</tr>
			<%
				if(total==0) {
			%>		
				<tr align="center" height="30">
					<td colspan = "6"> 등록된 상품이 없습니다.</td>
				</tr>
			<%
				} // if 종료
				else {
					
					while(rs.next()) {
						int idx = rs.getInt(1);
						String proname = rs.getString(2);
						String nation = rs.getString(3);
						int count = rs.getInt(4);
						String status = rs.getString(5);
						String date = rs.getString(6);
						int getSort = rs.getInt(7);
			%>	
  				<tr>
  					<td><input type="radio" name="user_CheckBox" ></td>
  					<td><%= idx %></td>
  					<td><%= proname %></td>
  					<td><%= nation %></td>
  					<td><%= count %></td>
  					<td><%= date %></td>
  					<td><a class="statusChg" href="javascript:statusChg();">
  					<%= status %></a>
  					</td>
  				</tr> 					
  			<%
					}// while 종료
				}// else 종료
				rs.close();
				stmt.close();
				conn.close();
  				} //try 종료
  				catch(SQLException e) {
  					out.println(e.toString());
  				}// catch 종료
  			%>
  			</table>
  			
  			
  			<table width="100%" cellpadding="0" cellspacing="0" border="0">
  				<tr><td colspan="6" height="5"></td></tr>
  				<tr>
					<td align="center">
						<%
							if(pg>BLOCK) {
						%>
								[<a href="product.jsp?pg=1">◀◀</a>]
								[<a href="product.jsp?pg=<%=startPage-1%>">◀</a>]
						<%
							}
						%>
						
						<%
							for(int i=startPage; i<= endPage; i++){
								if(i==pg){
						%>
									<u><b>[<%=i %>]</b></u>
						<%
								}else{
						%>
									[<a href="product.jsp?pg=<%=i %>"><%=i %></a>]
						<%
								}
							}
						%>
						
						<%
							if(endPage<allPage){
						%>
							[<a href="product.jsp?pg=<%=endPage+1%>">▶</a>]
							[<a href="product.jsp?pg=<%=allPage%>">▶▶</a>]
						<%
							}
						%>
						
						
					</td>
				</tr>
			</table>
			<br/>
			<div class="col-lg-12" id="ex3_Result2" style="width:100%; text-align:center;"></div> 
			<br/><br/>
			<div align="center">
				<input type="text" name="idx_t" value=""/>
				<input type="text" name="proname_t" value=""/>
				<input type="text" name="nation_t" value=""/>
				<input type="text" name="count_t" value=""/>
				<input type="text" name="date_t" value=""/>
				<input type="text" name="status_t" value=""/>
			</div>
			
			</form>
			
			<img style ="display: block; margin: 0px auto;" src="https://djbooth.net/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_700/MTU1ODQ4ODEwMjg5OTY0NDg4/asap-rocky-testing-album-review.webp">
			<%
				out.println("시작 페이지 ㅣ startpage = " + startPage);
			%>
			<br/>
			<%
				out.println("전체 페이지 수 ㅣ allpage = " + allPage);
			%>
			<br/>
			<%
				out.println("현재 페이지 ㅣ pg = " + pg);
			%>
			<br/>
			<%
				out.println("블록 수 ㅣ block = " + BLOCK);
			%>
	</body> 
	
	

	<script>
		// 상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
		$("#selectBtn").click(function(){ 
			
			
			
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=user_CheckBox]:checked");
			
			// 체크된 체크박스 값을 가져온다
			checkbox.each(function(i) {

				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());
				
				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var idx = td.eq(1).text()
				var proname = td.eq(2).text();
				var nation = td.eq(3).text();
				var count = td.eq(4).text();
				var date = td.eq(5).text();
				var status = td.eq(6).text();
				
				
				/* Block.sender = proname;
				Block.recipient = nation;
				Block.amount = count; */
				
				
				
				// 가져온 값을 배열에 담는다.
				tdArr.push(idx);
				tdArr.push(proname);
				tdArr.push(nation);
				tdArr.push(count);
				tdArr.push(date);
				tdArr.push(status);
				//console.log("no : " + no);
				//console.log("userid : " + userid);
				//console.log("name : " + name);
				//console.log("email : " + email);
			});
			var str = tdArr.join(', ');
			//$("#ex3_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
			$("#ex3_Result2").html(str);	
			$('input[name=idx_t]').attr('value',tdArr[0]);
			$('input[name=proname_t]').attr('value',tdArr[1]);
			$('input[name=nation_t]').attr('value',tdArr[2]);
			$('input[name=count_t]').attr('value',tdArr[3]);
			$('input[name=date_t]').attr('value',tdArr[4]);
			$('input[name=status_t]').attr('value',jQuery.trim(tdArr[5]));
		});
	</script>
</html>



