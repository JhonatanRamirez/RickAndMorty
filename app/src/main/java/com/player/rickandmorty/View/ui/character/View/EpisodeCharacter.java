package com.player.rickandmorty.View.ui.character.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.POJO.Episode;
import com.player.rickandmorty.R;
import com.player.rickandmorty.View.ui.character.Adapter.AdapterChararter;
import com.player.rickandmorty.View.ui.character.Adapter.AdapterEpisode;
import com.player.rickandmorty.View.ui.character.Impl.EpisodeCharacter.EpisodeCharacterPresenterImpl;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterPresenter;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterView;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.OnClickView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EpisodeCharacter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EpisodeCharacter extends Fragment implements EpisodeCharacterView, OnClickView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String chara = "c";
    private Character character;
    private EpisodeCharacterPresenter presenter;
    private AdapterEpisode adapterEpisode;
    @BindView(R.id.reciclerEpisode)
    RecyclerView reciclerEpisode;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EpisodeCharacter() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EpisodeCharacter.
     */
    // TODO: Rename and change types and number of parameters
    public static EpisodeCharacter newInstance(String param1, String param2) {
        EpisodeCharacter fragment = new EpisodeCharacter();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            character = (Character) getArguments().getSerializable(chara);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_episode_character, container, false);
        presenter= new EpisodeCharacterPresenterImpl(this);
        presenter.getDataEpisode(character.getEpisode());
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void setDataEpisode(ArrayList<Episode> data) {
        Log.e("TAG", "setDataEpisode: data "+data.size() );
        setRecycler(data);
    }

    private void setRecycler(ArrayList<Episode> episodes) {
        adapterEpisode = new AdapterEpisode(episodes,this, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL, false);
        reciclerEpisode.setLayoutManager(layoutManager);
        reciclerEpisode.setAdapter(adapterEpisode);
    }

    @Override
    public void clickView(int pos) {
        Toast.makeText(getContext(), "Por el momento no esta disponible", Toast.LENGTH_LONG).show();
    }
}