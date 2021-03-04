package com.mukesh.restaurant.RetroAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mukesh.Zingare on 05/01/17.
 */

public class APICall {
    private Call call;
    private APICallbackListener callbackListener;

    public APICall(APICallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

    public void setCall(Object call) {
        this.call = (Call) call;
        getResult();
    }

    private void getResult() {
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.body() != null && response.isSuccessful()) {
                    callbackListener.onSuccess(response);
                } else {
                    callbackListener.onError(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
