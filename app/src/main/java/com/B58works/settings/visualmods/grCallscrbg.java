package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.SwitchPreference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

public class grCallscrbg extends Superpref {

    SwitchPreference p;
    SwitchPreference p361;
    Preference p362;
    Preference p363;
    ListPreference p364;
    SwitchPreference p365;
    SwitchPreference p366;
    Preference p367;
    Preference p368;
    ListPreference p369;

    public void init()
    {
        p=(SwitchPreference)findPreference("callfullbg");
        p361=(SwitchPreference)findPreference("callscrbggren");
        p362=findPreference("callscrbg");
        p363=findPreference("callscrbggr");
        p364=(ListPreference) findPreference("callscrbgor");
        p365=(SwitchPreference)findPreference("callscrbgalten") ;
        p366=(SwitchPreference)findPreference("callscrbggralten");
        p367=findPreference("callscraltbg");
        p368=findPreference("callscraltbggr");
        p369=(ListPreference)findPreference("callscraltbgor");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vgrcallscr);
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
        p.setTitle(IDGen.string.callsinglebg);
        p.setSummary(IDGen.string.callsinglebgsum);
        p361.setTitle(IDGen.string.enablegr);
        p361.setSummary(IDGen.string.enablegrsum);
        p365.setTitle(IDGen.string.altrows);
        p365.setSummary(IDGen.string.altrowsbg);
        if(p.isChecked())
        {
            p365.setEnabled(true);
            p366.setEnabled(true);
            p367.setEnabled(true);
            p368.setEnabled(true);
            p369.setEnabled(true);
            mainrow();
            if(p365.isChecked())
            {
                p366.setTitle(IDGen.string.callsaltbggr);
                p366.setSummary(IDGen.string.callsaltbggrsum);
                altrow();
            }
            else
            {
                p366.setTitle(IDGen.string.disabled);
                p366.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.5"));
                p368.setTitle(IDGen.string.disabled);
                p368.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.5"));
                p369.setTitle(IDGen.string.disabled);
                p369.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.5"));
                p367.setTitle(IDGen.string.disabled);
                p367.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.5"));
                p368.setEnabled(false);
                p369.setEnabled(false);
                p367.setEnabled(false);
                p366.setEnabled(false);
            }
        }
        else
        {
            mainbg();
            p365.setEnabled(false);
            p366.setEnabled(false);
            p367.setEnabled(false);
            p368.setEnabled(false);
            p369.setEnabled(false);
            p365.setTitle(IDGen.string.disabled);
            p365.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.0"));
            p366.setTitle(IDGen.string.disabled);
            p366.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.0"));
            p367.setTitle(IDGen.string.disabled);
            p367.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.0"));
            p368.setTitle(IDGen.string.disabled);
            p368.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.0"));
            p369.setTitle(IDGen.string.disabled);
            p369.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.0"));
        }
    }

    private void mainbg()
    {
        if(p361.isChecked())
        {
            p362.setTitle(IDGen.string.startcolor);
            p362.setSummary(IDGen.string.callsfsbgstartsum);
            p363.setTitle(IDGen.string.endcolor);
            p363.setSummary(IDGen.string.callsfsbgendsum);
            p364.setTitle(IDGen.string.gradient);
            p364.setEntries(IDGen.array.gr_style);
            p364.setEntryValues(IDGen.array.actionbarStyleListValues);
            p364.setDefaultValue("0");
            p364.setSummary(IDGen.string.grstyle);
            p363.setEnabled(true);
            p364.setEnabled(true);
        }
        else
        {
            p362.setTitle(IDGen.string.callsscrbg);
            p362.setSummary(IDGen.string.callsscrfsbgsum);
            p363.setTitle(IDGen.string.disabled);
            p363.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.1"));
            p364.setTitle(IDGen.string.disabled);
            p364.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.1"));
            p363.setEnabled(false);
            p364.setEnabled(false);
        }
    }

    private void mainrow()
    {
        if(p361.isChecked())
        {
            p362.setTitle(IDGen.string.startcolor);
            p362.setSummary(IDGen.string.callsbgstartsum);
            p363.setTitle(IDGen.string.endcolor);
            p363.setSummary(IDGen.string.callsbgendsum);
            p364.setTitle(IDGen.string.gradient);
            p364.setEntries(IDGen.array.gr_style);
            p364.setEntryValues(IDGen.array.actionbarStyleListValues);
            p364.setDefaultValue("0");
            p364.setSummary(IDGen.string.grstyle);
            p363.setEnabled(true);
            p364.setEnabled(true);
        }
        else
        {
            p362.setTitle(IDGen.string.callsscrbg);
            p362.setSummary(IDGen.string.callsscrbgsum);
            p363.setTitle(IDGen.string.disabled);
            p363.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.1"));
            p364.setTitle(IDGen.string.disabled);
            p364.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.1"));
            p363.setEnabled(false);
            p364.setEnabled(false);
        }
    }

    private void altrow()
    {
        if(p366.isChecked())
        {
            p367.setTitle(IDGen.string.startcolor);
            p367.setSummary(IDGen.string.callsaltbgstartsum);
            p368.setTitle(IDGen.string.endcolor);
            p368.setSummary(IDGen.string.callsaltbgendsum);
            p369.setTitle(IDGen.string.gradient);
            p369.setEntries(IDGen.array.gr_style);
            p369.setEntryValues(IDGen.array.actionbarStyleListValues);
            p369.setDefaultValue("0");
            p369.setSummary(IDGen.string.grstyle);
            p368.setEnabled(true);
            p369.setEnabled(true);
        }
        else
        {
            p367.setTitle(IDGen.string.callsscraltbg);
            p367.setSummary(IDGen.string.callsscraltbgsum);
            p368.setTitle(IDGen.string.disabled);
            p368.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.6"));
            p369.setTitle(IDGen.string.disabled);
            p369.setSummary(getApplicationContext().getString(IDGen.string.enableoption,"3.6.6"));
            p368.setEnabled(false);
            p369.setEnabled(false);
        }
    }
}
