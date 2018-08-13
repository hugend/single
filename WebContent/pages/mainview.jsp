<%@page import="local.dto.LeDTO"%>
<%@page import="vs.dto.VsDTO"%>
<%@page import="point.dto.PointDTO"%>
<%@page import="mate.dto.MateDTO"%>
<%@page import="free.dto.FreeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.controller.MainBoard"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>singlesingle</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="EUC-KR">
<link rel="stylesheet" href="/single/common/styles/main/main.css" media="screen">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); 
	MainBoard board = new MainBoard();
	ArrayList<LeDTO> eventlist = board.leList();
	ArrayList<MateDTO> matelist = board.MateList();
	ArrayList<FreeDTO> freelist = board.FreeList();	
	ArrayList<VsDTO> vslist = board.VsList();
	ArrayList<PointDTO> pointlist = board.PointList();
	// int eventsize = eventlist.size();
	int matesize = matelist.size();
	int freesize = freelist.size();
	int vssize = vslist.size();
	int pointsize = pointlist.size();
	%>
	<!-- top -->
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
		<section id="shout" class="clear">
			<figure>
				<div>
					<img src="/single/images/demo/410x440.gif" alt="">
				</div>
					<article class="one_half last">
						<h2>What People Say About Us</h2>
							<blockquote>
							Justoid nonummy laoreet phasellent
							penatoque in antesque pellus elis eget tincidunt. 
							</blockquote>
					</article>
			</figure>
		</section>
	</div>

	<!-- content -->
	<div class="wrapper row2">
		<div id="container">
			<!-- 플로팅배너 -->
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Wrapper for slides -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<%-- <%
						if(eventsize==0){
							
						}else{ 
							for(int i=0; i<eventsize; i++){ 
						LeDTO event = eventlist.get(i);
						if(i==0){%>
						<div class="item active">
						<%}else{ %>
						<div class="item">
						<%} %>
							<a href="http://korean.visitkorea.or.kr/kor/bz15/where/festival/festival.jsp?cid=<%=event.getLe_cid()%>">
							<img src="/single/images/main/<%=event.getLe_img() %>" style="width: 1200px; height: 500px;">
							</a>
							<div class="carousel-caption">
								<h3><%=event.getLe_title() %></h3>
								<p><%=event.getLe_start() %>~<%=event.getLe_end() %></p>
								<p><%=event.getLe_addr1() %></p>
								<p><%=event.getLe_addr2() %></p>
							</div>
						</div>
					<%}} %> --%>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

			<!-- main content -->
			<hr />
			<div>
				<div class="col-sm-6">
					<div class="panel panel-primary" style="border-color: #edeef1;">
						<div class="panel-footer">메이트</div>
						<div style="padding-top: 20px; padding-left: 10px">
						<table style="border: none;">
							<thead>
								<tr>
									<td class="kboard-list-title">제목</td>
									<td class="kboard-list-date">작성일</td>
									<td class="kboard-list-view">조회</td>
								</tr>
							</thead>
							<tbody>
									<%if(matesize==0) {%>
									<tr>
									<td style="border: none;">등록된 게시물이 존재하지 않습니다.</td>
									<td style="border: none;"></td>
									<td style="border: none;"></td>
									</tr>
									<%}else{ 
										for(int i=0;i<matesize;i++){
											MateDTO mate=matelist.get(i);
											if(i>4){break;}%>
											<tr>
											<td style="border: none;"><a href="/single/mt/read.do?mt_no=<%=mate.getMt_no()%>"><%=mate.getMt_title() %></a></td>
											<td style="border: none;"><%=mate.getMt_date() %></td>
											<td style="border: none;"><%=mate.getMt_hits() %></td>
											</tr>
										<% } 
									} %>
							</tbody>
						 </table>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="panel panel-primary" style="border-color: #edeef1;">
						<div class="panel-footer">자유게시판</div>
						<div style="padding-top: 20px; padding-left: 10px">
						<table style="border: none;">
							<thead>
								<tr >
									<td class="kboard-list-title">제목</td>
									<td class="kboard-list-date">작성일</td>
									<td class="kboard-list-view">조회</td>
								</tr>
							</thead>
							<tbody>
									<%if(freesize==0) {%>
									<tr>
									<td style="border: none;">등록된 게시물이 존재하지 않습니다.</td>
									<td style="border: none;"></td>
									<td style="border: none;"></td>
									</tr>
									<%}else{ 
										for(int i=0;i<freesize;i++){
											FreeDTO free=freelist.get(i);
											if(i>4){break;}%>
											<tr>
											<td style="border: none;"><a href="/single/fr/read.do?no=<%=free.getFr_no()%>&action=read">[전체]<%=free.getFr_title() %></a></td>
											<td style="border: none;"><%=free.getFr_date() %></td>
											<td style="border: none;"><%=free.getFr_hits() %></td>
											</tr>
										<% } 
									} %>
							</tbody>
						 </table>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="col-sm-6">
					<div class="panel panel-primary" style="border-color: #edeef1;">
						<div class="panel-footer">VS게시판</div>
						<div style="padding-top: 20px; padding-left: 10px">
						<table style="border: none;">
							<thead>
								<tr>
									<td class="kboard-list-title">제목</td>
									<td class="kboard-list-date">작성일</td>
								</tr>
							</thead>
							<tbody>
									<%if(vssize==0) {%>
									<tr>
									<td style="border: none;">등록된 게시물이 존재하지 않습니다.</td>
									<td style="border: none;"></td>
									</tr>
									<%}else{ 
										for(int i=0;i<vssize;i++){
											VsDTO vs= vslist.get(i);
											if(i>4){break;}%>
											<tr>
											<td style="border: none;"><a href="/single/vs/vs_read.do"><%=vs.getVs_title() %></a></td>
											<td style="border: none;"><%=vs.getVs_date() %></td>
											</tr>
										<% } 
									} %>
							</tbody>
						 </table>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="panel panel-primary" style="border-color: #edeef1;">
						<div class="panel-footer">포인트마켓</div>
						<div style="padding-top: 20px; padding-left: 10px">
						<table style="border: none;">
							<thead>
								<tr>
									<td class="kboard-list-title">제목</td>
									<td class="kboard-list-date">작성일</td>
									<td class="kboard-list-date">포인트</td>
								</tr>
							</thead>
							<tbody>
									<%if(pointsize==0) {%>
									<tr>
									<td style="border: none;">등록된 게시물이 존재하지 않습니다.</td>
									<td style="border: none;"></td>
									<td style="border: none;"></td>
									</tr>
									<%}else{ 
										for(int i=0;i<pointsize;i++){
											PointDTO point= pointlist.get(i);
											if(i>4){break;}%>
											<tr>
											<td style="border: none;"><a href="/single/po/read.do?po_no=<%=point.getPo_no()%>"><%=point.getPo_title() %></a></td>
											<td style="border: none;"><%=point.getPo_date() %></td>
											<td style="border: none;"><%=point.getPo_pt() %></td>
											</tr>
										<% } 
									} %>
							</tbody>
						 </table>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="clear"></div>
		</div>
	</div>
	</div>
	<!-- Copyright -->
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>