package com.Siren.MusicPlayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserManage extends SQLiteOpenHelper {             //用户数据管理类
    //一些宏定义和声明
    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";
    private static final String TABLE_NAME = "users";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";
    private static final int DB_VERSION = 2;
    private Context mContext = null;
    private SQLiteDatabase db = null;

    //创建用户book表

    private static final String DB_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +  USER_NAME + " varchar," + USER_PWD + " varchar" + ");";

    public UserManage(Context context){
        super(context,DB_NAME,null,2);//把数据库改为可写入状态
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
    @Override
    public void onOpen(SQLiteDatabase db) { super.onOpen(db); }

    public void createTable(){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        db.execSQL(DB_CREATE);
    }

    public void insertData(String sql) {
        db.execSQL(sql);
    }

    //根据用户名和密码找用户，用于登录
    public int findUserByNameAndPwd(String userName, String pwd){

        int result=0;
        Cursor mCursor=db.query(TABLE_NAME, null, "user_name=? and user_pwd=?", new String[]{userName,pwd}, null, null,
                null);
        if(mCursor!=null){
            result=mCursor.getCount();
            mCursor.close();
        }
        return result;
    }
}