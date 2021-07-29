package com.example.tourismapp.ui.adaptor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tourismapp.R;
import com.example.tourismapp.ui.datamodel.alldatamodel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class alladaptor extends FirebaseRecyclerAdapter<alldatamodel, alladaptor.myviewholder> {


    public alladaptor(@NonNull FirebaseRecyclerOptions<alldatamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull alldatamodel model) {

        holder.header.setText(model.getHead());
//        holder.desc.setText(model.getDesc());
        Glide.with(holder.image.getContext()).load(model.getImage()).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", model);

                Navigation.findNavController(view).navigate(R.id.nav_desc_fragment, bundle);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
   {

       ImageView image;
       TextView header,desc;
       public myviewholder(@NonNull View itemView) {
           super(itemView);

           image=itemView.findViewById(R.id.image);
//           desc=itemView.findViewById(R.id.desc);
           header=itemView.findViewById(R.id.header);

       }
   }
}
