package com.example.ibnahmad.conversionapp;

import android.content.Context;
import android.preference.PreferenceManager;

public class NamePreference {

    private static final String PREF_NAME = "name";

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


}
