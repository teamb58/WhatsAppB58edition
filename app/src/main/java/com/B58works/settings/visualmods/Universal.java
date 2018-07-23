package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.B58works.B58;
import com.B58works.settings.Superpref;

import static com.B58works.B58.getBoolean;


public class Universal extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vuniversal", "xml"));
        this.getPreferenceManager().setSharedPreferencesName("B58");
        B58.settingstoast();
        final Preference p2=this.findPreference("ActionbarColor");
        final Preference p3=this.findPreference("ActionbarColorgr");
        if(getBoolean("ActionbarColorgrc"))
        {
            p2.setTitle("v2.1a Start color for Gradient");
            p2.setSummary("Choose a start color for Actionbar Gradient");
            p3.setTitle("v2.1b End color for Gradient");
            p3.setSummary("Choose an end color for Actionbar Gradient");
        }
        else if(!getBoolean("ActionbarColorgrc")) {
            p2.setTitle("v2.1 Universal Actionbar Color");
            p2.setSummary("Choose a color for Actionbar.");
        }
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
