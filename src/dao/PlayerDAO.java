package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Player;

public class PlayerDAO {
	public List<Player> search(String team, String number) throws Exception {

		List<Player> list = new ArrayList<>();

		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=JST",
				"root", "xxxxxxxx");

		PreparedStatement st = con.prepareStatement(
				"select * from player inner join team on player.team_id = team.team_id where team.team_id=? and number=?");
		st.setString(1, team);
		st.setString(2, number);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Player p = new Player();
			p.setNumber(rs.getString("number"));
			p.setTeam_name(rs.getString("team_name"));
			p.setPlayer_name(rs.getString("player_name"));
			p.setPosition(rs.getString("position"));
			p.setThrowing_batting(rs.getString("throwing_batting"));
			p.setHeight(rs.getInt("height"));
			p.setWeight(rs.getInt("weight"));
			p.setBirthday(rs.getDate("birthday"));
			p.setCareer(rs.getString("career"));
			p.setPro_year(rs.getInt("pro_year"));

			list.add(p);
		}

		st.close();
		con.close();

		return list;

	}

	public boolean trade(String team1, String number1, String team2, String number2, String EndCareer1, String EndCareer2) throws Exception {

		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=JST",
				"root", "xxxxxxxx");

		//update文のオートコミットを無効にする
		con.setAutoCommit(false);

		String KariNumber = "99" + number1;

		PreparedStatement st = con
				.prepareStatement("update player set team_id=?, number=?, career=concat(career, ?) where team_id=? and number=?");
		st.setString(1, team1);
		st.setString(2, KariNumber);
		st.setString(3, EndCareer1);
		st.setString(4, team2);
		st.setString(5, number2);
		st.addBatch();

		st.setString(1, team2);
		st.setString(2, number2);
		st.setString(3, EndCareer2);
		st.setString(4, team1);
		st.setString(5, number1);
		st.addBatch();

		st.setString(1, team1);
		st.setString(2, number1);
		st.setString(3, "");
		st.setString(4, team1);
		st.setString(5, KariNumber);
		st.addBatch();

		int cnt[] = st.executeBatch();
		if (cnt[0] == 1 && cnt[1] == 1 && cnt[2] == 1) {
			con.commit();
			//オートコミットを有効にしておく
			con.setAutoCommit(true);
			st.close();
			con.close();
			return true;

		} else {
			con.rollback();
			//オートコミットを有効にしておく
			con.setAutoCommit(true);
			st.close();
			con.close();
			return false;
		}
	}

	public List<Player> conf(String team1, String number1, String team2, String number2) throws Exception {

		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=JST",
				"root", "xxxxxxxx");

		List<Player> list = new ArrayList<>();

		PreparedStatement st = con
				.prepareStatement("select * from player inner join team on player.team_id = team.team_id where team.team_id=? and number=? or team.team_id=? and number=?");
		st.setString(1, team1);
		st.setString(2, number1);
		st.setString(3, team2);
		st.setString(4, number2);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Player p = new Player();
			p.setNumber(rs.getString("number"));
			p.setTeam_id(rs.getString("team_id"));
			p.setTeam_name(rs.getString("team_name"));
			p.setPlayer_name(rs.getString("player_name"));
			p.setCareer(rs.getString("career"));

			list.add(p);
		}

		st.close();
		con.close();

		return list;

	}

}
