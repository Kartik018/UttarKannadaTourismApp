package com.example.tourismapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.tourismapp.ui.datamodel.alldatamodel;

import org.jetbrains.annotations.NotNull;


public class descfragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_descfragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageholder=view.findViewById(R.id.bigimage);
        TextView headerholder=view.findViewById(R.id.headtext);
        TextView descholder=view.findViewById(R.id.desctext);

        alldatamodel model = (alldatamodel) getArguments().get("model");

        headerholder.setText(model.getHead());
        descholder.setText(model.getDesc());
        Glide.with(getContext()).load(model.getImage()).into(imageholder);
    }
}