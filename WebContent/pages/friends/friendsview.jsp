<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" >
	<title>Manage Friends</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/single/common/styles/layout.css" type="text/css" media="all">
	<link rel="stylesheet" href="/single/common/styles/mediaqueries.css" type="text/css" media="all">
	<script src="/single/common/scripts/jquery.min.js"></script>
	<script src="/single/common/scripts/jquery-mobilemenu.min.js"></script>
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<style type="text/css">
  	.button{
    	color: white;
    	padding: 12px 20px;
    	border: none;
    	border-radius: 4px;
    	cursor: pointer;
    	float: right;
    	margin: 5px;
	}
  	</style>
</head>
<body>
	<% 
		MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
	%>
	<!-- top -->
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container">
			<%
				if (loginUser != null) {
					ArrayList<MemberDTO> friends = (ArrayList<MemberDTO>) request.getAttribute("friends");
			%>
			<jsp:include page="/pages/template/floatingmenu.jsp" />

			<jsp:include page="/pages/friends/friendsmenu.jsp" />
			<!-- <p align="center">Friends List</p> -->
			<ul class="w3-ul w3-card-2">
				<%--친구 목록 --%>
				<%
						if (friends != null) {
							int size = friends.size();
							MemberDTO friend=null;
							for (int i=0; i<size; i++) {
								friend = friends.get(i);
				%>
				<li class="w3-bar list-group-item">
					<a href="/single/friends/delete.do?id=<%=loginUser.getMe_id()%>&bd_id=<%=friend.getMe_id()%>" onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-xlarge w3-right">×</a>
					<img src="/single/upload/<%=friend.getMe_img() %>" class="col-sm-4 img-circle" style="width: 100px;height: 85px">
					<div class="w3-bar-item">
						<span class="w3-large"><%=friend.getMe_name()%></span> <%=friend.getMe_id() %><br>
						<span><%=friend.getMe_addr()%></span> <br> 
						<a href="#" data-toggle="modal" data-target="#MessageModal<%=friend.getMe_id() %>">쪽지	보내기</a>
					</div>
				</li>
				
				<%-- 쪽지 보내기--%>
				<div class="modal fade" id="MessageModal<%=friend.getMe_id() %>" tabindex="-1" role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">Send Message</h4>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times; </span><span class="sr-only">Close</span>
								</button>
							</div>
							<form action="/single/msg/msg_insert.do" method="POST">
								<div class="modal-body">
									<div class="input-group">
										<span class="input-group-addon">@ 받는 사람</span> 
										<input type="text" class="form-control" placeholder="<%=friend.getMe_id()%>" readonly="readonly" />
										<input type="hidden" name="receiver" value="<%=friend.getMe_id()%>"/>
									</div>
									<p></p>
									<div class="input-group">
										<span class="input-group-addon">@ 제목</span> 
										<input type="text" class="form-control" placeholder="제목" name="msg_title" required="required" />
									</div>
									<p></p>
									<div class="input-group">
										<span class="input-group-addon">@ 메시지</span>
										<textarea rows="8" cols="50" class="form-control" placeholder="Message" name="msg_txt" required="required"></textarea>
										<input type="hidden" name="sender" value="<%=loginUser.getMe_id()%>" />
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
				<% }} %>
			</ul>
			<%} %>
		</div>
	</div>

	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>