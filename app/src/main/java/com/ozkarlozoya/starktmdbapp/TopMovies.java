package com.ozkarlozoya.starktmdbapp;

import java.util.List;

public class TopMovies{
    public int page;
    public List<Result> results;
    public int total_pages;
    public int total_results;
}

class Result{
    public boolean adult;
    public String backdrop_path;
    public List<Integer> genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;
}
