<%@page import="local.dto.LocalDTO"%>
<%@page import="local.dto.EventDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- hs 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/single/common/styles/local/select.css" type="text/css" media="all">
<!-- --------------- -->
<link rel="stylesheet" href="/single/common/styles/local/local.css" type="text/css" media="all">
<script src="/single/common/scripts/jquery.min.js"></script>
<script src="/single/common/scripts/local/local.js"></script>
</head>
<body>
<%
	MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); 
	ArrayList<EventDTO> eventlist = (ArrayList<EventDTO>)request.getAttribute("eventlist");
	String pageNo = request.getParameter("page");
	int crtpage = 1;
	if(pageNo!=null){
		crtpage = Integer.parseInt(pageNo);	//현재 페이지
	}
	int size = eventlist.size();
	ArrayList<LocalDTO> locallist = (ArrayList<LocalDTO>)request.getAttribute("locallist");
	int localsize = locallist.size();
	String areaCode = request.getParameter("areaCode");
%>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<!-- content -->
	<div class="wrapper row2">
		<div id="container">
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<!-- content body -->

			<section id="gallery" class="clear">
				<figure>
					<!-- 지역 선택 select box 시작 -->
					<form name="selArea">
						<span class="styled-select">
							<select name="area" id="area" onchange="selectArea(this.form)">
								<option value="" selected>지역선택</option>
								<option value="">전체</option>
								<%for(int i=0; i<localsize; i++){
								LocalDTO local = locallist.get(i); %>
								<option value="<%=local.getCode() %>"><%=local.getName() %></option>
								<%} %>
							</select> <span class="fa fa-sort-desc"></span>
						</span>
					</form>
					<!-- 지역 선택 select box 끝 -->
					<br/>
						<%for(int i=9*(crtpage-1); i<crtpage*9; i++){ 
							if(i<size){
								EventDTO event = eventlist.get(i);%>
								<span class="eventBox col-sm-4">
									<a href="http://korean.visitkorea.or.kr/kor/bz15/where/festival/festival.jsp?cid=<%=event.getContentid() %>">
									<img src="<%=event.getFirstimage()%>"></a>
									<h4><%=event.getTitle() %></h4>
									<p>행사기간: <%=event.getEventstartdate() %>~<%=event.getEventenddate() %></p>
									<p>행사장소: <%=event.getAddr1() %></p>
								</span>
						<%}} %>
				</figure>
			</section>
			
			<div class="pagination">
			<%int countPage = 0;
				if(size%9==0){
					countPage = size/9;
				}else{
					countPage = size/9+1;
				}%>
				<ul>
					<li class="prev">
					<%if(crtpage==1){ %>
						&laquo; Previous
					<%}else{ %>
					<a href="/single/local/list.do?areaCode=<%=areaCode %>&page=<%=crtpage-1%>">&laquo; Previous</a>
					<%} %>
					</li>
					<%int lastpage = 0;
					int firstpage = 0;
					if(countPage-5<crtpage){
						firstpage = countPage-9;
					}else if(crtpage-5>=1){
						firstpage = crtpage-5;
					}else{
						firstpage = 1;
					}
					if(countPage<=10){
						lastpage = countPage;
					}else if(crtpage+5<=10){
						lastpage = 10;
					}else if(crtpage+5<=countPage){
						lastpage = crtpage+5;
					}else{
						lastpage = countPage;
					}
					%>
					<% for(int i=firstpage; i<=lastpage; i++){
						if(i==crtpage){%>
						<li class="current"><strong><%=i %></strong></li>
						<%}else{%>
						<li><a href="/single/local/list.do?areaCode=<%=areaCode %>&page=<%=i%>"><%=i %></a></li>
					<%}} %>
					<!-- 	<li class="splitter"><strong>&hellip;</strong></li> -->
					<li class="next">
					<%if(crtpage==countPage){ %>
						Next &raquo;
					<%}else{ %>
					<a href="/single/local/list.do?areaCode=<%=areaCode %>&page=<%=crtpage+1%>">Next &raquo;</a>
					<%} %>
					</li>
				</ul>
			</div>

			<!-- / content body -->
			<!-- ################################################################################################ -->
			<div class="clear"></div>
		</div>
	</div>
	<!-- Copyright -->
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>