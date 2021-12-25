package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class price_done_ac extends AppCompatActivity
{


    boolean aBoolean=false;
    boolean started_m_ac=false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_done_ac);



        CountDownTimer timer=new CountDownTimer(60000,1000)
        {
            @Override
            public void onTick(long l)
            {
                try
                {
                    if(!aBoolean && !database.Sended.equals(""))
                    {
                        if(database.Sended.equals("{\"alert\":\"success\"}"))
                        {

                            if(!database.my_price_id.get(0).trim().equals("")&&!database.items.get(0).trim().equals(""))
                            {

                                database.get_all_my_order_list_now();

                                CountDownTimer timer1=new CountDownTimer(5000,10)
                                {
                                    @Override
                                    public void onTick(long l)
                                    {
                                        try
                                        {
                                            if (!started_m_ac && !database.my_price_id.equals(""))
                                            {
                                                Toast.makeText(price_done_ac.this, R.string.sended_a_pricer, Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(), m_ac.class));
                                                database.Sended = "";
                                                aBoolean = true;
                                                started_m_ac = true;
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
                        }
                        else
                        {
                            Toast.makeText(price_done_ac.this, R.string.not_sended, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), m_ac.class));
                            aBoolean = true;
                            database.Sended="";
                        }

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



}
