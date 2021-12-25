package com.gagit.snapp.snapp_gagit;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class slider_logo_ac extends PagerAdapter
{


    Context mConte;

//    int []Images={R.drawable.witt1};


    slider_logo_ac(Context context)
    {
        mConte=context;
    }



    @Override
    public int getCount()
    {
//        return Images.length;
        return 0;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view==object;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {

        ImageView imageView = new ImageView(mConte);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

//        imageView.setImageResource(Images[position]);

        container.addView(imageView, 0);

        return imageView;

    }





    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((ImageView)object);
    }
}
