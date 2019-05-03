package com.whatsapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.B58works.ColorStore;
import com.B58works.BooleanMethods;
import com.B58works.R;
import com.whatsapp.plus.XMLXplorerActivity;

import java.io.File;

import static com.B58works.B58.ctx;
import static com.B58works.B58.pref;

/**
 * Created by Bharath.R(58) on 19-01-2019.
 */

public class sn1 {

    public static void setQuot(View quot) {
        sn1.quot = quot;
        quoted();
    }

    private static View quot;

    public static int getColor(String str, int i) {
        return pref.getInt(str, i);
    }

    public static int getColor(final String s) {
        return pref.getInt(s, -16777216);
    }

    public static void ClearTheme() {
        ctx.getSharedPreferences("B58", 0).edit().clear().apply();
        File f=new File(ctx.getFilesDir(), "../files/wallpaper.jpg");
        Boolean d=f.delete();
        Toast.makeText(ctx, "All are reset to default now.", Toast.LENGTH_SHORT).show();
    }

    public static void DialogSaveTheme(final Activity activity) {
        final View inflate = LayoutInflater.from(activity).inflate(R.layout.editbox_dialog, null);
        final AlertDialog.Builder a = new AlertDialog.Builder(activity);
        a.setView(inflate);
        a.setCancelable(false).setPositiveButton(R.string.B58save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText e=inflate.findViewById(R.id.etname);
                final String string = e.getText().toString();
                b58.BackupPreference2(activity, (string) + ".xml", ("WhatsApp") + "/B58/Themes/");
                b58.getWallpaper(activity, string, "Themes");
            }
        }).setNegativeButton(R.string.B58cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        a.create().show();
    }

    public static void DownloadTheme(final Activity activity) {
        String app="tk.osmthemes";
        PackageManager packageManager = ctx.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(app, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo == null) {
            // not installed it will open your app directly on playstore
            Toast.makeText(ctx,"Please install OSMThemes app which helps you download themes.",Toast.LENGTH_LONG).show();
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + app)));
        }
        else {
            // Installed
            Toast.makeText(ctx,"Thank you for installing OSMThemes app.",Toast.LENGTH_LONG).show();
            Intent LaunchIntent = packageManager.getLaunchIntentForPackage(app);
            activity.startActivity( LaunchIntent );
        }
    }

    public static void LoadTheme(final Activity activity) {
        final Intent intent = new Intent(activity, XMLXplorerActivity.class);
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.putExtra("FILTER", ".xml");
        activity.startActivityForResult(intent, 6384);
    }

    public static GradientDrawable getGD(final String name) {
        final Object[] gradientColor = setGD(name);
        return new GradientDrawable((GradientDrawable.Orientation)gradientColor[0], new int[] { (int)gradientColor[1], (int)gradientColor[2] });
    }

    public static int getIntofList(String key)
    {
        return Integer.parseInt(pref.getString(key,"0"));
    }

    public static Object[] setGD(String name)
    {
        final int int1 = getColor(name);
        final int int2 = getColor(name+"gr");
        final int o=getIntofList(name+"or");
        GradientDrawable.Orientation go=GradientDrawable.Orientation.TOP_BOTTOM;
        switch(o)
        {
            case 4: {
                go = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            }
            case 3: {
                go = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            }
            case 2: {
                go = GradientDrawable.Orientation.TR_BL;
                break;
            }
            case 1: {
                go = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            }
            case 0: {
                go = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            }
        }
        return new Object[] { go, int1, int2 };
    }

    public static int mainpagercolor() {
        return pref.getInt("ActionbartextColor", ColorStore.getMainTextColor());
    }

    public static void Toolbarcolor(Toolbar t)
    {
        String value="ActionbarColor";
        if(BooleanMethods.actionbargr())
        {
            t.setBackgroundDrawable(getGD(value));
        }
        else {
            t.setBackgroundColor(getColor(value, ColorStore.getActionBarColor()));
        }

        t.setTitleTextColor(mainpagercolor());
        t.setSubtitleTextColor(mainpagercolor());
        final Drawable overflowIcon = t.getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setColorFilter(mainpagercolor(), PorterDuff.Mode.SRC_IN);
            t.setOverflowIcon(overflowIcon);
        }
    }

    public static void Toolbarnavicon(Toolbar t)
    {
        final Drawable nav=t.getNavigationIcon();
        if(nav != null)
        {
            nav.setColorFilter(getColor("ActionbartextColor", -1), PorterDuff.Mode.MULTIPLY);
            t.setNavigationIcon(nav);
        }
    }

    public static void setStatusNavBar(final Activity activity) {
        try {
            String statusBar="StatusbarColor";
            String navBar="NavbarColor";
            if (Build.VERSION.SDK_INT >= 21) {
                final int color = getColor(statusBar, ColorStore.getStatusBarColor());
                final int color2 = getColor(navBar, color);
                final Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(color);
                window.clearFlags(134217728);
                window.setNavigationBarColor(color2);
                if (!isColorDark(color) && Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
            }
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    private static boolean isColorDark(final int n) {
        return 1.0 - (0.299 * Color.red(n) + 0.587 * Color.green(n) + 0.114 * Color.blue(n)) / 255.0 > 0.5;
    }

    public static void GlobalBG(View view)
    {
        String name="homebgColor";
        if(BooleanMethods.globalbggr())
        {
            if(BooleanMethods.homebggr())
                view.setBackgroundDrawable(getGD(name));
            else
                view.setBackgroundColor(getColor(name,ColorStore.getConsBackColor()));
        }
    }

    public static void tabcolor(d.f.ME me)
    {
        String name="tabsbgColor";
        if(BooleanMethods.tabsbggr())
            me.setBackgroundDrawable(getGD(name));
        else
            me.setBackgroundColor(getColor(name, ColorStore.getActionBarColor()));
    }

    public static void tabtitle(TextView textView)
    {
        String name="tabtitle";
        textView.setTextColor(getColor(name, mainpagercolor()));
    }

    public static int tabunread(int i)
    {
        if(i==0)
            return getColor("unreadcounttab");
        else
            return (getColor("unreadcounttab")-Color.parseColor("80000000"));
    }

    public static void chatscrbg(View view)
    {
        String name="chatscrbg";
        if(!BooleanMethods.chatscrfullbg())
        {
            chatscrhelper(view,name);
        }
    }

    public static void chatscrrowbg(View view, int i)
    {
        String altname="chatscraltbg";
        String name="chatscrbg";
        if(BooleanMethods.chatscrfullbg())
        {
           if(BooleanMethods.chatscraltbg())
           {
               if(i==1)
               {
                   if(BooleanMethods.chatscraltbggr())
                       view.setBackgroundDrawable(getGD(altname));
                   else
                       view.setBackgroundColor(getColor(altname,ColorStore.getConsBackColor()));
               }
               else
               {
                   chatscrhelper(view,name);
               }
           }
           else
           {
               chatscrhelper(view,name);
           }
        }
    }

    private static void chatscrhelper(View view,String string)
    {
        if(BooleanMethods.chatscrfullbggr())
            view.setBackgroundDrawable(getGD(string));
        else
            view.setBackgroundColor(getColor(string,ColorStore.getConsBackColor()));
    }

    public static int setHomeCounterBK() {
        String name="unreadcount";
        return getColor(name, ColorStore.unread());
    }

    public static void statusscrbg(View view)
    {
        String name="statusscrbg";
        if(!BooleanMethods.statusscrfullbg())
        {
            statusscrhelper(view,name);
        }
    }

    public static void statusscrrowbg(View view, int i)
    {
        String altname="statusscraltbg";
        String name="statusscrbg";
        if(BooleanMethods.statusscrfullbg())
        {
            if(BooleanMethods.statusscraltbg())
            {
                if(i==1)
                {
                    if(BooleanMethods.statusscraltbggr())
                        view.setBackgroundDrawable(getGD(altname));
                    else
                        view.setBackgroundColor(getColor(altname,ColorStore.getConsBackColor()));
                }
                else
                {
                    statusscrhelper(view,name);
                }
            }
            else
            {
                statusscrhelper(view,name);
            }
        }
    }

    private static void statusscrhelper(View view,String string)
    {
        if(BooleanMethods.statusscrfullbggr())
            view.setBackgroundDrawable(getGD(string));
        else
            view.setBackgroundColor(getColor(string,ColorStore.getConsBackColor()));
    }

    public static void callscrbg(View view)
    {
        String name="callscrbg";
        if(!BooleanMethods.callscrfullbg())
        {
            statusscrhelper(view,name);
        }
    }

    public static void callscrrowbg(View view, int i)
    {
        String altname="statusscraltbg";
        String name="statusscrbg";
        if(BooleanMethods.callscrfullbg())
        {
            if(BooleanMethods.callscraltbg())
            {
                if(i==1)
                {
                    if(BooleanMethods.callscraltbggr())
                        view.setBackgroundDrawable(getGD(altname));
                    else
                        view.setBackgroundColor(getColor(altname,ColorStore.getConsBackColor()));
                }
                else
                {
                    callscrhelper(view,name);
                }
            }
            else
            {
                callscrhelper(view,name);
            }
        }
    }

    private static void callscrhelper(View view,String string)
    {
        if(BooleanMethods.callscrfullbggr())
            view.setBackgroundDrawable(getGD(string));
        else
            view.setBackgroundColor(getColor(string,ColorStore.getConsBackColor()));
    }

    public static void setcallbtn(final ImageView imageView) {
        String s="callicon";
        int color = getColor(s,ColorStore.getActionBarColor());
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void PaintBubbleRight(final Drawable drawable)
    {
        String name="rbubbleColor";
        drawable.setColorFilter(getColor(name,ColorStore.getChatBubbleRightColor()),PorterDuff.Mode.SRC_IN);
    }

    public static void setChatDateColor(final TextView textView, Boolean b) {
        if (b)
            textView.setTextColor(getColor("rtime", -12303292));
        else
            textView.setTextColor(getColor("ltime", -12303292));
    }

    public static void ChatMsgColor(final TextView textView, Boolean b)
    {
        if (b)
            textView.setTextColor(getColor("rtext", ColorStore.getChatBubbleTextColor()));
        else
            textView.setTextColor(getColor("ltext", ColorStore.getChatBubbleTextColorL()));
    }

    public static void PaintBubbleLeft(final Drawable drawable)
    {
        String name="lbubbleColor";
        drawable.setColorFilter(getColor(name,ColorStore.getChatBubbleLeftColor()),PorterDuff.Mode.SRC_IN);
    }

    public static void setEntryMod(final MentionableEntry mentionableEntry) {
        String text="textentry";
        String hint="entryhint";
        mentionableEntry.setTextColor(getColor(text, Color.parseColor("#303031")));
        mentionableEntry.setHintTextColor(getColor(hint, Color.parseColor("#505051")));
    }

    public static void text_entry_bg(final Drawable drawable)
    {
        String name="entrybg";
        drawable.setColorFilter(getColor(name,ColorStore.getConsBackColor()),PorterDuff.Mode.SRC_IN);
    }

    public static void ColorBtnInput(final View view) {
        String name="sendbg";
        /*final Drawable drawable = context.getResources().getDrawable(getResID("input_circle", "drawable"));
        drawable.setColorFilter(getColor(s, ColorStore.sbg()), PorterDuff.Mode.SRC_ATOP);*/
        Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = ctx.getDrawable(R.drawable.input_circle);
        }
        else
            drawable=ctx.getResources().getDrawable(R.drawable.input_circle);
        ColorDrawable colorDrawable=(ColorDrawable)drawable;
        int color= 0;
        if (colorDrawable != null) {
            color = colorDrawable.getColor();
        }
        view.setBackgroundColor(getColor(name,color));
    }

    public static ImageView send_icon(final ImageView i) {
        String s="sendbtn";
        //i.setColorFilter(new PorterDuffColorFilter(ctx.getSharedPreferences("B58", 0).getInt(s, ColorStore.send()), PorterDuff.Mode.MULTIPLY));
        i.setColorFilter(getColor(s,ColorStore.send()),PorterDuff.Mode.MULTIPLY);
        return i;
    }

    private static void quoted() {
        final int color = getColor("quotbg", -11);
        if (color != -11) {
            quot.setBackgroundColor(color);
        }
        final int color2 = getColor("quotname", -11);
        if (color2 != -11) {
            ((TextView)quot.findViewById(R.id.quoted_title)).setTextColor(color2);
        }
        final int color3 = getColor("quottext", -11);
        if (color3 != -11) {
            ((TextView)quot.findViewById(R.id.quoted_text)).setTextColor(color3);
        }
    }

    public static void emojiPicker(View view)
    {
        String headfoot="emojihfColor";
        String bg="emojibgColor";
        if(BooleanMethods.emojihfgr())
        {
            view.findViewById(R.id.footer_toolbar).setBackgroundDrawable(getGD(headfoot));
            view.findViewById(R.id.emoji_group_layout).setBackgroundDrawable(getGD(headfoot));
        }
        else
        {
            view.findViewById(R.id.footer_toolbar).setBackgroundColor(getColor(headfoot,Color.parseColor("#ffebeff2")));
            view.findViewById(R.id.emoji_group_layout).setBackgroundColor(getColor(headfoot,Color.parseColor("#ffebeff2")));
        }

        if(BooleanMethods.emojibggr())
        {
            view.setBackgroundDrawable(getGD(bg));
        }
        else
        {
            view.setBackgroundColor(getColor(bg,Color.parseColor("#ffebeff2")));
        }
    }

    public static void contactPicker(View view)
    {
        String name="conpickbgColor";
        if(BooleanMethods.conpickbggr())
            view.setBackgroundDrawable(getGD(name));
        else
            view.setBackgroundColor(getColor(name,ColorStore.getConsBackColor()));
    }

    public static void ColorFab(final View view) {
        String s="fabnormal";
        Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = ctx.getDrawable(R.drawable.input_circle_green);
        }
        else
            drawable=ctx.getResources().getDrawable(R.drawable.input_circle_green);
        ColorDrawable colorDrawable=(ColorDrawable)drawable;
        int color=colorDrawable.getColor();
        /*final Drawable drawable = context.getResources().getDrawable(getResID("input_circle_green", "drawable"));
        drawable.setColorFilter(getColor(s, 0), PorterDuff.Mode.SRC_ATOP);*/
        view.setBackgroundColor(getColor(s,color));
    }





}
