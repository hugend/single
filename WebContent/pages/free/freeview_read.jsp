<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="free.dto.FreeDTO"%>
<%@page import="free.dto.FreeCmtDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Single Single</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/single/common/styles/layout.css"
	type="text/css" media="all">
<link rel="stylesheet" href="/single/common/styles/mediaqueries.css"
	type="text/css" media="all">

<!-- hs 추가 -->
<link rel="shortcut icon" href="/single/images/favicon.ico">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel='stylesheet' id='kboard-skin-thumbnail-css'
	href='/single/common/styles/free/thumbnail.css?ver=5.3.9'
	type='text/css' media='all' />
<link rel='stylesheet' id='kboard-comments-skin-default-css'
	href='/single/common/styles/free/comments.css?ver=4.4.4'
	type='text/css' media='all' />

<style type="text/css">
.modal {
	text-align: center;
}

@media screen and (min-width: 768px) {
	.modal:before {
		display: inline-block;
		vertical-align: middle;
		content: " ";
		height: 100%;
	}
}

.modal-dialog {
	display: inline-block;
	vertical-align: middle;
}
</style>

<%
	FreeDTO post = (FreeDTO) request.getAttribute("post");
	ArrayList<FreeCmtDTO> cmtlist = (ArrayList<FreeCmtDTO>) request.getAttribute("cmtlist");
	int size = cmtlist.size();
%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#insert_bd").on("click", function() {

		    var id = $('#id').val();
		    var bd_id = $('#bd_id').val();
		    var postno = $('#postno').val();

		    $("#insert_bd_form").submit();
		});
	});
