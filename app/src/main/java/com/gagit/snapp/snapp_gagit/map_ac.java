package com.gagit.snapp.snapp_gagit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;


public class map_ac extends FragmentActivity implements OnMapReadyCallback{


    //Vars And Map And On Create Functions Start
    private GoogleMap mMap;
    public double x = 35.6961111111, y = 51.4230555556;
    public static double x1 = 35.6961111111, y1 = 51.4230555556;
    Button btn;
    boolean back=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_ac);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn=(Button)findViewById(R.id.done_or_default_in);
        get_header();

    }


    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Dexter.withActivity(map_ac.this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener()
            {

                @Override
                public void onPermissionGranted(PermissionGrantedResponse response)
                {

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
            mMap.setMyLocationEnabled(true);

        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x,y), 10.0f));

    }
    //Vars And Map And On Create Functions End











    //on Click Bottom Button in map Activity Start
    public void set_location_map_ac(View v)
    {

        CameraPosition composition = mMap.getCameraPosition();

        if(check_location(composition.target.longitude,composition.target.latitude))
        {

            if (btn.getText().toString().trim().equals("استفاده از آدرس پیشفرض"))
            {
                btn.setText(R.string.next_page);

                x1 = composition.target.longitude;
                y1 = composition.target.latitude;
                back = true;
            }
            else
            {
                startActivity(new Intent(getApplicationContext(), question_ac.class));
            }
        }
        else
        {
            Toast.makeText(this, R.string.Snapp_gadget_not_suported, Toast.LENGTH_SHORT).show();
        }
    }
    //on Click Bottom Button in map Activity Start
















    //Get Location Check Start
    public static boolean check_location(double x,double y)
    {
        double TEHRAN_TOP_START=34.898885495682485;
        double TEHRAN_TOP_END=36.36446056027659;
        double TEHRAN_LEFT_START=50.2435540035367;
        double TEHRAN_LEFT_END=53.24738435447215;


        if(x>TEHRAN_LEFT_START&&x<TEHRAN_LEFT_END)
        {
            if(y>TEHRAN_TOP_START&&y<TEHRAN_TOP_END)
            {
                return true;
            }
        }

        return false;
    }
    //Get Location Check End














    //On Click Bottom Button Start
    public void onclick_btn_report_ac(View v)
    {

        if(!btn.getText().toString().trim().equals("استفاده از آدرس پیشفرض"))
        {
            try
            {
                if(!database.question_text.equals(""))
                {
                    startActivity(new Intent(getApplicationContext(),question_ac.class));
                }
            }
            catch (Exception Err)
            {
                startActivity(new Intent(getApplicationContext(),detailes_ac.class));
            }

        }
        else
        {
            get_default_position();
        }
    }
    //On Click Bottom Button End












    //Get Default Address Start
    public void get_default_position()
    {

        SharedPreferences sharedPreferences=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE);
        String str=sharedPreferences.getString("address","");

        if(str.trim().equals(""))
        {
            Toast.makeText(this, R.string.not_have_default_address, Toast.LENGTH_SHORT).show();
        }
        else
        {
            try
            {
                String[] position = str.split("-");
                y = Double.parseDouble(position[0]);
                x = Double.parseDouble(position[1]);

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x, y), 15.0f));

                x1 = x;
                y1 = y;
                back=true;
                btn.setText(R.string.next_page);
            }
            catch (Exception Err)
            {
                Log.i("Err2",Err.getMessage());
            }
        }
    }
    //Get Default Address End

















    //On Back Press Start
    @Override
    public void onBackPressed()
    {
        if(!back)
        {
            super.onBackPressed();
        }
        else
        {
            btn.setText(R.string.use_default_address);
            back=false;
        }
    }
    //On Back Press End














    //Get Header Start
    public void get_header()
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End











}
