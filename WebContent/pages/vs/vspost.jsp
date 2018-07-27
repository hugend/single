<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/single/common/styles/layout.css" type="text/css" media="all">
	<link rel="stylesheet" href="/single/common/styles/mediaqueries.css" type="text/css" media="all">
	<link rel="stylesheet" href="/single/common/styles/vs/vspost.css">
</head>
<body>

	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>

	<div class="wrapper row2">

		<div class="container">
			<jsp:include page="/pages/template/floatingmenu.jsp" />

			<form action="/single/vs_insert.do" method="POST" name="myform">
				<div class="row">
					<div class="col-25">
						<label for="title">Title</label>
					</div>
					<div class="col-75">
						<input type="text" id="vs_title" name="vs_title" placeholder="제목">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="optionA">A 선택</label>
					</div>
					<div class="col-75">
						<input type="text" id="vs_optionA" name="vs_optionA" placeholder="A">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="optionB">B 선택</label>
					</div>
					<div class="col-75">
						<input type="text" id="vs_optionB" name="vs_optionB" placeholder="B">
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="lname">Content</label>
					</div>
					<div class="col-75">
						<textarea id="vs_txt" name="vs_txt" placeholder="Write something.." style="height: 200px"></textarea>
					</div>
				</div>

				<div class="row">
					<input type="submit" value="Submit">
				</div>
			</form>
		</div>


	</div>


	<!-- Copyright -->
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>

</body>
</html>
