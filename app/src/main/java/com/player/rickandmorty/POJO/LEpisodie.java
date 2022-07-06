package com.player.rickandmorty.POJO;

import java.util.ArrayList;

public class LEpisodie {
    Info inf;
    ArrayList<Episode> results;

    public LEpisodie() {
    }

    public LEpisodie(Info inf, ArrayList<Episode> results) {
        this.inf = inf;
        this.results = results;
    }

    public Info getInf() {
        return inf;
    }

    public void setInf(Info inf) {
        this.inf = inf;
    }

    public ArrayList<Episode> getResults() {
        return results;
    }

    public void setResults(ArrayList<Episode> results) {
        this.results = results;
    }
}
