<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<p style="color: maroon;">
		Welcome,
		<%=session.getAttribute("name")%>. You are successfully logged in!
	</p>
	<br>
	<form action="logout">
		<input type="submit" value="Logout"><br> <a
			href="Profile.jsp">View My Profile</a>
	</form>
</body>
</html>