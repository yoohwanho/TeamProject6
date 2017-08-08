<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>일일퀘스트</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/stylish-portfolio.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	// 사이드바 메뉴 닫는 함수
	$(function() {
		$("#menu-close").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	});

	// 사이드바 메뉴 오픈시키는 함수
	$(function() {
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	});
</script>
<style type="text/css">
img{
width:100px;
height: 100px;
}
</style>
</head>


<body>
	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i
		class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#"
				class="btn btn-light btn-lg pull-right toggle"><i
				class="fa fa-times"></i></a>
			<li><a href="http://localhost:8080/TeamP/main.jsp"><h2>일일퀘스트</h2></a></li>
			<li><a href="http://localhost:8080/TeamP/login">로그인</a></li>
			<li><a href="http://localhost:8080/TeamP/loginForm">회원가입</a></li>
			<li><a href="http://localhost:8080/TeamP/WriteForm?category='1'">해주세요</a></li>
			<li><a href="http://localhost:8080/TeamP/WriteForm?category='2'">해드립니다</a></li>
			<li><a href="http://localhost:8080/TeamP/List">거래목록</a></li>
		</ul>
	</nav>
	<!-- Navigation END -->

	<!-- header -->
	<header class="header">
		<div class="logo">
			<a href="http://localhost:8080/TeamP/main.jsp"><img
				src="./img/logo.png" alt="logo" width="50" height="50" /></a>
		</div>
	</header>
	<!-- header end -->

	<!-- section1 -->
	<section>
		<div align="center">
			<h1>프로필</h1>
			<div class="container">
			<form action="">
			<!-- 수정 버튼을 누르면 userDetail.jsp로 이동  -->
			<table class="table">
				<tr>
					<td rowspan="5"><img src="./img/defaultman.png" alt="default" /></td>
					<td>ID</td>
					<td>${id }</td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td colspan="2"><input type="text" name="phone" id="" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td colspan="2">
					<input type="radio" name="gender" id="male" /> 남자
					<input type="radio" name="gender" id="female" /> 여자				
					</td>
				</tr>
				<tr>
					<td><h2>소개</h2></td>
					<td colspan="2"><textarea name="contents" id="contents" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="3">
					<input type="submit" value="수정" />
					<!-- 수정 버튼을 누르면 userDetail.jsp로 이동  -->
					<input type="button" value="돌아가기" />
					</td>
				</tr>
			</table>
			</form>
			</div>
		</div>
	</section>
	<!-- section1 end -->







	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1 text-center">
					<h4>
						<strong>일일퀘스트</strong>
					</h4>
					<p>
						종각역4번출구 <br>에이콘 아카데미
					</p>
					<ul class="list-unstyled">
						<li><i class="fa fa-phone fa-fw"></i> (033) 123-4567</li>
						<li><i class="fa fa-envelope-o fa-fw"></i>acorn@google.com</a></li>
					</ul>
					<hr class="small">
					<p class="text-muted">Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer END -->


</body>
</html>