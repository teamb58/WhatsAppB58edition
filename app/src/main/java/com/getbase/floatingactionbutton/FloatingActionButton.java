package com.getbase.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

public class FloatingActionButton extends ImageButton
{
    private static final int HALF_TRANSPARENT_BLACK;
    private static final int HALF_TRANSPARENT_WHITE;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private float mCircleSize;
    int mColorNormal;
    int mColorPressed;
    private int mDrawableSize;
    private int mIcon;
    private float mShadowOffset;
    private float mShadowRadius;
    private int mSize;
    String mTitle;

    static {
        HALF_TRANSPARENT_WHITE = Color.argb(128, 255, 255, 255);
        HALF_TRANSPARENT_BLACK = Color.argb(128, 0, 0, 0);
    }

    public FloatingActionButton(final Context context) {
        this(context, null);
    }

    public FloatingActionButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.init(context, set);
    }

    public FloatingActionButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init(context, set);
    }

    private Drawable createCircleDrawable(final int color) {
        final ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        return shapeDrawable;
    }

    private StateListDrawable createFillDrawable() {
        final StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[] { 16842919 }, this.createCircleDrawable(this.mColorPressed));
        stateListDrawable.addState(new int[0], this.createCircleDrawable(this.mColorNormal));
        return stateListDrawable;
    }

    private Drawable createInnerStrokesDrawable(final float n) {
        final ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(n);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAlpha(this.opacityToAlpha(0.04f));
        shapeDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            public Shader resize(int access$000, final int n) {
                final float n2 = access$000 / 2;
                final float n3 = access$000 / 2;
                final float n4 = n;
                access$000 = FloatingActionButton.HALF_TRANSPARENT_BLACK;
                return new LinearGradient(n2, 0.0f, n3, n4, new int[] { 0, access$000, -16777216 }, new float[] { 0.0f, 0.8f, 1.0f }, Shader.TileMode.CLAMP);
            }
        });
        final ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        final Paint paint2 = shapeDrawable2.getPaint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(n);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAlpha(this.opacityToAlpha(0.8f));
        shapeDrawable2.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            public Shader resize(int access$100, final int n) {
                final float n2 = access$100 / 2;
                final float n3 = access$100 / 2;
                final float n4 = n;
                access$100 = FloatingActionButton.HALF_TRANSPARENT_WHITE;
                return new LinearGradient(n2, 0.0f, n3, n4, new int[] { -1, access$100, 0 }, new float[] { 0.0f, 0.2f, 1.0f }, Shader.TileMode.CLAMP);
            }
        });
        return new LayerDrawable(new Drawable[] { shapeDrawable, shapeDrawable2 });
    }

    private Drawable createOuterStrokeDrawable(final float strokeWidth) {
        final ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16777216);
        paint.setAlpha(this.opacityToAlpha(0.02f));
        return shapeDrawable;
    }

    private int opacityToAlpha(final float n) {
        return (int)(255.0f * n);
    }

    @SuppressLint({ "NewApi" })
    private void setBackgroundCompat(final Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.setBackground(drawable);
        }
        else {
            this.setBackgroundDrawable(drawable);
        }
    }

    private void updateCircleSize() {
        int n;
        if (this.mSize == 0) {
            n = R.dimen.fab_size_normal;
        }
        else {
            n = R.dimen.fab_size_mini;
        }
        this.mCircleSize = this.getDimension(n);
    }

    private void updateDrawableSize() {
        this.mDrawableSize = (int)(this.mCircleSize + 2.0f * this.mShadowRadius);
    }

    int getColor(final int n) {
        return this.getResources().getColor(n);
    }

    public int getColorNormal() {
        return this.mColorNormal;
    }

    public int getColorPressed() {
        return this.mColorPressed;
    }

    public float getDimension(final int n) {
        return this.getResources().getDimension(n);
    }

    Drawable getIconDrawable() {
        Object drawable;
        if (this.mIcon != 0) {
            drawable = this.getResources().getDrawable(this.mIcon);
        }
        else {
            drawable = new ColorDrawable(0);
        }
        return (Drawable)drawable;
    }

    public int getSize() {
        return this.mSize;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @SuppressLint("ResourceType")
    void init(final Context context, final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.FloatingActionButton, 0, 0);
        this.mColorNormal = obtainStyledAttributes.getColor(1, this.getColor(17170451));
        this.mColorPressed = obtainStyledAttributes.getColor(0, this.getColor(17170450));
        this.mSize = obtainStyledAttributes.getInt(3, 0);
        this.mIcon = obtainStyledAttributes.getResourceId(2, 0);
        this.mTitle = obtainStyledAttributes.getString(4);
        obtainStyledAttributes.recycle();
        this.updateCircleSize();
        this.mShadowRadius = this.getDimension(R.dimen.fab_shadow_radius);
        this.mShadowOffset = this.getDimension(R.dimen.fab_shadow_offset);
        this.updateDrawableSize();
        this.updateBackground();
    }

    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        this.setMeasuredDimension(this.mDrawableSize, this.mDrawableSize);
    }

    public void setColorNormal(final int mColorNormal) {
        if (this.mColorNormal != mColorNormal) {
            this.mColorNormal = mColorNormal;
            this.updateBackground();
        }
    }

    public void setColorNormalResId(final int n) {
        this.setColorNormal(this.getColor(n));
    }

    public void setColorPressed(final int mColorPressed) {
        if (this.mColorPressed != mColorPressed) {
            this.mColorPressed = mColorPressed;
            this.updateBackground();
        }
    }

    public void setColorPressedResId(final int n) {
        this.setColorPressed(this.getColor(n));
    }

    public void setIcon(final int mIcon) {
        if (this.mIcon != mIcon) {
            this.mIcon = mIcon;
            this.updateBackground();
        }
    }

    public void setSize(final int mSize) {
        if (mSize != 1 && mSize != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        }
        if (this.mSize != mSize) {
            this.mSize = mSize;
            this.updateCircleSize();
            this.updateDrawableSize();
            this.updateBackground();
        }
    }

    public void setTitle(final String s) {
        this.mTitle = s;
        final TextView textView = (TextView)this.getTag(R.id.fab_label);
        if (textView != null) {
            textView.setText(s);
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    FloatingActionButton.this.callOnClick();
                }
            });
        }
    }

    void updateBackground() {
        final float dimension = this.getDimension(R.dimen.fab_stroke_width);
        final float n = dimension / 2.0f;
        final Resources resources = this.getResources();
        int n2;
        if (this.mSize == 0) {
            n2 = R.drawable.fab_bg_normal;
        }
        else {
            n2 = R.drawable.fab_bg_mini;
        }
        final LayerDrawable backgroundCompat = new LayerDrawable(new Drawable[] { resources.getDrawable(n2), this.createFillDrawable(), this.createOuterStrokeDrawable(dimension), this.createInnerStrokesDrawable(dimension), this.getIconDrawable() });
        final int n3 = (int)(this.mCircleSize - this.getDimension(R.dimen.fab_icon_size)) / 2;
        final int n4 = (int)this.mShadowRadius;
        final int n5 = (int)(this.mShadowRadius - this.mShadowOffset);
        final int n6 = (int)(this.mShadowRadius + this.mShadowOffset);
        backgroundCompat.setLayerInset(1, n4, n5, n4, n6);
        backgroundCompat.setLayerInset(2, (int)(n4 - n), (int)(n5 - n), (int)(n4 - n), (int)(n6 - n));
        backgroundCompat.setLayerInset(3, (int)(n4 + n), (int)(n5 + n), (int)(n4 + n), (int)(n6 + n));
        backgroundCompat.setLayerInset(4, n4 + n3, n5 + n3, n4 + n3, n6 + n3);
        this.setBackgroundCompat(backgroundCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FAB_SIZE {
    }
}

