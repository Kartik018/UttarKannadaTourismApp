package com.example.tourismapp.ui.Gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tourismapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class gallery_adaptor extends FirebaseRecyclerAdapter<gallerydatamodel, gallery_adaptor.myviewholder>
{

    public gallery_adaptor(@NonNull @NotNull FirebaseRecyclerOptions<gallerydatamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull gallery_adaptor.myviewholder holder, int position, @NonNull @NotNull gallerydatamodel model) {

        Glide.with(holder.image.getContext()).load(model.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", model);

                Navigation.findNavController(view).navigate(R.id.nav_gal_fragment, bundle);
            }
        });
    }

    @NotNull
    @Override
    public gallery_adaptor.myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_singlerow,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;

        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_gallery);
        }
    }
}
