package com.gagit.snapp.snapp_gagit;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class address_ac extends AppCompatActivity implements OnMapReadyCallback
{




    //Vars
    private GoogleMap mMap;
    public double x = 35.6961111111, y = 51.4230555556;
    //Vars


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_address_ac);
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_address);
            mapFragment.getMapAsync(this);
            address();
            get_header();
        }
        catch (Exception Err)
        {

        }

    }



    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Dexter.withActivity(address_ac.this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener()
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


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x, y), 10.0f));
    }












    //Clear Address Function Start
    public void address() throws Exception
    {
        SharedPreferences.Editor shEditor=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE).edit();
        shEditor.putString("address","");
        shEditor.apply();
    }
    public void address(String address) throws Exception
    {
        SharedPreferences.Editor shEditor=getSharedPreferences("Snapp_gagit_profile",MODE_PRIVATE).edit();
        shEditor.putString("address",address);
        shEditor.apply();
    }
    //Clear Address Function End













    //on Click Doen Button Start
    public void onclick_done_btn_address_ac(View v) throws Exception
    {
        CameraPosition composition = mMap.getCameraPosition();
        x = composition.target.longitude;
        y = composition.target.latitude;
        if(check_location(x,y))
        {
            address(x + "-" + y + "-");
            Toast.makeText(this, R.string.You_address_saved, Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        else
        {
            Toast.makeText(this, R.string.Snapp_gadget_not_suported, Toast.LENGTH_SHORT).show();
        }
    }
    //on Click Doen Button End













    //Get Header Start
    public void get_header() throws Exception
    {
        ImageView appview_header_image=(ImageView)findViewById(R.id.image_view_header_m_ac);
        Picasso.get().load(database.Header_URL).into(appview_header_image);
//        Picasso.with(getApplicationContext()).load(database.Header_URL).into(appview_header_image);
    }
    //Get Header End














    //Get Location Check Start
    public static boolean check_location(double x,double y) throws Exception
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











}
