package com.B58works.extra;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;

import com.B58works.pass;
import com.B58works.patternC;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class bt implements Preference.OnPreferenceClickListener
{
    private final pass a;

    public bt(final pass a) {
        this.a = a;
    }

    public boolean onPreferenceClick(final Preference preference) {
        this.a.startActivity(new Intent((Context)this.a, (Class)patternC.class));
        return false;
    }
}

