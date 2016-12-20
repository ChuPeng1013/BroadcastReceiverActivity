package com.example.administrator.broadcastreceiveractivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity
{
    private NetWorkReceiver broadcastReceiver;
    private EditText userName;
    private EditText password;
    private Button loginButton;
    private Button messageButton;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //监听网络状态变化的监听
        broadcastReceiver = new NetWorkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        //加入广播需要监听的行为
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //对广播进行注册
        registerReceiver(broadcastReceiver, intentFilter);
        //初始化界面控件
        userName = (EditText) findViewById(R.id.usernameEdit);
        password = (EditText) findViewById(R.id.userpsdEdit);
        loginButton = (Button) findViewById(R.id.login);
        messageButton = (Button) findViewById(R.id.message);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(userName.getText().toString().equals("111") && password.getText().toString().equals("111"))
                {
                    Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "点击获取信息按钮获取账号密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        messageButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setAction("com.example.administrator.broadcastreceiveractivity.common");
                sendBroadcast(intent);
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        //对广播解除注册
        unregisterReceiver(broadcastReceiver);
    }
}
