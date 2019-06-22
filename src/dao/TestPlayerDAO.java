//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import bean.Player;
//
//public class PlayerDAO {
//	public List<Player> search(String team, int number) throws Exception {
//
//		List<Player> list = new ArrayList<>();
//
//		Connection con = null;
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=JST",
//				"root", "xxxxxxxxxxxx");
//
//		PreparedStatement st = con.prepareStatement(
//				"select * from player where team=? and number=?");
//		st.setString(1, team);
//		st.setInt(2, number);
//		ResultSet rs = st.executeQuery();
//
//		while (rs.next()) {
//			Player p = new Player();
//			p.setTeam(rs.getString("team"));
//			p.setNumber(rs.getInt("number"));
//			p.setTeam_name(rs.getString("team_name"));
//			p.setPlayer_name(rs.getString("player_name"));
//			p.setPosition(rs.getString("position"));
//			p.setThrowing_batting(rs.getString("throwing_batting"));
//			p.setHeight(rs.getInt("height"));
//			p.setWeight(rs.getInt("weight"));
//			p.setBirthday(rs.getDate("birthday"));
//			p.setPro_year(rs.getInt("pro_year"));
//
//			list.add(p);
//		}
//
//		st.close();
//		con.close();
//
//		return list;
//
//	}
//
//}
