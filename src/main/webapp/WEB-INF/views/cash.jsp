<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>届け先・支払い方法</title>
<link rel="stylesheet"
	href="/css/cash.css">
</head>
<body>
 <div class="top">
	<form:form action="order"  modelAttribute="user">

届け先住所・支払い方法<br>

		<%--<p><form:hidden path=order_date value="${order.order_date}" />${fn:escapeXml(order.order_date)}</p>--%>

		<p><form:hidden path="product_id" value="${productList.product_id}" /></p>

		<c:forEach var="list" items="${userList }">
		<p>
			<form:hidden path="user_id" value="${list.user_id}" />
		</p>
		<p>
			<form:input path="postcode" value="${list.post_code}" /></p>
		<p>
			<form:input path="from_add" value="${list.from_add}" /></p>
		<p>
			<form:input path="from_add2" value="${list.from_add2}" /></p>
        </c:forEach>
		<p>支払い方法</p>
		<form:radiobutton path="payment" value="1"/>現金
        <form:radiobutton path="payment" value="2"/>カード

<p>
			<button type="submit" name="a">確定</button>
			<br>
		</p>
		<p>
			<button type="submit" name="b">キャンセル</button>
			<br>
		</p>
	</form:form>
	</div>
</body>
</html>