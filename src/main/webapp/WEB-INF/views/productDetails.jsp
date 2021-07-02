<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
<link rel="stylesheet"
	href="/css/productDetails.css">
</head>
<body>
	<div class="top">
		<h1>商品詳細</h1>
		<form:form action="product" modelAttribute="productall">

			<p>
				<img src=${imagesList.img } width="200" height="200" align="bottom"> <input type="hidden" name=img
					value="${imagesList.img }"/>
			</p>
			<p>
				商品ID
				<form:hidden path="product_id" value="${productList.product_id}" />${productList.product_id}</p>
			<p>
				商品名
				<form:hidden path="product_name"
					value="${productList.product_name }" />${productList.product_name }</p>
			<p>
				価格
				<form:hidden path="price" value="${productList.price }" />${productList.price }</p>
			<p>
				在庫数
				<form:hidden path="stock" value="${productList.stock }" />
				${productList.stock }
			</p>
			<p>
				メーカー名
				<form:hidden path="meker" value="${productList.meker }" />
				${productList.meker }
			</p>


			<div class="middle">

				<p>
					<button type="submit" name="a" value=top>トップに戻る</button>
				</p>


				<p>
					<button type="submit" name="cart" value=cart>カートに入れる</button>
				</p>

			</div>

		</form:form>
		<form:form action="cash" modelAttribute="user">
			<p>
				<c:forEach var="manager" items="${userList}">

					<c:if test="${manager.manager==1 }">
						<button type="submit" name="manager">管理画面</button>
					</c:if>

					<c:if test="${manager.manager!=1 }">

					</c:if>
				</c:forEach>
			</p>
		</form:form>
	</div>
</body>
</html>