<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <table class="table">
   <tr>
    <td colspan="3" class="text-center">
    <img :src="'https://www.menupan.com'+vo.poster" style="width:800px;height:250px">
    </td>
   </tr>
   </table>
   
  </div>
 </div>
</body>
</html>