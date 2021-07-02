<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>送信しました。ご協力ありがとうございます。</h1>
<form:form action="top" modelAttribute="model">
<p><button type="submit" name=top value=responce>トップに戻る</button></p>
</form:form>
</body>
</html>