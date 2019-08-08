<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	Name:<%=session.getAttribute("name")%><br> Email:<%=session.getAttribute("email")%><br>
	<form action="logout">
		<input type="submit" value="Logout"><br>
	</form>
</body>
</html>