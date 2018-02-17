package com.B58works.extra;

import com.B58works.ColorPref;
import com.whatsapp.architjn.colorPicker.ColorSelectorDialog;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class b implements ColorSelectorDialog.OnColorChangedListener
{
    private final ColorPref a;
    private final String b;

    public b(final ColorPref a, final String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void colorChanged(final int n) {
        this.a.a(this.b, n);
    }
}
