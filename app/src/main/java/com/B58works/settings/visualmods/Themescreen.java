package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.Toast;

import com.B58works.B58;
import com.B58works.settings.Superpref;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getPrefString1;

public class Themescreen extends Superpref{

    public boolean onPreferenceClick(final Preference preference) {
        switch (preference.getKey()) {
            case "save_temp":
                B58.DialogSaveTheme(this);
                break;
            case "load_pref_file":
                B58.LoadTheme(this);
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

    private void cyo() {
        if(getPrefString1("file_type")==1)
        {
            SharedPreferences pref = B58.ctx.getSharedPreferences("B58", 0);
            pref.edit().remove("bubble_style").apply();
            pref.edit().remove("tick_style").apply();
        }
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vtheme", "xml"));
        this.getPreferenceManager().setSharedPreferencesName("B58");
        findPreference("save_temp").setOnPreferenceClickListener(this);
        findPreference("load_pref_file").setOnPreferenceClickListener(this);
        findPreference("clear_pref_file").setOnPreferenceClickListener(this);
        findPreference("download").setOnPreferenceClickListener(this);

    }

    public void onBackPressed()
    {
        super.onBackPressed();
        cyo();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume(){super.onResume();}

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }
}
