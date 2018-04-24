package com.B58works.extra;

import android.app.Activity;
import android.content.DialogInterface;

import com.B58works.B58;
import com.whatsapp.data.fo;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class an implements DialogInterface.OnClickListener
{
    public final fo a;
    public final Activity b;
    public final boolean c;

    public an(final fo a, final Activity b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void onClick(final DialogInterface dialogInterface, final int n) {
        B58.b583(this.a, this.b, this.c, dialogInterface, n);
    }
}
