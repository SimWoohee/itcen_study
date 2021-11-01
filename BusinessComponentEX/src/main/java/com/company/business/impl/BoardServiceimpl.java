package com.company.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;
import com.company.business.common.LogAdvice;

/*
 * ServiceImpl 클래스는 구현클래스이다
 * @Service는 비지니스 로직을 처리하는 클래스라고 스프링 컨테이너에게 전달한다.
 * BoardServiceimpl는 bean name은 boardService로 등록되어 있음
 */
@Service("boardService")
public class BoardServiceimpl implements BoardService{
	
	//스프링 컨테이너가 BoardDAO에 BoardDO객체를 주입시킨다
	@Autowired
	private BoardDAO boardDAO;
	
	//추가
	private LogAdvice log;
	//생성자
	public BoardServiceimpl() {
		log = new LogAdvice();
	}

	@Override
	public List<BoardDO> getBoardList(BoardDO boardDO) {
		//공통부분
		//log.printLog();
		return boardDAO.getBoardList(boardDO);
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		//return boardDAO.getBoard(boardDO);
		//log.printLog();
		return null;
	}

	@Override
	public void insertBoard(BoardDO boardDO) {
		//log.printLog();
		boardDAO.insertBoard(boardDO);
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		//log.printLog();
		//boardDAO.updateBoard(boardDO)
		
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		//log.printLog();
		//boardDAO.deleteBoard(boardDO)
		
	}

}
