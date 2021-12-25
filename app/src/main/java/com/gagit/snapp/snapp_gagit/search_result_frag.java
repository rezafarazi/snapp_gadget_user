package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.zip.Inflater;


public class search_result_frag extends Fragment
{





    //Vars Start//
    public static GridView search_result;
    public static SwipeRefreshLayout swipe_refresh;
    //Vars End//






    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_search_result_frag,container,false);

        search_result=(GridView)view.findViewById(R.id.search_view_grid_view);

        swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_search_result_frag);

        return view;
    }












}
