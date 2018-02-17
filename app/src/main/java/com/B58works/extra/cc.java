package com.B58works.extra;

import android.widget.Toast;

import com.B58works.patternC;
import com.eftimoff.patternview.PatternView;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class cc implements PatternView.OnPatternDetectedListener
{
    private final patternC a;

    public cc(final patternC a) {
        this.a = a;
    }

    @Override
    public void onPatternDetected() {
        patternC.a(this.a, patternC.a(this.a).getPatternString());
        patternC.b(this.a);
        Toast.makeText(patternC.ctx, (CharSequence)"New pattern Set!", Toast.LENGTH_SHORT).show();
        this.a.finish();
    }
}
