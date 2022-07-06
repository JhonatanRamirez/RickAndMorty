package com.player.rickandmorty.View.ui.character.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.View.ui.character.Impl.CharacterFragmentPresenterImpl;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragmentPresenter;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragmentView;
import com.player.rickandmorty.databinding.FragmentGalleryBinding;

import java.util.ArrayList;


public class CharacterFragment extends Fragment implements CharacterFragmentView {


    private FragmentGalleryBinding binding;
    private CharacterFragmentPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        presenter= new CharacterFragmentPresenterImpl(this);
        final TextView textView = binding.textGallery;
        textView.setText("Holaaaa");
        presenter.getCharacter();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void setCharacter(ArrayList<Character> character) {
        Log.e("TAG", "setCharacter: char "+character.size());
    }
}