package com.gagit.snapp.snapp_gagit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmadrosid.svgloader.SvgLoader;
import com.caverock.androidsvg.SVG;
import com.devsmart.android.Utils;
import com.pixplicity.sharp.Sharp;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import org.apache.http.client.HttpClient;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;


public class n_price_frag extends Fragment
{


    //Vars Start
    Button Help_button;
    public static int item_clicked_n_price;
    public static int intent_count=0;
    public static SwipeRefreshLayout swipeRefreshLayout;
    public static GridView list;
    public static RelativeLayout frag2,search_result;
    public static EditText search_edit_text;
    public static boolean get_search=false;
    //Vars End






    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view= inflater.inflate(R.layout.fragment_n_price_frag, container, false);

        try
        {

            list = (GridView) view.findViewById(R.id.new_price_frag_grid_view);

            frag2 = (RelativeLayout) view.findViewById(R.id.frag_2_select_cat);

            list.setAdapter(new list_adaptor());

            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.new_price_refresher_swipe);

            search_edit_text = (EditText) view.findViewById(R.id.search_edittext_n_price_frag);

            search_result = (RelativeLayout) view.findViewById(R.id.search_result_frag_ly);

            event();

            get_header(view);

        }
        catch (Exception Err)
        {

        }

        return view;
    }

















    //Get Header Start
    public void get_header(View v)
    {

        try
        {

            //Header Image Start
            ImageView imageView = (ImageView) v.findViewById(R.id.image_view2_header_m_ac);
            Picasso.get().load(Uri.parse(database.Header_URL)).into(imageView);
            //Header Image End


            //Header City Start
            TextView city = (TextView) v.findViewById(R.id.city_text_view_header_m_ac2);
            city.setText(user_class.city);
            //Header City End


            //Header Money Start
            TextView money = (TextView) v.findViewById(R.id.money_text_view_header_m_ac2);

            String moneystr = "";
            char[] chars = user_class.money.toCharArray();
            for (int a = 0; a < chars.length; a++)
            {
                if (a % 3 == 0 && a > 1)
                {
                    moneystr += chars[a] + ",";
                }
                else
                {
                    moneystr += chars[a];
                }
            }

            money.setText(user_class.money + " " + getString(R.string.toman));
            //Header Money End

        }
        catch (Exception Err)
        {

        }


    }
    //Get Header End




















    //All Events In Fragment Start
    public void event()
    {

        try {

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    list.removeAllViewsInLayout();

                    list.setAdapter(new list_adaptor());

                    swipeRefreshLayout.setRefreshing(false);

                }
            });


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    selected_cat_flag.id = i + "";

                    database.get_sub_items(i);

                    database.get_sub_items3(0);

                    selected_cat_flag.gridView.setAdapter(new grid_adaptor());

                    m_ac.Start_a_N_Price = true;

                    startActivity(new Intent(getContext(), sub3_and_done_ac.class));


//                intent_count=1;

