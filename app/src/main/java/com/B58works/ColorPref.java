package com.B58works;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.B58works.colorPicker.ColorSelectorDialog;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class ColorPref extends Preference {
    private ImageView a;
    private int b;

    public ColorPref(final Context context) {
        super(context);
        this.b = B58.getColor(this.getKey());
        this.setWidgetLayoutResource(R.layout.color_pref);
    }

    public ColorPref(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = B58.getColor(this.getKey());
        this.setWidgetLayoutResource(R.layout.color_pref);
    }

    public ColorPref(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = B58.getColor(this.getKey());
        this.setWidgetLayoutResource(R.layout.color_pref);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ColorPref(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.b = B58.getColor(this.getKey());
        this.setWidgetLayoutResource(R.layout.color_pref);
    }

    private void a() {
        ((GradientDrawable) this.a.getBackground()).setColor(this.b);
    }

    private void b() {
        final String key = this.getKey();
        new ColorSelectorDialog(this.getContext(), new ColorSelectorDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(int p0) {
                a(key,p0);
            }
        }, B58.ctx.getSharedPreferences("B58", 0).getInt(key, this.b)).show();
    }

    public void a(final View view) {
        this.onClick();
    }

    public void a(final String s, final int b) {
        B58.putInt(s, b);
        this.b = b;
        this.a();
    }

    public void onBindView(final View view) {
        super.onBindView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a(view);
            }
        });
        this.a = view.findViewById(R.id.imageViewIcon);
        if (this.a != null) {
            this.a();
            this.a.setClickable(true);
        }
    }

    public void onClick() {
        super.onClick();
        this.b();
    }
}

