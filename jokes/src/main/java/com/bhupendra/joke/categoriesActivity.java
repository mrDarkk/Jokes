package com.bhupendra.joke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class categoriesActivity extends AppCompatActivity {


    private static final String TAG = "categoriesActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private AdView mAdView;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //Log.d(TAG, "onCreate: started.");


        MobileAds.initialize(this,
                "ca-app-pub-2861056896636349~6727790187");

        mAdView = findViewById(R.id.adView);
        img = findViewById(R.id.change_lang);


        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent s1 = new Intent(categoriesActivity.this, LangSelectionActivity.class);
                startActivity(s1);
                finish();
            }
        });


        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);

        initImageBitmaps();

    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNames.add("शराबी");
        mNames.add("शिक्षक छात्र चुटकुले");
        mNames.add("बच्चों के लिए चुटकुले");
        mNames.add("पति पत्नी चुटकुले");
        mNames.add("संता-बंता");
        mNames.add("मजेदार चुटकुले");
        mNames.add("अकबर बीरबल");
        mNames.add("डाक्टर");
        mNames.add("राजनीति");
        mNames.add("18+");

       // initRecyclerView();
    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}