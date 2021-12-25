package com.gagit.snapp.snapp_gagit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.util.EncodingUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sign_ac extends AppCompatActivity
{


    //Var s
    private static final int RC_SIGN_IN = 007;
    private static final String TAG = Sign_ac.class.getSimpleName();
    EditText Frist_name,Last_name,City;
    WebView webView;
    //Var s








    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_ac);
        refresh();
    }

























    public boolean check_not_null_elements()
    {
        if((!Frist_name.getText().toString().trim().equals(""))&&(!Last_name.getText().toString().trim().equals(""))&&(!City.getText().toString().trim().equals("")))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



















    public void onclick_log_btn_sign_ac(View v)
    {
        startActivity(new Intent(getApplicationContext(),login_ac.class));
    }



















    public void refresh()
    {
        Frist_name=(EditText)findViewById(R.id.frist_name_sign_ac);
        Last_name=(EditText)findViewById(R.id.last_name_sign_ac);
        City=(EditText)findViewById(R.id.city_name_sign_ac);
        webView=(WebView)findViewById(R.id.webview_sign_ac);

        webView.setWebViewClient(new WebViewClient()
                                 {
                                     public void onPageFinished(WebView view, String url) {


                                     }


                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                         if (url.startsWith("tel:")) {
                                             Intent intent = new Intent(Intent.ACTION_DIAL,
                                                     Uri.parse(url));
                                             startActivity(intent);
                                         } else if (url.startsWith("http:") || url.startsWith("https:")) {
                                             view.loadUrl(url);
                                         }
                                         return true;

                                     }


                                     @Override
                                     public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                                         Intent Err = new Intent(Sign_ac.this, no_internet_ac.class);

                                         startActivity(Err);

                                     }


                                 }
        );









        webView.setWebChromeClient(new WebChromeClient() {










            public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> filePath, WebChromeClient.FileChooserParams fileChooserParams) {
                // Double check that we don't have any existing callbacks
                if (mFilePathCallback != null) {
                    mFilePathCallback.onReceiveValue(null);
                }
                mFilePathCallback = filePath;
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                        takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath);
                    } catch (IOException ex) {
                        // Error occurred while creating the File
                        Log.e(TAG, "Unable to create Image File", ex);
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        mCameraPhotoPath = "file:" + photoFile.getAbsolutePath();
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(photoFile));
                    } else {
                        takePictureIntent = null;
                    }
                }
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("image/*");
                Intent[] intentArray;
                if (takePictureIntent != null) {
                    intentArray = new Intent[]{takePictureIntent};
                } else {
                    intentArray = new Intent[0];
                }
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE);
                return true;
            }








            private File createImageFile() throws IOException {
                // Create an image file name
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStamp + "_";
                File storageDir = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES);
                File imageFile = File.createTempFile(
                        imageFileName,  /* prefix */
                        ".jpg",         /* suffix */
                        storageDir      /* directory */
                );
                return imageFile;
            }














        });









        webView.getSettings().setJavaScriptEnabled(true);

        security security=new security();


        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webView.getSettings().setAllowFileAccess(true);


        byte[] post = EncodingUtils.getBytes("security=" + security.code() + "&uid=" + user_class.uid, "UTF-8");
        webView.postUrl(database.API_URL+"user_c/to_server/profile.php", post);



        Frist_name.setText(user_class.fname.trim());
        Last_name.setText(user_class.lname.trim());
        City.setText(user_class.city.trim());



    }














    //Check To Connected To InterNet Start//
    public boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    //Check To Connected To InterNet Start//






























    //Chosee FIle Web View
    private static final int INPUT_FILE_REQUEST_CODE = 1;
    private ValueCallback<Uri> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE = 1;
    private ValueCallback<Uri[]> mFilePathCallback;
    private Uri mCapturedImageURI = null;
    private String mCameraPhotoPath;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
                super.onActivityResult(requestCode, resultCode, data);
                return;
            }
            Uri[] results = null;
            // Check that the response is a good one
            if (resultCode == Activity.RESULT_OK) {
                if (data == null) {
                    // If there is not data, then we may have taken a photo
                    if (mCameraPhotoPath != null) {
                        results = new Uri[]{Uri.parse(mCameraPhotoPath)};
                    }
                } else {
                    String dataString = data.getDataString();
                    if (dataString != null) {
                        results = new Uri[]{Uri.parse(dataString)};
                    }
                }
            }
            mFilePathCallback.onReceiveValue(results);
            mFilePathCallback = null;
        } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            if (requestCode != FILECHOOSER_RESULTCODE || mUploadMessage == null) {
                super.onActivityResult(requestCode, resultCode, data);
                return;
            }
            if (requestCode == FILECHOOSER_RESULTCODE) {
                if (null == this.mUploadMessage) {
                    return;
                }
                Uri result = null;
                try {
                    if (resultCode != RESULT_OK) {
                        result = null;
                    } else {
                        // retrieve from the private variable if the intent is null
                        result = data == null ? mCapturedImageURI : data.getData();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "activity :" + e,
                            Toast.LENGTH_LONG).show();
                }
                mUploadMessage.onReceiveValue(result);
                mUploadMessage = null;
            }
        }
        return;
    }
    //Chosee FIle Web View


















}