package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.annotation.board.BoardDAO;
import com.company.annotation.board.BoardDO;

/*
 * 커맨트 객체란?
 * 클라이언트가 보내주는 파라미터가 자동으로 담겨서 반환되는 객체를 말한다 UserDO,BoardDO에 담겨저 오는것
 * 이는 자동객체 변환이라고도 하며 MVC 디자인 패턴에서 가장 큰 핵심 기술 중에 하나이다
 * 스프링에서는 @RequestMapping을 이용하여 HandlerMapping 설정을 대체한다.
 */
@Controller
public class BoardController {
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, BoardDAO boardDAO, Model model, 
						String searchField, String searchText) {
		model.addAttribute("boardList", boardDAO.getBoardList(searchField, searchText));
		return "/getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public ModelAndView insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insertBoard(boardDO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	
	@RequestMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.deleteBoard(boardDO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
	
	@RequestMapping("/updateBoard.do")
	public ModelAndView updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO board, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(board));
		return "/getBoard.jsp";
	}

}
