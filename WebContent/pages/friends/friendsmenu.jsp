<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR" >
	<title>Insert title here</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
  	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</head>
<body>
	<nav class="navbar navbar-expand-lg ">
  		<a class="navbar-brand" href="/single/friends/list.do">친구관리</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
	
  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
    		<ul class="navbar-nav mr-auto">
		      	<li class="nav-item active">
		        	<a class="nav-link" href="/single/friends/list.do">친구목록</a>
		      	</li>
		      	<li class="nav-item dropdown">
		        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          		쪽지
		        	</a>
		        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          		<a class="dropdown-item" href="#">받은 쪽지</a>
		          		<a class="dropdown-item" href="#">보낸 쪽지</a>
		          		<div class="dropdown-divider"></div>
		          		<a class="dropdown-item" href="#">쪽지 관리</a>
		        	</div>
		      	</li>
		    </ul>
		    <br>
		    <br>		    
		   	<form>
  				<input type="text" name="search" placeholder="name"/>
  				<button class="btn">Search</button>
			</form>
  		</div>
	</nav>


</body>
</html>