package com.example.administrator.broadcastreceiveractivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class BootCompleteReceiver extends BroadcastReceiver
{
    private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals(ACTION_BOOT))
        {
            Toast.makeText(context, "开机完成", Toast.LENGTH_SHORT).show();
        }
    }
}
