package com.B58works.settings.visualmods;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.B58works.B58;
import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.nc;

import static com.B58works.B58.getResID;
import static com.B58works.settings.visualmods.Settings.sContext;

public class Fabscreen extends nc  implements SharedPreferences.OnSharedPreferenceChangeListener,Preference.OnPreferenceClickListener{

    public SharedPreferences.Editor editor;

    public boolean onPreferenceClick(Preference preference) {
        return false;
    }



    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.addPreferencesFromResource(getResID( "vfab", "xml"));
        if (sContext == null)
            sContext = getBaseContext();
        this.editor = sContext.getSharedPreferences("B58", 0).edit();
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
        updatePrefSummary(findPreference(paramString));
    }

    private void updatePrefSummary(final Preference preference) {
        if (preference != null) {
            final String key = preference.getKey();
            if (preference instanceof ListPreference) {
                this.editor.putString(key, ((ListPreference)preference).getValue());
                this.editor.commit();
            }
            else if (preference instanceof EditTextPreference) {
                preference.setSummary(((EditTextPreference)preference).getText());
            }
            else if (preference instanceof TwoStatePreference) {
                this.editor.putBoolean(key, ((TwoStatePreference)preference).isChecked());
                this.editor.commit();
            }
        }
    }
}
