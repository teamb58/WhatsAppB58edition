package com.getbase.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

public class FloatingActionsMenu extends ViewGroup
{
    private static final int ANIMATION_DURATION = 300;
    private static final float COLLAPSED_PLUS_ROTATION = 0.0f;
    private static final float EXPANDED_PLUS_ROTATION = 135.0f;
    public static final int EXPAND_DOWN = 1;
    public static final int EXPAND_LEFT = 2;
    public static final int EXPAND_RIGHT = 3;
    public static final int EXPAND_UP = 0;
    private static Interpolator sAlphaExpandInterpolator;
    private static Interpolator sCollapseInterpolator;
    private static Interpolator sExpandInterpolator;
    private AddFloatingActionButton mAddButton;
    private int mAddButtonColorNormal;
    private int mAddButtonColorPressed;
    private int mAddButtonPlusColor;
    private int mButtonSpacing;
    private int mButtonsCount;
    private AnimatorSet mCollapseAnimation;
    private AnimatorSet mExpandAnimation;
    private int mExpandDirection;
    private boolean mExpanded;
    private int mLabelsMargin;
    private int mLabelsStyle;
    private int mLabelsVerticalOffset;
    private OnFloatingActionsMenuUpdateListener mListener;
    private RotatingDrawable mRotatingDrawable;

    static {
        FloatingActionsMenu.sExpandInterpolator = new OvershootInterpolator();
        FloatingActionsMenu.sCollapseInterpolator = new DecelerateInterpolator(3.0f);
        FloatingActionsMenu.sAlphaExpandInterpolator = new DecelerateInterpolator();
    }

    public FloatingActionsMenu(final Context context) {
        this(context, null);
    }

