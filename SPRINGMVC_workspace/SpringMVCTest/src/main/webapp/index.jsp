<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h2>Login page with Post Method</h2>
<form action="login" method="post">
<label>EmailId</label>
<input type="email" name="emailID"/><br/>
<label>Password</label>
<input type="password" name="passwd"/><br/>
<input type="submit" value="SignIn"/>
<input type="reset" value="reset"/>
</form>
</body>
</html>