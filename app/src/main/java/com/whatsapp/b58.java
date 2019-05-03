package com.whatsapp;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Bharath.R(58) on 26-01-2019.
 */

public class b58 {

    public static void BackupPreference2(Context context, String str, String str2) {
        CreateFolder();
        File file = new File(Environment.getDataDirectory(), "data/" + context.getPackageName() + "/shared_prefs/" + "B58.xml");
        File file2 = new File(Environment.getExternalStorageDirectory(), String.valueOf(str2) + str);
        try {
            /*Object channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0, channel.size());
            channel.close();
            channel2.close();*/
            FileUtils.copyFile(file,file2);
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e2) {
            String message = e2.getMessage();
            e2.printStackTrace();
            Toast.makeText(context, "Failed to Back up user prefs to " + file2.getAbsolutePath() + " - " + message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void CreateFolder() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        for (int i = 0; i <= 2; i++) {
            if (i == 0) {
                new File(externalStorageDirectory + "/" + "WhatsApp").mkdir();
            } else if (i == 1) {
                new File(externalStorageDirectory + "/" + "WhatsApp" + "/B58").mkdir();
            } else if (i == 2) {
                new File(externalStorageDirectory + "/" + "WhatsApp" + "/B58/" + "Themes").mkdir();
            }
        }

    }

    public static void getWallpaper(Context context, String str, String str2) {
        File file = new File(context.getFilesDir().getAbsolutePath(), "wallpaper.jpg");
        File file2 = new File(Environment.getExternalStorageDirectory(), "WhatsApp" + "/B58/" + str2 + "/" + str + "_wallpaper" + ".jpg");
        try {
            /*Object channel = new FileInputStream(file).getChannel();
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            channel2.transferFrom(channel, 0, channel.size());
            channel.close();
            channel2.close();*/
            FileUtils.copyFile(file, file2);
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e2) {
            String message = e2.getMessage();
            e2.printStackTrace();
            Toast.makeText(context, "Failed to Backup wallpaper.jpg to " + file2.getAbsolutePath() + " - " + message, Toast.LENGTH_SHORT).show();
        }
    }

}
