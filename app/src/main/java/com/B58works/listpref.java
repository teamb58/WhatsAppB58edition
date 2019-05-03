package com.B58works;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.util.Log;

public class Listpref extends ListPreference {

    private int[] resourceIds;

    public Listpref(final Context context, final AttributeSet set) {
        super(context, set);
        this.resourceIds = null;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, new int[] { R.attr.entryImages });
        final String[] stringArray = context.getResources().getStringArray(obtainStyledAttributes.getResourceId(-1 + obtainStyledAttributes.getIndexCount(), -1));
        this.resourceIds = new int[stringArray.length];
        Log.d("B58", new StringBuilder().append(this.resourceIds.length).toString());
        for (int i = 0; i < stringArray.length; ++i) {
            this.resourceIds[i] = this.getResID(stringArray[i].substring(1 + stringArray[i].lastIndexOf(47), stringArray[i].lastIndexOf(46)), "drawable");
        }
        obtainStyledAttributes.recycle();
    }

    private int getResID(final String s, final String s2) {
        return this.getContext().getResources().getIdentifier(s, s2, this.getContext().getPackageName());
    }

    protected void onPrepareDialogBuilder(final AlertDialog.Builder alertDialog$Builder) {
        alertDialog$Builder.setAdapter(new ImageArrayAdapter(this.getContext(), this.getResID("listitem", "layout"), this.getEntries(), this.resourceIds, this.findIndexOfValue(this.getSharedPreferences().getString(this.getKey(), "1"))), this);
        super.onPrepareDialogBuilder(alertDialog$Builder);
    }
}
