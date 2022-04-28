package com.example.recipeapp_v1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Introscreens extends AppCompatActivity {
   private ViewPager screenPager;
   Introscreenadapter introscreenadapter;
    TextView btnNext, btnGetstarted, btnSkip;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.introscreenpage);


         btnNext = findViewById(R.id.btnNext);
        btnGetstarted = findViewById(R.id.btnGetstarted);
        btnSkip = findViewById(R.id.btnSkip);


        // when this activity is about to be launch we need to check if its openened before or not

        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();
        }


        // fill list screen
final List abouttheapp_items = new ArrayList();
boolean about_app = abouttheapp_items.add(new Introscreenscaffold( "Step by step recipe guide", "This app gives you a step by step directions explaining " +
                "how to prepare and cook various kinds of food. Use the search " +
                "box in the app to search from our collection recommended " +
                "or popular recipes.", R.drawable.burger));

abouttheapp_items.add(new Introscreenscaffold("In-built Calorie Calculator", "The amount of energy in a food or drink is important in determining " +
        "a healty diet depending on daily activity. Our bodies store the excess " +
        "calories as body fat  and over time we may put on weight. Therefore " +
        "our calculator will help you to maintain a healthy" +
        " body weight.", R.drawable.calories));

//setup viewpager

        screenPager = findViewById(R.id.view_page);
        introscreenadapter = new Introscreenadapter(this, abouttheapp_items);
        screenPager.setAdapter(introscreenadapter);


        // Get Started button click listener

        btnGetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), Mainscreen.class);
                startActivity(mainActivity);
                savePrefsData();
                finish();

            }
        });

        // next button click Listener

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if (position < abouttheapp_items.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == abouttheapp_items.size() - 1) { // when we rech to the last screen
                    // TODO : show the GETSTARTED Button and hide the indicator and the next button
                    loadLastScreen();
                }
            }
        });

        // skip button click listener
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(abouttheapp_items.size());
            }
        });



    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();
    }



    private boolean restorePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;
    }

    // show the GETSTARTED Button and hide the indicator and the next button

    private void loadLastScreen(){
        btnNext.setVisibility(View.INVISIBLE);
        btnGetstarted.setVisibility(View.VISIBLE);
        btnSkip.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
    }

}
