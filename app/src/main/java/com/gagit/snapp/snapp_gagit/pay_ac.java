package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;



public class pay_ac extends AppCompatActivity
{



    //Vars Start

    int []money={10000,20000,30000,40000,50000};
    ListView listView;
    TextView header_text_view;
    public static long pay_money=0;
    EditText edittext_how_money;
    Button btn;
    RelativeLayout relativeLayout;
    Button Pay_Button;
    EditText Pay_Value;
    //Vars End







    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pay_ac);
            refresh();
            get_header();
        }
        catch (Exception Err)
        {

        }

    }
















    //On Click On Get DEfault Values Start
    public void onclick_value_button_sharj_card_ac(View v)
    {

        try
        {
            switch (v.getId())
            {
                case R.id.button_value_100_sharj_ac:
                    Pay_Value.setText("100000");
                    break;
                case R.id.button_value_50_sharj_ac:
                    Pay_Value.setText("50000");
                    break;
                case R.id.button_value_20_sharj_ac:
                    Pay_Value.setText("20000");
                    break;
            }
        }
        catch (Exception Err)
        {

        }

    }
    //On Click On Get DEfault Values End



















    //On Click Pay Button Start
    public void onclick_pay_button_pay_ac(View v)
    {
        pay_money=Integer.parseInt(Pay_Value.getText().toString().trim());

        try
        {

            if(btn.getText().toString().trim().equals("دستی"))
            {
                pay_money=pay_money;
            }
            else
            {
                pay_money=Integer.parseInt(edittext_how_money.getText().toString().trim());
            }

            startActivity(new Intent(getApplicationContext(),pay_web_view_ac.class));


        }
        catch (Exception Err)
        {
            Toast.makeText(this, Err.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    //On Click Pay Button End















    //On Click Chanhge Button Type Start
    public void onclick_change_button_pay_ac(View v)
    {

        try
        {

            if (btn.getText().toString().trim().equals("دستی"))
            {
                listView.setVisibility(View.GONE);
                header_text_view.setVisibility(View.GONE);
                edittext_how_money.setText("");
                edittext_how_money.setVisibility(View.VISIBLE);
                btn.setText("پیش فرض");
            }
            else
            {
                listView.setVisibility(View.VISIBLE);
                header_text_view.setVisibility(View.VISIBLE);
                edittext_how_money.setVisibility(View.GONE);
                btn.setText("دستی");
            }

        }
        catch (Exception Err)
        {

        }

    }
    //On Click Chanhge Button Type End















    //All Components Start
    public void refresh()
    {

        try
        {

            listView = (ListView) findViewById(R.id.list_view_pay_ac);
            header_text_view = (TextView) findViewById(R.id.text_view_header_pay_ac);
            edittext_how_money = (EditText) findViewById(R.id.edit_text_money_pay_ac);
            btn = (Button) findViewById(R.id.btn_change_pay_ac);
            relativeLayout = (RelativeLayout) findViewById(R.id.main_panle_pay_ac);
            Pay_Button = (Button) findViewById(R.id.pay_button_pay_ac);
            Pay_Value = (EditText) findViewById(R.id.value_edittext_sharj_ac);


            Pay_Value.addTextChangedListener(new TextWatcher()
            {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                {

                    if (Pay_Value.getText().toString().trim().equals(""))
                    {
                        Pay_Button.setEnabled(false);
                    }
                    else
                    {
                        Pay_Button.setEnabled(true);
                    }

                }

                @Override
                public void afterTextChanged(Editable editable)
                {

                }

            });


            header_text_view.setText("تومان" + "\t" + "0");
            listView.setAdapter(new adaptor());
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    pay_money = money[i];

                    header_text_view.setText("تومان" + "\t" + money[i]);

                }
            });
            listView.setDivider(null);
            listView.setDividerHeight(0);


        }
        catch (Exception Err)
        {

        }


    }
    //All Components End





















    class adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return money.length;
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
            view=getLayoutInflater().inflate(R.layout.list_view_row_layout,null);

            try
            {

                TextView textView = (TextView) view.findViewById(R.id.text_view_money_list_view_row_layout);

                textView.setText(money[i] + "");

            }
            catch (Exception Err)
            {

            }

            return view;
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





}
