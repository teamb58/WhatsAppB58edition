package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.widget.Toast;


import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.SeekBarPreference;
import com.B58works.settings.Superpref;



public class Homescreen extends Superpref{

    SwitchPreference p300;
    Preference p301;
    Preference p302;
    Preference p303;
    SeekBarPreference p304;
    Preference p305;
    Preference p306;
    Preference p307;
    Preference p309;
    Preference p310;
    Preference p311;
    Preference p312;
    Preference p313;
    Preference p314;
    Preference p315;
    Preference p316;
    Preference p317;
    Preference p319;
    Preference p320;
    Preference p321;
    Preference p323;
    Preference p324;
    Preference p325;
    Preference p326;


    public void init()
    {
        p300=(SwitchPreference)findPreference("globalbggr");
        p301=findPreference("globalbg");
        p302=findPreference("globaltabsgr");
        p303=findPreference("tabtitle");
        p304=(SeekBarPreference) findPreference("textsize");
        p305=findPreference("unreadcounttab");
        p306=findPreference("unreadcounttabbg");
        p307=findPreference("chatsbggr");
        p309=findPreference("online");
        p310=findPreference("lastseen");
        p311=findPreference("unreadcount");
        p312=findPreference("unreadcountbg");
        p313=findPreference("chatcontname");
        p314=findPreference("chatdate");
        p315=findPreference("chatfrom");
        p316=findPreference("chatmsg");
        p317=findPreference("statusbggr");
        p319=findPreference("statcontname");
        p320=findPreference("stattime");
        p321=findPreference("callsbggr");
        p323=findPreference("callcontname");
        p324=findPreference("callcount");
        p325=findPreference("calldate");
        p326=findPreference("callicon");
    }
    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vhome);
        init();
        //getPreferenceManager().setSharedPreferencesName("B58");
        b581();
        general();
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
        main();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }

    private void b581()
    {
        p302.setIntent(new Intent(this,grGlobalTabs.class));
    }

    private void globalbg()
    {
        p301.setIntent(new Intent(this,grGlobalBG.class));
    }

    private void chatscrbg()
    {
        p307.setIntent(new Intent(this,grChatscrbg.class));
    }

    private void statuscrbg()
    {
        p317.setIntent(new Intent(this,grStatusscrbg.class));
    }

    private void callscrbg()
    {
        p321.setIntent(new Intent(this,grCallscrbg.class));
    }
    private void main()
    {
        p300.setTitle(IDGen.string.singlebg);
        //if(getApplicationContext().getSharedPreferences("B58",0).getBoolean("globalbggr",false))
        if(p300.isChecked())
        {
            p300.setSummary(getString(IDGen.string.singlebgsum,"Enabled"));
            p301.setTitle(IDGen.string.globalbg);
            p301.setSummary(IDGen.string.globalbgsum);
            globalbg();
            p307.setTitle(IDGen.string.disabled);
            p317.setTitle(IDGen.string.disabled);
            p321.setTitle(IDGen.string.disabled);
            p307.setSummary(getString(IDGen.string.disableoption,"3.0"));
            p317.setSummary(getString(IDGen.string.disableoption,"3.0"));
            p321.setSummary(getString(IDGen.string.disableoption,"3.0"));
            p307.setEnabled(false);
            p317.setEnabled(false);
            p321.setEnabled(false);
        }
        else
        {
            /*p300.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(getApplicationContext(),getApplicationContext().getString(IDGen.string.enableoption,"3.0"),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });*/
            p300.setSummary(getString(IDGen.string.singlebgsum,"Disabled"));
            p301.setTitle(IDGen.string.disabled);
            p301.setSummary(getString(IDGen.string.disableoption,"3.0"));
            p301.setEnabled(false);
            chatscrbg();
            statuscrbg();
            callscrbg();
            p307.setTitle(IDGen.string.chatscrbg);
            p307.setSummary(IDGen.string.chatscrbgsum);
            p317.setTitle(IDGen.string.statscrbg);
            p317.setSummary(IDGen.string.statscrbgsum);
            p321.setTitle(IDGen.string.callscrbg);
            p321.setSummary(IDGen.string.callscrbgsum);
            p307.setEnabled(true);
            p317.setEnabled(true);
            p321.setEnabled(true);
        }

    }

    public void general()
    {
        p302.setTitle(IDGen.string.tabcolor);
        p302.setSummary(IDGen.string.tabcolorsum);
        p303.setTitle(IDGen.string.tabtitle);
        p303.setSummary(IDGen.string.tabtitlesum);
        p304.setTitle(IDGen.string.textsize);
        p304.setSummary(IDGen.string.textsizesum);
        p305.setTitle(IDGen.string.unreadcounttab);
        p305.setSummary(IDGen.string.unreadcounttabsum);
        p306.setTitle(IDGen.string.unreadcounttabbg);
        p306.setSummary(IDGen.string.unreadcounttabbgsum);
        p309.setTitle(IDGen.string.onlinecolor);
        p309.setSummary(IDGen.string.onlinecolorsum);
        p310.setTitle(IDGen.string.lastseencolor);
        p310.setSummary(IDGen.string.lastseencolorsum);
        p311.setTitle(IDGen.string.unreadcount);
        p311.setSummary(IDGen.string.unreadcountsum);
        p312.setTitle(IDGen.string.unreadcountbg);
        p312.setSummary(IDGen.string.unreadcountbgsum);
        p313.setTitle(IDGen.string.contname);
        p313.setSummary(IDGen.string.contnamesum);
        p314.setTitle(IDGen.string.contdate);
        p314.setSummary(IDGen.string.contdatesum);
        p315.setTitle(IDGen.string.sender);
        p315.setSummary(IDGen.string.sendersum);
        p316.setTitle(IDGen.string.msgcolor);
        p316.setSummary(IDGen.string.msgcolorsum);
        p319.setTitle(IDGen.string.contname);
        p319.setSummary(IDGen.string.contnamesum);
        p320.setTitle(IDGen.string.stattime);
        p320.setSummary(IDGen.string.stattimesum);
        p323.setTitle(IDGen.string.contname);
        p323.setSummary(IDGen.string.contnamesum);
        p324.setTitle(IDGen.string.callcount);
        p324.setSummary(IDGen.string.callcountsum);
        p325.setTitle(IDGen.string.calltime);
        p325.setSummary(IDGen.string.calltimesum);
        p326.setTitle(IDGen.string.callicon);
        p326.setSummary(IDGen.string.calliconsum);
    }
}
