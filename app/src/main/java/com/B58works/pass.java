package com.B58works;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.TwoStatePreference;

import com.B58works.extra.*;
import com.whatsapp.nc;

public class pass extends nc implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener
{
    public static Context con;
    public SharedPreferences.Editor editor;


    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    public pass() {
        this.editor = null;
    }

    public static Drawable getWall() {
        return B58.ctx.getResources().getDrawable(B58.getResID("lockw", "drawable"));
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        pass.con = B58.ctx;
        this.editor = B58.ctx.getSharedPreferences("B58", 0).edit();
        this.addPreferencesFromResource(B58.getResID("tlock", "xml"));
        final Preference preference = this.findPreference("lockC");
        final Preference preference2 = this.findPreference("patternC");
        preference.setOnPreferenceClickListener(new bs(this));
        preference2.setOnPreferenceClickListener(new bt(this));
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
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