<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet"
	href="/css/register.css">
</head>
<body>
	<div class="top">
		<h1>確認画面</h1>
		<form:form action="register02" modelAttribute="user">
			<p>
				<form:input path="user_id" value="${user_id}" />
			</p>
			<p>
				<form:input path="nickname" value="${nickname}" />
			</p>
			<p>
				<form:input path="pass_word" value="${pass_word}" />
			</p>
			<p>
				<form:input path="from_add" value="${from_add}" />
			</p>
			<p>
				<form:input path="from_add2" value="${from_add2}" />
			</p>
			<p>
				<form:input path="tel_no" value="${tel_no}"/>
			</p>
			<p>
				<form:input path="post_code" value="${post_code}" />
			</p>
			<div class="footer">
				<button type=submit name="insert">登録</button>
				<button type=submit name="reset">戻る</button>

			</div>
		</form:form>

	</div>
</body>
</html>