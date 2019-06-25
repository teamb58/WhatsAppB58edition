package com.whatsapp.plus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.B58works.IDGen;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.B58works.BooleanMethods.getBoolean;

public class ReadLogFile extends Activity {

    StringBuilder a;
    ProgressDialog b;
    ListView c;
    ArrayList d;
    ArrayList e;
    ArrayAdapter f;
    df g = null;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    File m;


    public void onCreate(Bundle bundle)
    {
        String stringBuilder;
        super.onCreate(bundle);
        setContentView(IDGen.layout.readlog);
        if (getActionBar() != null) {
            getActionBar().setIcon(new ColorDrawable(getResources().getColor(IDGen.color.colorPrimary)));
        }
        c=findViewById(IDGen.id.loglist);
        d=new ArrayList();
        e=new ArrayList();
        h=getBoolean("log_hide_last_seen_check");
        i=getBoolean("log_hide_online_check");
        j=getBoolean("log_limit_check");
        k=getBoolean("log_show_all_check");
        l=getBoolean("log_show_name_check");
        m=new File(Environment.getDataDirectory(), "data/" + getPackageName() + "/files/" + "Logs/" + "whatsapp.log");
        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(this.m.lastModified()));
        long length = this.m.length();
        StringBuilder append = new StringBuilder(String.valueOf(this.m.getName())).append(" ");
        if (length < 1024) {
            stringBuilder = (length) + " B";
        } else {
            final int n = (int)(Math.log(length) / Math.log(1024.0));
            stringBuilder = String.format("%.1f %sb", length / Math.pow(1024.0, n), new StringBuilder(String.valueOf("KMGTPE".charAt(n - 1))).toString());
        }
        setTitle(append.append(stringBuilder).toString());
        if (this.m.exists()) {
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(IDGen.menu.readlog_menu, menu);
        MenuItem findItem = menu.findItem(IDGen.id.submenu_showname);
        MenuItem findItem2 = menu.findItem(IDGen.id.submenu_showall);
        MenuItem findItem3 = menu.findItem(IDGen.id.submenu_hideonline);
        MenuItem findItem4 = menu.findItem(IDGen.id.submenu_hidelastseen);
        MenuItem findItem5 = menu.findItem(IDGen.id.submenu_limit);
        if (findItem != null) {
            findItem.setChecked(this.l);
        }
        if (findItem2 != null) {
            findItem2.setChecked(this.k);
        }
        if (findItem3 != null) {
            findItem3.setChecked(this.i);
        }
        if (findItem4 != null) {
            findItem4.setChecked(this.h);
        }
        if (findItem5 != null) {
            findItem5.setChecked(this.j);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.d = new ArrayList();
        this.e = new ArrayList();
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }
        int i1 = menuItem.getItemId();
        if (i1 == IDGen.id.readlog_mn) {//fv.b(this);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        } else if (i1 == IDGen.id.submenu_showname) {
            this.l = menuItem.isChecked();
            Utils.setAppPrefBoolean(this, "log_show_name_check", this.l);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        } else if (i1 == IDGen.id.submenu_hidelastseen) {
            this.h = menuItem.isChecked();
            Utils.setAppPrefBoolean(this, "log_hide_last_seen_check", this.h);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        } else if (i1 == IDGen.id.submenu_hideonline) {
            this.i = menuItem.isChecked();
            Utils.setAppPrefBoolean(this, "log_hide_online_check", this.i);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        } else if (i1 == IDGen.id.submenu_limit) {
            this.j = menuItem.isChecked();
            Utils.setAppPrefBoolean(this, "log_limit_check", this.j);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        } else if (i1 == IDGen.id.submenu_showall) {
            this.k = menuItem.isChecked();
            Utils.setAppPrefBoolean(this, "log_show_all_check", this.k);
            this.g = new df(this, (byte) 0);
            this.g.execute(new File[]{this.m});
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
