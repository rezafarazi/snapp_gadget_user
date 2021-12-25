package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Sms_Panle_sign extends AppCompatActivity
{


    EditText Phone_Number;
    public static String Phone_number;
    public static String Key="";




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms__panle_sign);
        refresh();
    }





    public void onclick_on_done_Sms_ac_done_btn(View v)
    {
        if(check())
        {
            Generate_Password_Key();
            Phone_number=Phone_Number.getText().toString().trim();
            startActivity(new Intent(getApplicationContext(),Sms2_ac.class));
            overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
        }

    }






    public boolean check()
    {
        char []chars=Phone_Number.getText().toString().toCharArray();

        if(chars.length==11)
        {
                if(chars[0]=='0'&&chars[1]=='9')
                {
                    Phone_number=Phone_Number.getText().toString().trim();
                    return true;
                }
        }

        return false;
    }










    public void Generate_Password_Key()
    {

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                database db=new database(Phone_Number.getText().toString().trim());

            }

        }).start();

    }













    public void refresh()
    {
        Phone_Number=(EditText)findViewById(R.id.Enter_Your_Phone_Number_Text_Box);
    }



}
