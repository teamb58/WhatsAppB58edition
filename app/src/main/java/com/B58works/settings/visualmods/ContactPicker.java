package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.Preference;


import com.B58works.B58;
import com.B58works.R;
import com.B58works.settings.Superpref;


public class ContactPicker extends Superpref{

    Preference p601,p602,p603,p604;

    public ContactPicker()
    {
        p601=findPreference("conpickbg");
        p602=findPreference("conpickname");
        p603=findPreference("conpickstatus");
        p604=findPreference("conpicktype");
    }


    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.vconpick);
    }

    protected void onStart()
    {
        super.onStart();
        b581();b58();
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

    private void b581()
    {
        p601.setIntent(new Intent(getApplicationContext(),grConpickbg.class));
    }

    private void b58()
    {
        p601.setTitle(R.string.conpickgr);
        p601.setSummary(R.string.conpickgrsum);
        p602.setTitle(R.string.conpickname);
        p602.setSummary(R.string.conpicknamesum);
        p603.setTitle(R.string.conpickstatus);
        p603.setSummary(R.string.conpickstatussum);
        p604.setTitle(R.string.conpicktype);
        p604.setSummary(R.string.conpicktypesum);
    }
}

