package com.gagit.snapp.snapp_gagit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import com.squareup.picasso.Picasso;

public class clock_price_ac extends AppCompatActivity
{



    //Vars Start
    public static String Day="";
    public static String hourse,min;
    String str;
    Button btn;
    public static int day,Mounth,Year;
    //Vars End





    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_clock_price_ac);
            btn = (Button) findViewById(R.id.date_btn_clock_ac);
            btn.setText((!Day.equals("")) ? Day : "انتخاب تاریخ");
            get_header();
        }
        catch (Exception Err)
        {

        }

    }

















    //Day Price Start
    public void radio_btn_clock_price_ac(View v)
    {
//        Button btn=(Button) findViewById(v.getId());
//
//        if(v.getId()==R.id.radio1_day_clock_price_ac)
//        {
//            Button btn2=(Button)findViewById(R.id.radio2_day_clock_price_ac);
//            btn2.setBackgroundResource(R.color.colorAccent);
//            btn.setBackgroundResource(R.color.colorPrimaryDark);
//            btn2.setTextColor(0xFF9e015c);
//            btn.setTextColor(0xFFFFFFFF);
//        }
//        else
//        {
//            Button btn1=(Button)findViewById(R.id.radio1_day_clock_price_ac);
//            btn1.setBackgroundResource(R.color.colorAccent);
//            btn.setBackgroundResource(R.color.colorPrimaryDark);
//            btn1.setTextColor(0xFF9e015c);
//            btn.setTextColor(0xFFFFFFFF);
//        }
//
//        Day=btn.getText().toString().trim();
    }
    //Day Price End















    //On Click Done Button Start
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onclick_done_clock_price_ac(final View v)
    {



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Dexter.withActivity(clock_price_ac.this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener()
            {

                @Override
                public void onPermissionGranted(PermissionGrantedResponse response)
                {
                    if (!Day.equals("") && check())
                    {
                        TimePicker timePicker = (TimePicker) findViewById(R.id.time_clock_price_ac);
                        hourse = timePicker.getHour() + "";
                        min = timePicker.getMinute() + "";
                        str = hourse + ":" + min;
//        Toast.makeText(this, str+"\n"+Day, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), map_ac.class));
                    }
                    else
                    {
                        Snackbar snackbar = Snackbar.make(v, R.string.chosee_date, Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }

                @Override
                public void onPermissionDenied(PermissionDeniedResponse response) {

                }

                @Override
                public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token)
                {

                }
            }).check();
        }
        else
        {

            if (!Day.equals("") && check())
            {
                TimePicker timePicker = (TimePicker) findViewById(R.id.time_clock_price_ac);
                hourse = timePicker.getHour() + "";
                min = timePicker.getMinute() + "";
                str = hourse + ":" + min;
//        Toast.makeText(this, str+"\n"+Day, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), map_ac.class));
            }
            else
            {
                Snackbar snackbar = Snackbar.make(v, R.string.chosee_date, Snackbar.LENGTH_SHORT);
                snackbar.show();
            }

        }


    }
    //On Click Done Button End
















    public void check_date_time()
    {

    }
















    public boolean check()
    {
        PersianCalendar now = new PersianCalendar();

//        if(day>now.getPersianDay())

        return true;
    }
















    //On Click Get Date Start
    public void onclick_get_clender(View v)
    {



        PersianCalendar now = new PersianCalendar();

        com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog datePickerDialog = com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.newInstance(new com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.OnDateSetListener()
        {
               @Override
               public void onDateSet(com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth)
               {
                   String Date=year+"/"+(monthOfYear+1)+"/"+dayOfMonth;

                   PersianCalendar persianCalendar=new PersianCalendar();


                   if(year==persianCalendar.getPersianYear())
                   {

                       if (monthOfYear >= persianCalendar.getPersianMonth())
                       {

                           if (dayOfMonth>=persianCalendar.getPersianDay()||(dayOfMonth<=persianCalendar.getPersianDay()&&monthOfYear > persianCalendar.getPersianMonth()))
                           {

                               day = dayOfMonth;
                               Mounth = monthOfYear;
                               year = Year;
                               btn.setText(Date);
                               Day = Date;

                           }

                       }
                   }

               }


        }, now.getPersianYear(),now.getPersianMonth(),now.getPersianDay());


        datePickerDialog.show(getFragmentManager(), "tpd");







    }
    //On Click Get Date End







    //Get Header Start
    public void get_header() throws Exception
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End






}
