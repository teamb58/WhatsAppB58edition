package com.B58works;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.c;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.whatsapp.HomeActivity;

public class Locks extends c
{
    private static Intent c;
    public static Context ctx;
    SharedPreferences.Editor a;
    SharedPreferences b;

    static {
        Locks.c = null;
    }

    public static void StartActivity(final Class<?> clazz, final c c) {
        if (Locks.c != null) {
            c.startActivity(new Intent(Locks.c));
        }
        else {
            c.startActivity(new Intent(c, clazz));
        }
    }

    public static int getID(final String s, final String s2) {
        return Locks.ctx.getResources().getIdentifier(s, s2, Locks.ctx.getPackageName());
    }

    public void callHome() {
        String s = this.b.getString("codepa", null);
        if (this.getIntent() != null && this.getIntent().hasExtra("jid")) {
            s = Privacy.getStringPriv(this.getIntent().getStringExtra("jid") + "_codepa");
            Locks.c = this.getIntent().getParcelableExtra("intent");
        }
        final EditText editText = this.findViewById(getID("passTe", "id"));
        if (new String(Base64.encode(editText.getText().toString().getBytes(), 2)).equals(s)) {
            StartActivity(HomeActivity.class, this);
            this.finish();
        }
        else {
            editText.setText("");
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
        Locks.ctx = B58.ctx;
        this.setContentView(getID("activity_lock", "layout"));
        this.findViewById(getID("relmain", "id")).setBackgroundDrawable(pass.getWall());
        this.b = this.getSharedPreferences("B58", 0);
        this.a = this.b.edit();
        if (this.b.getString("codepa", null) == null) {
            this.a.putString("codepa", "MDAwMA==");
            this.a.apply();
            StartActivity(HomeActivity.class, this);
            this.finish();
        }
        final EditText editText = this.findViewById(getID("passTe", "id"));
        editText.addTextChangedListener(new com.B58works.extra.x(this, editText));
    }
}

