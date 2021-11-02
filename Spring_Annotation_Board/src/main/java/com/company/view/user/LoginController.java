package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.user.UserDAO;
import com.company.annotation.user.UserDO;

@Controller
public class LoginController {	//POJO 클래스로 구현한다.

	//11.02 추가
	@RequestMapping("/login.do")
	public String login(UserDO userDO, HttpSession session) {
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		if(user != null) {
			System.out.println("로그인 성공");
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else {
			System.out.println("로그인 실패");
			return "login.jsp";
		}
		
	}
}
