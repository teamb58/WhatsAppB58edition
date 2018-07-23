package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;


import com.B58works.B58;
import com.B58works.settings.Superpref;


import static com.B58works.B58.getBoolean;


public class Homescreen extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vhome", "xml"));
        B58.settingstoast();
        final Preference p2=this.findPreference("homebg");
        final Preference p3=this.findPreference("homebggr");
        if(getBoolean("homebggrc"))
        {
            p2.setTitle("v3.1a Start color for Gradient");
            p2.setSummary("Choose a start color for Home screen background Gradient");
            p3.setTitle("v3.1b End color for Gradient");
            p3.setSummary("Choose an end color for Home screen background Gradient");
        }
        else if(!getBoolean("homebggrc")) {
            p2.setTitle("v3.1 Home screen background");
            p2.setSummary("Choose a color for background of chats in homescreen.");
        }
        final Preference p5=this.findPreference("Tabcolor");
        final Preference p6=this.findPreference("Tabcolorgr");
        if(getBoolean("Tabcolorgrc"))
        {
            p5.setTitle("v3.2a Start color for Gradient");
            p5.setSummary("Choose a start color for Tab color Gradient");
            p6.setTitle("v3.2b End color for Gradient");
            p6.setSummary("Choose an end color for Tab color Gradient");
        }
        else if(!getBoolean("Tabcolorgrc")) {
            p5.setTitle("v3.2 Home Tabs color");
            p5.setSummary("Choose a color for Chats,Status and Calls tab.");
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }
}
