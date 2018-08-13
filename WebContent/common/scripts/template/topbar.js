function loginCheck(){
    if(!document.loginform.id.value){
        alert("아이디를 입력해주세요.");
    }else if(!document.loginform.pass.value){
    	alert("비밀번호를 입력해주세요.");
    }else{
    	login();
	}
}
function login(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = loginCallback;
	xhr.open("POST","/single/login.do",true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	info = document.loginform.id.value+","+document.loginform.pass.value;
	xhr.send("info="+info);
}
function loginCallback() {
	if(xhr.readyState==4&&xhr.status==200){
		if(xhr.responseText==1){
			
		}else{
			alert(xhr.responseText);
		}
		document.location.reload();
	}
}

function logout(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = logoutCallback;
	xhr.open("GET","/single/logout.do",true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
}
function logoutCallback() {
	if(xhr.readyState==4&&xhr.status==200){
		document.location.href="/single/pages/mainview.jsp";
	}
}

