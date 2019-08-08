package com.bridgelabz.serviceimplementation;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.dao.LoginDAO;
import com.bridgelabz.model.LoginUserRequest;
import com.bridgelabz.model.RegisterUserRequest;
import com.bridgelabz.service.LoginService;
import com.bridgelabz.utility.Util;

public class LoginServiceImpl implements LoginService {
	static LoginDAO loginDAO = new LoginDAO();;

	@Override
	public int registration(HttpServletRequest req) {
		RegisterUserRequest registerUser = new RegisterUserRequest();
		registerUser.setName(req.getParameter("name"));
		registerUser.setEmail(req.getParameter("email"));
		String password = Util.encryptPass(req.getParameter("password"));
		registerUser.setPassword(password);
		return loginDAO.userRegistration(registerUser);
	}

	@Override
	public String login(HttpServletRequest req) {
		LoginUserRequest loginUser = new LoginUserRequest();
		loginUser.setEmail(req.getParameter("email"));
		String password = Util.encryptPass(req.getParameter("password"));
		loginUser.setPassword(password);
		return loginDAO.userLogin(loginUser);
	}
}
