package com.player.rickandmorty.View.ui.episode.Impl;

import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragmentIterator;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragmentPresenter;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragmentView;

public class EpisodeFragmentPresenterImpl implements EpisodeFragmentPresenter {
    EpisodeFragmentView view;
    EpisodeFragmentIterator iterator;

    public EpisodeFragmentPresenterImpl(EpisodeFragmentView view) {
        this.view = view;
        this.iterator= new EpisodeFragmentIteratorImpl(this);
    }
}
