<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中</title>
<link rel="stylesheet" href="/css/cart.css">
</head>
<body>
	<div class="top">
		<h1>カートの中</h1>
		<form:form action="carts" modelAttribute="productsave">


         <div class="center">
			<c:set var="total" value="${0}" />

			<c:forEach var="dto" items="${dto}">

				商品ID <form:hidden path="product_id" value="${dto.product_id}" /> ${dto.product_id}<br>
				商品名 <form:hidden path="product_name" value="${dto.product_name}" /> ${dto.product_name}<br>
				価格 <form:hidden path="price" value="${dto.price}" /> ${dto.price}<br>
				在庫 <form:hidden path="stock" value="${dto.stock}" /> ${dto.stock}<br>
			    メーカー名 <form:hidden path="meker" value="${dto.meker}" /> ${dto.meker}<br>
				<p><c:set var="total" value="${total+dto.price }" /></p>
			</c:forEach>
			<p><button type="submit" name="remove" value=top>カートの中を削除</button></p>
			合計金額 ${total}
			</div>
			<div class="middle">
				<p>
					<button type="submit" name="top" value=top>トップページに戻る</button>
					<button type="submit" name="cash" value=cash>レジへ進む</button>
				</p>
			</div>
		</form:form>
	</div>
</body>
</html>