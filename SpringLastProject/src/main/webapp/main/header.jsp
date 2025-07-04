<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <!-- ****** Top Header Area Start ****** -->
    <div class="top_header_area">
        <div class="container">
            <div class="row">
                <div class="col-5 col-sm-6">
                    <!--  Top Social bar start -->
                    <div class="top_social_bar">
                        <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
                    </div>
                </div>
                <!--  Login Register Area -->
                <div class="col-7 col-sm-6">
                    <div class="signup-search-area d-flex align-items-center justify-content-end">
                        <div class="login_register_area d-flex">
                          <c:if test="${sessionScope.userid==null }">
                            <div class="login">
                                <a href="../member/login.do">로그인</a>
                            </div>
                            <div class="register">
                                <a href="../member/join.do">회원가입</a>
                            </div>
                          </c:if>
                          <c:if test="${sessionScope.userid!=null }">
                            <div class="login">
                                ${sessionScope.username }(
                                 <sec:authorize access="hasRole('ROLE_ADMIN')">관리자</sec:authorize>
                                 <sec:authorize access="hasRole('ROLE_USER')">일반사용자</sec:authorize>
                                )님 로그인되었습니다 &nbsp;&nbsp;
                                <a href="../member/logout.do">로그아웃</a>
                            </div>
                   
                          </c:if>
                        </div>
                        <!-- Search Button Area -->
                        <!-- <div class="search_button">
                            <a class="searchBtn" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
                        </div>
                        
                        <div class="search-hidden-form">
                            <form action="#" method="get">
                                <input type="search" name="search" id="search-anything" placeholder="Search Anything...">
                                <input type="submit" value="" class="d-none">
                                <span class="searchBtn"><i class="fa fa-times" aria-hidden="true"></i></span>
                            </form>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Top Header Area End ****** -->

    <!-- ****** Header Area Start ****** -->
    <header class="header_area">
        <div class="container">
            <div class="row">
                <!-- Logo Area Start -->
                <div class="col-12">
                    <div class="logo_area text-center">
                        <a href="index.html" class="yummy-logo">부산 여행</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <nav class="navbar navbar-expand-lg">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-nav" aria-controls="yummyfood-nav" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars" aria-hidden="true"></i> Menu</button>
                        <!-- Menu Area Start -->
                        <div class="collapse navbar-collapse justify-content-center" id="yummyfood-nav">
                            <ul class="navbar-nav" id="yummy-nav">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.html">홈<span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">부산에 가면</a>
                                    <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                        <a class="dropdown-item" href="../busan/info.do?cno=1">명소</a>
                                        <a class="dropdown-item" href="../busan/info.do?cno=2">음식</a>
                                        <a class="dropdown-item" href="single.html">숙박</a>
                                        <a class="dropdown-item" href="../busan/info.do?cno=3">쇼핑</a>
                                        <a class="dropdown-item" href="contact.html">축제</a>
                                    </div>
                                </li>
                                <%--
                                추천여행

일정여행 테마여행 미식투어 체험·해양
                                --%>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">추천 여행</a>
                                    <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                        <a class="dropdown-item" href="index.html">일정 여행</a>
                                        <a class="dropdown-item" href="archive.html">테마 여행</a>
                                        <a class="dropdown-item" href="single.html">미식 투어</a>
                                        <a class="dropdown-item" href="static.html">체험 해양</a>
                                        
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">부산 맛집</a>
                                    <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                        <a class="dropdown-item" href="../food/list.do">맛집 목록</a>
                                        <a class="dropdown-item" href="archive.html">맛집 검색</a>
                                        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                                         <a class="dropdown-item" href="single.html">맛집 추천</a>
                                         <a class="dropdown-item" href="static.html">맛집 예약</a>
                                        </sec:authorize>>
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">레시피</a>
                                    <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                        <a class="dropdown-item" href="index.html">레시피 목록</a>
                                        <a class="dropdown-item" href="archive.html">쉐프</a>
                                      
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../movie/list.do">여행 동영상</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../goods/list.do">부산 특산물</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../movie/movie_list.do">영화</a>
                                </li>
                                <%--
                                      v-if="id===${sessionScope.userid}"
                                      
                                      no:${no}
                                 --%>
                                <c:if test="${sessionScope.userid!=null }">
                                  <li class="nav-item">
                                    <a class="nav-link" href="../reserve/main.do">빠른 예약</a>
                                  </li>
                                </c:if>
                                    <sec:authorize access="hasRole('ROLE_USER')">
	                                 <li class="nav-item">
	                                    <a class="nav-link" href="../reserve/main.do">마이페이지</a>
	                                 </li>
	                                </sec:authorize>
	                                
	                                <sec:authorize access="hasRole('ROLE_ADMIN')">
	                                 <li class="nav-item">
	                                    <a class="nav-link" href="../adminpage/reserve_list.do">관리자페이지</a>
	                                 </li>
	                                </sec:authorize>
                               
                               
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ****** Header Area End ****** -->
</body>
</html>
