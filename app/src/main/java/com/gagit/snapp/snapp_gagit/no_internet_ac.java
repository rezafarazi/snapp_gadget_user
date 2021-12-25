package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class no_internet_ac extends AppCompatActivity
{


    //All Components

    RelativeLayout Main_Relativ_layout_no_internet_connetion;

    //All Components



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet_ac);
        refresh();
    }










    //On Back Button Click Start//
    @Override
    public void onBackPressed()
    {
        Intent exit=new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        startActivity(exit);
    }
    //On Back Button Click End//







    //On Click Retry Button In No Internet Connection Activity Start
    public void onclick_retry_connect_to_Internet(View v)
    {

        if (isNetworkAvailable())
        {
            startActivity(new Intent(getApplicationContext(), Log.class));
            overridePendingTransition(R.anim.activity_anim, R.anim.activity_anim);
        }
        else
        {
            Snackbar nointernet_agin = Snackbar.make(Main_Relativ_layout_no_internet_connetion, R.string.no_internet_connection_text, Snackbar.LENGTH_SHORT);
            nointernet_agin.show();
        }

    }
    //On Click Retry Button In No Internet Connection Activity End














    //Check To Connected To InterNet Start//
    public boolean isNetworkAvailable()
    {
        try
        {
            ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        catch (Exception Err)
        {
            return true;
        }
    }
    //Check To Connected To InterNet Start//








    //Components ID
    public void refresh()
    {
        Main_Relativ_layout_no_internet_connetion=(RelativeLayout)findViewById(R.id.no_internet_connection_main_relativ);
    }
    //Components ID






}
