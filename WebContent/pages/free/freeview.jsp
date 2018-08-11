<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="free.dto.FreeDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Single Single</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- free 추가 -->
<link rel='stylesheet' id='kboard-skin-thumbnail-css'
	href='/single/common/styles/free/thumbnail.css?ver=5.3.9'
	type='text/css' media='all' />
<%
	ArrayList<FreeDTO> postlist = (ArrayList<FreeDTO>) request.getAttribute("postlist");
	int size = postlist.size();
	
	String pageNo = request.getParameter("page");
	int crtpage = 1;
	if(pageNo!=null){
		crtpage = Integer.parseInt(pageNo);	//현재 페이지
	}
%>
<link rel="shortcut icon" href="/single/images/favicon.ico">

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
						<li class="kboard-category-selected"><a href="/single/fr/list.do?category=all">전체</a></li>
						<li><a href="/single/fr/list.do?category=free">자유</a></li>
	         		   <li><a href="/single/fr/list.do?category=tip">정보</a></li>
	         		   <li><a href="/single/fr/list.do?category=review">후기</a></li>
	          		   <li><a href="/single/fr/list.do?category=recom">추천</a></li>
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
							%>

						</tbody>
					</table>
				</div>
				<!-- 리스트 끝 -->

				<!-- 페이징 시작 -->
				<div class="kboard-pagination">
					<ul class="kboard-pagination-pages">
						<li class="active"><a href="#" onclick="return false">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">7</a></li>
						<li><a href="#">8</a></li>
						<li><a href="#">9</a></li>
						<li><a href="#">10</a></li>
						<li class="next-page"><a href="#">→</a></li>
						<li class="last-page"><a href="#">마지막</a></li>
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
							<%if(loginUser!=null){ %>
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
