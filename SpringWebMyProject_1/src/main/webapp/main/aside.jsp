<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table class="table">
  <tr>
   <td class="text-center"><h3>순위</h3></td>
  </tr>
 </table>
 <table class="table">
   <tr>
     <th class="text-center">순위</th>
     <th class="text-center"></th>
     <th class="text-center">레시피명</th>
   </tr>
   <c:forEach var="mvo" items="${rList }">
     <tr>
      <td class="text-center">${vo.no }</td>
      <td class="text-center">
      <img src="${vo.goods_poster }" style="width:30px; height:50px;"></td>
      <td>${vo.goods_name }</td>
     </tr>
   </c:forEach>
 </table>
</body>
</html>