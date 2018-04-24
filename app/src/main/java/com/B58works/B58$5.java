package com.B58works;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import com.whatsapp.MediaData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

class B58$5
{
    static int a;
    static HashMap b;
    static String c;
    private static File d;

    static void a() throws IOException {
        if (b()) {
            if (d()) {
                Toast.makeText(B58.ctx, (CharSequence)"Status saved to WhatsApp/Media/Contacts Status", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(B58.ctx, (CharSequence)"Connection Error..Try again later", Toast.LENGTH_LONG).show();
        }
    }

    private static boolean b() {
        try {
            d = ((MediaData)((com.whatsapp.protocol.k)((List)b.get(c)).get(a)).A).file;
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
            return file.getPath() + File.separator + (B58.stripJID(B58$5.c) + "_status_" + B58$5.d.getName());
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
            Toast.makeText(B58.ctx, (CharSequence)("Error accessing file: " + ex.getMessage()), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (new File(c).exists()) {
            Toast.makeText(B58.ctx, (CharSequence)"Already saved!", Toast.LENGTH_LONG).show();
            return false;
        }
        B58.copyFile(B58$5.d.getPath(), c);
        B58.ctx.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(c))));
        return true;
    }
}
