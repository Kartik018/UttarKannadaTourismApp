package com.example.tourismapp.ui.Gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    gallery_adaptor adapter;
    public GalleryFragment(){

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_all, container, false);
            recyclerView = view.findViewById(R.id.recview);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

            FirebaseRecyclerOptions<gallerydatamodel> options =
                    new FirebaseRecyclerOptions.Builder<gallerydatamodel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Gallery"), gallerydatamodel.class)
                            .build();

            adapter= new gallery_adaptor(options);
            recyclerView.setAdapter(adapter);
            return view;
        }
        @Override
        public void onStart() {
            super.onStart();
            adapter.startListening();
        }

        @Override
        public void onStop() {
            super.onStop();
            adapter.stopListening();
        }
    }