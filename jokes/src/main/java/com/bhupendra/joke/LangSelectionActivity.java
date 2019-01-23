package com.bhupendra.joke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LangSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang_selection);

        TextView hiButton =  findViewById(R.id.lan_hi);
        hiButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(LangSelectionActivity.this, "hindi", Toast.LENGTH_SHORT).show();
                Intent s1= new Intent(LangSelectionActivity.this,categoriesActivity.class);
                 startActivity(s1);
                finish();
            }
        });

        TextView enButton =  findViewById(R.id.lan_en);
        enButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(LangSelectionActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                Intent s2= new Intent(LangSelectionActivity.this,ENcategoriesActivity.class);
                startActivity(s2);
                finish();
            }
        });


    }
}
