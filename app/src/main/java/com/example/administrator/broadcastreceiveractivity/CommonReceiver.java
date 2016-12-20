package com.example.administrator.broadcastreceiveractivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ChuPeng on 2016/12/20.
 */

public class CommonReceiver extends BroadcastReceiver
{
    private final String ACTION_COMMON = "com.example.administrator.broadcastreceiveractivity.common";
    public void onReceive(Context context, Intent intent)
    {
        if(ACTION_COMMON.equals(intent.getAction()))
        {
            Toast.makeText(context, "账号密码都是111", Toast.LENGTH_SHORT).show();
        }
    }
}
