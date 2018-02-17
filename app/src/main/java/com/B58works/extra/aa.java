package com.B58works.extra;

import android.view.View;
import android.widget.TextView;

import com.B58works.B58;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class aa implements View.OnClickListener
{
    private final TextView a;

    public aa(final TextView a) {
        this.a = a;
    }

    public void onClick(final View view) {
        B58.status(this.a, view);
    }
}

