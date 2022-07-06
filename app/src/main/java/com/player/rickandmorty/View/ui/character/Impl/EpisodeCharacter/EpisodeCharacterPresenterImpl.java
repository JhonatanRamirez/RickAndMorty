package com.player.rickandmorty.View.ui.character.Impl.EpisodeCharacter;

import com.player.rickandmorty.POJO.Episode;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterIterator;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterPresenter;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterView;

import java.util.ArrayList;

public class EpisodeCharacterPresenterImpl implements EpisodeCharacterPresenter {
    EpisodeCharacterView view;
    EpisodeCharacterIterator iterator;

    public EpisodeCharacterPresenterImpl(EpisodeCharacterView view) {
        this.view = view;
        this.iterator= new EpisodeCharacterIteratorImpl(this);
    }

    @Override
    public void getDataEpisode(ArrayList<String> data) {
        this.iterator.getDataEpisode(data);
    }

    @Override
    public void setDataEpisode(ArrayList<Episode> data) {
    this.view.setDataEpisode(data);
    }
}
