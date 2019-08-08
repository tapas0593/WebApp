package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.service.LoginService;
import com.bridgelabz.serviceimplementation.LoginServiceImpl;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginService service = new LoginServiceImpl();
		String name = service.login(req);
		if (name != null) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", req.getParameter("email"));
			session.setAttribute("password", req.getParameter("password"));
			resp.sendRedirect("Welcome.jsp");
		} else {
			resp.sendRedirect("LoginError.jsp");
		}
	}
}
