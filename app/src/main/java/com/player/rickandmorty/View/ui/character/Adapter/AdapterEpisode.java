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

import com.player.rickandmorty.POJO.Episode;
import com.player.rickandmorty.R;
import com.player.rickandmorty.View.ui.episode.Interface.EpisodeFragment.OnClickView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterEpisode extends RecyclerView.Adapter<AdapterEpisode.ViewHolder>{
    private ArrayList<Episode> episodes;
    private OnClickView onclicklistiner;
    private Context c;

    public AdapterEpisode(ArrayList<Episode> episodes, OnClickView onclicklistiner, Context c) {
        this.episodes = episodes;
        this.onclicklistiner = onclicklistiner;
        this.c=c;

    }

    @NonNull
    @Override
    public AdapterEpisode.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_adapter_episode, parent, false);
        AdapterEpisode.ViewHolder vh = new AdapterEpisode.ViewHolder(v,onclicklistiner);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEpisode.ViewHolder holder, int position) {

        holder.name.setText(episodes.get(position).getName());
        holder.date.setText(episodes.get(position).getAir_date());
        holder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklistiner.clickView(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public Episode getCharacter(int pos){
        return this.episodes.get(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener  {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.ver)
        TextView ver;



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
