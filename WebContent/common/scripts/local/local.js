var href;
function selectArea(myform) {
	index = myform.area.selectedIndex;
	location.href="/single/local/list.do?areaCode="+myform.area.options[index].value+"&page=1";
}
