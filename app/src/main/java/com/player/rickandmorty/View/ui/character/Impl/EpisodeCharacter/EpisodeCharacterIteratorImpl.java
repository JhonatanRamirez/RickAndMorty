package com.player.rickandmorty.View.ui.character.Impl.EpisodeCharacter;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.player.rickandmorty.Manager.VolleyManager;
import com.player.rickandmorty.POJO.Episode;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterIterator;
import com.player.rickandmorty.View.ui.character.Interface.EpisodeCharacter.EpisodeCharacterPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EpisodeCharacterIteratorImpl implements EpisodeCharacterIterator {
    EpisodeCharacterPresenter presenter;

    public EpisodeCharacterIteratorImpl(EpisodeCharacterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getDataEpisode(ArrayList<String> data) {
        ArrayList<Episode> lEpiso= new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int finalI = i;
            JsonObjectRequest stringRequest = new JsonObjectRequest (Request.Method.GET, data.get(i),null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Episode c= new Episode();
                            // Log.e("TAG", "onResponse: array id "+response.getJSONArray("results").getJSONObject(i).optInt("id") );
                            c.setId(response.optInt("id"));
                            c.setName(response.optString("name"));
                            c.setUrl(response.optString("url"));
                            c.setCreated(response.optString("created"));
                            c.setAir_date(response.optString("air_date"));
                            lEpiso.add(c);

                            //  Log.e("TAG", "onResponse: response "+ response.getJSONArray("results") );
                            if(data.size()-1==(finalI)){
                                Log.e("TAG", "onResponse: entro " );
                                presenter.setDataEpisode(lEpiso);
                            }else{
                                Log.e("TAG", "onResponse: no entro " );
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG", "onResponse: error "+ error );
                        }
                    });
            RequestQueue requestQueue = VolleyManager.getQueue();
            requestQueue.add(stringRequest);

        }


    }
}
