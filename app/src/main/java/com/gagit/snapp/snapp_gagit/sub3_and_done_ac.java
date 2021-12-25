package com.gagit.snapp.snapp_gagit;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.Picasso;

public class sub3_and_done_ac extends AppCompatActivity
{




    //Vars Start
    GridView gridView;
    SwipeRefreshLayout swipeRefreshLayout;
    com.devsmart.android.ui.HorizontalListView switch_view;
    public static int id=0;
    int switch_view_item_postion=0;
    //Vars End





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3_and_done_ac);
        id=0;
        refresh();
        fill();
        events();

    }












    public void fill()
    {
        gridView.setAdapter(new grid_(sub3_and_done_ac.this));
        switch_view.setAdapter(new switch_view_adaptor());
        switch_view.scrollTo(switch_view_item_postion*600);
    }













    public void events()
    {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                selected_cat_flag.item_clicked_n_price_sub=i;
                database.get_questions(i);
                database.SID=database.items_sub_item3_sid.get(i);


                try
                {
                    if(!database.question_radio.equals(""))
                    {
                        startActivity(new Intent(getApplicationContext(),type_ac.class));
                    }
                }
                catch (Exception Errs)
                {
                    try
                    {
                        if(!database.question_check.get(0).equals(""))
                        {
                            startActivity(new Intent(getApplicationContext(),check_list_ac.class));
                        }
                    }
                    catch (Exception Err)
                    {
                        try
                        {
                            if(!database.question_number.get(0).equals(""))
                            {
                                startActivity(new Intent(getApplicationContext(),numbers_ac.class));
                            }
                        }
                        catch (Exception Err2)
                        {
                            startActivity(new Intent(getApplicationContext(),clock_price_ac.class));
                        }
                    }
                }


                type_ac.Counter=0;
            }
        });






        switch_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                database.get_sub_items3(i);
                id=i;
                gridView.removeAllViewsInLayout();
                fill();
                selected_cat_flag.item_clicked_n_price=i;
                switch_view_item_postion=(i%2==0)?i/4:i/3;
            }
        });





        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                gridView.removeAllViewsInLayout();
                fill();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
















    public void refresh()
    {
        gridView=(GridView)findViewById(R.id.grid_view_sub3_ac);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_sub3_ac);
        switch_view=(com.devsmart.android.ui.HorizontalListView)findViewById(R.id.top_switch_view_sub3_ac);
        get_header();

    }




















    //Selected Cat Grid View Start
    class grid_ extends BaseAdapter
    {

        Activity activity;
        public grid_(Activity ac)
        {
            activity=ac;
        }

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
            try {
                view = getLayoutInflater().inflate(R.layout.one_colnum_grid_view, null);

                ImageView imageView = (ImageView) view.findViewById(R.id.list_Image_view);

                TextView textView = (TextView) view.findViewById(R.id.list_textview_1);

//            Picasso.get().load(database.items_sub_item_icons3.get(i)).into(imageView);


                SvgLoader.pluck().with((Activity) activity).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.items_sub_item_icons3.get(i), imageView);


                textView.setText(database.items_sub_item3.get(i));

                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.item_anim);

                view.setAnimation(animation);

                return view;
            }
            catch (Exception s)
            {
                return view;
            }
        }
    }
    //Selected Cat Grid View End







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

            if(i==sub3_and_done_ac.id)
            {
                textView.setTextColor(0xFFFFFFFF);
                textView.setBackgroundResource(R.drawable.switch_view_selected_background);
            }

            return view;
        }
    }
    //Switch View Adaptor End








    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End



}
