package com.cyboss.alivio;

import android.location.Location;

public class FirebaseLocationData {
    String email;
    double latitude;
    double longitude;
    String time;
    String sos_time;
    boolean privacy = false;
    String uid;

    public FirebaseLocationData(String email, double latitude, double longitude, String time, String sos_time, boolean privacy, String uid) {
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.sos_time = sos_time;
        this.privacy = privacy;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }



    public FirebaseLocationData() {

    }

    public FirebaseLocationData(String email, double latitude, double longitude, String time, String sos_time) {
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.sos_time = sos_time;

    }


    public String getSos_time() {
        return sos_time;
    }

    public void setSos_time(String sos_time) {
        this.sos_time = sos_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}

