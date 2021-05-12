package com.ozkarlozoya.starktmdbapp.modulos;

import java.util.List;

public class MovieDetailsDate{
    public boolean adult;
    public String backdrop_path;
    public Object belongs_to_collection;
    public int budget;
    public List<Genre> genres;
    public String homepage;
    public int id;
    public String imdb_id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public List<ProductionCompany> production_companies;
    public List<ProductionCountry> production_countries;
    public String release_date;
    public int revenue;
    public int runtime;
    public List<SpokenLanguage> spoken_languages;
    public String status;
    public String tagline;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;
}

class Genre{
    public int id;
    public String name;
}

class ProductionCompany{
    public int id;
    public String logo_path;
    public String name;
    public String origin_country;
}

class ProductionCountry{
    public String iso_3166_1;
    public String name;
}

class SpokenLanguage{
    public String english_name;
    public String iso_639_1;
    public String name;
}


