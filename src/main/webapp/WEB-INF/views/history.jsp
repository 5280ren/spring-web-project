<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文履歴</title>
<link rel="stylesheet"
	href="/css/history.css">
</head>
<body>
	<div class="top">
		<h1>注文履歴</h1>
		<form:form action="orderhistory" modelAttribute="user">
			<c:set var="total" value="${0}" />
			<c:forEach var="list" items="${productList}">
				<p>
					<form:hidden path="user_id" value="${list.user_id}" />
				</p>


					商品名
					<form:hidden path="product_name" />
					${list.product_name}
				<br>

					価格
					<form:hidden path="price" />
					${list.price}
				<br>
					メーカー名
					<form:hidden path="meker" />
					${list.meker}<br>
				<br>
				<p><c:set var="total" value="${total+list.price }" /></p>
			</c:forEach>


		合計金額 ${total}

		<p>
				<button type=submit name="ab" value=reset>トップに戻る</button>
			</p>

		</form:form>
	</div>
</body>
</html>