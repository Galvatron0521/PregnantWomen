package com.shenkangyun.pregnantwomen.DBFolder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/7/12.
 */

public class SQLiteDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "UserInfo.db";
    public static final int DB_VERSION = 1;
    //创建 students 表的 sql 语句
    private static final String CREATE_UserInfo = "create table User("
            + "id integer primary key autoincrement,"
            + "userID text,"
            + "telNum text,"
            + "name text,"
            + "age integer,"
            + "birthday text,"
            + "sex text,"
            + "idCard text)";

    public SQLiteDbHelper(Context context) {
        // 传递数据库名与版本号给父类
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 在这里通过 db.execSQL 函数执行 SQL 语句创建所需要的表
        //创建 User 表
        db.execSQL(CREATE_UserInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // 启动外键
            db.execSQL("PRAGMA foreign_keys = 1;");
            //或者这样写
            String query = String.format("PRAGMA foreign_keys = %s", "ON");
            db.execSQL(query);
        }
    }
}

