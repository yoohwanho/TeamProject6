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
<style type="text/css">
.filter {
	text-align: center;
	height: 30%;
	left: 1%;
	position: absolute;
	width: 10%;
}

.miniTable {
	width: 200px;
	height: 300px;
}

.val {
	width: 50px;
}

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
			<a href="#" id="menu-close"
				class="btn btn-light btn-lg pull-right toggle"><i
				class="fa fa-times"></i></a>
			<li><a href="main"><h2>
						<c:choose>
							<c:when test="${isLogin }">
					${mdto.memberName }님					
				</c:when>
							<c:otherwise>
					로그인하세요
				</c:otherwise>
						</c:choose>
					</h2></a></li>
			<c:choose>
				<c:when test="${isLogin }">
					<li><a href="logout">로그아웃</a></li>
					<li><a href="myPage">마이페이지</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login">로그인</a></li>
					<li><a href="join">회원가입</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="write">해주세요/해드립니다</a></li>
			<li><a href="board">거래목록</a></li>
		</ul>
	</nav>
	<!-- Navigation END -->

	<!-- header -->
	<header class="header">
		<div class="logo">
			<a href="main"><img src="./img/logo1.png" alt="logo" width="50"
				height="50" /></a>
			<!-- Trigger the modal with a button -->
			<button type="searchButton" class="btn btn btn-lg"
				data-toggle="modal" data-target="#myModal">
				<img src="./img/search.png" alt="search" width="30" height="30" />
			</button>

		</div>

	</header>
	<!-- header end -->

	<!-- section1 -->
	<section>
		<div class="container">
			<div class="filter">
				<form action="board">
					<table class="miniTable">

						<tr>
							<td><label><input type="radio" name="optionJob"
									value="일감">일감</label></td>
							<td><label><input type="radio" name="optionJob"
									value="일손">일손</label></td>
							<td><label><input type="radio" name="optionJob"
									value="전체">전체</label></td>
						</tr>
						<tr>
							<td><label><input type="radio" name="optionGender"
									value="여자">여자</label></td>
							<td><label><input type="radio" name="optionGender"
									value="남자">남자</label></td>
							<td><label><input type="radio" name="optionGender"
									value="무관">무관</label></td>
						</tr>
						<tr>
							<td><input type="text" class="val" name="minVal"
								placeholder="0" /></td>

							<td><input type="text" class="val" name="maxVal"
								placeholder="100000" /></td>
							<td><input type="submit" value="검색" /></td>
						</tr>
					</table>
				</form>
			</div>


			<!-- 페이징처리할 구간 -->
			<div class="table-responsive" align="center">



				<table class="table">
					<c:forEach var="list" items="${list }">
						<tr>
							<td rowspan="2" width="100px"><img
								src="./img/defaultman.png" alt="userPic" height="50" width="50" /></td>
							<td class="type">${list.category }</td>
							<td class="title" colspan="2"><a
								
								href="detail?boardNo=${list.boardNo}">${list.title}</a></td>
						</tr>
						<tr>
							<td class="writer">${list.writer }</td>
							<td class="loc">${list.loc }</td>
							<td class="money">${list.reward }</td>
						</tr>
					</c:forEach>

					<tr>

						<td><c:choose>
								<c:when test="${prev}">
									<a href="board?currentPage=${currentPage-5 }">[이전]</a>
								</c:when>
							</c:choose> <c:forEach var="i" begin="${startPage }" end="${endPage }">
								<a href="board?currentPage=${i }">${i }</a>
							</c:forEach> <c:choose>
								<c:when test="${next }">
									<a href="board?currentPage=${currentPage+5 }">[다음]</a>
								</c:when>
							</c:choose></td>
					</tr>
				</table>





			</div>


			<!-- 페이징처리할 구간 end -->


			<div class="container">


				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">검색키워드</h4>
							</div>
							<div class="modal-body">
								<table class="miniTable">

									<tr>
										<td><label><input type="radio" name="optionJob"
												value="일감">일감</label></td>
										<td><label><input type="radio" name="optionJob"
												value="일손">일손</label></td>
										<td><label><input type="radio" name="optionJob"
												value="전체">전체</label></td>
									</tr>
									<tr>
										<td><label><input type="radio"
												name="optionGender" value="여자">여자</label></td>
										<td><label><input type="radio"
												name="optionGender" value="남자">남자</label></td>
										<td><label><input type="radio"
												name="optionGender" value="무관">무관</label></td>
									</tr>
									<tr>
										<td><input type="text" class="val" name="minVal"
											placeholder="0" /></td>
										<td>~</td>

										<td><input type="text" class="val" name="maxVal"
											placeholder="100000" /></td>
									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<form>
									<div class="input-group">
										<input type="text" class="form-control" placeholder="Search">
										<div class="input-group-btn">
											<button class="btn btn-default" type="submit">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
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