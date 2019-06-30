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
				"root", "xxxxxxxxxxxxx");

		PreparedStatement st = con.prepareStatement("select * from player inner join team on player.team_id = team.team_id where team.team_id=? and number=?");
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

}
