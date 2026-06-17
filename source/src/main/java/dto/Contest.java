package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Contest implements Serializable {

    private int id;
    private String name;
    private LocalDateTime start_at;
    private LocalDateTime end_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
	
    public Contest(int id, String name, LocalDateTime start_at, LocalDateTime end_at, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.start_at = start_at;
		this.end_at = end_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    public Contest() {
		super();
		this.id = 0;
		this.name = "";
		this.start_at = null;
		this.end_at = null;
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getStart_at() {
		return start_at;
	}

	public LocalDateTime getEnd_at() {
		return end_at;
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

	public void setStart_at(LocalDateTime start_at) {
		this.start_at = start_at;
	}

	public void setEnd_at(LocalDateTime end_at) {
		this.end_at = end_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
    
    
}