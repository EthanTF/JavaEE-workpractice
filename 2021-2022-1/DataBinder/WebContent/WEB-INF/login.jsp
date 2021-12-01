<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/LoginUser" method="post">
<center>
	用户:<input type="text" name="username"><br>
	密&nbsp;&nbsp;&nbsp;码:<input type="password" name="psw"><br>
		<input type="submit" value="登陆">
</center>
</form>

</body>
</html>