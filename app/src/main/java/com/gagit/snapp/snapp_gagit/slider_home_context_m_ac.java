package com.gagit.snapp.snapp_gagit;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class slider_home_context_m_ac extends PagerAdapter
{


    Context mConte;

//    int []Images={R.drawable.witt11,R.drawable.witt22};


    slider_home_context_m_ac(Context context)
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

//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

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
