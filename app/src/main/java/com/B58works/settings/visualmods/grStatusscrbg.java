package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.SwitchPreference;

import com.B58works.R;
import com.B58works.settings.Superpref;

public class grStatusscrbg extends Superpref {

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

    public grStatusscrbg()
    {
        p=(SwitchPreference)findPreference("statusfullbg");
        p361=(SwitchPreference)findPreference("statusscrbggren");
        p362=findPreference("statusscrbg");
        p363=findPreference("statusscrbggr");
        p364=(ListPreference) findPreference("statusscrbgor");
        p365=(SwitchPreference)findPreference("statusscrbgalten") ;
        p366=(SwitchPreference)findPreference("statusscrbggralten");
        p367=findPreference("statusscraltbg");
        p368=findPreference("statusscraltbggr");
        p369=(ListPreference)findPreference("statusscraltbgor");
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.vgrstatusscr);
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
        p.setTitle(R.string.statussinglebg);
        p.setSummary(R.string.statussinglebgsum);
        p361.setTitle(R.string.enablegr);
        p361.setSummary(R.string.enablegrsum);
        p365.setTitle(R.string.altrows);
        p365.setSummary(R.string.altrowsbg);
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
                p366.setTitle(R.string.statusaltbggr);
                p366.setSummary(R.string.statusaltbggrsum);
                altrow();
            }
            else
            {
                p366.setTitle(R.string.disabled);
                p366.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.5"));
                p368.setTitle(R.string.disabled);
                p368.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.5"));
                p369.setTitle(R.string.disabled);
                p369.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.5"));
                p367.setTitle(R.string.disabled);
                p367.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.5"));
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
            p365.setTitle(R.string.disabled);
            p365.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.0"));
            p366.setTitle(R.string.disabled);
            p366.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.0"));
            p367.setTitle(R.string.disabled);
            p367.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.0"));
            p368.setTitle(R.string.disabled);
            p368.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.0"));
            p369.setTitle(R.string.disabled);
            p369.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.0"));
        }
    }

    private void mainbg()
    {
        if(p361.isChecked())
        {
            p362.setTitle(R.string.startcolor);
            p362.setSummary(R.string.statussfsbgstartsum);
            p363.setTitle(R.string.endcolor);
            p363.setSummary(R.string.statussfsbgendsum);
            p364.setTitle(R.string.gradient);
            p364.setEntries(R.array.gr_style);
            p364.setEntryValues(R.array.actionbarStyleListValues);
            p364.setDefaultValue("0");
            p364.setSummary(R.string.grstyle);
            p363.setEnabled(true);
            p364.setEnabled(true);
        }
        else
        {
            p362.setTitle(R.string.statussscrbg);
            p362.setSummary(R.string.statussscrfsbgsum);
            p363.setTitle(R.string.disabled);
            p363.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.1"));
            p364.setTitle(R.string.disabled);
            p364.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.1"));
            p363.setEnabled(false);
            p364.setEnabled(false);
        }
    }

    private void mainrow()
    {
        if(p361.isChecked())
        {
            p362.setTitle(R.string.startcolor);
            p362.setSummary(R.string.statussbgstartsum);
            p363.setTitle(R.string.endcolor);
            p363.setSummary(R.string.statussbgendsum);
            p364.setTitle(R.string.gradient);
            p364.setEntries(R.array.gr_style);
            p364.setEntryValues(R.array.actionbarStyleListValues);
            p364.setDefaultValue("0");
            p364.setSummary(R.string.grstyle);
            p363.setEnabled(true);
            p364.setEnabled(true);
        }
        else
        {
            p362.setTitle(R.string.statussscrbg);
            p362.setSummary(R.string.statussscrbgsum);
            p363.setTitle(R.string.disabled);
            p363.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.1"));
            p364.setTitle(R.string.disabled);
            p364.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.1"));
            p363.setEnabled(false);
            p364.setEnabled(false);
        }
    }

    private void altrow()
    {
        if(p366.isChecked())
        {
            p367.setTitle(R.string.startcolor);
            p367.setSummary(R.string.statussaltbgstartsum);
            p368.setTitle(R.string.endcolor);
            p368.setSummary(R.string.statussaltbgendsum);
            p369.setTitle(R.string.gradient);
            p369.setEntries(R.array.gr_style);
            p369.setEntryValues(R.array.actionbarStyleListValues);
            p369.setDefaultValue("0");
            p369.setSummary(R.string.grstyle);
            p368.setEnabled(true);
            p369.setEnabled(true);
        }
        else
        {
            p367.setTitle(R.string.statussscraltbg);
            p367.setSummary(R.string.statussscraltbgsum);
            p368.setTitle(R.string.disabled);
            p368.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.6"));
            p369.setTitle(R.string.disabled);
            p369.setSummary(getApplicationContext().getString(R.string.enableoption,"3.6.6"));
            p368.setEnabled(false);
            p369.setEnabled(false);
        }
    }
}