    public FloatingActionsMenu(final Context context, final AttributeSet set) {
        super(context, set);
        this.mExpandAnimation = new AnimatorSet().setDuration(300L);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300L);
        this.init(context, set);
    }

    public FloatingActionsMenu(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mExpandAnimation = new AnimatorSet().setDuration(300L);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300L);
        this.init(context, set);
    }

    /*public static int access$000(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mAddButtonPlusColor;
    }

    public static int access$100(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mAddButtonColorNormal;
    }

    public static Interpolator access$1000() {
        return FloatingActionsMenu.sCollapseInterpolator;
    }

    public static int access$1100(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mExpandDirection;
    }

    public static int access$200(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mAddButtonColorPressed;
    }*/

    public static RotatingDrawable access$302(final FloatingActionsMenu floatingActionsMenu, final RotatingDrawable mRotatingDrawable) {
        return floatingActionsMenu.mRotatingDrawable = mRotatingDrawable;
    }

    /*public static AnimatorSet access$400(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mExpandAnimation;
    }

    public static AnimatorSet access$500(final FloatingActionsMenu floatingActionsMenu) {
        return floatingActionsMenu.mCollapseAnimation;
    }

    public static Interpolator access$800() {
        return FloatingActionsMenu.sExpandInterpolator;
    }

    public static Interpolator access$900() {
        return FloatingActionsMenu.sAlphaExpandInterpolator;
    }*/

    private int adjustForOvershoot(final int n) {
        return n * 12 / 10;
    }

    private void createAddButton(final Context context) {
        (this.mAddButton = new AddFloatingActionButton(context) {
            @Override
            public Drawable getIconDrawable() {
                final RotatingDrawable rotatingDrawable = new RotatingDrawable(super.getIconDrawable());
                FloatingActionsMenu.access$302(FloatingActionsMenu.this, rotatingDrawable);
                final OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[] { 135.0f, 0.0f });
                final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[] { 0.0f, 135.0f });
                ofFloat.setInterpolator(overshootInterpolator);
                ofFloat2.setInterpolator(overshootInterpolator);
                FloatingActionsMenu.this.mExpandAnimation.play(ofFloat2);
                FloatingActionsMenu.this.mCollapseAnimation.play(ofFloat);
                return rotatingDrawable;
            }

            @Override
            void updateBackground() {
                this.mPlusColor = FloatingActionsMenu.this.mAddButtonPlusColor;
                this.mColorNormal = FloatingActionsMenu.this.mAddButtonColorNormal;
                this.mColorPressed = FloatingActionsMenu.this.mAddButtonColorPressed;
                super.updateBackground();
            }
        }).setId(R.id.fab_expand_menu_button);
        this.mAddButton.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
            public void onClick(final View view) {
                FloatingActionsMenu.this.toggle();
            }
        });
        this.addView((View)this.mAddButton, super.generateDefaultLayoutParams());
    }

    private void createLabels() {
        final int fab_label = R.id.fab_label;
        final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.getContext(), this.mLabelsStyle);
        for (int i = 0; i < this.mButtonsCount; ++i) {
            final FloatingActionButton floatingActionButton = (FloatingActionButton)this.getChildAt(i);
            final String title = floatingActionButton.getTitle();
            if (floatingActionButton != this.mAddButton && title != null && floatingActionButton.getTag(fab_label) == null) {
                final TextView textView = new TextView(contextThemeWrapper);
                this.addView(textView);
                floatingActionButton.setTag(fab_label, textView);
                floatingActionButton.setTitle(title);
                textView.setClickable(false);
            }
        }
    }

    private boolean expandsHorizontally() {
        return this.mExpandDirection == 2 || this.mExpandDirection == 3;
    }

    private int getColor(final int n) {
        return this.getResources().getColor(n);
    }

    @SuppressLint("ResourceType")
    private void init(final Context context, final AttributeSet set) {
        final int fab_shadow_offset = R.dimen.fab_shadow_offset;
        this.mButtonSpacing = (int)(this.getResources().getDimension(R.dimen.fab_actions_spacing) - this.getResources().getDimension(R.dimen.fab_shadow_radius) - this.getResources().getDimension(fab_shadow_offset));
        this.mLabelsMargin = this.getResources().getDimensionPixelSize(R.dimen.fab_labels_margin);
        this.mLabelsVerticalOffset = this.getResources().getDimensionPixelSize(fab_shadow_offset);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.FloatingActionsMenu, 0, 0);
        this.mAddButtonPlusColor = obtainStyledAttributes.getColor(2, this.getColor(17170443));
        this.mAddButtonColorNormal = obtainStyledAttributes.getColor(1, this.getColor(17170451));
        this.mAddButtonColorPressed = obtainStyledAttributes.getColor(0, this.getColor(17170450));
        this.mExpandDirection = obtainStyledAttributes.getInt(4, 0);
        this.mLabelsStyle = obtainStyledAttributes.getResourceId(3, 0);
        obtainStyledAttributes.recycle();
        final SharedPreferences sharedPreferences = context.getSharedPreferences("B58", 0);
        this.mAddButtonColorNormal = sharedPreferences.getInt("FabNormalColor", Color.parseColor("#4db6ac"));
        this.mAddButtonColorPressed = sharedPreferences.getInt("FabPressedColor", Color.parseColor("#4db6ac"));
        if (this.mLabelsStyle != 0 && this.expandsHorizontally()) {
            throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
        }
        this.createAddButton(context);
    }

    private void setLabelsClickable(final boolean clickable) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final TextView textView = (TextView)this.getChildAt(i).getTag(R.id.fab_label);
            if (textView != null) {
                textView.setClickable(clickable);
            }
        }
    }

    public void addButton(final FloatingActionButton floatingActionButton) {
        this.addView((View)floatingActionButton, this.mButtonsCount - 1);
        ++this.mButtonsCount;
        if (this.mLabelsStyle != 0) {
            this.createLabels();
        }
    }

    protected boolean checkLayoutParams(final ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return super.checkLayoutParams(viewGroup$LayoutParams);
    }

    public void collapse() {
        if (this.mExpanded) {
            this.setLabelsClickable(this.mExpanded = false);
            this.mCollapseAnimation.start();
            this.mExpandAnimation.cancel();
            if (this.mListener != null) {
                this.mListener.onMenuCollapsed();
            }
        }
    }

    public void expand() {
        if (!this.mExpanded) {
            this.setLabelsClickable(this.mExpanded = true);
            this.mCollapseAnimation.cancel();
            this.mExpandAnimation.start();
            if (this.mListener != null) {
                this.mListener.onMenuExpanded();
            }
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public ViewGroup.LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(super.generateLayoutParams(set));
    }

    protected ViewGroup.LayoutParams generateLayoutParams(final ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return new LayoutParams(super.generateLayoutParams(viewGroup$LayoutParams));
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.bringChildToFront(this.mAddButton);
        this.mButtonsCount = this.getChildCount();
        if (this.mLabelsStyle != 0) {
            this.createLabels();
        }
    }

    protected void onLayout(final boolean b, int n, int n2, int i, int j) {
        switch (this.mExpandDirection) {
            case 0:
            case 1: {
                boolean b2;
                if (this.mExpandDirection == 0) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                if (b2) {
                    n2 = j - n2 - this.mAddButton.getMeasuredHeight();
                }
                else {
                    n2 = 0;
                }
                j = i - n - this.mAddButton.getMeasuredWidth();
                this.mAddButton.layout(j, n2, this.mAddButton.getMeasuredWidth() + j, this.mAddButton.getMeasuredHeight() + n2);
                final int n3 = j - this.mLabelsMargin;
                if (b2) {
                    n = n2 - this.mButtonSpacing;
                }
                else {
                    n = this.mAddButton.getMeasuredHeight() + n2 + this.mButtonSpacing;
                }
                View child;
                int n4;
                float n5;
                float translationY;
                float alpha;
                LayoutParams layoutParams;
                View animationsTarget;
                int measuredWidth;
                int n6;
                float translationY2;
                float alpha2;
                LayoutParams layoutParams2;
                for (i = this.mButtonsCount - 1; i >= 0; --i) {
                    child = this.getChildAt(i);
                    if (child != this.mAddButton) {
                        n4 = j + (this.mAddButton.getMeasuredWidth() - child.getMeasuredWidth()) / 2;
                        if (b2) {
                            n -= child.getMeasuredHeight();
                        }
                        child.layout(n4, n, child.getMeasuredWidth() + n4, child.getMeasuredHeight() + n);
                        n5 = n2 - n;
                        if (this.mExpanded) {
                            translationY = 0.0f;
                        }
                        else {
                            translationY = n5;
                        }
                        child.setTranslationY(translationY);
                        if (this.mExpanded) {
                            alpha = 1.0f;
                        }
                        else {
                            alpha = 0.0f;
                        }
                        child.setAlpha(alpha);
                        layoutParams = (LayoutParams)child.getLayoutParams();
                        layoutParams.mCollapseDir.setFloatValues(new float[] { 0.0f, n5 });
                        layoutParams.mExpandDir.setFloatValues(new float[] { n5, 0.0f });
                        layoutParams.setAnimationsTarget(child);
                        animationsTarget = (View)child.getTag(R.id.fab_label);
                        if (animationsTarget != null) {
                            measuredWidth = animationsTarget.getMeasuredWidth();
                            n6 = n - this.mLabelsVerticalOffset + (child.getMeasuredHeight() - animationsTarget.getMeasuredHeight()) / 2;
                            animationsTarget.layout(n3 - measuredWidth, n6, n3, animationsTarget.getMeasuredHeight() + n6);
                            if (this.mExpanded) {
                                translationY2 = 0.0f;
                            }
                            else {
                                translationY2 = n5;
                            }
                            animationsTarget.setTranslationY(translationY2);
                            if (this.mExpanded) {
                                alpha2 = 1.0f;
                            }
                            else {
                                alpha2 = 0.0f;
                            }
                            animationsTarget.setAlpha(alpha2);
                            layoutParams2 = (LayoutParams)animationsTarget.getLayoutParams();
                            layoutParams2.mCollapseDir.setFloatValues(new float[] { 0.0f, n5 });
                            layoutParams2.mExpandDir.setFloatValues(new float[] { n5, 0.0f });
                            layoutParams2.setAnimationsTarget(animationsTarget);
                        }
                        if (b2) {
                            n -= this.mButtonSpacing;
                        }
                        else {
                            n = child.getMeasuredHeight() + n + this.mButtonSpacing;
                        }
                    }
                }
                break;
            }
            case 2:
            case 3: {
                if (this.mExpandDirection == 2) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                if (n2 != 0) {
                    i = i - n - this.mAddButton.getMeasuredWidth();
                }
                else {
                    i = 0;
                }
                this.mAddButton.layout(i, 0, this.mAddButton.getMeasuredWidth() + i, this.mAddButton.getMeasuredHeight());
                if (n2 != 0) {
                    n = i - this.mButtonSpacing;
                }
                else {
                    n = this.mAddButton.getMeasuredWidth() + i + this.mButtonSpacing;
                }
                View child2;
                int n7;
                float n8;
                float translationX;
                float alpha3;
                LayoutParams layoutParams3;
                for (j = this.mButtonsCount - 1; j >= 0; --j) {
                    child2 = this.getChildAt(j);
                    if (child2 != this.mAddButton) {
                        if (n2 != 0) {
                            n -= child2.getMeasuredWidth();
                        }
                        n7 = (this.mAddButton.getMeasuredHeight() - child2.getMeasuredHeight()) / 2;
                        child2.layout(n, n7, child2.getMeasuredWidth() + n, child2.getMeasuredHeight() + n7);
                        n8 = i - n;
                        if (this.mExpanded) {
                            translationX = 0.0f;
                        }
                        else {
                            translationX = n8;
                        }
                        child2.setTranslationX(translationX);
                        if (this.mExpanded) {
                            alpha3 = 1.0f;
                        }
                        else {
                            alpha3 = 0.0f;
                        }
                        child2.setAlpha(alpha3);
                        layoutParams3 = (LayoutParams)child2.getLayoutParams();
                        layoutParams3.mCollapseDir.setFloatValues(new float[] { 0.0f, n8 });
                        layoutParams3.mExpandDir.setFloatValues(new float[] { n8, 0.0f });
                        layoutParams3.setAnimationsTarget(child2);
                        if (n2 != 0) {
                            n -= this.mButtonSpacing;
                        }
                        else {
                            n = child2.getMeasuredWidth() + n + this.mButtonSpacing;
                        }
                    }
                }
                break;
            }
        }
    }

    protected void onMeasure(int n, int max) {
        this.measureChildren(n, max);
        max = 0;
        n = 0;
        int n2 = 0;
        int max2;
        for (int i = 0; i < this.mButtonsCount; ++i, n2 = max2) {
            final View child = this.getChildAt(i);
            switch (this.mExpandDirection) {
                case 0:
                case 1: {
                    max = Math.max(max, child.getMeasuredWidth());
                    n += child.getMeasuredHeight();
                    break;
                }
                case 2:
                case 3: {
                    max += child.getMeasuredWidth();
                    n = Math.max(n, child.getMeasuredHeight());
                    break;
                }
            }
            max2 = n2;
            if (!this.expandsHorizontally()) {
                final TextView textView = (TextView)child.getTag(R.id.fab_label);
                max2 = n2;
                if (textView != null) {
                    max2 = Math.max(n2, textView.getMeasuredWidth());
                }
            }
        }
        int adjustForOvershoot = max;
        if (!this.expandsHorizontally()) {
            adjustForOvershoot = max + (this.mLabelsMargin + n2);
        }
        switch (this.mExpandDirection) {
            case 0:
            case 1: {
                n = this.adjustForOvershoot(n + this.mButtonSpacing * (this.getChildCount() - 1));
                break;
            }
            case 2:
            case 3: {
                adjustForOvershoot = this.adjustForOvershoot(adjustForOvershoot + this.mButtonSpacing * (this.getChildCount() - 1));
                break;
            }
        }
        this.setMeasuredDimension(adjustForOvershoot, n);
    }

    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            final SavedState savedState = (SavedState)parcelable;
            this.mExpanded = savedState.mExpanded;
            if (this.mRotatingDrawable != null) {
                final RotatingDrawable mRotatingDrawable = this.mRotatingDrawable;
                float rotation;
                if (this.mExpanded) {
                    rotation = 135.0f;
                }
                else {
                    rotation = 0.0f;
                }
                mRotatingDrawable.setRotation(rotation);
            }
            super.onRestoreInstanceState(savedState.getSuperState());
        }
        else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mExpanded = this.mExpanded;
        return (Parcelable)savedState;
    }

    public void setOnFloatingActionsMenuUpdateListener(final OnFloatingActionsMenuUpdateListener mListener) {
        this.mListener = mListener;
    }

    public void toggle() {
        if (this.mExpanded) {
            this.collapse();
        }
        else {
            this.expand();
        }
    }

    private class LayoutParams extends ViewGroup.LayoutParams
    {
        private ObjectAnimator mCollapseAlpha;
        private ObjectAnimator mCollapseDir;
        private ObjectAnimator mExpandAlpha;
        private ObjectAnimator mExpandDir;

        public LayoutParams(final ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.mExpandDir = new ObjectAnimator();
            this.mExpandAlpha = new ObjectAnimator();
            this.mCollapseDir = new ObjectAnimator();
            this.mCollapseAlpha = new ObjectAnimator();
            this.mExpandDir.setInterpolator(FloatingActionsMenu.sExpandInterpolator);
            this.mExpandAlpha.setInterpolator(FloatingActionsMenu.sAlphaExpandInterpolator);
            this.mCollapseDir.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setProperty(View.ALPHA);
            this.mCollapseAlpha.setFloatValues(new float[] { 1.0f, 0.0f });
            this.mExpandAlpha.setProperty(View.ALPHA);
            this.mExpandAlpha.setFloatValues(new float[] { 0.0f, 1.0f });
            switch (FloatingActionsMenu.this.mExpandDirection) {
                case 0:
                case 1: {
                    this.mCollapseDir.setProperty(View.TRANSLATION_Y);
                    this.mExpandDir.setProperty(View.TRANSLATION_Y);
                    break;
                }
                case 2:
                case 3: {
                    this.mCollapseDir.setProperty(View.TRANSLATION_X);
                    this.mExpandDir.setProperty(View.TRANSLATION_X);
                    break;
                }
            }
            FloatingActionsMenu.this.mExpandAnimation.play((Animator)this.mExpandAlpha);
            FloatingActionsMenu.this.mExpandAnimation.play((Animator)this.mExpandDir);
            FloatingActionsMenu.this.mCollapseAnimation.play((Animator)this.mCollapseAlpha);
            FloatingActionsMenu.this.mCollapseAnimation.play((Animator)this.mCollapseDir);
        }

        public void setAnimationsTarget(final View view) {
            this.mCollapseAlpha.setTarget((Object)view);
            this.mCollapseDir.setTarget((Object)view);
            this.mExpandAlpha.setTarget((Object)view);
            this.mExpandDir.setTarget((Object)view);
        }
    }

    public interface OnFloatingActionsMenuUpdateListener
    {
        void onMenuCollapsed();

        void onMenuExpanded();
    }

    private static class RotatingDrawable extends LayerDrawable
    {
        private float mRotation;

        public RotatingDrawable(final Drawable drawable) {
            super(new Drawable[] { drawable });
        }

        public void draw(final Canvas canvas) {
            canvas.save();
            canvas.rotate(this.mRotation, (float)this.getBounds().centerX(), (float)this.getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setRotation(final float mRotation) {
            this.mRotation = mRotation;
            this.invalidateSelf();
        }
    }

    public static class SavedState extends View.BaseSavedState
    {
        public static final Parcelable.Creator<SavedState> CREATOR;
        public boolean mExpanded;

        static {
            CREATOR = new Parcelable.Creator<SavedState>() {
                public SavedState createFromParcel(final Parcel parcel) {
                    return new SavedState(parcel);
                }

                public SavedState[] newArray(final int n) {
                    return new SavedState[n];
                }
            };
        }

        private SavedState(final Parcel parcel) {
			super(parcel);
            boolean mExpanded = true;
            if (parcel.readInt() != 1) {
                mExpanded = false;
            }
            this.mExpanded = mExpanded;
        }

        public SavedState(final Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel( final Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            if (this.mExpanded) {
                n = 1;
            }
            else {
                n = 0;
            }
            parcel.writeInt(n);
        }
    }
}

