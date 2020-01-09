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
          //��� ����
          var blockChain = new Array();
             
          var blockInfo = new Object();
           
          blockInfo.sender = form.proname.value;
          blockInfo.recipient = form.proloc.value;
          blockInfo.amount = form.pronumber.value;
             
          blockChain.push(blockInfo);
          
          
          //���ü�� ������ ����
          var totalInfo = new Object();
           
          totalInfo/* .transactions */ = blockChain;
           
          var jsonInfo = JSON.stringify(totalInfo);
          console.log(jsonInfo); //������ f12������ ��忡�� confole�� Ȯ�� ����
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
            	  alert("������ �Ͼ���ϴ�.");
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

function addTran()
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



function generateBlock(){ //���� ��� ���� �Լ�
	location.href="./generateBlock.jsp";
}



function addRow(){
	 
	   mytable = document.getElementById("table1");  //���� �߰��� ���̺�
	   row = mytable.insertRow(mytable.rows.length);  //�߰��� ��

	   
	   cell1 = row.insertCell(0);  //���� �� �߰� ���⼭�� ���ڴ� �÷� ��
	   cell2 = row.insertCell(1);
	   cell3 = row.insertCell(2);

	   
       cell1.innerHTML = document.getElementsByName('proname')[0].value; //�߰��� �࿡ ���ϴ�  ����߰�
	   cell2.innerHTML = document.getElementsByName('proloc')[0].value;
	   cell3.innerHTML = document.getElementsByName('pronumber')[0].value;
	}
	
