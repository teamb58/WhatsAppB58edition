package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.SwitchPreference;

import com.B58works.R;
import com.B58works.settings.Superpref;



public class Chatscreen extends Superpref{

    SwitchPreference p31,p32,p33,p34,p35,p36,p37;

    public Chatscreen()
    {
        p31=(SwitchPreference)findPreference("hideinfo");
        p32=(SwitchPreference)findPreference("txtselect");
        p33=(SwitchPreference)findPreference("callbtn");
        p34=(SwitchPreference)findPreference("profpic");
        p35=(SwitchPreference)findPreference("gifchoose");
        p36=(SwitchPreference)findPreference("chatstatus");
        p37=(SwitchPreference)findPreference("centeraction");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.tchat);
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
        p31.setTitle(R.string.hidedt);
        p31.setSummaryOn(getString(R.string.hidedtsum,getString(R.string.swhides)));
        p31.setSummaryOff(getString(R.string.hidedtsum,getString(R.string.swshows)));
        p32.setTitle(R.string.txtselect);
        p32.setSummaryOn(getString(R.string.txtselectsum,getString(R.string.swshows)));
        p32.setSummaryOff(getString(R.string.txtselectsum,getString(R.string.swhides)));
        p33.setTitle(R.string.callbtn);
        p33.setSummaryOn(getString(R.string.callbtnsum,getString(R.string.swhides)));
        p33.setSummaryOff(getString(R.string.callbtnsum,getString(R.string.swshows)));
        p34.setTitle(R.string.profpic);
        p34.setSummaryOn(getString(R.string.profpicsum,getString(R.string.swhides)));
        p34.setSummaryOff(getString(R.string.profpicsum,getString(R.string.swshows)));
        p35.setTitle(R.string.gifchoose);
        p35.setSummaryOn(R.string.giftenor);
        p35.setSummaryOff(R.string.gifgiphy);
        p36.setTitle(R.string.chatstatus);
        p36.setSummaryOn(getString(R.string.chatstatussum,getString(R.string.swshows)));
        p36.setSummaryOff(getString(R.string.chatstatussum,getString(R.string.swhides)));
        p37.setTitle(R.string.centeraction);
        p37.setSummaryOn(getString(R.string.centeractionsum,getString(R.string.swshows)));
        p37.setSummaryOff(getString(R.string.centeractionsum,getString(R.string.swhides)));
    }

}
