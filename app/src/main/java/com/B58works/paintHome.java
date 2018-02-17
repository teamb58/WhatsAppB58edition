package com.B58works;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class paintHome implements Runnable
{
    ViewGroup a;

    public paintHome(final ViewGroup a) {
        this.a = a;
    }

    @Override
    public void run() {
        final int int1 = B58.ctx.getSharedPreferences("B58", 0).getInt("HomeBarText", -1);
        try {
            if (this.a.getChildAt(0) instanceof TextView) {
                ((TextView)this.a.getChildAt(0)).setTextColor(int1);
            }
            final ImageView imageView = (ImageView)this.a.findViewById(B58.getResID("up", "id"));
            if (imageView != null) {
                final Drawable drawable = imageView.getDrawable();
                drawable.setColorFilter(int1, PorterDuff.Mode.SRC_IN);
                imageView.setImageDrawable(drawable);
            }
            final Toolbar toolbar = (Toolbar)this.a;
            final Drawable overflowIcon = toolbar.getOverflowIcon();
            if (overflowIcon != null) {
                overflowIcon.setColorFilter(int1, PorterDuff.Mode.SRC_IN);
                toolbar.setOverflowIcon(overflowIcon);
            }
        }
        catch (Exception ex) {}
    }
}
