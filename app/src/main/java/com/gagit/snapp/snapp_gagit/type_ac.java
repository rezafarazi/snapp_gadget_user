package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class type_ac extends AppCompatActivity
{




    //Vars Start
    LinearLayout types_Liner_view;
    TextView header_text_view_question;
    public static ArrayList<String> selected_items=new ArrayList<>();
    public static int Counter=0;
    String Value="";
    public static ArrayList<String> Selected_items=new ArrayList<>();
    public static int Count=0;
    //Vars End






    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_ac);
        refresh();
    }










    //On Click Done Button Start
    public void onclick_done_btn_type_ac(View v)
    {


        Count=(Count<0)?0:Count;


        try
        {
            if (!Selected_items.get(Count).equals("")||Selected_items.get(Count).equals(""))
            {
                Selected_items.set(Count, Value);
            }
            else
            {
                Selected_items.add(Value);
            }
        }
        catch (Exception Err)
        {
            Selected_items.add(Value);
        }




        boolean have_radio=false;


        for(int a=Counter;a<database.question_radio.size();a++)
        {

            try
            {
                if(!database.question_radio.get(a).equals(""))
                {
                    have_radio=true;
                   break;
                }
                else
                {
                    Counter++;
                }
            }
            catch (Exception Err)
            {

            }

        }










        if(have_radio)
        {
            startActivity(new Intent(getApplicationContext(),type_ac.class));
            Count++;
        }
        else
        {
            try
            {
                if(!database.question_check.get(0).equals(""))
                {
                    startActivity(new Intent(getApplicationContext(),check_list_ac.class));
                }
            }
            catch (Exception Err)
            {
                try
                {
                    if(!database.question_number.get(0).equals(""))
                    {
                        startActivity(new Intent(getApplicationContext(),numbers_ac.class));
                    }
                }
                catch (Exception Err2)
                {
                    startActivity(new Intent(getApplicationContext(),clock_price_ac.class));
                }
            }

        }


    }
    //On Click Done Button End















    //Get Component Start
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void refresh()
    {
        get_header();
        types_Liner_view=(LinearLayout)findViewById(R.id.types_Liner_type_ac);
        header_text_view_question=(TextView)findViewById(R.id.question_header_text_type_ac);


//        header_text_view_question.setText(database.question.get(check_list_ac.Counter+type_ac.Counter));
        //Is Chenged
        header_text_view_question.setText(database.question.get(type_ac.Counter+database.check_question.size()));
        //Is Chenged

        RadioGroup radioGroup=new RadioGroup(this);
        types_Liner_view.addView(radioGroup);
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        radioGroup.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        radioGroup.setTextDirection(View.TEXT_DIRECTION_RTL);


        ArrayList<String> radio_list=database.question_radio.get(Counter);

        radio_list.trimToSize();

//
//        for(int a=Counter;a<database.question_radio.size();a++)
//        {
//
//            try
//            {
//
//
//                if(!radio_list.get(a).equals(""))
//                {
//
//                    break;
//                }
//                else
//                {
//                    radio_list.clear();
//                    Counter++;
//                }
//            }
//            catch (Exception Err)
//            {
//                Counter++;
//            }
//
//        }




        for(int a=0;a<radio_list.size();a++)
        {
            RadioButton radioButton=new RadioButton(this);
            radioButton.setText(radio_list.get(a));
            radioGroup.addView(radioButton);
            RadioGroup.LayoutParams layoutParams=new RadioGroup.LayoutParams(radioButton.getLayoutParams());
            layoutParams.setMargins(20,20,20,20);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setId(a);
            radioButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    RadioButton radioButton1=(RadioButton)findViewById(view.getId());
                    Value=radioButton1.getText().toString().trim();
                }
            });
        }

        Counter++;





    }
    //Get Component End




















    //On Back Press Start
    @Override
    public void onBackPressed()
    {
        Counter--;
        Count--;
        super.onBackPressed();
    }
    //On Back Press Start
























    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End





}
