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
            case "update": {
                new Update(getContext()).execute((String[]) new String[0]);
                break;
            }

            case "reset": {
                this.getContext().getSharedPreferences("B58privacy", 0).edit().clear().apply();
                Toast.makeText(this.getContext(), "All privacy preferences including custom privacy are reset to default now.", Toast.LENGTH_SHORT).show();
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
            case "credits": {
                final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(this.getContext());
                alertDialog$Builder.setTitle((CharSequence)"Credits");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("file:///android_asset/credits.html");
                alertDialog$Builder.setView((View)view);
                alertDialog$Builder.setNeutralButton("OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog$Builder.show();
                break;
            }
            case "clogs": {
                final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(this.getContext());
                alertDialog$Builder.setTitle((CharSequence)"Changelogs");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("file:///android_asset/clog.html");
                alertDialog$Builder.setView((View)view);
                alertDialog$Builder.setNeutralButton((CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog$Builder.show();
                break;
            }
            case "devmsg": {
                final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(this.getContext());
                alertDialog$Builder.setTitle((CharSequence)"Developer Message");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("https://androtechupdates.com/wp-content/uploads/devmsg.html");
                alertDialog$Builder.setView((View)view);
                alertDialog$Builder.setNeutralButton((CharSequence)"OK", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog$Builder.show();
                break;
            }
        }
    }
}
