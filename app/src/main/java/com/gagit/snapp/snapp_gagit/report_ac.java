package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.Picasso;

public class report_ac extends AppCompatActivity
{


    //Vars Strat
    TextView []textView=new TextView[6];
    ImageView header_image_view;

    public static String item1="",item2="",item3="",picture="";
    //Vars End


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_ac);
        refresh();
    }











    //Componenets Start
    public void refresh()
    {

        get_header();

        textView[0]=(TextView)findViewById(R.id.xadmat_textview_report_ac);
        textView[1]=(TextView)findViewById(R.id.xadmat_type_textview_report_ac);
        textView[2]=(TextView)findViewById(R.id.xadmat_type_sub_textview_report_ac);
        textView[3]=(TextView)findViewById(R.id.xadmat_day_textview_report_ac);
        textView[4]=(TextView)findViewById(R.id.xadmat_time_textview_report_ac);
        textView[5]=(TextView)findViewById(R.id.ditales_textview_report_ac);

//        get_header();

        header_image_view=(ImageView)findViewById(R.id.image_view_report_ac);


        if(item1.equals("")||item1.equals("")||item1.equals("")||picture.equals(""))
        {
            SvgLoader.pluck().with(this).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.items_sub_item_icons3.get(selected_cat_flag.item_clicked_n_price_sub), header_image_view);
            textView[0].setText(database.items.get(n_price_frag.item_clicked_n_price));
            textView[1].setText(database.items_sub_item.get(selected_cat_flag.item_clicked_n_price));
            textView[2].setText(database.items_sub_item3.get(selected_cat_flag.item_clicked_n_price_sub));
            textView[3].setText(clock_price_ac.Day);
            textView[4].setText(clock_price_ac.hourse + ":" + clock_price_ac.min);
            textView[5].setText(detailes_ac.det);
        }
        else
        {
            SvgLoader.pluck().with(this).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(picture, header_image_view);
            textView[0].setText(item1);
            textView[1].setText(item2);
            textView[2].setText(item3);
            textView[3].setText(clock_price_ac.Day);
            textView[4].setText(clock_price_ac.hourse + ":" + clock_price_ac.min);
            textView[5].setText(detailes_ac.det);
        }


    }
    //Componenets End










    //On Click Done Button Start
    public void onclick_done_btn_report_ac(View v)
    {
        startActivity(new Intent(getApplicationContext(),price_done_ac.class));

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    String date = clock_price_ac.Year + "/" + clock_price_ac.Mounth + "/" + clock_price_ac.Day + "/" + clock_price_ac.hourse + "/" + clock_price_ac.min;
                    database.Insert_new_Price(detailes_ac.det, date);
                    new database("",database.SHA);
                }
                catch (Exception Err)
                {
                    Log.i("Err9",Err.getMessage());
                }
                clock_price_ac.Day="";
                clock_price_ac.min="";
                clock_price_ac.hourse="";
                clock_price_ac.day=0;
                clock_price_ac.Mounth=0;
                clock_price_ac.Year=0;
                numbers_ac.Counter=0;
                type_ac.Counter=0;
                check_list_ac.Counter=0;
                question_ac.Counter=0;
                n_price_frag.item_clicked_n_price=0;
                selected_cat_flag.item_clicked_n_price=0;
                selected_cat_flag.item_clicked_n_price_sub=0;
                clock_price_ac.hourse=clock_price_ac.min=question_ac.ditales=clock_price_ac.Day="";
                picture="";
                item1=item2=item3="";
                detailes_ac.det="";
            }
        }).start();


    }
    //On Click Done Button End













    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End






}
