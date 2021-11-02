package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.user.UserDAO;
import com.company.annotation.user.UserDO;

@Controller
public class UserController {
	
	@RequestMapping("/insertUser.do")
	public String insertUser(UserDO user, HttpSession session) {
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(user);
		return "login.jsp";
	}

}


