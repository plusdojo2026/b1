package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Menu implements Serializable {

    private int id;
    private String name;
    private String image;
    private int buns;
    private int patty1;
    private int patty2;
    private int patty3;
    private int vege1;
    private int vege2;
    private int vege3;
    private int topping1;
    private int topping2;
    private int topping3;
    private int sauce;
    private int price;
    private int judge;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Menu() {
        this.id = 0;
        this.name = "";
        this.image = "";
        this.buns = 0;
        this.patty1 = 0;
        this.patty2 = 0;
        this.patty3 = 0;
        this.vege1 = 0;
        this.vege2 = 0;
        this.vege3 = 0;
        this.topping1 = 0;
        this.topping2 = 0;
        this.topping3 = 0;
        this.sauce = 0;
        this.price = 0;
        this.judge = 0;
        this.created_at = null;
        this.updated_at = null;
    }

    public Menu(
            int id,
            String name,
            String image,
            int buns,
            int patty1,
            int patty2,
            int patty3,
            int vege1,
            int vege2,
            int vege3,
            int topping1,
            int topping2,
            int topping3,
            int sauce,
            int price,
            int judge,
            LocalDateTime created_at,
            LocalDateTime updated_at) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.buns = buns;
        this.patty1 = patty1;
        this.patty2 = patty2;
        this.patty3 = patty3;
        this.vege1 = vege1;
        this.vege2 = vege2;
        this.vege3 = vege3;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.sauce = sauce;
        this.price = price;
        this.judge = judge;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // ===== getter =====

    public int getId() { return id; }
    public String getName() { return name; }
    public String getImage() { return image; }
    public int getBuns() { return buns; }
    public int getPatty1() { return patty1; }
    public int getPatty2() { return patty2; }
    public int getPatty3() { return patty3; }
    public int getVege1() { return vege1; }
    public int getVege2() { return vege2; }
    public int getVege3() { return vege3; }
    public int getTopping1() { return topping1; }
    public int getTopping2() { return topping2; }
    public int getTopping3() { return topping3; }
    public int getSauce() { return sauce; }
    public int getPrice() { return price; }
    public int getJudge() { return judge; }
    public LocalDateTime getCreated_at() { return created_at; }
    public LocalDateTime getUpdated_at() { return updated_at; }

    // ===== setter =====

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setImage(String image) { this.image = image; }
    public void setBuns(int buns) { this.buns = buns; }
    public void setPatty1(int patty1) { this.patty1 = patty1; }
    public void setPatty2(int patty2) { this.patty2 = patty2; }
    public void setPatty3(int patty3) { this.patty3 = patty3; }
    public void setVege1(int vege1) { this.vege1 = vege1; }
    public void setVege2(int vege2) { this.vege2 = vege2; }
    public void setVege3(int vege3) { this.vege3 = vege3; }
    public void setTopping1(int topping1) { this.topping1 = topping1; }
    public void setTopping2(int topping2) { this.topping2 = topping2; }
    public void setTopping3(int topping3) { this.topping3 = topping3; }
    public void setSauce(int sauce) { this.sauce = sauce; }
    public void setPrice(int price) { this.price = price; }
    public void setJudge(int judge) { this.judge = judge; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
    public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at; }
}