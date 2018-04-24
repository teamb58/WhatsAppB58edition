package com.B58works.extra;

import android.content.DialogInterface;

import com.B58works.B58;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class al implements DialogInterface.OnClickListener
{
    public static DialogInterface.OnClickListener a;

    static {
        al.a = new al();
    }

    public void onClick(final DialogInterface dialogInterface, final int n) {
        B58.b581(dialogInterface, n);
    }
}
