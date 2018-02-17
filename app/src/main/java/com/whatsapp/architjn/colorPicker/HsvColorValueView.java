package com.whatsapp.architjn.colorPicker;

import android.graphics.drawable.*;
import android.content.*;
import android.util.*;
import android.graphics.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;

public class HsvColorValueView extends FrameLayout
{
    private Drawable colorSelector;
    private boolean down;
    private Bitmap drawCache;
    private float hue;
    private Shader innerShader;
    private int lastMeasuredSize;
    private OnSaturationOrValueChanged listener;
    private Shader outerShader;
    private Paint paint;
    private float saturation;
    private ImageView selectorView;
    private float value;
    
    public HsvColorValueView(final Context context) {
        super(context);
        this.hue = 0.0f;
        this.drawCache = null;
        this.lastMeasuredSize = -1;
        this.saturation = 0.0f;
        this.value = 1.0f;
        this.down = false;
        this.init();
    }
    
    public HsvColorValueView(final Context context, final AttributeSet set) {
        super(context, set);
        this.hue = 0.0f;
        this.drawCache = null;
        this.lastMeasuredSize = -1;
        this.saturation = 0.0f;
        this.value = 1.0f;
        this.down = false;
        this.init();
    }
    
    public HsvColorValueView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.hue = 0.0f;
        this.drawCache = null;
        this.lastMeasuredSize = -1;
        this.saturation = 0.0f;
        this.value = 1.0f;
        this.down = false;
        this.init();
    }
    
    private void ensureCache() {
        if (this.paint == null) {
            this.paint = new Paint();
        }
        int n = this.getHeight();
        if (n <= 0) {
            n = this.getMeasuredHeight();
        }
        if (n <= 0) {
            n = this.lastMeasuredSize;
        }
        final int backgroundSize = this.getBackgroundSize(n);
        if (this.drawCache == null && backgroundSize > 0) {
            this.outerShader = (Shader)new LinearGradient(0.0f, 0.0f, 0.0f, (float)backgroundSize, -1, -16777216, Shader$TileMode.CLAMP);
            this.innerShader = (Shader)new LinearGradient(0.0f, 0.0f, (float)backgroundSize, 0.0f, -1, Color.HSVToColor(new float[] { this.hue, 1.0f, 1.0f }), Shader$TileMode.CLAMP);
            this.paint.setShader((Shader)new ComposeShader(this.outerShader, this.innerShader, PorterDuff$Mode.MULTIPLY));
            this.drawCache = Bitmap.createBitmap(backgroundSize, backgroundSize, Bitmap$Config.ARGB_8888);
            new Canvas(this.drawCache).drawRect(0.0f, 0.0f, (float)backgroundSize, (float)backgroundSize, this.paint);
        }
    }
    
    private int getBackgroundSize(final int n) {
        return n - 2 * this.getBackgroundOffset();
    }
    
    private void init() {
        this.colorSelector = this.getContext().getResources().getDrawable(others.getResId(this.getContext(), "color_selector", "drawable"));
        (this.selectorView = new ImageView(this.getContext())).setImageDrawable(this.colorSelector);
        this.addView((View)this.selectorView, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(this.colorSelector.getIntrinsicWidth(), this.colorSelector.getIntrinsicHeight()));
        this.setWillNotDraw(false);
    }
    
    private void onSaturationOrValueChanged(final boolean b) {
        if (this.listener != null) {
            this.listener.saturationOrValueChanged(this, this.saturation, this.value, b);
        }
    }
    
    private void placeSelector() {
        final int backgroundOffset = this.getBackgroundOffset();
        final int n = (int)Math.ceil(this.selectorView.getHeight() / 2.0f);
        final int n2 = (int)(this.getBackgroundSize() * this.saturation);
        final int n3 = (int)(this.getBackgroundSize() * (1.0f - this.value));
        final int n4 = backgroundOffset + Math.max(0, Math.min(this.getBackgroundSize(), n2)) - n;
        final int n5 = backgroundOffset + Math.max(0, Math.min(this.getBackgroundSize(), n3)) - n;
        this.selectorView.layout(n4, n5, n4 + this.selectorView.getWidth(), n5 + this.selectorView.getHeight());
    }
    
    private void setPosFromSatAndValue() {
        if (this.drawCache != null) {
            this.placeSelector();
        }
    }
    
    private void setSatAndValueFromPos(final int n, final int n2, final boolean b) {
        final int backgroundOffset = this.getBackgroundOffset();
        this.saturation = (n - backgroundOffset) / this.getBackgroundSize();
        this.value = 1.0f - (n2 - backgroundOffset) / this.getBackgroundSize();
        this.onSaturationOrValueChanged(b);
    }
    
    private void setSelectorPosition(final int n, final int n2, final boolean b) {
        this.setSatAndValueFromPos(n, n2, b);
        this.placeSelector();
    }
    
    public int getBackgroundOffset() {
        return (int)Math.ceil(this.colorSelector.getIntrinsicHeight() / 2.0f);
    }
    
    public int getBackgroundSize() {
        this.ensureCache();
        return this.drawCache.getHeight();
    }
    
    public float getSaturation() {
        return this.saturation;
    }
    
    public float getValue() {
        return this.value;
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.ensureCache();
        canvas.drawBitmap(this.drawCache, (float)this.getBackgroundOffset(), (float)this.getBackgroundOffset(), this.paint);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.placeSelector();
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        this.setMeasuredDimension(this.lastMeasuredSize = Math.min(this.getMeasuredHeight(), this.getMeasuredWidth()), this.lastMeasuredSize);
        if (this.drawCache != null && this.drawCache.getHeight() != this.getBackgroundSize(this.lastMeasuredSize)) {
            this.drawCache.recycle();
            this.drawCache = null;
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean onTouchEvent = true;
        if (motionEvent.getAction() == 0) {
            this.down = onTouchEvent;
        }
        else if (motionEvent.getAction() == (onTouchEvent ? 1 : 0)) {
            this.down = false;
            this.setSelectorPosition((int)motionEvent.getX() - this.getBackgroundOffset(), (int)motionEvent.getY() - this.getBackgroundOffset(), onTouchEvent);
        }
        else if (motionEvent.getAction() == 2 && this.down) {
            this.setSelectorPosition((int)motionEvent.getX() - this.getBackgroundOffset(), (int)motionEvent.getY() - this.getBackgroundOffset(), false);
        }
        else {
            onTouchEvent = super.onTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }
    
    public void setHue(final float hue) {
        this.hue = hue;
        this.drawCache = null;
        this.invalidate();
    }
    
    public void setOnSaturationOrValueChanged(final OnSaturationOrValueChanged listener) {
        this.listener = listener;
    }
    
    public void setSaturation(final float saturation) {
        this.saturation = saturation;
        this.setPosFromSatAndValue();
    }
    
    public void setValue(final float value) {
        this.value = value;
        this.setPosFromSatAndValue();
    }
    
    public interface OnSaturationOrValueChanged
    {
        void saturationOrValueChanged(final HsvColorValueView p0, final float p1, final float p2, final boolean p3);
    }
}
