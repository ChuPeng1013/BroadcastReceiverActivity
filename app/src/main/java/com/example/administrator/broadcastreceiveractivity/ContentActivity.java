package com.example.administrator.broadcastreceiveractivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class ContentActivity extends BaseActivity
{
    private Button offLine;
    private LocalBroadcastManager localBroadcastManager;
    private OffLineReceiver offLineReceiver;
    private IntentFilter intentFilter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content);
        offLine = (Button) findViewById(R.id.offLine);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        offLineReceiver = new OffLineReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.administrator.broadcastreceiveractivity.action");
        localBroadcastManager.registerReceiver(offLineReceiver, intentFilter);

        offLine.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent("com.example.administrator.broadcastreceiveractivity.action");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(offLineReceiver);
    }
}
