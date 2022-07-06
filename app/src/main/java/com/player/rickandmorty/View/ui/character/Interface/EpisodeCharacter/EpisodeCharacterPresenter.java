package com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter;

import com.player.rickandmorty.POJO.Episode;

import java.util.ArrayList;

public interface EpisodeCharacterPresenter {
    void getDataEpisode(ArrayList<String> data);
    void setDataEpisode(ArrayList<Episode> data);
}
