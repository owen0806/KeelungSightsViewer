package com.example;

public class Sight implements java.io.Serializable {
    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String description;
    private String address;

    public String getSightName() {
        return sightName;
    }

    public String getZone() {
        return zone;
    }

    public String getCategory() {
        return category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return ("com.example.Sight Name: " + getSightName() + "\n"
        + "Zone: " + getZone() + "\n"
        + "Category: " + getCategory() + "\n"
        + "PhotoURL: " + "\n" + getPhotoURL() + "\n"
        + "Description: " + getDescription() + "\n"
        + "Address: " + getAddress() + "\n");
    }
}
