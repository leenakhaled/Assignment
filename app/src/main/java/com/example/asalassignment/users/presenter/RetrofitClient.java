package com.example.asalassignment.users.presenter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static volatile RetrofitClient sInstance = null;
    private static final String API_ASAL = "http://jsonplaceholder.typicode.com";
    private Retrofit mRetrofit;

    public Retrofit getRetrofit() {
        return mRetrofit;
    }


    private RetrofitClient() {
        addLoggingIntereptor();
        mRetrofit = new Retrofit.Builder().baseUrl(API_ASAL).addConverterFactory(GsonConverterFactory.create()).client(addLoggingIntereptor().build())
                .build();
    }

    private OkHttpClient.Builder addLoggingIntereptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    public static RetrofitClient getsInstance() {
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