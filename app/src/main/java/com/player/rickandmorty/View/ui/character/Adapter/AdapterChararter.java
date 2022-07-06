package com.player.rickandmorty.View.ui.character.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.R;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.OnClickView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterChararter extends RecyclerView.Adapter<AdapterChararter.ViewHolder>{
    private ArrayList<Character> characters;
    private OnClickView onclicklistiner;
    private Context c;

    public AdapterChararter(ArrayList<Character> characters, OnClickView onclicklistiner, Context c) {
        this.characters = characters;
        this.onclicklistiner = onclicklistiner;
        this.c=c;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_character, parent, false);
        ViewHolder vh = new AdapterChararter.ViewHolder(v,onclicklistiner);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(c)
                .load(characters.get(position).getImage())
                .into(holder.imgChar);
        holder.name.setText(characters.get(position).getName());
        holder.status.setText(characters.get(position).getStatus());
        holder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklistiner.clickView(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public Character getCharacter(int pos){
        return this.characters.get(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener  {
        @BindView(R.id.imgChar)
        ImageView imgChar;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.ver)
        Button ver;


        public ViewHolder(@NonNull View itemView, OnClickView onClickView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            onclicklistiner = onClickView;
            ver.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onclicklistiner.clickView(getAdapterPosition());
        }
    }
}
