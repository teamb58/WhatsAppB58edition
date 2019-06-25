package com.whatsapp.plus;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.provider.ContactsContract;

import com.B58works.R;
import com.whatsapp.Conversation;

public class Utils {

    static void setAppPrefBoolean(final Context context, final String s, final Boolean b) {
        final SharedPreferences.Editor edit = context.getSharedPreferences("B58", 0).edit();
        edit.putBoolean(s, b);
        edit.commit();
    }

    public static void openChat(Context context, String str) {
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id"}, "data1=?", new String[]{str}, null);
            if (query.moveToFirst() && query.getCount() > 0) {
                query.moveToFirst();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("content://com.android.contacts/data/" + query.getString(0)));
                if (str.contains("@g.us")) {
                    intent = new Intent(context, Conversation.class);
                }
                try {
                    intent.putExtra("jid", str);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP + Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage(context.getResources().getString(R.string.packagename));
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                query.close();
            }
        } catch (CursorIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }

}
