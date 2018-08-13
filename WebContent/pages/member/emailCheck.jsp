<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="member.controller.EmailConfirm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>인증번호를 입력하세요</title>
<script src="/single/common/scripts/member/register.js"></script>
</head>
<body>
<%
	String me_email=request.getParameter("me_email");
	// 위에서 작성한 java파일 객체 생성
	EmailConfirm emailconfirm = new EmailConfirm();
	String authNum=emailconfirm.connectEmail(me_email);
%>
<form method="post" action="register.jsp" name="emailcheck">
	<table>
		<tr>
			<th colspan="2">인증번호를 입력하세요.</th>
		</tr>
		<tr>
			<td>
				<input type="text" name="emailconfirm">
			</td>
			<td>
				<input type="button" value="확인" 
                 onclick="confirmemail(emailcheck.emailconfirm.value, <%=authNum%>)">
			</td>
		</tr>
	</table>
</form>
</body>
</html>