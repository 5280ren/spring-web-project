<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/css/manager.css">
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
  <div class="top">
	<h1>管理画面</h1>
	<form:form action="manager" modelAttribute="product">
		<p>商品管理画面
		<p />
		<p>
			<form:input path="product_id" placeholder="商品番号" value="${productList.product_id}"/>
		    <form:errors path="product_id" cssStyle="color: red" />
		</p>
		<p>
			<input type="file" name="img" value="${imagesList.img }" />
		    <form:errors path="img" cssStyle="color: red" />
		</p>
		<p>
			<form:input path="product_name" placeholder="商品名" value="${productList.product_name}" />
		    <form:errors path="product_name" cssStyle="color: red" />
		</p>
		<p>
			<form:input path="price" placeholder="価格" value="${productList.price}" />
		    <form:errors path="price" cssStyle="color: red" />
		</p>
		<p>
			<form:input path="stock" placeholder="在庫" value="${productList.stock}"/>
		    <form:errors path="stock" cssStyle="color: red" />
		</p>
		<p>
			<form:input path="meker" placeholder="メーカー"  value="${productList.meker}" />
		    <form:errors path="meker" cssStyle="color: red" />
		</p>
		<p>
			<form:radiobutton path="category_id" value="1" />
			時計
			<form:radiobutton path="category_id" value="2" />
			靴
			<form:radiobutton path="category_id" value="3" />
			服
		    <form:errors path="category_id" cssStyle="color: red" />
		 <p>
			<button type="submit" name="insert">商品の登録または更新</button>
		</p>
		<p>
			<button type="submit" name="delete">商品の削除</button>
		<p/>
		<p>
			<button type="submit" name="ab">トップに戻る</button>
		</p>
		<p>
			<button type="submit" name="manager">新たな管理人の追加</button>
		</p>
	</form:form>
    </div>
</body>
</html>