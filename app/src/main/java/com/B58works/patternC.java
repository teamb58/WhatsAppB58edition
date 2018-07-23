package com.B58works;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eftimoff.patternview.PatternView;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class patternC extends Activity
{
    public static Context ctx;
    SharedPreferences.Editor a;
    private PatternView b;
    private String c;

    public static PatternView a(final patternC p) {
        return p.b;
    }

    public static String a(final patternC p, final String c) {
        return p.c = c;
    }

    private void a() {
        String string = "pat";
        if (this.getIntent() != null) {
            if (this.getIntent().hasExtra("jid")) {
                final String stringExtra = this.getIntent().getStringExtra("jid");
                string = stringExtra + "_pat";
                this.a.putBoolean(stringExtra + "_locked", true);
            }
        }
        this.a.putString(string, this.c);
        this.a.apply();
    }

    public static void b(final patternC patternC) {
        patternC.a();
    }

    public static int getID(final String s, final String s2) {
        return patternC.ctx.getResources().getIdentifier(s, s2, patternC.ctx.getPackageName());
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        patternC.ctx = B58.ctx;
        this.a = this.getSharedPreferences("B58", 0).edit();
        this.setContentView(getID("activity_pattern", "layout"));
        (this.findViewById(getID("relmain", "id"))).setBackgroundDrawable(pass.getWall());
        this.b = this.findViewById(getID("patternView", "id"));
        Toast.makeText(this.getApplicationContext(), "Draw your new pattern", Toast.LENGTH_SHORT).show();
        this.b.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {
            @Override
            public void onPatternDetected() {
                c=b.getPatternString();
                a();
                Toast.makeText(patternC.ctx, "New pattern Set!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

