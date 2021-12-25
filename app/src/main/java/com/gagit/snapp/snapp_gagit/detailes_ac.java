package com.gagit.snapp.snapp_gagit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class detailes_ac extends AppCompatActivity
{



    //Vars Start
    public static String det="";
    EditText text_area;
    //Vars End







    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detailes_ac);
            refresh();
        }
        catch (Exception Err)
        {

        }

    }









    //On Click Done Button Detailes Ac Start
    public void onclick_done_btn_detailes_ac(View v)
    {

        try
        {
            det = text_area.getText().toString().trim();
            startActivity(new Intent(getApplicationContext(), report_ac.class));
        }
        catch (Exception Err)
        {

        }

    }
    //On Click Done Button Detailes Ac End










    //Get All Components Start
    public void refresh() throws Exception
    {
        text_area=(EditText)findViewById(R.id.text_area_detailes_ac);
        text_area.setText(det);
    }
    //Get All Components End





}
