package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Logo extends AppCompatActivity
{



    //All Componenet Start//
    LinearLayout Sing_and_Log;
    ProgressBar progressBar_Log_ac;
    ViewPager slider_log_ac;
    ImageView logo_image_view;
    Button Create_acc;
    RelativeLayout Mian_Relative;
    boolean sign_in_to_app=false;
    int a=0;
    public static String SHA;
    //All Componenet End//












    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        refresh();
        timer();
    }
















    //Timer And Start Activity
    int anim_counter=0;
    public void timer()
    {
        final boolean sign=eventss();

        final CountDownTimer timer=new CountDownTimer(60000,10)
        {
            @Override
            public void onTick(long l)
            {



                if(isNetworkAvailable())
                {



                    if (sign)
                    {


                        try
                        {
                            if (!database.items.get(0).equals("") && !user_class.uid.equals("") && !sign_in_to_app && !database.Header_URL.equals(""))
                            {
                                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_anim_logo);
                                logo_image_view.setAnimation(anim);
                                anim.start();
                                Start_Main_Page();
                                sign_in_to_app=true;
                            }
                        }
                        catch (Exception Err)
                        {

                        }



                    }
                    else
                    {
                        if(a==2)
                        {
                            Not_Sign();
                        }
                    }
                }
                else
                {
                    if(!sign_in_to_app)
                    {
                        startActivity(new Intent(getApplicationContext(), no_internet_ac.class));
                        overridePendingTransition(R.anim.activity_anim, R.anim.activity_anim);
                        sign_in_to_app = true;
                    }
                }
                a++;

            }

            @Override
            public void onFinish()
            {
            }
        }.start();
    }
    //Timer And Start Activity End
















    //Get Events Main Start
    public boolean eventss()
    {
        return check_Sign();
    }
    //Get Events Main Start
























    //Start Main Page Start//
    public void Start_Main_Page()
    {
        startActivity(new Intent(getApplicationContext(),m_ac.class));
//        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //Start Main Page End//





















    //If Not SignEd To App//
    public void Not_Sign()
    {

//
//        startActivity(new Intent(getApplicationContext(),frist_slider.class));
//        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);

        progressBar_Log_ac.setVisibility(View.GONE);

        slider_log_ac.setVisibility(View.GONE);

        logo_image_view.setVisibility(View.VISIBLE);

        Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sign_and_log_panle_anim);

        Animation anim2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sign_and_log_panle_anim2);

        Sing_and_Log.setVisibility(View.VISIBLE);

        Sing_and_Log.setAnimation(anim);

        slider_logo_ac slider_cls=new slider_logo_ac(this);

        slider_log_ac.setAdapter(slider_cls);

        slider_log_ac.setAnimation(anim2);

        anim.start();


    }
    //If Not SignEd To App//




















    //Check For Log In To Soft Ware//
    public boolean check_Sign()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE);

        SHA=sharedPreferences.getString("SHA","");


        if(!SHA.trim().equals(""))
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    database db=new database("",SHA);

//                    Log.i("Err10",database.Header_URL);

                }
            }).start();

            return true;
        }
        else
        {
            return false;
        }
    }
    //Check For Log In To Soft Ware//




















    //On Click On Sign In Button Event Start//
    public void onclick_sign_in_btn_in_log_ac(View v)
    {
//        startActivity(new Intent(getApplicationContext(),Sign_ac.class));
//        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
        startActivity(new Intent(getApplicationContext(),Sms_Panle_sign.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //On Click On Sign In Button Event End//



















    //On Click On Lgo In Button Event Start//
    public void onclick_log_in_btn_in_log_ac(View v)
    {
//        startActivity(new Intent(getApplicationContext(),login_ac.class));
//        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
        startActivity(new Intent(getApplicationContext(),Sms_Panle_sign.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //On Click On Log In Button Event End//




















    //Check To Connected To InterNet Start//
    public boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //Check To Connected To InterNet Start//

























    public void events()
    {
        slider_log_ac.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {

                Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_anim3);

                view.setAnimation(anim);

                return false;
            }
        });
    }
















    //Change Language//

    public void changelang_to_en(View v)
    {
//        setLocale("en");
//        Create_acc.setText("Sign in");
//        recreate();
    }







    public void changelang_to_fa(View v)
    {
//        setLocale("fa");
//        Create_acc.setText("حساب جدید");
//        recreate();
    }








    public void setLocale(String loc)
    {
//        Locale locale=new Locale(loc);
//        Locale.setDefault(locale);
//
//        Configuration configuration=new Configuration();
//        configuration.locale=locale;
//
//        getBaseContext().getResources().updateConfiguration(configuration,getResources().getDisplayMetrics());
//
//        SharedPreferences.Editor sharedPreferences=getSharedPreferences("Settings",MODE_PRIVATE).edit();
//
//        sharedPreferences.putString("My_Lang",loc);
//
//        sharedPreferences.apply();
    }








    public void Change_lang()
    {
//        SharedPreferences editor=getSharedPreferences("Settings",MODE_PRIVATE);
//
//        String lang=editor.getString("My_Lang","");
//
//        setLocale(lang);
//
//
//        if(lang.equals("en"))
//        {
//            Create_acc.setText("Sign in");
//        }
//        else
//        {
//            Create_acc.setText("حساب جدید");
//        }

    }




    //Change Language//
























































    //Components ID
    public void refresh()
    {
        Sing_and_Log=(LinearLayout)findViewById(R.id.sing_and_log);
        progressBar_Log_ac=(ProgressBar)findViewById(R.id.procc_load_start);
        slider_log_ac=(ViewPager)findViewById(R.id.slider_in_logo_ac);
        logo_image_view=(ImageView)findViewById(R.id.logo_in_log_ac);
        Create_acc=(Button)findViewById(R.id.create_a_account_logo_ac);
        Mian_Relative=(RelativeLayout)findViewById(R.id.relative_logo_ac);


        events();
//        Change_lang();

    }
    //Components ID









}
