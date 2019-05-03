package com.whatsapp.architjn.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.B58works.ColorStore;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class ConversationView extends FrameLayout {

    private Context context;
    private int pointX, pointY;
    private double screenWidthInPixels, screenHeightInPixels;


    public ConversationView(Context context) {
        super(context);
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ConversationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    public ConversationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public ConversationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final String posId = "1";
        final FloatingActionsMenu a = (FloatingActionsMenu) getChildAt(Integer.parseInt(posId));
        final SharedPreferences shp = context.getSharedPreferences("B58", Context.MODE_PRIVATE);
        final ImageView cardView = new ImageView(context);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        cardView.setLayoutParams(lp);
        cardView.setVisibility(GONE);
        cardView.setBackgroundColor(shp.getInt("fabbg", ColorStore.getFabBgColor()));
        cardView.setAlpha(0.9f);
        addView(cardView, Integer.parseInt(posId));
        String one = "0", two = "1", three = "2";
        Configuration config = getResources().getConfiguration();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidthInPixels = (double) config.screenWidthDp * dm.density;
        screenHeightInPixels = screenWidthInPixels * dm.heightPixels / dm.widthPixels;
        screenHeightInPixels = screenHeightInPixels + (screenHeightInPixels / 4);
        pointX = Integer.parseInt(shp.getString("PosX", "500"));
        pointY = Integer.parseInt(shp.getString("PosY", "500"));
        cardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                a.collapse();
            }
        });
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(one))).setColorNormal(shp.getInt("fabnormal", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(two))).setColorNormal(shp.getInt("fabnormal", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(three))).setColorNormal(shp.getInt("fabnormal", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(one))).setColorPressed(shp.getInt("fabpressed", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(two))).setColorPressed(shp.getInt("fabpressed", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) a.getChildAt(Integer.parseInt(three))).setColorPressed(shp.getInt("fabpressed", ColorStore.getFabColorNormal()));
        a.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    cardView.setVisibility(View.VISIBLE);
                    final Animator anim_start = ViewAnimationUtils.createCircularReveal(cardView,
                            pointX,
                            pointY,
                            0,
                            (int) screenHeightInPixels)
                            .setDuration(700);
                    anim_start.start();
                } else {
                    ObjectAnimator fadeIn = ObjectAnimator.ofFloat(cardView, "alpha", 0, 0.9f);
                    fadeIn.setDuration(300);
                    cardView.setVisibility(View.VISIBLE);
                    fadeIn.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                        }
                    });
                    fadeIn.start();
                }
            }

            @Override
            public void onMenuCollapsed() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    final Animator anim_end = ViewAnimationUtils.createCircularReveal(cardView,
                            pointX,
                            pointY,
                            (int) screenHeightInPixels, 0)
                            .setDuration(700);
                    anim_end.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cardView.setVisibility(View.GONE);
                        }
                    });
                    anim_end.start();
                } else {
                    ObjectAnimator fadeOut = ObjectAnimator.ofFloat(cardView, "alpha", 0.9f, 0);
                    fadeOut.setDuration(300);
                    fadeOut.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            cardView.setVisibility(View.GONE);
                        }
                    });
                    fadeOut.start();
                }
            }
        });
    }

    public static int getNavigationBarHeight(Activity activity) {
        Resources resources = activity.getApplicationContext().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

}
