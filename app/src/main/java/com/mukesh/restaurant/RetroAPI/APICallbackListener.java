package com.mukesh.restaurant.RetroAPI;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Mukesh.Zingare on 09/01/17.
 */

public interface APICallbackListener {
    void onSuccess(Response<Object> response);
    void onError(ResponseBody responseBody);
}
