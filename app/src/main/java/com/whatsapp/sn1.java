package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.app.a;
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

import com.B58works.paintHome;
import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.plus.XMLXplorerActivity;
import com.whatsapp.protocol.j;

/**
 * Created by Bharath.R(58) on 27-12-2017.
 */

public class sn1
{
    public static void BackupPreference2(final Context context, final String s, final String s2) {
        CreateFolder("Themes");
        new File(context.getFilesDir(), "../shared_prefs/B58.xml");
        final File file = new File(Environment.getDataDirectory(), "data/" + context.getPackageName() + "/shared_prefs/" + "B58.xml");
        final File file2 = new File(Environment.getExternalStorageDirectory(), String.valueOf(s2) + s);
        try {
            final FileChannel channel = new FileInputStream(file).getChannel();
            final FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
            Toast.makeText(context, (CharSequence)"Saved", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        catch (IOException ex2) {
            final String message = ex2.getMessage();
            ex2.printStackTrace();
            Toast.makeText(context, (CharSequence)("Failed to Back up user prefs to " + file2.getAbsolutePath() + " - " + message), Toast.LENGTH_SHORT).show();
        }
    }

    public static void ChangeSize(final TextView textView, final int n) {
        if (textView != null) {
            textView.setTextSize((float)(B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getInt("main_text", 15) - n));
            textView.setTextColor(mainTextColor());
        }
    }

    public static void ChatMsgColor(final TextView textView, final Context context, final j j) {
        String s = "left_message_text_color_check";
        try {
            if (j.b.b) {
                s = "right_message_text_color_check";
            }
            if (s.contains("right")) {
                textView.setTextColor(getColor("right_message_text_color_picker", ColorStore.getChatBubbleTextColor()));
            }
            else {
                textView.setTextColor(getColor("left_message_text_color_picker", ColorStore.getChatBubbleTextColorL()));
            }
            textView.setTextSize((float)16);
        }
        catch (Exception ex) {}
    }

    public static void ClearTheme(final Activity activity) {
        B58.ctx.getSharedPreferences("B58", 0).edit().clear().apply();
        Toast.makeText(B58.ctx, (CharSequence)"All are reset to default now.", Toast.LENGTH_SHORT).show();
    }

    public static void ColorBtnInput(final Context context, final View view) {
        final Drawable drawable = context.getResources().getDrawable(B58.getResID("input_circle", "drawable"));
        drawable.setColorFilter(getColor("ModChaSendBKColor", ColorStore.sbg()), PorterDuff.Mode.SRC_ATOP);
        view.setBackgroundDrawable(drawable);
    }

    public static void ColorFab(final Context context, final View view) {
        final Drawable drawable = context.getResources().getDrawable(B58.getResID("input_circle_green", "drawable"));
        drawable.setColorFilter(getColor("ModFab", 0), PorterDuff.Mode.SRC_ATOP);
        view.setBackgroundDrawable(drawable);
    }

    public static void CreateFolder(final String s) {
        final File externalStorageDirectory = Environment.getExternalStorageDirectory();
        for (int i = 0; i <= 2; ++i) {
            if (i == 0) {
                new File(externalStorageDirectory + "/" + "WhatsApp").mkdir();
            }
            else if (i == 1) {
                new File(externalStorageDirectory + "/" + "WhatsApp" + "/B58").mkdir();
            }
            else if (i == 2) {
                new File(externalStorageDirectory + "/" + "WhatsApp" + "/B58/" + s).mkdir();
            }
        }
    }

    @SuppressLint("ResourceType")
    public static void DialogSaveTheme(final Activity activity) {
        final View inflate = LayoutInflater.from((Context)activity).inflate(zeditbox_dialog(), (ViewGroup)null);
        final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder((Context)activity);
        alertDialog$Builder.setView(inflate);
        alertDialog$Builder.setCancelable(false).setPositiveButton(17039370, (DialogInterface.OnClickListener)new com.B58works.extra.ba(activity, (EditText)inflate.findViewById(zetname()))).setNegativeButton(17039360, (DialogInterface.OnClickListener)new com.B58works.extra.ab());
        alertDialog$Builder.create().show();
    }

    public static void DownloadTheme(final Activity activity) {
        Toast.makeText(B58.ctx, (CharSequence)"Waiting for some donations to setup a Themes server.", Toast.LENGTH_SHORT).show();
    }

    public static void LoadTheme(final Activity activity) {
        final Intent intent = new Intent((Context)activity, (Class)XMLXplorerActivity.class);
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.putExtra("FILTER", ".xml");
        activity.startActivityForResult(intent, 6384);
    }

    public static int MainBKC() {
        int n;
            n = getColor("ModConBackColor", ColorStore.getConsBackColor());
        return n;
    }

    public static void ModChatColor(final a a) {
        final int color = getColor("ModChatColor", -11);
        if (color != -11) {
            a.a((Drawable)new ColorDrawable(color));
        }
    }

    public static a ModContPick(final android.support.v7.app.a a) {
        final int color = getColor("ModConPickColor", -11);
        if (color != -11) {
            a.a((Drawable)new ColorDrawable(color));
        }
        return a;
    }

    public static void MsgFromColorChats(final TextView textView) {
        try {
            textView.setTextColor(getColor("chats_from_color_picker", ColorStore.getChatBubbleTextColorL()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void PaintBubbleLeft(final Drawable drawable) {
        try {
            drawable.setColorFilter(getColor("grey_bubble_color_picker", ColorStore.getChatBubbleLeftColor()), PorterDuff.Mode.SRC_IN);
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static void PaintBubbleRight(final Drawable drawable) {
        try {
            drawable.setColorFilter(getColor("green_bubble_color_picker", ColorStore.getChatBubbleRightColor()), PorterDuff.Mode.SRC_IN);
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static void Restart() {
        Process.killProcess(Process.myPid());
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
        String s = "ModConPickColor";
        final ViewGroup viewGroup = null;
        try {
            if (activity instanceof Conversation) {
                s = "ModChatColor";
            }
            final int color = getColor(s, -11);
            Object viewById = viewGroup;
            if (color != -11) {
                viewById = activity.findViewById(zaction_mode_bar());
                ((View)viewById).setBackgroundDrawable((Drawable)new ColorDrawable(color));
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

    public static void chatContactName(final View view) {
        ((TextEmojiLabel)view.findViewById(B58.getResID("conversation_contact_name", "id"))).setTextColor(getColor("ModconnameColor", ColorStore.send()));
    }

    public static int circleColor() {
        return getColor("ModConColor", ColorStore.getActionBarColor());
    }

    public static int contactLasSeenString() {
        return B58.getResID("conversation_last_seen", "string");
    }

    public static int contactOfflineString() {
        return B58.getResID("offline_str", "string");
    }

    public static int contactOnlineString() {
        return B58.getResID("conversation_contact_online", "string");
    }

    public static int contactStatusString() {
        return B58.getResID("contact_status", "string");
    }

    public static void convsContactName(final View view) {
        ((TextView)view.findViewById(B58.getResID("conversations_row_contact_name", "id"))).setTextColor(getColor("ModContactNameColor", mainTextColor()));
    }

    public static void convstatus(final View view) {
        ((TextView)view.findViewById(B58.getResID("conversation_contact_status", "id"))).setTextColor(getColor("ModstatusColor", ColorStore.name()));
    }

    public static int file() {
        return B58.getResID("file", "layout");
    }

    public static int folder_icon() {
        return B58.getResID("folder_icon", "id");
    }

    public static int folder_layout() {
        return B58.getResID("folder_layout", "id");
    }

    public static int folder_name() {
        return B58.getResID("folder_name", "id");
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
            final File file = new File(((Context) ex).getFilesDir().getAbsolutePath(), "wallpaper.jpg");
            file2 = new File(Environment.getExternalStorageDirectory(), String.valueOf("WhatsApp") + "/B58/" + message + "/" + s + "_wallpaper" + ".jpg");
            final FileChannel channel = new FileInputStream(file).getChannel();
            final FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
        } catch (IOException ex2) {
            message = ex2.getMessage();
            Toast.makeText((Context) ex, (CharSequence) ("Failed to Backup wallpaper.jpg to " + file2.getAbsolutePath() + " - " + message), Toast.LENGTH_SHORT).show();
        }
    }

    public static int ic_file() {
        return B58.getResID("ic_file", "drawable");
    }

    public static int ic_folder() {
        return B58.getResID("ic_folder", "drawable");
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
        return B58.getResID("list_selector_background", "drawable");
    }

    public static int list_selector_background_gray() {
        return B58.getResID("list_selector_background_gray", "drawable");
    }

    public static int loglist() {
        return B58.getResID("loglist", "id");
    }

    public static int mainTextColor() {
        return getColor("ModConTextColor", Color.parseColor("#303031"));
    }

    public static int mainpagercolor() {
        return B58.ctx.getSharedPreferences("B58", 0).getInt("HomeBarText", ColorStore.getConsBackColor());
    }

    public static void pagerTitles(final TextView textView, final int n) {
        Label_0019: {
            if (n != -1) {
                break Label_0019;
            }
            while (true) {
                try {
                    textView.setTextColor(getColor("pagetitle_sel_picker", mainpagercolor()));

                    textView.setTextColor(getColor("pagetitle_picker", mainpagercolor()));
                    return;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void paintHome(final ViewGroup viewGroup) {
        try {
            new Handler().post((Runnable)new paintHome(viewGroup));
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static void paintHome(final ViewGroup viewGroup, final Activity activity) {
        try {
            if (!(activity instanceof GroupChatInfo) && !(activity instanceof ContactInfo)) {
                new Handler().post((Runnable)new paintHome(viewGroup));
            }
        }
        catch (Exception ex) {ex.printStackTrace();}
    }

    public static Drawable paintHomeDrawables(final int n) {
        final Drawable a = android.support.v4.content.b.a(B58.getCtx(), n);
        a.setColorFilter(getColor("HomeBarText", -1), PorterDuff.Mode.MULTIPLY);
        return a;
    }

    public static int ppUpdatedString() {
        return B58.getResID("profile_photo_updated", "string");
    }

    public static int profileNameString() {
        return B58.getResID("profile_name", "string");
    }

    public static int readlog() {
        return B58.getResID("readlog", "layout");
    }

    public static int readlog_menu() {
        return B58.getResID("readlog_menu", "menu");
    }

    public static int readlogrow() {
        return B58.getResID("readlogrow", "layout");
    }

    public static ImageView send_icon(final ImageView imageView, final Context context) {
        imageView.setColorFilter((ColorFilter)new PorterDuffColorFilter(context.getSharedPreferences("B58", 0).getInt("send_icon_color_picker", ColorStore.send()), PorterDuff.Mode.MULTIPLY));
        return imageView;
    }

    public static void setChatDateColor(final TextView textView, final j j) {
        try {
            String s;
            if (j.b.b) {
                s = "date_right_color";
            }
            else {
                s = "date_left_color";
            }
            textView.setTextColor(getColor(s, -12303292));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setEntryMod(final MentionableEntry mentionableEntry, final Conversation conversation) {
        mentionableEntry.setTextColor(getColor("textinentry", Color.parseColor("#303031")));
        mentionableEntry.setHintTextColor(getColor("hintinentry", Color.parseColor("#505051")));
    }

    public static void setHomeCounterBK(final TextView textView) {
        final int color = getColor("HomeCounterBK", -11);
        if (color != -11) {
            textView.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static void setHomeIc(final ImageView imageView) {
        int mainTextColor = mainTextColor();
        if (B58.getBoolean("start_bl") && (mainTextColor = mainTextColor) == Color.parseColor("#303031")) {
            mainTextColor = -1;
        }
        imageView.setColorFilter(mainTextColor, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setQView(final View d) {
        B58.d = d;
        B58.l();
    }

    public static void setStatusNavBar(final Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                final int color = getColor("ModDarkConPickColor", ColorStore.getStatusBarColor());
                final int color2 = getColor("ModDarkConPickColorNav", color);
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
        drawable.setColorFilter(getColor("pagetitle_picker", mainpagercolor()), PorterDuff.Mode.MULTIPLY);
        return drawable;
    }

    public static void text_entry_bgChat(final View view, final Drawable drawable, final Context context) {
        drawable.setColorFilter(getColor("entrybg", ColorStore.getConsBackColor()), PorterDuff.Mode.MULTIPLY);
    }

    public static int zaction_mode_bar() {
        return B58.getResID("action_mode_bar", "id");
    }

    public static int zcancel() {
        return B58.getResID("cancel", "id");
    }

    public static int zcolor_hue() {
        return B58.getResID("color_hue", "drawable");
    }

    public static int zcolor_seekselector() {
        return B58.getResID("color_seekselector", "drawable");
    }

    public static int zconversation_actionbar() {
        return B58.getResID("conversation_actionbar", "layout");
    }

    public static int zconversation_contact_global_status() {
        return B58.getResID("conversation_contact_global_status", "id");
    }

    public static int zconversation_contact_photo_frame() {
        return B58.getResID("conversation_contact_photo_frame", "id");
    }

    public static int zeditbox_dialog() {
        return B58.getResID("editbox_dialog", "layout");
    }

    public static int zerror_adding_participant_401() {
        return B58.getResID("error_adding_participant_401", "string");
    }

    public static int zetname() {
        return B58.getResID("etname", "id");
    }

    public static int zexplorer() {
        return B58.getResID("explorer", "layout");
    }

    public static int zforce_stop_msg() {
        return B58.getResID("force_stop_msg", "string");
    }

    public static int zforce_stop_title() {
        return B58.getResID("force_stop_title", "string");
    }

    public static int zicon() {
        return B58.getResID("icon", "drawable");
    }

    public static int ziconid() {
        return B58.getResID("icon", "id");
    }

    public static int zinput_circle() {
        return B58.getResID("input_circle", "id");
    }

    public static int zlabel() {
        return B58.getResID("label", "id");
    }

    public static int zmute_indicator() {
        return B58.getResID("mute_indicator", "id");
    }

    public static int znever() {
        return B58.getResID("never", "string");
    }

    public static int zno() {
        return B58.getResID("no", "string");
    }

    public static int znotifybar_error() {
        return B58.getResID("notifybar_error", "drawable");
    }

    public static int zprimary() {
        return B58.getResID("primary", "color");
    }

    public static int zquoted_name() {
        return B58.getResID("quoted_name", "id");
    }

    public static int zquoted_text() {
        return B58.getResID("quoted_text", "id");
    }

    public static int zrestore_error_msg0() {
        return B58.getResID("restore_error_msg0", "string");
    }

    public static int zrestore_from_sd() {
        return B58.getResID("restore_from_sd", "string");
    }

    public static int zrestore_ok_msg() {
        return B58.getResID("restore_ok_msg", "string");
    }

    public static int zsave_error_msg0() {
        return B58.getResID("save_error_msg0", "string");
    }

    public static int zsave_error_msg1() {
        return B58.getResID("save_error_msg1", "string");
    }

    public static int zsave_success() {
        return B58.getResID("save_success", "string");
    }

    public static int zsaved_to() {
        return B58.getResID("saved_to", "string");
    }

    public static int zseekBarPrefBarContainer() {
        return B58.getResID("seekBarPrefBarContainer", "id");
    }

    public static int zseekBarPrefUnitsLeft() {
        return B58.getResID("seekBarPrefUnitsLeft", "id");
    }

    public static int zseekBarPrefUnitsRight() {
        return B58.getResID("seekBarPrefUnitsRight", "id");
    }

    public static int zseekBarPrefValue() {
        return B58.getResID("seekBarPrefValue", "id");
    }

    public static int zseek_bar_preference() {
        return B58.getResID("seek_bar_preference", "layout");
    }

    public static int zselect_file() {
        return B58.getResID("select_file", "string");
    }

    public static int zstatus() {
        return B58.getResID("status", "id");
    }

    public static int zwamod_style_stockcentered_conversation_actionbar() {
        return B58.getResID("wamod_style_stockcentered_conversation_actionbar", "layout");
    }

    public static int zyes() {
        return B58.getResID("yes", "string");
    }
}
