<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Player, java.util.List"%>
<%@ include file="./header.html" %>
<%@ include file="./title.jsp" %>
	<% List<Player> list = (List<Player>) request.getAttribute("player_list"); %>

	<% for (Player p : list) { %>
	<p>チーム略称：<%=p.getTeam_id()%></p>
	<p>背番号：<%=p.getNumber()%></p>
	<p>チーム名：<%=p.getTeam_name()%></p>
	<p>選手名：<%=p.getPlayer_name()%></p>
	<p>ポジション：<%=p.getPosition()%></p>
	<p>投/打：<%=p.getThrowing_batting()%></p>
	<p>身長/体重：<%=p.getHeight()%>cm/<%=p.getWeight()%>kg</p>
	<p>誕生日：<%=p.getBirthday()%></p>
	<p>経歴：<%=p.getCareer()%></p>
	<p>プロ年数：<%=p.getPro_year()%></p>
	<% } %>
	<% if(list.size() == 0){ %>
	<p>対象の選手はいませんでした。</p>
	<% } %>
</body>
</html>