package com.gagit.snapp.snapp_gagit;


import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import java.util.ArrayList;



public class database
{


    //Vars Start
    public static String API_URL="http://www.snapp-gadget.ir/api/";
    public static String Sms_Key;
    public static String SHA;
    public static ArrayList<String> items=new ArrayList<>();
    public static ArrayList<String> items_icons=new ArrayList<>();
    public static ArrayList<String> items_sub=new ArrayList<>();
    public static ArrayList<String> items_sub_item=new ArrayList<>();
    public static ArrayList<String> items_sub_item_icons=new ArrayList<>();
    public static ArrayList<String> items_sub_item_sub=new ArrayList<>();
    public static ArrayList<String> items_sub_item3_sid=new ArrayList<>();
    public static ArrayList<String> items_sub_item3=new ArrayList<>();
    public static ArrayList<String> items_sub_item_icons3=new ArrayList<>();
    public static ArrayList<String> items_sub_item_sub3=new ArrayList<>();
    public static ArrayList<String> search_result_items=new ArrayList<>();
    public static ArrayList<String> search_result_items_icons=new ArrayList<>();
    public static ArrayList<String> search_result_three_item1=new ArrayList<>();
    public static ArrayList<String> search_result_three_item2=new ArrayList<>();
    public static ArrayList<String> search_result_three_item3=new ArrayList<>();
    public static ArrayList<String> search_result_icon=new ArrayList<>();
    public static ArrayList<String> search_result_questions=new ArrayList<>();
    public static ArrayList<String> search_result_sid=new ArrayList<>();
    public static String Site_APP_Version;
    public static String Site_APP_Link;
    public static String Site_Share_Text;
    public static ArrayList<String> question=new ArrayList<>();
    public static ArrayList<ArrayList<String>> question_radio=new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> question_check=new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> question_text=new ArrayList<>();
    public static ArrayList<ArrayList<String>> question_number=new ArrayList<ArrayList<String>>();
    public static ArrayList<ArrayList<String>> question_name=new ArrayList<ArrayList<String>>();
    public static ArrayList<String> radio_question=new ArrayList<>();
    public static ArrayList<String> check_question=new ArrayList<>();
    public static ArrayList<String> num_question=new ArrayList<>();
    public static ArrayList<String> text_question=new ArrayList<>();
    public static String Header_URL;
    public static String Sname;
    public static String SID="";
    public static String Sended="";
    public static ArrayList<String> my_price_id=new ArrayList<>();
    public static ArrayList<String> my_price_name=new ArrayList<>();
    public static ArrayList<String> my_price_picture_url=new ArrayList<>();
    public static ArrayList<String> my_price_dateorther=new ArrayList<>();
    public static ArrayList<String> my_price_status=new ArrayList<>();
    public static ArrayList<String> my_price_status_text=new ArrayList<>();
    public static ArrayList<String> my_price_master_text=new ArrayList<>();
    public static ArrayList<String> my_price_masters=new ArrayList<>();
    public static String my_selected_proposal_id;
    public static String my_selected_proposal_name;
    public static String my_selected_proposal_picture;
    public static String my_selected_proposal_active;
    public static String my_selected_proposal_text;
    public static String my_selected_proposal_geo;
    public static ArrayList<String> my_all_proposals_actors_name=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_picture=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_mobile=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_count_work=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_score=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_count_comment=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_price=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_time=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_is_special=new ArrayList<>();
    public static ArrayList<String> my_all_proposals_actors_is_selected=new ArrayList<>();
    //Vars End







    public database(String phone_number)
    {

        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_server/login.php");




            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("mobile",phone_number));

            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));




            HttpResponse httpResponse=httpClient.execute(httpGet);

            HttpEntity httpEntity=httpResponse.getEntity();


            String code_p=EntityUtils.toString(httpEntity);


