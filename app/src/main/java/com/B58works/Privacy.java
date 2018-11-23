package com.B58works;

/**
 * Created by Bharath.R(58) on 27-12-2017.
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.preference.Preference;

import com.whatsapp.ow;
import com.whatsapp.protocol.n;

import java.lang.reflect.Field;

public class Privacy extends ow {
    static String JID;
    static Context pctx;

    public static boolean AlwaysOnline() {
        return getPrivacyB("always_online");
    }

    public static boolean AntiRevoke(final Object o) {
        final String a = ((n)o).b.a;
        boolean b;
        if (getPrivacyB(a)) {
            b = getPrivacyB(String.valueOf(a) + "_AR");
        }
        else {
            b = getPrivacyB("Antirevoke");
        }
        return b;
    }


    private static String GetType(Object o) {
        for (final Field field : o.getClass().getFields()) {
            if (String.class.isAssignableFrom(field.getType())) {
                try {
                    final Object value = field.get(o);
                    if (value != null) {
                        if (value.toString().contains("@broadcast")) {
                            o = "B";
                            return (String) o;
                        } else if (value.toString().contains("@s.whatsapp.net")) {
                            o = "G";
                            return (String) o;
                        } else if (value.toString().contains("g.us")) {
                            o = "G";
                            return (String) o;
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }
        o = "C";
        return (String) o;
    }

    private static String GetType2(final String s) {
        String s2;
        if (s.contains("g.us")) {
            s2 = "G";
        } else if (s.contains("@broadcast")) {
            s2 = "B";
        } else {
            s2 = "C";
        }
        return s2;
    }

    public static boolean HideCR(final String s, final int n) {
        boolean b;
        switch (n) {
            default: {
                if (getPrivacyB(s)) {
                    b = getPrivacyB(s + "_HideCompose");
                    break;
                }
                b = getPrivacyB(GetType2(s) + "_HideCompose");
                break;
            }
            case 1: {
                if (getPrivacyB(s)) {
                    b = getPrivacyB(s + "_HideRecord");
                    break;
                }
                b = getPrivacyB(GetType2(s) + "_HideRecord");
                break;
            }
        }
        return b;
    }

    public static boolean HidePlay(final n k) {
        final String a = k.b.a;
        boolean b;
        if (getPrivacyB(a)) {
            b = getPrivacyB(a + "_HidePlay");
        } else {
            b = getPrivacyB(GetType(k) + "_HidePlay");
        }
        return b;
    }

    public static boolean HideRead(final Object o) {
        final String s = (String)o;
        boolean b;
        if (getPrivacyB(s)) {
            b = getPrivacyB(s + "_HideRead");
        }
        else {
            b = getPrivacyB(GetType(o) + "_HideRead");
        }
        return b;
    }

    public static boolean HideReceipt(final Object o) {
        final String s = (String)o;
        boolean b;
        if (getPrivacyB(s)) {
            b = getPrivacyB(s + "_HideReceipt");
        }
        else {
            b = getPrivacyB(GetType(o) + "_HideReceipt");
        }
        return b;
    }

    public static boolean HideSeen() {
        return getPrivacyB("HideSeen");
    }

    public static boolean HideStatus() {
        final String jid = Privacy.JID;
        boolean b;
        if (getPrivacyB(jid)) {
            b = (!getPrivacyB(String.valueOf(jid) + "_HideStatus"));
        }
        else {
            b = (!getPrivacyB("hide_status"));
        }
        return b;
    }

    public static void SetJID(final String jid) {
        Privacy.JID = jid;
    }

    static boolean getPrivacyB(final String s) {
        return Privacy.pctx.getSharedPreferences("B58privacy", 0).getBoolean(s, false);
    }

    public static String getStringPriv(final String s) {
        return B58.ctx.getSharedPreferences("B58", 0).getString(s, "");
    }

    public void onBackPressed() {
        super.onBackPressed();
        Process.killProcess(Process.myPid());
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.getPreferenceManager().setSharedPreferencesName("B58privacy");
        this.addPreferencesFromResource(B58.getResID("b58_privacy", "xml"));
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
}
