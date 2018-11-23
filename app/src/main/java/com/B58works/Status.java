package com.B58works;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import com.whatsapp.MediaData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getResID;

public class Status{

    public static int S=0;
    public static HashMap T;

    public static void za(final Activity activity, String d) {
        if (T != null && !T.isEmpty()) {
            final List<com.whatsapp.protocol.a.p> list = (List<com.whatsapp.protocol.a.p>) T.get(d);
            if (list.get(S) instanceof com.whatsapp.protocol.a.p && list.get(S).L != null) {
                final MediaData m=list.get(S).L;
                File file = m.file;
                if (file != null) {
                    if (file.getAbsolutePath().endsWith("mp4")) {
                        e(activity, file, "video/*");
                    }
                    else {
                        e(activity, file, "image/*");
                    }
                }
            }
            else {
                final List<com.whatsapp.protocol.n> list1 = (List<com.whatsapp.protocol.n>) T.get(d);
                d = list1.get(S).b();
                if (d != null) {
                    if (Build.VERSION.SDK_INT < 11) {
                        ((ClipboardManager)activity.getSystemService(Context.CLIPBOARD_SERVICE)).setText(d);
                    }
                    else {
                        ((android.content.ClipboardManager)activity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("textlabel", d));
                    }
                    Toast.makeText(ctx,"Status copied to clipboard",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public static void e(final Activity ex, final File file, final String s) {
        Serializable s2 = new SimpleDateFormat("yyyyMMddHHmmss");
        final Date date = new Date();
        if (s.equals("video/*"))
            s2 = new File(Environment.getExternalStorageDirectory(), "/WhatsApp/Media/WhatsApp Status/VID-" + ((DateFormat)s2).format(date) + ".mp4");
        else if(s.equals("image/*"))
            s2 = new File(Environment.getExternalStorageDirectory(), "/WhatsApp/Media/WhatsApp Status/IMG-" + ((DateFormat)s2).format(date) + ".jpg");
        if (!new File(Environment.getExternalStorageDirectory(), "/WhatsApp/Media/WhatsApp Status").exists()) {
            p();
        }
        try {
            final FileChannel channel = new FileInputStream(file).getChannel();
            final FileChannel channel2 = new FileOutputStream((File)s2).getChannel();
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
            a(ex, (File)s2, s);
            Toast.makeText(ex, "Status media successfully saved to WhatsApp/Media/WhatsApp Status .", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex2) {
            Toast.makeText(ex, ("Failed to save photo " + ((File)s2).getAbsolutePath() + " - " + ex2.getMessage()), Toast.LENGTH_SHORT).show();
        }
    }

    public static void p() {
        try {
            final File externalStorageDirectory = Environment.getExternalStorageDirectory();
            for (int i = 0; i <= 2; ++i) {
                if (i == 0) {
                    new File(externalStorageDirectory + "/WhatsApp").mkdir();
                }
                else if (i == 1) {
                    new File(externalStorageDirectory + "/WhatsApp/Media").mkdir();
                }
                else if (i == 2)
                    new File(externalStorageDirectory + "/WhatsApp/Media/WhatsApp Status").mkdir();
            }
        }
        catch (Exception ex) {}
    }

    public static void a(final Context context, final File file, final String s) {
        if (Build.VERSION.SDK_INT >= 20) {
            if (s.equals("video/*")) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("_data", file.getAbsolutePath());
                contentValues.put("mime_type", "video/mp4");
                contentValues.put("date_added", System.currentTimeMillis());
                context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            }
            else if (s.equals("image/*")) {
                final ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_data", file.getAbsolutePath());
                contentValues2.put("mime_type", "image/jpeg");
                contentValues2.put("date_added", System.currentTimeMillis());
                context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
            }
        }
        else if (Build.VERSION.SDK_INT >= 19) {
            final Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        }
        else {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        }
    }

    public static String g(final String s) {
        if (T != null) {
            if (T.isEmpty()) {
                return ctx.getString(getResID("mediadownload","string"));
            }
            final List<com.whatsapp.protocol.a.p> list = (List<com.whatsapp.protocol.a.p>) T.get(s);
            if (list.get(S) instanceof com.whatsapp.protocol.a.p && list.get(S).L != null) {
                return ctx.getString(getResID("mediadownload","string"));
            }
        }
        return ctx.getString(getResID("textcopy","string"));
    }

    public static Object y(final Object o, final String s) {
        HashMap t;
        if (o instanceof List) {
            T.put(s, o);
            t = T;
        }
        else {
            t = null;
        }
        return t;
    }

    public static int statusmenu()
    {
        return com.B58works.B58.getResID("statusmenu","id");
    }
}
