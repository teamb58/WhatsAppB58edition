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

import static com.B58works.B58.getResID;
import static com.whatsapp.sn1.zseekBarPrefBarContainer;
import static com.whatsapp.sn1.zseekBarPrefUnitsLeft;
import static com.whatsapp.sn1.zseekBarPrefUnitsRight;
import static com.whatsapp.sn1.zseekBarPrefValue;
import static com.whatsapp.sn1.zseek_bar_preference;

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
    private String f;
    private String g;
    private SeekBar h;
    private TextView i;
    private RelativeLayout j;

    public SeekBarPreference(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = this.getClass().getName();
        this.b = 100;
        this.c = 0;
        this.d = 1;
        this.f = "";
        this.g = "";
        this.j = null;
        this.a(context, set);
    }

    public SeekBarPreference(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = this.getClass().getName();
        this.b = 100;
        this.c = 0;
        this.d = 1;
        this.f = "";
        this.g = "";
        this.j = null;
        this.a(context, set);
    }

    private static String a(final AttributeSet set, final String s, final String s2, String s3) {
        final String attributeValue = set.getAttributeValue(s, s2);
        if (attributeValue != null) {
            s3 = attributeValue;
        }
        return s3;
    }

    private void a(final Context context, final AttributeSet set) {
        this.b = set.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
        this.c = set.getAttributeIntValue("http://robobunny.com", "min", 0);
        this.f = a(set, "http://robobunny.com", "unitsLeft", "");
        this.g = a(set, "http://robobunny.com", "unitsRight", a(set, "http://robobunny.com", "units", ""));
        while (true) {
            try {
                final String attributeValue = set.getAttributeValue("http://robobunny.com", "interval");
                if (attributeValue != null) {
                    this.d = Integer.parseInt(attributeValue);
                }
                (this.h = new SeekBar(context, set)).setMax(this.b - this.c);
                this.h.setOnSeekBarChangeListener(this);
            }
            catch (Exception ex) {
                Log.e(this.a, "Invalid interval value", (Throwable)ex);
                continue;
            }
            break;
        }
    }

    public void onBindView(View paramView)
    {
        try
        {
            super.onBindView(paramView);
            try
            {
                ViewParent localViewParent = this.h.getParent();
                ViewGroup localViewGroup = paramView.findViewById(zseekBarPrefBarContainer());
                if (localViewParent != localViewGroup)
                {
                    if (localViewParent != null)
                        ((ViewGroup)localViewParent).removeView(this.h);
                    localViewGroup.removeAllViews();
                    localViewGroup.addView(this.h, -1, -2);
                }
                if ((!this.j.isEnabled()) && (this.j != null))
                    this.h.setEnabled(false);
            }
            catch (Exception localException1)
            {
                try
                {
                    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
                    this.i = ((TextView)localRelativeLayout.findViewById(zseekBarPrefValue()));
                    this.i.setText(String.valueOf(this.e));
                    this.i.setMinimumWidth(30);
                    this.h.setProgress(this.e - this.c);
                    ((TextView)localRelativeLayout.findViewById(zseekBarPrefUnitsRight())).setText(this.g);
                    ((TextView)localRelativeLayout.findViewById(zseekBarPrefUnitsLeft())).setText(this.f);
                    localException1 = localException1;
                    Log.e(this.a, "Error binding view: " + localException1.toString());
                    label184: return;
                }
                catch (Exception localException2)
                {
                    while (true)
                        Log.e(this.a, "Error updating seek bar preference", localException2);
                }
            }
        }
        catch (NullPointerException localNullPointerException)
        {

        }
    }

    protected View onCreateView(final ViewGroup viewGroup) {
        super.onCreateView(viewGroup);
        try {
            this.j = (RelativeLayout) ((LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(zseek_bar_preference(), viewGroup, false);
            return (View) this.j;
        } catch (Exception ex) {
            Log.e(this.a, "Error creating seek bar preference", ex);
            return (View) this.j;
        }
    }

    public void onDependencyChanged(final Preference preference, final boolean b) {
        super.onDependencyChanged(preference, b);
        if (this.j != null) {
            this.h.setEnabled(!b);
            final TextView i = this.i;
            boolean enabled = false;
            if (!b) {
                enabled = true;
            }
            i.setEnabled(enabled);
        }
    }

    protected Object onGetDefaultValue(final TypedArray typedArray, final int n) {
        return typedArray.getInt(n, 50);
    }

    public void onProgressChanged(final SeekBar seekBar, final int n, final boolean b) {
        try {
            int e = n + this.c;
            if (e > this.b) {
                e = this.b;
            }
            else if (e < this.c) {
                e = this.c;
            }
            else if (this.d != 1 && e % this.d != 0) {
                e = Math.round(e / this.d) * this.d;
            }
            if (!this.callChangeListener((Object)e)) {
                seekBar.setProgress(this.e - this.c);
            }
            else {
                this.e = e;
                this.i.setText((CharSequence)String.valueOf(e));
                this.persistInt(e);
            }
        }
        catch (NullPointerException ex) {}
    }

    protected void onSetInitialValue(final boolean b, final Object o) {
        if (b) {
            this.e = this.getPersistedInt(this.e);
        }
        else {
            while (true) {
                try {
                    final int intValue = (int)o;
                    this.persistInt(intValue);
                    this.e = intValue;
                }
                catch (Exception ex) {
                    Log.e(this.a, "Invalid default value: " + o.toString());
                    final int intValue = 0;
                    continue;
                }
                break;
            }
        }
    }

    public void onStartTrackingTouch(final SeekBar seekBar) {
    }

    public void onStopTrackingTouch(final SeekBar seekBar) {
        this.notifyChanged();
        if (this.g.contains("r") || this.g.contains("Mb")) {
            //com.whatsapp.plus.fv.d(this.getContext());
        }
    }

    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        this.h.setEnabled(b);
    }
}

