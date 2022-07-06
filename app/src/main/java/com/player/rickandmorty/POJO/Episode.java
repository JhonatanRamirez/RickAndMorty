package com.player.rickandmorty.POJO;

import java.util.ArrayList;

public class Episode {

    int id;
    String name;
    String air_date;
    String episode;
    ArrayList<Character> character;
    String url;
    String created;

    public Episode() {
    }

    public Episode(int id, String name, String air_date, String episode, ArrayList<Character> character, String url, String created) {
        this.id = id;
        this.name = name;
        this.air_date = air_date;
        this.episode = episode;
        this.character = character;
        this.url = url;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public ArrayList<Character> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<Character> character) {
        this.character = character;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
