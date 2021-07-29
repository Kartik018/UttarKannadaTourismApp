package com.example.tourismapp.ui.Honnavar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.R;
import com.example.tourismapp.ui.adaptor.alladaptor;
import com.example.tourismapp.ui.datamodel.alldatamodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Honnavarfragment extends Fragment {


    RecyclerView recyclerView;
    alladaptor adapter;
    public Honnavarfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        recyclerView = view.findViewById(R.id.recview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        FirebaseRecyclerOptions<alldatamodel> options =
                new FirebaseRecyclerOptions.Builder<alldatamodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Honnavar"), alldatamodel.class)
                        .build();

        adapter=new alladaptor(options);
        recyclerView.setAdapter(adapter);
        return view;


    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        Log.i("hi..","hello..");
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Honnavar");
//
//        // Read from the database
//        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                Log.i("TAG",task.getResult().getValue().toString());
//            }
//        });
//    }
//
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