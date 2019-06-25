package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.SwitchPreference;

import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.SeekBarPreference;
import com.B58works.settings.Superpref;

public class Mediamods extends Superpref{

    SeekBarPreference p41,p42,p43,p44,p45,p46;
    SwitchPreference p47,p48;

    public void init()
    {
        p41=(SeekBarPreference) findPreference("status_image_quality");
        p42=(SeekBarPreference) findPreference("status_image_max_edge");
        p43=(SeekBarPreference) findPreference("status_video_max_duration");
        p44=(SeekBarPreference) findPreference("image_max_kbytes");
        p45=(SeekBarPreference) findPreference("image_quality");
        p46=(SeekBarPreference) findPreference("image_max_edge");
        p47=(SwitchPreference) findPreference("Audio_sensor");
        p48=(SwitchPreference) findPreference("Audio_ears");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.tmedia);
        init();
        this.getPreferenceManager().setSharedPreferencesName("com.whatsapp_preferences");
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
        b58();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
        onStart();
    }

    private void b58()
    {
        p41.setTitle(IDGen.string.statusquality);
        p42.setTitle(IDGen.string.statusimg);
        p43.setTitle(IDGen.string.statusduration);
        p44.setTitle(IDGen.string.imgsize);
        p45.setTitle(IDGen.string.imgquality);
        p46.setTitle(IDGen.string.imgresolution);
        p47.setTitle(IDGen.string.mediaprox);
        p48.setTitle(IDGen.string.mediaopswitch);
        p48.setDependency(p47.getKey());
    }
}
