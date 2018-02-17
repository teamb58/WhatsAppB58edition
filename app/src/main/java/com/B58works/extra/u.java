package com.B58works.extra;

import android.widget.*;
import android.view.*;
import com.B58works.*;

public class u implements View$OnClickListener
{
    private final TextView a;
    
    public u(final TextView a) {
        this.a = a;
    }
    
    public void onClick(final View view) {
        B58.status(this.a, view);
    }
}
