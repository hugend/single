<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보</title>
<link href="/single/common/styles/member/info.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="shortcut icon" href="/single/images/favicon.ico">
</head>
<body>
<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); %>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container" class="container bootstrap snippet">
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<div class="page-header">
				<h1>회원정보</h1>
			</div>
			<div class="row">
				<div class="col-sm-10">
					<h1><%=loginUser.getMe_id() %></h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<!--left col-->
					<div class="text-center">
						<img src="/single/upload/<%=loginUser.getMe_img() %>" class="avatar img-circle img-thumbnail">
					</div>
					<hr/>
					<br>

					<ul class="list-group">
						<li class="list-group-item text-muted">소모임<i
							class="fa fa-dashboard fa-1x"></i></li>
						<li class="list-group-item text-right"><span
							class="pull-left"><strong><a href="">구로1동</a></strong></span>5</li>
						<li class="list-group-item text-right"><span
							class="pull-left"><strong><a href="">양파나눔</a></strong></span>3</li>
						<li class="list-group-item text-right"><span
							class="pull-left"><strong><a href="">축제</a></strong></span>7</li>
					</ul>

					<div class="panel panel-default">
						<div class="panel-heading">Social Media</div>
						<div class="panel-body">
							<i class="fa fa-facebook fa-2x"></i> <i
								class="fa fa-github fa-2x"></i> <i class="fa fa-twitter fa-2x"></i>
							<i class="fa fa-pinterest fa-2x"></i> <i
								class="fa fa-google-plus fa-2x"></i>
						</div>
					</div>

				</div>
				<!--/col-3-->
				<div class="col-sm-9">
					<div class="tab-content">
						<div class="tab-pane active" id="home">
							<hr>
							<form class="form" action="##" method="post"
								id="registrationForm">
								<div class="form-group">
									<div class="col-xs-6">
										<div>
											<label class="info">성명</label>
										</div>
										<p><%=loginUser.getMe_name() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<div>
											<label class="info">생년월일</label>
										</div>
										<p><%=loginUser.getMe_birth() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">성별</label>
										</div>
										<p><%=loginUser.getMe_gender() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">전화번호</label>
										</div>
										<p><%=loginUser.getMe_phone() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">비상연락처</label>
										</div>
										<p><%=loginUser.getMe_telnum() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">비상연락설정</label>
										</div>
										<p><%=loginUser.getMe_telchk() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">Email</label>
										</div>
										<p><%=loginUser.getMe_email() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">주소</label>
										</div>
										<p><%=loginUser.getMe_addr() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">포인트</label>
										</div>
										<p><%=loginUser.getMe_point() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">누적포인트</label>
										</div>
										<p><%=loginUser.getMe_points() %></p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">회원등급</label>
										</div>
										<p>
										<%if(loginUser.getMe_points()<100){%>
										준회원
										<%}else if(loginUser.getMe_points()<500){%>
										정회원
										<%}else if(loginUser.getMe_points()>=500){%>
										우수회원
										<%}else if(loginUser.getMe_black()>=10){%>
										블랙리스트
										<%}else if(loginUser.getMe_id().equals("single")){ %>
										관리자
										<%} %>
										</p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">성향</label>
										</div>
										<%if(loginUser.getMe_character()!=null){ %>
										<p><%=loginUser.getMe_character() %> </p>
										<%}else{ %>
										<p> - </p>
										<%} %>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<hr />
										<div>
											<label class="info">블랙리스트신고횟수</label>
										</div>
										<p><%=loginUser.getMe_black() %></p>
									</div>
								</div>
							<hr>
						
							<div class="form-group">
								<div class="col-xs-12">
									<br>
									<a href="/single/pages/member/withdrawal.jsp" class="btn btn-danger pull-right"><i class="glyphicon glyphicon-remove">회원탈퇴</i></a>
									<a href="/single/memberinfo.do?action=UPDATE" class="btn btn-primary pull-right"><i class="glyphicon glyphicon-edit">회원정보수정</i></a>
								</div>
							</div>
						</form>
					</div>
					<!--/tab-pane-->
				</div>
				<!--/tab-content-->
			</div>
			<!--/col-9-->
		</div>
		<!--/row-->
	</div>
</div>
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>