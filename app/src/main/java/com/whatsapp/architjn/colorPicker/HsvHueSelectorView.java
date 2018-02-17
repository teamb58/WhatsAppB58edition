package com.whatsapp.architjn.colorPicker;

import android.graphics.drawable.*;
import android.content.*;
import android.util.*;
import android.widget.*;
import android.view.*;

public class HsvHueSelectorView extends LinearLayout
{
    private boolean down;
    private float hue;
    private ImageView imgHue;
    private ImageView imgSeekSelector;
    private OnHueChangedListener listener;
    private int minOffset;
    private Drawable seekSelector;
    
    public HsvHueSelectorView(final Context context) {
        super(context);
        this.minOffset = 0;
        this.hue = 0.0f;
        this.down = false;
        this.init();
    }
    
    public HsvHueSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.minOffset = 0;
        this.hue = 0.0f;
        this.down = false;
        this.init();
    }
    
    private void buildUI() {
        this.setOrientation(0);
        this.setGravity(1);
        (this.imgSeekSelector = new ImageView(this.getContext())).setImageDrawable(this.seekSelector);
        this.addView((View)this.imgSeekSelector, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(this.seekSelector.getIntrinsicWidth(), this.seekSelector.getIntrinsicHeight()));
        (this.imgHue = new ImageView(this.getContext())).setImageDrawable(this.getContext().getResources().getDrawable(2130840670));
        this.imgHue.setScaleType(ImageView$ScaleType.FIT_XY);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -1);
        linearLayout$LayoutParams.setMargins(0, this.getOffset(), 0, this.getSelectorOffset());
        this.addView((View)this.imgHue, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
    }
    
    private int getOffset() {
        return Math.max(this.minOffset, this.getSelectorOffset());
    }
    
    private int getSelectorOffset() {
        return (int)Math.ceil(this.seekSelector.getIntrinsicHeight() / 2.0f);
    }
    
    private void init() {
        this.seekSelector = this.getContext().getResources().getDrawable(2130840671);
        this.buildUI();
    }
    
    private void onHueChanged() {
        if (this.listener != null) {
            this.listener.hueChanged(this, this.hue);
        }
    }
    
    private void placeSelector() {
        final int n = (int)((360.0f - this.hue) / 360.0f * this.imgHue.getHeight());
        this.imgSeekSelector.layout(0, n + this.getOffset() - this.getSelectorOffset(), this.imgSeekSelector.getWidth(), n + this.getOffset() - this.getSelectorOffset() + this.imgSeekSelector.getHeight());
    }
    
    private void setPosition(final int n) {
        this.hue = Math.max(Math.min(360.0f - 360.0f * ((n - this.getOffset()) / this.imgHue.getHeight()), 360.0f), 0.0f);
        this.placeSelector();
        this.onHueChanged();
    }
    
    public float getHue() {
        return this.hue;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.placeSelector();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean onTouchEvent = true;
        if (motionEvent.getAction() == 0) {
            this.down = onTouchEvent;
            this.setPosition((int)motionEvent.getY());
        }
        else if (motionEvent.getAction() == (onTouchEvent ? 1 : 0)) {
            this.down = false;
        }
        else if (this.down && motionEvent.getAction() == 2) {
            this.setPosition((int)motionEvent.getY());
        }
        else {
            onTouchEvent = super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }
    
    public void setHue(final float hue) {
        if (this.hue != hue) {
            this.hue = hue;
            this.placeSelector();
        }
    }
    
    public void setMinContentOffset(final int minOffset) {
        this.minOffset = minOffset;
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(this.imgHue.getLayoutParams());
        layoutParams.setMargins(0, this.getOffset(), 0, this.getSelectorOffset());
        this.imgHue.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public void setOnHueChangedListener(final OnHueChangedListener listener) {
        this.listener = listener;
    }
    
    public interface OnHueChangedListener
    {
        void hueChanged(final HsvHueSelectorView p0, final float p1);
    }
}
