package com.ozkarlozoya.starktmdbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ozkarlozoya.starktmdbapp.adapters.RetrofitAdapter;
import com.ozkarlozoya.starktmdbapp.modulos.MovieDetailsDate;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetails extends AppCompatActivity {

    ImageView movieDetailImg;
    TextView txtTituloDetail;
    TextView txtRankDetail;
    TextView txtDateReleaseDetail;
    TextView txtSinopsisDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieDetailImg=(ImageView)findViewById(R.id.movieDetailImg);
        txtTituloDetail=(TextView)findViewById(R.id.tituloMovieDetail);
        txtRankDetail=(TextView)findViewById(R.id.rankMovieDetail);
        txtDateReleaseDetail=(TextView)findViewById(R.id.dateReleaseMovieDetail);
        txtSinopsisDetail=(TextView)findViewById(R.id.dateSinopsisMovieDetail);

        Intent myIntent = getIntent(); // gets the previously created intent
        String idMovie = myIntent.getStringExtra("idmovie");
        System.out.println("sara2: "+idMovie);
        PeticionDetalle(idMovie);
    }

    private void PeticionDetalle(String idMovie) {
        Call<MovieDetailsDate> call= RetrofitAdapter.getApiService().getMovieDetail(idMovie);
        call.enqueue(new Callback<MovieDetailsDate>() {
            @Override
            public void onResponse(Call<MovieDetailsDate> call, Response<MovieDetailsDate> response) {
                String urlMovieDetail="https://image.tmdb.org/t/p/original"+response.body().poster_path;
                Picasso.get().load(urlMovieDetail).into(movieDetailImg);
                int unicode = 0x1F4AB;
                String emoji = new String(Character.toChars(unicode));
                txtTituloDetail.setText(response.body().title);
                txtRankDetail.setText(emoji+" "+response.body().vote_average);
                txtDateReleaseDetail.setText(response.body().release_date+"");
                txtSinopsisDetail.setText(response.body().overview+"");
            }

            @Override
            public void onFailure(Call<MovieDetailsDate> call, Throwable t) {

            }
        });
    }
}