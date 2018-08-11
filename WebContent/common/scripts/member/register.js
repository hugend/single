//달력, 생년월일
$(function() {
	$.datepicker.setDefaults({
		closeText : "닫기",
		prevText : "이전달",
		nextText : "다음달",
		currentText : "오늘",
		monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)', '5월(MAY)',
				'6월(JUN)', '7월(JUL)', '8월(AUG)', '9월(SEP)', '10월(OCT)',
				'11월(NOV)', '12월(DEC)' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShot : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],

		changeMonth : true, // 월 변경가능
		changeYear : true, // 년 변경가능
		showMonthAfterYear : true, // 년 뒤에 월 표시
		dateFormat : "yy/mm/dd", // 년월일 표시방법
		firstDay : 1, // 0: 일요일 부터 시작, 1:월요일 부터 시작
		autoSize : true, // default: false, input 사이즈를 자동으로 리사이즈.
		showAnim : "fold", // default: show , fold
		showWeek : false, // 주차 = true : 보이기 / false : 숨기기
		weekHeader : "주차", // default: Wk, 주차 헤드 부분의 명칭 설정
		showButtonPanel : true, // 하단에 Today, Done 버튼 Display
		gotoCurrent : false, // default: false, true일 경우에는 Today버튼 클릭 시 현재
								// 일자로 이동하지 못함
	});
	$("#datepicker").datepicker();
});

//비밀번호 일치확인
$(document).ready(function(){
	$("#pwdChk").on("keyup",function(){
		if((myform.me_pwd.value)==(myform.pwdChk.value)){
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치합니다";
		}else{
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치하지 않습니다. 다시 확인해 주세요.";
		}
	});
	$("#me_pwd").on("keyup",function(){
		if((myform.me_pwd.value)==(myform.pwdChk.value)){
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치합니다";
		}else{
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치하지 않습니다. 다시 확인해 주세요.";
		}
	});
});

//전화번호 자동하이픈
$(document).ready(function () {
	   $(function () {
	            $("#me_phone").keydown(function (event) {
	             var key = event.charCode || event.keyCode || 0;
	             $text = $(this); 
	             if (key !== 8 && key !== 9) {
	                 if ($text.val().length === 3) {
	                     $text.val($text.val() + '-');
	                 }
	                 if ($text.val().length === 8) {
	                     $text.val($text.val() + '-');
	                 }
	             }
	             return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
	         })
	         $("#me_telnum").keydown(function (event) {
	             var key = event.charCode || event.keyCode || 0;
	             $text = $(this); 
	             if (key !== 8 && key !== 9) {
	                 if ($text.val().length === 3) {
	                     $text.val($text.val() + '-');
	                 }
	                 if ($text.val().length === 8) {
	                     $text.val($text.val() + '-');
	                 }
	             }
	             return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
	         })
	   });
});
//아이디 중복확인
var xhr
var idInfo
function IdCheck() {
	//alert("test");
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = idCheckMsg;
	
	xhr.open("POST","/single/idcheck.do",true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("id="+myform.me_id.value);
}
function idCheckMsg() {
	if(xhr.readyState==4&&xhr.status==200){
		if(xhr.responseText==1){
			document.getElementById("idChk").innerHTML = "사용가능한 아이디입니다.";
		}else{
			document.getElementById("idChk").innerHTML = xhr.responseText;
		}
		idInfo = xhr.responseText;
	}
}

//이메일 유효성검사 및 창 띄우기
function emailcheck(me_email) {
	// 유효성 검사
	if (!myform.me_email.value) {
		alert("이메일을 확인해주세요");
		myform.me_email.focus();
		return;
	}
	// 인증을 위해 새창으로 이동
	var url = "/single/pages/member/emailCheck.jsp?me_email=" + me_email;
	open(url, "emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200");
}

//이메일인증
function confirmemail(emailconfirm_value, authNum){
    // 입력한 값이 없거나, 인증코드가 일치하지 않을 경우
	if(!emailconfirm_value || emailconfirm_value != authNum){
		alert("인증번호가 일치하지않습니다.");
		emailconfirm_value="";
		self.close();
    // 인증코드가 일치하는 경우
	}else if(emailconfirm_value==authNum){
		alert("인증되었습니다.");
		emailconfirm_value="";
		opener.setOk(1);
		self.close();
	}
}
myok=0;
function setOk(ok){
 myok = ok;
}
//회원가입 위치정보받기 + 비밀번호일치하지 않으면 회원가입 안됨 + 중복된 아이디도 회원가입안됨 + 이메일인증해야함.
function join(){
	if(idInfo==1){
		if(document.myform.me_pwd.value==document.myform.pwdChk.value){
			if(myok==1){
				// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
				if (navigator.geolocation) {
				    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
				    navigator.geolocation.getCurrentPosition(function(position) {
				        lat = position.coords.latitude; // 위도
				        lon = position.coords.longitude; // 경도
				       	document.getElementById("lat").value = lat;
				       	document.getElementById("lon").value = lon;
				       	alert("회원가입 완료");
				    	document.myform.submit();
				      });
				} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
					   	lat = 33.450701; // 위도
				       	lon = 126.570667; // 경도
				    	document.getElementById("lat").value = lat;
				       	document.getElementById("lon").value = lon;
				     	alert("회원가입 완료");
				    	document.myform.submit();
				}
				return false;
			}else{
				alert("이메일인증을 완료해주세요");
				return false;
			}
		}else{
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	}else{
		alert("이미 존재하는 아이디입니다.");
		return false;
	}
}



