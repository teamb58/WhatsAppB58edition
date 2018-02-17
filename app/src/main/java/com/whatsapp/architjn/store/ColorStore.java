package com.whatsapp.architjn.store;

import android.graphics.Color;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class ColorStore
{
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String gn;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static String name;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String send;
    private static String sendbg;

    static {
        ColorStore.a = "#ffffff";
        ColorStore.b = "#ffffff";
        ColorStore.c = "#075e54";
        ColorStore.d = "#075e54";
        ColorStore.e = "#075e54";
        ColorStore.f = "#075e54";
        ColorStore.g = "#000000";
        ColorStore.h = "#1Affffff";
        ColorStore.i = "#ffffff";
        ColorStore.j = "#e1ffc7";
        ColorStore.k = "#ffffff";
        ColorStore.l = "#075e54";
        ColorStore.m = "#000000";
        ColorStore.n = "#075e54";
        ColorStore.o = "#303030";
        ColorStore.p = "#ffffff";
        ColorStore.q = "#303030";
        ColorStore.r = "#303030";
        ColorStore.send = "#ffffff";
        ColorStore.gn = "#303030";
        ColorStore.name = "#ffffff";
        ColorStore.sendbg = "#075e54";
    }

    public static int getActionBarColor() {
        return Color.parseColor(ColorStore.c);
    }

    public static int getBGColor() {
        return Color.parseColor(ColorStore.p);
    }

    public static int getChatBubbleLeftColor() {
        return Color.parseColor(ColorStore.i);
    }

    public static int getChatBubbleRightColor() {
        return Color.parseColor(ColorStore.j);
    }

    public static int getChatBubbleTextColor() {
        return Color.parseColor(ColorStore.r);
    }

    public static int getChatBubbleTextColorL() {
        return Color.parseColor(ColorStore.q);
    }

    public static int getConPickBackColor() {
        return Color.parseColor(ColorStore.b);
    }

    public static int getConsBackColor() {
        return Color.parseColor(ColorStore.a);
    }

    public static int getFabBgColor() {
        return Color.parseColor(ColorStore.h);
    }

    public static int getFabColorNormal() {
        return Color.parseColor(ColorStore.e);
    }

    public static int getFabColorPressed() {
        return Color.parseColor(ColorStore.f);
    }

    public static int getMicColor() {
        return Color.parseColor(ColorStore.o);
    }

    public static int getNavigationBarColor() {
        return Color.parseColor(ColorStore.g);
    }

    public static int getStatusBarColor() {
        return Color.parseColor(ColorStore.d);
    }

    public static int getUniActionColor() {
        return Color.parseColor(ColorStore.n);
    }

    public static int getUniBackColor() {
        return Color.parseColor(ColorStore.k);
    }

    public static int getUniNavColor() {
        return Color.parseColor(ColorStore.m);
    }

    public static int getUniStatColor() {
        return Color.parseColor(ColorStore.l);
    }

    public static int gnc() {
        return Color.parseColor(ColorStore.gn);
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
}

