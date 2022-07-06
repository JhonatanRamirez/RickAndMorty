package com.player.rickandmorty.View.ui.character.Impl;

import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragmentIterator;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragmentPresenter;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragmentView;

import java.util.ArrayList;

public class CharacterFragmentPresenterImpl implements CharacterFragmentPresenter {
    CharacterFragmentView view;
    CharacterFragmentIterator iterator;

    public CharacterFragmentPresenterImpl(CharacterFragmentView view) {
        this.view = view;
        this.iterator= new CharacterFragmentIteratorImpl(this);
    }

    @Override
    public void getCharacter() {
        this.iterator.getCharacter();
    }

    @Override
    public void setCharacter(ArrayList<Character> character) {
        this.view.setCharacter(character);
    }


}
