package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.SwitchPreference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

public class grConpickbg extends Superpref {

    SwitchPreference p;
    Preference p1;
    Preference p2;
    ListPreference p3;

    public void init()
    {
        p=(SwitchPreference) findPreference("conpickbggr");
        p1=findPreference("conpickbgColor");
        p2=findPreference("conpickbgColorgr");
        p3=(ListPreference) findPreference("conpickbgColoror");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vgrconpickbg);
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
        p.setTitle(IDGen.string.enablegr);
        p.setSummary(IDGen.string.enablegrsum);
        if(p.isChecked())
        {
            p2.setEnabled(true);
            p3.setEnabled(true);
            p1.setTitle(IDGen.string.startcolor);
            p1.setSummary(IDGen.string.conpickbgstartsum);
            p2.setTitle(IDGen.string.endcolor);
            p2.setSummary(IDGen.string.conpickbgendsum);
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
            p2.setSummary(getApplicationContext().getString(IDGen.string.disableoption,"4.20.0"));
            p3.setSummary(getApplicationContext().getString(IDGen.string.disableoption,"4.20.0"));
            p1.setTitle(IDGen.string.conpickbg);
            p1.setSummary(IDGen.string.conpickbgsum);
        }
    }
}
