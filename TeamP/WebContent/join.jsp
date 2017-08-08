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
			<h1>회원가입</h1>
			<form action="join" method="post">
			<div class="container">
				<table class="table">
					<tr>
						<th>id</th>
						<td colspan ="2"><input type="text" name="id" /></td>
					</tr>
					<tr>
						<th>pw</th>
						<td colspan="2"><input type="password" name="pw" /></td>
					</tr>
					<tr>
						<th>pw확인</th>
						<td colspan="2"><input type="password" name="repw" /></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="" id="" /></td>
					</tr>
					<tr>
						<th>email</th>
						<td colspan="2"><input type="email" name="email" /></td>
					</tr>
					<tr>
						<th>휴대폰</th>
						<td colspan="2"><input type="text" name="phone"  placeholder="'-'없이 입력해주세요." /></td>
					</tr>
					
					<tr>
						<th>성별</th>
						<td colspan="2"><input type="radio" name="gender" id="male" />남자
						<input type="radio" name="gender" id="female" />여자
						</td>
					</tr>
					<tr><th>생년월일</th>
						<td colspan="2"><input type="date" name="birthday" id="" /></td>
					</tr>
					<tr rowspan="2">
						<th>사진 등록</th>
						<td><img src="./img/defaultman.png" alt="default" width="100" height="100"/></td>
						<!-- 현재  default이미지 파일 선택후 파일이미지로 대체할 예정 -->
						<td>
							<input type="text" name="" id="" />
							<!-- filePath출력 -->
							<input type="file" name="file" id="" />
						<td>
					</tr>

					<tr>
						<td colspan="3">
						<input type="submit" value="회원가입" />
						<!-- 회원가입 버튼을 누르면 로그인 페이지로 넘어가서 회원 가입 성공창이 뜬다.  -->
						<input type="button" value="취소" id="btn" />
						</td>
					</tr>
					</div>
				</table>
			</form>
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