package com.B58works;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class ImageArrayAdapter extends ArrayAdapter<CharSequence>
{
    private int index;
    private int[] resourceIds;

    public ImageArrayAdapter(final Context context, final int n, final CharSequence[] array, final int[] resourceIds, final int index) {
        super(context, n, array);
        this.index = 0;
        this.resourceIds = null;
        this.index = index;
        this.resourceIds = resourceIds;
    }

    public int getResID(final String s, final String s2) {
        return this.getContext().getResources().getIdentifier(s, s2, this.getContext().getPackageName());
    }

    public String getString(final String s) {
        return this.getContext().getString(this.getContext().getResources().getIdentifier(s, "string", this.getContext().getPackageName()));
    }

    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final View inflate = ((Activity)this.getContext()).getLayoutInflater().inflate(this.getResID("listitem", "layout"), viewGroup, false);
        ((ImageView)inflate.findViewById(this.getResID("image", "id"))).setImageResource(this.resourceIds[n]);
        final CheckedTextView checkedTextView = inflate.findViewById(this.getResID("check", "id"));
        checkedTextView.setText(this.getItem(n));
        if (n == this.index) {
            checkedTextView.setChecked(true);
        }
        return inflate;
    }
}
