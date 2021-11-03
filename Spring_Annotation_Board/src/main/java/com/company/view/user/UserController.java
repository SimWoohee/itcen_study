package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.user.UserDAO;
import com.company.annotation.user.UserDO;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/insertUser.do")
	public String insertUser(UserDO user) {
		userDAO.insertUser(user);
		return "login.jsp";
	}

}


