package com.example.fragmentsdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class ListFragment extends Fragment {

    Button cs;
    Button ece;
    Button async;
    TextView counter;
    //declare interaction listener

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_list, container, false);

        //initialize buttons and textview
        cs = (Button) view.findViewById(R.id.csButton);
        ece= (Button) view.findViewById(R.id.eceButton);
        async = (Button) view.findViewById(R.id.asyncButton);
        counter= (TextView) view.findViewById(R.id.count);

        //add listeners

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onClick(View view){

    }
}