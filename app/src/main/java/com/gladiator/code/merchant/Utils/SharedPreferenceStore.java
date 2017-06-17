package com.gladiator.code.merchant.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Mukesh on 5/16/2017.
 * This class user for saving data to local
 */

public class SharedPreferenceStore {

    public static final String KEY_ONLINE_AMOUNT = "KEY_ONLINE_AMOUNT";
    public static final String KEY_OFFLINE_AMOUNT = "KEY_OFFLINE_AMOUNT";

    public static void deleteValue(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key).commit();
    }

    public static void storeValue(Context context, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value).commit();
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(key));
    }

    public static void storeValue(Context context, String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value).apply();
    }

    public static void storeValue(Context context, String key, double value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String doubleVal = String.valueOf(value);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, doubleVal).apply();
    }

    public static void storeValue(Context context, String key, float value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value).apply();
    }

    public static void storeValue(Context context, String key, long value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value).apply();
    }

    public static void storeValue(Context context, String key, int value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value).apply();
    }



    /**
     * **********************
     * GET Methods
     * *************************************
     */
    public static String getValue(Context context, String key, String defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, defValue);
    }

    public static boolean getValue(Context context, String key, boolean defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, defValue);
    }

    public static double getValue(Context context, String key, double defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String doubleVal = String.valueOf(defValue);
        return Double.parseDouble(preferences.getString(key, doubleVal));
    }

    public static float getValue(Context context, String key, float defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getFloat(key, defValue);
    }

    public static long getValue(Context context, String key, long defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getLong(key, defValue);
    }

    public static int getValue(Context context, String key, int defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, defValue);
    }


}
