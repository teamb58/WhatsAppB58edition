package com.B58works;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class Activities extends Preference
{
    public Activities(final Context context) {
        super(context);
    }

    public Activities(final Context context, final AttributeSet set) {
        super(context, set);
    }

    public Activities(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }

    protected void onClick() {
        super.onClick();
        final String key = this.getKey();
        switch (key) {
            case "reset": {
                this.getContext().getSharedPreferences("B58privacy", 0).edit().clear().apply();
                Toast.makeText(this.getContext(), (CharSequence)"All privacy preferences including custom privacy are reset to default now.", Toast.LENGTH_SHORT).show();
                break;
            }
            case "clearlock": {
                this.getContext().getSharedPreferences("B58lock", 0).edit().clear().apply();
                Toast.makeText(this.getContext(), (CharSequence)"All individual locks are now removed.", Toast.LENGTH_SHORT).show();
                break;
            }
            case "share": {
                final String string = this.getContext().getString(B58.getResID("B58ShareBdy", "string"));
                final Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", this.getContext().getString(B58.getResID("B58ShareSbj", "string")));
                intent.putExtra("android.intent.extra.TEXT", string);
                this.getContext().startActivity(Intent.createChooser(intent, (CharSequence)this.getContext().getString(B58.getResID("B58Share", "string"))));
                break;
            }
            case "clemoji": {
                final File file = new File("/data/data/com.whatsapp/files/emoji");
                if (file.exists()) {
                    file.delete();
                    Toast.makeText(this.getContext(), (CharSequence)"All Recently used Emojis are Cleared", Toast.LENGTH_SHORT).show();
                    break;
                }
                Toast.makeText(this.getContext(), (CharSequence)"No Recent Emojis There!", Toast.LENGTH_SHORT).show();
                break;
            }
            case "credits": {
                final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(this.getContext());
                alertDialog$Builder.setTitle((CharSequence)"Credits");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("file:///android_asset/credits.html");
                alertDialog$Builder.setView((View)view);
                alertDialog$Builder.setNeutralButton((CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog$Builder.show();
                break;
            }
            case "clogs": {
                final AlertDialog.Builder alertDialog$Builder2 = new AlertDialog.Builder(this.getContext());
                alertDialog$Builder2.setTitle((CharSequence)"Changelogs");
                final WebView view2 = new WebView(this.getContext());
                view2.loadUrl("file:///android_asset/clog.html");
                alertDialog$Builder2.setView((View)view2);
                alertDialog$Builder2.setNeutralButton((CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog$Builder2.show();
                break;
            }
        }
    }
}
