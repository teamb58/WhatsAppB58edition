package com.whatsapp.architjn;

import android.content.Context;

/**
 * Created by Bharath.R(58) on 01-04-2018.
 */

public class others {
    public static int getResId(final Context context, final String s, final String s2) {
        return context.getResources().getIdentifier(s, s2, context.getPackageName());
    }
}
