package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.B58works.B58;
import com.B58works.settings.Superpref;

public class Mediamods extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("tmedia", "xml"));
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
