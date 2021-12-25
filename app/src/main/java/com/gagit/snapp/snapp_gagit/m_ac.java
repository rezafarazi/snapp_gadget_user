package com.gagit.snapp.snapp_gagit;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;





public class m_ac extends AppCompatActivity
{



    // Vars Start
        BottomNavigationView menu;
        RelativeLayout menu1,menu2,menu3;
        public static ImageView appview_header_image;
        public static Boolean Start_a_N_Price=false;
    // Vars End




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_m_ac);
            refresh();
            events();
            help();
        }
        catch (Exception Err)
        {

        }

    }

























    //On Back Button Press Event Start
    @Override
    public void onBackPressed()
    {

        if(n_price_frag.get_search)
        {
            n_price_frag.swipeRefreshLayout.setVisibility(View.VISIBLE);
            n_price_frag.search_result.setVisibility(View.GONE);
            n_price_frag.search_edit_text.setText("");
            n_price_frag.get_search=false;
            return;
        }

        if(n_price_frag.intent_count==0)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);

            intent.addCategory(Intent.CATEGORY_HOME);

            startActivity(intent);

            overridePendingTransition(R.anim.activity_anim, R.anim.activity_anim);
        }
        else if(n_price_frag.intent_count==1)
        {
            n_price_frag.swipeRefreshLayout.setVisibility(View.VISIBLE);
            n_price_frag.frag2.setVisibility(View.GONE);
            n_price_frag.intent_count=0;
        }
    }
    //On Back Button Press Event End















    int a=0;
    //All Events In Activity Start
    public void events() throws Exception
    {

        try {

            menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {

                    try
                    {
                        hide_all();
                        switch (item.getItemId())
                        {
                            case R.id.new_price_btn_bottm_menu_m_ac_ic_m:
                                menu1.setVisibility(View.VISIBLE);
                                break;
                            case R.id.my_list_btn_bottm_menu_m_ac_ic_m:
                                menu2.setVisibility(View.VISIBLE);
                                break;
                            case R.id.profile_btn_bottm_menu_m_ac_ic_m:
                                menu3.setVisibility(View.VISIBLE);
                                break;
                        }

                    }
                    catch (Exception Err)
                    {
                        Log.i("Err66",Err.getMessage());
                    }
                    return true;
                }
            });
        }
        catch (Exception Err)
        {
            Log.i("Err66",Err.getMessage());
        }













    }
    //All Events In Activity End


















    //Hide All Panles Start
    public void hide_all() throws Exception
    {
        menu1.setVisibility(View.GONE);
        menu2.setVisibility(View.GONE);
        menu3.setVisibility(View.GONE);
    }
    //Hide All Panles End














    ///On Click Factors Button Start
    public void onclick_factors_btn(View v)
    {
        startActivity(new Intent(getApplicationContext(),factors_ac.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    ///On Click Factors Button End





















    //On Click Exit Button Start
    public void onclick_exit_button(View v)
    {
        onBackPressed();
    }
    //On Click Exit Button End






















    //On Click Edit Profile Icon Strat
    public void onclick_edit_profile_profile_frag(View v)
    {
        startActivity(new Intent(getApplicationContext(),Sign_ac.class));
    }
    //On Click Edit Profile Icon End





















    //On Click Exit From Account Start
    public void on_click_exit_account(View v)
    {
        SharedPreferences.Editor shEditor=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE).edit();
        shEditor.putString("phone","");
        startActivity(new Intent(getApplicationContext(),Sms_Panle_sign.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //On Click Exit From Account End

















    //On Click SHow Web Site Start
    public void onclick_show_web_site(View v)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http:\\www.snapp-gadget.ir"));
        startActivity(intent);
    }
    //On Click SHow Web Site End















    //On Click Show Commands Activity Start
    public void onclick_show_command_activity(View v)
    {
        startActivity(new Intent(getApplicationContext(),command_ac.class));
    }
    //On Click Show Commands Activity End















    //On Click Share Application Start
    public void onclick_share_app_btn(View v)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT,database.Site_Share_Text);

        startActivity(intent);

    }
    //On Click Share Application End




















    //On Click Set New Address Start
    public void onclick_show_new_address_ac(View v)
    {
        if(_do_getaddress())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(m_ac.this);
            builder.setTitle(R.string.alert);
            builder.setMessage(R.string.do_you_are_clear);
            builder.setPositiveButton(R.string.no, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    startActivity(new Intent(getApplicationContext(), address_ac.class));
                }

            });


            builder.setNeutralButton(R.string.yes, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {

                }

            });

            builder.show();
        }
        else
        {
            startActivity(new Intent(getApplicationContext(), address_ac.class));
        }



    }
    //On Click Set New Address End















    // If I Have Address Function Start
    public boolean _do_getaddress()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE);
        String address=sharedPreferences.getString("address","");

        if(!address.equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }


    }
    // If I Have Address Function End





















    //Get To Law To Web Site Start
    public void onclick_start_get_law(View v)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http:\\www.snapp-gadget.ir\\law"));
        startActivity(intent);
    }
    //Get To Law To Web Site End




















    //On Click Help Button Start
    public static int fris_log=0;
    public void onclick_help_button_n_price_header(View v)
    {
        try
        {
            fris_log = 1;
            help();
        }
        catch (Exception Err)
        {

        }
    }




    public void help() throws Exception
    {
        try
        {
            if (fris_log == 1)
            {

                new MaterialTapTargetPrompt.Builder(m_ac.this)
                        .setTarget(findViewById(R.id.profile_btn_bottm_menu_m_ac_ic_m))
                        .setPrimaryText(R.string.My_profile)
                        .setSecondaryText(R.string.Show_profile)
                        .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                            @Override
                            public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED) {


                                    new MaterialTapTargetPrompt.Builder(m_ac.this)
                                            .setTarget(findViewById(R.id.my_list_btn_bottm_menu_m_ac_ic_m))
                                            .setPrimaryText(R.string.My_List)
                                            .setSecondaryText(R.string.Show_list_help)
                                            .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                @Override
                                                public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED) {


                                                        new MaterialTapTargetPrompt.Builder(m_ac.this)
                                                                .setTarget(findViewById(R.id.new_price_btn_bottm_menu_m_ac_ic_m))
                                                                .setPrimaryText(R.string.new_price)
                                                                .setSecondaryText(R.string.New_price_help)
                                                                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                    @Override
                                                                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED) {


                                                                        }
                                                                    }
                                                                })
                                                                .show();


                                                    }
                                                }
                                            })
                                            .show();


                                }
                            }
                        })
                        .show();

                fris_log = 0;
            }
        }
        catch (Exception Err)
        {

        }

    }
    //On Click Help Button End
























    //On Click On Pay Strat
    public void onclick_pay_btn(View v)
    {
        startActivity(new Intent(getApplicationContext(),pay_ac.class));
    }
    //On Click On Pay End


























    //On Click City Icon Start
    public void onclick_city_icon_n_price_frag(View v)
    {
        startActivity(new Intent(getApplicationContext(),Sign_ac.class));
    }
    //On Click City Icon End


























    //Refresh Page Start
    public void refresh() throws Exception
    {
        menu=(BottomNavigationView)findViewById(R.id.bottom_menu_m_ac);
        menu1=(RelativeLayout)findViewById(R.id.frag_1_new_price_m_ac);
        menu2=(RelativeLayout)findViewById(R.id.panle_my_list_user);
        menu3=(RelativeLayout)findViewById(R.id.panle_prifile_user);



//        get_header();



        try
        {

            PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            if(version!=database.Site_APP_Version)
            {
                AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                alert.setMessage(R.string.update);
                alert.setNegativeButton(R.string.update_btn, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(database.Site_APP_Link)));
                    }
                });

                alert.setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                    }
                });


                alert.show();
            }


        }
        catch (Exception e)
        {

        }


    }
    //Refresh Page End














}
