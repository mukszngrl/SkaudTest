package com.mukesh.restaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mukesh.restaurant.Models.RestaurantResponse;
import com.mukesh.restaurant.RetroAPI.APICall;
import com.mukesh.restaurant.RetroAPI.APICallbackListener;
import com.mukesh.restaurant.RetroAPI.APIClient;
import com.mukesh.restaurant.RetroAPI.APIInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements APICallbackListener {

    APIInterface apiInterface;
    APICall apiCall;
    String apiKey = "AIzaSyD0AQBJ_BwInY5Tv_0tqGPJIWL7FcllnH0";
    EditText etSearchBox;
    RecyclerView rvRestaurantList;
    RestaurantAdaptor restaurantAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseControls();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        apiCall = new APICall(this);
        String location = "17.43307229259422,78.44854345440416";
        String radius = "2500";
        String type = "restaurant";

        Call<RestaurantResponse> call = apiInterface.getNearbyRestaurants(location, radius, type, apiKey);
        apiCall.setCall(call);
    }

    private void initialiseControls() {
        //initialising views
        etSearchBox = findViewById(R.id.etSearchBox);
        rvRestaurantList = findViewById(R.id.rvRestaurantList);

        rvRestaurantList.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurantList.setAdapter(restaurantAdaptor = new RestaurantAdaptor(this));

        etSearchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Call<RestaurantResponse> call;
                String location = "17.43307229259422,78.44854345440416";
                String radius = "2500";
                String type = "restaurant";
                if (TextUtils.isEmpty(editable.toString()))
                    call = apiInterface.getNearbyRestaurants(location, radius, type, apiKey);
                else
                    call = apiInterface.getNearbyRestaurantsBySearch(location, radius, type, editable.toString(), apiKey);
                apiCall.setCall(call);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(Response<Object> response) {
        if (response != null) {
            if (response.body() instanceof RestaurantResponse) {
                RestaurantResponse restaurantResponse = (RestaurantResponse) response.body();
                if (restaurantResponse.getResults() != null && restaurantResponse.getResults().size() > 0) {
                    restaurantAdaptor.refresh(restaurantResponse.getResults());
                }
            }
        }
    }

    @Override
    public void onError(ResponseBody responseBody) {
        if (responseBody != null) {
            Toast.makeText(getApplicationContext(), responseBody.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong...!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
