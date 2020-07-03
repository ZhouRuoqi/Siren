package com.Siren.MusicPlayer;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.Siren.MusicPlayer.ui.welcome.WelcomeActivity;

public class Login extends AppCompatActivity {

    private TextView fail;
    private EditText et1;
    private EditText et2;
    private Button bt_login;
    private Button bt_register;
    private Button bt_change;
    private UserManage mUserManager;         //用户数据管理类
    // public static MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fail=(TextView) findViewById(R.id.textView2);
        et1 = (EditText) findViewById(R.id.editText);//用户名
        et2 = (EditText) findViewById(R.id.editText2);//密码
        bt_login = (Button) findViewById(R.id.button);
        bt_register = (Button) findViewById(R.id.button2);
        bt_change = (Button) findViewById(R.id.button3);

        mUserManager = new UserManage(this);  //实例化
        // mContext = this;
        SQLiteDatabase db = null;
        mUserManager.onCreate(db);  //创建库
        mUserManager.onOpen(db);
        mUserManager.createTable();//创建表

        //****************************修改密码**********************************/
        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1= et1.getText().toString();String s2= et2.getText().toString();

               int result = mUserManager.findUserByNameAndPwd(s1, s2);
                  if (result >0) {

                   Intent intent=new Intent(Login.this,ChangePSW.class);
                    intent.putExtra("strType", s1);//传参：用户名
                    Login.this.startActivity(intent);

               }
               else
                   fail.setText("Failed!");//需要检查用户名和密码是否匹配

                 mUserManager.close();
                 mUserManager = null;
            }

        });
/****************************注册**********************************/
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login.this, Register.class);
                startActivity(intent);
            }

        });
/****************************登录**********************************/
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Intent intent = new Intent();
               // intent.setClass(Login.this, WelcomeActivity.class);
                //startActivity(intent);
                // SQLiteDatabase db = null;
                //mUserManager.onCreate(db);  //创建库
                // mUserManager.onOpen(db);
                //mUserManager.createTable();//创建表

                // mUserManager.insertData("insert into users(user_name,user_pwd) values('admin','123456')");
                String s1= et1.getText().toString();
                String s2= et2.getText().toString();
                int result = mUserManager.findUserByNameAndPwd(s1, s2);
                if (result>0) {
                    fail.setText("Login successfully!");
                    Intent intent = new Intent();
                   intent.setClass(Login.this, WelcomeActivity.class);
                    startActivity(intent);
                }
               else
                  fail.setText("Failed to login!");

                //  mUserManager.close();
                //   mUserManager = null;
            }

        });
    }

}
