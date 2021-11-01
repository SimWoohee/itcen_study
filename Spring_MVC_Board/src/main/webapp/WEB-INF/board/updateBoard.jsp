<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
   
<!--  추가  -->
<%@ page errorPage = "error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>updateBoard.jsp</title>
</head>
<body>
   <center>
   <h1>글 수정 </h1>
   <a href = "logout.do">로그아웃</a>
   <hr>
   <form name = "updateForm" method = "POST" action = "dataupdateBoard.do">
   	<input type="hidden" value="${board.seq}" name="seq"/>
      <table border = "1" cellpadding = "0" cellspacing = "0">
         <tr>
            <td bgcolor= "orange" width = "70">제목</td>
            <td align = "left"><input type = "text" name = "title" value="${board.title}"/>
         </tr>
         <tr>
            <td bgcolor= "orange">내용</td>
            <td align = "left">
               <textarea rows="10" cols="40" name = "content" >${board.content}</textarea>
            </td>
         </tr>
         
         <tr>
            <td colspan = "2" align = "center">
               <input type = "submit" value = "글 수정"/>
         </tr>
      </table>
   </form>
   <hr>
   <a href = "getBoardList.do">전체 게시글 목록 보기</a>
   </center>
</body>
</html>