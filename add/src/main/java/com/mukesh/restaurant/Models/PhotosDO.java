package com.mukesh.restaurant.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class PhotosDO implements Serializable {
    private float height;
    ArrayList<String> html_attributions = new ArrayList<>();
    private String photo_reference;
    private float width;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public ArrayList<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(ArrayList<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
