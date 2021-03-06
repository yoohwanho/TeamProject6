<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>일일퀘스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

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
	
	$(function(){
		if("${filePath}"!= ""){
			$('#imgF').attr('src',"${filePath}")
		}
		
	})
	
	$(function(){
		("${postPic}").on("click", function(){
			$.post("imgPutForm3");
		})
	})
	
	
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
			<a href="main"><img
				src="./img/logo1.png" alt="logo" width="50" height="50" /></a>
		</div>
	</header>
	<!-- header end -->

	<!-- section1 -->
	<section>
		<div align="center">
			<h1>프로필 수정</h1>
			<div class="container">
			<form:form action="modify" method="post" id="postModify"
			enctype="multipart/form-data" commandName="uploadFile">
			<!-- 수정 버튼을 누르면 userDetail.jsp로 이동  -->
			<table class="table">
			
						<tr>
							<th>id</th>
							<td colspan="2">${mdto.memberId}
							<input type="hidden" name="memberId" value="${mdto.memberId }" />
							</td>
							
						</tr>
						<tr>
							<th>pw</th>
							<td colspan="2"><input type="password" name="memberPwd" value="${mdto.memberPwd }"/></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="memberName" id="" value="${mdto.memberName }"/></td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td colspan="2"><input type="text" name="phone"
								placeholder="'-'없이 입력해주세요." value="${mdto.phone}"/></td>
						</tr>

						<tr>
							<th>성별</th>
							<td colspan="2">
								<c:choose>
								<c:when test="${mdto.gender eq 'male'}">
								<input type="radio" name="gender" id="male" value="male" checked="checked" />남자
								<input type="radio" name="gender" id="female" value="female"/>여자
								</c:when>
								<c:when test="${mdto.gender eq 'female' }">
								<input type="radio" name="gender" id="male" value="male" />남자
								<input type="radio" name="gender" id="female" value="female" checked="checked"/>여자								
								</c:when>
								</c:choose>
								</td>
								
						</tr>
						<tr>
							<th>사진 등록</th>
							<!-- ${filePath }-->
							<td colspan="2">
							<input type="file" name="file" value="${mdto.profileSrc }"  />
							
							</td>
						</tr>
						
						<tr>
							<th>자기 소개</th>
							<td><textarea name="contents" id="contents" cols="50" rows="5">${mdto.contents }</textarea></td>
						</tr>

						<tr>
							<td colspan="3"><input type="submit" value="수정완료" id="goModify"/> 
							
								<input type="button" value="취소" id="btn" /></td>
						</tr>
					
					</table>
					
			</form:form>
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
						<li><i class="fa fa-envelope-o fa-fw"></i>acorn@google.com</li>
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