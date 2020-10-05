package com.hanabi.thithu.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiBuilder {

    private static Api api;

    public static Api getInstance(){
        if (api == null){
            api =  new Retrofit.Builder()
                    .baseUrl("http://192.168.1.166/chatk32/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api.class);
        }
        return api;
    }

}
