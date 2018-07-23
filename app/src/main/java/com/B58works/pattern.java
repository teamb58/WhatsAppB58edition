package com.B58works;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eftimoff.patternview.PatternView;
import com.whatsapp.HomeActivity;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class pattern extends Activity
{
    private static Intent c;
    public static Context ctx;
    private PatternView a;
    private String b;

    static {
        pattern.c = null;
    }

    public static void StartActivity(final Class<?> clazz, final Activity activity) {
        if (pattern.c != null) {
            activity.startActivity(new Intent(pattern.c));
        }
        else {
            activity.startActivity(new Intent(activity, clazz));
        }
    }

    public static PatternView a(final pattern pattern) {
        return pattern.a;
    }

    public static String b(final pattern pattern) {
        return pattern.b;
    }

    public static int getID(final String s, final String s2) {
        return pattern.ctx.getResources().getIdentifier(s, s2, pattern.ctx.getPackageName());
    }

    protected void onCreate(final Bundle bundle) {
        this.requestWindowFeature(1);
        super.onCreate(bundle);
        pattern.ctx = B58.ctx;
        this.setContentView(getID("activity_pattern", "layout"));
        ((RelativeLayout)this.findViewById(getID("relmain", "id"))).setBackgroundDrawable(pass.getWall());
        this.b = this.getSharedPreferences("B58", 0).getString("pat", (String)null);
        if (this.getIntent() != null && this.getIntent().hasExtra("jid")) {
            this.b = Privacy.getStringPriv(this.getIntent().getStringExtra("jid") + "_pat");
            pattern.c = this.getIntent().getParcelableExtra("intent");
        }
        if (this.b == null) {
            Toast.makeText(this.getApplicationContext(), "Set a pattern first!", Toast.LENGTH_SHORT).show();
            StartActivity(HomeActivity.class, this);
            this.finish();
        }
        this.a = this.findViewById(getID("patternView", "id"));
        Toast.makeText(this.getApplicationContext(), "ENTER PATTERN", Toast.LENGTH_SHORT).show();
        this.a.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {
            @Override
            public void onPatternDetected() {
                if (b.equals(a.getPatternString())) {
                    Toast.makeText(getApplicationContext(), "Unlocked.", Toast.LENGTH_SHORT).show();
                    pattern.StartActivity(HomeActivity.class,pattern.super.getParent());
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong. Try resetting if you've forgotten.", Toast.LENGTH_SHORT).show();
                   a.clearPattern();
                }
            }
        });
    }
}