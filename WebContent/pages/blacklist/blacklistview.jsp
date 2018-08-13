<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			%>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%
				}
			%>
			<jsp:include page="/pages/blacklist/blacklistmenu.jsp" />

			<p align="center">블랙리스트 관리</p>

			<ul class="w3-ul w3-card-4">
				<%--친구 목록 --%>
				<%
					ArrayList<MemberDTO> blacklist = (ArrayList<MemberDTO>) request.getAttribute("blacklist");
					if (blacklist != null) {
						int size = blacklist.size();
						for (int i = 0; i < size; i++) {
				%>
				<li class="w3-bar"><a type="button" href="/single/black/delete.do?id=<%=blacklist.get(i).getMe_id()%>"
					onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</a> 
				<img src="/single/upload/<%=blacklist.get(i).getMe_img()%>" class="w3-bar-item w3-circle w3-hide-small" style="width: 85px">
					<div class="w3-bar-item"> 
						<span class="w3-large"><%=blacklist.get(i).getMe_name()%> / </span> 
						<span class="w3-large"><%=blacklist.get(i).getMe_id()%></span>
						<br> <span><%=blacklist.get(i).getMe_addr()%></span> <br>
					</div>
				</li>
				<%}}%>
			</ul>
		</div>
	</div>

	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>

</body>
</html>