package com.example.asalassignment.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {
    private static volatile RetrofitClient sInstance = null;
    private static final String API_PHOTOS = "http://jsonplaceholder.typicode.com";
    private Retrofit mRetrofit;

    Retrofit getRetrofit() {
        return mRetrofit;
    }


    private RetrofitClient() {
        addLoggingIntereptor();
        mRetrofit = new Retrofit.Builder().baseUrl(API_PHOTOS).addConverterFactory(GsonConverterFactory.create()).client(addLoggingIntereptor().build())
                .build();
    }

    private OkHttpClient.Builder addLoggingIntereptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    static RetrofitClient getsInstance() {
        if (sInstance == null) {
            synchronized (RetrofitClient.class) {
                if (sInstance == null) {
                    sInstance = new RetrofitClient();
                }
            }
        }
        return sInstance;
    }
}