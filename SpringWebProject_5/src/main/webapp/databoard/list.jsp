
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
h3{
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <h3>Spring를 이용한 자료실</h3>
     <table class="table">
      <tr>
        <td><a href="insert.do" class="btn btn-sm btn-primary">새글</a></td>
      </tr>
     </table>
     <table class="table">
       <tr>
         <th width=10% class="text-center">번호</th>
         <th width=45% class="text-center">제목</th>
         <th width=15% class="text-center">이름</th>
         <th width=20% class="text-center">작성일</th>
         <th width=10% class="text-center">조회수</th>
       </tr>
       <c:set var="count" value="${count }"/>
       
       <c:forEach var="vo" items="${list }">
         <tr>
	         <td width=10% class="text-center">${count}</td>
	         <td width=45%><a href="detail.do?no=${vo.no }">${vo.subject }</a></td>
	         <td width=15% class="text-center">${vo.name}</td>
	         <td width=20% class="text-center">${vo.dbday }</td>
	         <td width=10% class="text-center">${vo.hit }</td>
	       </tr>
	       <c:set var="count" value="${count-1 }"/>
       </c:forEach>
       <tr>
         <td colspan="5" class="text-center">
          <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
           ${curpage } page / ${totalpage } pages
          <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
         </td>
       </tr>
     </table>
    </div>
  </div>
</body>
</html>


