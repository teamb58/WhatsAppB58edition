package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
//import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;

import com.B58works.B58;

import java.io.File;

import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.plus.XMLXplorerActivity;
import com.whatsapp.protocol.n;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getPrefString;
import static com.B58works.B58.getResID;
import static com.whatsapp.architjn.store.ColorStore.getActionBarColor;
import static com.whatsapp.architjn.store.ColorStore.unread;

/**
 * Created by Bharath.R(58) on 27-12-2017.
 */

public class sn1
{

    public static void ChatMsgColor(final TextView textView, final n k) {
        String s = "left_msg";
        String right;
        String left;
        switch(getPrefString("file_type"))
        {
            default:{right="rightmsg";left="leftmsg";break;}
            case 1:{right="ModChatBubbleText";left="ModChatBubbleTextLeft";break;}
            case 2:{right="right_message_text_color_picker";left="left_message_text_color_picker";break;}
        }
        try {
            if (k.b.b) {
                s = "right_msg";
            }
            if (s.contains("right")) {
                textView.setTextColor(getColor(right, ColorStore.getChatBubbleTextColor()));
            }
            else {
                textView.setTextColor(getColor(left, ColorStore.getChatBubbleTextColorL()));
            }
            textView.setTextSize((float)16);
        }
        catch (Exception ex) {}
    }

