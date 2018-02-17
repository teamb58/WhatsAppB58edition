package com.B58works.extra;

import android.view.View;

import com.B58works.B58;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class ak implements View.OnClickListener
{
    private final String a;

    public ak(final String a) {
        this.a = a;
    }

    public void onClick(final View view) {
        B58.a(this.a, view);
    }
}
