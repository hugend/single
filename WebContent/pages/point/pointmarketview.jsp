<%@page import="member.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="point.dto.PointDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); 
	ArrayList<PointDTO> prdlist = (ArrayList<PointDTO>)request.getAttribute("prdlist"); 
	int size = prdlist.size();
	int pageNo = 0;
	if(request.getParameter("page")==null){
		pageNo = 1;
	}else{
		pageNo = Integer.parseInt(request.getParameter("page")); //현재페이지
	}
	System.out.println(pageNo);
	int prdNum = prdlist.size();
	int totalPage = 0; // 총페이지수
	if(prdNum%9==0){
		totalPage = prdNum/9;
	}else{
		totalPage = prdNum/9 + 1;
	}
	int firstPage = 1; // 첫페이지
	if(pageNo<=5){
		firstPage = 1;
	}else if(totalPage-5<pageNo){
		firstPage = totalPage-9;
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
			
			<section id="portfolio" class="clear">
			<% for(int i=9*(pageNo-1); i<pageNo*9; i++){
				if(i<size){
				if(loginUser!=null && loginUser.getMe_id().equals("single")){		%>
				<ul>
					<li style="margin-left: 40px">
						<article>
							<figure>
								<p><%=prdlist.get(i).getPo_no() %></p>
								<a href="/single/po/read.do?po_no=<%= prdlist.get(i).getPo_no() %>">
								<img src="/single/upload/<%=prdlist.get(i).getPo_img() %>" alt="" 
								style="width: 220px; height: 150px;"></a>
								<figcaption><h4><%= prdlist.get(i).getPo_title() %></h4>
								필요 포인트: <%=prdlist.get(i).getPo_pt() %>
								<p>작성일: <%=prdlist.get(i).getPo_date() %></p></figcaption>
							</figure>
						</article>
					</li>
				</ul>
				<% }else{ 
						if(prdlist.get(i).getPo_state()==1){%>
						
					<ul>
						<li style="margin-left: 40px">
							<article>
								<figure>
									<p><%=prdlist.get(i).getPo_no() %></p>
									<a href="/single/po/read.do?po_no=<%= prdlist.get(i).getPo_no() %>">
									<img src="/single/upload/<%=prdlist.get(i).getPo_img() %>" alt="" 
									style="width: 220px; height: 150px;"></a>
									<figcaption><h4><%= prdlist.get(i).getPo_title() %></h4>
									필요 포인트: <%=prdlist.get(i).getPo_pt() %>
									<p>작성일: <%=prdlist.get(i).getPo_date() %></p></figcaption>
								</figure>
							</article>
						</li>
					</ul>
				<% 		}
					}
				}}%>
			</section>
			<!-- ####################################################################################################### -->
			<div>
				<%if(loginUser!=null)if(loginUser.getMe_id().equals("single")){ %>
				<footer class="more" style="float: right">
					<a href="/single/pages/point/pointmarketwriteview.jsp">글쓰기 &raquo;</a>
				</footer>
				<%} %>
			</div>

			<!-- ####################################################################################################### -->
			<div class="pagination">
				<ul>
					<li class="prev">
					<%if(pageNo==1){ %>
						&laquo; Previous
					<%}else{ %>
						<a href="/single/po/list.do?&page=<%=pageNo-1%>">&laquo; Previous</a>
					<%} %>
					</li>
						<%for(int i=firstPage;i<=lastPage;i++){ 
							if(i==pageNo){%>
							<li class="current"><strong><%=i %></strong></li>
							<%}else{ %>
							<li><a href="/single/po/list.do?page=<%=i%>"><%=i %></a></li>
						<%}} %>
					<li class="next">
					<%if(pageNo==totalPage){ %>
						Next &raquo;
					<%}else{ %>
						<a href="/single/po/list.do?page=<%=pageNo+1 %>">Next &raquo;</a>
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