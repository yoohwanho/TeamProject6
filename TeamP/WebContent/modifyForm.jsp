<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form action="modifyOk" method="post">
				<div class="container">
					<table class="table">
						<tr>
							<c:choose>
								<c:when test="${dvdto.category eq '구인'}">
									<td><input type="radio" name="category" id="구인"
										checked="checked" />해주세요 <input type="radio" name="category"
										id="구직" />해드립니다</td>
								</c:when>
								<c:otherwise>
									<td><input type="radio" name="category" id="구인" />해주세요 <input
										type="radio" name="category" id="구직" checked="checked" />해드립니다.</td>
								</c:otherwise>
							</c:choose>
							
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" value="${dvdto.title}" /><input type="hidden" name="boardNo" value="${dvdto.boardNo}" /></td>
						</tr>
						<tr>
							<th>상세 내용</th>
							<td><textarea name ="contents" rows="5" cols="40">${dvdto.contents}</textarea></td>
						</tr>
						<tr>
							<th>제안 금액</th>
							<td><input type="text" name="reward" value="${dvdto.reward}" /></td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td><input type="text" name="phone"
								placeholder="${dvdto.phone}" /></td>
							<!-- default로 로그인 한 사람의 핸드폰 번호가 들어가지만 후에 본인이 수정 가능!! -->
						</tr>
						<tr>
							<th>지원기한</th>
							<td><input type="date" name="time" value="${dvdto.time}" /></td>
						</tr>
						<tr>
							<th>위치</th>
							<td><input type="text" id="sample6_postcode"
							name="sample6_postcode"
								value="${sample6_postcode}"> <input type="button"
								onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample6_address"
								name="sample6_address"
								value="${sample6_address1}"> <input type="text"
								id="sample6_address2" name="sample6_address2" value="${sample6_address2}"> <script
									src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
								<script>
									function sample6_execDaumPostcode() {
										new daum.Postcode(
												{
													oncomplete : function(data) {
														// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

														// 각 주소의 노출 규칙에 따라 주소를 조합한다.
														// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
														var fullAddr = ''; // 최종 주소 변수
														var extraAddr = ''; // 조합형 주소 변수

														// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
														if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
															fullAddr = data.roadAddress;

														} else { // 사용자가 지번 주소를 선택했을 경우(J)
															fullAddr = data.jibunAddress;
														}

														// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
														if (data.userSelectedType === 'R') {
															//법정동명이 있을 경우 추가한다.
															if (data.bname !== '') {
																extraAddr += data.bname;
															}
															// 건물명이 있을 경우 추가한다.
															if (data.buildingName !== '') {
																extraAddr += (extraAddr !== '' ? ', '
																		+ data.buildingName
																		: data.buildingName);
															}
															// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
															fullAddr += (extraAddr !== '' ? ' ('
																	+ extraAddr
																	+ ')'
																	: '');
														}

														// 우편번호와 주소 정보를 해당 필드에 넣는다.
														document
																.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
														document
																.getElementById('sample6_address').value = fullAddr;

														// 커서를 상세주소 필드로 이동한다.
														document
																.getElementById(
																		'sample6_address2')
																.focus();
													}
												}).open();
									}
								</script></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="수정" /> <!-- detail로 넘어간다 -->
								<input type="button" value="취소" id="btn" /></td>
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