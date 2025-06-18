<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>커뮤니티 게시판</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 8px; border: 1px solid #ccc; text-align: center; }
        a { text-decoration: none; color: blue; }
        .pagination { margin-top: 20px; text-align: center; }
        .pagination a { margin: 0 5px; }
    </style>
</head>
<body>
    <h2>📋 게시판 목록</h2>

    <!-- 검색 -->
    <form method="get" action="list">
        <select name="type">
            <option value="title" ${type == 'title' ? 'selected' : ''}>제목</option>
            <option value="content" ${type == 'content' ? 'selected' : ''}>내용</option>
        </select>
        <input type="text" name="keyword" value="${keyword}">
        <input type="submit" value="검색">
    </form>

    <!-- 글 목록 테이블 -->
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자번호</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>좋아요</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vo" items="${list}">
                <tr>
                    <td>${vo.post_id}</td>
                    <td><a href="detail?post_id=${vo.post_id}">${vo.title}</a></td>
                    <td>${vo.user_no}</td>
                    <td><fmt:formatDate value="${vo.create_at}" pattern="yyyy-MM-dd"/></td>
                    <td>${vo.views}</td>
                    <td>${vo.like_count}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- 페이지네이션 -->
    <div class="pagination">
        <c:forEach var="i" begin="1" end="${totalPage}">
            <a href="list?page=${i}${type != null ? '&type=' + type : ''}${keyword != null ? '&keyword=' + keyword : ''}">
                [${i}]
            </a>
        </c:forEach>
    </div>

    <!-- 글쓰기 버튼 -->
    <div style="text-align: right; margin-top: 20px;">
        <a href="insert">✍ 글쓰기</a>
    </div>
</body>
</html>