//            Log.i("Err2",code_p);


            json_phone_code(code_p);


        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }

    }







    public database(String test,String SHA)
    {

        get_userr_ditales(SHA);

        get_item_list();

        get_config();

        get_all_my_order_list_now();

    }







    public database()
    {

    }








    private void json_phone_code(String json)
    {

        JsonParser jsonParser=new JsonParser();

        Object object=jsonParser.parse(json);

        JsonObject object1=(JsonObject)object;

        String alert= object1.get("alert")+"";
        String code= object1.get("code")+"";
        SHA=object1.get("sha_pre").getAsString();

//        Log.i("Err2","Alert Is "+alert);
//        Log.i("Err2","Code Is "+code);

        if(alert.trim().equals("\"success\"")||alert.trim().equals("success"))
        {
            Sms_Key=json_clear(code).trim();
        }


    }










    public static String json_clear(String string)
    {
        char []s=string.toCharArray();

        s[0]=' ';
        s[s.length-1]=' ';

        return new String(s);

    }












    //Get User Ditales Strat
    private void get_userr_ditales(String SHA)
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_client/get_user.php");




            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("mobile",SHA));


            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));




            HttpResponse httpResponse=httpClient.execute(httpGet);

            HttpEntity httpEntity=httpResponse.getEntity();


            String code_p=EntityUtils.toString(httpEntity);


            user_class user_class=new user_class(code_p);


//            Log.i("Err2",code_p);

        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }
    }
    //Get User Ditales End






    //Get Items From Json Start
    private void get_item_list()
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_client/get_service.php");


            pairs.add(new BasicNameValuePair("security",code));


            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));


            HttpResponse httpResponse=httpClient.execute(httpGet);


