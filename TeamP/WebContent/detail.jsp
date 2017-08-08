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
			<li><a href="main"><h2>일일퀘스트</h2></a></li>
			<li><a href="login">로그인</a></li>
			<li><a href="join">회원가입</a></li>
			<li><a href="writeForm">해주세요/해드립니다</a></li>
			<li><a href="board">거래목록</a></li>
		</ul>
	</nav>
	<!-- Navigation END -->

	<!-- header -->
	<header class="header">
		<div class="logo">
			<a href="main"><img
				src="./img/logo.png" alt="logo" width="50" height="50" /></a>
		</div>
	</header>
	<!-- header end -->

	<!-- section1 -->


	<section>

		<!--  게시글 클릭시 디테일 창. -->
		<div class="container">
			<div class="table-responsive" align="center">
				<table class="table">
					<tr>
						<th colspan="4">제목</th>
					</tr>
					<tr>
						<td rowspan="4"><img src="./img/mal2.png" alt="프사"
							class="img-rounded" /></td>
						<td><h5>등록일</h5></td>
					</tr>
					<tr>
						<td>댓글 N개</td>
					</tr>
					<tr>
						<td>평점 6.5/10</td>
					</tr>
					<tr>
						<td>금액</td>
					</tr>
					<tr>
						<td colspan="5">집에 뭘 두고왔는데 대신 가져다 주실분</td>
					</tr>
					<tr>
						<th>연락처</th>
						<th>지역</th>
						<th>기한</th>
					</tr>
					<tr>
						<td>010-1234-5678</td>
						<td>서울시 종로구</td>
						<td>2017-08-15</td>
					</tr>
					<tr>
					
					</tr>

				</table>
				<!--  댓글 테이블. db에서 댓글 조회하여 입력시켜야함. -->
				<table class="table">
					<tr>
						<td>댓글 (2개)</td>
					</tr>
					<tr>
						<td>멍멍이</td>
						<td>8.5/10</td>
						<td>2017-08-08 11:35:40</td>
					</tr>
					<tr>
						<td colspan="5">지원하고싶습니다.</td>
					</tr>
					<tr>

						<td>멍멍이</td>
						<td>8.5/10</td>
						<td>2017-08-08 11:35:40</td>
					</tr>
					<tr>
						<td colspan="5">지원하고싶습니다.</td>
					</tr>
				</table>
			</div>
			<!--  댓글입력창. form에 액션 추가하고 사용.-->
			<div class="container">
				<form>
					<div class="form-group">
						<label for="comment">문의하기</label>
						<textarea class="form-control" rows="5" id="comment"
							placeholder="궁금하신 점을 작성해주세요~"></textarea>
						<button type="button" class="btn" id="">등록하기</button>
					</div>
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