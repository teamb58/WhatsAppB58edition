package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;


public class Universal extends Superpref{

    Preference p,p4,p5,p6;

    public void init()
    {
        p=this.findPreference("actionbar");
        p4=findPreference("ActionbartextColor");
        p5=findPreference("StatusbarColor");
        p6=findPreference("NavbarColor");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vuniversal);
        init();
        b58();
        p.setTitle(IDGen.string.actionbarc);
        p.setSummary(IDGen.string.actionbarcsum);
        p4.setTitle(IDGen.string.univactionbartext);
        p4.setSummary(IDGen.string.univactionbartextsum);
        p5.setTitle(IDGen.string.univstatusbar);
        p5.setSummary(IDGen.string.univstatusbarsum);
        p6.setTitle(IDGen.string.univnavbar);
        p6.setSummary(IDGen.string.univnavbarsum);
    }

    protected void onStart()
    {
        super.onStart();
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
        p.setIntent(new Intent(getApplicationContext(),grActionbar.class));
    }
}
