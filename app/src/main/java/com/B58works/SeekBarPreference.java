package com.B58works;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class SeekBarPreference extends Preference implements SeekBar.OnSeekBarChangeListener
{
    private final String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private SeekBar f;
    private TextView g;
    private String h;
    private String i;
    private int j;

    public SeekBarPreference(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = this.getClass().getName();
        this.d = 100;
        this.e = 0;
        this.c = 1;
        this.h = "";
        this.i = "";
        this.a(context, set);
    }

    public SeekBarPreference(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = this.getClass().getName();
        this.d = 100;
        this.e = 0;
        this.c = 1;
        this.h = "";
        this.i = "";
        this.a(context, set);
    }

    private String a(final AttributeSet set, String s, final String s2, final String s3) {
        String attributeValue;
        s = (attributeValue = set.getAttributeValue(s, s2));
        if (s == null) {
            attributeValue = s3;
        }
        return attributeValue;
    }

    private void a(final Context context, final AttributeSet set) {
        this.a(set);
        (this.f = new SeekBar(context, set)).setMax(this.d - this.e);
        this.f.setOnSeekBarChangeListener(this);
    }

    private void a(final AttributeSet set) {
        this.d = set.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
        this.e = set.getAttributeIntValue("http://robobunny.com", "min", 0);
        this.j = set.getAttributeIntValue("http://schemas.android.com/apk/res/android", "defaultValue", 0);
        this.h = this.a(set, "http://robobunny.com", "unitsLeft", "");
        this.i = this.a(set, "http://robobunny.com", "unitsRight", this.a(set, "http://robobunny.com", "units", ""));
        try {
            final String attributeValue = set.getAttributeValue("http://robobunny.com", "interval");
            if (attributeValue != null) {
                this.c = Integer.parseInt(attributeValue);
            }
        }
        catch (Exception ex) {
            Log.e(this.a, "Invalid interval value", ex);
        }
    }

    public int getdef() {
        return this.j;
    }

    public int myVal() {
        return this.b;
    }

    public void onBindView(final View view) {
        super.onBindView(view);
        try {
            final ViewParent parent = this.f.getParent();
            final ViewGroup viewGroup = view.findViewById(IDGen.id.seekBarPrefBarContainer);
            if (parent != viewGroup) {
                if (parent != null) {
                    ((ViewGroup)parent).removeView(this.f);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.f, -1, -2);
            }
        }
        catch (Exception ex) {
            final String a = this.a;
            String sb = "Error binding view: " +
                    ex.toString();
            Log.e(a, sb);
        }
        this.updateView(view);
    }

    protected View onCreateView(final ViewGroup viewGroup) {
        super.onCreateView(viewGroup);
        try {
            return LayoutInflater.from(this.getContext()).inflate(IDGen.layout.seek_bar_preference, viewGroup, false);
        }
        catch (Exception ex) {
            Log.e(this.a, "Error creating seek bar preference", ex);
            return null;
        }
    }

    protected Object onGetDefaultValue(final TypedArray typedArray, final int n) {
        return typedArray.getInt(n, 50);
    }

    public void onProgressChanged(final SeekBar seekBar, int b, final boolean b2) {
        final int n = b + this.e;
        if (n > this.d) {
            b = this.d;
        }
        else if (n < this.e) {
            b = this.e;
        }
        else {
            b = n;
            if (this.c != 1) {
                b = n;
                if (n % this.c != 0) {
                    b = Math.round(n / this.c) * this.c;
                }
            }
        }
        if (this.callChangeListener(b)) {
            this.b = b;
            this.g.setText(String.valueOf(b));
            this.persistInt(b);
            return;
        }
        seekBar.setProgress(this.b - this.e);
    }

    protected void onSetInitialValue(final boolean b, final Object o) {
        int b2;
        if (b) {
            b2 = this.getPersistedInt(this.b);
        }
        else {
            b2 = 0;
            try {
                b2 = (int)o;
            }
            catch (Exception ex) {
                final String a = this.a;
                String sb = "Invalid default value: " +
                        o.toString();
                Log.e(a, sb);
            }
            this.persistInt(b2);
        }
        this.b = b2;
    }

    public void onStartTrackingTouch(final SeekBar seekBar) {
    }

    public void onStopTrackingTouch(final SeekBar seekBar) {
        this.notifyChanged();
    }

    public void setmyVal(final int b) {
        this.b = b;
    }

    private void updateView(final View view) {
        try {
            final RelativeLayout relativeLayout = (RelativeLayout)view;
            (this.g = relativeLayout.findViewById(IDGen.id.seekBarPrefValue)).setText(String.valueOf(this.b));
            this.g.setMinimumWidth(30);
            this.f.setProgress(this.b - this.e);
            ((TextView)relativeLayout.findViewById(IDGen.id.seekBarPrefUnitsRight)).setText(this.i);
            ((TextView)relativeLayout.findViewById(IDGen.id.seekBarPrefUnitsLeft)).setText(this.h);
        }
        catch (Exception ex) {
            Log.e(this.a, "Error updating seek bar preference", ex);
        }
    }
}

