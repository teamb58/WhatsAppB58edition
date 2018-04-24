package com.B58works;

import android.content.Context;
import android.os.Environment;
import android.preference.Preference;
import android.util.AttributeSet;

import java.io.File;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class BackupPref extends Preference implements Preference.OnPreferenceClickListener
{
    public BackupPref(final Context context) {
        super(context);
        this.init();
    }

    public BackupPref(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }

    public BackupPref(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init();
    }

    public void init() {
        this.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)this);
    }

    public boolean onPreferenceClick(final Preference preference) {
        final Context context = this.getContext();
        final File dataDirectory = Environment.getDataDirectory();
        String s="data/com.whatsapp";
        final File file = new File(dataDirectory, s);
        final File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String s2="data/com.whatsapp";
        new CopyingTask(context, true, file, new File(externalStorageDirectory, s2)).execute(new File[0]);
        return false;
    }
}
