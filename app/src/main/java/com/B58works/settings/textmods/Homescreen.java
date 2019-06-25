package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.SwitchPreference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

public class Homescreen extends Superpref{

    SwitchPreference p21,p22,p23,p25,p26,p27,p28;
    ListPreference p24;

    public void init()
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
        addPreferencesFromResource(IDGen.xml.thome);
        init();
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
        p21.setTitle(IDGen.string.oldui);
        p21.setSummaryOn(getString(IDGen.string.olduisum,getString(IDGen.string.swhides)));
        p21.setSummaryOff(getString(IDGen.string.olduisum,getString(IDGen.string.swshows)));
        p22.setTitle(IDGen.string.lsmain);
        p22.setSummaryOn(getString(IDGen.string.lsmainsum,getString(IDGen.string.swshows)));
        p22.setSummaryOff(getString(IDGen.string.lsmainsum,getString(IDGen.string.swhides)));
        p23.setTitle(IDGen.string.actbartitle);
        p23.setSummaryOn(getString(IDGen.string.actbartitlesum,getString(IDGen.string.swshows)));
        p23.setSummaryOff(getString(IDGen.string.actbartitlesum,getString(IDGen.string.swhides)));
        p24.setTitle(IDGen.string.actbarsubtitle);
        p24.setEntries(IDGen.array.subtitile_names);
        p24.setDefaultValue("0");
        p24.setEntryValues(IDGen.array.subtitle_values);
        p25.setTitle(IDGen.string.archvchat);
        p25.setSummaryOn(getString(IDGen.string.archvchatsum,getString(IDGen.string.swhides)));
        p25.setSummaryOff(getString(IDGen.string.archvchatsum,getString(IDGen.string.swshows)));
        p26.setTitle(IDGen.string.onlinetoast);
        p26.setSummaryOn(getString(IDGen.string.onlinetoastsum,getString(IDGen.string.swshows)));
        p26.setSummaryOff(getString(IDGen.string.onlinetoastsum,getString(IDGen.string.swhides)));
        p27.setTitle(IDGen.string.hidemsg);
        p27.setSummaryOn(getString(IDGen.string.hidemsgsum,getString(IDGen.string.swhides)));
        p27.setSummaryOff(getString(IDGen.string.hidemsgsum,getString(IDGen.string.swshows)));
        p28.setTitle(IDGen.string.hidename);
        p28.setSummaryOn(getString(IDGen.string.hidenamesum,getString(IDGen.string.swhides)));
        p28.setSummaryOff(getString(IDGen.string.hidenamesum,getString(IDGen.string.swshows)));
    }
}
