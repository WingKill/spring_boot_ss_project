<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- 예시파일이다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table width="700" cellpadding="0" cellspacing="0" border="1" style="text-align: center;">
      <tr>
         <td>번호</td>
         <td>제목</td>
         <td>이름</td>
         <td>날짜</td>
         <td>조회수</td>
         <td>삭제</td>            
      </tr>
      <c:forEach var="board" items="${boards}">
         <tr>
            <td>${board.bid}</td>
			<td>
            	<c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
            	<a href="${pageContext.request.contextPath}/board/content_view?bid=${board.bid}" >${board.btitle}</a>
            </td>
            <td>${board.bname}</td>
            <td>${board.bdate}</td>
            <td>${board.bhit}</td>      
            <%-- <td><button type="button" onclick="location.href='/dept/remove?deptno=${dept.deptno}';">삭제</button></td> --%>
            <td>
               <a href="${pageContext.request.contextPath}/board/delete?bid=${board.bid}"><button type="button">삭제</button></a>
            </td>
         </tr>
      </c:forEach>
      <tr>
         <td colspan="6"><a href="${pageContext.request.contextPath}/board/write_view">글작성</a></td>
      </tr>       
   </table>
</body>
</html>