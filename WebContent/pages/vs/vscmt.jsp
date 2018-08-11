<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>vs게시판</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="/single/common/styles/vs/vscmt.css">
</head>
<body>
	<%-- 댓글 --%>
		<div class="row">
			<div class="panel panel-default widget">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span>
					<h3 class="panel-title">Comments</h3>
					<span class="label label-info"> 78</span>
				</div>
				<div class="panel-body">
					<ul class="list-group">
						
						<%--댓글목록 --%>
						<li class="list-group-item">
							<div class="row">
								<div class="col-xs-2 col-md-1">
									<img src="../../images/irene.png" class="img-circle img-responsive" alt="" />
								</div>
								<div class="col-xs-10 col-md-11">
									<div class="comment-text">뭐가 힘든지 말해야죠</div>
									<div>
										<a href="#"></a>
										<div class="mic-info">
											By: <a href="#">배주현</a> on 2 Jul 2018
										</div>
									</div>
									<div class="action">
										<button type="button" class="btn btn-primary btn-xs" title="Edit">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
										<button type="button" class="btn btn-success btn-xs" title="Approved">
											<span class="glyphicon glyphicon-ok"></span>
										</button>
										<button type="button" class="btn btn-danger btn-xs" title="Delete">
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</div>
								</div>
							</div>
						</li>
						
					</ul>
					<a href="#" class="btn btn-default btn-sm btn-block" role="button"> 
						<span class="glyphicon glyphicon-refresh"></span> More
					</a>
				</div>
			</div>
		</div>


</body>
</html>