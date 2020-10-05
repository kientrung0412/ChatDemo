package com.hanabi.thithu.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {

    private static Api api;

    public Api getInstance(Context context){
        if (api != null){
            api =  new Retrofit.Builder()
                    .baseUrl("http://192.168.1.166/chatk32/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api.class);
        }
        return api;
    }

}
