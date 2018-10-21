package com.example.ibnahmad.conversionapp;

import android.content.Context;
import android.preference.PreferenceManager;

public class NamePreference {

    private static final String PREF_NAME = "name";
    private static final String PREF_FIRST_RUN = "first_run";

    public static String getStoredName(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_NAME, null);
    }

    public static void setStoredName(Context context, String name){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_NAME, name)
                .apply();
    }

    public static boolean isFirstRun(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_FIRST_RUN, false);
    }

    public static void setPrefFirstRun(Context context, boolean isFirstRun){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_FIRST_RUN, isFirstRun)
                .apply();
    }

}
