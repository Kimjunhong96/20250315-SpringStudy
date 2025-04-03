<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <talbe class="table">
    <tr>
      <td>
        <c:forEach var="vo" items="${list }">
         
        </c:forEach>
      </td>
    </tr>
    <table class="table">
   <tr>
     <td class="text-center" colspan="3">
       <img src="${vo.poster }" style="width:820px; height: 250px;">
     </td>
   </tr>
   <tr>
     <td class="text-center" colspan="3"><h3>${vo.title }</h3></td>
   </tr>
   <tr>
     <td class="text-center" style="color:gray" colspan="3">${vo.content }</td>
   </tr>
   <tr>
    <td class="text-center"><img src="../recipe/m1.png"></td>
    <td class="text-center"><img src="../recipe/m2.png"></td>
    <td class="text-center"><img src="../recipe/m3.png"></td>
    <td class="text-center"><img src="../recipe/m4.png"></td>
   </tr>
   <tr>
    <td class="text-center">${vo.mem_cont1 }</td>
    <td class="text-center">${vo.mem_cont2 }</td>
    <td class="text-center">${vo.mem_cont3 }</td>
    <td class="text-center">${vo.mem_cont7 }</td>
   </tr>
  </table>
  div style="height:10px"></div>
 <div class="text-center">
   <ul class="pagination">
     <c:if test="${startPage>1 }">
     <li><a href="../recipe/chef_list.do?page=${startPage-1 }">&lt;</a></li>
     </c:if>
     <c:forEach var="i" begin="${startPage }" end="${endPage }">
       <li ${i==curpage?"class=active":"" }><a href="../recipe/chef_list.do?page=${i }">${i }</a></li>
     </c:forEach>
     
     <c:if test="${endPage<totalpage }">
     <li><a href="../reucipe/chef_list.do?page=${endPage+1 }">&gt;</a></li>
     </c:if>
   </ul>
 </div>
  </talbe>
</body>
</html>