//            HttpEntity httpEntity=httpResponse.getEntity();


            String json= EntityUtils.toString(httpResponse.getEntity(), "UTF-8");


            create_list_items(json);


        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }
    }








    private void create_list_items(String json)
    {

        try
        {


            JSONArray ar=new JSONArray(json);

            items.clear();
            items_icons.clear();
            items_sub.clear();

            for(int a=0;a<ar.length();a++)
            {
                items.add(ar.getJSONObject(a).getString("name").toString());
                items_icons.add(ar.getJSONObject(a).getString("picture").toString());
                items_sub.add(ar.getJSONObject(a).getString("sub").toString());
            }


        }
        catch (Exception Err)
        {
            Log.i("Err",Err.getMessage());
        }

    }








    public static void get_sub_items(int sub_count)
    {
        try
        {



            JSONArray ar=new JSONArray(items_sub.get(sub_count));

            items_sub_item.clear();
            items_sub_item_icons.clear();
            items_sub_item_sub.clear();

            for(int a=0;a<ar.length();a++)
            {
                items_sub_item.add(ar.getJSONObject(a).getString("name").toString());
                String t=ar.getJSONObject(a).getString("picture").toString();
                items_sub_item_icons.add(t);
                items_sub_item_sub.add(ar.getJSONObject(a).getString("sub2").toString());
            }


        }
        catch (Exception Err)
        {
//            Log.i("Err2", Err.getMessage());
        }
    }









    public static void get_sub_items3(int sub_count)
    {
        try
        {



            JSONArray ar=new JSONArray(items_sub_item_sub.get(sub_count));

            items_sub_item3_sid.clear();
            items_sub_item3.clear();
            items_sub_item_icons3.clear();
            items_sub_item_sub3.clear();

            for(int a=0;a<ar.length();a++)
            {
                items_sub_item3_sid.add(ar.getJSONObject(a).getString("id").toString());
                items_sub_item3.add(ar.getJSONObject(a).getString("name").toString());
                items_sub_item_icons3.add(ar.getJSONObject(a).getString("picture").toString());
                items_sub_item_sub3.add(ar.getJSONObject(a).getString("steps").toString());

            }

        }
        catch (Exception Err)
        {

        }
    }









    //Step Questions Start
    public static void get_questions(int index)
    {

        try
        {
            JSONArray jsonArray = new JSONArray(items_sub_item_sub3.get(index));

            question.clear();
            question_radio.clear();
            question_check.clear();
            question_text.clear();
            question_number.clear();

            String Jsn="";

            for(int a=0;a<jsonArray.length();a++)
            {
                question.add(jsonArray.getJSONObject(a).getString("question"));
                Jsn=jsonArray.getJSONObject(a).getString("inputs");
                get_question_from_json(Jsn);
            }

        }
        catch (Exception Err)
        {

        }


    }










    public static void get_questions(String json)
    {

        try
        {

            JSONArray jsonArray = new JSONArray(json);

            question.clear();
            question_radio.clear();
            question_check.clear();
            question_text.clear();
            question_number.clear();

            String Jsn="";

            for(int a=0;a<jsonArray.length();a++)
            {
                Log.i("Err_s",jsonArray.getJSONObject(a).getString("question"));
                question.add(jsonArray.getJSONObject(a).getString("question"));
                Jsn=jsonArray.getJSONObject(a).getString("inputs");
                get_question_from_json(Jsn);
            }

        }
        catch (Exception Err)
        {

        }


    }











    private static void get_question_from_json(String Json)
    {

        type_ac.selected_items.clear();

        ArrayList<String> radio_list=new ArrayList<>();
        ArrayList<String> check_list=new ArrayList<>();
        ArrayList<String> text=new ArrayList<>();
        ArrayList<String> numbers=new ArrayList<>();
        ArrayList<String> name=new ArrayList<>();


        try
        {

            JSONArray json=new JSONArray(Json);

            for(int a=0;a<json.length();a++)
            {
                if(json.getJSONObject(a).getString("type").equals("radio"))
                {
                    radio_question.add(json.getJSONObject(a).getString("name"));
                    radio_list.add(json.getJSONObject(a).getString("text"));
                    continue;
                }
                if(json.getJSONObject(a).getString("type").equals("check"))
                {
                    check_question.add(json.getJSONObject(a).getString("name"));
                    check_list.add(json.getJSONObject(a).getString("text"));
                    continue;
                }
                if(json.getJSONObject(a).getString("type").equals("text"))
                {
                    text_question.add(json.getJSONObject(a).getString("name"));
                    text.add(json.getJSONObject(a).getString("text"));
                    continue;
                }
                if(json.getJSONObject(a).getString("type").equals("number"))
                {
                    num_question.add(json.getJSONObject(a).getString("name"));
                    numbers.add(json.getJSONObject(a).getString("text"));
                    continue;
                }
            }










            radio_question=remove_array_retry_values(radio_question);
            check_question=remove_array_retry_values(check_question);
            num_question=remove_array_retry_values(num_question);
            text_question=remove_array_retry_values(text_question);












            for(int a=0;a<radio_question.size();a++)
                Log.i("Err80",radio_question.get(a));
            for(int a=0;a<check_question.size();a++)
                Log.i("Err80",check_question.get(a));
            for(int a=0;a<text_question.size();a++)
                Log.i("Err80",text_question.get(a));
            for(int a=0;a<num_question.size();a++)
                Log.i("Err80",num_question.get(a));













            try
            {
                if(!radio_list.get(0).equals(""))
                {
                    question_radio.add(radio_list);
                    question_name.add(name);
                }
            }
            catch (Exception Err)
            {}



            try
            {
                if(!check_list.get(0).equals(""))
                {
                    question_check.add(check_list);
                    question_name.add(name);
                }
            }
            catch (Exception Err)
            {}



            try
            {
                if(!text.get(0).equals(""))
                {
                    question_text.add(text);
                    question_name.add(name);
                }
            }
            catch (Exception Err)
            {}



            try
            {
                if(!numbers.get(0).equals(""))
                {
                    question_number.add(numbers);
                    question_name.add(name);
                }
            }
            catch (Exception Err)
            {}





        }
        catch (Exception Err)
        {
//            Log.i("Err98",Err.getMessage());
        }

    }
    //Step Questions End
