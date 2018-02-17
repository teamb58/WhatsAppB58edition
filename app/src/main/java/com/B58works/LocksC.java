package com.B58works;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.c;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LocksC extends c
{
    public static Context ctx;
    SharedPreferences.Editor a;

    private void a(final String s) {
        String string = "codepa";
        if (this.getIntent() != null) {
            string = string;
            if (this.getIntent().hasExtra("jid")) {
                final String stringExtra = this.getIntent().getStringExtra("jid");
                string = stringExtra + "_codepa";
                this.a.putBoolean(stringExtra + "_locked", true);
            }
        }
        this.a.putString(string, s);
        this.a.apply();
    }

    public static int getID(final String s, final String s2) {
        return LocksC.ctx.getResources().getIdentifier(s, s2, LocksC.ctx.getPackageName());
    }

    public void callHome() {
        final EditText editText = this.findViewById(getID("passTe", "id"));
        final String string = editText.getText().toString();
        if (editText.getText().toString().trim().length() > 0) {
            this.a(new String(Base64.encode(string.getBytes(), 2)));
            this.finish();
        }
        else {
            Toast.makeText((Context)this, (CharSequence)"Please enter a valid password!", Toast.LENGTH_SHORT).show();
            editText.setText((CharSequence)"");
        }
    }

    public void fillPass(final View view) {
        final EditText editText = this.findViewById(getID("passTe", "id"));
        if (view.getId() == getID("button0", "id")) {
            editText.setText((CharSequence)(editText.getText() + "0"));
        }
        else if (view.getId() == getID("button1", "id")) {
            editText.setText((CharSequence)(editText.getText() + "1"));
        }
        else if (view.getId() == getID("button2", "id")) {
            editText.setText((CharSequence)(editText.getText() + "2"));
        }
        else if (view.getId() == getID("button3", "id")) {
            editText.setText((CharSequence)(editText.getText() + "3"));
        }
        else if (view.getId() == getID("button4", "id")) {
            editText.setText((CharSequence)(editText.getText() + "4"));
        }
        else if (view.getId() == getID("button5", "id")) {
            editText.setText((CharSequence)(editText.getText() + "5"));
        }
        else if (view.getId() == getID("button6", "id")) {
            editText.setText((CharSequence)(editText.getText() + "6"));
        }
        else if (view.getId() == getID("button7", "id")) {
            editText.setText((CharSequence)(editText.getText() + "7"));
        }
        else if (view.getId() == getID("button8", "id")) {
            editText.setText((CharSequence)(editText.getText() + "8"));
        }
        else if (view.getId() == getID("button9", "id")) {
            editText.setText((CharSequence)(editText.getText() + "9"));
        }
        else if (view.getId() == getID("btr", "id")) {
            final int length = editText.getText().length();
            if (length > 0) {
                editText.getText().delete(length - 1, length);
            }
        }
    }

    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        LocksC.ctx = B58.ctx;
        this.a = this.getSharedPreferences("B58", 0).edit();
        this.setContentView(getID("activity_lock", "layout"));
        final RelativeLayout relativeLayout = this.findViewById(getID("relmain", "id"));
        final EditText editText = this.findViewById(getID("passTe", "id"));
        editText.addTextChangedListener((TextWatcher)new com.B58works.extra.y(this, editText));
    }
}

