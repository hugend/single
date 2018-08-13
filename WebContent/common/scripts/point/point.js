$(document).ready(function(){
	$("#buyBtn").on("click", function(){
			var userid = $("#userid").val();
			var po_no = $("#po_no").val();
		 	if(userid==""){
				alert("로그인해주세요");
			}else{
				location.href="/single/po/buy.do?userid="+userid+"&po_no="+po_no;
			} 
	});
});
window.onload = function(){
	if($("#state").val()==0){
		alert("포인트가 부족합니다.");
		document.getElementById("#state").value = "";
	}else if($("#state").val()==1){
		alert("구매가 완료되었습니다.");
		document.getElementById("#state").value = "";
	}
}