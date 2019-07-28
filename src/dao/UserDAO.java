package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class UserDAO {
	public User login(String name, String password) throws Exception {
		User user = null;
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=JST",
				"root", "xxxxxxxx");

		PreparedStatement st = con.prepareStatement("select * from user where name=? and password=?");
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			user = new User();
			user.setUser(name);
			user.setPassword(password);
		}

		st.close();
		con.close();

		return user;
	}
}
