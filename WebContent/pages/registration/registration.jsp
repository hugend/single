<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>registration</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="/single/common/styles/registration/registration.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/single/common/scripts/member/register.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ebf7b2f2c5987b5f48041fd7c1490397"></script>
</head>
<body>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container">
			<div class="page-header">
				<h1>
					회원가입 
				</h1>
			</div>
			<form class="form-horizontal" action="/single/memberinsert.do" method="POST" name="myform" onsubmit="return join()"
			enctype="multipart/form-data">
				<!-- 회원사진 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">프로필사진</label>
					<div class="col-sm-9">
						<img class="img-circle" src="/single/images/basicUser.png" id="me_img"> <input
							type="file" name="me_img"
							onchange="document.getElementById('me_img').src = window.URL.createObjectURL(this.files[0])"
							accept="upload/*">
					</div>
				</div>
				<!-- 아이디 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">아이디*</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_id" id="me_id" type="text" maxlength="12"
							placeholder="ID" onkeyup="IdCheck()" required>
						<p class="help-block" id="idChk">12자이내</p>
					</div>
					
				</div>
				<!-- 비밀번호 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">비밀번호*</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_pwd" id="me_pwd" type="password" maxlength="15"
							placeholder="Password" required>
						<p class="help-block">15자이내</p>
					</div>
				</div>
				<!-- 비밀번호확인 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">비밀번호 확인*</label>
					<div class="col-sm-6">
						<input class="form-control" name="pwdChk" id="pwdChk" maxlength="15"
							type="password" placeholder="Password Check" required>
						<p class="help-block" id="pwMsg">비밀번호를 한번 더 입력해주세요.</p>
					</div>
				</div>

				<!-- 이름 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">성명*</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_name" id="me_name" type="text"
							placeholder="Name" required>
					</div>
				</div>

				<!-- 생년월일 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">생년월일*</label>
					<div class="col-sm-6">
						<p><input class="form-control" type="text" id="datepicker" name="me_birth" required ></p>
					</div>
				</div>

				<!-- 성별 -->
				<div class="form-group">
					<label class="col-md-3 control-label">성별*</label>
					<div class="col-md-6">
						<div class="radio">
							<label> <input type="radio" name="me_gender" value="male" checked/>남자</label> 
							<label> <input type="radio" name="me_gender" value="female" />여자
							</label>
						</div>
					</div>
				</div>

				<!-- 전화번호 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">전화번호*</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_phone" maxlength="13" id="me_phone" type="text"
							placeholder="010-0000-0000" required>
						<p class="help-block">-없이입력해주세요.</p>
					</div>
				</div>

				<!-- 비상연락처 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">비상연락처*</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_telnum" maxlength="13" id="me_telnum" type="text"
							placeholder="010-0000-0000" required>
						<p class="help-block">-없이입력해주세요.</p>
					</div>
				</div>

				<!-- 비상연락 선택 -->
				<div class="form-group">
					<label class="col-md-3 control-label">비상연락설정*</label>
					<div class="col-md-6">
						<div class="radio">
							<label> <input type="radio" name="me_telchk" value="켬" checked/>켬
							</label> <label> <input type="radio" name="me_telchk" value="끔" />끔
							</label>
						</div>
					</div>
				</div>

				<!-- 이메일 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">이메일*</label>
					<div class="col-sm-4">
						<input class="form-control" name="me_email" id="me_email" type="email"
							placeholder="single@single.com" required/>
					</div>
					<div class="col-sm-2">
						<input class="btn" type="button" name="emailconfirm_btn" value="인증"
							onclick="emailcheck(myform.me_email.value)"/>
					</div>
				</div>
					
				<!-- 주소 -->
				<div class="form-group">
					<label class="col-sm-3 control-label">주소</label>
					<div class="col-sm-6">
						<input class="form-control" name="me_addr" id="me_addr" type="text"
							placeholder="주소">
						<input type="hidden" name="lat" id="lat"/>
						<input type="hidden" name="lon" id="lon"/>
					</div>
				</div>

				<!-- 성향 -->
				<div class="form-group">
					<label class="col-md-3 control-label">성향</label>
					<label class="col-md-1 control-label">관심사</label>
					<div class="col-md-4">
						<div class="checkbox">
							<label> <input type="checkbox" name="me_character" value="동네"/>동네</label> 
							<label> <input type="checkbox" name="me_character" value="음식"/>음식</label> 
							<label> <input type="checkbox" name="me_character" value="공동구매"/>공동구매</label>
							<label> <input type="checkbox" name="me_character" value="축제"/>축제</label>
							<label> <input type="checkbox" name="me_character" value="영화"/>영화</label>
							<label> <input type="checkbox" name="me_character" value="뮤지컬"/>뮤지컬</label>
							<label> <input type="checkbox" name="me_character" value="전시회"/>전시회</label>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="submit" id="BtnJoin">회원가입</button>
						<button class="btn btn-danger" type="reset">가입취소</button>
					</div>
				</div>
			</form>
		</div>
		</div>
		<div class="wrapper row3">
			<jsp:include page="/pages/template/Footer.jsp" />
		</div>
</body>
</html>