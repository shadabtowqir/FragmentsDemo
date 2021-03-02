package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

public class InformationActivity extends AppCompatActivity {

    InformationFragment informationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_information);

        //Check if we are at the land mode
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        Bundle b1= getIntent().getExtras();

        String info = b1.getString("information");

        informationFragment= (InformationFragment) getSupportFragmentManager().findFragmentById(R.id.infoFrag);

        informationFragment.setText(info);
    }

}