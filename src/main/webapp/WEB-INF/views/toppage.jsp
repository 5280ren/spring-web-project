<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
<link rel="stylesheet"
	href="/css/toppage.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js">
</script>
</head>
<body>


     <div class="form">
		<div class="top">
		    <c:forEach var="list" items="${userList }">
		       <p>userID:<c:out value="${list.user_id }"/></p>
		        <p>ようこそ<c:out value="${list.nickname }"/>さん。</p>
		    </c:forEach>
			<h1>トップページ</h1>
		</div>

		<div class="picuture">
			<h2>商品一覧</h2>
            <c:forEach var="list" items="${imagelist}">
				<div class="img">
					<a href="product?product_id=${list.product_id }"><img src="${list.img }"
						width="200" height="200" align="bottom"/>
					詳細</a>
				</div>
			</c:forEach>

		</div>
</div>


		<div class="footer">
			<form:form action="category" modelAttribute="product">

			<h3>カテゴリ</h3>

			<form:radiobutton path="category_id" value="1"/>時計 <form:radiobutton
				path="category_id" value="2"/>靴 <form:radiobutton path="category_id" value="3"/>服
			<button type="submit" name="submit">検索</button>
           </form:form>


           <form:form action="cash" modelAttribute="user">
			<p>
				<button type="submit" name="cart">カートの中</button>
			</p>
			<p>
				<button type="submit" name="historys">注文履歴</button>
			</p>
			<p>
				<button type="submit" name="update">ユーザー情報変更</button>
			</p>
			<p>
			   <button type="submit" name="reviews">レビュー依頼</button>
			</p>
			<p>
			    <button type="submit" name="rogout">ログアウト</button>
			</p>
			<p>
			    <c:forEach var="manager" items="${userList}">

			    <c:if test="${manager.manager==1 }">
			    <button type="submit"name="manager">管理画面</button>
			    </c:if>

			    <c:if test="${manager.manager!=1 }">

			    </c:if>
			  </c:forEach>
			</p>
		   </form:form>
		</div>



	<script>
		$(function() {
			$('.img').hide(70).fadeIn(3700);
		});
	</script>
</body>
</html>