package com.whatsapp.architjn.ui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.whatsapp.architjn.store.ColorStore;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

public class FabButton extends FloatingActionButton
{
    private Context context;

    public FabButton(final Context context) {
        super(context);
        this.context = context;
    }

    public FabButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.context = context;
    }

    public FabButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.context = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        final SharedPreferences sharedPreferences = this.context.getSharedPreferences("B58", 0);
        this.setColorNormal(sharedPreferences.getInt("FabNormalColor", ColorStore.getFabColorNormal()));
        this.setColorPressed(sharedPreferences.getInt("FabPressedColor", ColorStore.getFabColorPressed()));
    }
}
