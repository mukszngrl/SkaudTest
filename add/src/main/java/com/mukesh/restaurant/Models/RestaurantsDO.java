package com.mukesh.restaurant.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantsDO implements Serializable {
    private String business_status;
    GeometryDO geometry;
    private String icon;
    private String name;
    OpeningHoursDO opening_hours;
    ArrayList <PhotosDO> photos = new ArrayList<>();
    private String place_id;
    PlusCodeDO plus_code;
    private float price_level;
    private float rating;
    private String reference;
    private String scope;
    ArrayList <String> types = new ArrayList <> ();
    private float user_ratings_total;
    private String vicinity;

    public String getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(String business_status) {
        this.business_status = business_status;
    }

    public GeometryDO getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryDO geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpeningHoursDO getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(OpeningHoursDO opening_hours) {
        this.opening_hours = opening_hours;
    }

    public ArrayList<PhotosDO> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<PhotosDO> photos) {
        this.photos = photos;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public PlusCodeDO getPlus_code() {
        return plus_code;
    }

    public void setPlus_code(PlusCodeDO plus_code) {
        this.plus_code = plus_code;
    }

    public float getPrice_level() {
        return price_level;
    }

    public void setPrice_level(float price_level) {
        this.price_level = price_level;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public float getUser_ratings_total() {
        return user_ratings_total;
    }

    public void setUser_ratings_total(float user_ratings_total) {
        this.user_ratings_total = user_ratings_total;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
