package com.B58works;

/**
 * Created by Bharath.R(58) on 27-12-2017.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.B58works.plus.Utils;
import com.whatsapp.adm;
import com.whatsapp.data.fr;
import com.whatsapp.Conversation;
import com.whatsapp.GroupChatInfo;
import com.whatsapp.HomeActivity;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.sn1;
import com.whatsapp.cy;
import com.whatsapp.contact.g;
import com.whatsapp.xa;

import a.a.a.a.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import static com.B58works.settings.getDrawable.downloadFile;

public class B58 extends sn1 {
    public static Context ctx;
    public static View quot;
    static Class n;
    public static SQLiteOpenHelper sql;

    static {
        com.B58works.B58.n = B58.class;
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

    public static boolean CallBHide() {
        return getBoolean("call_btn");
    }

    public static void ClearLogs(final Context context) {
        DeleteDirectory(new File(context.getFilesDir() + "/Logs"));
        Toast.makeText(com.B58works.B58.ctx, "WhatsApp Logs have been cleared successfully.", Toast.LENGTH_SHORT).show();
    }

    public static void Contactonl(String s)
    {
        String j;
        if (B58.contact_online_toast()) {
            j = xa.a().b.jabber_id;
            if (j != null) {
                Utils.checkContactOnline(B58.ctx, s, j);
            }
        }
    }

    private static void DeleteDirectory(final File file) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                DeleteDirectory(listFiles[i]);
            }
        }
        file.delete();
    }

    public static void Deletespecial()
    {
        final File file = new File(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        long eligibleForDeletion = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
        if(file.lastModified() <= eligibleForDeletion)
            file.delete();
    }

    public static int Disablefablayout()
    {
        if(getBoolean("hide_fab"))
            return getResID("conversations","layout");
        else
            return getResID("conversations_fab","layout");
    }

    public static int GetCounterId() {
        return com.B58works.B58.ctx.getResources().getIdentifier("counter", "id", com.B58works.B58.ctx.getPackageName());
    }

    public static LinkedHashMap<String, Integer> GetGroupMsgs(final String s) {
        final LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        final Cursor rawQuery = com.B58works.B58.sql.getReadableDatabase().rawQuery("SELECT remote_resource, count(remote_resource) as total FROM messages WHERE key_remote_jid=\"" + s + "\" AND remote_resource!=\"\" GROUP BY remote_resource UNION SELECT remote_resource, count(key_from_me) as total FROM messages WHERE key_remote_jid=\"" + s + "\" AND key_from_me=1 And receipt_server_timestamp!=-1 GROUP BY remote_resource ORDER BY total DESC", (String[])null);
        rawQuery.moveToFirst();
        if (rawQuery != null && rawQuery.getCount() > 0) {
            do {
                linkedHashMap.put(rawQuery.getString(0), rawQuery.getInt(1));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return linkedHashMap;
    }

    public static int GetNIcon() {
        //return Integer.parseInt(B58.ctx.getSharedPreferences("B58", 0).getString("notifybar_colors_list", "13"));
        return getPrefString1("notifybar_colors_list");

    }

    public static void HidePicBar(final Conversation c) {
        if (getBoolean("B58pic")) {
            final FrameLayout f = c.findViewById(sn1.zconversation_contact_photo_frame());
            if (f != null) {
                f.setVisibility(View.GONE);
            }
        }
    }

    public static int LockString() {
        int n;
        if (getBoolean(jid() + "_locked")) {
            n = getResID("unlock", "string");
        }
        else {
            n = getResID("lock", "string");
        }
        return n;
    }

    public static String MaMy_Name2() {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("push_name", "");
    }

    public static String MaMy_Number() {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("registration_jid", "");
    }

    public static String MaMy_status() {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("my_current_status", "");
    }

    static Intent OpenChat(final String s) {
        try {
            return Conversation.a(B58.ctx, s);
        }
        catch (Exception ex) {
            return null;
        }
    }

    public static void SetDB(final SQLiteOpenHelper sql) {
        B58.sql = sql;
    }

    public static void SetGroupChat(final boolean b) {
        SetPrefBool(b);
    }

    public static boolean SetLock() {
        return getBoolean("Locked");
    }

    public static void SetMsgs(String s, final GroupChatInfo groupChatInfo, final View view) {
        final LinkedHashMap<String, Integer> counter = groupChatInfo.Counter;
        final TextView textView = view.findViewById(GetCounterId());
        if (counter != null) {
            textView.setVisibility(View.VISIBLE);
            if (s.equals("me")) {
                s = null;
            }
            if (groupChatInfo.Counter.get(s) == null) {
                textView.setText("0");
            }
            else {
                textView.setText(String.valueOf(groupChatInfo.Counter.get(s)));
            }
        }
    }

    private static void SetPrefBool(final boolean b) {
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.B58works.B58.ctx).edit();
        edit.putBoolean("is_group_chat", b);
        edit.apply();
    }

    private static void SetPrefInt(final int n) {
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.B58works.B58.ctx).edit();
        edit.putInt("gif_provider", n);
        edit.apply();
    }

    public static void SetStatusChat(final Conversation c, final fr f) {
        String s,s1,t;
        com.whatsapp.emoji.c a;
        switch(getPrefString("file_type"))
        {
            default:{s="ModChatGStatusT";s1="ModChatGStatusB";break;}
            case 1:{s="ModChatGStatusT";s1="ModChatGStatusB";break;}
            case 2:{s="contact_global_status_mod_picker";s1="contact_global_bg_status_mod_picker";break;}
        }
            final TextView textView = c.findViewById(getResID("conversation_contact_global_status", "id"));
            if (wacontactfinder(f)) {
                SetGroupChat(true);
            }
            else {
                SetGroupChat(false);
                t= f.t;
                a=c.cR;
                textView.setText(d.a(t, c, textView.getPaint(),a));
                textView.setTextColor(sn1.getColor(s, -1));
                textView.setSelected(true);
                textView.setBackgroundColor(sn1.getColor(s1, Color.parseColor("#44000000")));
                if (statuschat()) {
                    textView.setVisibility(View.VISIBLE);
                    clickcopytext(textView);
                    return;
                }
            }
            textView.setVisibility(View.GONE);


    }

    public static void ShowName(final android.support.v7.app.a a) {
        if (getBoolean("show_my_name_check")) {
            a.a(MaMy_Name2());
            if (getBoolean("subhead")) {
                if (getBoolean("number")) {
                    a.b(MaMy_Number());
                }
                else {
                    a.b(MaMy_status());
                }
            }
        }
    }

    public static void TxtSelect(final TextEmojiLabel t) {
        if (getBoolean("TxtSelect")) {
            t.setTextIsSelectable(true);
            t.setLinksClickable(true);
        }
    }

    public static Class a() {
        Serializable s;
        if (!getBoolean("Locked")) {
            s = HomeActivity.class;
        }
        else if (getBoolean("pt_enabled")) {
            s = pattern.class;
        }
        else {
            s = Locks.class;
        }
        return (Class)s;
    }

    public static int actionbar() {
        int n;
        if (getBoolean( "actionbar")) {
            n = sn1.zwamod_style_stockcentered_conversation_actionbar();
        }
        else {
            n = sn1.zconversation_actionbar();
        }
        return n;
    }

    public static void addMenu(final HomeActivity homeActivity, final MenuItem menuItem) {
        if(getBoolean("hide_fab"))
        {
            if (menuItem.getItemId() == getResID("B58textmods", "id")) {
                downloadFile();
                //sleep();
                homeActivity.startActivity(new Intent(homeActivity, com.B58works.settings.textmods.newSettings.class));
            }
            if (menuItem.getItemId() == getResID("B58visualmods", "id")) {
                downloadFile();
                //sleep();
                homeActivity.startActivity(new Intent(homeActivity, com.B58works.settings.visualmods.newSettings.class));
            }
        }
        if (menuItem.getItemId() == getResID("restart", "id")) {
            rebootApp(homeActivity);
        }
        if(menuItem.getItemId() == getResID("openc", "id")){
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(homeActivity);
            builder.setTitle("New Chat");
            builder.setMessage("Enter Number");
            final EditText input = new EditText(homeActivity);
            input.setHint("Ex: 91 1234512345");
            builder.setView(input);
            builder.setPositiveButton("Message!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String number = input.getText().toString().trim().replace("+", "").replace(" ", "");
                            String s = number + "@s.whatsapp.net";
                            if (number.contains("-")) {
                                s = number + "@g.us";
                            }
                            homeActivity.startActivity(com.B58works.B58.OpenChat(s));
                        }
                    });
            builder.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder.show();
        }
        /*if(menuItem.getItemId() == getResID("special","id")){
            downloadFile();
            sleep();
            homeActivity.startActivity(new Intent(homeActivity, com.B58works.settings.WishPage.class));}*/

    }

    public static void sleep()
    {
        try {
            Thread.sleep(4000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /*public static void b581(final DialogInterface dialogInterface, final int n) {
        dialogInterface.dismiss();
    }

    public static void b582(final fq f, final Activity activity, final boolean b, final DialogInterface dialogInterface, final int n) {
        cx.a().a(f, activity, 8, b, true);
    }

    public static void b583(final fq f, final Activity activity, final boolean b, final DialogInterface dialogInterface, final int n) {
        switch (n) {
            case 0: {
                cx.a().a(f, activity, 8, b, false);
                break;
            }
            case 1: {
                b584(activity);
                break;
            }
            case 2: {
                b585(activity);
                break;
            }
        }
    }

    public static void b584(final Activity activity) {
        try {
            activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:+" + g.b(Privacy.JID))));
        }
        catch (ActivityNotFoundException ex) {
            Toast.makeText(B58.ctx, "No dialer app found. Please check.", Toast.LENGTH_SHORT).show();
        }
    }

    public static void b585(final Activity activity) {
        try {
            activity.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:+" + g.b(Privacy.JID))));
        }
        catch (ActivityNotFoundException ex) {
            Toast.makeText(B58.ctx, "No messaging app found. Please check.", Toast.LENGTH_SHORT).show();
        }
    }*/

    @SuppressLint("ResourceType")
    public static void callDlg(final fr f, final Activity activity, final boolean b) {
        final String string = getString("audio_call");
        final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(activity);
        if (b) {
            alertDialog$Builder.setMessage(getString("video_call_confirmation_text")).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //b581(dialogInterface,i);
                    dialogInterface.dismiss();
                }
            }).setPositiveButton(getString("call"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //b582(f,activity,b,dialogInterface,i);
                    cy.a().a(f, activity, 8, b, true);
                }
            });
        }
        else {
            alertDialog$Builder.setItems(new String[]{string, "Call over SIM", "Send text message"}, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0: {
                            cy.a().a(f, activity, 8, b, false);
                            break;
                        }
                        case 1: {
                            try {
                                activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:+" + g.b(Privacy.JID))));
                            }
                            catch (ActivityNotFoundException ex) {
                                Toast.makeText(B58.ctx, "No dialer app found. Please check.", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                        case 2: {
                            try {
                                activity.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:+" + g.b(Privacy.JID))));
                            }
                            catch (ActivityNotFoundException ex) {
                                Toast.makeText(B58.ctx, "No messaging app found. Please check.", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }
                }
            });
        }
        alertDialog$Builder.create().show();
    }

    public static void clickcopytext(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=textView.getText().toString();
                ((ClipboardManager)ctx.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("text", s));
                Toast.makeText(ctx, getString("B58Copy"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void copystatus(final TextView t)
    {
        if (t.getPaddingRight() > 8 && t.getId() == zstatus())
        {
            clickcopytext(t);
        }
    }

    public static boolean contact_online_toast() {
        return getBoolean("contact_online_toast");
    }

    public static String contactstringsfinder(final fr f) {
        return com.whatsapp.fy.a().b(f);
    }

    public static void copyFile(final String s, final String s2) throws IOException {
        try {
            final File file = new File(s);
            final File file2 = new File(s2);
            final FileInputStream fileInputStream = new FileInputStream(file);
            final FileOutputStream fileOutputStream = new FileOutputStream(file2);
            final byte[] array = new byte[1024];
            while (true) {
                final int read = fileInputStream.read(array);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(array, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static boolean getBoolean(final String s) {
        return com.B58works.B58.ctx.getSharedPreferences("B58", 0).getBoolean(s, false);
        /*Boolean b= PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(s,false);
        B58.ctx.getSharedPreferences("B58", 0).edit().putBoolean(s, b).apply();
        return B58.ctx.getSharedPreferences("B58", 0).getBoolean(s, false);*/
    }

    public static int getContactStatusStr() {
        return getResID("conversations_contact_status1", "id");
    }

    public static boolean getHideInfo() {
        return getBoolean("B58_hideinfo");
    }

    public static int getID(final String s, final String s2) {
        int n = getfreqidq(s);
        if (n == -1) {
            n = com.B58works.B58.ctx.getResources().getIdentifier(s, s2, com.B58works.B58.ctx.getPackageName());
        }
        return n;
    }

    public static int getNIcon() {
        return com.B58works.B58.ctx.getResources().getIdentifier("n_" + GetNIcon(), "drawable", com.B58works.B58.ctx.getPackageName());
    }

    public static int getPrefString(final String s) {
        return Integer.parseInt(B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString(s, "0"));
    }

    public static int getPrefString1(final String s) {
        return Integer.parseInt(B58.ctx.getSharedPreferences("B58", 0).getString(s, "0"));
    }

    public static int getResID(final String s, final String s2) {
        return com.B58works.B58.ctx.getResources().getIdentifier(s, s2, com.B58works.B58.ctx.getPackageName());
    }

    public static String getString(final String s) {
        return com.B58works.B58.ctx.getString(getResID(s, "string"));
    }

    public static String getStringpref(final String s) {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString(s, "");
    }

    public static int getfreqidq(final String s) {
        int int1 = -1;
        try {
            final Field declaredField = com.B58works.B58.n.getDeclaredField(s.toLowerCase(Locale.ENGLISH));
            int1 = declaredField.getInt(declaredField);
            return int1;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return int1;
        }
    }

    public static void init(final Context sctx) {
        Status.b = new HashMap();
        if (sctx instanceof Activity) {
            com.B58works.B58.ctx = sctx.getApplicationContext();
            Privacy.pctx = sctx.getApplicationContext();
        }
        else {
            com.B58works.B58.ctx = sctx;
            Privacy.pctx = sctx;
        }
        if (com.B58works.B58.ctx == null || Privacy.pctx == null) {
            Log.d("B58Mods", "Context var initialized to NULL!!!");
        }
        Deletespecial();
        tgchooser();
    }

    public static Intent isLocked(final Intent intent) {
        final String stringExtra = intent.getStringExtra("jid");
        final String substring = stringExtra.substring(0, stringExtra.indexOf("@"));
        Intent intent2 = intent;
        if (getBoolean(substring + "_locked")) {
            if (getBoolean("pt_enabled")) {
                intent2 = new Intent(B58.ctx, pattern.class).putExtra("jid", substring).putExtra("intent", intent);
            }
            else {
                intent2 = new Intent(B58.ctx, Locks.class).putExtra("jid", substring).putExtra("intent", intent);
            }
        }
        return intent2;
    }

    public static boolean isNetworkAvailable() {
        try {
            final ConnectivityManager connectivityManager = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        }
        catch (Exception ex) {
            return false;
        }
    }

    public static boolean isOnline(final Context context) {
        return ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    public static String jid() {
        return B58.ctx.getSharedPreferences("B58", 0).getString("jid", "");
    }

    public static Class m1() {
        Serializable s;
        if (!getBoolean("Locked")) {
            s = Conversation.class;
        }
        else {
            if (getBoolean("pt_enabled")) {
                s = pattern.class;
            }
            else
                s=Locks.class;
        }
        return (Class)s;
    }

    public static Intent notifIn(Intent putExtra) {
        if (getBoolean("Locked")) {
            putExtra = new Intent(ctx, a()).putExtra("intent", putExtra);
        }
        return putExtra;
    }

    public static int oldui() {
        int n;
        if (getBoolean("oldui")) {
            n = getResID("homeo", "layout");
        }
        else {
            n = getResID("home", "layout");
        }
        return n;
    }

    public static boolean onlinechat() {
        return getBoolean("onlinechat");
    }

    public static void presencemanagerfinder(final String f) {
        adm.a().c(f);
    }

    public static void putInt(final String s, final int n) {
        B58.ctx.getSharedPreferences("B58", 0).edit().putInt(s, n).commit();
    }

    public static void putString(final String s, final String s2) {
        B58.ctx.getSharedPreferences("B58", 0).edit().putString(s, s2).commit();
    }

    public static void rebootApp(final Context context) {
        ((AlarmManager)context.getSystemService(Context.ALARM_SERVICE)).set(AlarmManager.RTC, 100L + System.currentTimeMillis(), PendingIntent.getActivity(context, 123456, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), PendingIntent.FLAG_CANCEL_CURRENT));
        System.exit(0);
    }

    public static void setLock(final Activity activity) {
        final String jid = jid();
        if (getBoolean(jid + "_locked")) {
            B58.ctx.getSharedPreferences("B58", 0).edit().putBoolean(jid + "_locked", false).apply();
        }
        else if (getBoolean("pt_enabled")) {
            activity.startActivity(new Intent(activity, patternC.class).putExtra("jid", jid));
        }
        else {
            activity.startActivity(new Intent(activity, LocksC.class).putExtra("jid", jid));
        }
    }

    public static MenuItem setMenuC(final Menu menu) {
        return menu.add(1, getResID("openc", "id"), 0, getResID("opench", "string"));
    }

    public static MenuItem setMenuR(final Menu menu) {
        return menu.add(1, getResID("restart", "id"), 0, getResID("B58Restart", "string"));
    }

    public static MenuItem setMenutS(final Menu menu) {
        return menu.add(1, getResID("B58textmods", "id"), 0, getResID("B58textsettingstitle", "string"));
    }

    public static MenuItem setMenuvS(final Menu menu) {
        return menu.add(1, getResID("B58visualmods", "id"), 0, getResID("B58visualsettingstitle", "string"));
    }

    public static MenuItem setMenusp(final Menu menu) {
        return menu.add(1, getResID("special", "id"), 0, getResID("special", "string"));
    }

    public static void setMenuNC(final Menu menu) {
        if(!getBoolean("hide_fab"))
        {
            MenuItem m=menu.add(1, getResID("menuitem_new_conversation", "id"), 0, getResID("menuitem_new", "string"));
            int i=getResID("ic_action_compose","drawable");
            m.setIcon(i);
            m.setShowAsAction(2);
            menuic(m);
        }

    }

    public static void menu(final Menu m)
    {
        if(getBoolean("hide_fab"))
        {
            setMenutS(m);
            setMenuvS(m);
        }
        setMenuR(m);
        setMenuC(m);
        //setMenusp(m);
    }
    public static void setStatusText(final fr f, final TextView textView) {
        String s,s1;
        switch(getPrefString("file_type"))
        {
            default:{s="ModOnlineColor";s1="ModlastseenColor";break;}
            case 1:{s="ModOnlineColor";s1="ModlastseenColor";break;}
            case 2:{s="chats_status_online_text_color_picker";s1="chats_status_text_color_picker";break;}
        }
            if (Privacy.HideSeen() || wacontactfinder(f) || !onlinechat() || (!isNetworkAvailable())) {
                textView.setVisibility(View.GONE);
                return;
            }
            presencemanagerfinder(f.s);
            final String replace = contactstringsfinder(f).replace("last seen", "");
            if (replace.contains("online")) {
                textView.setTextColor(sn1.getColor(s));
                textView.setTypeface(textView.getTypeface(), 1);
            }
            else {
                textView.setTextColor(sn1.getColor(s1));
                textView.setTypeface(textView.getTypeface(), 0);
            }
            textView.setText(replace);
            textView.setVisibility(View.VISIBLE);

    }

    public static boolean statuschat() {
        return getBoolean("statuschat");
    }

    public static String stripJID(String s) {
        if (s.contains("@g.us") || s.contains("@s.whatsapp.net") || s.contains("@broadcast")) {
            s = s.substring(0, s.indexOf("@"));
        }
        return s;
    }

    private static void tgchooser() {
        int n = 1;
        if (!getBoolean("tgchoose")) {
            n = 0;
        }
        SetPrefInt(n);
    }

    public static boolean wacontactfinder(final fr f) {
        return f.a();
    }

    public static void cmenu(final int i, final Activity a)
    {
        if(i==22)
            setLock(a);
    }
}