    public static void ClearTheme() {
        B58.ctx.getSharedPreferences("B58", 0).edit().clear().apply();
        SharedPreferences pref = B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0);
        pref.edit().remove("file_type").apply();
        File f=new File(ctx.getFilesDir(), "../files/wallpaper.jpg");
        Boolean d=f.delete();
        Toast.makeText(B58.ctx, "All are reset to default now.", Toast.LENGTH_SHORT).show();
    }

    public static void ColorBtnInput(final Context context, final View view) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="sendbg";break;}
            case 1:{s="ModChaSendBKColor";break;}
            case 2:{s="mic_circle_mod_picker";break;}
        }
        final Drawable drawable = context.getResources().getDrawable(getResID("input_circle", "drawable"));
        drawable.setColorFilter(getColor(s, ColorStore.sbg()), PorterDuff.Mode.SRC_ATOP);
        view.setBackgroundDrawable(drawable);
    }

    public static void ColorFab(final Context context, final View view) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="FabNormalColor";break;}
            case 1:{s="ModFabNormalColor";break;}
            case 2:{s="floatingbtn_bg_color_picker";break;}
        }
        final Drawable drawable = context.getResources().getDrawable(getResID("input_circle_green", "drawable"));
        drawable.setColorFilter(getColor(s, 0), PorterDuff.Mode.SRC_ATOP);
        view.setBackgroundDrawable(drawable);
    }

    public static void DisableFAB(final ImageView i, int n) {
        if(!getBoolean("hide_fab"))
        {
            if (n == 1)
                i.setVisibility(View.GONE);
        }
    }

    @SuppressLint("ResourceType")
    public static void DialogSaveTheme(final Activity activity) {
        final View inflate = LayoutInflater.from(activity).inflate(zeditbox_dialog(), null);
        final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(activity);
        alertDialog$Builder.setView(inflate);
        alertDialog$Builder.setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText e=inflate.findViewById(zetname());
                final String string = e.getText().toString();
                b58.BackupPreference2(activity, String.valueOf(string) + ".xml", String.valueOf("WhatsApp") + "/B58/Themes/");
                b58.getWallpaper(activity, string, "Themes");
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertDialog$Builder.create().show();
        //com.B58works.extra.ba(activity, (EditText)inflate.findViewById(zetname())))
    }

    public static void DownloadTheme(final Activity activity) {
        //Toast.makeText(B58.ctx, "Waiting for some donations to setup a Themes server.", Toast.LENGTH_SHORT).show();
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
        } else {
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

    public static void Homebg(View v) {
        String s,s1,s2;
        final File file = new File(Environment.getExternalStorageDirectory()+"/"+"WhatsApp"+"/B58"+"/wall.jpg");
        switch(getPrefString("file_type"))
        {
            default:{s="homebg";s1=null;s2=null;break;}
            case 1:{s="ModConBackColor";s1=null;s2=null;break;}
            case 2:{s="chats_bg_odd_color_picker";s1="chats_background_gd_bg_color_picker";s2="chats_background_gd_bg_mode";break;}
        }
        if(getBoolean(s+"grc")|| getBoolean(s+"_Gactive") || (B58.getPrefString1("chats_background_gd_bg_mode")!=0))
            v.setBackgroundDrawable(getGD(s,s1,s2));
        else if(getPrefString("file_type")==1 && file.exists())
            v.setBackgroundDrawable(wall());
        else
            v.setBackgroundColor(getColor(s, ColorStore.getConsBackColor()));

    }

    public static int callcolor()
    {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="ActionbarColor";break;}
            case 1:{s="ModConPickColor";break;}

        }
        return getColor(s,getActionBarColor());
    }
    public static Drawable wall()
    {
        Bitmap myBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/"+"WhatsApp"+"/B58"+"/wall.jpg");
        return new BitmapDrawable(ctx.getResources(), myBitmap);
    }

    public static void Contactpickerbg(View l)
    {
        String s,s1,s2;
        switch(getPrefString("file_type"))
        {
            default:{s="conbg";s1=null;s2=null;break;}
            case 2:{s="contacts_bg_odd_color_picker";s1="contacts_background_gd_bg_color_picker";s2="contacts_background_gd_bg_mode";break;}
        }
        if(getBoolean(s+"grc")|| (B58.getPrefString1("contacts_background_gd_bg_mode")!=0))
            l.setBackgroundDrawable(getGD(s,s1,s2));
        else
            l.setBackgroundColor(getColor(s, ColorStore.getConsBackColor()));
    }

    public static void PaintBubbleLeft(final Drawable drawable) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="leftfill";break;}
            case 1:{s="ModChatLeftBubble";break;}
            case 2:{s="grey_bubble_color_picker";break;}
        }
        drawable.setColorFilter(getColor(s, ColorStore.getChatBubbleLeftColor()), PorterDuff.Mode.SRC_IN);
    }

    public static void PaintBubbleRight(final Drawable drawable) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="rightfill";break;}
            case 1:{s="ModChatRightBubble";break;}
            case 2:{s="green_bubble_color_picker";break;}
        }
        drawable.setColorFilter(getColor(s, ColorStore.getChatBubbleRightColor()), PorterDuff.Mode.SRC_IN);
    }

    public static void PaintBubbleCenter(final Drawable drawable) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="centerfill";break;}
            case 1:{s="ModChatRightBubble";break;}
            case 2:{s="green_bubble_color_picker";break;}
        }
        drawable.setColorFilter(getColor(s, ColorStore.getChatBubbleRightColor()), PorterDuff.Mode.SRC_IN);
    }

    public static void Restart() {
        Process.killProcess(Process.myPid());
    }

    public static void Toolbarcolor(Toolbar t)
    {
        String s,s1,s2;
        switch(getPrefString("file_type"))
        {
            default:{s="ActionbarColor";s1=null;s2=null;break;}
            case 1:{s="ModConPickColor";s1=null;s2=null;break;}
            case 2:{s="chats_header_background_picker";s1="chats_header_background_gd_bg_color_picker";s2="chats_header_background_gd_bg_mode";break;}
        }
        if(getBoolean("ActionbarColorgrc") || getBoolean(s+"_Gactive") || (B58.getPrefString1("chats_header_background_gd_bg_mode")!=0))
        {
            t.setBackgroundDrawable(getGD(s,s1,s2));
        }
        else {
            t.setBackgroundColor(getColor(s, ColorStore.getActionBarColor()));
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
        nav.setColorFilter(getColor("ActionbartextColor", -1), PorterDuff.Mode.MULTIPLY);
        t.setNavigationIcon(nav);
    }

    public static void settingstoast()
    {
        String s;
        switch(getPrefString("file_type"))
        {
            case 1:{s="YoWhatsApp";break;}
            case 2:{s="GBWhatsApp";break;}
            default:{s="B58";break;}
        }
        if(getPrefString("file_type")!=0)
            Toast.makeText(ctx,"Please do not make any changes here as they will not work when a "+s+"Theme is applied.",Toast.LENGTH_SHORT).show();
    }

    public static GradientDrawable getGD(final String s, String s1, String s2) {
        final Object[] gradientColor = setGD(s,s1,s2);
        return new GradientDrawable((GradientDrawable.Orientation)gradientColor[0], new int[] { (int)gradientColor[1], (int)gradientColor[2] });
    }

    public static Object[] setGDB58(String s)
    {
        final int int1 = getColor(s);
        final int int2 = getColor(s+"gr");
        final int o=getPrefString(s+"or");
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

    public static Object[] setGDyo(String s)
    {
        final int int1 = getColor(s);
        final int int2 = getColor(s+"_GC");
        final int o=getPrefString(s+"_GCDir");
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

    public static Object[] setGDgb(String s, String s1, String  s2)
    {
        final int int1 = getColor(s);
        final int int2 = getColor(s1);
        final int o=getPrefString(s2);
        GradientDrawable.Orientation go;
        switch(o)
        {
            case 2: {
                go = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            }
            case 1: {
                go = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            }
            default: {
                go = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            }
        }
        return new Object[] { go, int1, int2 };
    }

    public static Object[] setGD(String s, String s1, String s2)
    {
        switch(getPrefString("file_type"))
        {
            default:{return setGDB58(s);
            }
            case 1:{return setGDyo(s);}
            case 2:{return setGDgb(s,s1,s2);}
        }


    }
    public static void Toolbarcolor(final android.support.v7.app.a a) {
        String s,s1,s2;
        switch(getPrefString("file_type"))
        {
            default:{s="ActionbarColor";s1=null;s2=null;break;}
            case 1:{s="ModConPickColor";s1=null;s2=null;break;}
            case 2:{s="chats_header_background_picker";s1="chats_header_background_gd_bg_color_picker";s2="chats_header_background_gd_bg_mode";break;}
        }
        if(getBoolean(s+"grc") || getBoolean(s+"_Gactive") || (B58.getPrefString1("chats_header_background_gd_bg_mode")!=0))
        {
            a.a(getGD(s,s1,s2));
        }
        else {
            final int color = getColor(s, ColorStore.getActionBarColor());
            if (color != -11) {
                a.a(new ColorDrawable(color));
            }
        }
    }

    static void a(final View view, final int textColor) {
        try {
            if (view instanceof ImageView) {
                ((ImageView)view).setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
            }
            else {
                if (view instanceof TextView) {
                    ((TextView)view).setTextColor(textColor);
                }
                try {
                    final ActionMenuItemView actionMenuItemView = (ActionMenuItemView)view;
                    final Drawable[] compoundDrawables = actionMenuItemView.getCompoundDrawables();
                    compoundDrawables[0].setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
                    actionMenuItemView.setIcon(compoundDrawables[0]);
                }
                catch (ClassCastException ex2) {}
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int abc_action_bar_default_height_material() {
        return B58.getResID("abc_action_bar_default_height_material", "dimen");
    }

    public static void actionbarbk(final Activity activity) {
        final int mainpagercolor = mainpagercolor();
        String s,s1,s2;
        switch(getPrefString("file_type"))
        {
            default:{s="ActionbarColor";s1=null;s2=null;break;}
            case 1:{s="ModConPickColor";s1=null;s2=null;break;}
            case 2:{s="chats_header_background_picker";s1="chats_header_background_gd_bg_color_picker";s2="chats_header_background_gd_bg_mode";break;}
        }
        final ViewGroup viewGroup = null;
        try {
            final int color = getColor(s, -11);
            Object viewById = viewGroup;
            if (color != -11) {
                viewById = activity.findViewById(zaction_mode_bar());
                if(getBoolean(s+"grc") || getBoolean(s+"_Gactive") || (B58.getPrefString1("chats_header_background_gd_bg_mode")!=0))
                {
                    ((View) viewById).setBackgroundDrawable(getGD(s,s1,s2));
                }
                else {
                    ((View) viewById).setBackgroundDrawable(new ColorDrawable(color));
                }
            }
            final ViewGroup viewGroup2 = (ViewGroup)viewById;
            for (int i = 0; i < viewGroup2.getChildCount(); ++i) {
                b(viewGroup2.getChildAt(i), mainpagercolor);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void b(final View view, final int n) {
        try {
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                    final View child = viewGroup.getChildAt(i);
                    if (child != null) {
                        a(child, n);
                    }
                }
            }
            else {
                a(view, n);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void tabcolor(adu a) {
        String s,s1,s2;
        switch(getPrefString("file_type"))
        {
            default:{s="Tabcolor";s1=null;s2=null;break;}
            case 1:{s="ModConColor";s1=null;s2=null;break;}
            case 2:{s="chats_header_background_picker";s1="chats_header_background_gd_bg_color_picker";s2="chats_header_background_gd_bg_mode";break;}
        }
        if(getBoolean(s+"grc") || getBoolean(s+"_Gactive") || (B58.getPrefString1("chats_header_background_gd_bg_mode")!=0))
        {
            a.setBackgroundDrawable(getGD(s,s1,s2));
        }
        else
            a.setBackgroundColor(getColor(s, ColorStore.getActionBarColor()));
    }

    public static int contactLasSeenString() {
        return getResID("conversation_last_seen", "string");
    }

    @SuppressLint("NewApi")
    public static void tabcount(TextView t, int i)
    {
        t.setTextColor(getColor("countertabtext",0xff075e54));
        Drawable d=ctx.getResources().getDrawable(i);//check this once
        //Drawable d= ContextCompat.getDrawable(ctx,i);
        d.setColorFilter(getColor("countertabtextbg", -1), PorterDuff.Mode.MULTIPLY);
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            t.setBackground(d);
        else
            t.setBackgroundDrawable(d);
    }
    public static int contactOfflineString() {
        return getResID("offline_str", "string");
    }

    public static int contactOnlineString() {
        return getResID("conversation_contact_online", "string");
    }

    public static int contactStatusString() {
        return getResID("contact_status", "string");
    }

    public static int file() {
        return getResID("file", "layout");
    }

    public static int folder_icon() {
        return getResID("folder_icon", "id");
    }

    public static int folder_layout() {
        return getResID("folder_layout", "id");
    }

    public static int folder_name() {
        return getResID("folder_name", "id");
    }

    public static int getColor(final String s) {
        return B58.ctx.getSharedPreferences("B58", 0).getInt(s, -16777216);
    }

    public static int getColor(final String s, final int n) {
        return B58.ctx.getSharedPreferences("B58", 0).getInt(s, n);
    }

    public static int ic_file() {
        return getResID("ic_file", "drawable");
    }

    public static int ic_folder() {
        return getResID("ic_folder", "drawable");
    }

    public static boolean isColorDark(final int n, final double n2) {
        return 1.0 - (0.299 * Color.red(n) + 0.587 * Color.green(n) + 0.114 * Color.blue(n)) / 255.0 > n2;
    }

    public static void l() {
        final int color = getColor("quoted_bg_picker", -11);
        if (color != -11) {
            B58.quot.setBackgroundColor(color);
        }
        final int color2 = getColor("quoted_name_picker", -11);
        if (color2 != -11) {
            ((TextView)B58.quot.findViewById(zquoted_name())).setTextColor(color2);
        }
        final int color3 = getColor("quoted_text_picker", -11);
        if (color3 != -11) {
            ((TextView)B58.quot.findViewById(zquoted_text())).setTextColor(color3);
        }
    }

    public static int list_selector_background() {
        return getResID("list_selector_background", "drawable");
    }

    public static int list_selector_background_gray() {
        return getResID("list_selector_background_gray", "drawable");
    }

    public static int loglist() {
        return getResID("loglist", "id");
    }

    public static int mainTextColor() {
        return getColor("ModConTextColor", Color.parseColor("#de000000"));
    }

    public static int mainpagercolor() {
        return B58.ctx.getSharedPreferences("B58", 0).getInt("ActionbartextColor", ColorStore.getConsBackColor());
    }

    public static void pagerTitles(final TextView textView) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="pagetitle";break;}
            case 1:{s="pagetitle_picker";break;}
            case 2:{s="pagetitle_picker";break;}
        }
            textView.setTextColor(getColor(s, mainpagercolor()));
    }

    public static void menuic(final MenuItem m)
    {
        Drawable d=m.getIcon();
        d.setColorFilter(getColor("ActionbartextColor", -1), PorterDuff.Mode.MULTIPLY);
        m.setIcon(d);

    }

    public static Drawable paintHomeDrawables(final int n) {
        Drawable a= ctx.getResources().getDrawable(n);
        a.setColorFilter(getColor("ActionbartextColor", -1), PorterDuff.Mode.MULTIPLY);
        return a;
    }

    public static int ppUpdatedString() {
        return getResID("profile_photo_updated", "string");
    }

    public static int profileNameString() {
        return getResID("profile_name", "string");
    }

    public static int readlog() {
        return getResID("readlog", "layout");
    }

    public static int readlog_menu() {
        return getResID("readlog_menu", "menu");
    }

    public static int readlogrow() {
        return getResID("readlogrow", "layout");
    }

    public static ImageView send_icon(final ImageView i) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="sendcolor";break;}
            case 1:{s="ModChaSendColor";break;}
            case 2:{s="send_icon_color_picker";break;}
        }
        i.setColorFilter(new PorterDuffColorFilter(ctx.getSharedPreferences("B58", 0).getInt(s, ColorStore.send()), PorterDuff.Mode.MULTIPLY));
        return i;
    }

    public static void setChatDateColor(final TextView t, final n k) {
        String s,s1;
        switch(getPrefString("file_type"))
        {
            default:{s="rightdate";s1="leftdate";break;}
            case 1:{s="date_right_color";s1="date_left_color";break;}
            case 2:{s="date_right_color_picker";s1="date_color_picker";break;}
        }
            String s2;
            if (k.b.b) {
                s2 = s;
            }
            else {
                s2 = s1;
            }
            t.setTextColor(getColor(s2, -12303292));

    }

    public static void setEntryMod(final MentionableEntry m) {
        String s,s1;
        switch(getPrefString("file_type"))
        {
            default:{s="textinentry";s1="hintinentry";break;}
            case 1:{s="ModChatTextColor";s1="hintinentry";break;}
            case 2:{s="text_entry_color_picker";s1="hintinentry";break;}
        }
        m.setTextColor(getColor(s, Color.parseColor("#303031")));
        m.setHintTextColor(getColor(s1, Color.parseColor("#505051")));
    }

    public static int setHomeCounterBK() {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="counterbg";break;}
            case 1:{s="HomeCounterBK";break;}
            case 2:{s="chats_unread_msg_bg_color_picker";break;}
        }
        return getColor(s, unread());
    }

    public static void setHomeIc(final ImageView imageView) {
        int color = mainpagercolor();
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setcallbtn(final ImageView imageView) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="callbtncolor";break;}
            case 1:{s="callbtncolor";break;}
            case 2:{s="color_icon_call_picker";break;}
        }
        int color = getColor(s,ColorStore.getActionBarColor());
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setQView(final View d) {
        B58.quot = d;
        B58.l();
    }

    public static void setStatusNavBar(final Activity activity) {
        try {
            String s,s1;
            switch(getPrefString("file_type"))
            {
                default:{s="StatusbarColor";s1="NavbarColor";break;}
                case 1:{s="ModDarkConPickColor";s1="ModDarkConPickColorNav";break;}
                case 2:{s="chats_transparent_mode_sb_color_picker";s1="chats_transparent_mode_nav_color_picker";break;}
            }
            if (Build.VERSION.SDK_INT >= 21) {
                final int color = getColor(s, ColorStore.getStatusBarColor());
                final int color2 = getColor(s1, color);
                final Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(color);
                window.clearFlags(134217728);
                window.setNavigationBarColor(color2);
                if (!isColorDark(color, 0.5) && Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(8192);
                }
            }
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static Drawable statuscamera(final Drawable drawable) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="pagetitle";break;}
            case 1:{s="pagetitle_picker";break;}
            case 2:{s="pagetitle_picker";break;}
        }
        drawable.setColorFilter(getColor(s, mainpagercolor()), PorterDuff.Mode.MULTIPLY);
        return drawable;
    }

    public static void text_entry_bgChat(final Drawable d) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="entrybg";break;}
            case 1:{s="ModChatEntry";break;}
            case 2:{s="text_entry_bg_color_picker";break;}
        }
        d.setColorFilter(getColor(s, ColorStore.getConsBackColor()), PorterDuff.Mode.MULTIPLY);
    }

    public static int zaction_mode_bar() {
        return getResID("action_mode_bar", "id");
    }

    public static int zcancel() {
        return getResID("cancel", "id");
    }

    public static int zcolor_hue() {
        return getResID("color_hue", "drawable");
    }

    public static int zcolor_seekselector() {
        return getResID("color_seekselector", "drawable");
    }

    public static int zconversation_actionbar() {
        return getResID("conversation_actionbar", "layout");
    }

    public static int zconversation_contact_global_status() {
        return getResID("conversation_contact_global_status", "id");
    }

    public static int zconversation_contact_photo_frame() {
        return getResID("conversation_contact_photo_frame", "id");
    }

    public static int zeditbox_dialog() {
        return getResID("editbox_dialog", "layout");
    }

    public static int zerror_adding_participant_401() {
        return getResID("error_adding_participant_401", "string");
    }

    public static int zetname() {
        return getResID("etname", "id");
    }

    public static int zexplorer() {
        return getResID("explorer", "layout");
    }

    public static int zforce_stop_msg() {
        return getResID("force_stop_msg", "string");
    }

    public static int zforce_stop_title() {
        return getResID("force_stop_title", "string");
    }

    public static int zicon() {
        return getResID("icon", "drawable");
    }

    public static int ziconid() {
        return getResID("icon", "id");
    }

    public static int zinput_circle() {
        return getResID("input_circle", "id");
    }

    public static int zlabel() {
        return getResID("label", "id");
    }

    public static int zhidemsg() {
        return getResID("msgid", "id");
    }

    public static int zmute_indicator() {
        return getResID("mute_indicator", "id");
    }

    public static int znever() {
        return getResID("never", "string");
    }

    public static int zno() {
        return getResID("no", "string");
    }

    public static int znotifybar_error() {
        return getResID("notifybar_error", "drawable");
    }

    public static int zprimary() {
        return getResID("primary", "color");
    }

    public static int zquoted_name() {
        return getResID("quoted_title", "id");
    }

    public static int zquoted_text() {
        return getResID("quoted_text", "id");
    }

    public static int zrestore_error_msg0() {
        return getResID("restore_error_msg0", "string");
    }

    public static int zrestore_from_sd() {
        return getResID("restore_from_sd", "string");
    }

    public static int zrestore_ok_msg() {
        return getResID("restore_ok_msg", "string");
    }

    public static int zsave_error_msg0() {
        return getResID("save_error_msg0", "string");
    }

    public static int zsave_error_msg1() {
        return getResID("save_error_msg1", "string");
    }

    public static int zsave_success() {
        return getResID("save_success", "string");
    }

    public static int zsaved_to() {
        return getResID("saved_to", "string");
    }

    public static int zseekBarPrefBarContainer() {
        return getResID("seekBarPrefBarContainer", "id");
    }

    public static int zseekBarPrefUnitsLeft() {
        return getResID("seekBarPrefUnitsLeft", "id");
    }

    public static int zseekBarPrefUnitsRight() {
        return getResID("seekBarPrefUnitsRight", "id");
    }

    public static int zseekBarPrefValue() {
        return getResID("seekBarPrefValue", "id");
    }

    public static int zseek_bar_preference() {
        return getResID("seek_bar_preference", "layout");
    }

    public static int zselect_file() {
        return getResID("select_file", "string");
    }

    public static int zstatus() {
        return getResID("status", "id");
    }

    public static int zwamod_style_stockcentered_conversation_actionbar() {
        return getResID("wamod_style_stockcentered_conversation_actionbar", "layout");
    }

}
