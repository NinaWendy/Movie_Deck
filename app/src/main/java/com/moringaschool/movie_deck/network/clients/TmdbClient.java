package com.moringaschool.movie_deck.network.clients;

import com.moringaschool.movie_deck.models.Constants;
import com.moringaschool.movie_deck.network.interfaces.TmdbApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbClient {
    //Singleton pattern to ensure that only one Retrofit instance will be created for the duration of our pattern
    private static Retrofit retrofit = null;

    public static TmdbApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.TMDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // handles data serialization from JSON to Java objects
                    .build();
        }

        return retrofit.create(TmdbApi.class);
    }
}
