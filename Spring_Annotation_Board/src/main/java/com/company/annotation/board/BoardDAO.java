package com.company.annotation.board;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.annotation.common.JDBCUtil;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession mybatis;

	// 전체 게시글 목록 조회 메소드
	public List<BoardDO> getBoardList(BoardDO boardDO) {
		System.out.println("====>getBoardList() running ......");
		//selectList는 데이터를 다 가져올때 사용
		//sqlsession에서 제공하는 메소드
		return mybatis.selectList("BoardDAO.getBoardList", boardDO);

	}

	// 게시글번호 조건에 맞는 해당 게시글만 검색하는 메소드
	public BoardDO getBoard(BoardDO boardDO) {
		System.out.println("====>getBoard() running ......");
		//selectOne는 데이터를 한개 가져올때 사용
		return mybatis.selectOne("BoardDAO.getBoard", boardDO);
	
	} 

	// 게시글 수정 처리 메소드
	public void updateBoard(BoardDO boardDO) {
		System.out.println("====>updateBoard() running ......");
		mybatis.update("BoardDAO.updateBoard", boardDO);

	} 

	// 게시글 삭제 처리 메소드
	public void deleteBoard(BoardDO boardDO) {
		System.out.println("====>deleteBoard() running ......");
		mybatis.delete("BoardDAO.deleteBoard", boardDO);
	}

	public void insertBoard(BoardDO boardDO) {
		System.out.println("====>insertBoard() running ......");
		mybatis.insert("BoardDAO.insertBoard", boardDO);
	}

}

