package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class check_list_ac extends AppCompatActivity
{


    //Vars Start
    GridView check_list;
    TextView question_header;
    public static int Counter=0;
    ArrayList<String> check_list_array=null;
    ArrayList<String> check_values=new ArrayList<>();
    public static int Count1=0;
    public static int Count2=0;
    public static ArrayList<ArrayList<String>> Selected_Checks_bank=new ArrayList<>();
    //Vars End






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_check_list_ac);
            refresh();
        }
        catch (Exception Err)
        {

        }

    }











    //On Click on Done Button Start
    public void onclick_done_check_list_ac(View v)
    {


        Count1=(Count1<0)?0:Count1;





        try
        {
            ArrayList<String> list=Selected_Checks_bank.get(Count1);

            if(list.get(0).equals(""))
            {
                Selected_Checks_bank.add(check_values);
            }
            else
            {
                Selected_Checks_bank.set(Count1,check_values);
            }
        }
        catch (Exception Err)
        {
            Selected_Checks_bank.add(check_values);
        }












        boolean have_check=false;


        for(int a=Counter;a<database.question_check.size();a++)
        {

            try
            {
                if(!database.question_check.get(a).equals(""))
                {
                    have_check=true;
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



        if(have_check)
        {
            startActivity(new Intent(getApplicationContext(),check_list_ac.class));
            Count1++;
            Count1=0;
        }
        else
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
    //On Click on Done Button End













    //Get Header Start
    public void get_header() throws Exception
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End












    //Get All Components Start
    public void refresh() throws Exception
    {
        check_list_array=database.question_check.get(Counter);
        check_list = (GridView) findViewById(R.id.check_list_check_list_ac);
        question_header = (TextView) findViewById(R.id.question_header_text_check_list_ac);


        //question_header.setText(database.question.get(check_list_ac.Counter+type_ac.Count+1));
        question_header.setText(database.question.get(check_list_ac.Counter));
        //IS Chenged


        check_list.setAdapter(new check_list_adaptor());
        get_header();
        Counter++;

    }
    //Get All Components End














    //On Back Pressed Event Start
    @Override
    public void onBackPressed()
    {
        Counter--;
        Count1--;
        Count2=0;
        super.onBackPressed();
    }
    //On Back Pressed Event End


















    //GridView Adaptor Start
    class check_list_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return check_list_array.size();
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {

            view=getLayoutInflater().inflate(R.layout.check_list_ly,null);

            try
            {
                final CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_box_check_list_ly);

                checkBox.setText(check_list_array.get(i));

                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkBox.isSelected() || checkBox.isChecked())
                        {
                            check_values.add(checkBox.getText().toString());
                        }
                        else
                        {
                            check_values.remove(checkBox.getText().toString());
                        }
                    }
                });
            }
            catch (Exception Err)
            {

            }

            return view;
        }
    }
    //GridView Adaptor End








}
