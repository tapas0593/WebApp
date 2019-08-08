package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.serviceimplementation.LoginServiceImpl;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginServiceImpl service = new LoginServiceImpl();
		int result = service.registration(req);
		if (result > 0) {
			resp.sendRedirect("Login.html");
		} else {
			resp.sendRedirect("RegistrationError.jsp");
		}
	}
}
