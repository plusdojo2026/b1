package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Category implements Serializable {

    private int id;
    private String name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
	
    public Category(int id, String name, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    public Category() {
		super();
		this.id = 0;
		this.name = "";
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
    
    
    
}