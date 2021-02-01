package com.example.socs.recyclerview;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.example.socs.recyclerview.model.Drinks;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Preference {
//
//    static final String KEY_USER_TEREGISTER ="user", KEY_PASS_TEREGISTER ="pass";
//    static final String KEY_USERNAME_SEDANG_LOGIN = "Username_logged_in";
//    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    private Context context;
    private SharedPreferences sharedPreferences;

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
    }


    public void setOrder(ArrayList<Drinks>  listMinuman) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String cartItem = gson.toJson(listMinuman);
        editor.putString("Minuman", cartItem);
        editor.apply();
    }
    public ArrayList<Drinks> getOrder() {
        Gson gson = new Gson();
        String cartItem = sharedPreferences.getString("Minuman", "");

        Type listType = new TypeToken<ArrayList<Drinks>>(){}.getType();
        ArrayList<Drinks> listMinuman = gson.fromJson(cartItem,listType);

        if(listMinuman == null){
            listMinuman = new ArrayList<>();
        }
        return listMinuman;
    }
    public int getTotal(){
        int total=0;
        ArrayList<Drinks> arr = getOrder();
        for (Drinks item: arr) {
            if (item.getQty() < 1)
                item.setQty(1);
            total += item.getPrice()*item.getQty();
        };
        return total;
    }

//    public void setTotal() {
//        int total=0;
//        ArrayList<Drinks> arr = getOrder();
//        for (Drinks item: arr) {
//            if (item.getQty() < 1)
//                item.setQty(1);
//            total += item.getPrice()*item.getQty();
//        }
//
//    }

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


//    public static void setRegisteredUser(Context context, String username){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_USER_TEREGISTER, username);
//        editor.apply();
//    }
//
//    public static String getRegisteredUser(Context context){
//        return getSharedPreference(context).getString(KEY_USER_TEREGISTER,"");
//    }
//
//
//    public static void setRegisteredPass(Context context, String password){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_PASS_TEREGISTER, password);
//        editor.apply();
//    }
//    /** Mengembalikan nilai dari key KEY_PASS_TEREGISTER berupa String */
//    public static String getRegisteredPass(Context context){
//        return getSharedPreference(context).getString(KEY_PASS_TEREGISTER,"");
//    }
//
//    /** Deklarasi Edit Preferences dan mengubah data
//     *  yang memiliki key KEY_USERNAME_SEDANG_LOGIN dengan parameter username */
//    public static void setLoggedInUser(Context context, String username){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putString(KEY_USERNAME_SEDANG_LOGIN, username);
//        editor.apply();
//    }
//    /** Mengembalikan nilai dari key KEY_USERNAME_SEDANG_LOGIN berupa String */
//    public static String getLoggedInUser(Context context){
//        return getSharedPreference(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
//    }
//
//    /** Deklarasi Edit Preferences dan mengubah data
//     *  yang memiliki key KEY_STATUS_SEDANG_LOGIN dengan parameter status */
//    public static void setLoggedInStatus(Context context, boolean status){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
//        editor.apply();
//    }
//    /** Mengembalikan nilai dari key KEY_STATUS_SEDANG_LOGIN berupa boolean */
//    public static boolean getLoggedInStatus(Context context){
//        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
//    }
//
//    /** Deklarasi Edit Preferences dan menghapus data, sehingga menjadikannya bernilai default
//     *  khusus data yang memiliki key KEY_USERNAME_SEDANG_LOGIN dan KEY_STATUS_SEDANG_LOGIN */
//    public static void clearLoggedInUser (Context context){
//        SharedPreferences.Editor editor = getSharedPreference(context).edit();
//        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
//        editor.remove(KEY_STATUS_SEDANG_LOGIN);
//        editor.apply();
//    }
}
