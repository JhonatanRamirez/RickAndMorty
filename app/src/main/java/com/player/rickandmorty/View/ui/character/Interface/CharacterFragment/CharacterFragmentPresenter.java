package com.player.rickandmorty.View.ui.character.Interface.CharacterFragment;

import com.player.rickandmorty.POJO.Character;

import java.util.ArrayList;

public interface CharacterFragmentPresenter {
    void getCharacter();
    void setCharacter(ArrayList<Character> character);
}
