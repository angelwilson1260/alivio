package com.cyboss.alivio;

import com.google.firebase.database.Exclude;

public class contacts extends ContctsID{
    private String Name;
    private String photo;
    private String id;
    private String number;
    private int position;


    public contacts() {}
    public contacts (int position){
        this.position = position;
    }
    public contacts(String name, String imageUrl ,String Des) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        this.Name = name;
        this.photo = imageUrl;
        this.number = Des;
    }
    public String getDescription() {
        return number;
    }
    public void setDescription(String description) {
        this.number = description;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
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
