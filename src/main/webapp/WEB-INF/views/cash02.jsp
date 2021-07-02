<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文ありがとうございます</title>
<link rel="stylesheet"
	href="/css/cash.css">
</head>
<body>
	<div class="top">
		<h2>注文ありがとうございます。</h2>
		<form:form action="cash" modelAttribute="user">
			<div class="bottom">
				<p>
					<button type="submit" name="top">トップページへ</button>
				</p>
			</div>
		</form:form>
	</div>
</body>
</html>