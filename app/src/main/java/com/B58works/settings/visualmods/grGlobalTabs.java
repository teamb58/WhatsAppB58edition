package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.B58works.R;
import com.B58works.settings.Superpref;

public class grGlobalTabs extends Superpref {

    Preference p;
    Preference p1;
    Preference p2;
    ListPreference p3;

    public grGlobalTabs()
    {
        p=findPreference("tabsbggr");
        p1=findPreference("tabsbgColor");
        p2=findPreference("tabsbgColorgr");
        p3=(ListPreference) findPreference("tabsbgColoror");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.vgrglobaltabs);
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
        p.setTitle(R.string.grfortabs);
        p.setSummary(R.string.grfortabssum);
        if(p.isEnabled())
        {
            p1.setTitle(R.string.startcolor);
            p1.setSummary(R.string.tabsbgstartsum);
            p2.setTitle(R.string.endcolor);
            p2.setSummary(R.string.tabsbgendsum);
            p3.setTitle(R.string.gradient);
            p3.setEntries(R.array.gr_style);
            p3.setEntryValues(R.array.actionbarStyleListValues);
            p3.setDefaultValue("0");
            p3.setSummary(R.string.grstyle);
        }
        else
        {
            p2.setTitle(R.string.disabled);
            p3.setTitle(R.string.disabled);
            p2.setSummary(getApplicationContext().getString(R.string.disableoption,"undef"));
            p3.setSummary(getApplicationContext().getString(R.string.disableoption,"undef"));
            p1.setTitle(R.string.tabsbg);
            p1.setSummary(R.string.tabsbgsum);
        }
    }
}
