package com.example.emilianocervantes.soccer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ovman on 13/02/2018.
 */

public class SoccerAdapter extends ArrayAdapter<Match> {
    private Context context;
    public SoccerAdapter(@NonNull Context context, int resource, @NonNull List<Match> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.soccer_matches_layout,parent,false);
        }
        Match match = getItem(position);
        TextView fecha = (TextView) convertView.findViewById(R.id.fecha);
        TextView eq01 = (TextView) convertView.findViewById(R.id.equipo01);
        TextView eq02 = (TextView) convertView.findViewById(R.id.equipo02);
        TextView ma01 = (TextView) convertView.findViewById(R.id.marcador01);
        TextView ma02 = (TextView) convertView.findViewById(R.id.marcador02);

        fecha.setText(match.fecha);
        eq01.setText(match.equipo01);
        eq02.setText(match.equipo02);
        ma01.setText(match.marcador01.toString());
        ma02.setText(match.marcador02.toString());
        convertView.setBackgroundResource(R.color.colorPrimary);

        return convertView;
    }
}
