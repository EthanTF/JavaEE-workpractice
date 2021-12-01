<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单界面</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/orderUser" method="post">
<center>
	订单编号:<input type="text" name="order_id"><br>
	用户用户名:<input type="text" name="user.username"><br>
		<input type="submit" value="查询">
</center>
</form>


</body>
</html>