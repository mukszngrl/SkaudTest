package com.mukesh.restaurant.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantResponse implements Serializable {
    ArrayList<Object> html_attributions = new ArrayList<>();
    ArrayList<RestaurantsDO> results = new ArrayList<>();
    private String status;

    public ArrayList<Object> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(ArrayList<Object> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public ArrayList<RestaurantsDO> getResults() {
        return results;
    }

    public void setResults(ArrayList<RestaurantsDO> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
