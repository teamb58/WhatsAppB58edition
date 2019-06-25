package com.B58works;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.net.Uri;
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
import com.whatsapp.Conversation;
import com.whatsapp.HomeActivity;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.sn1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import d.f.B1.f;
import d.f.uC;
import d.f.o1.g;
import c.a.a1.a;

import static com.B58works.BooleanMethods.getBoolean;
import static com.B58works.BooleanMethods.isNetworkAvailable;
import static com.B58works.BooleanMethods.onlinechat;

/**
 * Created by Bharath.R(58) on 19-01-2019.
 */

public class B58 extends sn1 {
    public static Context ctx;
    public static SharedPreferences pref;
    public static SharedPreferences.Editor prefEdit;
    public static Class n;
    public static SQLiteOpenHelper sql;
    private static LinkedHashMap<String, Integer> Counter;
    public static Conversation conversation;

    static {
        n = B58.class;
    }

    public static void setConversation(Conversation conversation) {
        B58.conversation = conversation;
    }

    public static String MaMy_Name2() {
        return ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("push_name", "");
    }

    public static void ClearLogs(final Context context) throws IOException {
        FileUtils.cleanDirectory(new File(context.getFilesDir() + "/Logs"));
        Toast.makeText(com.B58works.B58.ctx, "WhatsApp Logs have been cleared successfully.", Toast.LENGTH_SHORT).show();
    }

    static void putInt(final String s, final int n) {
        prefEdit.putInt(s, n).commit();
    }

    public static int Disablefablayout() {
        if (BooleanMethods.hidefab())
            return IDGen.layout.conversations;
        else
            return IDGen.layout.conversations_fab;
    }

    public static void CallBHide(MenuItem m) {
        if (getBoolean("callbtn"))
            m.setShowAsAction(0);
    }

    public static void Contactonl(String s) {
        String j;
        if (BooleanMethods.contact_online_toast()) {
            j = uC.c().e.jabber_id;
            if (j != null) {
                Utils.checkContactOnline(ctx, s, j);
            }
        }
    }

    public static int getNIcon() {
        return com.B58works.B58.ctx.getResources().getIdentifier("n_" + GetNIcon(), "drawable", com.B58works.B58.ctx.getPackageName());
    }

    public static void init(final Context context) {
        //Status.T = new HashMap();
        pref = context.getSharedPreferences("B58", 0);
        prefEdit = pref.edit();
        if (context instanceof Activity) {
            ctx = context.getApplicationContext();
        } else {
            ctx = context;
        }
        if (ctx == null) {
            Log.d("B58Mods", "Context var initialized to NULL!!!");
        }
        //Deletespecial();
        tgchooser();
    }

    public static int oldui() {
        if (getBoolean("oldui")) {
            return IDGen.layout.homeo;
        } else {
            return IDGen.layout.home;
        }
    }

