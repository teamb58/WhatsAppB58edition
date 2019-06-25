package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

public class grGlobalTabs extends Superpref {

    Preference p;
    Preference p1;
    Preference p2;
    ListPreference p3;

    public void init()
    {
        p=findPreference("tabsbggr");
        p1=findPreference("tabsbgColor");
        p2=findPreference("tabsbgColorgr");
        p3=(ListPreference) findPreference("tabsbgColoror");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vgrglobaltabs);
        init();
    }

    protected void onStart()
    {
        super.onStart();
        b58();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }

    private void b58()
    {
        p.setTitle(IDGen.string.grfortabs);
        p.setSummary(IDGen.string.grfortabssum);
        if(p.isEnabled())
        {
            p1.setTitle(IDGen.string.startcolor);
            p1.setSummary(IDGen.string.tabsbgstartsum);
            p2.setTitle(IDGen.string.endcolor);
            p2.setSummary(IDGen.string.tabsbgendsum);
            p3.setTitle(IDGen.string.gradient);
            p3.setEntries(IDGen.array.gr_style);
            p3.setEntryValues(IDGen.array.actionbarStyleListValues);
            p3.setDefaultValue("0");
            p3.setSummary(IDGen.string.grstyle);
        }
        else
        {
            p2.setTitle(IDGen.string.disabled);
            p3.setTitle(IDGen.string.disabled);
            p2.setSummary(getApplicationContext().getString(IDGen.string.disableoption,"undef"));
            p3.setSummary(getApplicationContext().getString(IDGen.string.disableoption,"undef"));
            p1.setTitle(IDGen.string.tabsbg);
            p1.setSummary(IDGen.string.tabsbgsum);
        }
    }
}
