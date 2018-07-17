package com.parse.starter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.parse.ParseObject;
import com.parse.starter.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter<ParseObject> {

    private Context context;
    private ArrayList<ParseObject> postagens;

    public HomeAdapter(@NonNull Context c, @NonNull ArrayList<ParseObject> objects) {
        super(c, 0, objects);
        this.context = c;
        this.postagens = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null){

            //Inicializa objeto para montagem no layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //Monta a view
            view = inflater.inflate(R.layout.lista_postagem,parent,false);
        }

        //veririca se existe postagem
        if (postagens.size() > 0){

            //recupera componentes da tela
            ImageView imagemPostada = (ImageView) view.findViewById(R.id.image_lista_postagem);

            ParseObject parseObject = postagens.get(position);

           // parseObject.getParseFile("imagem");
            Picasso.with(context).load(parseObject.getParseFile("imagem").getUrl()).fit().into(imagemPostada);


        }

        return  view;
    }
}
