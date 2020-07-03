package com.Siren.MusicPlayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangePSW extends AppCompatActivity {

    private TextView result;
    private EditText et6;
    private Button bt_c;
    private UserManage mUserManager;         //用户数据管理类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_psw);
        result = (TextView) findViewById(R.id.textView6);//修改结果
        et6 = (EditText) findViewById(R.id.editText6);//新密码
        bt_c = (Button) findViewById(R.id.button3);//修改按钮
        mUserManager = new UserManage(this);  //实例化

        bt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s6= et6.getText().toString();

                String recieve="";//接收传递过来的参数
                final Intent intent = getIntent();
                recieve = intent.getStringExtra("strType");

                mUserManager.insertData("DELETE FROM users WHERE user_name='"+recieve+"'");
                mUserManager.insertData("insert into users(user_name,user_pwd) values('"+recieve+"','"+s6+"')");

                int result2 = mUserManager.findUserByNameAndPwd(recieve, s6);
                if (result2 >0) {
                    result.setText("Successful!");
                }
                else
                    result.setText("Failed!");

                //  mUserManager.close();
            }

        });
    }
}
