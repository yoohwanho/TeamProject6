<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<style>
	/* 알림 세션  */
	.alert{
		margin: 0 auto;
		width: 600px;
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
<li><a href="main"><h2>
			<c:choose>
				<c:when test="${isLogin }">
					${id}님					
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
			<a href="main"><img
				src="./img/logo1.png" alt="logo" width="50" height="50" /></a>
		</div>
	</header>
	<!-- header end -->
	
	<!-- section1 안내 메세지 세션-->
	<section>
		<!-- 로그인 실패시 경고  -->	
		<c:choose>
			<c:when test="${isJoin}">
				<!-- 회원가입 성공시 -->
				<div class="alert alert-success alert-dismissable fade in" id="joinSuccessAlert">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>회원가입 성공!</strong> 이제 서비스를 이용하실 수 있습니다.
				</div>
			</c:when>
			<c:when test="${isAccess}">
				<!-- 회원이 아닌 경우 접근이 불가능한 메뉴에 접근시 -->
				<div class="alert alert-warning alert-dismissable fade in" id="joinSuccessAlert">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>로그인을 해야 이용하실 수 있습니다.</strong> 
				</div>
			</c:when>
			<c:when test="${isFail }">
				<div class="alert alert-danger alert-dismissable fade in" id="loginFailAlert">
		  		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>로그인 실패</strong> 아이디 또는 패스워드가 틀립니다.
				</div>			
			</c:when>
		</c:choose>
		
		
	</section>

	<!-- section2 로그인세션 -->
	<section>
		<div align="center">
			<h1>로그인</h1>
			<form action="tryLogin" method="post" id="loginForm">
				<table>
					<tr>
						<th>id</th>
						<td><input type="text" name="id" id="id" /></td>
					</tr>
					<tr>
						<th>pw</th>
						<td>
							<input type="password" name="pw" id="pw"/>
							<input type="hidden" name="url" id="url" value="" />
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" id="btnLogin" value="로그인" />
							<!-- join.jsp로 이동 -->
							<a href="join"><input type="button" value="회원가입" id="btn" />
							</a>
							<!-- ID/PW찾기 미구현 -->
							<!-- <a href="http://localhost:8080/TeamP/"><input type="button" value="ID/PW찾기" id="btn2" /></a> -->
						</td>
					</tr>
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
<script>
 	$(function(){
		$("#btnLogin").on("click",chkLogin);
	});
	
	function chkLogin(){
		//	값이 비어있지 않은지 확인
		if($("#id").val()==""){
			alert("아이디를 입력해주세요.");		
		}else if($("#pw").val()==""){
			alert("패스워드를 입력해주세요.");
		}else{
			//	비어있지 않으면 request에 현재 페이지 저장해서 입력받은 id,pw랑 같이 db로 보냄
			$("#url").val(document.referrer);
			$("#loginForm").submit();
		}
	} 
</script>
</body>
</html>