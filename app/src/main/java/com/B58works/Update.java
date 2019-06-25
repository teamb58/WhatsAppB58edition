package com.B58works;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Update extends AsyncTask<String, String, String>
{
    private int a;
    private int b;
    private String c;
    private Context ctx;
    private ProgressDialog progDlg;
    private int v1;
    private int v2;

    Update(final Context ctx) {
        this.a = 0;
        this.b = 0;
        c=null;
        this.ctx = ctx;
        this.v1=13;
        this.v2=1;
    }

    protected String doInBackground(final String... array) {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://https://tempohari.com/wp-content/uploads/update.txt").openStream()));
            String string = "";
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                string += line;
            }
            final JSONObject jsonObject = new JSONObject(string);
            this.a = jsonObject.getInt("ver1");
            this.b = jsonObject.getInt("ver2");
            c=jsonObject.getString("url");
            return "1";
        }
        catch (Exception ex) {
            return "?";
        }
    }

    protected void onPostExecute(final String s) {
        final String url=c;
        if (this.a > v1 || this.b > v2 ) {
            final WebView view = new WebView(this.ctx);
            view.loadUrl("https://tempohari.com/wp-content/uploads/clog.html");
            final AlertDialog.Builder alertDialog$Builder = new AlertDialog.Builder(this.ctx);
            alertDialog$Builder.setTitle(("New Update v" + this.a + "." + this.b + "Found"));
            alertDialog$Builder.setView(view);
            alertDialog$Builder.setPositiveButton("Download Now", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    Update.this.ctx.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
            });
            alertDialog$Builder.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    Toast.makeText(Update.this.ctx, "Always keep updated to get new features and bug free.", Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            });
            alertDialog$Builder.create();
            alertDialog$Builder.show();
        }
        else if (s.equals("?")) {
            final AlertDialog.Builder alertDialog$Builder2 = new AlertDialog.Builder(this.ctx);
            alertDialog$Builder2.setTitle("Error!").setMessage("Connection to internet denied. Please check.");
            alertDialog$Builder2.create();
            alertDialog$Builder2.show();
        }
        else {
            final AlertDialog.Builder alertDialog$Builder3 = new AlertDialog.Builder(this.ctx);
            alertDialog$Builder3.setTitle("Good!").setMessage(("You have latest update!:\n v" + v1 + "." + v2));
            alertDialog$Builder3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    dialogInterface.dismiss();
                }
            });
            alertDialog$Builder3.create();
            alertDialog$Builder3.show();
        }
        this.progDlg.dismiss();
    }

    protected void onPreExecute() {
        (this.progDlg = new ProgressDialog(this.ctx)).setMessage("Please wait while we check for updates...");
        this.progDlg.setCancelable(true);
        this.progDlg.show();
    }
}
