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

import com.B58works.extra.*;

import java.io.File;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class pass extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{
    public static Context con;
    public static String path;
    public SharedPreferences.Editor editor;

    static {
        pass.path = Environment.getExternalStorageDirectory() + "/WhatsApp/B58works/lockw.png";
    }

    public pass() {
        this.editor = null;
    }

    private void a(final Preference preference) {
        if (preference != null) {
            final String key = preference.getKey();
            if (preference instanceof ListPreference) {
                this.editor.putString(key, ((ListPreference)preference).getValue());
                this.editor.commit();
            }
            else if (preference instanceof EditTextPreference) {
                preference.setSummary((CharSequence)((EditTextPreference)preference).getText());
            }
            else if (preference instanceof CheckBoxPreference) {
                this.editor.putBoolean(key, ((CheckBoxPreference)preference).isChecked());
                this.editor.commit();
            }
        }
    }

    public static Drawable getWall() {
        new File(pass.path);
        return B58.ctx.getResources().getDrawable(B58.getResID("lockw", "drawable"));
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        pass.con = B58.ctx;
        this.editor = B58.ctx.getSharedPreferences("B58", 0).edit();
        this.addPreferencesFromResource(B58.getResID("B58_lock", "xml"));
        final Preference preference = this.findPreference((CharSequence)"lockC");
        final Preference preference2 = this.findPreference((CharSequence)"patternC");
        preference.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)new bs(this));
        preference2.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)new bt(this));
    }

    protected void onPause() {
        super.onPause();
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)this);
    }

    protected void onResume() {
        super.onResume();
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)this);
    }

    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String s) {
        this.a(this.findPreference((CharSequence)s));
    }
}

