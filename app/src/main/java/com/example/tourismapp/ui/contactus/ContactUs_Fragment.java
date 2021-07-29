package com.example.tourismapp.ui.contactus;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tourismapp.R;


public class ContactUs_Fragment extends Fragment {


    public ContactUs_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        TextView textView_linkedin=view.findViewById(R.id.linkedin);
        TextView textView_twitter=view.findViewById(R.id.txt_twitter);
        textView_linkedin.setMovementMethod(LinkMovementMethod.getInstance());
        textView_twitter.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}