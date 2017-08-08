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
	
	$(function (){
		$("#searchaddrs").click(function(){
			<!--autoload=false 파라미터를 이용하여 자동으로 로딩되는 것을 막습니다.-->
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
			<script>
			    //load함수를 이용하여 core스크립트의 로딩이 완료된 후, 우편번호 서비스를 실행합니다.
			    daum.postcode.load(function(){
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
			            }
			        }).open();
			    });
			</script>
		})
		
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
			<form action="writeOk" method="post">
				<div class="container">
					<table class="table">
						<tr>
							<td><input type="radio" name="category" id="구인" />해주세요 <input
								type="radio" name="category" id="구직" />해드립니다 <!-- 뒤에 글귀는 후에 변경 가능!!  -->
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" /></td>
						</tr>
						<tr>
							<th>상세 내용</th>
							<td><textarea rows="10" cols="30"></textarea></td>
						</tr>
						<tr>
							<th>제안 금액</th>
							<td><input type="text" name="money" id="" /></td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td><input type="text" name="phone" placeholder="${phone}" /></td>
							<!-- default로 로그인 한 사람의 핸드폰 번호가 들어가지만 후에 본인이 수정 가능!! -->
						</tr>
						<tr>
							<th>지원기한</th>
							<td><input type="date" name="period" id="" /></td>
						</tr>
						<tr>
							<th>위치</th>
							<td>
								<input type="text" name="" id="" />
								<input type="button" value="주소 검색" id="searchaddrs"/>
							</td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="작성/수정" /> <input
								type="button" value="취소" id="btn" /></td>
						</tr>
					</table>
				</div>
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