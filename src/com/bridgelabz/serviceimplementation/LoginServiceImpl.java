package com.bridgelabz.serviceimplementation;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.dao.LoginDao;
import com.bridgelabz.model.User;

public class LoginServiceImpl {
	LoginDao dao;

	public int registration(HttpServletRequest req) {
		dao = new LoginDao();
		User model = new User();
		model.setName(req.getParameter("name"));
		model.setEmail(req.getParameter("email"));
		model.setPassword(req.getParameter("password"));
		return dao.registration(model);
	}

	public int login(HttpServletRequest req) {
		dao = new LoginDao();
		User model = new User();
		model.setEmail(req.getParameter("email"));
		model.setPassword(req.getParameter("password"));
		return dao.login(model);
	}
}
