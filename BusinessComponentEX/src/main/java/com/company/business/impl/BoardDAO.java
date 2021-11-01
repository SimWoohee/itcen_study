package com.company.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.business.board.BoardDO;
import com.company.business.common.JDBCUtil;

// @Repository의 의미는 해당 클래스는 데이터베이스 연동을 처리하는 클래스 라고
// Springcontainer에게 알려주는 것

@Repository
public class BoardDAO {
	
	 private Connection conn= null;
	 private PreparedStatement pstmt = null;
	 private ResultSet rs = null;
	 
	 
	 //getBoardList 설계
	 public List<BoardDO> getBoardList(BoardDO boardDO) {
		 System.out.println("====> getBoardList() 처리");
		 
		 List<BoardDO> boardList = new ArrayList<BoardDO>();
		 String selectSql = "SELECT * FROM board order by seq desc";
		 
		 try {
			 conn = JDBCUtil.getConnction();
			 pstmt = conn.prepareStatement(selectSql);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 BoardDO board = new BoardDO();
				 
				 board.setSeq(rs.getInt("seq"));
				 board.setTitle(rs.getString("title"));
				 board.setWriter(rs.getString("writer"));
				 board.setContent(rs.getString("content"));
				 board.setRegdate(rs.getDate("regdate"));
				 board.setCnt(rs.getInt("cnt"));
				 
				 boardList.add(board);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		 return boardList;
		
	}
	 
	 public void insertBoard(BoardDO boardDO) {
		 System.out.println("====> insertBoard() 처리");
		 //nvl 함수 seq의 max값이 null이면 0으로 셋팅하고 +1 => 1
		 //seq값의 max값을 가져와서 있으면 max값 + 1 => max + 1
		 
		 String insertSql = "insert into board(seq,title,writer,content) "
		 		+ "values((select nvl(max(seq),0)+1"
				+ "from board),?,?,?)";
				 
		 try {
			conn = JDBCUtil.getConnction();
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, boardDO.getTitle());
			pstmt.setString(2, boardDO.getWriter());
			pstmt.setString(3, boardDO.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	 
}
