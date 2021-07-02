<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報変更画面</title>
<link rel="stylesheet" href="/css/update.css">
</head>
<body>
	<div class="top">
		<h1>ユーザー情報変更</h1>
		<form:form action="update" modelAttribute="user">
			<div class="footer">
			<p>  現在のIDを入力してください:<form:input path="user_id" /></p>

				<p>現在のニックネーム:<form:input path="nickname"/></p>

				<p>現在のパスワード入力してください：<form:input path="pass_word"/></p>

				<p>
					新しいニックネーム：<form:input path="nickname"/>
				</p>
				<p>
					新しいパスワード：<form:input path="pass_word"/>
				</p>
			</div>
			<button type="submit" name="update">変更</button>
			<button type="submit" name="return" >トップに戻る</button>
	  </form:form>

	</div>

</body>
</html>