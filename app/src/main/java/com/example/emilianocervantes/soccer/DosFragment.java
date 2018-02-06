package com.example.emilianocervantes.soccer;


import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DosFragment extends Fragment {
    int posicion;

    public DosFragment() {
        // Required empty public constructor
    }

    public void nextVersion(){
        //Hacemos que se muestre
        imageView.setImageResource(Data.drawableArray[posicion]);
        textView.setText(Data.androidNames[posicion]);
        posicion++;
    }

    private ImageView imageView;
    private TextView textView;

    // Podemos mandar datos de la actividad al fragmento
    // Recibo datos de la actividad y los cargo en el fragmento
    // Para argumentos de la actividad
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dos, container, false);

        //Posicion se inicializa solito en 0 porque es primitivo
        // Pero como buena practica se debe inicializar en onCreateView o en (no logre escuchar)
    }

    //Ya que se creo, vamos a sobreescribir otro
    // Vista a la cual me da acceso una vez se creo
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Asocio los elementos
        imageView = (ImageView)view.findViewById(R.id.imageView2);
        textView = (TextView)view.findViewById(R.id.textView3);
    }
}
