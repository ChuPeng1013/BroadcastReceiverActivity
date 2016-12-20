package com.example.administrator.broadcastreceiveractivity;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChuPeng on 2016/12/19.
 */

public class ActivityCollector
{
    private static List<Activity> activityList = new ArrayList<Activity>();
    //加入Activity
    public static void addActivity(Activity activity)
    {
        activityList.add(activity);
    }
    //删除Activity
    public static void removeActivity(Activity activity)
    {
        activityList.remove(activity);
    }
    //清除所有Activity
    public static void cleanActivity()
    {
        for(int i = 0; i < activityList.size(); i++)
        {
            if(!activityList.get(i).isFinishing())
            {
                activityList.get(i).finish();
            }
        }
    }
}
