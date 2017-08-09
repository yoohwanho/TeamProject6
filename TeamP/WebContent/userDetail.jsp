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
			<a href="http://localhost:8080/TeamP/main.jsp"><img
				src="./img/logo1.png" alt="logo" width="50" height="50" /></a>
		</div>
	</header>
	<!-- header end -->

	<!-- section1 -->
	<section>
		<div align="center">
			<h1>프로필</h1>
			
			<<div class="container">
			<table class="table">

				<tr>
					<td rowspan="4"><img src="./img/defaultman.png" alt="default"
						width="100" height="100" /></td>
					<th>ID</th>
					<td>${mdto.memberId }</td>
				</tr>
				<tr>
					<th>휴대폰</tj>
					<td colspan="2">${mdto.phone}</td>
				</tr>
				<tr>
					<th>요청자로서의 평점</th>
					<td colspan="2">${mdto.buyGrade }/10</td>
					<!--  평정 입력 값이 들어가야함  -->
				</tr>
				<tr>
					<th>지원자로서의 평점</th>
					<td colspan="2">${mdto.sellGrade }/10</td>
					<!--  지원자 평점이 들어가야 함  -->
				</tr>

				<tr>
					<td><h2>소개</h2></td>
					<td colspan="2">
						<div class="panel panel-default">
							<div class="panel-body">${mdto.contents }</div>
						</div>
					</td>
					<!-- 소개글이 출력되야함 -->
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="button" value="수정" /></td>
				</tr>
			</table>
		</div>
		<div class="container">
			<table class="table">
				<div class="container">
					<div class="panel-group" id="accordion">
				<tr>
					<td rowspan="2" width="46" height="225"><img src="./img/defaultman.png" alt="default"
						width="30" height="30" /></td>
					<td>후기글 작성자</td>
				</tr>
				<tr>
					<td>
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapse1"> 후기글 제목</a>
									</h4>
								</div>
								<div id="collapse1" class="panel-collapse collapse">
									<div class="panel-body">
									<table>
									<tr>
										<td><img src="./img/worker.jpg" alt="후기 이미지"  width="100" height="100"/>
									<!-- 후기 이미지 넣기 --></td>
										<td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consectetur illum doloremque eos labore voluptatem rem explicabo inventore tempora eum necessitatibus dignissimos similique non vero tenetur corporis asperiores minima. Rerum ducimus?</td>
									</tr>
									</table>
									
									</div>
								</div>
					</td>
				</tr>
			</table>

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