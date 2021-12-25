package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class themes_ac extends AppCompatActivity
{




    //Vars Start
    public static int color=0;
    ScrollView scrollView;
    RadioButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    //Vars End





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes_ac);
        refresh();
        get_color();
    }







    //On click a Item Start
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onclick_theme_item(View v)
    {

        ScrollView scrollView=(ScrollView)findViewById(R.id.scroll_view_themes_ac);

        switch (v.getId())
        {
            case R.id.radio_theme_1:
                setTheme_lay(R.color.theme0,1);
                break;

            case R.id.radio_theme_2:
                setTheme_lay(R.color.theme1,2);
                break;

            case R.id.radio_theme_3:
                setTheme_lay(R.color.theme2,3);
                break;

            case R.id.radio_theme_4:
                setTheme_lay(R.color.theme3,4);
                break;

            case R.id.radio_theme_5:
                setTheme_lay(R.color.theme4,5);
                break;

            case R.id.radio_theme_6:
                setTheme_lay(R.color.theme5,6);
                break;

            case R.id.radio_theme_7:
                setTheme_lay(R.color.theme6,7);
                break;

        }

    }
    //On click a Item End











    //Set A Theme Start
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setTheme_lay(int color,int index)
    {
        scrollView.setBackgroundResource(color);
//        getWindow().setStatusBarColor(ContextCompat.getColor(themes_ac.this,color));
        save_changed(index);
    }
    //Set A Theme End







    //Save To Sharep Start
    public void save_changed(int index)
    {
        SharedPreferences.Editor editor=getSharedPreferences("snapp_gaget",MODE_PRIVATE).edit();
        editor.putString("color",""+index);
        editor.apply();

    }
    //Save To Sharep End








    //Get Color Start
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void get_color()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("snapp_gaget",MODE_PRIVATE);
        String color_index=sharedPreferences.getString("color","");

        if(!color_index.trim().equals(""))
        {
            switch (color_index)
            {
                case "1":
                    btn1.setChecked(true);
                    break;
                case "2":
                    btn2.setChecked(true);
                    break;
                case "3":
                    btn3.setChecked(true);
                    break;
                case "4":
                    btn4.setChecked(true);
                    break;
                case "5":
                    btn5.setChecked(true);
                    break;
                case "6":
                    btn6.setChecked(true);
                    break;
                case "7":
                    btn7.setChecked(true);
                    break;
            }
            color=Integer.parseInt(color_index);
            switch (color)
            {
                case 1:
                    setTheme_lay(R.color.theme0,1);
                    break;

                case 2:
                    setTheme_lay(R.color.theme1,2);
                    break;

                case 3:
                    setTheme_lay(R.color.theme2,3);
                    break;

                case 4:
                    setTheme_lay(R.color.theme3,4);
                    break;

                case 5:
                    setTheme_lay(R.color.theme4,5);
                    break;

                case 6:
                    setTheme_lay(R.color.theme5,6);
                    break;

                case 7:
                    setTheme_lay(R.color.theme6,7);
                    break;

            }
        }


    }
    //Get Color End









    //Get Components Start
    public void refresh()
    {
        scrollView=(ScrollView)findViewById(R.id.scroll_view_themes_ac);
        btn1=(RadioButton)findViewById(R.id.radio_theme_1);
        btn2=(RadioButton)findViewById(R.id.radio_theme_2);
        btn3=(RadioButton)findViewById(R.id.radio_theme_3);
        btn4=(RadioButton)findViewById(R.id.radio_theme_4);
        btn5=(RadioButton)findViewById(R.id.radio_theme_5);
        btn6=(RadioButton)findViewById(R.id.radio_theme_6);
        btn7=(RadioButton)findViewById(R.id.radio_theme_7);
    }
    //Get Components End







}
