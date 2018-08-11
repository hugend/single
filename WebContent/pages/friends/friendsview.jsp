<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" >
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); %>
	<!-- top -->
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>

	<div class="wrapper row2">
		<div id="container">
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<jsp:include page="/pages/friends/friendsmenu.jsp"/>
			
			<p align="center">Friends List</p>
			
			<ul class="w3-ul w3-card-4">
			<%--친구 목록 --%>
			<%
				ArrayList<MemberDTO> friends = (ArrayList<MemberDTO>) request.getAttribute("friends");
				if(friends!=null){
					int size = friends.size();	
					for(int i=0;i<size;i++){
			%>
				<li class="w3-bar">
					<span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
					<img src="/single/upload/<%=friends.get(i).getMe_img() %>" class="w3-bar-item w3-circle w3-hide-small" style="width: 85px">
					<div class="w3-bar-item">
						<span class="w3-large"><%=friends.get(i).getMe_name() %></span> 
						<br>
						<span><%=friends.get(i).getMe_addr() %></span> 
						<br> 
						<a href="#" data-toggle="modal" data-target="#MessageModal">쪽지 보내기</a>
					</div>
				</li>
			
			
			<%-- 쪽지 보내기 modal--%>
			<div class="modal fade" id="MessageModal" tabindex="-1" role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times; </span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Message</h4>
						</div>
						<form action="/single/msg/msg_insert.do" method="POST">
						<div class="modal-body">
							<div class="input-group">
								<span class="input-group-addon">@ 받는 사람</span> 
								<input type="text" class="form-control" placeholder="<%=friends.get(i).getMe_id() %>" name="receiver" readonly="readonly"/>
							</div>
							<p></p>
							<div class="input-group">
								<span class="input-group-addon">@ 제목</span> 
								<input type="text" class="form-control" placeholder="제목" name="msg_title" required="required"/>
							</div>
							<p></p>
							<div class="input-group">
								<span class="input-group-addon">@ 메시지</span>
								<textarea rows="4" cols="50" class="form-control" placeholder="Message" name="msg_txt" required="required"></textarea>
								<input type="hidden" name="sender" value="<%=loginUser.getMe_id()%>"/>
							</div>
						</div>

						<div class="modal-footer">
							<button type="submit" class="button btn-default" style="float: right; width: 20%">등록</button>
							<button type="button" class="button btn-default" data-dismiss="modal" style="float: right; width: 20%">취소</button>
						</div>
						</form>
					</div>
				</div>
			</div>
			<%--------------%>
			<% }}%>
			</ul>
			
		</div>
	</div>
	
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>

</body>
</html>