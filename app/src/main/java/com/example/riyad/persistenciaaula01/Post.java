package com.example.riyad.persistenciaaula01;

/**
 * Created by riyad on 17/08/2016.
 */

import java.text.SimpleDateFormat;
import  java.util.Date;

public class Post {
    private long id;
    private String texto;
    private long likes;
    private Date data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "id : " + id + " texto : " + texto + " data: " + new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}
