package com.B58works.settings.textmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;


import com.B58works.Listpref;
import com.B58works.R;
import com.B58works.settings.Superpref;
import com.whatsapp.architjn.ui.activity.IconChoose;


public class Choosers extends Superpref{

    Listpref p71,p73,p74;
    Preference p72;

    public Choosers()
    {
        p71=(Listpref)findPreference("notifyicon");
        p72=findPreference("launchericon");
        p73=(Listpref)findPreference("bubblestyle");
        p74=(Listpref)findPreference("tickstyle");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.tchooser);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
        b58();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
        onStart();
    }

    private void b58()
    {
        p71.setTitle(R.string.notifychoose);
        p71.setEntries(R.array.notifybar_colors);
        p71.setDefaultValue("0");
        p71.setEntryValues(R.array.notifybar_values);
        p72.setTitle(R.string.launcherchoose);
        p72.setIntent(new Intent(this, IconChoose.class));
        p73.setTitle(R.string.bubblechoose);
        p73.setEntries(R.array.conversation_bubbleStyleList);
        p73.setDefaultValue("0");
        p73.setEntryValues(R.array.conversation_bubbleStyleListValues);
        p74.setTitle(R.string.tickchoose);
        p74.setEntries(R.array.tick_n);
        p74.setDefaultValue("0");
        p74.setEntryValues(R.array.tick_v);
    }
}
