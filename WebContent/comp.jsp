<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.html" %>
<%@ include file="./title.jsp" %>
	<% String message = (String) request.getAttribute("message"); %>
	<p><%= message %></p>
</body>
</html>