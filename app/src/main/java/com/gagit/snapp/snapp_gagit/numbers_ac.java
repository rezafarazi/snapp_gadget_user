package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class numbers_ac extends AppCompatActivity
{



    //Vars Start
    EditText Nums;
    TextView question;
    public static int Counter=0;
    public static ArrayList<String> numbers=new ArrayList<>();
    public static int Count=0;
    //Vars End




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_numbers_ac);
            refresh();
        }
        catch (Exception Err)
        {

        }

    }









    public void onclick_done_btn_numbers_ac(View v)
    {


        Count=(Count<0)?0:Count;

        try
        {
            if(numbers.get(Count).toString().trim().equals(""))
            {
                numbers.add(Nums.getText().toString().trim());
            }
            else
            {
                numbers.set(Count,Nums.getText().toString().trim());
            }
        }
        catch (Exception Err)
        {
            numbers.add(Nums.getText().toString().trim());
        }









        boolean have_num=false;


        for(int a=Counter;a<database.question_number.size();a++)
        {

            try
            {
                if(!database.question_number.get(a).equals(""))
                {
                    have_num=true;
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



        if(have_num)
        {
            startActivity(new Intent(getApplicationContext(),numbers_ac.class));
            Count++;
        }
        else
        {
            startActivity(new Intent(getApplicationContext(),clock_price_ac.class));
        }

    }













    //Get Header Start
    public void get_header()
    {

        try
        {
            ImageView appview_header_image = (ImageView) findViewById(R.id.image_view_header_m_ac);
            Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
        }
        catch (Exception Err)
        {

        }

    }
    //Get Header End















    //On Back Press Ed Start
    @Override
    public void onBackPressed()
    {
        Counter--;
        Count--;
        super.onBackPressed();
    }
    //On Back Press Ed End















    //Get All Componnts Start
    public void refresh()
    {
        try
        {
            get_header();
            Nums = (EditText) findViewById(R.id.number_edittext_numbers_ac);
            question = (TextView) findViewById(R.id.question_textview_numbers_ac);

            question.setText(database.question.get(check_list_ac.Counter + type_ac.Counter));

            ArrayList<String> number = database.question_number.get(Counter);
            Nums.setHint(number.get(0));
            Counter++;
        }
        catch (Exception Err)
        {

        }

    }
    //Get All Componnts End







}
