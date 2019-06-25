package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.Toast;

import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;

public class Themescreen extends Superpref implements Preference.OnPreferenceClickListener {

    Preference p101,p102,p103,p104;

    public void init()
    {
        p101=findPreference("save_temp");
        p102=findPreference("load_pref_file");
        p103=findPreference("clear_pref_file");
        p104=findPreference("download");
    }

    public boolean onPreferenceClick(final Preference preference) {
        switch (preference.getKey()) {
            case "save_temp":
                B58.DialogSaveTheme(this);
                break;
            case "load_pref_file":
                B58.LoadTheme(this);
                //Toast.makeText(this,"Work in progress",Toast.LENGTH_SHORT).show();
                break;
            case "clear_pref_file":
                B58.ClearTheme();
                break;
            case "download":
                B58.DownloadTheme(this);
                break;
        }
        return true;
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vtheme);b58();
        init();
        this.getPreferenceManager().setSharedPreferencesName("B58");
        p101.setOnPreferenceClickListener(this);
        p102.setOnPreferenceClickListener(this);
        p103.setOnPreferenceClickListener(this);
        p104.setOnPreferenceClickListener(this);

    }

    public void onPause() {
        super.onPause();
    }

    public void onResume(){super.onResume();}

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }

    private void b58()
    {
        p101.setTitle(IDGen.string.savetheme);
        p101.setSummary(IDGen.string.savethemesum);
        p102.setTitle(IDGen.string.loadtheme);
        p102.setSummary(IDGen.string.loadthemesum);
        p103.setTitle(IDGen.string.cleartheme);
        p103.setSummary(IDGen.string.clearthemesum);
        p104.setTitle(IDGen.string.downloadtheme);
        p104.setSummary(IDGen.string.downloadthemesum);
    }
}
