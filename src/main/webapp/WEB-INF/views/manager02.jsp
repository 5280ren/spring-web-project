<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>反映完了</title>
<link rel="stylesheet" href="/css/manager.css">
</head>
<body>
	<div class="top">
		<h1>反映しました。</h1>
		<form:form action="top" modelAttribute="user">
			<p>
				<button type="submit" name=top value=responce>トップに戻る</button>
			</p>
		</form:form>
	</div>
</body>
</html>