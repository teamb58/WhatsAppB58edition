package com.B58works.settings.textmods;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.TwoStatePreference;
import android.widget.Toast;

import com.B58works.B58;
import com.B58works.Privacy;
import com.B58works.pass;
import com.whatsapp.nc;

import static com.B58works.B58.getBoolean;

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
            n = B58.getResID("text_settingsads", "xml");
        }
        else {
            n = B58.getResID("text_settings", "xml");
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
        findPreference("tprivacy").setOnPreferenceClickListener(this);
        findPreference("thome").setOnPreferenceClickListener(this);
        findPreference("tchat").setOnPreferenceClickListener(this);
        findPreference("tmedia").setOnPreferenceClickListener(this);
        findPreference("tlog").setOnPreferenceClickListener(this);
        findPreference("tpass").setOnPreferenceClickListener(this);
        findPreference("tchoosers").setOnPreferenceClickListener(this);

    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public boolean onPreferenceClick(final Preference preference) {
        switch (preference.getKey()) {
            case "tprivacy":
                final Intent intent = new Intent(this.getBaseContext(), Privacy.class);
                final Context baseContext = this.getBaseContext();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext.startActivity(intent);
                break;
            case "tpass": {
                final Intent intent2 = new Intent(this.getBaseContext(), pass.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "thome": {
                final Intent intent2 = new Intent(this.getBaseContext(), Homescreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "tchat": {
                final Intent intent2 = new Intent(this.getBaseContext(), Chatscreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "tmedia": {
                final Intent intent2 = new Intent(this.getBaseContext(), Mediamods.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "tlog": {
                final Intent intent2 = new Intent(this.getBaseContext(), Logscreen.class);
                final Context baseContext2 = this.getBaseContext();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                baseContext2.startActivity(intent2);
                break;
            }
            case "tchoosers": {
                final Intent intent2 = new Intent(this.getBaseContext(), Choosers.class);
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
