<%@page import="mate.dto.MateCmtDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="mate.dto.MateDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>메이트</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="/single/common/scripts/jquery.min.js"></script>
	<script src="/single/common/scripts/jquery-mobilemenu.min.js"></script>
	<link rel="shortcut icon" href="/single/images/favicon.ico">
</head>
<body>
<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); %>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	<div class="wrapper row2">
		<div id="container">
			<!-- 플로팅배너 -->
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			<!-- content body -->
			
			<% MateDTO dto = (MateDTO)request.getAttribute("dto"); %>
			<h1>소모임이름</h1>
			<footer class="more">
				<a href="/single/mt_join.do?me_id=test1">참여하기 &raquo;</a>
			</footer>

			<hr />
			<!-- 작성정보 -->
			<table border="1">
					<tr>
						<td><%=dto.getMt_ctg() %></td>
						<td colspan="3"><%=dto.getMt_title() %></td>
					</tr>
					<tr>
						<td><%=dto.getMe_id() %></td>
						<td><%=dto.getMt_hits() %></td>
						<td colspan="2"><%=dto.getMt_date() %></td>
					</tr>
					<tr>
						<td colspan="4"><%=dto.getMt_txt() %></td>
					</tr>
			</table>

			<section id="portfolio" class="clear">
				<ul>
					<li>
						<article>
							<figure>
								<a href="#"><img src="/single/images/demo/225x160.gif" alt=""></a>
								<figcaption>참여자 1</figcaption>
							</figure>
						</article>
					</li>
					<li>
						<article>
							<figure>
								<a href="#"><img src="/single/images/demo/225x160.gif" alt=""></a>
								<figcaption>참여자 2</figcaption>
							</figure>
						</article>
					</li>
					<li>
						<article>
							<figure>
								<a href="#"><img src="/single/images/demo/225x160.gif" alt=""></a>
								<figcaption>참여자 3</figcaption>
							</figure>
						</article>
					</li>
					<li class="last">
						<article>
							<figure>
								<a href="#"><img src="/single/images/demo/225x160.gif" alt=""></a>
								<figcaption>참여자 4</figcaption>
							</figure>
						</article>
					</li>

				</ul>
			</section>

			<!-- 댓글######################################################################### -->
			<% ArrayList<MateCmtDTO> dtolist = (ArrayList<MateCmtDTO>)request.getAttribute("dtolist"); %>
			<section id="comments">
				<h2>댓글</h2>
				<ul>
				<% for(int i =0; i<dtolist.size(); i++){
					%>
				
					<li class="comment_odd">
						<article>
							<header>
								<figure>
									<img src="/single/images/demo/avatar.gif" width="32"
										height="32" alt="">
								</figure>
								<address>
									 <a href="#"><%=dtolist.get(i).getMe_id()%></a>
								</address>
								<time datetime="<%=dtolist.get(i).getMt_cmt_date()%>">
									<%=dtolist.get(i).getMt_cmt_date()%>
								</time>
							</header>
							<section>
								<p><%=dtolist.get(i).getMt_cmt_txt() %></p>
							</section>
						</article>
					</li>
					<% }%>
				</ul>
<!-- 					<li class="comment_even">
						<article>
							<header>
								<figure>
									<img src="/single/images/demo/avatar.gif" width="32" height="32"
										alt="">
								</figure>
								<address>
									By <a href="#">A Name</a>
								</address>
								<time datetime="2000-04-06T08:15+00:00">
									Friday, 6<sup>th</sup> April 2000 @08:15:00
								</time>
							</header>
							<section>
								<p>This is an example of a comment made on a post. You can
									either edit the comment, delete the comment or reply to the
									comment. Use this as a place to respond to the post or to share
									what you are thinking.</p>
							</section>
						</article>
					</li>
					<li class="comment_odd">
						<article>
							<header>
								<figure>
									<img src="/single/images/demo/avatar.gif" width="32" height="32"
										alt="">
								</figure>
								<address>
									By <a href="#">A Name</a>
								</address>
								<time datetime="2000-04-06T08:15+00:00">
									Friday, 6<sup>th</sup> April 2000 @08:15:00
								</time>
							</header>
							<section>
								<p>This is an example of a comment made on a post. You can
									either edit the comment, delete the comment or reply to the
									comment. Use this as a place to respond to the post or to share
									what you are thinking.</p>
							</section>
						</article>
					</li> -->



				<form action="/single/mt/re_insert.do" method="post">
					<input type="hidden" name="mt_no" value="<%=dto.getMt_no()%>"/>
					<%
						if (loginUser != null) {
					%>
					<input type="hidden" name="me_id" value="<%=loginUser.getMe_id()%>" />
					<%
						}
					%>
					<p>
						<textarea name="mt_cmt_txt" id="comment" cols="25" rows="5"></textarea>
					</p>
					<input name="submit" type="submit" id="submit" value="등록"
						style="float: right">
				</form>
			</section>

			<!-- ####################################################################################################### -->
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