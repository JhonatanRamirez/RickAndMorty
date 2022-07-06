package com.player.rickandmorty.Manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


public class VolleyManager {
    private static VolleyManager INSTANCE;
    private static RequestQueue mQueue;
    private static Context mcontext;
    public static VolleyManager get(Context context) {
        mcontext = context;
        if (INSTANCE == null) {
            INSTANCE = new VolleyManager(context.getApplicationContext());
        }
        return INSTANCE;
    }
    public VolleyManager(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public static void add(JsonObjectRequest request){
        mQueue.add(request);
    }


    public static RequestQueue getQueue(){
        if(mQueue!=null){
            return mQueue;
        }else{
            Log.e("TAG", "getQueue: es nulo" );
        }
        return null;
    }

    public static Context getMcontext(){
        return mcontext;
    }
}
