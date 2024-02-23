package com.example.searchbooks.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookApiClient {
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiServices getService() {
        return retrofit.create(ApiServices.class);
    }
}
