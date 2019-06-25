package com.B58works.settings.textmods;

import android.os.Bundle;
import android.preference.Preference;


import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.settings.Superpref;

import java.io.IOException;


public class Logscreen extends Superpref implements Preference.OnPreferenceClickListener {

    Preference p51,p52;

    public void init()
    {
        p51=findPreference("openlog");
        p52=findPreference("clear_logs");
    }

    public boolean onPreferenceClick(Preference preference) {
        if (preference.equals(p52)) {
            try {
                B58.ClearLogs(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.tlog);
        init();
        b58();
        findPreference("clear_logs").setOnPreferenceClickListener(this);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    private void b58()
    {
        p51.setTitle(IDGen.string.openlog);
        p52.setTitle(IDGen.string.clearlog);
        //p51.setIntent(new Intent(this, ReadLogFile.class));
    }

}
