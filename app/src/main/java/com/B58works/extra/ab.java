package com.B58works.extra;

import android.content.DialogInterface;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class ab implements DialogInterface.OnClickListener
{
    public void onClick(final DialogInterface dialogInterface, final int n) {
        dialogInterface.cancel();
    }
}
