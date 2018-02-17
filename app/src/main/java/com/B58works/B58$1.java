package com.B58works;

import com.whatsapp.*;
import android.widget.*;
import android.content.*;

static final class B58$1 implements DialogInterface$OnClickListener {
    public void onClick(final DialogInterface dialogInterface, final int n) {
        final String string = this.val$input.getText().toString() + "@s.whatsapp.net";
        if (B58.OpenChat(string) == null) {
            Toast.makeText((Context)this.val$a, (CharSequence)"This Number does not Exist On WhatsApp, Check Again!", 0).show();
        }
        else {
            this.val$a.startActivity(B58.OpenChat(string));
        }
    }
}