package com.example.tourismapp.ui.Gallery;

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
import com.example.tourismapp.R;

import org.jetbrains.annotations.NotNull;


public class gal_dis_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gal_dis, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageholder=view.findViewById(R.id.gal_image);
        TextView titleholder=view.findViewById(R.id.i_name);

        gallerydatamodel model = (gallerydatamodel) getArguments().get("model");

        titleholder.setText(model.getTitle());
        Glide.with(getContext()).load(model.getImage()).into(imageholder);
    }
}