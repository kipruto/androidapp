package com.example.recipeapp_v1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Introscreenadapter extends PagerAdapter {

Context mContext;
List<Introscreenscaffold>  mListIntroscreens;

 public Introscreenadapter(Context mContext, List<Introscreenscaffold>  mListIntroscreens){
     this.mContext = mContext;
     this.mListIntroscreens = mListIntroscreens;
 }

 @NonNull
 @Override

    public Object instantiateItem(@NonNull ViewGroup container, int position ){

     LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     View introscreenpage = inflater.inflate(R.layout.introscreenpage, null);
     ImageView introImage = introscreenpage.findViewById(R.id.introimage);
     TextView title = introscreenpage.findViewById(R.id.introtext);
     TextView description = introscreenpage.findViewById(R.id.introdescription);

     title.setText(mListIntroscreens.get(position).getheadTitle());
     description.setText(mListIntroscreens.get(position).getDescription());
     introImage.setImageResource(mListIntroscreens.get(position).getIntroImg());
     container.addView(introscreenpage);

     return introscreenpage;
 }


    @Override
    public int getCount() {
        return mListIntroscreens.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((View) object);
    }
}
