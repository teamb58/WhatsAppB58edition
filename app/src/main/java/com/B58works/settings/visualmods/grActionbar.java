package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

/**
 * Created by Bharath.R(58) on 20-01-2019.
 */

public class grActionbar extends Superpref {

    SwitchPreference p;
    Preference p1;
    Preference p2;
    ListPreference p3;

    public void init()
    {
        p3=(ListPreference) findPreference("ActionbarColoror");
        p2=findPreference("ActionbarColorgr");
        p1=findPreference("ActionbarColor");
        p=(SwitchPreference) findPreference("actionbargr");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vgractionbar);
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
        onStart();
    }

    private void b58()
    {
        p.setTitle(IDGen.string.enablegr);
        if(p.isChecked())
        {
            p2.setEnabled(true);
            p3.setEnabled(true);
            p1.setTitle(IDGen.string.startcolor);
            p1.setSummary(IDGen.string.univactionbarstartsum);
            p2.setTitle(IDGen.string.endcolor);
            p2.setSummary(IDGen.string.univactionbarendsum);
            p3.setTitle(IDGen.string.gradient);
            p3.setEntries(IDGen.array.gr_style);
            p3.setEntryValues(IDGen.array.actionbarStyleListValues);
            p3.setDefaultValue("0");
            p3.setSummary(IDGen.string.grstyle);
        }
        else
        {
            p2.setEnabled(false);
            p3.setEnabled(false);
            p2.setTitle(IDGen.string.disabled);
            p3.setTitle(IDGen.string.disabled);
            p2.setSummary(getString(IDGen.string.disableoption,"2.1.1"));
            p3.setSummary(getString(IDGen.string.disableoption,"2.1.1"));
            p1.setTitle(IDGen.string.univactionbar);
            p1.setSummary(IDGen.string.univactionbarsum);
        }
    }
}
