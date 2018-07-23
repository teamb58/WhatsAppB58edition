package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.Preference;


import com.B58works.B58;
import com.B58works.settings.Superpref;

import static com.B58works.B58.getBoolean;


public class ContactPicker extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vconpick", "xml"));
        B58.settingstoast();
        final Preference p2=this.findPreference("conbg");
        final Preference p3=this.findPreference("conbggr");
        if(getBoolean("conbggrc"))
        {
            p2.setTitle("v6.1a Start color for Gradient");
            p2.setSummary("Choose a start color for background Gradient");
            p3.setTitle("v6.1b End color for Gradient");
            p3.setSummary("Choose an end color for background Gradient");
        }
        else if(!getBoolean("conbggrc")) {
            p2.setTitle("v6.1 ContactPicker screen background");
            p2.setSummary("Choose a color for background of contacts in ContactPicker screen.");
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

