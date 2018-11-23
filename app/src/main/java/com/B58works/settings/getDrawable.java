package com.B58works.settings;


import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

import static com.B58works.B58.ctx;
import static com.B58works.B58.isOnline;

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
                    .setAllowedOverRoaming(false).setTitle("WhatsApp")
                    .setDescription("New version is downloading...")
                    .setDestinationInExternalPublicDir("/B58wishes", "update.apk");

            mgr.enqueue(request);
        }
        else
            Toast.makeText(ctx,"No internet connection to check for new wallpaper",Toast.LENGTH_SHORT).show();

    }

    public static Drawable getbg()
    {
        Bitmap myBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        return new BitmapDrawable(ctx.getResources(), myBitmap);
    }
}