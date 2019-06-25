package com.B58works;

import android.graphics.Color;

public class ColorStore {

    public static int getActionBarColor() {
        String actionbar = "#075e54";
        return Color.parseColor(actionbar);
    }

    public static int getConsBackColor() {
        String homebg = "#fffafafa";
        return Color.parseColor(homebg);
    }

    public static int getMainTextColor()
    {
        String main="#ffffffff";
        return Color.parseColor(main);
    }

    public static int getStatusBarColor() {
        String statusbar = "#075e54";
        return Color.parseColor(statusbar);
    }

    public static int unread()
    {
        String unreadbg = "#09d261";
        return Color.parseColor(unreadbg);
    }

    public static int getChatBubbleRightColor() {
        String chatbubbleright="#e1ffc7";
        return Color.parseColor(chatbubbleright);
    }

    public static int getChatBubbleTextColor() {
        String rightbubbletext="#303030";
        return Color.parseColor(rightbubbletext);
    }

    public static int getChatBubbleTextColorL() {
        String leftbubbletext="#303030";
        return Color.parseColor(leftbubbletext);
    }

    public static int getChatBubbleLeftColor() {
        String chatbubbleleft="#ffffff";
        return Color.parseColor(chatbubbleleft);
    }

    public static int send() {
        String send = "#ffffff";
        return Color.parseColor(send);
    }

    public static int getFabColorNormal() {
        String fabColorNormal = "#4db6ac";
        return Color.parseColor(fabColorNormal);
    }

    public static int getFabColorPressed() {
        String fabColorPressed = "#4db6ac";
        return Color.parseColor(fabColorPressed);
    }

    public static int getFabBgColor() {
        String fabBackgoundColor = "#1Affffff";
        return Color.parseColor(fabBackgoundColor);
    }
}
