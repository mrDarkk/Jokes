package com.bhupendra.joke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ENcategoriesActivity extends AppCompatActivity {



    private static final String TAG = "ENcategoriesActivity";
    private ImageView img;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Log.d(TAG, "onCreate: started.");
        img = findViewById(R.id.change_lang);

        img.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent s1= new Intent(ENcategoriesActivity.this,LangSelectionActivity.class);
                startActivity(s1);
                finish();
            }
        });

        initImageBitmaps();

//        CardView card1 = (CardView)findViewById(R.id.card1);
//        card1.setCardBackgroundColor(100);
    }

        private void initImageBitmaps(){
            Log.d(TAG, "initImageBitmaps: preparing bitmaps.");




            mNames.add("Bar Jokes");


//            mNames.add("sdgdfgd के लिए चुटकुले");
//
//
            mNames.add("Funniest jokes");



            initRecyclerView();
        }


        private void initRecyclerView(){
            Log.d(TAG, "initRecyclerView: init recyclerview.");
            RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }