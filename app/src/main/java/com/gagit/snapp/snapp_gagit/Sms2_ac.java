package com.gagit.snapp.snapp_gagit;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sms2_ac extends AppCompatActivity
{




    //Var s

    EditText done_code;
    TextView help_Text_view;

    int counter_invalde=0;

    //Var s






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms2_ac);
        refresh();
        events();
    }










    ///ON Back Buttton
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(getApplicationContext(),Logo.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    ///ON Back Buttton












    //On Click Done Button Start
    public void onclick_done_btn_check_digits(View v)
    {
        if(done_code.getText().toString().equals(database.Sms_Key))
        {
            start_main_ac_and_save();
        }
        else
        {
            if(counter_invalde<=3)
            {
                Toast.makeText(this, R.string.Password_invalde, Toast.LENGTH_SHORT).show();
            }
            else
            {
                startActivity(new Intent(getApplicationContext(),Logo.class));
            }
            counter_invalde++;
        }
    }
    //On Click Done Button End












    //Events On Start AC Time Start
    public void events()
    {
        done_code.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent)
            {

                if(done_code.getText().toString().equals(database.Sms_Key))
                {
                    start_main_ac_and_save();
                }


                return false;
            }
        });
    }
    //Events On Start AC Time End

















    //Save And Start Android App Start
    public void start_main_ac_and_save()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                new database("",database.SHA);
            }
        }).start();

        startActivity(new Intent(getApplicationContext(),loading_ac.class));
    }
    //Save And Start Android App End



















    //Change Phone Number On Click Event Start
    public void onclick_change_Phone_number(View v)
    {
        startActivity(new Intent(getApplicationContext(),Sms_Panle_sign.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //Change Phone Number On Click Event End


















    //Get All Components On Screen Satrt
    public void refresh()
    {
        done_code=(EditText)findViewById(R.id.Enter_virify_code);
        help_Text_view=(TextView)findViewById(R.id.text_help_sms2_ac);


        help_Text_view.setText(help_Text_view.getText().toString()+"\n"+Sms_Panle_sign.Phone_number);
    }
    //Get All Components On Screen End








}
