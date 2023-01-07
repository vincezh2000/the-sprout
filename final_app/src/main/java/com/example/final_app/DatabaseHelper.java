package com.example.final_app;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db) {
        //创建数据库sql语句 并 执行,相当于初始化数据库，这里是新建了一张表
        //这个方法继承自SQLiteOpenHelper,会自动调用  也就是 会 当新建了一个DatabaseHelper对象时，就会m=默认新建一张表，表里存着name
//        String sql = "create table intro(id int, content char(1000))";
//        db.execSQL(sql);

        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Opened database successfully");

            String sql = "create table intro(id int primary key, content char(1000))";
            db.execSQL(sql);

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
