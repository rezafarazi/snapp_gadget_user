package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.apache.http.util.EncodingUtils;

public class pay_web_view_ac extends AppCompatActivity
{

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_web_view_ac);
        refresh();
        get_header();
    }













    //Get All Compoenents Start
    public void refresh()
    {
        webView=(WebView)findViewById(R.id.pay_web_view_ac);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        byte []post=EncodingUtils.getBytes("uid="+(user_class.uid.toString())+"&amount="+(pay_ac.pay_money+""),"UTF-8");
        webView.postUrl(database.API_URL+"user_c/to_server/pay.php",post);


//        Toast.makeText(this, "uid="+user_class.uid+"&amount="+pay_ac.pay_money, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "لطفا چند لحظه صبر کنید", Toast.LENGTH_SHORT).show();
    }
    //Get All Components End








    @Override
    public void onBackPressed()
    {

    }







    public void onclick_end_event_webview_ac(View v)
    {
        startActivity(new Intent(getApplicationContext(),m_ac.class));
    }








    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
//        Picasso.get().load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End





}
