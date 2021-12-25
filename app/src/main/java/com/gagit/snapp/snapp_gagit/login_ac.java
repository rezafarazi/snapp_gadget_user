package com.gagit.snapp.snapp_gagit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class login_ac extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener
{



    //Var s
    private static final int RC_SIGN_IN = 007;
    private static final String TAG = Sign_ac.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    SignInButton btn_google_sign;
    EditText User_name_Edit_text,Password_Edit_text;
    //Var s




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ac);
        refresh_for_google();
        refresh();
    }








    //On Back Button Click Start//
    @Override
    public void onBackPressed()
    {
        Intent exit=new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        startActivity(exit);
    }
    //On Back Button Click End//







    //On Click Sign In Btn Start
    public void onclick_sign_in_btn_log_in_ac(View v)
    {
        startActivity(new Intent(getApplicationContext(),Sign_ac.class));
        overridePendingTransition(R.anim.activity_anim,R.anim.activity_anim);
    }
    //On Click Sign In Btn End








    //On Click By Mobile Btn Start
    public void onclick_log_in_ac_by_mobile(View v)
    {
        startActivity(new Intent(getApplicationContext(),Sms_Panle_sign.class));
    }
    //On Click By Mobile Btn End









    //On Click Log In Button Start
    public void onclick_Log_in_ac_btn(View v)
    {
        if(check())
        {

        }
        else
        {
            Toast.makeText(this, R.string.Check_fildes, Toast.LENGTH_SHORT).show();
        }
    }
    //On Click Log In Button End








    //Check Not Null Fildes Start
    public boolean check()
    {
        if(!User_name_Edit_text.getText().toString().trim().equals("")&&!Password_Edit_text.getText().toString().trim().equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Check Not Null Fildes End










    //Google
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult)
    {

    }




    public void signIn()
    {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN)
        {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }




    private void handleSignInResult(GoogleSignInResult result)
    {

        if (result.isSuccess())
        {

            GoogleSignInAccount acct = result.getSignInAccount();


            String personName = acct.getDisplayName();
            String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

//            User_name.setText(personName);
//
//            Email.setText(email);

            updateUI(true);
        }
        else
        {
            updateUI(false);
        }
    }




    public void updateUI(boolean v)
    {

    }



    public void refresh_for_google()
    {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        btn_google_sign=(SignInButton)findViewById(R.id.google_sign_in_log_in_ac);
        btn_google_sign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                signIn();
            }
        });
    }

    //Google













    public void refresh()
    {
        User_name_Edit_text=(EditText)findViewById(R.id.frist_input_layout_log_in_ac);
        Password_Edit_text=(EditText)findViewById(R.id.sec_input_layout_log_in_ac);
    }





}
