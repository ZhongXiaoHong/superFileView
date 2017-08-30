package com.silang.superfileview;
import android.text.TextUtils;
import android.util.Log;


public final class TLog {
    private static final String LOG_TAG = "superFileLog";
    private static boolean DEBUG = true;

    private TLog() {
    }

    public static void e(String log) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.e(LOG_TAG, "" + log);
    }

    public static void i(String log) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.i(LOG_TAG, log);
    }

    public static void i(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.i(tag, log);
    }

    public static void d(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.d(tag, log);
    }

    public static void d(String log) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.d(LOG_TAG, log);
    }

    public static void e(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.e(tag, log);
    }


}
