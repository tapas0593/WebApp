package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.serviceimplementation.LoginServiceImpl;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginServiceImpl service = new LoginServiceImpl();
		int result = service.registration(req);
		if (result > 0) {
			resp.sendRedirect("Login.html");
		}else {
			HttpSession session=req.getSession();
			session.setAttribute("name", req.getParameter("name"));
			resp.sendRedirect("RegistrationError.jsp");
		}
	}
}
