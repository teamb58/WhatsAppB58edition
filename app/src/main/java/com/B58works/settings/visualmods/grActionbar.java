package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

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

    public grActionbar()
    {
        p3=(ListPreference) findPreference("ActionbarColoror");
        p2=findPreference("ActionbarColorgr");
        p1=findPreference("ActionbarColor");
        p=(SwitchPreference) findPreference("actionbargr");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.vgractionbar);
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
        p.setTitle(R.string.enablegr);
        if(p.isChecked())
        {
            p2.setEnabled(true);
            p3.setEnabled(true);
            p1.setTitle(R.string.startcolor);
            p1.setSummary(R.string.univactionbarstartsum);
            p2.setTitle(R.string.endcolor);
            p2.setSummary(R.string.univactionbarendsum);
            p3.setTitle(R.string.gradient);
            p3.setEntries(R.array.gr_style);
            p3.setEntryValues(R.array.actionbarStyleListValues);
            p3.setDefaultValue("0");
            p3.setSummary(R.string.grstyle);
        }
        else
        {
            p2.setEnabled(false);
            p3.setEnabled(false);
            p2.setTitle(R.string.disabled);
            p3.setTitle(R.string.disabled);
            p2.setSummary(getApplicationContext().getString(R.string.disableoption,"undef"));
            p3.setSummary(getApplicationContext().getString(R.string.disableoption,"undef"));
            p1.setTitle(R.string.univactionbar);
            p1.setSummary(R.string.univactionbarsum);
        }
    }
}
