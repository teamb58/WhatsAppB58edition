package com.whatsapp.architjn.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.whatsapp.architjn.store.ColorStore;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

public class ConversationView extends FrameLayout {
    private Context context;
    private int pointX;
    private int pointY;
    private double screenHeightInPixels;
    private double screenWidthInPixels;

    public ConversationView(final Context context) {
        super(context);
        this.context = context;
    }

    public ConversationView(final Context context, final AttributeSet set) {
        super(context, set);
        this.context = context;
    }

    public ConversationView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.context = context;
    }

    public static int access$000(final ConversationView conversationView) {
        return conversationView.pointX;
    }

    public static int access$100(final ConversationView conversationView) {
        return conversationView.pointY;
    }

    public static double access$200(final ConversationView conversationView) {
        return conversationView.screenHeightInPixels;
    }

    public static int getNavigationBarHeight(final Activity activity) {
        final Resources resources = activity.getApplicationContext().getResources();
        final int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize;
        if (identifier > 0) {
            dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        } else {
            dimensionPixelSize = 0;
        }
        return dimensionPixelSize;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        final FloatingActionsMenu floatingActionsMenu = (FloatingActionsMenu) this.getChildAt(Integer.parseInt("1"));
        final SharedPreferences sharedPreferences = this.context.getSharedPreferences("B58", 0);
        final ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setVisibility(GONE);
        imageView.setBackgroundColor(sharedPreferences.getInt("FabBgColor", ColorStore.getFabBgColor()));
        imageView.setAlpha(0.9f);
        this.addView( imageView, Integer.parseInt("1"));
        final Configuration configuration = this.getResources().getConfiguration();
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.screenWidthInPixels = configuration.screenWidthDp * displayMetrics.density;
        this.screenHeightInPixels = this.screenWidthInPixels * displayMetrics.heightPixels / displayMetrics.widthPixels;
        this.screenHeightInPixels += this.screenHeightInPixels / 4.0;
        this.pointX = Integer.parseInt(sharedPreferences.getString("FabBgPosX", "500"));
        this.pointY = Integer.parseInt(sharedPreferences.getString("FabBgPosY", "500"));
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                floatingActionsMenu.collapse();
            }
        });
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("0"))).setColorNormal(sharedPreferences.getInt("architModFabNormalColor", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("1"))).setColorNormal(sharedPreferences.getInt("architModFabNormalColor", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("2"))).setColorNormal(sharedPreferences.getInt("architModFabNormalColor", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("0"))).setColorPressed(sharedPreferences.getInt("architModFabPressedColor", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("1"))).setColorPressed(sharedPreferences.getInt("architModFabPressedColor", ColorStore.getFabColorNormal()));
        ((FloatingActionButton) floatingActionsMenu.getChildAt(Integer.parseInt("2"))).setColorPressed(sharedPreferences.getInt("architModFabPressedColor", ColorStore.getFabColorNormal()));
        floatingActionsMenu.setOnFloatingActionsMenuUpdateListener( new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuCollapsed() {
                if (Build.VERSION.SDK_INT >= 21) {
                    final Animator setDuration = ViewAnimationUtils.createCircularReveal((View) imageView, ConversationView.access$000(ConversationView.this), ConversationView.access$100(ConversationView.this), (float) (int) ConversationView.access$200(ConversationView.this), 0.0f).setDuration(700L);
                    setDuration.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(final Animator animator) {
                            super.onAnimationEnd(animator);
                            imageView.setVisibility(GONE);
                        }
                    });
                    setDuration.start();
                } else {
                    final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", new float[] { 0.9f, 0.0f });
                    ofFloat.setDuration(300L);
                    ofFloat.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(final Animator animator) {
                            super.onAnimationEnd(animator);
                            imageView.setVisibility(GONE);
                        }
                    });
                    ofFloat.start();
                }
            }

            @Override
            public void onMenuExpanded() {
                if (Build.VERSION.SDK_INT >= 21) {
                    imageView.setVisibility(VISIBLE);
                    ViewAnimationUtils.createCircularReveal((View) imageView, ConversationView.access$000(ConversationView.this), ConversationView.access$100(ConversationView.this), 0.0f, (float) (int) ConversationView.access$200(ConversationView.this)).setDuration(700L).start();
                } else {
                    final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", new float[] { 0.0f, 0.9f });
                    ofFloat.setDuration(300L);
                    imageView.setVisibility(VISIBLE);
                    ofFloat.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(final Animator animator) {
                            super.onAnimationEnd(animator);
                        }
                    });
                    ofFloat.start();
                }
            }
        });
    }
}


