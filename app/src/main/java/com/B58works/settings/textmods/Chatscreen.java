package com.B58works.settings.textmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.SwitchPreference;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;



public class Chatscreen extends Superpref{

    SwitchPreference p31,p32,p33,p34,p35,p36,p37;

    public void init()
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
        addPreferencesFromResource(IDGen.xml.tchat);
        init();
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
        p31.setTitle(IDGen.string.hidedt);
        p31.setSummaryOn(getString(IDGen.string.hidedtsum,getString(IDGen.string.swhides)));
        p31.setSummaryOff(getString(IDGen.string.hidedtsum,getString(IDGen.string.swshows)));
        p32.setTitle(IDGen.string.txtselect);
        p32.setSummaryOn(getString(IDGen.string.txtselectsum,getString(IDGen.string.swshows)));
        p32.setSummaryOff(getString(IDGen.string.txtselectsum,getString(IDGen.string.swhides)));
        p33.setTitle(IDGen.string.callbtn);
        p33.setSummaryOn(getString(IDGen.string.callbtnsum,getString(IDGen.string.swhides)));
        p33.setSummaryOff(getString(IDGen.string.callbtnsum,getString(IDGen.string.swshows)));
        p34.setTitle(IDGen.string.profpic);
        p34.setSummaryOn(getString(IDGen.string.profpicsum,getString(IDGen.string.swhides)));
        p34.setSummaryOff(getString(IDGen.string.profpicsum,getString(IDGen.string.swshows)));
        p35.setTitle(IDGen.string.gifchoose);
        p35.setSummaryOn(IDGen.string.giftenor);
        p35.setSummaryOff(IDGen.string.gifgiphy);
        p36.setTitle(IDGen.string.chatstatus);
        p36.setSummaryOn(getString(IDGen.string.chatstatussum,getString(IDGen.string.swshows)));
        p36.setSummaryOff(getString(IDGen.string.chatstatussum,getString(IDGen.string.swhides)));
        p37.setTitle(IDGen.string.centeraction);
        p37.setSummaryOn(getString(IDGen.string.centeractionsum,getString(IDGen.string.swshows)));
        p37.setSummaryOff(getString(IDGen.string.centeractionsum,getString(IDGen.string.swhides)));
    }

}
