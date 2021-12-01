<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
<form action= "${pageContext.request.contextPath}/deleteUsers" method="post">
<table width="20%" border=1>
<tr>
<td>选择</td>
<td>用户名</td>
</tr>

<tr>
<td><input name="ids" value="1" type="checkbox"></td>>
<td>Jack</td>
</tr>

<tr>
<td><input name="ids" value="2" type="checkbox"></td>>
<td>Tom</td>
</tr>

<tr>
<td><input name="ids" value="3" type="checkbox"></td>>
<td>Sara</td>
</tr>

</table>
<input type="submit" value="删除">
</form>
</body>
</html>