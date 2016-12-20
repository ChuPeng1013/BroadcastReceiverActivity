package com.example.administrator.broadcastreceiveractivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class BaseActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
