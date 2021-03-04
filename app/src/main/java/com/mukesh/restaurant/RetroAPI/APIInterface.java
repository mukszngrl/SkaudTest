package com.mukesh.restaurant.RetroAPI;

import com.mukesh.restaurant.Models.RestaurantResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mukesh.Zingare on 09/01/17.
 */

public interface APIInterface {

    @GET("/maps/api/place/nearbysearch/json?")
    Call<RestaurantResponse> getNearbyRestaurants(@Query("location") String location, @Query("radius") String radius,
                                                  @Query("type") String type, @Query("key") String key);

    @GET("/maps/api/place/nearbysearch/json?")
    Call<RestaurantResponse> getNearbyRestaurantsBySearch(@Query("location") String location, @Query("radius") String radius,
                                              @Query("type") String type, @Query("keyword") String keyword, @Query("key") String key);
}
