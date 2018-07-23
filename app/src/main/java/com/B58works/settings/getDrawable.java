package com.B58works.settings;


import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.B58works.B58.ctx;
import static com.B58works.B58.getResID;
import static com.B58works.B58.isOnline;
import static com.B58works.B58.sleep;

public class getDrawable {

    public static void downloadFile1() {
        String uRl="https://androtechupdates.com/wp-content/uploads/special.jpg";
        File direct = new File(Environment.getExternalStorageDirectory() + "B58wishes");

        if (!direct.exists()) {
            direct.mkdirs();
        }
        if(isOnline(ctx))
        {
            DownloadManager mgr = (DownloadManager) ctx.getSystemService(Context.DOWNLOAD_SERVICE);

            Uri downloadUri = Uri.parse(uRl);
            DownloadManager.Request request = new DownloadManager.Request(
                    downloadUri);

            request.setAllowedNetworkTypes(
                    DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false).setTitle("B58")
                    .setDescription("Wallpaper is downloading...")
                    .setDestinationInExternalPublicDir("/B58wishes", "special.jpg");

            mgr.enqueue(request);
        }

    }

    public static Drawable getbg()
    {
        Bitmap myBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        return new BitmapDrawable(ctx.getResources(), myBitmap);
    }

    public static void downloadFile()
    {
        final File file = new File(Environment.getExternalStorageDirectory()+"/B58wishes"+"/special.jpg");
        if(!file.exists())
        {
            downloadFile1();
            sleep();
        }
    }
}