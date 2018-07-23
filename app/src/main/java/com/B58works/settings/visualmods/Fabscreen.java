package com.B58works.settings.visualmods;

import android.content.SharedPreferences;

import android.os.Bundle;

import com.B58works.B58;
import com.B58works.settings.Superpref;

import static com.B58works.B58.getResID;


public class Fabscreen extends Superpref{

    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.addPreferencesFromResource(getResID( "vfab", "xml"));
        B58.settingstoast();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }
}
