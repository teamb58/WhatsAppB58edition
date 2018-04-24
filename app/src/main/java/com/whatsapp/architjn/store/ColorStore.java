package com.whatsapp.architjn.store;

import android.graphics.Color;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class ColorStore
{
    private static String homebg;
    private static String actionbar;
    private static String statusbar;
    private static String chatbubbleleft;
    private static String chatbubbleright;
    private static String name;
    private static String leftbubbletext;
    private static String rightbubbletext;
    private static String gn;
    private static String send;
    private static String sendbg;
    private static String unread;

    private static String FabColorNormal;
    private static String FabColorPressed;
    private static String FabBackgoundColor;

    static {
        ColorStore.homebg = "#ffffff";
        ColorStore.actionbar = "#075e54";
        ColorStore.statusbar = "#075e54";
        ColorStore.chatbubbleleft = "#ffffff";
        ColorStore.chatbubbleright = "#e1ffc7";
        ColorStore.leftbubbletext = "#303030";
        ColorStore.rightbubbletext = "#303030";
        ColorStore.gn = "#303030";
        ColorStore.send = "#ffffff";
        ColorStore.name = "#ffffff";
        ColorStore.sendbg = "#075e54";
        ColorStore.unread = "#09d261";
        ColorStore.FabColorNormal = "#00897b";
        ColorStore.FabColorPressed = "#bdbdbd";
        ColorStore.FabBackgoundColor = "#ffffffff";
    }

    public static int getActionBarColor() {
        return Color.parseColor(ColorStore.actionbar);
    }

    public static int getChatBubbleLeftColor() {
        return Color.parseColor(ColorStore.chatbubbleleft);
    }

    public static int getChatBubbleRightColor() {
        return Color.parseColor(ColorStore.chatbubbleright);
    }

    public static int getChatBubbleTextColor() {
        return Color.parseColor(ColorStore.rightbubbletext);
    }

    public static int getChatBubbleTextColorL() {
        return Color.parseColor(ColorStore.leftbubbletext);
    }

    public static int getConsBackColor() {
        return Color.parseColor(ColorStore.homebg);
    }

    public static int getFabBgColor() {
        return Color.parseColor(ColorStore.FabBackgoundColor);
    }

    public static int getFabColorNormal() {
        return Color.parseColor(ColorStore.FabColorNormal);
    }

    public static int getFabColorPressed() {
        return Color.parseColor(ColorStore.FabColorPressed);
    }

    public static int getStatusBarColor() {
        return Color.parseColor(ColorStore.statusbar);
    }

    public static int name() {
        return Color.parseColor(ColorStore.name);
    }

    public static int sbg() {
        return Color.parseColor(ColorStore.sendbg);
    }

    public static int send() {
        return Color.parseColor(ColorStore.send);
    }

    public static int unread(){ return Color.parseColor(unread);}
}

