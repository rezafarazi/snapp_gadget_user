package com.gagit.snapp.snapp_gagit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.devsmart.android.ui.HorizontalListView;
import com.squareup.picasso.Picasso;


public class selected_cat_flag extends Fragment
{


    //Vars Start
    public static int item_clicked_n_price,item_clicked_n_price_sub;
    public static String id;
    public static SwipeRefreshLayout swipeRefreshLayout;
    HorizontalListView switch_view;
    public static GridView gridView;
    //Vars End








    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }












    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_selected_cat_flag, container, false);

        switch_view_fn(view);

        grid(view);

        swiper(view);

        return view;
    }











    //Swiper Start
    public void swiper(View view)
    {
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.select_cat_swiper);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {

                gridView.setAdapter(new grid_adaptor());

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    //Swiper End














    //Switch View Start
    public void switch_view_fn(View view)
    {

        switch_view=(HorizontalListView) view.findViewById(R.id.top_switch_view_select_frag_m_ac);

        switch_view.setAdapter(new switch_view_adaptor());


        switch_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch_view.setAdapter(new switch_view_adaptor());
            }
        });


    }
    //Switch View End















    //Grid View Events Start
    public void grid(View view)
    {
        gridView=(GridView)view.findViewById(R.id.selected_cat_grid_view);

        n_items();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                database.get_sub_items3(i);

                startActivity(new Intent(view.getContext(),sub3_and_done_ac.class));

                item_clicked_n_price=i;

            }
        });


    }
    //Grid View Events End










    public void n_items()
    {
        gridView.setAdapter(new grid_adaptor());
    }




















    //Switch View AdApor Start
    class switch_view_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.items_sub_item.size();
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {

            view=getLayoutInflater().inflate(R.layout.switch_view,null);

            TextView textView=(TextView)view.findViewById(R.id.switch_view_text_view);

            textView.setText(database.items_sub_item.get(i));

            if(i==Integer.parseInt(id))
            {
                textView.setTextColor(0xFFFFFFFF);
                textView.setBackgroundResource(R.drawable.switch_view_selected_background);

            }


            return view;
        }
    }
    //Switch View Adaptor End










    //Selected Cat Grid View Start
    class grid_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.items_sub_item3.size();
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {

            view=getLayoutInflater().inflate(R.layout.two_colnum_grid_view,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.list_Image_view);

            TextView textView=(TextView) view.findViewById(R.id.list_textview_1);

//            Picasso.get().load(database.items_sub_item_icons.get(i)).into(imageView);

            SvgLoader.pluck().with(getActivity()).setPlaceHolder(R.drawable.wite,R.drawable.wite).load(database.items_sub_item_icons3.get(i),imageView);

            textView.setText(database.items_sub_item3.get(i));

            return view;
        }
    }
    //Selected Cat Grid View End











}
