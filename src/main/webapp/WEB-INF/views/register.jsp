<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/css/register.css">
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<div class="top">
		<h1>新規登録</h1>

		<form:form action="register" modelAttribute="user">
			<p>
				ユーザーid
				<form:input path="user_id" />
				<form:errors path="user_id" cssStyle="color: red" />
			</p>
			<p>
				ニックネーム
				<form:input path="nickname" />
				<form:errors path="nickname" cssStyle="color: red" />
			</p>
			<p>
				パスワード
				<form:input path="pass_word" />
				<form:errors path="pass_word" cssStyle="color: red" />
			</p>
			<p>
				住所１
				<form:input path="from_add" />
				<form:errors path="from_add" cssStyle="color: red" />
			</p>
			<p>
				住所２
				<form:input path="from_add2" />
				<form:errors path="from_add2" cssStyle="color: red" />
			</p>
			<p>
				電話番号
				<form:input path="tel_no" />
				<form:errors path="tel_no" cssStyle="color: red" />
			</p>
			<p>
				郵便番号
				<form:input path="post_code" />
				<form:errors path="post_code" cssStyle="color: red" />
			</p>




			<div class="footer">
			<button type="submit" name="in">次へ</button>
			<p><button type="submit" name="login">アカウント お持ちの方はこちら</button></p>
			</div>
		</form:form>
	</div>
</body>
</html>