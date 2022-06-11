package com.moringaschool.movie_deck.network.interfaces;


import com.moringaschool.movie_deck.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {
    @GET("trending/all/day")
    Call<Movies> getResults(
            //name it as it is in the API documentation
            @Query("api_key") String apiKey
    );

    @GET("search/movie")
    Call<Movies> searchMovie(
            //name it as it is in the API documentation
            @Query("api_key") String apiKey,
            @Query("query") String term,
            @Query("page") String page
    );
}
