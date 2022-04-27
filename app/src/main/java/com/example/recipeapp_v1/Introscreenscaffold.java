package com.example.recipeapp_v1;

import androidx.appcompat.app.AppCompatActivity;

public class Introscreenscaffold extends AppCompatActivity {
String Title, Description;
int IntroImg;

public Introscreenscaffold(String title, String description, int introImg) {
    Title = title;
    Description = description;
    IntroImg = introImg;
}

public void setTitle(String title){Title = title;}
public void setDescription(String description){Description = description;}
public void setImage(int introimg){IntroImg = introimg;}


public String getDescription(){return Description;}
public int getIntroImg(){return IntroImg;}
public String getheadTitle(){return Title;}
}
