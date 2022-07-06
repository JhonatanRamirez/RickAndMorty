package com.player.rickandmorty.View.ui.character.Impl.CharacterFragment;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonObjectRequest;
import com.player.rickandmorty.Manager.VolleyManager;
import com.player.rickandmorty.POJO.Character;
import com.player.rickandmorty.POJO.Location;
import com.player.rickandmorty.POJO.Origin;
import com.player.rickandmorty.Utils.Config;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragment.CharacterFragmentIterator;
import com.player.rickandmorty.View.ui.character.Interface.CharacterFragment.CharacterFragmentPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CharacterFragmentIteratorImpl implements CharacterFragmentIterator {

    CharacterFragmentPresenter presenter;

    public CharacterFragmentIteratorImpl(CharacterFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getCharacter() {

        JsonObjectRequest stringRequest = new JsonObjectRequest (Request.Method.GET, Config.getUrlChart(),null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<Character> lChart= new ArrayList<>();
                        try {
                            for (int i = 0; i < response.getJSONArray("results").length(); i++) {
                                Character c= new Character();
                                Origin o= getOriginByJson(response.getJSONArray("results").getJSONObject(i));
                                Location l= getLocationByJson(response.getJSONArray("results").getJSONObject(i));
                                ArrayList<String> e = getArrayDataEp(response.getJSONArray("results").getJSONObject(i).optJSONArray("episode"));
                               // Log.e("TAG", "onResponse: array id "+response.getJSONArray("results").getJSONObject(i).optInt("id") );
                                c.setId(response.getJSONArray("results").getJSONObject(i).optInt("id"));
                                c.setName(response.getJSONArray("results").getJSONObject(i).optString("name"));
                                c.setStatus(response.getJSONArray("results").getJSONObject(i).optString("status"));
                                c.setSpecies(response.getJSONArray("results").getJSONObject(i).optString("species"));
                                c.setType(response.getJSONArray("results").getJSONObject(i).optString("type"));
                                c.setGender(response.getJSONArray("results").getJSONObject(i).optString("gender"));
                                c.setImage(response.getJSONArray("results").getJSONObject(i).optString("image"));
                                c.setUrl(response.getJSONArray("results").getJSONObject(i).optString("url"));
                                c.setCreated(response.getJSONArray("results").getJSONObject(i).optString("created"));
                                c.setOrigin(o);
                                c.setLocation(l);
                                c.setEpisode(e);
                                lChart.add(c);
                            }

                          //  Log.e("TAG", "onResponse: response "+ response.getJSONArray("results") );
                        } catch (JSONException e) {
                            Log.e("TAG", "onResponse: error conversion "+ e.toString() );
                        }
                        presenter.setCharacter(lChart);
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

    private ArrayList<String> getArrayDataEp(JSONArray optJSONArray) throws JSONException {
        ArrayList<String> r= new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            r.add(optJSONArray.getString(i));
        }
        return r;
    }

    private Location getLocationByJson(JSONObject results) {
        return (new Location(results.optJSONObject("origin").optString("name"), results.optJSONObject("origin").optString("url") ));
    }

    private Origin getOriginByJson(JSONObject results) {
        return (new Origin(results.optJSONObject("origin").optString("name"), results.optJSONObject("origin").optString("url") ));

    }


}
