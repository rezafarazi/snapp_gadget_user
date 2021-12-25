package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.Picasso;


public class my_list_flag extends Fragment
{




    //All Vars Start
    RelativeLayout empty_ly;







    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_my_list_flag, container, false);

        try
        {
            empty_ly=(RelativeLayout)view.findViewById(R.id.is_empty_my_list_flag);
            get_header(view);
            swiper(view);
            girdview(view);
            auto_fill_refresh();
            Events(view);
        }
        catch (Exception Err)
        {
            Log.i("Err",Err.getMessage());
        }

        return view;
    }
















    //Grid View Function Start
    GridView gridView_list;
    public void girdview(View view) throws Exception
    {

        try
        {
            gridView_list = (GridView) view.findViewById(R.id.my_list_user);

            gridView_list.removeAllViewsInLayout();

            if (database.my_price_id.size() == 0)
            {
                empty_ly.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setVisibility(View.GONE);
            }
            else
            {
                empty_ly.setVisibility(View.GONE);
                swipeRefreshLayout.setVisibility(View.VISIBLE);
                gridView_list.setAdapter(new my_list_adaptor());
            }
        }
        catch (Exception Err)
        {

        }

    }
    //Grid View Function End

















    //All Events Start
    public void Events(View view) throws Exception
    {
        gridView_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int i, long l)
            {

                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        database.get_my_all_proposals(database.my_price_id.get(i));
                    }
                }).start();

                startActivity(new Intent(getContext(),Visit_List_Item_ac.class));
            }
        });

    }
    //All Events End




















    //Swiper Start
    SwipeRefreshLayout swipeRefreshLayout;
    public void swiper(View view) throws Exception
    {

        try
        {

            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_my_list_user);

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    swipeRefreshLayout.setRefreshing(false);
                }
            });

        }
        catch (Exception Err)
        {

        }

    }
    //Swiper End

















    //Get Header Start
    public void get_header(View view)
    {

        try
        {
            ImageView appview_header_image = (ImageView) view.findViewById(R.id.image_view_header_m_ac);
            Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getContext()).load(database.Header_URL).into(appview_header_image);
        }
        catch (Exception Err)
        {

        }

    }
    //Get Header End

















    //Auto Fill Items Start
    public void auto_fill_refresh() throws Exception
    {

        CountDownTimer timer=new CountDownTimer(600000,10000)
        {

            @Override
            public void onTick(long l)
            {

                try
                {

                    final int old_count = database.my_price_id.size();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            database.get_all_my_order_list_now();
                        }
                    }).start();


                    //Timer 2
                    CountDownTimer timer1 = new CountDownTimer(9500, 100)
                    {
                        @Override
                        public void onTick(long l)
                        {

                            try
                            {
                                if (database.my_price_id.size() != old_count || m_ac.Start_a_N_Price)
                                {
                                    if (database.my_price_id.size() <= 0 && check_empty())
                                    {
                                        empty_ly.setVisibility(View.VISIBLE);
                                        swipeRefreshLayout.setVisibility(View.GONE);
                                    }
                                    else
                                    {
                                        empty_ly.setVisibility(View.GONE);
                                        swipeRefreshLayout.setVisibility(View.VISIBLE);
                                        gridView_list.setAdapter(new my_list_adaptor());
                                    }
                                    m_ac.Start_a_N_Price = false;
                                }
                            }
                            catch (Exception Err)
                            {

                            }

                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                    //Timer 2


                }
                catch (Exception Err)
                {

                }


            }

            @Override
            public void onFinish()
            {

            }

        }.start();

    }
    //Auto Fill Items End













    //Check Empty
    public Boolean check_empty()
    {
        try
        {
            if(gridView_list.getAdapter().getCount()==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception Err)
        {
            return false;
        }
    }
    //Check Empty














    //My List Adaptor Start
    class my_list_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.my_price_id.size();
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

            view=getLayoutInflater().inflate(R.layout.one_colnum_grid_view6,null);

            try
            {

                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.item_anim);

                ImageView imageView = (ImageView) view.findViewById(R.id.picture_image_view_one_colnum_grid_view2);

                TextView textVie1w = (TextView) view.findViewById(R.id.time_textview_one_colnum_grid_ly2);

                TextView textVie11 = (TextView) view.findViewById(R.id.services_name_textview_one_colnum_grid_ly2);

                TextView an_other_Counter = (TextView) view.findViewById(R.id.an_other_textview_one_colnum_grid_view_2);


                ImageView imageView1_profile = (ImageView) view.findViewById(R.id.an_other_imageview1_one_colnum_grid_view_2);
                ImageView imageView2_profile = (ImageView) view.findViewById(R.id.an_other_imageview2_one_colnum_grid_view_2);
                ImageView imageView3_profile = (ImageView) view.findViewById(R.id.an_other_imageview3_one_colnum_grid_view_2);


                ImageView icon = (ImageView) view.findViewById(R.id.icon_imageview_one_colnum_grid_view2);
                RelativeLayout icon_background = (RelativeLayout) view.findViewById(R.id.icon_ly_one_colnum_grid_view2);
                TextView icon_text_view = (TextView) view.findViewById(R.id.text_icon_one_colnum_grid_view2);


                textVie1w.setText(database.my_price_dateorther.get(i));

                textVie11.setText(database.my_price_name.get(i));

                an_other_Counter.setText(database.my_price_master_text.get(i).toString());

                SvgLoader.pluck().with(getActivity()).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.my_price_picture_url.get(i), imageView);