//                swipeRefreshLayout.setVisibility(View.GONE);
//
//                frag2.setVisibility(View.VISIBLE);

                    item_clicked_n_price = i;

                }
            });


            search_edit_text.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (search_edit_text.getText().toString().equals("")) {
                        swipeRefreshLayout.setVisibility(View.VISIBLE);
                        search_result.setVisibility(View.GONE);
                    }
                    return false;
                }
            });


            search_edit_text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    try {
                        if (search_edit_text.getText().toString().trim().equals("")) {
                            swipeRefreshLayout.setVisibility(View.VISIBLE);
                            search_result.setVisibility(View.GONE);
                            get_search = false;
                            return;
                        } else {
                            swipeRefreshLayout.setVisibility(View.GONE);
                            search_result.setVisibility(View.VISIBLE);
                            database.search_result_items.clear();
                            database.search_result_items_icons.clear();
                            database.search(search_edit_text.getText().toString());
                            search_result_frag.search_result.setAdapter(new search_result());
                            if (database.search_result_items.size() == 0) {
                                Toast.makeText(getContext(), R.string.not_found, Toast.LENGTH_SHORT).show();
                                swipeRefreshLayout.setVisibility(View.VISIBLE);
                                search_result.setVisibility(View.GONE);
                                get_search = false;
                                return;
                            }
                            get_search = true;
                        }

                    } catch (Exception Err) {

                    }


                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });


            search_edit_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    try {
                        Toast.makeText(getContext(), R.string.wite, Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setVisibility(View.GONE);
                        search_result.setVisibility(View.VISIBLE);
                        database.search_result_items.clear();
                        database.search_result_items_icons.clear();
                        database.search(search_edit_text.getText().toString());
                        search_result_frag.search_result.setAdapter(new search_result());
                        if (database.search_result_items.size() == 0) {
                            Toast.makeText(getContext(), R.string.not_found, Toast.LENGTH_SHORT).show();
                            swipeRefreshLayout.setVisibility(View.VISIBLE);
                            search_result.setVisibility(View.GONE);
                            get_search = false;
                            return false;
                        }
                        get_search = true;
                    } catch (Exception Err) {

                    }
                    return false;
                }
            });


            search_result_frag.swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    search_result_frag.search_result.setAdapter(new search_result());
                    search_result_frag.swipe_refresh.setRefreshing(false);
                }
            });


            search_result_frag.search_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    report_ac.item1 = database.search_result_three_item1.get(i);

                    report_ac.item2 = database.search_result_three_item2.get(i);

                    report_ac.item3 = database.search_result_three_item3.get(i);

                    report_ac.picture = database.search_result_icon.get(i);

                    database.get_questions(database.search_result_questions.get(i));

                    database.SID = database.search_result_sid.get(i);

                    type_ac.Counter = 0;

                    try {
                        if (!database.question_radio.equals("")) {
                            startActivity(new Intent(getContext(), type_ac.class));
                        }
                    } catch (Exception Errs) {
                        try {
                            if (!database.question_check.get(0).equals("")) {
                                startActivity(new Intent(getContext(), check_list_ac.class));
                            }
                        } catch (Exception Err) {
                            try {
                                if (!database.question_number.get(0).equals("")) {
                                    startActivity(new Intent(getContext(), numbers_ac.class));
                                }
                            } catch (Exception Err2) {
                                startActivity(new Intent(getContext(), clock_price_ac.class));
                            }
                        }
                    }


                }
            });


        }
        catch (Exception Err)
        {

        }

    }
    //All Events In Fragment End


























    //Fragment Adaptor Start
    class list_adaptor extends BaseAdapter
    {


        @Override
        public int getCount()
        {
            return database.items.size();
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
            view=getLayoutInflater().inflate(R.layout.two_colnum_grid_view,null);


            try
            {

                ImageView imageView = (ImageView) view.findViewById(R.id.image_itom_new_price_frag);

                TextView textView = (TextView) view.findViewById(R.id.text_itom_new_price_frag);

//            com.gagit.snapp.snapp_gagit.Utils.fetchSvg(getContext(),database.items_icons.get(i),imageView);

//            imageView.setImageResource(images[i]);

//            Picasso.get().load(database.items_icons.get(i)).into(imageView);


                SvgLoader.pluck().with(getActivity()).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.items_icons.get(i), imageView);


                textView.setText(database.items.get(i));

            }
            catch (Exception Err)
            {

            }

            return view;

        }


    }
    //Fragment Adaptor End




















    //Selected Cat Grid View Start
    class grid_adaptor extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.items_sub_item3.size();
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

            view=getLayoutInflater().inflate(R.layout.one_colnum_grid_view,null);

            try
            {

                ImageView imageView = (ImageView) view.findViewById(R.id.list_Image_view);

                TextView textView = (TextView) view.findViewById(R.id.list_textview_1);


//            Down is It s True
//            com.gagit.snapp.snapp_gagit.Utils.fetchSvg(getContext(),database.items_sub_item_icons.get(i),imageView);

//            Picasso.get().load(database.items_sub_item_icons.get(i)).into(imageView);

                SvgLoader.pluck().with(getActivity()).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.items_sub_item_icons3.get(i), imageView);

                textView.setText(database.items_sub_item3.get(i));
            }
            catch (Exception Err)
            {

            }

            return view;
        }
    }
    //Selected Cat Grid View End
















    //Search_adaptor Start
    class search_result extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return database.search_result_items.size();
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
            view=getLayoutInflater().inflate(R.layout.one_colnum_grid_view,null);

            try
            {

                TextView textView = (TextView) view.findViewById(R.id.list_textview_1);

                ImageView imageView = (ImageView) view.findViewById(R.id.list_Image_view);

                textView.setText(database.search_result_items.get(i));

                SvgLoader.pluck().with(getActivity()).setPlaceHolder(R.drawable.wite, R.drawable.wite).load(database.search_result_items_icons.get(i), imageView);
            }
            catch (Exception Err)
            {

            }

            return view;
        }
    }
    //Search_adaptor End












}