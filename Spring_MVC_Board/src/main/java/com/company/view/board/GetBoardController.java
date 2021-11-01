package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDO board = new BoardDO();
		board.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDO boardDO = boardDAO.getBoard(board);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardDO);
		mav.setViewName("/getBoard");
		
		return mav;
	}

}
