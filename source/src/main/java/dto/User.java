package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
	private int id;
	private String phone; 
	private String pw; 
	private String name;
	private int rank_id;
	private String icon;
	private int vote;
	private int levelup_menu;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public User(int id, String phone, String pw, String name, int rank_id, String icon, int vote, int levelup_menu,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.phone = phone;
		this.pw = pw;
		this.name = name;
		this.rank_id = rank_id;
		this.icon = icon;
		this.vote = vote;
		this.levelup_menu = levelup_menu;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public User() {
		super();
		this.id = 0;
		this.phone = "";
		this.pw = "";
		this.name = "";
		this.rank_id = 0;
		this.icon = "";
		this.vote = 0;
		this.levelup_menu = 0;
		this.created_at = null;
		this.updated_at = null;
	}
	public int getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getRank_id() {
		return rank_id;
	}

	public String getIcon() {
		return icon;
	}

	public int getVote() {
		return vote;
	}

	public int getLevelup_menu() {
		return levelup_menu;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRank_id(int rank_id) {
		this.rank_id = rank_id;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public void setLevelup_menu(int levelup_menu) {
		this.levelup_menu = levelup_menu;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}	
}