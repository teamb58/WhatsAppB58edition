package com.B58works.settings.textmods;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;


import com.B58works.B58;
import com.B58works.R;
import com.B58works.settings.Superpref;
import com.whatsapp.plus.ReadLogFile;

import java.io.IOException;


public class Logscreen extends Superpref implements Preference.OnPreferenceClickListener {

    Preference p51,p52;

    public Logscreen()
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
        addPreferencesFromResource(R.xml.tlog);
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
        p51.setTitle(R.string.openlog);
        p52.setTitle(R.string.clearlog);
        //p51.setIntent(new Intent(this, ReadLogFile.class));
    }

}