</script>
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
			<%
				MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
			%>
			<%
				if (loginUser != null) {
			%>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%
				}
			%>

			<!-- Modal -->

			<div class="modal" id="infoModal" tabindex="-1" role="dialog">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-body">
							<form action="/single/bd/insert_bd.do" method="post"
								id="insert_bd_form">
								<input name="postno" type="hidden" value="<%=post.getFr_no()%>" id="postno">
								<%
									if (loginUser != null) {
								%>
								<input name="id" type="hidden" value="<%=loginUser.getMe_id()%>"
									id="me_id">
								<%
									}
								%>
								<input name="bd_id" type="hidden" value="<%=post.getMe_id()%>"
									id="bd_id">
								<button type="button" class="btn btn-info" data-dismiss="modal"
									id="insert_bd">친구추가</button>
							</form>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-info" aria-label="Close"
								data-dismiss="modal">
								<span aria-hidden="true">&times;</span>
							</button>

						</div>
					</div>
				</div>
			</div>

			<!-- ============================== -->

			<div id="kboard-document">
				<div id="kboard-thumbnail-document">
					<div class="kboard-document-wrap" itemscope
						itemtype="http://schema.org/Article">
						<div class="kboard-title" itemprop="name">
							<h1><%=post.getFr_title()%></h1>
						</div>
						<div class="kboard-detail">
							<div class="detail-attr detail-writer">
								<div class="detail-name">작성자</div>
								<div class="detail-value">
									<a href="#infoModal" data-toggle="modal"
										data-target="#infoModal"><%=post.getMe_id()%></a>
								</div>
							</div>
							<div class="detail-attr detail-date">
								<div class="detail-name">작성일</div>
								<div class="detail-value"><%=post.getFr_date()%></div>
							</div>
							<div class="detail-attr detail-view">
								<div class="detail-name">조회</div>
								<div class="detail-value"><%=post.getFr_hits()%></div>
							</div>
						</div>
						<div class="kboard-content" itemprop="description">
							<div class="content-view">
								<p style="text-align: center;">
									<%
										if (post.getFr_img() != null) {
									%>
									<img src="/single/pages/free/upload/<%=post.getFr_img()%>" /><br />
									<%
										}
									%>
									<%=post.getFr_txt()%>
								</p>
							</div>
						</div>

						<div class="kboard-document-action">

							<div class="right">
								<a
									href="/single/fr/report.do?id=<%=post.getMe_id()%>&no=<%=post.getFr_no()%>"
									class="kboard-button-action kboard-button-print"
									onclick="return confirm('신고 하시겠습니까?');">신고</a>
							</div>
						</div>

					</div>

					<div class="kboard-comments-area">
						<div id="kboard-comments-1851" class="kboard-comments-default">
							<div class="kboard-comments-wrap">

								<div class="comments-header">
									<div class="comments-count">
										전체 <span class="comments-total-count"><%=post.getCmtcount()%></span>
									</div>

									<hr>
								</div>

								<!-- 댓글 리스트 시작 -->
								<div class="comments-list" id="cmtlist">
									<%
										for (int i = 0; i < size; i++) {
											FreeCmtDTO cmt = cmtlist.get(i);
									%>
									<ul>
										<li itemscope itemtype="http://schema.org/Comment"
											class="kboard-comments-item">
											<div class="comments-list-username" itemprop="author">
												<img src="/single/upload/<%=cmt.getMe_img()%>" width="24"
													height="24"
													class="avatar avatar-24 wp-user-avatar wp-user-avatar-24 photo avatar-default" />
												<a href="#infoModal" data-toggle="modal"
													data-target="#infoModal"><%=cmt.getMe_id()%></a>
											</div>
											<div class="comments-list-create" itemprop="dateCreated"><%=cmt.getFr_cmt_date()%></div>
											<div class="comments-list-content" itemprop="description"><%=cmt.getFr_cmt_txt()%></div>


											<div class="comments-list-controller">
												<div class="right">
												<%if(loginUser != null && loginUser.getMe_id().equals(cmt.getMe_id())){%>
													<a type="button"
														href="/single/fr/cmtdelete.do?cmt_no=<%=cmt.getFr_cmt_no()%>&no=<%=post.getFr_no()%>"
														class="comments-button-action comments-button-delete"
														onclick="return confirm('삭제 하시겠습니까?');" title="삭제">삭제</a>
												<%} %>
												</div>
											</div>
										</li>
									</ul>
									<%
										}
									%>
								</div>

								<!-- 댓글 입력 폼 시작 -->
								<%
									if (loginUser != null) {
								%>
								<form id="cmtform" method="post"
									action="/single/fr/cmtinsert.do">
									<input name="postno" type="hidden" value="<%=post.getFr_no()%>">
									<input name="id" type="hidden"
										value="<%=loginUser.getMe_id()%>">

									<div class="kboard-comments-form">
										<div class="comments-field">
											<textarea name="cmt" placeholder="댓글을 입력하세요."
												onfocus="kboard_comments_field_show()" required></textarea>
										</div>

										<div class="comments-submit-button">
											<input type="submit" value="입력" id="insertcmt">
										</div>
									</div>
								</form>
								<%
									}
								%>
								<!-- 댓글 입력 폼 끝 -->

							</div>
						</div>
					</div>

					<div class="kboard-control">
						<div class="left">
							<a href="/single/fr/list.do?category=all"
								class="kboard-thumbnail-button-small">돌아가기</a>
						</div>

						<div class="right">
							<%
								if (loginUser != null && loginUser.getMe_id().equals(post.getMe_id())) {
							%>
							<a
								href="/single/fr/read.do?no=<%=post.getFr_no()%>&action=modify"
								class="kboard-thumbnail-button-small">글수정</a> <a
								href="/single/fr/delete.do?no=<%=post.getFr_no()%>"
								class="kboard-thumbnail-button-small"
								onclick="return confirm('삭제 하시겠습니까?');">글삭제</a>
							<%
								}
							%>
						</div>
					</div>

				</div>
			</div>
			<br />

		</div>
		<!-- ################################################################################################ -->
		<div class="clear"></div>
	</div>
	<!-- Copyright -->
	<div class="wrapper row3">
		<jsp:include page="/pages/template/Footer.jsp" />
	</div>
</body>
</html>