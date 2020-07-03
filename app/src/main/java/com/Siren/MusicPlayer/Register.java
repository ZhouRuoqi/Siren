package com.Siren.MusicPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Register extends AppCompatActivity {

    private TextView result;
    private EditText et3;
    private EditText et4;
    private Button bt_r;
    private UserManage mUserManager;         //用户数据管理类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        result = (TextView) findViewById(R.id.textView4);//注册结果
        et3 = (EditText) findViewById(R.id.editText3);//用户名
        et4 = (EditText) findViewById(R.id.editText4);//密码
        bt_r = (Button) findViewById(R.id.button3);//注册按钮
        mUserManager = new UserManage(this);  //实例

        bt_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1= et3.getText().toString();
                String s2= et4.getText().toString();

              //  SQLiteDatabase db = null;
               // mUserManager.onCreate(db);  //创建库
                // mUserManager.onOpen(db);
                 //mUserManager.createTable();//创建表


                mUserManager.insertData("insert into users(user_name,user_pwd) values('"+s1+"','"+s2+"')");

                int result2 = mUserManager.findUserByNameAndPwd(s1, s2);
                if (result2 >0) {
                    result.setText("Register successfully!");
                }
                else
                    result.setText("Fail to register!");

                //  mUserManager.close();
                //  mUserManager = null;

            }

        });

    }
}
