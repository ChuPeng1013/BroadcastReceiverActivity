package com.example.administrator.broadcastreceiveractivity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class OffLineReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, Intent intent)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("警告：");
        dialog.setMessage("您的账号在别处登录，请重新登陆~");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                //消除说有Activity
                ActivityCollector.cleanActivity();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //重新启动登录界面
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
