package com.gagit.snapp.snapp_gagit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.Picasso;

public class Visit_List_Item_ac extends AppCompatActivity
{


    //Vars Start
    public static String Phone_num="";
    RelativeLayout wite_ly,main_context,not_avable_ly;
    Boolean is_show=false;
    GridView gridView_context;
    TextView title_view,time_view;
    //Vars End







    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_visit__list__item_ac);
            refresh();
            get_header();
        }
        catch (Exception Err)
        {

        }

    }








    //On Click Call Button Start
    public void onclick_call_btn_visit_list_item_ac(View v)
    {
        if(!Phone_num.trim().equals(""))
        {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + Phone_num));
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, R.string.not_service, Toast.LENGTH_SHORT).show();
        }
    }
    //On Click Call Button End








    //On Click Cancel Button Start
    public void onclick_cancel_button_Visit_list_item_ac(View v)
    {

    }
    //On Click Cancel Button End








    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End









    //Get All Components Start
    @SuppressLint("ResourceAsColor")
    public void refresh()
    {


        try {

            wite_ly = (RelativeLayout) findViewById(R.id.plase_wite_for_fill_fieldes_visit_list_item_ac);
            main_context = (RelativeLayout) findViewById(R.id.main_context_visit_list_item_ac);
            not_avable_ly = (RelativeLayout) findViewById(R.id.not_avable_ly_visit_item_ac);
            gridView_context = (GridView) findViewById(R.id.context_grid_view_visit_ac);


            title_view = (TextView) findViewById(R.id.title_visit_list_ac);
            time_view = (TextView) findViewById(R.id.time_visit_list_ac);


            Button btn_cancel = findViewById(R.id.cancel_btn_visit_ac);


            if (Build.VERSION.SDK_INT > 21)
            {
                btn_cancel.setBackgroundResource(R.drawable.ripple_color);
                btn_cancel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cancel_stop_color_icon, 0, 0, 0);
            }
            else
            {
                btn_cancel.setTextColor(0xFFFFFFFF);
                btn_cancel.setBackgroundColor(0xFFF50057);
            }


            refresh_timer();


        }
        catch (Exception Err)
        {

        }


    }
    //Get All Components End










    //Refresh Timer Start
    public void refresh_timer()
    {

        try
        {
            CountDownTimer timer = new CountDownTimer(60000, 10) {
                @Override
                public void onTick(long l) {

                    try {
                        if (!is_show && !database.my_selected_proposal_id.equals("")) {

                            title_view.setText(database.my_selected_proposal_name);
                            time_view.setText(database.my_selected_proposal_geo);


                            gridView_context.setAdapter(new main_adaptor());


                            main_context.setVisibility(View.VISIBLE);
                            wite_ly.setVisibility(View.GONE);
                            is_show = true;
                        }
                    } catch (Exception Err) {

                    }

                }

                @Override
                public void onFinish() {

                    try {

                        if (!is_show) {
                            main_context.setVisibility(View.GONE);
                            wite_ly.setVisibility(View.GONE);
                            not_avable_ly.setVisibility(View.VISIBLE);
                            is_show = true;
                        }

                    }
                    catch (Exception Err)
                    {

                    }

                }
            }.start();
        }
        catch (Exception Err)
        {

        }

    }
    //Refresh Timer End










    class main_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.my_all_proposals_actors_name.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            view=getLayoutInflater().inflate(R.layout.one_colnum_props_grid_ly,null);


            try {

                TextView title, time, coin, point, comment_counter;
                Button cell_btn, selectd_btn;
                ImageView imageView;
                ProgressBar Proess;


                imageView = (ImageView) view.findViewById(R.id.image_view_prop_grid_ly);
                title = (TextView) view.findViewById(R.id.title_view_prop_grid_ly);
                time = (TextView) view.findViewById(R.id.time_view_prop_grid_ly);
                coin = (TextView) view.findViewById(R.id.money_view_prop_grid_ly);
                point = (TextView) view.findViewById(R.id.point_view_prop_grid_ly);
                comment_counter = (TextView) view.findViewById(R.id.command_counter_view_prop_grid_ly);
                cell_btn = (Button) view.findViewById(R.id.cell_btn_view_prop_grid_ly);
                selectd_btn = (Button) view.findViewById(R.id.select_btn_view_prop_grid_ly);
                Proess = (ProgressBar) view.findViewById(R.id.process_view_prop_grid_ly);


                try {
                    title.setText(database.my_all_proposals_actors_name.get(i));
                    time.setText(database.my_all_proposals_actors_time.get(i));
                    coin.setText(database.my_all_proposals_actors_price.get(i));
                    point.setText("امتیاز شما : " + database.my_all_proposals_actors_score.get(i));
                    comment_counter.setText(database.my_all_proposals_actors_count_comment.get(i));
                    Proess.setProgress(Integer.parseInt(database.my_all_proposals_actors_score.get(i)));
                    Picasso.get().load(database.my_all_proposals_actors_picture.get(i)).into(imageView);
                } catch (Exception Err) {

                }


                final int t = i;

                cell_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + database.my_all_proposals_actors_mobile.get(t)));
                        startActivity(intent);
                    }
                });


            }
            catch (Exception Err)
            {

            }


            return view;
        }
    }









    @Override
    public void onBackPressed()
    {

        try
        {
            database.my_selected_proposal_id="";
            database.my_selected_proposal_name="";
            database.my_selected_proposal_picture="";
            database.my_selected_proposal_active="";
            database.my_selected_proposal_text="";
            database.my_selected_proposal_geo="";
            database.my_all_proposals_actors_name.clear();
            database.my_all_proposals_actors_picture.clear();
            database.my_all_proposals_actors_mobile.clear();
            database.my_all_proposals_actors_count_work.clear();
            database.my_all_proposals_actors_score.clear();
            database.my_all_proposals_actors_count_comment.clear();
            database.my_all_proposals_actors_time.clear();
            database.my_all_proposals_actors_is_special.clear();
            database.my_all_proposals_actors_is_selected.clear();
        }
        catch (Exception Err)
        {

        }

        super.onBackPressed();
    }







}
