package com.gagit.snapp.snapp_gagit;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class factors_ac extends AppCompatActivity
{




    //Vars And Compoenents Start
    SwipeRefreshLayout swipeRefreshLayout;
    GridView gridView;
    //Vars And Compoenents End




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_factors_ac);
            refresh();
            Events();
        }
        catch (Exception Err)
        {

        }

    }



















    //All Events Start
    public static int factor_id;

    public void Events() throws Exception
    {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                swipeRefreshLayout.setRefreshing(false);
//                gridView.setAdapter(new datagrid_adaptor());
            }
        });




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                factor_id=i;
                startActivity(new Intent(getApplicationContext(),Share_Factor_ac.class));
                overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
            }
        });


    }
    //All Events End

























    //Find All Views Start
    public void refresh() throws Exception
    {
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.factor_ac_swiper);
        gridView=(GridView)findViewById(R.id.factor_ac_grid_view);
//        gridView.setAdapter(new datagrid_adaptor());
        get_header();
    }
    //Find All Views End


















    //Get Header Start
    public void get_header() throws Exception
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End


















    //Adaptor Start
//    public static int []images={R.drawable.pg11,R.drawable.pg12,R.drawable.pg13,R.drawable.pg14,R.drawable.pg15,R.drawable.pg19,R.drawable.pg17,R.drawable.pg18,R.drawable.pg11,R.drawable.pg12,R.drawable.pg13,R.drawable.pg14,R.drawable.pg15,R.drawable.pg19,R.drawable.pg17,R.drawable.pg18,R.drawable.pg11,R.drawable.pg12,R.drawable.pg13,R.drawable.pg14,R.drawable.pg15,R.drawable.pg19,R.drawable.pg17,R.drawable.pg18,R.drawable.pg11,R.drawable.pg12,R.drawable.pg13,R.drawable.pg14,R.drawable.pg15,R.drawable.pg19,R.drawable.pg17,R.drawable.pg18};
//
//    class datagrid_adaptor extends BaseAdapter
//    {
//
//        @Override
//        public int getCount()
//        {
//            return images.length;
//        }
//
//        @Override
//        public Object getItem(int i)
//        {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i)
//        {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup)
//        {
//            view=getLayoutInflater().inflate(R.layout.factor_ac_grid_view_layout,null);
//
//            try
//            {
//
//                ImageView imageView = (ImageView) view.findViewById(R.id.factor_ac_grid_view_Image_view_id);
//
//                imageView.setImageResource(images[i]);
//            }
//            catch (Exception Err)
//            {
//
//            }
//
//            return view;
//        }
//    }
    //Adaptor End








}
