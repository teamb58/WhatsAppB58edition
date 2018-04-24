package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.TwoStatePreference;

import com.B58works.B58;
import com.whatsapp.nc;

import static com.B58works.settings.visualmods.Settings.sContext;


public class Chatscreen extends nc  implements SharedPreferences.OnSharedPreferenceChangeListener,Preference.OnPreferenceClickListener{

    public SharedPreferences.Editor editor;

    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vchat", "xml"));
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
