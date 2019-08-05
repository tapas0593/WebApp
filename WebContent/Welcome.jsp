<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("email") == null) {
			response.sendRedirect("Login.html");
		}
	%>

	<p>You are successfully logged in!</p><br>
	

	<form action="logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>