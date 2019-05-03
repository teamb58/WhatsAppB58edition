package com.B58works;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.SwitchPreference;

import java.util.HashSet;

import d.f.cz;
/**
 * Created by Bharath.R(58) on 26-01-2019.
 */

public class Privacy extends cz implements SharedPreferences.OnSharedPreferenceChangeListener {

    static String JID;
    static HashSet hashSet;

    static{
        hashSet=new HashSet();
    }

    /*public static boolean AlwaysOnline() {
        return getPrivacyB("always_online");
    }*/

    public static boolean AntiRevoke(final Object o) {
        final String jid = (String)o;
        if (getPrivacyB(jid)) {
            return getPrivacyB(jid + "_AR");
        }
        else {
            return getPrivacyB("Antirevoke");
        }
    }

    /*public static boolean isRevoked(Object o)
    {
        return true;
    }*/

    private static String GetType2(final String jid) {
        if (jid.contains("g.us"))
            return  "G";
        else if (jid.contains("@broadcast"))
            return  "B";
        else if (jid.contains("@s.whatsapp.net"))
            return  "C";
        else
            return "ST";
    }

    public static boolean HideCR(final String s, final int n) {
        if (n == 1) {
            if (getPrivacyB(s))
                return getPrivacyB(s + "_HideRecord");
            else
                getPrivacyB(GetType2(s) + "_HideRecord");
        }
        else
        {
            if (getPrivacyB(s))
                return getPrivacyB(s + "_HideCompose");
            else
                return getPrivacyB(GetType2(s) + "_HideCompose");
        }
        return false;
    }

    public static boolean HidePlay(final Object o) {
        final String jid = (String)o;
        if (getPrivacyB(jid))
            return getPrivacyB(jid + "_HidePlay");
        else
            return getPrivacyB(GetType2(jid) + "_HidePlay");
    }

    public static int HideForward(final int i) {
        return (getPrivacyB("HideForward") || i <= 0) ? i : i-1;
        /*final String jid = (String)o;
        if (getPrivacyB(jid))
            return getPrivacyB(jid + "_HideForward");
        else
            return getPrivacyB(GetType2(jid) + "_HideForward");*/
    }

    public static boolean HideRead(final Object o) {
        final String jid = (String)o;
        if (getPrivacyB(jid))
            return getPrivacyB(jid + "_HideRead");
        else
            return getPrivacyB(GetType2(jid) + "_HideRead");
    }

    public static boolean HideReceipt(final Object o) {
        final String jid = (String)o;
        if (getPrivacyB(jid))
            return getPrivacyB(jid + "_HideReceipt");
        else
            return getPrivacyB(GetType2(jid) + "_HideReceipt");
    }

    public static boolean HideSeen() {
        return getPrivacyB("HideSeen");
    }

    public static boolean HideStatus() {
        final String jid = Privacy.JID;
        if (getPrivacyB(jid))
            return (!getPrivacyB(jid + "_HideStatus"));
        else
            return (!getPrivacyB("hide_status"));
    }

    public static void SetJID(final String jid) {
        JID = jid;
    }

    static boolean getPrivacyB(final String s) {
        return B58.ctx.getSharedPreferences("B58privacy", 0).getBoolean(s, false);
    }

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.tprivacy);
        this.getPreferenceManager().setSharedPreferencesName("B58privacy");
        final Preference p1=this.findPreference("C_HideReceipt");
        final Preference p2=this.findPreference("B_HideReceipt");
        final Preference p3=this.findPreference("G_HideReceipt");
        p1.setEnabled(false);
        p1.setSummary("Please use custom privacy as it has reduced delay.");
        p2.setEnabled(false);
        p2.setSummary("Please use custom privacy as it has reduced delay.");
        p3.setEnabled(false);
        p3.setSummary("Please use custom privacy as it has reduced delay.");
    }

    protected void onStart()
    {
        super.onStart();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference p=findPreference(s);
        if(p!=null)
        {
            String key=p.getKey();
            if(p instanceof SwitchPreference)
                B58.ctx.getSharedPreferences("B58",0).edit().putBoolean(key, ((SwitchPreference)p).isChecked()).apply();
        }
        onStart();
    }

}
