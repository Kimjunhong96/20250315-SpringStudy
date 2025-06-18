<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../main/main.do">MY Spring Goods Example</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">검색
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">쉐프</a></li>
          <li><a href="../goods/find.do">상품 검색</a></li>
        </ul>
      </li>
      <li><a href="#">채팅</a></li>
      <li><a href="#">답변형게시판</a></li>
    </ul>
  </div>
</nav>
</body>
</html>
