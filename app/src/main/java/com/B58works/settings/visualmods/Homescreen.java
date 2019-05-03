package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.widget.Toast;


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


    public Homescreen()
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
        addPreferencesFromResource(R.xml.vhome);
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
        p300.setTitle(R.string.singlebg);
        //if(getApplicationContext().getSharedPreferences("B58",0).getBoolean("globalbggr",false))
        if(p300.isChecked())
        {
            p300.setSummary(getApplicationContext().getString(R.string.singlebgsum,"Enabled"));
            p301.setTitle(R.string.globalbg);
            p301.setSummary(R.string.globalbgsum);
            globalbg();
            p307.setTitle(R.string.disabled);
            p317.setTitle(R.string.disabled);
            p321.setTitle(R.string.disabled);
            p307.setSummary(getApplicationContext().getString(R.string.disableoption,"3.0"));
            p317.setSummary(getApplicationContext().getString(R.string.disableoption,"3.0"));
            p321.setSummary(getApplicationContext().getString(R.string.disableoption,"3.0"));
            p307.setEnabled(false);
            p317.setEnabled(false);
            p321.setEnabled(false);
        }
        else
        {
            /*p300.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.enableoption,"3.0"),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });*/
            p300.setSummary(getApplicationContext().getString(R.string.singlebgsum,"Disabled"));
            p301.setTitle(R.string.disabled);
            p301.setSummary(getString(R.string.disableoption,"3.0"));
            p301.setEnabled(false);
            chatscrbg();
            statuscrbg();
            callscrbg();
            p307.setTitle(R.string.chatscrbg);
            p307.setSummary(R.string.chatscrbgsum);
            p317.setTitle(R.string.statscrbg);
            p317.setSummary(R.string.statscrbgsum);
            p321.setTitle(R.string.callscrbg);
            p321.setSummary(R.string.callscrbgsum);
            p307.setEnabled(true);
            p317.setEnabled(true);
            p321.setEnabled(true);
        }

    }

    public void general()
    {
        p302.setTitle(R.string.tabcolor);
        p302.setSummary(R.string.tabcolorsum);
        p303.setTitle(R.string.tabtitle);
        p303.setSummary(R.string.tabtitlesum);
        p304.setTitle(R.string.textsize);
        p304.setSummary(R.string.textsizesum);
        p305.setTitle(R.string.unreadcounttab);
        p305.setSummary(R.string.unreadcounttabsum);
        p306.setTitle(R.string.unreadcounttabbg);
        p306.setSummary(R.string.unreadcounttabbgsum);
        p309.setTitle(R.string.onlinecolor);
        p309.setSummary(R.string.onlinecolorsum);
        p310.setTitle(R.string.lastseencolor);
        p310.setSummary(R.string.lastseencolorsum);
        p311.setTitle(R.string.unreadcount);
        p311.setSummary(R.string.unreadcountsum);
        p312.setTitle(R.string.unreadcountbg);
        p312.setSummary(R.string.unreadcountbgsum);
        p313.setTitle(R.string.contname);
        p313.setSummary(R.string.contnamesum);
        p314.setTitle(R.string.contdate);
        p314.setSummary(R.string.contdatesum);
        p315.setTitle(R.string.sender);
        p315.setSummary(R.string.sendersum);
        p316.setTitle(R.string.msgcolor);
        p316.setSummary(R.string.msgcolorsum);
        p319.setTitle(R.string.contname);
        p319.setSummary(R.string.contnamesum);
        p320.setTitle(R.string.stattime);
        p320.setSummary(R.string.stattimesum);
        p323.setTitle(R.string.contname);
        p323.setSummary(R.string.contnamesum);
        p324.setTitle(R.string.callcount);
        p324.setSummary(R.string.callcountsum);
        p325.setTitle(R.string.calltime);
        p325.setSummary(R.string.calltimesum);
        p326.setTitle(R.string.callicon);
        p326.setSummary(R.string.calliconsum);
    }
}
