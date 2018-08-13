<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" >
	<title>Friends Menu</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
  	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<style type="text/css">
		li.list-group-item:hover {
			background-color: rgba(86, 61, 124, .1);
	}
	</style>
</head>
<body>
	<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); %>
	<nav class="navbar navbar-expand-lg ">
		<a href="/single/friends/list.do?me_id=<%=loginUser.getMe_id()%>">친구관리  </a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/single/friends/list.do?me_id=<%=loginUser.getMe_id()%>">친구목록</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
						쪽지 
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="/single/msg/msg_read.do?me_id=<%=loginUser.getMe_id()%>&option=receive">
							받은 쪽지
						</a> 
						<a class="dropdown-item" href="/single/msg/msg_read.do?me_id=<%=loginUser.getMe_id()%>&option=send">
							보낸 쪽지
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">쪽지 관리</a>
					</div>
				</li>
			</ul>
			<br> <br>
			<form>
				<input type="text" name="search" placeholder="name" />
				<button class="btn">Search</button>
			</form>
		</div>
	</nav>
</body>
</html>