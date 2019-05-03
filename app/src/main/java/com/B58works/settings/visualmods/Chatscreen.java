package com.B58works.settings.visualmods;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.B58works.B58;
import com.B58works.R;
import com.B58works.settings.Superpref;



public class Chatscreen extends Superpref {

    Preference p401,p402,p403,p404,p405,p406,p407,p408,p409,p410,p411,p412,p413,p414,p415,p416,p417,p418,p419,p420;

    public Chatscreen()
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
        addPreferencesFromResource(R.xml.vchat);
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
        p401.setTitle(R.string.chatcontname);
        p401.setSummary(R.string.chatcontnamesum);
        p402.setTitle(R.string.chatscrls);
        p402.setSummary(R.string.chatscrlssum);
        p403.setTitle(R.string.chatscrstatusbg);
        p403.setSummary(R.string.chatscrstatusbgsum);
        p404.setTitle(R.string.chatscrstatus);
        p404.setSummary(R.string.chatscrstatussum);
        p405.setTitle(R.string.chatscrrightb);
        p405.setSummary(R.string.chatscrrightbsum);
        p406.setTitle(R.string.chatscrrtime);
        p406.setSummary(R.string.chatscrrtimesum);
        p407.setTitle(R.string.chatscrrtext);
        p407.setSummary(R.string.chatscrrtextsum);
        p408.setTitle(R.string.chatscrleftb);
        p408.setSummary(R.string.chatscrleftbsum);
        p409.setTitle(R.string.chatscrltime);
        p409.setSummary(R.string.chatscrltimesum);
        p410.setTitle(R.string.chatscrltext);
        p410.setSummary(R.string.chatscrltextsum);
        p411.setTitle(R.string.chatscrtextentry);
        p411.setSummary(R.string.chatscrtextentrysum);
        p412.setTitle(R.string.chatscrentryhint);
        p412.setSummary(R.string.chatscrentryhintsum);
        p413.setTitle(R.string.chatscrentrybg);
        p413.setSummary(R.string.chatscrentrybgsum);
        p414.setTitle(R.string.chatscrsendbtn);
        p414.setSummary(R.string.chatscrsendbtnsum);
        p415.setTitle(R.string.chatscrsendbg);
        p415.setSummary(R.string.chatscrsendbgsum);
        p416.setTitle(R.string.chatscrquotname);
        p416.setSummary(R.string.chatscrquotnamesum);
        p417.setTitle(R.string.chatscrquottext);
        p417.setSummary(R.string.chatscrquottextsum);
        p418.setTitle(R.string.chatscrquotbg);
        p418.setSummary(R.string.chatscrquotbgsum);
        p419.setTitle(R.string.chatscremojihf);
        p419.setSummary(R.string.chatscremojihfsum);
        p420.setTitle(R.string.chatscremojibg);
        p420.setSummary(R.string.chatscremojibgsum);
    }
}
