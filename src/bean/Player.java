package bean;

import java.util.Date;

public class Player {
	private String team_id;
	private String number;
	private String team_name;
	private String player_name;
	private String position;
	private String throwing_batting;
	private int height;
	private int weight;
	private Date birthday;
	private String career;
	private int pro_year;

	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getThrowing_batting() {
		return throwing_batting;
	}
	public void setThrowing_batting(String throwing_batting) {
		this.throwing_batting = throwing_batting;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getPro_year() {
		return pro_year;
	}
	public void setPro_year(int pro_year) {
		this.pro_year = pro_year;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
