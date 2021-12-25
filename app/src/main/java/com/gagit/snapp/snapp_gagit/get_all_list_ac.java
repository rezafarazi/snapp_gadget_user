package com.gagit.snapp.snapp_gagit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class get_all_list_ac extends AppCompatActivity
{

    //Vars
    GridView gridView;
    SwipeRefreshLayout swipe;
    //Vars



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_get_all_list_ac);
            refresh();
        }
        catch (Exception Err)
        {

        }

    }









    //Context Menu Start
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add("حذف درخواست");
        menu.add("پرداخت از اعتبار حساب");
    }










    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        return super.onContextItemSelected(item);
    }
    //Context Menu End












    //Get Components Start
    public void refresh() throws Exception
    {
        get_header();
        gridView = (GridView) findViewById(R.id.grid_get_all_list_ac);
//        gridView.setAdapter(new adaptor());
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_get_all_list_ac);
        events();
    }
    //Get Components End












    //Events Start
    public void events() throws Exception
    {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
//                gridView.setAdapter(new adaptor());
                swipe.setRefreshing(false);
            }
        });
    }
    //Events End











//    class adaptor extends BaseAdapter
//    {
//
//        @Override
//        public int getCount()
//        {
//            return selected_cat_flag.images.length;
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
//            view=getLayoutInflater().inflate(R.layout.done_list_items_row,null);
//
//            try
//            {
//                ImageView imageView = (ImageView) view.findViewById(R.id.image_grid_get_all_list_ac);
//                TextView textView = (TextView) view.findViewById(R.id.textview_grid_get_all_list_ac);
//
//                imageView.setImageResource(selected_cat_flag.images[i]);
//                textView.setText(selected_cat_flag.texts[i]);
//
//
//                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_anim);
//
//                view.setAnimation(animation);
//
//                registerForContextMenu(view);
//            }
//            catch (Exception Err)
//            {
//
//            }
//
//
//            return view;
//        }
//
//    }











    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
//        Picasso.get().load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End








}