//Get Items From Json End















    public static ArrayList<String> remove_array_retry_values(ArrayList<String> arrayList)
    {

        ArrayList<String> list=new ArrayList<>();


        for(int a=0;a<arrayList.size();a++)
        {

            boolean have=false;

            for(int b=0;b<list.size();b++)
            {
                if(arrayList.get(a).equals(list.get(b)))
                {
                    have=true;
                }
            }

            if(!have)
            {
                list.add(arrayList.get(a));
            }
        }


        return list;
    }















    //Search Start
    public static void search(String Value)
    {


        search_result_three_item1.clear();
        search_result_three_item2.clear();
        search_result_three_item3.clear();
        search_result_questions.clear();
        search_result_icon.clear();
        items_sub_item3_sid.clear();
        search_result_sid.clear();


        for(int search_loop1=0;search_loop1<items.size();search_loop1++)
        {

            items_sub_item.clear();

            items_sub_item_icons.clear();

            items_sub_item_sub3.clear();


            get_sub_items(search_loop1);



            for(int search_loop2=0;search_loop2<items_sub_item.size();search_loop2++)
            {

                items_sub_item3.clear();

                items_sub_item_icons3.clear();

                get_sub_items3(search_loop2);


                for(int search_loop3=0;search_loop3<items_sub_item3.size();search_loop3++)
                {

                    if(items_sub_item3.get(search_loop3).lastIndexOf(Value)!=-1)
                    {
                        search_result_items.add(items_sub_item3.get(search_loop3));
                        search_result_items_icons.add(items_sub_item_icons3.get(search_loop3));
                        search_result_three_item1.add(items.get(search_loop1));
                        search_result_three_item2.add(items_sub_item.get(search_loop2));
                        search_result_three_item3.add(items_sub_item3.get(search_loop3));
                        search_result_icon.add(items_sub_item_icons3.get(search_loop3));
                        search_result_questions.add(items_sub_item_sub3.get(search_loop3));
                        search_result_sid.add(items_sub_item3_sid.get(search_loop3));

//                        Log.i("Err7",items_sub_item_sub3.get(search_loop3));
                    }

                }


            }



        }



    }
    //Search End











    //Get Application Config From Json Start
    public static void get_config()
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"config.php");

            pairs.add(new BasicNameValuePair("security",code));

            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));

            HttpResponse httpResponse=httpClient.execute(httpGet);

            String json= EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

//            Log.i("Err3",json);

            Create_Config_data(json);

        }
        catch (Exception Error)
        {

        }

    }












    public static void Create_Config_data(String Json) throws Exception
    {

        JsonParser jsonParser=new JsonParser();

        Object object=(Object)jsonParser.parse(Json);

        JsonObject jsonObject=(JsonObject)object;

        Sname=jsonObject.get("sname").getAsString();

        Site_APP_Version=jsonObject.get("android_c_version").getAsString();

        Site_Share_Text=jsonObject.get("sharetext").getAsString();

        Header_URL=jsonObject.get("logo").getAsString();

//        Log.i("Err3","Conf Done");

//        Header_URL="https://snapp-gadget.ir/data/app_logo/original.png";
    }
    //Get Application Config From Json End















    //Insert New Price Start
    public static void Insert_new_Price(String othertext,String dateorther)
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_server/submit_order.php");


            dateorther=dateorther.replace("0/1/","");
            dateorther=dateorther.replace("0/2/","");
            dateorther=dateorther.replace("0/3/","");
            dateorther=dateorther.replace("0/4/","");
            dateorther=dateorther.replace("0/5/","");
            dateorther=dateorther.replace("0/6/","");
            dateorther=dateorther.replace("0/7/","");
            dateorther=dateorther.replace("0/8/","");
            dateorther=dateorther.replace("0/9/","");



            Log.i("Err9",code);
            Log.i("Err9",user_class.uid.trim());
            Log.i("Err9",SID);
            Log.i("Err9",othertext);
            Log.i("Err9",dateorther);


            pairs.add(new BasicNameValuePair("uid",user_class.uid.trim()));
            pairs.add(new BasicNameValuePair("sid",SID));
            pairs.add(new BasicNameValuePair("othertext",othertext));
            pairs.add(new BasicNameValuePair("dateorder",dateorther));
            pairs.add(new BasicNameValuePair("geo",map_ac.x1+"-"+map_ac.y1));
            pairs.add(new BasicNameValuePair("security",code));










            //Radio Start
            try
            {
                for (int a = 0; a < radio_question.size(); a++)
                {
                    pairs.add(new BasicNameValuePair(radio_question.get(a), type_ac.Selected_items.get(a)));
                    Log.i("Err9", radio_question.get(a));
                }
            }
            catch (Exception Err)
            {

            }
            //Radio End











            //Check Start
            try
            {
                for (int a = 0; a < check_question.size(); a++)
                {
                    ArrayList<String> checks = check_list_ac.Selected_Checks_bank.get(a);

                    String values="\"";

                    int t=checks.size();
                    t--;
                    for (int i = 0; i < checks.size(); i++)
                    {
                        if(i == t)
                        {
                            values += checks.get(i);
                        }
                        else
                        {
                            values += checks.get(i) + ",";
                        }
                    }
                    values+="\"";

                    pairs.add(new BasicNameValuePair(check_question.get(a), values));

                    Log.i("Err9","Check OK");
                }
            }
            catch (Exception Err)
            {

            }
            //Check End
















            //Number Start
            try
            {
                for (int a = 0; a < num_question.size(); a++)
                {
                    pairs.add(new BasicNameValuePair(num_question.get(a), numbers_ac.numbers.get(a)));
                }
                Log.i("Err9","Number OK");
            }
            catch (Exception Err)
            {
            }
            //Number End



















            //Text Start
            try
            {
                for (int a = 0; a < text_question.size(); a++)
                {
                    pairs.add(new BasicNameValuePair(text_question.get(a), question_ac.questions_text.get(a)));
                }
                Log.i("Err9","Text OK");
            }
            catch (Exception Err)
            {
            }
            //Text End




















            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));

            HttpResponse httpResponse=httpClient.execute(httpGet);

            HttpEntity httpEntity=httpResponse.getEntity();

            String code_p=EntityUtils.toString(httpEntity);

