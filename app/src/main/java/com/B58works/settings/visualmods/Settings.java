package com.B58works.settings.visualmods;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.B58works.B58;
import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.nc;

import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getResID;

public class Settings extends nc implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener {
    public static Context sContext;
    public static Context sctx;
    public SharedPreferences.Editor editor;

    static {
        sContext = null;
    }

    public Settings() {
        this.editor = null;
    }

    public static void Backpress() {
        Toast.makeText(B58.ctx, "Please Restart WhatsApp for the changes to take place if you have made any.", Toast.LENGTH_LONG).show();
    }

    public static int ads() {
        int n;
        if (getBoolean("support")) {
            n = B58.getResID("visual_settingsads", "xml");
        }
        else {
            n = B58.getResID("visual_settings", "xml");
        }
        return n;
    }

    public static int getResID(final String s, final String s2) {
        return sContext.getResources().getIdentifier(s, s2, sContext.getPackageName());
    }

    public void onBackPressed() {
        super.onBackPressed();
        Backpress();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (sContext == null)
            sContext = getBaseContext();
        addPreferencesFromResource(ads());
        this.editor = sContext.getSharedPreferences("B58", 0).edit();
        findPreference("vfab").setOnPreferenceClickListener(this);
        findPreference("vhome").setOnPreferenceClickListener(this);
        findPreference("vchat").setOnPreferenceClickListener(this);
        findPreference("vthemes").setOnPreferenceClickListener(this);
        findPreference("vuniversal").setOnPreferenceClickListener(this);
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public boolean onPreferenceClick(final Preference preference) {
        switch (preference.getKey()) {
            case "vfab":
                final Intent intent = new Intent(this.getBaseContext(), Fabscreen.class);
                final Context baseContext = this.getBaseContext();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext.startActivity(intent);
                break;
            case "vhome": {
                final Intent intent2 = new Intent(this.getBaseContext(), com.B58works.settings.visualmods.Homescreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "vchat": {
                final Intent intent2 = new Intent(this.getBaseContext(), com.B58works.settings.visualmods.Chatscreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "vthemes": {
                final Intent intent2 = new Intent(this.getBaseContext(), Themescreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "vuniversal": {
                final Intent intent2 = new Intent(this.getBaseContext(), Universal.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
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
