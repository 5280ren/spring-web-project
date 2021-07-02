<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="/css/register03.css">
</head>
<body>
	<div class="form">
		<h1>ログイン画面</h1>
		<form:form action="register03" modelAttribute="user">
			<p>
				ID:
				<form:input path="user_id" />
				<form:errors path="user_id" cssStyle="color: red" />
			</p>
			<p>
				<form:hidden path="nickname" />
			<p>
				パスワード：
				<form:password path="pass_word" />
				<form:errors path="pass_word" cssStyle="color: red" />
			</p>
			<form:hidden path="from_add" />
			<br>
			<form:hidden path="from_add2" />
			<br>
			<form:hidden path="tel_no" />
			<br>
			<form:hidden path="post_code" />
			<br>
			<div class="footer">
				<button type="submit">決定</button>
			</div>
		</form:form>
	</div>
</body>
</html>