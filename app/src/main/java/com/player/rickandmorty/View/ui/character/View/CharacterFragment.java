package com.player.rickandmorty.View.ui.character.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.R;
import com.player.rickandmorty.View.ui.character.Impl.CharacterFragment.CharacterFragmentPresenterImpl;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragment.CharacterFragmentPresenter;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragment.CharacterFragmentView;
import com.player.rickandmorty.View.ui.character.Adapter.AdapterChararter;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.OnClickView;
import com.player.rickandmorty.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CharacterFragment extends Fragment implements CharacterFragmentView, OnClickView {


    private FragmentGalleryBinding binding;
    private CharacterFragmentPresenter presenter;
    private ArrayList<Character> character;
    private AdapterChararter adapterChararter;
    private NavController navController;

    @BindView(R.id.reciclerCharacter)
    RecyclerView recyclerChararter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, root);
        presenter= new CharacterFragmentPresenterImpl(this);
        character= new ArrayList<>();
        presenter.getCharacter();
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void setCharacter(ArrayList<Character> character) {
        this.character=character;
        setRecycler(character);
        Log.e("TAG", "setCharacter: char "+character.size());
    }

    @Override
    public void clickView(int pos) {
        Bundle b= new Bundle();
        b.putSerializable("c",character.get(pos));
        navController.navigate(R.id.action_nav_gallery_to_episodeCharacter, b);

    }
    private void setRecycler(ArrayList<Character> character) {
        adapterChararter = new AdapterChararter(character,this, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerChararter.setLayoutManager(layoutManager);
        recyclerChararter.setAdapter(adapterChararter);
    }
}