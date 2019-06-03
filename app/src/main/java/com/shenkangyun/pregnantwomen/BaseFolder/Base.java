package com.shenkangyun.pregnantwomen.BaseFolder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.shenkangyun.pregnantwomen.DBFolder.SQLiteDbHelper;
import com.shenkangyun.pregnantwomen.DBFolder.User;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class Base {


    public static final String URL = "http://192.168.0.210:8080/skyapp_cfyou/api/app_patient/";

    public static String getMD5Str() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd");
        String md5 = new Md5Hash("shenkangyun_canlian_patient", timeFormat.format(new Date()), 1).toString();
        return md5;
    }

    public static String getTimeSpan() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd");
        return timeFormat.format(new Date());
    }

//    public static String getUserID() {
//        String userID = "";
//        SQLiteDbHelper sqLiteDbHelper = new SQLiteDbHelper(MyApp.getContext());
//        SQLiteDatabase db = sqLiteDbHelper.getWritableDatabase();
//        Cursor cursor = db.query("User", null, null, null, null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                userID = cursor.getString(cursor.getColumnIndex("userID"));
//            } while (cursor.moveToLast());
//        }
//        cursor.close();
//        return userID;
//    }
}