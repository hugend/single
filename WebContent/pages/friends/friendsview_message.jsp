<%@page import="member.dto.MemberDTO"%>
<%@page import="friends.dto.MsgDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" >
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>\
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
			
			<jsp:include page="/pages/friends/friendsmenu.jsp"/>
			
			<p align="center">Message List</p>
			
			<%
				String option = (String) request.getParameter("option");
				ArrayList<MsgDTO> msgs = (ArrayList<MsgDTO>) request.getAttribute("msgs");
				int size = msgs.size();	
			%>
			
			<%--보낸쪽지--%>
			<%
				if(option.equals("send")){
			%>
			<div class="panel panel-default widget">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span> &nbsp;&nbsp;
					Send Message
					<span class="label label-default" id="cmtNum" style="float: right;"><%=size %></span>
				</div>
				<%
					if(msgs!=null){
						for(int i=0;i<size;i++){
				%>
				<div class="panel-body">
					<ul class="list-group">
						<li class="w3-bar list-group-item">
						<form action="/single/msg/msg_delete.do">
							<div class="w3-bar-item">
								<span class="w3-large" style="display:inline-block; width:100px;" ><%=msgs.get(i).getReceiver() %></span> 
								<%=msgs.get(i).getMsg_title() %><br/>
								<span style="display:inline-block; width:100px;"></span> 
								<%=msgs.get(i).getMsg_txt() %>
							</div>
							<div class="action" style="float: right;">
								<!-- <button type="button" class="btn btn-primary btn-xs" title="Edit">
									<span class="glyphicon glyphicon-pencil">&nbsp;답장</span>
								</button> -->
								<button type="submit" class="btn btn-danger btn-xs" title="Delete" >
									<span class="glyphicon glyphicon-trash">&nbsp;삭제</span>
								</button>
								<input type="hidden" name="msg_no" value="<%=msgs.get(i).getMsg_no()%>" />
								<input type="hidden" name="option" value="send" />
							</div>
						</form>
						</li>
					</ul>

				</div>
				<%
					}}
				%>
			</div>
			<%} %>
			
			<%--받은쪽지--%>
			<%
				if(option.equals("receive")){
			%>
			<div class="panel panel-default widget">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span> &nbsp;&nbsp; 
					Receive Message 
					<span class="label label-default" id="cmtNum" style="float: right;"><%=size%></span>
				</div>
				<%
					if(msgs!=null){
						for(int i=0;i<size;i++){
				%>
				<div class="panel-body">
					<ul class="list-group">
						<li class="w3-bar list-group-item">
						<form action="/single/msg/msg_delete.do">
							<div class="w3-bar-item">
								<span class="w3-large" style="display:inline-block; width:100px;" ><%=msgs.get(i).getSender() %></span> 
								<%=msgs.get(i).getMsg_title() %><br/>
								<span style="display:inline-block; width:100px;"></span> 
								<%=msgs.get(i).getMsg_txt() %>
							</div>
							<div class="action" style="float: right;">
								<!-- <button type="button" class="btn btn-primary btn-xs" title="Edit">
									<span class="glyphicon glyphicon-pencil">&nbsp;답장</span>
								</button> -->
								<button type="submit" class="btn btn-danger btn-xs" title="Delete" >
									<span class="glyphicon glyphicon-trash">&nbsp;삭제</span>
								</button>
								<input type="hidden" name="msg_no" value="<%=msgs.get(i).getMsg_no()%>" />
								<input type="hidden" name="option" value="receive" />
							</div>
						</form>
						</li>
					</ul>

				</div>
				<%}} %>
			</div>
			<%}} %>
			</div>
		</div>
	
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>

</body>
</html>