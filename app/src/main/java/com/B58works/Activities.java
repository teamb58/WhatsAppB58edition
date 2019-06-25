package com.B58works;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.preference.Preference;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.Toast;

public class Activities extends Preference {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Activities(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Activities(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Activities(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Activities(Context context) {
        super(context);
    }

    protected void onClick() {
        super.onClick();
        final String key = this.getKey();
        switch (key) {
            case "update": {
                new Update(getContext()).execute((String[]) new String[0]);
                //Toast.makeText(getContext(),"Keep checking official page from below mentioned link.",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),"This is the only OFFICIAL way to check for updates.",Toast.LENGTH_SHORT).show();
                break;
            }

            case "reset": {
                getContext().getSharedPreferences("B58privacy", 0).edit().clear().apply();
                Toast.makeText(this.getContext(), "All privacy preferences including custom privacy are reset to default now.", Toast.LENGTH_SHORT).show();
                break;
            }
            case "share": {
                final String string = this.getContext().getString(IDGen.string.B58ShareBdy);
                final Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", this.getContext().getString(IDGen.string.B58ShareSbj));
                intent.putExtra("android.intent.extra.TEXT", string);
                this.getContext().startActivity(Intent.createChooser(intent, this.getContext().getString(IDGen.string.B58Share)));
                break;
            }
            case "credits": {
                final AlertDialog.Builder ab = new AlertDialog.Builder(this.getContext());
                ab.setTitle("Credits");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("file:///android_asset/credits.html");
                ab.setView(view);
                ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                }).show();
                //Toast.makeText(getContext(),"Work in progress",Toast.LENGTH_SHORT).show();
                break;
            }
            case "clogs": {
                final AlertDialog.Builder ab = new AlertDialog.Builder(this.getContext());
                ab.setTitle("Changelogs");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("file:///android_asset/clog.html");
                ab.setView(view);
                ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                }).show();

                //Toast.makeText(getContext(),"Work in progress",Toast.LENGTH_SHORT).show();
                break;
            }
            case "devmsg": {
                final AlertDialog.Builder ab = new AlertDialog.Builder(this.getContext());
                ab.setTitle("Developer Message");
                final WebView view = new WebView(this.getContext());
                view.loadUrl("https://androtechupdates.com/wp-content/uploads/devmsg.html");
                ab.setView(view);
                ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                        dialogInterface.dismiss();
                    }
                }).show();
                //Toast.makeText(getContext(),"Work in progress",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
