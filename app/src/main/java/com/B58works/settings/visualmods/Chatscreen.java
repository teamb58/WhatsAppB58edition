package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;



public class Chatscreen extends Superpref {

    Preference p401,p402,p403,p404,p405,p406,p407,p408,p409,p410,p411,p412,p413,p414,p415,p416,p417,p418,p419,p420;

    public void init()
    {
        p401=findPreference("contname");
        p402=findPreference("contls");
        p403=findPreference("statusbg");
        p404=findPreference("statustext");
        p405=findPreference("rbubbleColor");
        p406=findPreference("rtime");
        p407=findPreference("rtext");
        p408=findPreference("lbubbleColor");
        p409=findPreference("ltime");
        p410=findPreference("ltext");
        p411=findPreference("textentry");
        p412=findPreference("entryhint");
        p413=findPreference("entrybg");
        p414=findPreference("sendbtn");
        p415=findPreference("sendbg");
        p416=findPreference("quotname");
        p417=findPreference("quottext");
        p418=findPreference("quotbg");
        p419=findPreference("emojihf");
        p420=findPreference("emojibg");
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.vchat);
        init();
    }

    protected void onStart()
    {
        super.onStart();
        /*rightbubble();leftbubble();*/emojihf();emojiBG();main();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }

    /*private void rightbubble()
    {
        p405.setIntent(new Intent(getApplicationContext(),grRightBubble.class));
    }

    private void leftbubble()
    {
        p408.setIntent(new Intent(getApplicationContext(),grLeftBubble.class));
    }*/

    private void emojihf()
    {
        p419.setIntent(new Intent(getApplicationContext(),grEmojihf.class));
    }

    private void emojiBG()
    {
        p420.setIntent(new Intent(getApplicationContext(),grEmojiBG.class));
    }

    private void main()
    {
        p401.setTitle(IDGen.string.chatcontname);
        p401.setSummary(IDGen.string.chatcontnamesum);
        p402.setTitle(IDGen.string.chatscrls);
        p402.setSummary(IDGen.string.chatscrlssum);
        p403.setTitle(IDGen.string.chatscrstatusbg);
        p403.setSummary(IDGen.string.chatscrstatusbgsum);
        p404.setTitle(IDGen.string.chatscrstatus);
        p404.setSummary(IDGen.string.chatscrstatussum);
        p405.setTitle(IDGen.string.chatscrrightb);
        p405.setSummary(IDGen.string.chatscrrightbsum);
        p406.setTitle(IDGen.string.chatscrrtime);
        p406.setSummary(IDGen.string.chatscrrtimesum);
        p407.setTitle(IDGen.string.chatscrrtext);
        p407.setSummary(IDGen.string.chatscrrtextsum);
        p408.setTitle(IDGen.string.chatscrleftb);
        p408.setSummary(IDGen.string.chatscrleftbsum);
        p409.setTitle(IDGen.string.chatscrltime);
        p409.setSummary(IDGen.string.chatscrltimesum);
        p410.setTitle(IDGen.string.chatscrltext);
        p410.setSummary(IDGen.string.chatscrltextsum);
        p411.setTitle(IDGen.string.chatscrtextentry);
        p411.setSummary(IDGen.string.chatscrtextentrysum);
        p412.setTitle(IDGen.string.chatscrentryhint);
        p412.setSummary(IDGen.string.chatscrentryhintsum);
        p413.setTitle(IDGen.string.chatscrentrybg);
        p413.setSummary(IDGen.string.chatscrentrybgsum);
        p414.setTitle(IDGen.string.chatscrsendbtn);
        p414.setSummary(IDGen.string.chatscrsendbtnsum);
        p415.setTitle(IDGen.string.chatscrsendbg);
        p415.setSummary(IDGen.string.chatscrsendbgsum);
        p416.setTitle(IDGen.string.chatscrquotname);
        p416.setSummary(IDGen.string.chatscrquotnamesum);
        p417.setTitle(IDGen.string.chatscrquottext);
        p417.setSummary(IDGen.string.chatscrquottextsum);
        p418.setTitle(IDGen.string.chatscrquotbg);
        p418.setSummary(IDGen.string.chatscrquotbgsum);
        p419.setTitle(IDGen.string.chatscremojihf);
        p419.setSummary(IDGen.string.chatscremojihfsum);
        p420.setTitle(IDGen.string.chatscremojibg);
        p420.setSummary(IDGen.string.chatscremojibgsum);
    }
}
