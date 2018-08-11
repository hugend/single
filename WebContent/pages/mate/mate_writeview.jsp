<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/single/common/scripts/jquery.min.js"></script>
	<script src="/single/common/scripts/jquery-mobilemenu.min.js"></script>
	<script type="text/javascript">
	function map(){
		window.open('/single/pages/mate/mate_mapview.jsp','mapwindow','location=no, directories=no, resizable=no,status=no,toolbar=no,menubar=no, width=600,height=500,left=0, top=0, scrollbars=yes');
	}
	
	</script>
	
	<style>
	btndiv{width: 100%; text-align: center; margin: 0 auto;}
	
	</style>
</head>
<body>
<% MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); 
	String me_id = loginUser.getMe_id();
	String me_loc = loginUser.getMe_loc();
%>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container">
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<!-- ################################################################################################ -->
			<h1>소모임만들기</h1>
			<hr/>
			<form action="/single/mt/insert.do" method="post" name="myform">
				<input type="hidden" name="me_id" value="<%=me_id%>"/>
				<table border="1">
					<tr>
						<td>소모임이름</td>
						<td><input type="text" name="mt_title" size="40" value="">
						</td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td><select name="mt_ctg">
								<option>동네친구</option>
								<option>밥친구</option>
						</select></td>
					</tr>
					<tr>
						<td>지역</td><!-- 새창열기로 마커로 찍어서 주소등록 -->
						<td>
							<a href='#' id="ajaxbtn" onclick="map()">
							지역선택</a>
							<input type="hidden" name="mt_lat" id="latval"/>
							<input type="hidden" name="mt_lng" id="lngval"/>
							<input type="text" name="mt_map" id="result">
							<input type="hidden" name="mt_loc" id="loc_result">
							
					 
						</td>
					</tr>
					<tr>
						<td>인원</td>
						<td><select name="mt_cnt">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
						</select></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="mt_img"></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="mt_file"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="mt_txt" cols="100" rows="8"></textarea></td>
					</tr>
				</table>
				<div id="btndiv">
					<button type="button" class="btn btn-danger" onclick="history.back()">취소</button>
					<button type="submit" class="btn btn-danger">등록</button>
				</div>	
			</form>

			<!-- ################################################################################################ -->
			<div class="clear"></div>
		</div>
	</div>
	<!-- Copyright -->
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>