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
.title {
	text-align: left;
	font-size: large;
	font: bold;
	font-weight: bold;
	width: 60%;
}

.type {
	width: 30%;
}

.writer {
	text-align: left;
	width: 15%;
}

.loc {
	text-align: left;
	font: bold;
	width: 70%;
}

.money {
	text-align: right;
	font: bold;
	font-weight: bold;
	font-size: medium;
	width: 15%;
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

		<div class="container">
			<div class="table-responsive" align="center">
				<table class="table">
					<tr>
						<td rowspan="2" width="100px"><img src="./img/mal2.png"
							alt="userPic" /></td>
						<td class="type">해주세요.</td>
						<td class="title" colspan="2">멍멍이좀 찾아주세요</td>
					</tr>
					<tr>
						<td class="writer">개장수</td>
						<td class="loc">서울시 도봉구 도봉동</td>

						<td class="money">99000</td>
					</tr>

					<tr>
						<td rowspan="2"><img src="./img/mal2.png" alt="userPic" /></td>
						<td class="type">해드립니다.</td>
						<td class="title" colspan="2">사람 찾아드립니다.</td>
					</tr>
					<tr>
						<td class="writer">마포갈비</td>
						<td class="loc">서울시 마포구 상암동</td>

						<td class="money">30000000</td>
					</tr>
					<tr>
						<td rowspan="2"><img src="./img/mal2.png" alt="userPic" /></td>
						<td class="type">해드립니다.</td>
						<td class="title" colspan="2">방학숙제해드립니다.</td>
					</tr>
					<tr>
						<td class="writer">대학생</td>
						<td class="loc">서울시 관악구 신림동</td>

						<td class="money">20000</td>
					</tr>
					<tr>
						<td rowspan="2"><img src="./img/mal2.png" alt="userPic" /></td>
						<td class="type">해주세요.</td>
						<td class="title" colspan="2">머리풍성 하게 해주세요.</td>
					</tr>
					<tr>
						<td class="writer">김광규</td>
						<td class="loc">서울시 종로구 창신동</td>

						<td class="money">50000000</td>
					</tr>

				</table>
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