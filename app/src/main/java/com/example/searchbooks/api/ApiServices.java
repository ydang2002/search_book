package com.example.searchbooks.api;

import com.example.searchbooks.model.Items;
import com.example.searchbooks.response.BooksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("volumes")
    Call<BooksResponse<Items>> searchBooks(
            @Query("q") String query,
            @Query("maxResults") int maxResults,
            @Query("printType") String printType
    );
}
