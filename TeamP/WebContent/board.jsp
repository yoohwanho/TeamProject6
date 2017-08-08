<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!-- <div align="center">
			<table>
					<tr>
						<td>해주세요</td>
						<td colspan="2">제목 </td>
						<td>완료인지아닌지</td>
					</tr>
					<tr>
						<td colspan="2">이름(서울시 종로구)</td>
						<td>댓글4개</td>
						<td>금액 1000원</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>해주세요</td>
						<td colspan="2">제목 </td>
						<td>완료인지아닌지</td>
					</tr>
					<tr>
						<td colspan="2">이름(서울시 종로구)</td>
						<td>댓글4개</td>
						<td>금액 1000원</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>해주세요</td>
						<td colspan="2">제목 </td>
						<td>완료인지아닌지</td>
					</tr>
					<tr>
						<td colspan="2">이름(서울시 종로구)</td>
						<td>댓글4개</td>
						<td>금액 1000원</td>
					</tr>
				</table> -->
		<div class="job_info" align="center">
			<div class="photo">
				<img src="./img/defaultman.png" width="50" height="50">
			</div>
			<strong class="title-inline ellipsis-inline"><em>해드립니다</em><a
				href="/index.php?r=deal/work-detail&amp;id=4887">원고작성/블로그원고/재택근무/바이럴마케팅</a></strong><span
				class="name-inline name-seller">이**</span><span
				class="addr-inline ellipsis-inline">경기도 수원시 권선구 세권로101번길</span><span
				class="state type_04">요청</span><span class="pay-inline">₩5,000</span>
		</div>



		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>${list.해주세요/해드립니다 }</td>
					<td colspan="2">${list.제목 }</td>
					<td>${list.완료인지아닌지 }</td>
				</tr>
				<tr>
					<td colspan="2">${list.이름 }(${list.주소 })</td>
					<td>${list.댓글 }</td>
					<td>${list.금액 }</td>
				</tr>
			</table>
		</c:forEach>
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