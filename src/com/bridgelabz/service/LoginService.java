package com.bridgelabz.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	public int registration(HttpServletRequest req);
	public String login(HttpServletRequest req);
}
