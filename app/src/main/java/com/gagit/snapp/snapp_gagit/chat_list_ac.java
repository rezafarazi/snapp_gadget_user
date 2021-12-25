package com.gagit.snapp.snapp_gagit;

import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

public class chat_list_ac extends AppCompatActivity
{





    //All Vars Start
    ImageView appview_header_image;
    GridView chat_list;
    SwipeRefreshLayout refreshLayout;
    RelativeLayout empty_ly;
    Boolean is_show=false;
    //All Vars End





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list_ac);
        refresh();
        events();
        refresh_timer();
        get_header();
    }






    //Get Header Start
    public void get_header()
    {
        appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End






    //Get All Components Start
    public void refresh()
    {
        chat_list=(GridView)findViewById(R.id.grid_view_chat_list_ac);
        refreshLayout=(SwipeRefreshLayout)findViewById(R.id.refresh_ly_chat_list_ac);
        empty_ly=(RelativeLayout)findViewById(R.id.not_avable_ly_chat_list_ac);


        refreshLayout.setRefreshing(true);


        CountDownTimer timer=new CountDownTimer(6000,10)
        {
            @Override
            public void onTick(long l)
            {

            }

            @Override
            public void onFinish()
            {
                if(!is_show)
                {
                    refreshLayout.setRefreshing(false);
                    chat_list.setAdapter(new chat_list_adaptor());
                    is_show=true;
                }
            }
        }.start();


    }
    //Get All Components End










    //Events Start
    public void events()
    {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                refreshLayout.setRefreshing(false);
            }
        });
    }
    //Events End












    //Timer Auto Refresh Start
    public void refresh_timer()
    {

        CountDownTimer timer=new CountDownTimer(6000000,5000)
        {
            @Override
            public void onTick(long l)
            {



                CountDownTimer timer1=new CountDownTimer(4500,10)
                {
                    @Override
                    public void onTick(long l)
                    {

                    }

                    @Override
                    public void onFinish()
                    {

                    }
                }.start();


            }

            @Override
            public void onFinish()
            {

            }
        }.start();

    }
    //Timer Auto Refresh End












    //Chat List Adaptor Start
    class chat_list_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return 10;
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
            view=getLayoutInflater().inflate(R.layout.one_chat_colnum_ly,null);

//            //Get Compoennt Start//
//            TextView title=(TextView)view.findViewById(R.id.one_chat_colnum_ly_title);
//            TextView message_count=(TextView)view.findViewById(R.id.one_colnum_ly_grid_3_messages);
//            TextView text=(TextView)view.findViewById(R.id.one_chat_colnum_ly_text);
//            TextView time=(TextView)view.findViewById(R.id.one_chat_colnum_ly_time);
//            ImageView tick=(ImageView)view.findViewById(R.id.one_chat_colnum_ly_see);
//            //Get Compoennt End//
//
//
//
//            //Set Value To Components Start
//            title.setText(getString(R.string.priceser_counter)+" "+chat_class.chat_list_ucid.get(i));
//            text.setText(chat_class.chat_list_text.get(i));
//            message_count.setText(chat_class.chat_list_unread.get(i));
//            time.setText(chat_class.chat_list_time.get(i));
//            //Set Value To Components End
//
//
//            if(chat_class.chat_list_tick.equals("1"))
//            {
//                tick.setImageResource(R.drawable.see_2_icon);
//            }
//            else
//            {
//                tick.setImageResource(R.drawable.single_see_icon);
//            }
//
//
//            if(chat_class.chat_list_unread.get(i).equals("0"))
//            {
//                message_count.setVisibility(View.GONE);
//            }
//            else
//            {
//                message_count.setVisibility(View.VISIBLE);
//            }

            return view;
        }
    }
    //Chat List Adaptor End








}