    private static void rebootApp(final Context context) {
        ((AlarmManager) context.getSystemService(Context.ALARM_SERVICE)).set(AlarmManager.RTC, 100L + System.currentTimeMillis(), PendingIntent.getActivity(context, 123456, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), PendingIntent.FLAG_CANCEL_CURRENT));
        System.exit(0);
    }

    private static void setMenuC(final Menu menu) {
        menu.add(1, IDGen.id.openc, 0, IDGen.string.opench);
    }

    private static void setMenuR(final Menu menu) {
        menu.add(1, IDGen.id.restart, 0, IDGen.string.B58Restart);
    }

    private static void setMenutS(final Menu menu) {
        menu.add(1, IDGen.id.B58textmods, 0, IDGen.string.B58textsettingstitle);
    }

    private static void setMenuvS(final Menu menu) {
        menu.add(1, IDGen.id.B58visualmods, 0, IDGen.string.B58visualsettingstitle);
    }

    public static void setMenuNC(final Menu menu) {
        if (!getBoolean("hide_fab")) {
            MenuItem m = menu.add(1, IDGen.id.menuitem_new_conversation, 0, IDGen.string.menuitem_new);
            int i = IDGen.drawable.ic_action_compose;
            m.setIcon(i);
            m.setShowAsAction(2);
            menuic(m);
        }

    }

    public static void menu(final Menu m) {
        if (getBoolean("hide_fab")) {
            setMenutS(m);
            setMenuvS(m);
        }
        setMenuR(m);
        setMenuC(m);
        //setMenusp(m);
    }

    private static String contactstringsfinder() {
        return d.f.nw.a().a(conversation.df);
    }

    private static void presencemanagerfinder(Conversation conversation) {
        d.f.bF.b().e(conversation.df.I);
    }

    public static void setStatusText(final View view) {
        TextView textView = view.findViewById(getContactStatusStr());
        String online = "online";
        String ls = "lastseen";

        if (Privacy.HideSeen() || wacontactfinder(conversation) || !onlinechat() || (!isNetworkAvailable())) {
            textView.setVisibility(View.GONE);
            return;
        }
        presencemanagerfinder(conversation);
        final String replace = contactstringsfinder().replace("last seen", "");
        if (replace.contains("online")) {
            textView.setTextColor(B58.getColor(online));
        } else {
            textView.setTextColor(B58.getColor(ls));
        }
        textView.setText(replace);
        textView.setVisibility(View.VISIBLE);
    }

    private static void tgchooser() {
        int n = 1;
        if (!getBoolean("gifchoose")) {
            n = 0;
        }
        SetPrefInt(n);
    }

    private static void SetPrefInt(final int n) {
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.B58works.B58.ctx).edit();
        edit.putInt("gif_provider", n);
        edit.apply();
    }

    public static void GroupMsgs(final String s)
    {
        Counter=GetGroupMsgs(s);
    }

    private static LinkedHashMap<String, Integer> GetGroupMsgs(final String s) {
        final LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        final Cursor rawQuery = com.B58works.B58.sql.getReadableDatabase().rawQuery("SELECT remote_resource, count(remote_resource) as total FROM messages WHERE key_remote_jid=\"" + s + "\" AND remote_resource!=\"\" GROUP BY remote_resource UNION SELECT remote_resource, count(key_from_me) as total FROM messages WHERE key_remote_jid=\"" + s + "\" AND key_from_me=1 And receipt_server_timestamp!=-1 GROUP BY remote_resource ORDER BY total DESC", (String[]) null);
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
        return getIntofList("notifyicon");

    }

    public static void HidePicBar(final Conversation c) {
        if (getBoolean("profpic")) {
            final FrameLayout f = c.findViewById(IDGen.id.conversation_contact_photo_frame);
            if (f != null) {
                f.setVisibility(View.GONE);
            }
        }
    }

    public static String MaMy_Number() {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("registration_jid", "");
    }

    public static String MaMy_status() {
        return B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getString("my_current_status", "");
    }

    public static Intent OpenChat(final String s) {
        try {
            return a(ctx, s);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Intent a(final Context c, final String s) {
        return new Intent(c, Conversation.class).putExtra("jid", s).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP + Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public static void SetDB(final SQLiteOpenHelper sqLiteOpenHelper) {
        sql = sqLiteOpenHelper;
    }

    public static void SetMsgs(String s, final View view) {
        final LinkedHashMap<String, Integer> counter = Counter;
        final TextView textView = view.findViewById(IDGen.id.counter);
        if (counter != null) {
            textView.setVisibility(View.VISIBLE);
            if (s.equals("me")) {
                s = null;
            }
            if (Counter.get(s) == null) {
                textView.setText("0");
            } else {
                textView.setText(String.valueOf(Counter.get(s)));
            }
        }
    }

    public static boolean wacontactfinder(Conversation conversation) {
        return conversation.df.h();
    }

    public static void SetStatusChat(Conversation conversation) {
        String text = "statustext";
        String bg = "statusbg";
        TextView textView = conversation.findViewById(IDGen.id.conversation_contact_global_status);
        if (wacontactfinder(conversation)) {
            if (!BooleanMethods.statuschat()) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setText(f.a(conversation.df.E.e, conversation, conversation.dd));
                textView.setSelected(true);
                textView.setTextColor(getColor(text, -1));
                textView.setBackgroundColor(getColor(bg, Color.parseColor("#44000000")));
                textView.setVisibility(View.VISIBLE);
                clickcopytext(textView);
            }
            if (textView.getText().toString().isEmpty()) {
                textView.setVisibility(View.GONE);
            }
            SetGroupChat(true);
        } else if ((conversation.df.o).endsWith("@broadcast")) {
            textView.setVisibility(View.GONE);
            SetGroupChat(true);
        } else {
            if (!BooleanMethods.statuschat()) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setText(f.a(conversation.df.p, conversation, conversation.hd));
                textView.setSelected(true);
                textView.setTextColor(getColor(text, -1));
                textView.setBackgroundColor(getColor(bg, Color.parseColor("#44000000")));
                textView.setVisibility(View.VISIBLE);
                clickcopytext(textView);
            }
            if (textView.getText().toString().isEmpty()) {
                textView.setVisibility(View.GONE);
            }
            SetGroupChat(false);
        }
    }

    public static void SetGroupChat(final boolean b) {
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.B58works.B58.ctx).edit();
        edit.putBoolean("is_group_chat", b);
        edit.apply();
    }

    public static void ShowName(final a a) {
        if (getBoolean("actbartitle")) {
            a.a(MaMy_Name2());
            int i=getIntofList("actbarsubtitle");
            if(i==1)
                a.b(MaMy_Number());
            else if(i==2)
                a.b(MaMy_status());
        }
    }

    public static void TxtSelect(final TextEmojiLabel t) {
        if (getBoolean("txtselect")) {
            t.setTextIsSelectable(true);
            t.setLinksClickable(true);
        }
    }

    public static int actionbar() {

        if (getBoolean("centeraction")) {
            return IDGen.layout.wamod_style_stockcentered_conversation_actionbar;
        } else {
            return IDGen.layout.conversation_actionbar;
        }

    }

    public static void addMenu(final HomeActivity homeActivity, final MenuItem menuItem) {
        if (getBoolean("hide_fab")) {
            if (menuItem.getItemId() == IDGen.id.B58textmods) {
                homeActivity.startActivity(new Intent(homeActivity, com.B58works.settings.textmods.newSettings.class));
            }
            if (menuItem.getItemId() == IDGen.id.B58visualmods) {
                homeActivity.startActivity(new Intent(homeActivity, com.B58works.settings.visualmods.newSettings.class));
            }
        }
        if (menuItem.getItemId() == IDGen.id.restart) {
            rebootApp(homeActivity);
        }
        if (menuItem.getItemId() == IDGen.id.openc) {
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

    }

    public static void callDlg(final Activity activity, final boolean b) {
        final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(activity);
        if (b) {
            alertDialog$Builder.setMessage(IDGen.string.video_call_confirmation_text).setNegativeButton(IDGen.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setPositiveButton(IDGen.string.call, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    conversation.qd.a(conversation.df, activity, 8, b, true);
                }
            });
        } else {
            alertDialog$Builder.setItems(new String[]{"Voice Call", "Call over SIM", "Send text message"}, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0: {
                            conversation.qd.a(conversation.df, activity, 8, b, false);
                            break;
                        }
                        case 1: {
                            try {
                                activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:+" + g.a(Privacy.JID))));
                            } catch (ActivityNotFoundException ex) {
                                Toast.makeText(ctx, "No dialer app found. Please check.", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                        case 2: {
                            try {
                                activity.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:+" + g.a(Privacy.JID))));
                            } catch (ActivityNotFoundException ex) {
                                Toast.makeText(ctx, "No messaging app found. Please check.", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }
                }
            });
        }
        alertDialog$Builder.create().show();
    }

    private static void clickcopytext(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textView.getText().toString();
                ((ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("text", s));
                Toast.makeText(ctx, ctx.getText(IDGen.string.B58copy), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void copystatus(final TextView t) {
        if (t.getPaddingRight() > 8 && t.getId() == IDGen.id.status) {
            clickcopytext(t);
        }
    }

    public static int getContactStatusStr() {
        return IDGen.id.conversations_contact_status1;
    }

}
