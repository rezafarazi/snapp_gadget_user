package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class Share_Factor_ac extends AppCompatActivity
{




    //Vars
    ImageView imageView;
    //Vars



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share__factor_ac);
        imageView=(ImageView)findViewById(R.id.image_view_factor_dialog);
//        imageView.setImageResource(factors_ac.images[factors_ac.factor_id]);
    }













    //On Click SHare Icon Event Start
    public void on_click_share_factor(View v)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        Uri uri=Uri.parse("http://www.liberaldictionary.com/wp-content/uploads/2018/11/test-1.png");
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM,uri);
        startActivity(intent);
    }
    //On Click SHare Icon Event End




}
