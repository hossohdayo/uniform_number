<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="uniform_number.LogoutAction, uniform_number.LoginAction, java.util.List" %>
<%@ include file="./header.html" %>
<%@ include file="./title.jsp" %>
<p class="error">
	<% String LogOutMessage = (String)request.getAttribute("LogoutMessage"); %>
	<% if(LogOutMessage != null){ %>
		<% out.println(LogOutMessage); %>
		<% } %>
</p>
<form action="login" method="post">
	<p>ログイン名<input class="inputBox" type="text" name="user" autocomplete="off"></p>
	<p>パスワード<input class="inputBox" type="password" name="password" autocomplete="off"></p>
	<p><input class="btn" type="submit"value="ログイン"></p>
</form>
	<% List<String> e_list = (List<String>) request.getAttribute("LoginError"); %>
	<% if(e_list == null){ %>
	<% }else{ %>
		<% for (Object error : e_list) { %>
		<p class="error"><% out.println(error); %></p>
		<% } %>
	<% } %>
</body>
</html>