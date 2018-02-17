package com.B58works;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class RestoreBtn extends Button implements View.OnClickListener
{
    public RestoreBtn(final Context context) {
        super(context);
        this.init();
    }

    public RestoreBtn(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }

    public RestoreBtn(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init();
    }

    public String getString(final String s) {
        return this.getContext().getString(this.getContext().getResources().getIdentifier(s, "string", this.getContext().getPackageName()));
    }

    public void init() {
        this.setOnClickListener((View.OnClickListener)this);
    }

    public void onClick(final View view) {
        final File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String s;
        if (B58.IsB58) {
            s = "WhatsApp/B58Backup";
        }
        else {
            s = "WhatsApp/B58Backup";
        }
        if (new File(externalStorageDirectory, s).exists()) {
            final Context context = this.getContext();
            final File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
            String s2;
            if (B58.IsB58) {
                s2 = "WhatsApp/B58Backup";
            }
            else {
                s2 = "WhatsApp/B58Backup";
            }
            final File file = new File(externalStorageDirectory2, s2);
            final File dataDirectory = Environment.getDataDirectory();
            String s3;
            if (B58.IsB58) {
                s3 = "data/com.whatsapp";
            }
            else {
                s3 = "data/com.whatsapp";
            }
            new CopyingTask(context, false, file, new File(dataDirectory, s3)).execute(new File[0]);
        }
        else {
            Toast.makeText(this.getContext(), (CharSequence)this.getString("B58NoBackup"), Toast.LENGTH_SHORT).show();
        }
    }
}