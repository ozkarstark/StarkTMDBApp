package com.ozkarlozoya.starktmdbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.ozkarlozoya.starktmdbapp.adapters.MyAdapter;
import com.ozkarlozoya.starktmdbapp.adapters.RetrofitAdapter;
import com.ozkarlozoya.starktmdbapp.interfaces.InterfaceEkis;
import com.ozkarlozoya.starktmdbapp.modulos.MovieInfo;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<MovieInfo> movieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InterfaceM();
    }

    private void InterfaceM() {
        InterfaceEkis ekis=new InterfaceEkis() {
            @Override
            public void Peticion() {
                Call<TopMovies> call= RetrofitAdapter.getApiService().getTopMovies();
                call.enqueue(new Callback<TopMovies>() {
                    @Override
                    public void onResponse(Call<TopMovies> call, Response<TopMovies> response) {

                        System.out.println("liz: "+response.body().results.size());
                        for(int x=0; x<response.body().results.size();x++){

                            String urlImg="https://image.tmdb.org/t/p/original"+response.body().results.get(x).poster_path;

                            movieList.add(new MovieInfo(response.body().results.get(x).title.toString(), response.body().results.get(x).release_date.toString(),urlImg,response.body().results.get(x).id,response.body().results.get(x).vote_average+""));
                        }
                        viewPager=(HorizontalInfiniteCycleViewPager)findViewById(R.id.view_pager);
                        MyAdapter adapter=new MyAdapter(getApplicationContext(), movieList);
                        viewPager.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<TopMovies> call, Throwable t) {

                    }
                });
            }
        };
        ekis.Peticion();
    }
}