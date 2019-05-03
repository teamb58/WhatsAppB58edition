package com.whatsapp.architjn.ui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;

import com.B58works.ColorStore;
import com.getbase.floatingactionbutton.FloatingActionButton;

/**
 * Created by architjn on 05/04/15.
 */
public class FabButton extends FloatingActionButton {

    private Context context;

    public FabButton(Context context) {
        super(context);
        this.context = context;
    }

    public FabButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public FabButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        SharedPreferences shp = context.getSharedPreferences("architMod", Context.MODE_PRIVATE);
        setColorNormal(shp.getInt("architModFabNormalColor", ColorStore.getFabColorNormal()));
        setColorPressed(shp.getInt("architModFabPressedColor", ColorStore.getFabColorPressed()));
    }
}
