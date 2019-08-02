<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="uniform_number.SearchAction, java.util.List" %>
<%@ include file="./header.html" %>
<%@ include file="./title.jsp" %>
<form action="search" method="post">
	<table>
		<tr>
			<td><label><input class="radio" type="radio" name="team" value="L">ライオンズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="H">ホークス</label></td>
			<td><label><input class="radio" type="radio" name="team" value="F">ファイターズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="M">マリーンズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="B">バファローズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="E">イーグルス</label></td>
		</tr>
		<tr>
			<td><label><input class="radio" type="radio" name="team" value="C">カープ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="S">ヤクルト</label></td>
			<td><label><input class="radio" type="radio" name="team" value="G">ジャイアンツ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="De">ベイスターズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="D">ドラゴンズ</label></td>
			<td><label><input class="radio" type="radio" name="team" value="T">タイガース</label></td>
		</tr>
	</table>
	<div class="button_wrapper">
		<input class="inputBox" type="text" name="number" autocomplete="off">
		<input class="btn" type="submit" value="検索">
	</div>
</form>
	<% List<String> e_list = (List<String>) request.getAttribute("error"); %>
	<% if(e_list == null){ %>
	<% }else{ %>
		<% for (Object error : e_list) { %>
		<p class="error"><% out.println(error); %></p>
		<% } %>
	<% } %>
<%@ include file="./footer.html" %>