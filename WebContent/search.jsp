<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="uniform_number.SearchAction, java.util.List" %>
<%@ include file="./header.html" %>
<%@ include file="./title.jsp" %>
<form action="search" method="post">
	<table>
		<tr>
			<td><input type="radio" name="team" value="L">ライオンズ</td>
			<td><input type="radio" name="team" value="H">ホークス</td>
			<td><input type="radio" name="team" value="F">ファイターズ</td>
			<td><input type="radio" name="team" value="M">マリーンズ</td>
			<td><input type="radio" name="team" value="B">バファローズ</td>
			<td><input type="radio" name="team" value="E">イーグルス</td>
		</tr>
		<tr>
			<td><input type="radio" name="team" value="C">カープ</td>
			<td><input type="radio" name="team" value="S">ヤクルト</td>
			<td><input type="radio" name="team" value="G">ジャイアンツ</td>
			<td><input type="radio" name="team" value="De">ベイスターズ</td>
			<td><input type="radio" name="team" value="D">ドラゴンズ</td>
			<td><input type="radio" name="team" value="T">タイガース</td>
		</tr>
	</table>
	<div class="button_wrapper">
		<input type="text" name="number">
		<input type="submit" value="検索">
	</div>
</form>
	<% List<String> e_list = (List<String>) request.getAttribute("error"); %>
	<% if(e_list == null){ %>
	<% }else{ %>
		<% for (Object error : e_list) { %>
		<p class="error"><% out.println(error); %></p>
		<% } %>
	<% } %>
</body>
</html>