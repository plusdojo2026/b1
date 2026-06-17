package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

    private int id;
    private int user_id;
    private int menu_id;
    private int menu_count;
    private int mymenu_id;
    private int mymenu_count;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
	
    public Order(int id, int user_id, int menu_id, int menu_count, int mymenu_id, int mymenu_count,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.menu_id = menu_id;
		this.menu_count = menu_count;
		this.mymenu_id = mymenu_id;
		this.mymenu_count = mymenu_count;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    public Order() {
		super();
		this.id = 0;
		this.user_id = 0;
		this.menu_id = 0;
		this.menu_count = 0;
		this.mymenu_id = 0;
		this.mymenu_count = 0;
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public int getMenu_count() {
		return menu_count;
	}

	public int getMymenu_id() {
		return mymenu_id;
	}

	public int getMymenu_count() {
		return mymenu_count;
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

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public void setMenu_count(int menu_count) {
		this.menu_count = menu_count;
	}

	public void setMymenu_id(int mymenu_id) {
		this.mymenu_id = mymenu_id;
	}

	public void setMymenu_count(int mymenu_count) {
		this.mymenu_count = mymenu_count;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
    
    
    
    
    
}