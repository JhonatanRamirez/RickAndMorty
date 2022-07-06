package com.player.rickandmorty.View.ui.episode.Impl.EpisodeFragment;

import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.EpisodeFragmentIterator;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.EpisodeFragmentPresenter;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.EpisodeFragmentView;

public class EpisodeFragmentPresenterImpl implements EpisodeFragmentPresenter {
    EpisodeFragmentView view;
    EpisodeFragmentIterator iterator;

    public EpisodeFragmentPresenterImpl(EpisodeFragmentView view) {
        this.view = view;
        this.iterator= new EpisodeFragmentIteratorImpl(this);
    }
}
