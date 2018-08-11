//비밀번호 일치확인
$(document).ready(function(){
	$("#pwdChk").on("keyup",function(){
		if((myform.me_pwd.value)==(myform.pwdChk.value)){
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치합니다";
		}else{
			document.getElementById("pwMsg").innerHTML = "비밀번호가 일치하지 않습니다. 다시 확인해 주세요.";
		}
	});
	$("#pass").on("keyup",function(){
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
	            $("#phone").keydown(function (event) {
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
	         $("#telnum").keydown(function (event) {
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


//비밀번호일치여부 확인
function update(){
	if(document.myform.me_pwd.value==document.myform.pwdChk.value){
		return true;
	}else{
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
}
