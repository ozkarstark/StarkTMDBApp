package com.ozkarlozoya.starktmdbapp.interfaces;

import com.ozkarlozoya.starktmdbapp.TopMovies;
import com.ozkarlozoya.starktmdbapp.modulos.MovieDetailsDate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("movie/top_rated?api_key=c0b2e3c64ce3c22587fd7940557ceae0")
    Call<TopMovies> getTopMovies();

    @GET("movie/{movie_id}?api_key=c0b2e3c64ce3c22587fd7940557ceae0")
    Call<MovieDetailsDate> getMovieDetail(@Path(value = "movie_id", encoded = true) String userId);
}
