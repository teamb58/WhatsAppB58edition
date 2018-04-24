package com.whatsapp.architjn.colorPicker;

import android.app.*;
import android.content.*;
import android.os.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;
import android.widget.LinearLayout.LayoutParams;

public class ColorSelectorDialog extends Dialog
{
    private Button btnNew;
    private Button btnOld;
    private int color;
    private ColorSelectorView content;
    private int initColor;
    private OnColorChangedListener listener;
    
    public ColorSelectorDialog(final Context context, final OnColorChangedListener listener, final int initColor) {
        super(context);
        this.listener = listener;
        this.initColor = initColor;
    }
    
    private void colorChangedInternal(final int n) {
        this.btnNew.setBackgroundColor(n);
        this.btnNew.setTextColor(0xFF000000 | ~n);
        this.color = n;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final LinearLayout contentView = new LinearLayout(this.getContext());
        contentView.setOrientation(LinearLayout.VERTICAL);
        final LinearLayout linearLayout = new LinearLayout(this.getContext());
        final Context context = this.getContext();
        linearLayout.setBackgroundResource(others.getResId(context, "transparentbackrepeat", "drawable"));
        (this.btnOld = new Button(this.getContext())).setText(this.getContext().getResources().getString(others.getResId(context, "color_old_color", "string")));
        final LinearLayout.LayoutParams LayoutParams = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams.weight = 1.0f;
        linearLayout.addView(this.btnOld, LayoutParams);
        this.btnOld.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
            public void onClick(final View view) {
                ColorSelectorDialog.this.dismiss();
            }
        });
        (this.btnNew = new Button(this.getContext())).setText((CharSequence)this.getContext().getResources().getString(others.getResId(context, "color_new_color", "string")));
        final LayoutParams LayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams2.weight = 1.0f;
        linearLayout.addView((View)this.btnNew, (ViewGroup.LayoutParams)LayoutParams2);
        this.btnNew.setOnClickListener((View.OnClickListener)new View.OnClickListener() {
            public void onClick(final View view) {
                if (ColorSelectorDialog.this.listener != null) {
                    ColorSelectorDialog.this.listener.colorChanged(ColorSelectorDialog.this.color);
                }
                ColorSelectorDialog.this.dismiss();
            }
        });
        (this.content = new ColorSelectorView(this.getContext())).setOnColorChangedListener((ColorSelectorView.OnColorChangedListener)new ColorSelectorView.OnColorChangedListener() {
            @Override
            public void colorChanged(final int n) {
                ColorSelectorDialog.this.colorChangedInternal(n);
            }
        });
        final LinearLayout.LayoutParams LayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        LayoutParams3.weight = 1.0f;
        final LinearLayout.LayoutParams LayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams4.weight = 0.0f;
        contentView.addView((View)this.content, (ViewGroup.LayoutParams)LayoutParams3);
        contentView.addView((View)linearLayout, (ViewGroup.LayoutParams)LayoutParams4);
        this.setContentView((View)contentView);
        this.btnOld.setBackgroundColor(this.initColor);
        this.btnOld.setTextColor(0xFF000000 | (-1 ^ this.initColor));
        this.content.setColor(this.initColor);
    }
    
    public void setColor(final int color) {
        this.content.setColor(color);
    }
    
    public interface OnColorChangedListener
    {
        void colorChanged(final int p0);
    }
}
