package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.http.util.EncodingUtils;

public class Access_is_false_ac extends AppCompatActivity
{



    //All Vars Start
    WebView webView;
    String SHA;
    //All Vars End





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_access_is_false_ac);
            refresh();
            get_profile();
            refresh_timer();
        }
        catch (Exception Err)
        {

        }
    }




    //Get All Componnets Start
    public void refresh() throws Exception
    {
        webView=(WebView)findViewById(R.id.web_view_access_is_false_ac);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        security security=new security();

        byte []post=EncodingUtils.getBytes("security="+security.code()+"&uid="+user_class.uid,"UTF-8");
        webView.postUrl("http://snapp-gadget.ir/api/user_s/to_server/change_profile.php",post);

    }
    //Get All Componnets End





    //On Back Pressed Start
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    //On Back Pressed End








    //Get Profile Start
    public void get_profile() throws Exception
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE);

        SHA=sharedPreferences.getString("SHA","");
    }
    //Get Profile End








    //Timer Start
    public void refresh_timer() throws Exception
    {
//
//        CountDownTimer timer =new CountDownTimer(6000000,5000)
//        {
//            @Override
//            public void onTick(long l)
//            {
//
//
//                new database("",SHA);
//
//
//                CountDownTimer timer1=new CountDownTimer(4500,100)
//                {
//                    @Override
//                    public void onTick(long l)
//                    {
//
//                    }
//
//                    @Override
//                    public void onFinish()
//                    {
//
//                    }
//                }.start();
//
//
//            }
//
//            @Override
//            public void onFinish()
//            {
//
//            }
//
//        }.start();

    }
    //Timer End











}
