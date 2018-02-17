package com.B58works;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class CopyingTask extends AsyncTask<File, Integer, Integer>
{
    Context ctx;
    ProgressDialog dialog;
    boolean done;
    int i;
    boolean isBackup;
    int max;
    File sourceLocation;
    String str;
    File targetLocation;

    public CopyingTask(final Context ctx, final boolean isBackup, final File sourceLocation, final File targetLocation) {
        this.i = 0;
        this.done = false;
        this.isBackup = false;
        this.max = 0;
        this.ctx = ctx;
        this.isBackup = isBackup;
        if (isBackup) {
            this.str = "Backup";
        }
        else {
            this.str = "Restore";
        }
        (this.dialog = new ProgressDialog(ctx)).setProgressStyle(1);
        this.dialog.setCancelable(false);
        this.dialog.setIndeterminate(false);
        this.dialog.setTitle((CharSequence)this.getString("B58" + this.str + "Title"));
        this.dialog.setMessage((CharSequence)this.getString("B58" + this.str + "Msg"));
        this.sourceLocation = sourceLocation;
        this.targetLocation = targetLocation;
    }

    void CountFiles(final File file) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                this.CountFiles(listFiles[i]);
            }
        }
        ++this.max;
    }

    void DeleteDirectory(final File file) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                this.DeleteDirectory(listFiles[i]);
            }
        }
        file.delete();
    }

    public void copyDirectory(final File file, final File file2) throws IOException {
        file.getPath();
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            else {
                this.DeleteDirectory(file2);
                file2.mkdir();
            }
            final String[] list = file.list();
            for (int i = 0; i < list.length; ++i) {
                this.copyDirectory(new File(file, list[i]), new File(file2, list[i]));
            }
        }
        else {
            final FileInputStream fileInputStream = new FileInputStream(file);
            final FileOutputStream fileOutputStream = new FileOutputStream(file2);
            final byte[] array = new byte[1024];
            while (true) {
                final int read = fileInputStream.read(array);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(array, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.close();
            ++this.i;
            this.publishProgress((Integer[]) new Integer[] { this.i });
        }
    }

    protected Integer doInBackground(final File... array) {
        try {
            this.copyDirectory(this.sourceLocation, this.targetLocation);
            this.done = true;
            return null;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            this.done = false;
            return null;
        }
    }

    public int getResID(final String s, final String s2) {
        return this.ctx.getResources().getIdentifier(s, s2, this.ctx.getPackageName());
    }

    public String getString(final String s) {
        return this.ctx.getString(this.ctx.getResources().getIdentifier(s, "string", this.ctx.getPackageName()));
    }

    protected void onCancelled() {
        Toast.makeText(this.ctx, (CharSequence)this.getString("B58" + this.str + "Fail"), Toast.LENGTH_SHORT).show();
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    protected void onPostExecute(final Integer n) {
        this.dialog.dismiss();
        if (this.done) {
            Toast.makeText(this.ctx, (CharSequence)this.getString("B58" + this.str + "Done"), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this.ctx, (CharSequence)this.getString("B58" + this.str + "Fail"), Toast.LENGTH_SHORT).show();
        }
        if (!this.isBackup) {
            System.exit(0);
        }
    }

    protected void onPreExecute() {
        try {
            this.CountFiles(this.sourceLocation);
            this.dialog.setMax(this.max);
            this.dialog.show();
        }
        catch (Exception ex) {
            this.cancel(true);
        }
    }

    protected void onProgressUpdate(final Integer... array) {
        this.dialog.setProgress((int)array[0]);
    }
}
