package com.B58works;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListAdapter;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class listpref extends ListPreference
{
    private int[] resourceIds;

    public listpref(final Context context, final AttributeSet set) {
        super(context, set);
        this.resourceIds = null;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, new int[] { this.getResID("entryImages", "attr") });
        final String[] stringArray = context.getResources().getStringArray(obtainStyledAttributes.getResourceId(-1 + obtainStyledAttributes.getIndexCount(), -1));
        this.resourceIds = new int[stringArray.length];
        Log.d("B58", new StringBuilder().append(this.resourceIds.length).toString());
        for (int i = 0; i < stringArray.length; ++i) {
            this.resourceIds[i] = this.getResID(stringArray[i].substring(1 + stringArray[i].lastIndexOf(47), stringArray[i].lastIndexOf(46)), "drawable");
        }
        obtainStyledAttributes.recycle();
    }

    public int getResID(final String s, final String s2) {
        return this.getContext().getResources().getIdentifier(s, s2, this.getContext().getPackageName());
    }

    public String getString(final String s) {
        return this.getContext().getString(this.getContext().getResources().getIdentifier(s, "string", this.getContext().getPackageName()));
    }

    protected void onPrepareDialogBuilder(final AlertDialog.Builder alertDialog$Builder) {
        alertDialog$Builder.setAdapter((ListAdapter)new ImageArrayAdapter(this.getContext(), this.getResID("listitem", "layout"), this.getEntries(), this.resourceIds, this.findIndexOfValue(this.getSharedPreferences().getString(this.getKey(), "1"))), this);
        super.onPrepareDialogBuilder(alertDialog$Builder);
    }
}
