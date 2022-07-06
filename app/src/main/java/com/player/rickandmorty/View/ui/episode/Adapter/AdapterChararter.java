package com.player.rickandmorty.View.ui.episode.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.player.rickandmorty.View.ui.episode.Interface.OnClickView;

import java.util.ArrayList;

public class AdapterChararter extends RecyclerView.Adapter<AdapterChararter.ViewHolder>{
    private ArrayList<Character> characters;
    private OnClickView onclicklistiner;

    public AdapterChararter(ArrayList<Character> characters, OnClickView onclicklistiner) {
        this.characters = characters;
        this.onclicklistiner = onclicklistiner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener  {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        @Override
        public void onClick(View view) {

        }
    }
}
