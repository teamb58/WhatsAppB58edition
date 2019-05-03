package com.B58works;

import android.content.Context;
import android.net.ConnectivityManager;

import static com.B58works.B58.ctx;

public class BooleanMethods {

    public static Boolean getBoolean(String name)
    {
        return B58.pref.getBoolean(name,false);
    }
    public static Boolean actionbargr()
    {
        return getBoolean("actionbargr");
    }

    public static Boolean globalbggr()
    {
        return getBoolean("globalbggr");
    }

    public static Boolean homebggr()
    {
        return getBoolean("homebggr");
    }

    public static Boolean tabsbggr()
    {
        return getBoolean("tabsbggr");
    }

    public static Boolean chatscrfullbg()
    {
        return getBoolean("chatfullbg");
    }

    public static Boolean chatscrfullbggr()
    {
        return getBoolean("chatscrbggren");
    }

    public static Boolean chatscraltbg()
    {
        return getBoolean("chatscrbgalten");
    }

    public static Boolean chatscraltbggr()
    {
        return getBoolean("chatscrbggralten");
    }

    public static Boolean hidename()
    {
        return getBoolean("hidename");
    }

    public static Boolean hidemsg()
    {
        return getBoolean("hidemsg");
    }

    public static Boolean statusscrfullbg()
    {
        return getBoolean("statusfullbg");
    }

    public static Boolean statusscrfullbggr()
    {
        return getBoolean("statusscrbggren");
    }

    public static Boolean statusscraltbg()
    {
        return getBoolean("statusscrbgalten");
    }

    public static Boolean statusscraltbggr()
    {
        return getBoolean("statusscrbggralten");
    }

    public static Boolean callscrfullbg()
    {
        return getBoolean("callfullbg");
    }

    public static Boolean callscrfullbggr()
    {
        return getBoolean("callscrbggren");
    }

    public static Boolean callscraltbg()
    {
        return getBoolean("callscrbgalten");
    }

    public static Boolean callscraltbggr()
    {
        return getBoolean("callscrbggralten");
    }

    public static Boolean emojihfgr()
    {
        return getBoolean("emojihfgr");
    }

    public static Boolean emojibggr()
    {
        return getBoolean("emojibggr");
    }

    public static Boolean conpickbggr()
    {
        return getBoolean("conpickbggr");
    }

    public static Boolean hidefab()
    {
        return getBoolean("hidefab");
    }

    public static boolean contact_online_toast() {
        return getBoolean("contact_online_toast");
    }

    public static boolean Archv_chats() {
        return getBoolean("Archv_chats");
    }

    public static boolean Audio_ears() {
        return getBoolean("Audio_ears");
    }

    public static boolean Audio_sensor() {
        return getBoolean("Audio_sensor");
    }

    public static boolean HideInfo() {
        return getBoolean("B58_hideinfo");
    }

    static boolean onlinechat() {
        return getBoolean("onlinechat");
    }

    static boolean isNetworkAvailable() {
        try {
            final ConnectivityManager connectivityManager = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        }
        catch (Exception ex) {
            return false;
        }
    }

    public static boolean statuschat() {
        return getBoolean("statuschat");
    }
}
