package com.ozkarlozoya.starktmdbapp.adapters;

import com.ozkarlozoya.starktmdbapp.interfaces.RetrofitInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static RetrofitInterface API_SERVICE;

    public static RetrofitInterface getApiService(){
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl="https://api.themoviedb.org/3/";

        if(API_SERVICE==null){
            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            API_SERVICE=retrofit.create(RetrofitInterface.class);
        }
        return API_SERVICE;
    }
}
