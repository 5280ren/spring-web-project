<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理人設定</title>
<link rel="stylesheet" href="/css/managerinsert.css">
</head>
<body>
	<div class="top">
		<h1>管理人設定</h1>
		<form:form action="managerinsert" modelAttribute="user">

      userId<form:select path="user_id">
				<c:forEach var="list" items="${userservice }">
					<option><c:out value="${list.user_id }" /></option>
				</c:forEach>
			</form:select>
			<br>



			<form:radiobutton path="manager" value="1" />
			管理権限付与
			<form:radiobutton path="manager" value="0" />
			管理権限削除
		<p>
				<button type="submit" name="insert">決定</button>
			<p>
			<p>
				<button type="submit" name="delete">トップに戻る</button>
			<p>
		</form:form>
	</div>
</body>
</html>