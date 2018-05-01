package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;

import com.B58works.B58;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.plus.XMLXplorerActivity;
import com.whatsapp.protocol.k;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getResID;
import static com.whatsapp.architjn.store.ColorStore.unread;

/**
 * Created by Bharath.R(58) on 27-12-2017.
 */

public class sn1
{
    public static void BackupPreference2(final Context context, final String s, final String s2) {
        new File(context.getFilesDir(), "../shared_prefs/B58.xml");
        final File file = new File(Environment.getDataDirectory(), "data/" + context.getPackageName() + "/shared_prefs/" + "B58.xml");
        final File file2 = new File(Environment.getExternalStorageDirectory(), String.valueOf(s2) + s);
        try {
            final FileChannel channel = new FileInputStream(file).getChannel();
            final FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        catch (IOException ex2) {
            final String message = ex2.getMessage();
            ex2.printStackTrace();
            Toast.makeText(context, ("Failed to Back up user prefs to " + file2.getAbsolutePath() + " - " + message), Toast.LENGTH_SHORT).show();
        }
    }

    public static void ChatMsgColor(final TextView textView, final Context context, final com.whatsapp.protocol.k k) {
        String s = "left_msg";
        try {
            if (k.b.b) {
                s = "right_msg";
            }
            if (s.contains("right")) {
                textView.setTextColor(getColor("rightmsg", ColorStore.getChatBubbleTextColor()));
            }
            else {
                textView.setTextColor(getColor("leftmsg", ColorStore.getChatBubbleTextColorL()));
            }
            textView.setTextSize((float)16);
        }
        catch (Exception ex) {}
    }

    public static void ClearTheme(final Activity activity) {
        B58.ctx.getSharedPreferences("B58", 0).edit().clear().apply();
        Toast.makeText(B58.ctx, "All are reset to default now.", Toast.LENGTH_SHORT).show();
    }

    public static void ColorBtnInput(final Context context, final View view) {
        final Drawable drawable = context.getResources().getDrawable(getResID("input_circle", "drawable"));
        drawable.setColorFilter(getColor("sendbg", ColorStore.sbg()), PorterDuff.Mode.SRC_ATOP);
        view.setBackgroundDrawable(drawable);
    }

    public static void ColorFab(final Context context, final View view) {
        final Drawable drawable = context.getResources().getDrawable(getResID("input_circle_green", "drawable"));
        drawable.setColorFilter(getColor("FabNormalColor", 0), PorterDuff.Mode.SRC_ATOP);
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
        alertDialog$Builder.setCancelable(false).setPositiveButton(17039370, new com.B58works.extra.ba(activity, (EditText)inflate.findViewById(zetname()))).setNegativeButton(17039360, new com.B58works.extra.ab());
        alertDialog$Builder.create().show();
    }

    public static void DownloadTheme(final Activity activity) {
        Toast.makeText(B58.ctx, "Waiting for some donations to setup a Themes server.", Toast.LENGTH_SHORT).show();
    }

    public static void LoadTheme(final Activity activity) {
        final Intent intent = new Intent(activity, XMLXplorerActivity.class);
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.putExtra("FILTER", ".xml");
        activity.startActivityForResult(intent, 6384);
    }

    public static int Homebg() {
         return getColor("homebg", ColorStore.getConsBackColor());
    }

    public static void PaintBubbleLeft(final Drawable drawable) {
        drawable.setColorFilter(getColor("leftfill", ColorStore.getChatBubbleLeftColor()), PorterDuff.Mode.MULTIPLY);
    }

    public static void PaintBubbleRight(final Drawable drawable) {
        drawable.setColorFilter(getColor("rightfill", ColorStore.getChatBubbleRightColor()), PorterDuff.Mode.MULTIPLY);
    }

    public static void Restart() {
        Process.killProcess(Process.myPid());
    }

    public static void Toolbarcolor(Toolbar t)
    {
        t.setBackgroundColor(getColor("ActionbarColor",ColorStore.getActionBarColor()));
        t.setTitleTextColor(mainpagercolor());
        t.setSubtitleTextColor(mainpagercolor());
    }

    public static void Toolbarcolor(final android.support.v7.app.a a) {
        final int color = getColor("ActionbarColor", ColorStore.getActionBarColor());
        if (color != -11) {
            a.a(new ColorDrawable(color));
        }
    }

    public static void Toolbaricon(Toolbar t, int i)
    {
        Drawable d=paintHomeDrawables(i);
        t.setNavigationIcon(d);
    }

    public static void Voipcnamebg(TextView t)
    {
        t.setBackgroundColor(tabcolor());
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
        String s = "ActionbarColor";
        final ViewGroup viewGroup = null;
        try {
            final int color = getColor(s, -11);
            Object viewById = viewGroup;
            if (color != -11) {
                viewById = activity.findViewById(zaction_mode_bar());
                ((View)viewById).setBackgroundDrawable(new ColorDrawable(color));
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

    public static int tabcolor() {
        return getColor("Tabcolor", ColorStore.getActionBarColor());
    }

    public static int contactLasSeenString() {
        return getResID("conversation_last_seen", "string");
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

    public static void getWallpaper(final Context ex, final String s, String message) {
        File file2 = null;
        try {
            final File file = new File((ex).getFilesDir().getAbsolutePath(), "wallpaper.jpg");
            file2 = new File(Environment.getExternalStorageDirectory(), String.valueOf("WhatsApp") + "/B58/" + message + "/" + s + "_wallpaper" + ".jpg");
            final FileChannel channel = new FileInputStream(file).getChannel();
            final FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
        } catch (IOException ex2) {
            message = ex2.getMessage();
            Toast.makeText( ex,  ("Failed to Backup wallpaper.jpg to " + file2.getAbsolutePath() + " - " + message), Toast.LENGTH_SHORT).show();
        }
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
            B58.d.setBackgroundColor(color);
        }
        final int color2 = getColor("quoted_name_picker", -11);
        if (color2 != -11) {
            ((TextView)B58.d.findViewById(zquoted_name())).setTextColor(color2);
        }
        final int color3 = getColor("quoted_text_picker", -11);
        if (color3 != -11) {
            ((TextView)B58.d.findViewById(zquoted_text())).setTextColor(color3);
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
            textView.setTextColor(getColor("pagetitle", mainpagercolor()));
    }

    public static Drawable paintHomeDrawables(final int n) {
        final Drawable a = android.support.v4.content.b.a(B58.getCtx(), n);
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

    public static ImageView send_icon(final ImageView imageView, final Context context) {
        imageView.setColorFilter(new PorterDuffColorFilter(context.getSharedPreferences("B58", 0).getInt("sendcolor", ColorStore.send()), PorterDuff.Mode.MULTIPLY));
        return imageView;
    }

    public static void setChatDateColor(final TextView textView, final k k) {
        try {
            String s;
            if (k.b.b) {
                s = "rightdate";
            }
            else {
                s = "leftdate";
            }
            textView.setTextColor(getColor(s, -12303292));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setEntryMod(final MentionableEntry mentionableEntry) {
        mentionableEntry.setTextColor(getColor("textinentry", Color.parseColor("#303031")));
        mentionableEntry.setHintTextColor(getColor("hintinentry", Color.parseColor("#505051")));
    }

    public static int setHomeCounterBK() {
        return getColor("counterbg", unread());
    }

    public static void setHomeIc(final ImageView imageView) {
        int color = mainpagercolor();
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setcallbtn(final ImageView imageView) {
        int color = getColor("callbtncolor",ColorStore.getActionBarColor());
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setQView(final View d) {
        B58.d = d;
        B58.l();
    }

    public static void setStatusNavBar(final Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                final int color = getColor("StatusbarColor", ColorStore.getStatusBarColor());
                final int color2 = getColor("NavbarColor", color);
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
        drawable.setColorFilter(getColor("pagetitle", mainpagercolor()), PorterDuff.Mode.MULTIPLY);
        return drawable;
    }

    public static void text_entry_bgChat(final View view, final Drawable drawable, final Context context) {
        drawable.setColorFilter(getColor("entrybg", ColorStore.getConsBackColor()), PorterDuff.Mode.MULTIPLY);
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
        return getResID("quoted_name", "id");
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
