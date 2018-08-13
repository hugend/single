<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Single 회원탈퇴</title>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="/single/common/styles/member/withdrawal.css" rel="stylesheet">
<script src="/single/common/scripts/member/withdrawal.js"></script>
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
				<h1>회원탈퇴</h1>
		</div>
		<form class="form-horizontal" action="/single/memberwithdrawal.do" method="get" name="myform" 
		onsubmit="return agreeCheck()">
			<div>
				<h2>탈퇴 안내</h2>
				<h3>회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</h3>
			</div>
			<div class="section_delete">
				<p> 1. 사용하고 계신 아이디(아이디)는 탈퇴할 경우 재사용 및 복구가 불가능합니다.</p>
				<p> <em>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</em>하오니 신중하게 선택하시기 바랍니다.</p>
				<p> 2. 탈퇴 후에도 게시판형 서비스에 등록한 게시물 및 댓글은 그대로 남아 있습니다.</p>
				<p> 삭제를 원하는 게시글및 댓글이 있다면 <em>반드시 탈퇴 전 삭제하시기 바랍니다.</em></p>
				<p> 탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다. </p>
				<input type="checkbox" id="dropoutAgree" name="dropoutAgree" value="agree">
				<label for="dropoutAgree"><strong>안내 사항을 모두 확인하였으며, 이에 동의합니다.</strong></label>
			</div>
		<button class="btn btn-danger pull-right" type="submit" id="updatebtn"><i class="glyphicon glyphicon-remove">회원탈퇴</i></button>
		</form>
	</div>
</div>

<div class="wrapper row3">
	<jsp:include page="/pages/template/Footer.jsp" />
</div>
</body>
</html>