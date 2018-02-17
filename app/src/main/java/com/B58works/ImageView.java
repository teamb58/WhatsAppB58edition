package com.B58works;

import android.content.*;
import android.util.*;
import android.annotation.*;
import android.graphics.drawable.*;
import android.os.*;
import android.graphics.*;
import android.net.*;
import android.view.animation.*;
import android.widget.*;
import android.view.*;

public class ImageView extends android.widget.ImageView
{
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    private Context context;
    private Fling fling;
    private float[] m;
    private GestureDetector mGestureDetector;
    private ScaleGestureDetector mScaleDetector;
    private boolean maintainZoomAfterSetImage;
    private float matchViewHeight;
    private float matchViewWidth;
    private Matrix matrix;
    private float maxScale;
    private float minScale;
    private float normalizedScale;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    private boolean setImageCalledRecenterImage;
    private State state;
    private float superMaxScale;
    private float superMinScale;
    private int viewHeight;
    private int viewWidth;
    
    public ImageView(final Context context) {
        super(context);
        this.sharedConstructing(context);
    }
    
    public ImageView(final Context context, final AttributeSet set) {
        super(context, set);
        this.sharedConstructing(context);
    }
    
    public ImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.sharedConstructing(context);
    }
    
    static /* synthetic */ void access$1(final ImageView imageView, final Fling fling) {
        imageView.fling = fling;
    }
    
    @TargetApi(16)
    private void compatPostOnAnimation(final Runnable runnable) {
        if (Build$VERSION.SDK_INT >= 16) {
            this.postOnAnimation(runnable);
        }
        else {
            this.postDelayed(runnable, 16L);
        }
    }
    
    private void fitImageToView() {
        final Drawable drawable = this.getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.matrix != null && this.prevMatrix != null) {
            final int intrinsicWidth = drawable.getIntrinsicWidth();
            final int intrinsicHeight = drawable.getIntrinsicHeight();
            final float min = Math.min(this.viewWidth / intrinsicWidth, this.viewHeight / intrinsicHeight);
            final float n = this.viewHeight - min * intrinsicHeight;
            final float n2 = this.viewWidth - min * intrinsicWidth;
            this.matchViewWidth = this.viewWidth - n2;
            this.matchViewHeight = this.viewHeight - n;
            if (this.normalizedScale == 1.0f || this.setImageCalledRecenterImage) {
                this.matrix.setScale(min, min);
                this.matrix.postTranslate(n2 / 2.0f, n / 2.0f);
                this.normalizedScale = 1.0f;
                this.setImageCalledRecenterImage = false;
            }
            else {
                this.prevMatrix.getValues(this.m);
                this.m[0] = this.matchViewWidth / intrinsicWidth * this.normalizedScale;
                this.m[4] = this.matchViewHeight / intrinsicHeight * this.normalizedScale;
                final float n3 = this.m[2];
                final float n4 = this.m[5];
                this.translateMatrixAfterRotate(2, n3, this.prevMatchViewWidth * this.normalizedScale, this.getImageWidth(), this.prevViewWidth, this.viewWidth, intrinsicWidth);
                this.translateMatrixAfterRotate(5, n4, this.prevMatchViewHeight * this.normalizedScale, this.getImageHeight(), this.prevViewHeight, this.viewHeight, intrinsicHeight);
                this.matrix.setValues(this.m);
            }
            this.setImageMatrix(this.matrix);
        }
    }
    
    private void fixScaleTrans() {
        this.fixTrans();
        this.matrix.getValues(this.m);
        if (this.getImageWidth() < this.viewWidth) {
            this.m[2] = (this.viewWidth - this.getImageWidth()) / 2.0f;
        }
        if (this.getImageHeight() < this.viewHeight) {
            this.m[5] = (this.viewHeight - this.getImageHeight()) / 2.0f;
        }
        this.matrix.setValues(this.m);
    }
    
    private float getFixDragTrans(float n, final float n2, final float n3) {
        if (n3 <= n2) {
            n = 0.0f;
        }
        return n;
    }
    
    private float getFixTrans(final float n, final float n2, final float n3) {
        float n4;
        float n5;
        if (n3 <= n2) {
            n4 = n2 - n3;
            n5 = 0.0f;
        }
        else {
            n5 = n2 - n3;
            n4 = 0.0f;
        }
        float n6;
        if (n < n5) {
            n6 = n5 + -n;
        }
        else {
            final float n7 = fcmpl(n, n4);
            n6 = 0.0f;
            if (n7 > 0) {
                n6 = n4 + -n;
            }
        }
        return n6;
    }
    
    private float getImageHeight() {
        return this.matchViewHeight * this.normalizedScale;
    }
    
    private float getImageWidth() {
        return this.matchViewWidth * this.normalizedScale;
    }
    
    private void savePreviousImageValues() {
        if (this.matrix != null) {
            this.matrix.getValues(this.m);
            this.prevMatrix.setValues(this.m);
            this.prevMatchViewHeight = this.matchViewHeight;
            this.prevMatchViewWidth = this.matchViewWidth;
            this.prevViewHeight = this.viewHeight;
            this.prevViewWidth = this.viewWidth;
        }
    }
    
    private void scaleImage(float n, final float n2, final float n3, final boolean b) {
        float normalizedScale;
        float normalizedScale2;
        if (b) {
            normalizedScale = this.superMinScale;
            normalizedScale2 = this.superMaxScale;
        }
        else {
            normalizedScale = this.minScale;
            normalizedScale2 = this.maxScale;
        }
        final float normalizedScale3 = this.normalizedScale;
        this.normalizedScale *= n;
        if (this.normalizedScale > normalizedScale2) {
            this.normalizedScale = normalizedScale2;
            n = normalizedScale2 / normalizedScale3;
        }
        else if (this.normalizedScale < normalizedScale) {
            this.normalizedScale = normalizedScale;
            n = normalizedScale / normalizedScale3;
        }
        this.matrix.postScale(n, n, n2, n3);
        this.fixScaleTrans();
    }
    
    private void setImageCalled() {
        if (!this.maintainZoomAfterSetImage) {
            this.setImageCalledRecenterImage = true;
        }
    }
    
    private void setState(final State state) {
        this.state = state;
    }
    
    private int setViewSize(final int n, int min, final int n2) {
        switch (n) {
            case -1342177280: {
                min = Math.min(n2, min);
                break;
            }
            case 0: {
                min = n2;
                break;
            }
        }
        return min;
    }
    
    private void sharedConstructing(final Context context) {
        super.setClickable(true);
        this.context = context;
        this.mScaleDetector = new ScaleGestureDetector(context, (ScaleGestureDetector$OnScaleGestureListener)new ScaleListener((ScaleListener)null));
        this.mGestureDetector = new GestureDetector(context, (GestureDetector$OnGestureListener)new GestureListener((GestureListener)null));
        this.matrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.m = new float[9];
        this.normalizedScale = 1.0f;
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.superMinScale = 0.75f * this.minScale;
        this.superMaxScale = 1.25f * this.maxScale;
        this.maintainZoomAfterSetImage = true;
        this.setImageMatrix(this.matrix);
        this.setScaleType(ImageView$ScaleType.MATRIX);
        this.setState(State.NONE);
        this.setOnTouchListener((View$OnTouchListener)new ImageViewListener((ImageViewListener)null));
    }
    
    private PointF transformCoordBitmapToTouch(final float n, final float n2) {
        this.matrix.getValues(this.m);
        return new PointF(this.m[2] + n / this.getDrawable().getIntrinsicWidth() * this.getImageWidth(), this.m[5] + n2 / this.getDrawable().getIntrinsicHeight() * this.getImageHeight());
    }
    
    private PointF transformCoordTouchToBitmap(final float n, final float n2, final boolean b) {
        this.matrix.getValues(this.m);
        final float n3 = this.getDrawable().getIntrinsicWidth();
        final float n4 = this.getDrawable().getIntrinsicHeight();
        final float n5 = this.m[2];
        final float n6 = this.m[5];
        float min = n3 * (n - n5) / this.getImageWidth();
        float min2 = n4 * (n2 - n6) / this.getImageHeight();
        if (b) {
            min = Math.min(Math.max(n, 0.0f), n3);
            min2 = Math.min(Math.max(n2, 0.0f), n4);
        }
        return new PointF(min, min2);
    }
    
    private void translateMatrixAfterRotate(final int n, final float n2, final float n3, final float n4, final int n5, final int n6, final int n7) {
        if (n4 < n6) {
            this.m[n] = 0.5f * (n6 - n7 * this.m[0]);
        }
        else if (n2 > 0.0f) {
            this.m[n] = -(0.5f * (n4 - n6));
        }
        else {
            this.m[n] = -((Math.abs(n2) + 0.5f * n5) / n3 * n4 - 0.5f * n6);
        }
    }
    
    public void fixTrans() {
        this.matrix.getValues(this.m);
        final float n = this.m[2];
        final float n2 = this.m[5];
        final float fixTrans = this.getFixTrans(n, this.viewWidth, this.getImageWidth());
        final float fixTrans2 = this.getFixTrans(n2, this.viewHeight, this.getImageHeight());
        if (fixTrans != 0.0f || fixTrans2 != 0.0f) {
            this.matrix.postTranslate(fixTrans, fixTrans2);
        }
    }
    
    public float getCurrentZoom() {
        return this.normalizedScale;
    }
    
    public PointF getDrawablePointFromTouchPoint(final float n, final float n2) {
        return this.transformCoordTouchToBitmap(n, n2, true);
    }
    
    public PointF getDrawablePointFromTouchPoint(final PointF pointF) {
        return this.transformCoordTouchToBitmap(pointF.x, pointF.y, true);
    }
    
    public float getMaxZoom() {
        return this.maxScale;
    }
    
    public float getMinZoom() {
        return this.minScale;
    }
    
    public void maintainZoomAfterSetImage(final boolean maintainZoomAfterSetImage) {
        this.maintainZoomAfterSetImage = maintainZoomAfterSetImage;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final Drawable drawable = this.getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            this.setMeasuredDimension(0, 0);
        }
        else {
            final int intrinsicWidth = drawable.getIntrinsicWidth();
            final int intrinsicHeight = drawable.getIntrinsicHeight();
            final int size = View$MeasureSpec.getSize(n);
            final int mode = View$MeasureSpec.getMode(n);
            final int size2 = View$MeasureSpec.getSize(n2);
            final int mode2 = View$MeasureSpec.getMode(n2);
            this.viewWidth = this.setViewSize(mode, size, intrinsicWidth);
            this.viewHeight = this.setViewSize(mode2, size2, intrinsicHeight);
            this.setMeasuredDimension(this.viewWidth, this.viewHeight);
            this.fitImageToView();
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            final Bundle bundle = (Bundle)parcelable;
            this.normalizedScale = bundle.getFloat("saveScale");
            this.m = bundle.getFloatArray("matrix");
            this.prevMatrix.setValues(this.m);
            this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
            this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
            this.prevViewHeight = bundle.getInt("viewHeight");
            this.prevViewWidth = bundle.getInt("viewWidth");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
        }
        else {
            super.onRestoreInstanceState(parcelable);
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.normalizedScale);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.matrix.getValues(this.m);
        bundle.putFloatArray("matrix", this.m);
        return (Parcelable)bundle;
    }
    
    public void setImageBitmap(final Bitmap imageBitmap) {
        super.setImageBitmap(imageBitmap);
        this.setImageCalled();
        this.savePreviousImageValues();
        this.fitImageToView();
    }
    
    public void setImageDrawable(final Drawable imageDrawable) {
        super.setImageDrawable(imageDrawable);
        this.setImageCalled();
        this.savePreviousImageValues();
        this.fitImageToView();
    }
    
    public void setImageResource(final int imageResource) {
        super.setImageResource(imageResource);
        this.setImageCalled();
        this.savePreviousImageValues();
        this.fitImageToView();
    }
    
    public void setImageURI(final Uri imageURI) {
        super.setImageURI(imageURI);
        this.setImageCalled();
        this.savePreviousImageValues();
        this.fitImageToView();
    }
    
    public void setMaxZoom(final float maxScale) {
        this.maxScale = maxScale;
        this.superMaxScale = 1.25f * this.maxScale;
    }
    
    public void setMinZoom(final float minScale) {
        this.minScale = minScale;
        this.superMinScale = 0.75f * this.minScale;
    }
    
    private class DoubleTapZoom implements Runnable
    {
        private static final float ZOOM_TIME = 500.0f;
        private float bitmapX;
        private float bitmapY;
        private PointF endTouch;
        private AccelerateDecelerateInterpolator interpolator;
        private long startTime;
        private PointF startTouch;
        private float startZoom;
        private boolean stretchImageToSuper;
        private float targetZoom;
        
        DoubleTapZoom(final float targetZoom, final float n, final float n2, final boolean stretchImageToSuper) {
            this.interpolator = new AccelerateDecelerateInterpolator();
            ImageView.this.setState(State.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = ImageView.this.normalizedScale;
            this.targetZoom = targetZoom;
            this.stretchImageToSuper = stretchImageToSuper;
            final PointF access$17 = ImageView.this.transformCoordTouchToBitmap(n, n2, false);
            this.bitmapX = access$17.x;
            this.bitmapY = access$17.y;
            this.startTouch = ImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            this.endTouch = new PointF((float)(ImageView.this.viewWidth / 2), (float)(ImageView.this.viewHeight / 2));
        }
        
        private float calculateDeltaScale(final float n) {
            return (this.startZoom + n * (this.targetZoom - this.startZoom)) / ImageView.this.normalizedScale;
        }
        
        private float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.startTime) / 500.0f));
        }
        
        private void translateImageToCenterTouchPosition(final float n) {
            final float x = this.startTouch.x;
            final float x2 = this.endTouch.x;
            final float x3 = this.startTouch.x;
            final float y = this.startTouch.y;
            final float y2 = this.endTouch.y;
            final float y3 = this.startTouch.y;
            final PointF access$18 = ImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            ImageView.this.matrix.postTranslate(x + n * (x2 - x3) - access$18.x, y + n * (y2 - y3) - access$18.y);
        }
        
        @Override
        public void run() {
            final float interpolate = this.interpolate();
            ImageView.this.scaleImage(this.calculateDeltaScale(interpolate), this.bitmapX, this.bitmapY, this.stretchImageToSuper);
            this.translateImageToCenterTouchPosition(interpolate);
            ImageView.this.fixScaleTrans();
            ImageView.this.setImageMatrix(ImageView.this.matrix);
            if (interpolate < 1.0f) {
                ImageView.this.compatPostOnAnimation(this);
            }
            else {
                ImageView.this.setState(State.NONE);
            }
        }
    }
    
    private class Fling implements Runnable
    {
        int currX;
        int currY;
        Scroller scroller;
        
        Fling(final int n, final int n2) {
            ImageView.this.setState(State.FLING);
            this.scroller = new Scroller(ImageView.this.context);
            ImageView.this.matrix.getValues(ImageView.this.m);
            final int currX = (int)ImageView.this.m[2];
            final int currY = (int)ImageView.this.m[5];
            int n3;
            int n4;
            if (ImageView.this.getImageWidth() > ImageView.this.viewWidth) {
                n3 = ImageView.this.viewWidth - (int)ImageView.this.getImageWidth();
                n4 = 0;
            }
            else {
                n3 = currX;
                n4 = currX;
            }
            int n5;
            int n6;
            if (ImageView.this.getImageHeight() > ImageView.this.viewHeight) {
                n5 = ImageView.this.viewHeight - (int)ImageView.this.getImageHeight();
                n6 = 0;
            }
            else {
                n6 = currY;
                n5 = currY;
            }
            this.scroller.fling(currX, currY, n, n2, n3, n4, n5, n6);
            this.currX = currX;
            this.currY = currY;
        }
        
        public void cancelFling() {
            if (this.scroller != null) {
                ImageView.this.setState(State.NONE);
                this.scroller.forceFinished(true);
            }
        }
        
        @Override
        public void run() {
            if (this.scroller.isFinished()) {
                this.scroller = null;
            }
            else if (this.scroller.computeScrollOffset()) {
                final int currX = this.scroller.getCurrX();
                final int currY = this.scroller.getCurrY();
                final int currX2 = this.currX;
                final int currY2 = this.currY;
                this.currX = currX;
                this.currY = currY;
                ImageView.this.matrix.postTranslate((float)(currX - currX2), (float)(currY - currY2));
                ImageView.this.fixTrans();
                ImageView.this.setImageMatrix(ImageView.this.matrix);
                ImageView.this.compatPostOnAnimation(this);
            }
        }
    }
    
    private class GestureListener extends GestureDetector$SimpleOnGestureListener
    {
        public boolean onDoubleTap(final MotionEvent motionEvent) {
            final State access$3 = ImageView.this.state;
            final State none = State.NONE;
            boolean b = false;
            if (access$3 == none) {
                float n;
                if (ImageView.this.normalizedScale == ImageView.this.minScale) {
                    n = ImageView.this.maxScale;
                }
                else {
                    n = ImageView.this.minScale;
                }
                ImageView.this.compatPostOnAnimation(new DoubleTapZoom(n, motionEvent.getX(), motionEvent.getY(), false));
                b = true;
            }
            return b;
        }
        
        public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
            if (ImageView.this.fling != null) {
                ImageView.this.fling.cancelFling();
            }
            ImageView.access$1(ImageView.this, new Fling((int)n, (int)n2));
            ImageView.this.compatPostOnAnimation(ImageView.this.fling);
            return super.onFling(motionEvent, motionEvent2, n, n2);
        }
        
        public void onLongPress(final MotionEvent motionEvent) {
            ImageView.this.performLongClick();
        }
        
        public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
            return ImageView.this.performClick();
        }
    }
    
    private class ImageViewListener implements View$OnTouchListener
    {
        private PointF last;
        
        private ImageViewListener() {
            this.last = new PointF();
        }
        
        public boolean onTouch(final View view, final MotionEvent motionEvent) {
            ImageView.this.mScaleDetector.onTouchEvent(motionEvent);
            ImageView.this.mGestureDetector.onTouchEvent(motionEvent);
            final PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            if (ImageView.this.state == State.NONE || ImageView.this.state == State.DRAG || ImageView.this.state == State.FLING) {
                switch (motionEvent.getAction()) {
                    case 0: {
                        this.last.set(pointF);
                        if (ImageView.this.fling != null) {
                            ImageView.this.fling.cancelFling();
                        }
                        ImageView.this.setState(State.DRAG);
                        break;
                    }
                    case 2: {
                        if (ImageView.this.state == State.DRAG) {
                            ImageView.this.matrix.postTranslate(ImageView.this.getFixDragTrans(pointF.x - this.last.x, ImageView.this.viewWidth, ImageView.this.getImageWidth()), ImageView.this.getFixDragTrans(pointF.y - this.last.y, ImageView.this.viewHeight, ImageView.this.getImageHeight()));
                            ImageView.this.fixTrans();
                            this.last.set(pointF.x, pointF.y);
                            break;
                        }
                        break;
                    }
                    case 1:
                    case 6: {
                        ImageView.this.setState(State.NONE);
                        break;
                    }
                }
            }
            ImageView.this.setImageMatrix(ImageView.this.matrix);
            return true;
        }
    }
    
    private class ScaleListener extends ScaleGestureDetector$SimpleOnScaleGestureListener
    {
        public boolean onScale(final ScaleGestureDetector scaleGestureDetector) {
            ImageView.this.scaleImage(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            return true;
        }
        
        public boolean onScaleBegin(final ScaleGestureDetector scaleGestureDetector) {
            ImageView.this.setState(State.ZOOM);
            return true;
        }
        
        public void onScaleEnd(final ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            ImageView.this.setState(State.NONE);
            float n = ImageView.this.normalizedScale;
            int n2;
            if (ImageView.this.normalizedScale > ImageView.this.maxScale) {
                n = ImageView.this.maxScale;
                n2 = 1;
            }
            else {
                final float n3 = fcmpg(ImageView.this.normalizedScale, ImageView.this.minScale);
                n2 = 0;
                if (n3 < 0) {
                    n = ImageView.this.minScale;
                    n2 = 1;
                }
            }
            if (n2 != 0) {
                ImageView.this.compatPostOnAnimation(new DoubleTapZoom(n, ImageView.this.viewWidth / 2, ImageView.this.viewHeight / 2, true));
            }
        }
    }
    
    public enum State
    {
        ANIMATE_ZOOM("ANIMATE_ZOOM", 4), 
        DRAG("DRAG", 1), 
        FLING("FLING", 3), 
        NONE("NONE", 0), 
        ZOOM("ZOOM", 2);
        
        private State(final String s, final int n) {
        }
    }
}
