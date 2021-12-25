package com.gagit.snapp.snapp_gagit;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class command_ac extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_ac);
    }








    //On Click Send Commmand Btn Start
    public void onclick_btn_send_commadn_command_ac(View v)
    {

        try
        {

            if (isNetworkAvailable())
            {
                FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(v.getId());

                send_Text();

                onBackPressed();
            }
            else
            {
                Toast.makeText(this, R.string.Check_NetWork, Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception Err)
        {

        }

    }
    //On Click Send Commmand Btn End











    //Send Commmand Functon Start
    public void send_Text() throws Exception
    {
        final EditText editText=(EditText)findViewById(R.id.command_edit_text_command_ac);

        if(!editText.getText().toString().trim().equals("")&&check())
        {
            new Thread(new Runnable()
            {

                String value=editText.getText().toString().trim();

                @Override
                public void run()
                {

                    database.Insert_new_command(value);

                    if(database.Sended.equals("{\"alert\":\"success\"}"))
                    {
                        Log.i("Err2","Sended");
                    }
                    database.Sended="";
                }
            }).start();


            editText.setText("");

            Toast.makeText(command_ac.this, R.string.Doen_sended_comment, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(command_ac.this, R.string.Not_sended_comment, Toast.LENGTH_SHORT).show();
        }

    }
    //Send Commmand Functon End
















    //Check Auto Click Start
    public boolean check() throws Exception
    {

        SharedPreferences sharedPreferences=getSharedPreferences("S_g_p",MODE_PRIVATE);

        String date=sharedPreferences.getString("C_dt","");
        String count=sharedPreferences.getString("cnt","");



        cal cal=new cal();


        if(date.trim().equals(""))
        {
            SharedPreferences.Editor editor=getSharedPreferences("S_g_p",MODE_PRIVATE).edit();

            editor.putString("C_dt",cal.getIranianYear()+"/"+cal.getIranianMonth()+"/"+cal.getIranianMonth());
            editor.putString("cnt","1");

            editor.apply();

            return true;
        }
        else if(date.trim().equals(cal.getIranianYear()+"/"+cal.getIranianMonth()+"/"+cal.getIranianMonth())&&count.trim().equals("1"))
        {
            SharedPreferences.Editor editor=getSharedPreferences("S_g_p",MODE_PRIVATE).edit();

            editor.putString("C_dt",cal.getIranianYear()+"/"+cal.getIranianMonth()+"/"+cal.getIranianMonth());
            editor.putString("cnt","2");

            editor.apply();
            return true;
        }
        else if (!date.trim().equals(cal.getIranianYear()+"/"+cal.getIranianMonth()+"/"+cal.getIranianMonth()))
        {
            SharedPreferences.Editor editor=getSharedPreferences("S_g_p",MODE_PRIVATE).edit();

            editor.putString("C_dt",cal.getIranianYear()+"/"+cal.getIranianMonth()+"/"+cal.getIranianMonth());
            editor.putString("cnt","1");

            editor.apply();

            return true;
        }




        return false;
    }
    //Check Auto Click End
















    //Check To Connected To InterNet Start//
    public boolean isNetworkAvailable() throws Exception
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //Check To Connected To InterNet Start//



















    //Get Encript Start
    public String enc(String string)
    {
        try
        {
            String Key_s="1020315400006016161718651516516";
            Key key=new SecretKeySpec(Key_s.getBytes(),"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte []text=cipher.doFinal(string.getBytes());
            return new String(text);

        }
        catch (Exception Err)
        {

        }
        return "";
    }
    //Get Encript End











    //Get Encript Start
    public String denc(byte code)
    {
        try
        {
            String Key_s="1020315400006016161718651516516";
            Key key=new SecretKeySpec(Key_s.getBytes(),"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,key);
//            return new String(cipher.doFinal(code));

        }
        catch (Exception Err)
        {

        }
        return "";
    }
    //Get Encript End









}
