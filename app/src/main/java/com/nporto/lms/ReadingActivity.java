package com.nporto.lms;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;

public class ReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        Resources res = getResources();
        Intent iin= getIntent();
        Bundle extras = iin.getExtras();

        String paragraphTitle;
        String paragraphContent;

        TextView ViewContent = (TextView) findViewById(R.id.paragraphContent);
        TextView ViewParagraph = (TextView) findViewById(R.id.toolbar_title);

        if(extras!=null)
        {

//            indices
            int ch = extras.getInt("chapter");
            int par = extras.getInt("paragraph");

//            data
            paragraphTitle = extras.getString("paragraphTitle");
            int paragraphContentID = extras.getInt("paragraphContentID");
            paragraphContent = res.getStringArray(paragraphContentID)[par];

//            SETTING DATA

//            Toast.makeText(this, paragraphTitle, Toast.LENGTH_SHORT).show();
            ViewParagraph.setText(paragraphTitle);
            ViewContent.setText(paragraphContent);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
