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
	$(function() {
		if ("${filePath}" != "") {
			$('#imgF').attr('src', "${filePath }");
		}
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
			<a href="main"><img src="./img/logo1.png" alt="logo" width="50"
				height="50" /></a>
		</div>
	</header>
	<!-- header end -->

	<!-- section1 -->
	<section>
		<div align="center">
			<form action="reviewOk" method="post" id="reviewForm">
				<div class="container">
					<table class="table">


						<tr>
							<th>내용</th>
							<td>
								<textarea rows="5" cols="40" name="contents" id="contents"
									placeholder="리뷰는 한번 작성하면 수정할 수 없습니다. 신중하게 작성해주세요."></textarea>
								<input type="hidden" name="boardNo" value="${boardNo }" />
							</td>
						</tr>

						<tr>
							<th>평점</th>
							<td>
								<input type="number" name="score" id="score" min="0" max="10"/>
							</td>
						</tr>
						<tr>
							<th>사진첨부</th>
							<td><img src="./img/defaultman.png" alt="default" width="50"
								height="50" id="imgF" name="imgSrc"/><a href="imgPutForm2">사진올리기</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" value="작성" id="btnWrite" /> <!-- 작성 버튼을 누르면 detail창으로 넘어간다.  -->
								<input type="button" value="취소" id="btnCancel" /> <!-- 취소 버튼을 누르면 detail 넘어간다.  -->
							</td>
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
<script>
	$(function(){
		$("#btnWrite").on("click",function(){
			//	작성 버튼
			if($("#contents").val()==""){
				//	내용에 아무것도 입력하지 않았을 때
				alert("내용을 입력해주세요");				
			}else{
				$("#reviewForm").submit();
			}
		});
		$("#btnCancel").on("click",function(){
			//	취소 버튼
			if($("#contents").val()!=""){
				var answer = confirm("변경된 내용이 있습니다. 저장하지 않고 취소합니까?");
				if(answer){
					//	취소
					history.back();					
				}
			}else{
				history.back();
			}
		});
		
	});

	
</script>

</body>
</html>