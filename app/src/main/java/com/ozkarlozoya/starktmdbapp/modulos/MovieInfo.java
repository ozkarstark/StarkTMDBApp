package com.ozkarlozoya.starktmdbapp.modulos;

public class MovieInfo {

    private String name;
    private String description;
    private String image;
    private int id;
    private String calificacionT;

    public MovieInfo(){

    }

    public MovieInfo(String name, String description, String image,int id,String calificacionT){
        this.name=name;
        this.description=description;
        this.image=image;
        this.id=id;
        this.calificacionT=calificacionT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalificacionT() {
        return calificacionT;
    }

    public void setCalificacionT(String calificacionT) {
        this.calificacionT = calificacionT;
    }
}
