package com.cyboss.alivio;

import android.net.Uri;

import java.util.Arrays;

/**
 * Created by George on 12-Oct-17.
 */

public class Article {

    public  String id;
    public  String Title;
    public  String Body;
    public  String photo;

public Article(){

}

//    public Article(int id, String title, String body) {
//
//        this.id = id;
//        this.Title = title;
//        this.Body = body;
//
//    }

    public Article(String id, String title, String body,String photo) {
        this.id = id;
        this.Title = title;
        this.Body = body;

        this.photo = photo;
    }

    public String getImageHead() {
        return Title;
    }
    public void setImageHead(String Title){
    this.Title=Title;
    }
    public  String getImageBody() {
        return Body;
    }
    public void setImageBody(String Body){
        this.Body=Body;
    }
    public  String getImageURL() {
        return photo;
    }
    public void setImageURL(String photo){
        this.photo=photo;
    }
}