//            Log.i("price_json",code_p);

            Sended=code_p;

        }
        catch (Exception Error)
        {
            Log.i("Err2",Error.getMessage());
        }

    }
    //Insert New Price End


















    //New Commmand Start
    public static void Insert_new_command(String command)
    {

        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_server/submit_comment.php");


            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("uid",user_class.uid));
            pairs.add(new BasicNameValuePair("text",command));

            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));




            HttpResponse httpResponse=httpClient.execute(httpGet);

            HttpEntity httpEntity=httpResponse.getEntity();


            String code_p=EntityUtils.toString(httpEntity);

//            Log.i("Err2",code_p);

            Sended=code_p;

        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }

    }
    //New Commmand End
















    //Get My Orther List Now Start
    public static void get_all_my_order_list_now()
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_client/get_order.php");


            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("uid",user_class.uid));



            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));

            HttpResponse httpResponse=httpClient.execute(httpGet);

            String code_p= EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

//            Log.i("Err",code_p);

            create_my_arraylist_order_from_json(code_p);


        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }
    }
    //Get My Orther List Now End














    //Get My Orther List Now Start
    public static void get_all_my_order_list_now_from_price_done()
    {
        try
        {

            my_price_id.clear();
            my_price_name.clear();
            my_price_picture_url.clear();
            my_price_dateorther.clear();

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_client/get_order.php");


            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("uid",user_class.uid));



            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));

            HttpResponse httpResponse=httpClient.execute(httpGet);

            String code_p= EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            create_my_arraylist_order_from_json(code_p);


        }
        catch (Exception Error)
        {
//            Log.i("Err2",Error.getMessage());
        }
    }
    //Get My Orther List Now End


















    //Create My ArrayList Now Start
    public static void create_my_arraylist_order_from_json(String json)
    {
        try
        {

            my_price_id.clear();
            my_price_name.clear();
            my_price_picture_url.clear();
            my_price_dateorther.clear();
            my_price_status.clear();
            my_price_status_text.clear();
            my_price_master_text.clear();
            my_price_masters.clear();


            JSONArray jsonArray=new JSONArray(json);

            for(int a=0;a<jsonArray.length();a++)
            {
                my_price_id.add(jsonArray.getJSONObject(a).getString("id"));
                my_price_name.add(jsonArray.getJSONObject(a).getString("name"));
                my_price_picture_url.add(jsonArray.getJSONObject(a).getString("picture"));
                my_price_dateorther.add(jsonArray.getJSONObject(a).getString("dateorder"));
                my_price_status.add(jsonArray.getJSONObject(a).getString("status"));
                my_price_status_text.add(jsonArray.getJSONObject(a).getString("status_text"));
                my_price_master_text.add(jsonArray.getJSONObject(a).getString("master_text"));
                my_price_masters.add(jsonArray.getJSONObject(a).getString("masters"));
            }

        }
        catch (Exception Err)
        {

        }

    }
    //Create My ArrayList Now End




















    //Get My All Proposals Start
    public static void get_my_all_proposals(String id)
    {
        try
        {

            ArrayList<NameValuePair> pairs=new ArrayList<NameValuePair>();

            security security=new security();

            String code=security.code();

            DefaultHttpClient httpClient=new DefaultHttpClient();

            HttpPost httpGet=new HttpPost(API_URL+"user_c/to_client/get_order_detail.php");



            pairs.add(new BasicNameValuePair("security",code));
            pairs.add(new BasicNameValuePair("uid",user_class.uid));
            pairs.add(new BasicNameValuePair("id",id));


            httpGet.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));



            HttpResponse httpResponse=httpClient.execute(httpGet);

            HttpEntity httpEntity=httpResponse.getEntity();

            String code_p=EntityUtils.toString(httpEntity);

            convert_my_all_proposal_1_fun(code_p);
        }
        catch (Exception Error)
        {
            Log.i("Err_s",Error.getMessage());
        }
    }
    //Get My All Proposals End






















    //Convert Json My All Proposal 1 Start
    private static void convert_my_all_proposal_1_fun(String json) throws Exception
    {

        byte []codes=json.getBytes("ISO-8859-1");

        String result=new String(codes,"UTF-8");

        JsonParser jsonParser=new JsonParser();

        Object object=(Object)jsonParser.parse(result);

        JsonObject jsonObject=(JsonObject)object;





        my_selected_proposal_id=jsonObject.get("id").getAsString();
        my_selected_proposal_name=jsonObject.get("name").getAsString();
        my_selected_proposal_picture=jsonObject.get("picture").getAsString();
        my_selected_proposal_active=jsonObject.get("active").getAsString();
        my_selected_proposal_text=jsonObject.get("text").getAsString();
        my_selected_proposal_geo=jsonObject.get("geo").getAsString();

        String json_array=jsonObject.getAsJsonArray("proposal").getAsJsonArray()+"";

        try
        {
            JSONArray jsonArray=new JSONArray(json_array);

            for(int a=0;a<jsonArray.length();a++)
            {
                my_all_proposals_actors_name.add(jsonArray.getJSONObject(a).getString("name")+"");
                my_all_proposals_actors_picture.add(jsonArray.getJSONObject(a).getString("picture")+"");
                my_all_proposals_actors_mobile.add(jsonArray.getJSONObject(a).getString("mobile")+"");
                my_all_proposals_actors_count_work.add(jsonArray.getJSONObject(a).getString("count_work")+"");
                my_all_proposals_actors_score.add(jsonArray.getJSONObject(a).getString("score")+"");
                my_all_proposals_actors_count_comment.add(jsonArray.getJSONObject(a).getString("count_comment")+"");
                my_all_proposals_actors_price.add(jsonArray.getJSONObject(a).getString("price")+"");
                my_all_proposals_actors_time.add(jsonArray.getJSONObject(a).getString("time")+"");
//                my_all_proposals_actors_is_special.add(jsonArray.getJSONObject(a).getString("special")+"");
//                my_all_proposals_actors_is_selected.add(jsonArray.getJSONObject(a).getString("selected")+"");
            }

            Log.i("Err_s","OK2");

        }
        catch (Exception Err)
        {
            Log.i("Err_s",Err.getMessage());
        }


    }
    //Convert Json My All Proposal 1 End










}