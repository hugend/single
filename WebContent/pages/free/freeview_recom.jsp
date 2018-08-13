<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="free.dto.FreeDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>추천게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/single/common/styles/layout.css"
	type="text/css" media="all">
<link rel="stylesheet" href="/single/common/styles/mediaqueries.css"
	type="text/css" media="all">

<!-- hs 추가 -->
<link rel="shortcut icon" href="/single/images/favicon.ico">

<link rel='stylesheet' id='kboard-skin-thumbnail-css'
	href='/single/common/styles/free/thumbnail.css?ver=5.3.9' type='text/css'
	media='all' />
<%
	ArrayList<FreeDTO> postlist = (ArrayList<FreeDTO>) request.getAttribute("postlist");
	int size = postlist.size();
	int pageNo = 0;
	if(request.getParameter("page")==null){
		pageNo = 1;
	}else{
		pageNo = Integer.parseInt(request.getParameter("page")); //현재페이지
	}
	System.out.println(pageNo);
	int prdNum = postlist.size();
	int totalPage = 0; // 총페이지수
	if(prdNum%20==0){
		totalPage = prdNum/20;
	}else{
		totalPage = prdNum/20 + 1;
	}
	int firstPage = 1; // 첫페이지
	
	if(pageNo<=5){
		firstPage = 1;
	}else if(totalPage-5<pageNo){
		firstPage = totalPage - 5;
	}else{
		firstPage = pageNo - 5;
	}
	int lastPage = totalPage;	//마지막페이지
	if(totalPage<=10){
		lastPage = totalPage;
	}else if(pageNo+5<=10){
		lastPage = 10;
	}else if(pageNo+5>=totalPage){
		lastPage = totalPage;
	}else{
		lastPage = pageNo + 5;
	}
%>
<!-- -------------------------------- -->



<script src="/single/common/scripts/jquery.min.js"></script>
<script src="/single/common/scripts/jquery-mobilemenu.min.js"></script>
</head>
<body>
	<!-- content -->
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container">
			<!-- 플로팅배너 -->
		<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); %>
		<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>

			<div id="kboard-thumbnail-list">

				<!-- 카테고리 시작 -->
 				<div class="kboard-category category-pc">
					<ul class="kboard-category-list"> 
				<li><a href="/single/fr/list.do?category=all">전체</a></li>
	            <li><a href="/single/fr/list.do?category=free">자유</a></li>
	            <li><a href="/single/fr/list.do?category=tip">정보</a></li>
	            <li><a href="/single/fr/list.do?category=review">후기</a></li>
						<li  class="kboard-category-selected"><a href="/single/fr/list.do?category=recom">추천</a></li>
					</ul>
				</div>
				<!-- 카테고리 끝 -->
				<!-- 리스트 시작 -->
				<div class="kboard-list">
					<table>
						<thead>
							<tr>
								<td class="kboard-list-uid">번호</td>
								<td class="kboard-list-title">제목</td>
								<td class="kboard-list-user">작성자</td>
								<td class="kboard-list-date">작성일</td>
								<td class="kboard-list-view">조회</td>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < size; i++) {
									FreeDTO post = postlist.get(i);
									if(post.getMe_id().equals("single")){
							%>

							<tr class="kboard-list-notice">
								<td class="kboard-list-uid"><%=post.getFr_no()%></td>
								<td class="kboard-list-title"><a href="/single/fr/read.do?no=<%=post.getFr_no()%>&action=read">
										<div class="kboard-thumbnail-cut-strings">
											<span class="admin"> <%=post.getFr_title()%> </span> <span class="kboard-comments-count">(<%=post.getCmtcount()%>)</span>
										</div>
								</a>
								</td>
								<td class="kboard-list-user">관리자</td>
								<td class="kboard-list-date"><%=post.getFr_date()%></td>
								<td class="kboard-list-view"><%=post.getFr_hits()%></td>
							</tr>

							<%
								} else {
							%>

							<tr class="">
								<td class="kboard-list-uid"><%=post.getFr_no()%></td>

								<td class="kboard-list-title"><a
									href="/single/fr/read.do?no=<%=post.getFr_no()%>&action=read">
										<div class="kboard-thumbnail-cut-strings">
											<%=post.getFr_title()%>
											<span class="kboard-comments-count">(<%=post.getCmtcount()%>)</span>
										</div>
								</a> </td>
								<td class="kboard-list-user"><%=post.getMe_id()%></td>
								<td class="kboard-list-date"><%=post.getFr_date()%></td>
								<td class="kboard-list-view"><%=post.getFr_hits()%></td>
							</tr>
							<%
								}
								}
							%>

						</tbody>
					</table>
				</div>
				<!-- 리스트 끝 -->

				<!-- 페이징 시작 -->
				<div class="pagination">
					<ul>
						<li class="prev">
						<%if(pageNo==1){ %>
							&laquo; Previous
						<%}else{ %>
							<a href="/single/fr/list.do?category=recom&page=<%=pageNo-1%>">&laquo; Previous</a>
						<%} %>
						</li>
							<%for(int i=firstPage;i<=lastPage;i++){ 
								if(i==pageNo){%>
								<li class="current"><strong><%=i %></strong></li>
								<%}else{ %>
								<li><a href="/single/fr/list.do?category=recom&page=<%=i%>"><%=i %></a></li>
							<%}} %>
						<li class="next">
						<%if(pageNo==totalPage){ %>
							Next &raquo;
						<%}else{ %>
							<a href="/single/fr/list.do?category=recom&page=<%=pageNo+1 %>">Next &raquo;</a>
						<%} %>
						</li>
					</ul>
				</div>
				<!-- 페이징 끝 -->

				<!-- 검색폼 시작 -->
				<div class="kboard-search">
					<form id="kboard-search-form-1" method="get" action="/single/fr/search.do">
						<select name="column">
							<option value="">전체</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="writer">작성자</option>
						</select> <input type="text" name="search" value="">
						<button type="submit" class="kboard-thumbnail-button-small">검색</button>
					</form>
				</div>
				<!-- 검색폼 끝 -->
				<!-- 버튼 시작 -->
				<%if(loginUser!=null  && loginUser.getMe_black()<10){ %>
				<div class="kboard-control">
					<a href="/single/pages/free/freeview_write.jsp" class="kboard-thumbnail-button-small">글쓰기</a>
				</div>
				<%} %>
				<!-- 버튼 끝 -->
				<!-- ########################################################################################## -->
			</div>
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