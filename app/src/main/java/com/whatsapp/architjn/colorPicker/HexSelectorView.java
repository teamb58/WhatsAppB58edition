package com.whatsapp.architjn.colorPicker;

import android.content.*;
import android.util.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;

public class HexSelectorView extends LinearLayout
{
    private Button btnSave;
    private int color;
    private EditText edit;
    private OnColorChangedListener listener;
    private TextView txtError;
    
    public HexSelectorView(final Context context) {
        super(context);
        this.init();
    }
    
    public HexSelectorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }
    
    private void init() {
        final LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService("layout_inflater");
        final Context context = this.getContext();
        final View inflate = layoutInflater.inflate(others.getResId(context, "color_hexview", "layout"), (ViewGroup)null);
        this.addView(inflate, (ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        this.txtError = (TextView)inflate.findViewById(others.getResId(context, "color_hex_txtError", "id"));
        this.edit = (EditText)inflate.findViewById(others.getResId(context, "color_hex_edit", "id"));
        (this.btnSave = (Button)inflate.findViewById(others.getResId(context, "color_hex_btnSave", "id"))).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                String s = null;
                Label_0103: {
                    try {
                        s = HexSelectorView.this.edit.getText().toString();
                        if (s.startsWith("0x")) {
                            s = s.substring(2);
                        }
                        if (s.startsWith("#")) {
                            s = s.substring(1);
                        }
                        if (s.length() == 6) {
                            s = "FF" + s;
                        }
                        if (s.length() != 8) {
                            throw new Exception();
                        }
                        break Label_0103;
                    }
                    catch (Exception ex) {
                        HexSelectorView.this.txtError.setVisibility(0);
                    }
                    return;
                }
                HexSelectorView.this.color = (int)Long.parseLong(s, 16);
                HexSelectorView.this.txtError.setVisibility(8);
                HexSelectorView.this.onColorChanged();
            }
        });
    }
    
    private void onColorChanged() {
        if (this.listener != null) {
            this.listener.colorChanged(this.getColor());
        }
    }
    
    private String padLeft(String string, final char c, final int n) {
        if (string.length() < n) {
            final StringBuilder sb = new StringBuilder();
            for (int i = string.length(); i < n; ++i) {
                sb.append(c);
            }
            sb.append(string);
            string = sb.toString();
        }
        return string;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public void setColor(final int color) {
        if (color != this.color) {
            this.color = color;
            this.edit.setText((CharSequence)this.padLeft(Integer.toHexString(color).toUpperCase(), '0', 8));
            this.txtError.setVisibility(8);
        }
    }
    
    public void setOnColorChangedListener(final OnColorChangedListener listener) {
        this.listener = listener;
    }
    
    public interface OnColorChangedListener
    {
        void colorChanged(final int p0);
    }
}
