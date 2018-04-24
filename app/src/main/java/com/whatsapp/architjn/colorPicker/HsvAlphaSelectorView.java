package com.whatsapp.architjn.colorPicker;

import android.graphics.drawable.*;
import android.content.*;
import android.util.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.graphics.*;
import android.view.*;

public class HsvAlphaSelectorView extends LinearLayout
{
    private int alpha;
    private int color;
    private boolean dirty;
    private boolean down;
    private ImageView imgAlpha;
    private ImageView imgSeekSelector;
    private OnAlphaChangedListener listener;
    private int minOffset;
    private Drawable seekSelector;
    
    public HsvAlphaSelectorView(final Context context) {
        super(context);
        this.minOffset = 0;
        this.alpha = 0;
        this.color = -1;
        this.dirty = true;
        this.down = false;
        this.init();
    }
    
    public HsvAlphaSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.minOffset = 0;
        this.alpha = 0;
        this.color = -1;
        this.dirty = true;
        this.down = false;
        this.init();
    }
    
    private void buildUI() {
        this.setOrientation(HORIZONTAL);
        this.setGravity(1);
        this.setWillNotDraw(false);
        (this.imgSeekSelector = new ImageView(this.getContext())).setImageDrawable(this.seekSelector);
        this.addView((View)this.imgSeekSelector, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(this.seekSelector.getIntrinsicWidth(), this.seekSelector.getIntrinsicHeight()));
        (this.imgAlpha = new ImageView(this.getContext())).setBackgroundDrawable(this.getContext().getResources().getDrawable(others.getResId(this.getContext(), "transparentbackrepeat", "drawable")));
        this.imgAlpha.setScaleType(ImageView.ScaleType.FIT_XY);
        final LinearLayout.LayoutParams LayoutParams = new LinearLayout.LayoutParams(-1, -1);
        LayoutParams.setMargins(0, this.getOffset(), 0, this.getSelectorOffset());
        this.addView((View)this.imgAlpha, LayoutParams);
    }
    
    private int getOffset() {
        return Math.max(this.minOffset, (int)Math.ceil(this.seekSelector.getIntrinsicHeight() / 2.0));
    }
    
    private int getSelectorOffset() {
        return (int)Math.ceil(this.imgSeekSelector.getHeight() / 2.0f);
    }
    
    private void init() {
        this.seekSelector = this.getContext().getResources().getDrawable(others.getResId(this.getContext(), "color_seekselector", "drawable"));
        this.buildUI();
    }
    
    private void onAlphaChanged() {
        if (this.listener != null) {
            this.listener.alphaChanged(this, this.alpha);
        }
    }
    
    private void placeSelector() {
        final int n = (int)((255 - this.alpha) / 255.0f * this.imgAlpha.getHeight());
        final int selectorOffset = this.getSelectorOffset();
        final int top = this.imgAlpha.getTop();
        this.imgSeekSelector.layout(0, n + top - selectorOffset, this.imgSeekSelector.getWidth(), n + top - selectorOffset + this.imgSeekSelector.getHeight());
    }
    
    private void setAlphaImage() {
        if (this.imgAlpha.getHeight() <= 0) {
            this.dirty = true;
            this.invalidate();
        }
        else {
            final Paint paint = new Paint();
            if (!false) {
                paint.setShader((Shader)new LinearGradient(0.0f, (float)this.imgAlpha.getHeight(), 0.0f, 0.0f, 0xFFFFFF & this.color, 0xFF000000 | this.color, Shader.TileMode.CLAMP));
                final Bitmap bitmap = Bitmap.createBitmap(this.imgAlpha.getWidth(), this.imgAlpha.getHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(bitmap).drawRect(0.0f, 0.0f, (float)this.imgAlpha.getWidth(), (float)this.imgAlpha.getHeight(), paint);
                this.imgAlpha.setImageBitmap(bitmap);
            }
        }
    }
    
    private void setPosition(final int n) {
        this.alpha = 255 - Math.min(255, Math.max(0, (int)(255.0f * ((n - this.imgAlpha.getTop()) / this.imgAlpha.getHeight()))));
        this.placeSelector();
        this.onAlphaChanged();
    }
    
    public float getAlpha() {
        return this.alpha;
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.dirty) {
            this.dirty = false;
            this.setAlphaImage();
        }
        super.onDraw(canvas);
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
    
    public void setAlpha(final int alpha) {
        if (this.alpha != alpha) {
            this.alpha = alpha;
            this.placeSelector();
        }
    }
    
    public void setColor(final int color) {
        if (this.color != color) {
            this.color = color;
            this.setAlphaImage();
        }
    }
    
    public void setMinContentOffset(final int minOffset) {
        this.minOffset = minOffset;
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.imgAlpha.getLayoutParams());
        layoutParams.setMargins(0, this.getOffset(), 0, this.getSelectorOffset());
        this.imgAlpha.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }
    
    public void setOnAlphaChangedListener(final OnAlphaChangedListener listener) {
        this.listener = listener;
    }
    
    public interface OnAlphaChangedListener
    {
        void alphaChanged(final HsvAlphaSelectorView p0, final int p1);
    }
}
