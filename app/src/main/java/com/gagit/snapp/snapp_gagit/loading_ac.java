package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class loading_ac extends AppCompatActivity
{



    boolean aBoolean=false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_loading_ac);
            save_and_start();
        }
        catch (Exception Err)
        {

        }

    }











    public void save_and_start() throws Exception
    {
        CountDownTimer timer=new CountDownTimer(60000,1000)
        {
            @Override
            public void onTick(long l)
            {

                try
                {
                    if (!database.items.get(0).trim().equals("") && !aBoolean)
                    {
                        aBoolean = true;
                        Toast.makeText(getApplicationContext(), "خوش آمدید", Toast.LENGTH_SHORT).show();
                        save_profile();
                        startActivity(new Intent(getApplicationContext(), m_ac.class));
                        overridePendingTransition(R.anim.activity_anim, R.anim.activity_anim);
                        m_ac.fris_log = 1;
                    }
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












    //Save Profile Start
    public void save_profile() throws Exception
    {
        SharedPreferences.Editor editor=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE).edit();

        editor.putString("phone",Sms_Panle_sign.Phone_number);
        editor.putString("SHA",database.SHA);

        editor.apply();

    }
    //Save Profile End






}
