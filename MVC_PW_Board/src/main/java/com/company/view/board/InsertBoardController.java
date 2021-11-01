package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_PW_Board.board.BoardDAO;
import com.company.MVC_PW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class InsertBoardController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("인서트 메소드 처리");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDO boarDO = new BoardDO();
		boarDO.setTitle(title);
		boarDO.setWriter(writer);
		boarDO.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(boarDO);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boarDO);
		
		
		return "getBoardList.do";
	}

}
