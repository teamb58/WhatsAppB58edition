package com.B58works.extra;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import com.B58works.B58;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class ba implements DialogInterface.OnClickListener
{
    Activity a;
    EditText etname;

    public ba(final Activity a, final EditText etname) {
        this.a = a;
        this.etname = etname;
    }

    public void onClick(final DialogInterface dialogInterface, final int n) {
        final String string = this.etname.getText().toString();
        B58.BackupPreference2((Context)this.a, String.valueOf(string) + ".xml", String.valueOf("WhatsApp") + "/B58/Themes/");
        B58.getWallpaper((Context)this.a, string, "Themes");
    }
}
