package com.getbase.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

public class AddFloatingActionButton extends FloatingActionButton
{
    int mPlusColor;

    public AddFloatingActionButton(final Context context) {
        this(context, null);
    }

    public AddFloatingActionButton(final Context context, final AttributeSet set) {
        super(context, set);
    }

    public AddFloatingActionButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }

    @Override
    Drawable getIconDrawable() {
        final float dimension = this.getDimension(R.dimen.fab_icon_size);
        final ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() {
            final float val$iconHalfSize = dimension / 2.0f;
            final float val$plusHalfStroke = getDimension(R.dimen.fab_plus_icon_stroke) / 2.0f;
            final float val$plusOffset = (dimension - getDimension(R.dimen.fab_plus_icon_size)) / 2.0f;

            public void draw(final Canvas canvas, final Paint paint) {
                canvas.drawRect(this.val$plusOffset, this.val$iconHalfSize - this.val$plusHalfStroke, dimension - this.val$plusOffset, this.val$plusHalfStroke + this.val$iconHalfSize, paint);
                canvas.drawRect(this.val$iconHalfSize - this.val$plusHalfStroke, this.val$plusOffset, this.val$plusHalfStroke + this.val$iconHalfSize, dimension - this.val$plusOffset, paint);
            }
        });
        final Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.mPlusColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }

    public int getPlusColor() {
        return this.mPlusColor;
    }

    @Override
    void init(final Context context, final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.AddFloatingActionButton, 0, 0);
        this.mPlusColor = obtainStyledAttributes.getColor(0, this.getColor(17170443));
        obtainStyledAttributes.recycle();
        super.init(context, set);
    }

    @Override
    public void setIcon(final int n) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(final int mPlusColor) {
        if (this.mPlusColor != mPlusColor) {
            this.mPlusColor = mPlusColor;
            this.updateBackground();
        }
    }

    public void setPlusColorResId(final int n) {
        this.setPlusColor(this.getColor(n));
    }
}
