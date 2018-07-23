package com.B58works;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.whatsapp.MediaData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Status {

    static int a;
    static HashMap b;
    static String c;
    private static File d;

    public static void a() throws IOException {
        if (b()) {
            if (d()) {
                Toast.makeText(B58.ctx, "Status saved to WhatsApp/Media/Contacts Status", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(B58.ctx, "Connection Error..Try again later", Toast.LENGTH_LONG).show();
        }
    }

    private static boolean b() {
        try {
            d = ((MediaData)((com.whatsapp.protocol.k)((List)b.get(c)).get(a)).s).file;
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    private static String c() {
        try {
            final File file = new File(Environment.getExternalStorageDirectory() + File.separator + "WhatsApp" + File.separator + "Media" + File.separator + "Contacts Status");
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return file.getPath() + File.separator + (B58.stripJID(c) + "_status_" + d.getName());
        }
        catch (Exception ex) {
            return null;
        }
    }

    private static boolean d() throws IOException {
        String c;
        try {
            c = c();
            if (c == null) {
                throw new IOException();
            }
        }
        catch (Exception ex) {
            Toast.makeText(B58.ctx, ("Error accessing file: " + ex.getMessage()), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (new File(c).exists()) {
            Toast.makeText(B58.ctx, "Already saved!", Toast.LENGTH_LONG).show();
            return false;
        }
        B58.copyFile(d.getPath(), c);
        B58.ctx.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(c))));
        return true;
    }

    public static void collectStories(final List list, final String s) {
        b.put(s, list);
    }

    public static void setCP(final int ab) {
        a = ab;
    }

    public static void setVw(final View view) {
        if (view == null) {
            return;
        }
        try {
            (view.findViewById(B58.getID("div2", "id"))).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        a();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (Exception ex) {}
    }

    public static void setplaying(final String c1) {
        if (c != null && (!c.equals(c1))) {
            setCP(0);
        }
        c = c1;
    }
}
