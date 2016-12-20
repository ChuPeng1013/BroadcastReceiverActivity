package com.example.administrator.broadcastreceiveractivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class NetWorkReceiver extends BroadcastReceiver
{
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "网络状态发生改变", Toast.LENGTH_SHORT).show();
    }
}
