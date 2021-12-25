package com.gagit.snapp.snapp_gagit;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class user_class
{

    public static String uid="";
    public static String city="";
    public static String mobile="";
    public static String money="0";
    public static String fname="";
    public static String lname="";
    public static String national_code="";
    public static String picture="";
    public static String datecreate="";





    public user_class(String json)
    {

        try
        {


            Log.i("Err",json);

            byte []codes=json.getBytes("ISO-8859-1");

            String result=new String(codes,"UTF-8");

            JsonParser jsonParser = new JsonParser();

            Object object = jsonParser.parse(result);

            JsonObject object1 = (JsonObject) object;

            uid = "";
            city = "";
            mobile = "";
            money = "";
            fname = "";
            lname = "";
            national_code = "";
            picture = "";
            datecreate = "";


            uid = json_clear(object1.get("uid") + "");
            city = json_clear(object1.get("city") + "");
            mobile = json_clear(object1.get("mobile") + "");
            money = json_clear(object1.get("money") + "");
            fname = json_clear(object1.get("fname") + "");
            lname = json_clear(object1.get("lname") + "");
            national_code = json_clear(object1.get("national_code") + "");
            picture = json_clear(object1.get("picture") + "");
            datecreate = json_clear(object1.get("datecreate") + "");

        }
        catch (Exception Err)
        {

        }

    }





    public static String json_clear(String string)
    {
        char []s=string.toCharArray();

        s[0]=' ';
        s[s.length-1]=' ';

        return new String(s);

    }




}