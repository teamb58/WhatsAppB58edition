package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.SwitchPreference;

import com.B58works.R;
import com.B58works.settings.Superpref;

public class Homescreen extends Superpref{

    SwitchPreference p21,p22,p23,p25,p26,p27,p28;
    ListPreference p24;

    public Homescreen()
    {
        p21=(SwitchPreference)findPreference("oldui");
        p22=(SwitchPreference)findPreference("lsmain");
        p23=(SwitchPreference)findPreference("actbartitle");
        p24=(ListPreference)findPreference("actbarsubtitle");
        p25=(SwitchPreference)findPreference("archvchat");
        p26=(SwitchPreference)findPreference("onlinetoast");
        p27=(SwitchPreference)findPreference("hidemsg");
        p28=(SwitchPreference)findPreference("hidename");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.thome);
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
        p21.setTitle(R.string.oldui);
        p21.setSummaryOn(getString(R.string.olduisum,getString(R.string.swhides)));
        p21.setSummaryOff(getString(R.string.olduisum,getString(R.string.swshows)));
        p22.setTitle(R.string.lsmain);
        p22.setSummaryOn(getString(R.string.lsmainsum,getString(R.string.swshows)));
        p22.setSummaryOff(getString(R.string.lsmainsum,getString(R.string.swhides)));
        p23.setTitle(R.string.actbartitle);
        p23.setSummaryOn(getString(R.string.actbartitlesum,getString(R.string.swshows)));
        p23.setSummaryOff(getString(R.string.actbartitlesum,getString(R.string.swhides)));
        p24.setTitle(R.string.actbarsubtitle);
        p24.setEntries(R.array.subtitile_names);
        p24.setDefaultValue("0");
        p24.setEntryValues(R.array.subtitle_values);
        p25.setTitle(R.string.archvchat);
        p25.setSummaryOn(getString(R.string.archvchatsum,getString(R.string.swhides)));
        p25.setSummaryOff(getString(R.string.archvchatsum,getString(R.string.swshows)));
        p26.setTitle(R.string.onlinetoast);
        p26.setSummaryOn(getString(R.string.onlinetoastsum,getString(R.string.swshows)));
        p26.setSummaryOff(getString(R.string.onlinetoastsum,getString(R.string.swhides)));
        p27.setTitle(R.string.hidemsg);
        p27.setSummaryOn(getString(R.string.hidemsgsum,getString(R.string.swhides)));
        p27.setSummaryOff(getString(R.string.hidemsgsum,getString(R.string.swshows)));
        p28.setTitle(R.string.hidename);
        p28.setSummaryOn(getString(R.string.hidenamesum,getString(R.string.swhides)));
        p28.setSummaryOff(getString(R.string.hidenamesum,getString(R.string.swshows)));
    }
}
