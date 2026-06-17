package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vote implements Serializable {

    private int id;
    private int user_id;
    private int contest_id;
    private int contestmenu_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
	
    public Vote(int id, int user_id, int contest_id, int contestmenu_id, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.contest_id = contest_id;
		this.contestmenu_id = contestmenu_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    public Vote() {
		super();
		this.id = 0;
		this.user_id = 0;
		this.contest_id = 0;
		this.contestmenu_id = 0;
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getContest_id() {
		return contest_id;
	}

	public int getContestmenu_id() {
		return contestmenu_id;
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

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}

	public void setContestmenu_id(int contestmenu_id) {
		this.contestmenu_id = contestmenu_id;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
    
    
    
}
	