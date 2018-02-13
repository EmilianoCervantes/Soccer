package com.example.emilianocervantes.soccer;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link ListFragment} subclass.
 */
public class MatchesListFragment extends ListFragment {


    public MatchesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matches_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SoccerAdapter adapter = getAdapter();
        //Darle un adaptador a una lista
        setListAdapter(adapter);
    }

    private SoccerAdapter getAdapter() {
        SoccerAdapter adapter = new SoccerAdapter(
                getActivity(),
                R.layout.soccer_matches_layout,
                new ArrayList<Match>());
        try {
            JSONObject jsonObject = new JSONObject(getJSON());
            JSONArray jsonArray = jsonObject.getJSONArray("rounds");
            for(int i = 0; i < jsonArray.length();i++){
                JSONObject jsonObject01 = jsonArray.getJSONObject(i);
                JSONArray matches = jsonObject01.getJSONArray("matches");
                for(int j = 0; j < jsonArray.length();j++){
                    JSONObject match = matches.getJSONObject(j);
                    Match m = new Match();
                    m.fecha = match.getString("date");
                    m.equipo01 = match.getJSONObject("team1").getString("name");
                    m.equipo02 = match.getJSONObject("team2").getString("name");
                    m.marcador01 = match.getInt("score1");
                    m.marcador02 = match.getInt("score2");
                    adapter.add(m);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return adapter;
    }

    private String getJSON(){
        //Lo sacamos de la car
        try {
            InputStream inputStream = getActivity().getAssets().open("liga.json");
            //Vamos a leer liga.json

            //Ver su tamano
            int size = inputStream.available();
            byte[] archivo = new byte[size];
            inputStream.read(archivo);
            inputStream.close();
            return new String(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
