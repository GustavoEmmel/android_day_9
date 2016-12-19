package com.example.aluno.jsonobject;

/**
 * Created by Aluno on 19/12/2016.
 */

public class Projeto {

    private String url;
    private String name;

    public Projeto(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
