<%@page import="member.dto.MemberDTO"%>
<%@page import="mate.dto.MateDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="/single/common/scripts/jquery.min.js"></script>
<script src="/single/common/scripts/jquery-mobilemenu.min.js"></script>


</head>
<body>
	<%MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser"); 
	%>
	<div class="wrapper row1">
		<jsp:include page="/pages/template/Topbar.jsp" />
	</div>
	
	<div class="wrapper row2">
		<div id="container">
			<!-- 플로팅배너 -->
			<%if(loginUser!=null){ %>
			<jsp:include page="/pages/template/floatingmenu.jsp" />
			<%} %>
			
			<div>
				<button class="btn btn-primary" onclick="panTo()">내위치로</button>
				<a href="/single/pages/mate/mate_writeview.jsp"><button class="btn btn-danger">소모임 만들기</button></a>
				<h3 id="centerAddr"></h3>
			</div>
			
			<!-- map body -->
			<div id="map" style="width: 100%; height: 400px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e389da52ac8c672d4985eead6dce0c46&libraries=services,clusterer,drawing"></script>
			<script type="text/javascript">
			
			var map = new daum.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
						center : new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
						level : 12	// 지도의 확대 레벨 
						});
			
			function panTo() {
				// 이동할 위도 경도 위치를 생성합니다 
				var moveLatLon = new daum.maps.LatLng(<%=loginUser.getMe_loc()%>);
				// 지도 중심을 부드럽게 이동시킵니다
				// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
				map.panTo(moveLatLon);
			}
			var zoomControl = new daum.maps.ZoomControl();
			map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
			
			// 마커 클러스터러를 생성합니다 
			var clusterer = new daum.maps.MarkerClusterer({
				map : map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
				averageCenter : true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
				minLevel : 10
			// 클러스터 할 최소 지도 레벨 
			});
			// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다	 
			$.get("/single/common/json/json_test10.json", function(data) {
				// 데이터에서 좌표 값을 가지고 마커를 표시합니다
				// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
				var markers = $(data.positions).map(function(i, position) {
					return new daum.maps.Marker({
						position : new daum.maps.LatLng(position.lat, position.lng)
					});
				});
				// 클러스터러에 마커들을 추가합니다
				clusterer.addMarkers(markers);
			});
		</script>
		<script src="/single/common/scripts/mate/map.js"></script>
			<% ArrayList<MateDTO> dtolist = (ArrayList<MateDTO>)request.getAttribute("dtolist");
				int size = dtolist.size();%>

			<div id="map"></div>


			<hr />
			<!-- content body -->

			<section id="portfolio" class="clear">
				<ul>
				<% for(int i = 0; i<size; i++){
					%>
					<li>
						<a href="/single/mt/read.do?mt_no=<%=dtolist.get(i).getMt_no() %>">
						<article>
							<figure>
								<figcaption><%=dtolist.get(i).getMt_ctg() %></figcaption>
								<figcaption><%=dtolist.get(i).getMt_map() %></figcaption>
								<figcaption><%=dtolist.get(i).getMt_title() %></figcaption>
							</figure>
						</article></a>
					</li>
						<% }%>

				</ul>
			</section>
			<!-- ####################################################################################################### -->
			<!-- ####################################################################################################### -->
			<div class="pagination">
				<ul>
					<li class="prev"><a href="#">&laquo; Previous</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li class="splitter"><strong>&hellip;</strong></li>
					<li><a href="#">6</a></li>
					<li class="current"><strong>7</strong></li>
					<li><a href="#">8</a></li>
					<li class="splitter"><strong>&hellip;</strong></li>
					<li><a href="#">14</a></li>
					<li><a href="#">15</a></li>
					<li class="next"><a href="#">Next &raquo;</a></li>
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