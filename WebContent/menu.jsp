<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.html"%>
<%@ include file="./title.jsp" %>
<%@ page import="bean.Player, java.util.List" %>
<% String user = (String) request.getParameter("user"); %>
<% if(user != null){ %>
<p>ログイン成功</p>
<p>こんにちは、<%=user %>さん</p>
<% }else{ %>
<% } %>
<% String message = (String) request.getAttribute("message"); %>
<% if(message != null){ %>
<p class="error"><%=message %></p>
<% } %>
<% List<String> e_list = (List<String>) request.getAttribute("error"); %>
<% if(e_list == null){ %>
<% }else{ %>
	<% for (Object error : e_list) { %>
	<p class="error"><% out.println(error); %></p>
	<% } %>
<% } %>
<form action="conf" method="post">
	<table>
		<tr>
		<td class="TradeTable">
			<select name="team1">
				<option value="">チームを選んでください</option>
				<option value="L">ライオンズ</option>
				<option value="H">ホークス</option>
				<option value="F">ファイターズ</option>
				<option value="M">マリーンズ</option>
				<option value="B">バファローズ</option>
				<option value="E">イーグルス</option>
				<option value="C">カープ</option>
				<option value="S">スワローズ</option>
				<option value="G">ジャイアンツ</option>
				<option value="De">ベイスターズ</option>
				<option value="D">ドラゴンズ</option>
				<option value="T">タイガース</option>
			</select>
		</td>
		<td rowspan="2" class="TradeTable">
			⇔
		</td>
		<td class="TradeTable">
			<select name="team2">
				<option value="">チームを選んでください</option>
				<option value="L">ライオンズ</option>
				<option value="H">ホークス</option>
				<option value="F">ファイターズ</option>
				<option value="M">マリーンズ</option>
				<option value="B">バファローズ</option>
				<option value="E">イーグルス</option>
				<option value="C">カープ</option>
				<option value="S">スワローズ</option>
				<option value="G">ジャイアンツ</option>
				<option value="De">ベイスターズ</option>
				<option value="D">ドラゴンズ</option>
				<option value="T">タイガース</option>
			</select>
		</td>
		</tr>
		<tr>
		<td class="TradeTable">
			<input class="inputBox" type="text" name="number1" autocomplete="off">
		</td>
		<td class="TradeTable">
			<input class="inputBox" type="text" name="number2" autocomplete="off">
		</td>
		</tr>
	</table>
	<input class="btn" type="submit" value="トレード">
</form>
	<% List<Player> TradeList = (List<Player>) session.getAttribute("TradeList"); %>
	<% if(TradeList != null){ %>
		<% for (Player p : TradeList) { %>
		<p>チーム名：<%=p.getTeam_name()%>
		背番号：<%=p.getNumber()%>
		選手名：<%=p.getPlayer_name()%></p>
		<% } %>
		<p>以上の選手を入れ替えますか？</p>
<form action="trade" method="post">
	<input class="btn" type="submit" value="はい">
</form>
<form action="menu.jsp" method="post">
	<% //session.removeAttribute("TradeList"); %>
	<% //「いいえ」を押下したらセッションを破棄するようにしたい %>
	<input class="btn" type="submit" value="いいえ">
</form>
	<% } %>

<form action="logout" method="post">
	<input class="btn" type="submit" value="ログアウトする">
</form>
</body>
</html>