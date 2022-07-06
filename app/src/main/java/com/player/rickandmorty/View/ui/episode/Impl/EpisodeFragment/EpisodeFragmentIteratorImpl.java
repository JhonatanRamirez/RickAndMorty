package com.player.rickandmorty.View.ui.episode.Impl.EpisodeFragment;

import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.EpisodeFragmentIterator;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.EpisodeFragmentPresenter;

public class EpisodeFragmentIteratorImpl implements EpisodeFragmentIterator {
    EpisodeFragmentPresenter presenter;

    public EpisodeFragmentIteratorImpl(EpisodeFragmentPresenter presenter) {
        this.presenter = presenter;
    }
}
