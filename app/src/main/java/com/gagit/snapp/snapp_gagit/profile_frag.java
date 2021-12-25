package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;


public class profile_frag extends Fragment
{




    //Vars Start
    TextView Phone_number_header_Text_View,Money_Text_View;
    ImageView profile_image;
    //Vars End





    //Fragmet Start
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_profile_frag, container, false);
        get_header(view);
        refresh(view);
        return view;
    }
    //Fragmet End










    //Get Header Start
    public void get_header(View view)
    {
        ImageView appview_header_image=(ImageView)view.findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End











    //Components Start
    public void refresh(View v)
    {
        Phone_number_header_Text_View=(TextView)v.findViewById(R.id.phone_number_text_view_profile_header_frag);
        Money_Text_View=(TextView)v.findViewById(R.id.money_text_view_profile_header_frag);
        profile_image=(ImageView)v.findViewById(R.id.profile_image_view_profile_header);


        Phone_number_header_Text_View.setText(user_class.mobile);
        Money_Text_View.setText(user_class.money);
//        Picasso.with(getContext()).load(user_class.picture).into(profile_image);
        profile_image();


        //Request To Server Start
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                database db=new database("",Logo.SHA);
                Money_Text_View.setText(user_class.money);
            }
        }).start();
        //Request To Server End




        if(Build.VERSION.SDK_INT>21)
        {

            LinearLayout []btn=new LinearLayout[9];
            btn[0]=(LinearLayout)v.findViewById(R.id.profile_btn1_profile_context_frag);
            btn[1]=(LinearLayout)v.findViewById(R.id.profile_btn2_profile_context_frag);
            btn[2]=(LinearLayout)v.findViewById(R.id.profile_btn3_profile_context_frag);
            btn[3]=(LinearLayout)v.findViewById(R.id.profile_btn4_profile_context_frag);
            btn[4]=(LinearLayout)v.findViewById(R.id.profile_btn5_profile_context_frag);
            btn[5]=(LinearLayout)v.findViewById(R.id.profile_btn6_profile_context_frag);
            btn[6]=(LinearLayout)v.findViewById(R.id.profile_btn7_profile_context_frag);
            btn[7]=(LinearLayout)v.findViewById(R.id.profile_btn8_profile_context_frag);
            btn[8]=(LinearLayout)v.findViewById(R.id.profile_btn9_profile_context_frag);


            for (int a = 0; a < btn.length; a++)
            {
                btn[a].setBackgroundResource(R.drawable.ripple_white);
            }

        }







    }
    //Components End









    //Load Profile Image To ImageView Start
    public void profile_image()
    {

        String image_uri=user_class.picture.trim();
        Picasso.get().load(image_uri).into(profile_image);
//        Picasso.with(getContext()).load(image_uri).into(profile_image);
    }
    //Load Profile Image To ImageView End




}
