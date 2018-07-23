package com.B58works.settings.textmods;

import android.os.Bundle;
import android.preference.Preference;


import com.B58works.B58;
import com.B58works.settings.Superpref;


public class Logscreen extends Superpref{

    public boolean onPreferenceClick(Preference preference) {
        if (preference.getKey().equals("clear_logs")) {
            B58.ClearLogs(this);
        }
        return true;
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("tlog", "xml"));
        findPreference("clear_logs").setOnPreferenceClickListener(this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
