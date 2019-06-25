package com.B58works;

import android.content.Context;
import android.net.ConnectivityManager;

import static com.B58works.B58.ctx;

public class BooleanMethods {

    public static boolean getBoolean(String name)
    {
        return B58.pref.getBoolean(name,false);
    }
    public static boolean actionbargr()
    {
        return getBoolean("actionbargr");
    }

    public static boolean globalbggr()
    {
        return getBoolean("globalbggr");
    }

    public static boolean homebggr()
    {
        return getBoolean("homebggr");
    }

    public static boolean tabsbggr()
    {
        return getBoolean("tabsbggr");
    }

    public static boolean chatscrfullbg()
    {
        return getBoolean("chatfullbg");
    }

    public static boolean chatscrfullbggr()
    {
        return getBoolean("chatscrbggren");
    }

    public static boolean chatscraltbg()
    {
        return getBoolean("chatscrbgalten");
    }

    public static boolean chatscraltbggr()
    {
        return getBoolean("chatscrbggralten");
    }

    static boolean hidename()
    {
        return getBoolean("hidename");
    }

    static boolean hidemsg()
    {
        return getBoolean("hidemsg");
    }

    public static boolean statusscrfullbg()
    {
        return getBoolean("statusfullbg");
    }

    public static boolean statusscrfullbggr()
    {
        return getBoolean("statusscrbggren");
    }

    public static boolean statusscraltbg()
    {
        return getBoolean("statusscrbgalten");
    }

    public static boolean statusscraltbggr()
    {
        return getBoolean("statusscrbggralten");
    }

    public static boolean callscrfullbg()
    {
        return getBoolean("callfullbg");
    }

    public static boolean callscrfullbggr()
    {
        return getBoolean("callscrbggren");
    }

    public static boolean callscraltbg()
    {
        return getBoolean("callscrbgalten");
    }

    public static boolean callscraltbggr()
    {
        return getBoolean("callscrbggralten");
    }

    public static boolean emojihfgr()
    {
        return getBoolean("emojihfgr");
    }

    public static boolean emojibggr()
    {
        return getBoolean("emojibggr");
    }

    public static boolean conpickbggr()
    {
        return getBoolean("conpickbggr");
    }

    public static boolean hidefab()
    {
        return getBoolean("hidefab");
    }

    static boolean contact_online_toast() {
        return getBoolean("onlinetoast");
    }

    public static boolean Archv_chats() {
        return getBoolean("archvchat");
    }

    public static boolean Audio_ears() {
        return getBoolean("Audio_ears");
    }

    public static boolean Audio_sensor() {
        return getBoolean("Audio_sensor");
    }

    public static boolean HideInfo() {
        return getBoolean("hideinfo");
    }

    static boolean onlinechat() {
        return getBoolean("lsmain");
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

    static boolean statuschat() {
        return getBoolean("chatstatus");
    }
}
