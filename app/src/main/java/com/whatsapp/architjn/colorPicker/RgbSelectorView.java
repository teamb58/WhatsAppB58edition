package com.whatsapp.architjn.colorPicker;

import android.content.*;
import android.util.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;

public class RgbSelectorView extends LinearLayout
{
    private ImageView imgPreview;
    private OnColorChangedListener listener;
    private SeekBar seekAlpha;
    private SeekBar seekBlue;
    private SeekBar seekGreen;
    private SeekBar seekRed;
    
    public RgbSelectorView(final Context context) {
        super(context);
        this.init();
    }
    
    public RgbSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }
    
    private void init() {
        final View inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(others.getResId(this.getContext(), "color_rgbview", "layout"), (ViewGroup)null);
        this.addView(inflate, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        final SeekBar$OnSeekBarChangeListener seekBar$OnSeekBarChangeListener = (SeekBar$OnSeekBarChangeListener)new SeekBar$OnSeekBarChangeListener() {
            public void onProgressChanged(final SeekBar seekBar, final int n, final boolean b) {
                RgbSelectorView.this.setPreviewImage();
                RgbSelectorView.this.onColorChanged();
            }
            
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }
            
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        };
        (this.seekRed = (SeekBar)inflate.findViewById(others.getResId(this.getContext(), "color_rgb_seekRed", "id"))).setOnSeekBarChangeListener((SeekBar$OnSeekBarChangeListener)seekBar$OnSeekBarChangeListener);
        (this.seekGreen = (SeekBar)inflate.findViewById(others.getResId(this.getContext(), "color_rgb_seekGreen", "id"))).setOnSeekBarChangeListener((SeekBar$OnSeekBarChangeListener)seekBar$OnSeekBarChangeListener);
        (this.seekBlue = (SeekBar)inflate.findViewById(others.getResId(this.getContext(), "color_rgb_seekBlue", "id"))).setOnSeekBarChangeListener((SeekBar$OnSeekBarChangeListener)seekBar$OnSeekBarChangeListener);
        (this.seekAlpha = (SeekBar)inflate.findViewById(others.getResId(this.getContext(), "color_rgb_seekAlpha", "id"))).setOnSeekBarChangeListener((SeekBar$OnSeekBarChangeListener)seekBar$OnSeekBarChangeListener);
        this.imgPreview = (ImageView)inflate.findViewById(others.getResId(this.getContext(), "color_rgb_imgpreview", "id"));
        this.setColor(-16777216);
    }
    
    private void onColorChanged() {
        if (this.listener != null) {
            this.listener.colorChanged(this.getColor());
        }
    }
    
    private void setPreviewImage() {
        final Bitmap bitmap = Bitmap.createBitmap(1, 1, Bitmap$Config.ARGB_8888);
        bitmap.setPixel(0, 0, this.getColor());
        this.imgPreview.setImageBitmap(bitmap);
    }
    
    public int getColor() {
        return Color.argb(this.seekAlpha.getProgress(), this.seekRed.getProgress(), this.seekGreen.getProgress(), this.seekBlue.getProgress());
    }
    
    public void setColor(final int n) {
        this.seekAlpha.setProgress(Color.alpha(n));
        this.seekRed.setProgress(Color.red(n));
        this.seekGreen.setProgress(Color.green(n));
        this.seekBlue.setProgress(Color.blue(n));
        this.setPreviewImage();
    }
    
    public void setOnColorChangedListener(final OnColorChangedListener listener) {
        this.listener = listener;
    }
    
    public interface OnColorChangedListener
    {
        void colorChanged(final int p0);
    }
}
