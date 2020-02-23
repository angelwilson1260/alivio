package com.cyboss.alivio;
import com.google.firebase.database.Exclude;

public class Model {
    private String Title;
    private String photo;
    private String id;
    private String Body;
    private int position;

    public Model() {
        //empty constructor needed
    }
    public Model (int position){
        this.position = position;
    }
    public Model(String name, String imageUrl ,String Des) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        this.Title = name;
        this.photo = imageUrl;
        this.Body = Des;
    }
    public String getDescription() {
        return Body;
    }
    public void setDescription(String description) {
        this.Body = description;
    }

    public String getName() {
        return Title;
    }
    public void setName(String name) {
        this.Title = name;
    }
    public String getImageUrl() {
        return photo;
    }
    public void setImageUrl(String imageUrl) {
        this.photo = imageUrl;
    }
    @Exclude
    public String getKey() {
        return id;
    }
    @Exclude
    public void setKey(String key) {
        this.id = key;
    }
}