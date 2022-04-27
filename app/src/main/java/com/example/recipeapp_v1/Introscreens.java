package com.example.recipeapp_v1;

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


final List abouttheapp_items = new ArrayList();
boolean about_app = abouttheapp_items.add(new Introscreenscaffold( "Step by step recipe guide", "This app gives you a step by step directions explaining \n" +
                "how to prepare and cook various kinds of food. Use the search \n" +
                "box in the app to search from our collection recommended \n" +
                "or popular recipes.", R.drawable.burger));
abouttheapp_items.add(new Introscreenscaffold("In-built Calorie Calculator", "The amount of energy in a food or drink is important in determining \n" +
        "a healty diet depending on daily activity. Our bodies store the excess \n" +
        "calories as body fat  and over time we may put on weight. Therefore \n" +
        "our calculator will help you to maintain a healthy\n" +
        " body weight.", R.drawable.calories));

//setup viewpager

        screenPager = findViewById(R.id.viewpager);
        introscreenadapter = new Introscreenadapter(this, abouttheapp_items);
        screenPager.setAdapter(introscreenadapter);

    }

}
