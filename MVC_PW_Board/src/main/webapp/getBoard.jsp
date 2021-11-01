<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.company.MVC_PW_Board.board.BoardDO" %>


<%
   BoardDO board = (BoardDO)session.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>getBoard.jsp</title>
</head>
<body>
   <center>
      <h1>게시글 상세 보기</h1>
      <a href="Logout.do">로그아웃</a>
      <hr>
      <form name="getBoardForm" method="POST" action="updateBoard.do">
         <input type="hidden" name="seq" value="${board.seq}"/>
         <table border="1" cellpadding="0" cellspacing="0">
            <tr>
               <td bgcolor="orange" width="70">제목</td>
               <td align="left">
                  <input type="text" name="title" value="${board.title}"/>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="orange">작성자</td>
               <td align="left">
                  <input type="text" name="writer" value="${board.title}"/>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="orange">내용</td>
               <td align="left">
                  <textarea name="content" rows="10" cols="40">${board.content}</textarea>
               </td>
            </tr>
            
            <tr>
               <td bgcolor="orange">등록일</td>
               <td align="left">${board.regdate}</td>
            </tr>
            
            <tr>
               <td bgcolor="orange">조회수</td>
               <td align="left">${board.cnt}</td>
            </tr>
            
            <tr>
               <td colspan="2" align="center">
                  <input type="submit" value="글 수정"/>
               </td>
            </tr>
         </table>
      </form>
      <hr>
      <a href="insertBoard.jsp">새 게시글 등록</a>
      <a href="deleteBoard.do?seq=${board.seq}">게시글 삭제</a>&nbsp;&nbsp;&nbsp;
      <a href="getBoardList.do">전체 게시글 목록 보기</a>
   </center>
   
</body>
</html>