//            SvgLoader svg=new SvgLoader();
//            svg.load(Uri.parse(database.my_price_picture_url.get(i)),imageView);


                if (database.my_price_status.get(i).trim().equals("cancel"))
                {
                    icon.setImageResource(R.drawable.close_one_colnum_ly_2_icon);
                    icon_background.setBackgroundResource(R.drawable.close_one_colnum_ly_2_icon_background);
                    icon_text_view.setTextColor(0xFFad0540);
                    icon_text_view.setText(database.my_price_status_text.get(i));
                }
                else if (database.my_price_status.get(i).trim().equals("selected"))
                {
                    icon.setImageResource(R.drawable.done_one_colnum_ly_2_icon);
                    icon_background.setBackgroundResource(R.drawable.done_one_colnum_ly_2_icon_background);
                    icon_text_view.setTextColor(0xFF699f3a);
                    icon_text_view.setText(database.my_price_status_text.get(i));
                }
                else if (database.my_price_status.get(i).trim().equals("wait"))
                {
                    icon.setImageResource(R.drawable.clock_one_colnum_ly_2_icon);
                    icon_background.setBackgroundResource(R.drawable.clock_one_colnum_ly_2_icon_background);
                    icon_text_view.setTextColor(0xFF008fcb);
                    icon_text_view.setText(database.my_price_status_text.get(i));
                }
                else
                {
                    icon.setVisibility(View.GONE);
                    icon_background.setVisibility(View.GONE);
                    icon_text_view.setVisibility(View.GONE);
                }


                try
                {

                    String images_url = database.my_price_masters.get(i).toString() + ",";
                    String[] masters = images_url.split(",");


                    try
                    {
                        masters[0]=masters[0].replace("[","");
                        masters[0]=masters[0].replace("]","");

                        if (!masters[0].equals(""))
                        {
                            Picasso.get().load(database.json_clear(masters[0]).trim()).into(imageView3_profile);
                        }
                        else
                        {
                            imageView3_profile.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception Err)
                    {

                    }


                    try
                    {

                        masters[1]=masters[1].replace("[","");
                        masters[1]=masters[1].replace("]","");

                        if (!masters[1].equals(""))
                        {
                            Picasso.get().load(database.json_clear(masters[1]).trim()).into(imageView2_profile);
                        }
                        else
                        {
                            imageView2_profile.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception Err)
                    {

                    }


                    try
                    {

                        masters[2]=masters[2].replace("[","");
                        masters[2]=masters[2].replace("]","");

                        if (!masters[2].equals(""))
                        {
                            Picasso.get().load(database.json_clear(masters[2]).trim()).into(imageView1_profile);
                        }
                        else
                        {
                            imageView1_profile.setVisibility(View.GONE);
                        }
                    }
                    catch (Exception Err)
                    {

                    }


                }
                catch (Exception Err)
                {

                }

//            view.setAnimation(anim);


//            registerForContextMenu(view);


            }
            catch (Exception Err)
            {

            }

            return view;
        }
    }
    //My List Adaptor End


}
