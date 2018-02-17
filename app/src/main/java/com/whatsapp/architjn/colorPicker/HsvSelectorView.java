package com.whatsapp.architjn.colorPicker;

import android.content.*;
import android.util.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;

public class HsvSelectorView extends LinearLayout
{
    private HsvAlphaSelectorView alphaSelector;
    private int color;
    private HsvColorValueView hsvColorValueView;
    private HsvHueSelectorView hueSelector;
    private OnColorChangedListener listener;
    
    public HsvSelectorView(final Context context) {
        super(context);
        this.init();
    }
    
    public HsvSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }
    
    private void buildUI() {
        final View inflate = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(others.getResId(this.getContext(), "color_hsvview", "layout"), (ViewGroup)null);
        this.addView(inflate, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
        this.alphaSelector = (HsvAlphaSelectorView)inflate.findViewById(others.getResId(this.getContext(), "color_hsv_alpha", "id"));
        this.hsvColorValueView = (HsvColorValueView)inflate.findViewById(others.getResId(this.getContext(), "color_hsv_value", "id"));
        this.hueSelector = (HsvHueSelectorView)inflate.findViewById(others.getResId(this.getContext(), "color_hsv_hue", "id"));
        this.alphaSelector.setOnAlphaChangedListener((HsvAlphaSelectorView.OnAlphaChangedListener)new HsvAlphaSelectorView.OnAlphaChangedListener() {
            @Override
            public void alphaChanged(final HsvAlphaSelectorView hsvAlphaSelectorView, final int n) {
                HsvSelectorView.this.internalSetColor(HsvSelectorView.this.getCurrentColor(true), true);
            }
        });
        this.hsvColorValueView.setOnSaturationOrValueChanged((HsvColorValueView.OnSaturationOrValueChanged)new HsvColorValueView.OnSaturationOrValueChanged() {
            @Override
            public void saturationOrValueChanged(final HsvColorValueView hsvColorValueView, final float n, final float n2, final boolean b) {
                HsvSelectorView.this.alphaSelector.setColor(HsvSelectorView.this.getCurrentColor(false));
                HsvSelectorView.this.internalSetColor(HsvSelectorView.this.getCurrentColor(true), b);
            }
        });
        this.hueSelector.setOnHueChangedListener((HsvHueSelectorView.OnHueChangedListener)new HsvHueSelectorView.OnHueChangedListener() {
            @Override
            public void hueChanged(final HsvHueSelectorView hsvHueSelectorView, final float hue) {
                HsvSelectorView.this.hsvColorValueView.setHue(hue);
                HsvSelectorView.this.alphaSelector.setColor(HsvSelectorView.this.getCurrentColor(false));
                HsvSelectorView.this.internalSetColor(HsvSelectorView.this.getCurrentColor(true), true);
            }
        });
        this.setColor(-16777216);
    }
    
    private int getCurrentColor(final boolean b) {
        final float[] array = { this.hueSelector.getHue(), this.hsvColorValueView.getSaturation(), this.hsvColorValueView.getValue() };
        int n;
        if (b) {
            n = (int)this.alphaSelector.getAlpha();
        }
        else {
            n = 255;
        }
        return Color.HSVToColor(n, array);
    }
    
    private void init() {
        this.buildUI();
    }
    
    private void internalSetColor(final int color, final boolean b) {
        this.color = color;
        if (b) {
            this.onColorChanged();
        }
    }
    
    private void onColorChanged() {
        if (this.listener != null) {
            this.listener.colorChanged(this.color);
        }
    }
    
    public int getColor() {
        return this.color;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(this.alphaSelector.getLayoutParams());
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(this.hueSelector.getLayoutParams());
        layoutParams.height = this.hsvColorValueView.getHeight();
        layoutParams2.height = this.hsvColorValueView.getHeight();
        this.hueSelector.setMinContentOffset(this.hsvColorValueView.getBackgroundOffset());
        this.alphaSelector.setMinContentOffset(this.hsvColorValueView.getBackgroundOffset());
        this.alphaSelector.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.hueSelector.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        super.onMeasure(n, n2);
    }
    
    public void setColor(final int color) {
        int n = 1;
        this.alphaSelector.setAlpha(Color.alpha(color));
        final int n2 = color | 0xFF000000;
        final float[] array = new float[3];
        Color.colorToHSV(n2, array);
        this.hueSelector.setHue(array[0]);
        this.hsvColorValueView.setHue(array[0]);
        this.hsvColorValueView.setSaturation(array[n]);
        this.hsvColorValueView.setValue(array[2]);
        this.alphaSelector.setColor(color);
        if (this.color == color) {
            n = 0;
        }
        this.internalSetColor(color, n != 0);
    }
    
    public void setOnColorChangedListener(final OnColorChangedListener listener) {
        this.listener = listener;
    }
    
    public interface OnColorChangedListener
    {
        void colorChanged(final int p0);
    }
}
