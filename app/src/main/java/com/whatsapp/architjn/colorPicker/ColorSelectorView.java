package com.whatsapp.architjn.colorPicker;

import android.content.*;
import android.util.*;
import com.whatsapp.architjn.*;
import android.view.*;
import android.widget.*;

public class ColorSelectorView extends LinearLayout
{
    private static final String HEX_TAG = "HEX";
    private static final String HSV_TAG = "HSV";
    private static final String RGB_TAG = "RGB";
    private int color;
    private HexSelectorView hexSelector;
    private HsvSelectorView hsvSelector;
    private OnColorChangedListener listener;
    private int maxHeight;
    private int maxWidth;
    private RgbSelectorView rgbSelector;
    private TabHost tabs;
    
    public ColorSelectorView(final Context context) {
        super(context);
        this.maxHeight = 0;
        this.maxWidth = 0;
        this.init();
    }
    
    public ColorSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.maxHeight = 0;
        this.maxWidth = 0;
        this.init();
    }
    
    private void init() {
        final LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final Context context = this.getContext();
        final View inflate = layoutInflater.inflate(others.getResId(context, "color_colorselectview", "layout"), (ViewGroup)null);
        this.addView(inflate, new LinearLayout.LayoutParams(-1, -1));
        (this.hsvSelector = new HsvSelectorView(this.getContext())).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.hsvSelector.setOnColorChangedListener((HsvSelectorView.OnColorChangedListener)new HsvSelectorView.OnColorChangedListener() {
            @Override
            public void colorChanged(final int color) {
                ColorSelectorView.this.setColor(color);
            }
        });
        (this.rgbSelector = new RgbSelectorView(this.getContext())).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
        this.rgbSelector.setOnColorChangedListener((RgbSelectorView.OnColorChangedListener)new RgbSelectorView.OnColorChangedListener() {
            @Override
            public void colorChanged(final int color) {
                ColorSelectorView.this.setColor(color);
            }
        });
        (this.hexSelector = new HexSelectorView(this.getContext())).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
        this.hexSelector.setOnColorChangedListener((HexSelectorView.OnColorChangedListener)new HexSelectorView.OnColorChangedListener() {
            @Override
            public void colorChanged(final int color) {
                ColorSelectorView.this.setColor(color);
            }
        });
        (this.tabs = (TabHost)inflate.findViewById(others.getResId(context, "colorview_tabColors", "id"))).setup();
        final ColorTabContentFactory content = new ColorTabContentFactory();
        final TabHost.TabSpec setContent = this.tabs.newTabSpec("HSV").setIndicator((CharSequence)"HSV", this.getContext().getResources().getDrawable(others.getResId(context, "hsv32", "drawable"))).setContent((TabHost.TabContentFactory)content);
        final TabHost.TabSpec setContent2 = this.tabs.newTabSpec("RGB").setIndicator((CharSequence)"RGB", this.getContext().getResources().getDrawable(others.getResId(context, "rgb32", "drawable"))).setContent((TabHost.TabContentFactory)content);
        final TabHost.TabSpec setContent3 = this.tabs.newTabSpec("HEX").setIndicator((CharSequence)"HEX", this.getContext().getResources().getDrawable(others.getResId(context, "hex32", "drawable"))).setContent((TabHost.TabContentFactory)content);
        this.tabs.addTab(setContent);
        this.tabs.addTab(setContent2);
        this.tabs.addTab(setContent3);
    }
    
    private void onColorChanged() {
        if (this.listener != null) {
            this.listener.colorChanged(this.getColor());
        }
    }
    
    private void setColor(final int n, final View view) {
        if (this.color != n) {
            this.color = n;
            if (view != this.hsvSelector) {
                this.hsvSelector.setColor(n);
            }
            if (view != this.rgbSelector) {
                this.rgbSelector.setColor(n);
            }
            if (view != this.hexSelector) {
                this.hexSelector.setColor(n);
            }
            this.onColorChanged();
        }
    }
    
    public int getColor() {
        return this.color;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if ("HSV".equals(this.tabs.getCurrentTabTag())) {
            this.maxHeight = this.getMeasuredHeight();
            this.maxWidth = this.getMeasuredWidth();
        }
        this.setMeasuredDimension(this.maxWidth, this.maxHeight);
    }
    
    public void setColor(final int n) {
        this.setColor(n, null);
    }
    
    public void setOnColorChangedListener(final OnColorChangedListener listener) {
        this.listener = listener;
    }
    
    class ColorTabContentFactory implements TabHost.TabContentFactory
    {
        public View createTabContent(final String s) {
            Object o;
            if ("HSV".equals(s)) {
                o = ColorSelectorView.this.hsvSelector;
            }
            else if ("RGB".equals(s)) {
                o = ColorSelectorView.this.rgbSelector;
            }
            else if ("HEX".equals(s)) {
                o = ColorSelectorView.this.hexSelector;
            }
            else {
                o = null;
            }
            return (View)o;
        }
    }
    
    public interface OnColorChangedListener
    {
        void colorChanged(final int p0);
    }
}
