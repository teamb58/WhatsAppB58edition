package com.B58works.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import com.B58works.B58;
import com.B58works.SeekBarPreference;

import d.f.cz;
import static com.B58works.B58.prefEdit;

public class Superpref extends cz implements SharedPreferences.OnSharedPreferenceChangeListener{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        this.getPreferenceManager().setSharedPreferencesName("B58");
    }

    public void onPause() {
        super.onPause();
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    protected void onStart()
    {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        final PreferenceScreen preferenceScreen = this.getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        /*for (int i = 0; i < preferenceScreen.getPreferenceCount(); ++i) {
            final Preference preference = preferenceScreen.getPreference(i);
            final String key = preference.getKey();
            if (preference instanceof ListPreference) {
                ((ListPreference)preference).setValue(ctx.getSharedPreferences("com.whatsapp_preferences",0).getString(key, null));
            }
            else if (preference instanceof TwoStatePreference) {
                ((TwoStatePreference)preference).setChecked(ctx.getSharedPreferences("B58",0).getBoolean(key, false));
            }
            else if (preference instanceof SeekBarPreference) {
                final SeekBarPreference seekBarPreference = (SeekBarPreference)preference;
                seekBarPreference.setmyVal(ctx.getSharedPreferences("com.whatsapp_preferences",0).getInt(key, seekBarPreference.getdef()));
            }
        }*/

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference p=findPreference(s);
        if(p!=null)
        {
            String key=p.getKey();
            if(p instanceof SwitchPreference)
                prefEdit.putBoolean(key, ((SwitchPreference)p).isChecked()).apply();
            else if(p instanceof SeekBarPreference)
                B58.ctx.getSharedPreferences("com.whatsapp_preferences",0).edit().putInt(key, ((SeekBarPreference)p).myVal()).apply();
            else if(p instanceof ListPreference)
                prefEdit.putString(key, ((ListPreference)p).getValue()).apply();
        }
        onStart();
    }
}
