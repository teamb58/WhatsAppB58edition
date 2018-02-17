package com.B58works.extra;

import android.widget.Toast;

import com.B58works.pattern;
import com.eftimoff.patternview.PatternView;
import com.whatsapp.HomeActivity;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class cb implements PatternView.OnPatternDetectedListener
{
    private final pattern a;

    public cb(final pattern a) {
        this.a = a;
    }

    @Override
    public void onPatternDetected() {
        if (pattern.b(this.a).equals(pattern.a(this.a).getPatternString())) {
            Toast.makeText(this.a.getApplicationContext(), (CharSequence)"Unlocked.", Toast.LENGTH_SHORT).show();
            pattern.StartActivity(HomeActivity.class, this.a);
            this.a.finish();
        }
        else {
            Toast.makeText(this.a.getApplicationContext(), (CharSequence)"Wrong. Try resetting if you've forgotten.", Toast.LENGTH_SHORT).show();
            pattern.a(this.a).clearPattern();
        }
    }
}