function statusChg(){
	var form = document.chkform;
	if(confirm("���¸� �����Ͻðڽ��ϱ�? index number : ")){
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
 		<title> ����ǰ ���� </title>
	</head>
 	<body>
 		<table>
			 <center>
			 
			 
				 <form name=writeform method=post action="write_ok.jsp">
				 			<br /><br /><br /><br /><br /><br /><br /><br /><br />
				 	<table border = 0 width="15%" cellpadding="0" cellspacing="0" style="margin:auto; text-align:center">
				 		<tr>
				 			<td>��ǰ��</td>
				 			<td>
				 				<input autocomplete=off list="product" id="prodname" name="proname" placeholder="����ǰ ��ǰ ��">
									<datalist id="product">
											<option value="AIR JORDAN1">AIR JORDAN1</option>
											<option value="YEEZY BOOST">YEEZY BOOST</option>
									</datalist>
							</td>
				 		</tr>
				 		<tr>
				 			<td>������</td>
				 			<td>
				 				<!-- <input autocomplete=off name="proloc" placeholder="������" /> -->
				 				<select id="prodloc" name="proloc" size=1">
										<optgroup label="ASIA">
											<option value="" selected disabled hidden> �������� �����ϼ���.</option>
											<option value="KR">KR(KOREA)</option>
											<option value="CH">CH(CHINA)</option>
										</optgroup>
									</select>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td>����</td>
				 			<td>
				 				<input autocomplete=off id="prodnumber" name="pronumber" placeholder="����ǰ ����"/>
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
	   				<input type=button value="���" OnClick ="generateBlock();">
	   				<!-- <input type=button value="����" OnClick = "javascript:statusChg();"> -->
	   				<!-- <input type=button value="json append" id="checkJson"> -->
	   				<!-- input type=button value="TESTTEST" id="selectBtn"> -->
	   				<!-- <button type="button" id="selectBtn">����</button> -->
	   				<input type="button" value="�ŷ����� �߰�" Onclick = "javascript:writeCheck();">
	   				<!-- <button type="button" value="���� ��� ����" Onclick = "javascript:generateBlock();"> ���� ��� ���� </button> -->
	   			</td>
	  		</tr>
  		<!-- <script type="text/javascript" src"./js/app.js"></script> -->
		</table>
		<br />
		
		
		
		<form name=chkform method=post action="edit.jsp">
		
		<table width="1200px" cellpadding="0" cellspacing="0" border="0" style="margin:auto; text-align:center" class="type11">
		
			<%
				final int ROWSIZE = 5; // �� �������� ���� �Խù� ��
				final int BLOCK = 5; // �Ʒ��� ���� ������ �ִ� ���� 1~5 / 6 ~ 10 / 11 ~ 15
				int pg = 1; // �⺻ ������ ��
				
				if(request.getParameter("pg") != null) { // �޾ƿ� pg ���� ���� �� .
					pg = Integer.parseInt(request.getParameter("pg")); // pg �� ����
				}
				int start = (pg*ROWSIZE) - (ROWSIZE -1); // �ش����������� ���� ��ȣ ( DB - SORT )
				int end = (pg*ROWSIZE); // �ش� ���������� �� ��ȣ ( DB - SORT )
				
				int allPage = 0; // ��ü ������ ��
				
				int startPage = ((pg-1)/BLOCK*BLOCK)+1; // ���� �� ����. 1~5���� 1, 6~10 6
				int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK; // �� �� ����. 1~5���� 5, 6~10 10
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
  					Statement stmt = conn.createStatement(); // sqlCount�� �Ҵ�.
  					Statement stmt1 = conn.createStatement(); // sql�� �Ҵ�.
  					
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
  				
  					String sql = "SELECT NO, PRODUCT_NAME, NATION, COUNT, STATUS, CREATE_DATE,SORT FROM PRODUCT WHERE SORT >= " + start + " and SORT <= " + end + " ORDER BY SORT"; //������ ���
  					rs = stmt1.executeQuery(sql);
  			%>
  			<tr>
  				<th>����</th>
				<th>��ȣ</th>
				<th>����ǰ ��</th>
				<th>������</th>
				<th>����</th>
				<th>������</th>
				<th>STATUS</th>
			</tr>
			<%
				if(total==0) {
			%>		
				<tr align="center" height="30">
					<td colspan = "6"> ��ϵ� ��ǰ�� �����ϴ�.</td>
				</tr>
			<%
				} // if ����
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
					}// while ����
				}// else ����
				rs.close();
				stmt.close();
				conn.close();
  				} //try ����
  				catch(SQLException e) {
  					out.println(e.toString());
  				}// catch ����
  			%>
  			</table>
  			
  			
  			<table width="100%" cellpadding="0" cellspacing="0" border="0">
  				<tr><td colspan="6" height="5"></td></tr>
  				<tr>
					<td align="center">
						<%
							if(pg>BLOCK) {
						%>
								[<a href="product.jsp?pg=1">����</a>]
								[<a href="product.jsp?pg=<%=startPage-1%>">��</a>]
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
							[<a href="product.jsp?pg=<%=endPage+1%>">��</a>]
							[<a href="product.jsp?pg=<%=allPage%>">����</a>]
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
				out.println("���� ������ �� startpage = " + startPage);
			%>
			<br/>
			<%
				out.println("��ü ������ �� �� allpage = " + allPage);
			%>
			<br/>
			<%
				out.println("���� ������ �� pg = " + pg);
			%>
			<br/>
			<%
				out.println("��� �� �� block = " + BLOCK);
			%>
	</body> 
	
	

	<script>
		// ��� ���ù�ư Ŭ���� üũ�� Row�� ���� �����´�.
		$("#selectBtn").click(function(){ 
			
			
			
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=user_CheckBox]:checked");
			
			// üũ�� üũ�ڽ� ���� �����´�
			checkbox.each(function(i) {

				// checkbox.parent() : checkbox�� �θ�� <td>�̴�.
				// checkbox.parent().parent() : <td>�� �θ��̹Ƿ� <tr>�̴�.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				// üũ�� row�� ��� ���� �迭�� ��´�.
				rowData.push(tr.text());
				
				// td.eq(0)�� üũ�ڽ� �̹Ƿ�  td.eq(1)�� ������ �����´�.
				var idx = td.eq(1).text()
				var proname = td.eq(2).text();
				var nation = td.eq(3).text();
				var count = td.eq(4).text();
				var date = td.eq(5).text();
				var status = td.eq(6).text();
				
				
				/* Block.sender = proname;
				Block.recipient = nation;
				Block.amount = count; */
				
				
				
				// ������ ���� �迭�� ��´�.
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
			//$("#ex3_Result1").html(" * üũ�� Row�� ��� ������ = "+rowData);	
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



