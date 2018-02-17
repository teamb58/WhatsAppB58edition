package com.B58works;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.TwoStatePreference;

import com.whatsapp.oy;
import com.whatsapp.ph;

public class Settings extends ph implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener {
    public static Context sContext;
    static Context sctx;
    public static String url;
    public SharedPreferences.Editor editor;

    static {
        Settings.sContext = null;
        Settings.url = null;
    }

    public Settings() {
        this.editor = null;
    }

    public static int getResID(final String s, final String s2) {
        return Settings.sContext.getResources().getIdentifier(s, s2, Settings.sContext.getPackageName());
    }


    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (sContext == null)
            sContext = getBaseContext();
        addPreferencesFromResource(getResID("B58_settings", "xml"));
        this.editor = sContext.getSharedPreferences("B58", 0).edit();
        findPreference("B58privacy").setOnPreferenceClickListener(this);
        findPreference("clear_logs").setOnPreferenceClickListener(this);
        findPreference("pass").setOnPreferenceClickListener(this);
        findPreference("save_temp").setOnPreferenceClickListener(this);
        findPreference("load_pref_file").setOnPreferenceClickListener(this);
        findPreference("clear_pref_file").setOnPreferenceClickListener(this);
        findPreference("download").setOnPreferenceClickListener(this);
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public boolean onPreferenceClick(final Preference preference) {
        if (preference.getKey().equals("clear_logs")) {
            B58.ClearLogs((Context) this);
        } else if (preference.getKey().equals("B58privacy")) {
            final Intent intent = new Intent(this.getBaseContext(), (Class) Privacy.class);
            final Context baseContext = this.getBaseContext();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            baseContext.startActivity(intent);
        } else if (preference.getKey().equals("pass")) {
            final Intent intent2 = new Intent(this.getBaseContext(), (Class) pass.class);
            final Context baseContext2 = this.getBaseContext();
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            baseContext2.startActivity(intent2);
        } else if (preference.getKey().equals("save_temp")) {
            B58.DialogSaveTheme((Activity) this);
        } else if (preference.getKey().equals("load_pref_file")) {
            B58.LoadTheme((Activity) this);
        } else if (preference.getKey().equals("clear_pref_file")) {
            B58.ClearTheme((Activity) this);
        } else if (preference.getKey().equals("download")) {
            B58.DownloadTheme((Activity) this);
        }
        return true;
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
