<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー</title>
<link rel="stylesheet"
	href="/css/review.css">
</head>
<body>
<div class="top">
	<form:form action="review" modelAttribute="data">
		<h1>レビュー依頼</h1>
		<p>
			<form:input path="user_id" placeholder="ユーザーID"/>
		</p>
		<p>
			<form:input path="review" placeholder="点数"/>
		</p>

		<p>
			<form:textarea path="review_data" placeholder="内容" />
		</p>
		<p>
			<form:input path="product_id" placeholder="商品ID" />
		</p>
		<p>
			<form:input path="date" placeholder="日付" />
		</p>
		<p>
			<button type="submit" name="a">送信</button>
		</p>

		<p>
			<button type="submit" name="return">トップに戻る</button>
		</p>
	</form:form>
	</div>
</body>
</html>