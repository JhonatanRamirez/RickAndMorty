package com.player.rickandmorty.View.ui.episode.Impl;

import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragmentIterator;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragmentPresenter;

public class EpisodeFragmentIteratorImpl implements EpisodeFragmentIterator {
    EpisodeFragmentPresenter presenter;

    public EpisodeFragmentIteratorImpl(EpisodeFragmentPresenter presenter) {
        this.presenter = presenter;
    }
}
