package cn.link.linklive.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.link.linklive.R;


public class ActivityManager {

    public static List<Activity> activities = new ArrayList<>();

    /**
     * add a new activity
     * @param activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * remove a activity
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * delete all activity ,exit application
     */
    public static void finishAll(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    /**
     * delay to new Activity
     * @param context
     * @param cls
     * @param delay
     */
    public static void delayToActivity(final Context context, final Class<?> cls, long delay) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                context.startActivity(new Intent(context, cls));
            }
        }, delay);
    }
    /**
     * to new Activity，not carry data ，not set flag
     * @param context
     * @param cls
     */
    public static void goToActivity(Context context,Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
    /**
     * go to activity,use animation
     * @param context
     * @param cls
     * @param enterAnim
     * @param exitAnim
     */
    public static void goToActivity(Context context,Class<?> cls,int enterAnim,int exitAnim,Bundle bundle) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim,exitAnim);
    }
    /**
     * to new activity,use animation from right to left
     * @param context
     * @param cls
     */
    public static void goToActivityFromLeft2Right(Context context,Class<?> cls) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
    }
    /**
     * to new activity,use animation from right to left carry data
     * @param context
     * @param cls
     */
    public static void goToActivityFromLeft2Right(Context context,Class<?> cls,Bundle bundle) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_left,R.anim.out_to_right);
    }
    /**
     * to new activity,use animation from left to right
     * @param context
     * @param cls
     */
    public static void goToActivityFromRight2Left(Context context,Class<?> cls) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
    }
    /**
     * to new activity,use animation from left to right carry data
     * @param context
     * @param cls
     */
    public static void goToActivityFromRight2Left(Context context,Class<?> cls,Bundle bundle) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
    }
    /**
     * to new activity,use animation from bottom to top carry data
     * @param context
     * @param cls
     * @param bundle
     */
    public static void goToActivityFromBottom2Top(Context context,Class<?> cls,Bundle bundle) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_bottom,R.anim.out_to_top);
    }
    /**
     * to new activity,use animation from bottom to top
     * @param context
     * @param cls
     */
    public static void goToActivityFromBottom2Top(Context context,Class<?> cls) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_bottom,R.anim.out_to_top);
    }
    /**
     * to new activity,use animation form top to bottom
     * @param context
     * @param cls
     */
    public static void goToActivityFromTop2Bottom(Context context,Class<?> cls) {
        Activity activity = (Activity)context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_top,R.anim.out_to_bottom);
    }


    /**
     * to new Activity，with carrying data,no animation
     * @param context
     * @param cls
     */
    public static void goToActivity(Context context,Class<?> cls,Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
