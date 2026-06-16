package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Material implements Serializable {

    private int id;
    private String name;
    private int category;
    private int price;
    private String image;
    private int protein;
    private int df;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
	
    public Material(int id, String name, int category, int price, String image, int protein, int df,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
		this.protein = protein;
		this.df = df;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
    public Material() {
		super();
		this.id = 0;
		this.name = "";
		this.category = 0;
		this.price = 0;
		this.image = "";
		this.protein = 0;
		this.df = 0;
		this.created_at = null;
		this.updated_at = null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public int getProtein() {
		return protein;
	}

	public int getDf() {
		return df;
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

	public void setCategory(int category) {
		this.category = category;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public void setDf(int df) {
		this.df = df;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}
    
    
    
    
    