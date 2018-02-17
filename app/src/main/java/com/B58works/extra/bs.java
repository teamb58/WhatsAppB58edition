package com.B58works.extra;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;

import com.B58works.LocksC;
import com.B58works.pass;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class bs implements Preference.OnPreferenceClickListener
{
    private final pass a;

    public bs(final pass a) {
        this.a = a;
    }

    public boolean onPreferenceClick(final Preference preference) {
        this.a.startActivity(new Intent((Context)this.a, (Class)LocksC.class));
        return false;
    }
}