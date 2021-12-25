package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class question_ac extends AppCompatActivity
{




    //Vars Start
    public static EditText question_ac_text_area,num_edittext;
    public static String ditales="";
    public static int Counter=0;
    TextView question_text_view;
    public static ArrayList<String> questions_text=new ArrayList<>();
    public static int Count=0;
    //Vars End




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_ac);
        refresh();
    }









    //On Click Done Btn Start
    public void onclick_done_btn_question_ac(View v)
    {


        Count=(Count<0)?0:Count;

        try
        {
            if(questions_text.get(Count).toString().trim().equals(""))
            {
                questions_text.add(question_ac_text_area.getText().toString().trim());
            }
            else
            {
                questions_text.set(Count,question_ac_text_area.getText().toString().trim());
            }
        }
        catch (Exception Err)
        {
            questions_text.add(question_ac_text_area.getText().toString().trim());
        }






        boolean have_text=false;


        for(int a=Counter;a<database.question_text.size();a++)
        {

            try
            {
                if(!database.question_text.get(a).equals(""))
                {
                    have_text=true;
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



        if(have_text)
        {
            Count++;
            startActivity(new Intent(getApplicationContext(),question_ac.class));
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),detailes_ac.class));
        }

    }
    //On Click Done Btn End















    //Get All Compoennets Start
    public void refresh()
    {
        ArrayList<String> text=database.question_text.get(Counter);
        question_ac_text_area=(EditText)findViewById(R.id.text_area_question_ac);
        question_text_view=(TextView)findViewById(R.id.question_textview_question_ac);


        question_text_view.setText(database.question.get(check_list_ac.Counter+type_ac.Counter+numbers_ac.Counter));

        question_ac_text_area.setText(ditales);
        question_ac_text_area.setHint(text.get(0));
        Counter++;
        get_header();
    }
    //Get All Compoennets End











    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End















    //On Back Pressed STart
    @Override
    public void onBackPressed()
    {
        Counter--;
        Count--;
        super.onBackPressed();
    }
    //On Back Pressed End




}
