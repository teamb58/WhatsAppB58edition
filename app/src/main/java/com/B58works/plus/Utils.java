package com.B58works.plus;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.widget.Toast;

/**
 * Created by Bharath.R(58) on 17-02-2018.
 */

public class Utils extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceChangeListener
{
    public static void checkContactOnline(final Context context, String substring, final String s) {
        try {
            if (!substring.contains(s) && substring != null) {
                substring = substring.substring(0, substring.lastIndexOf("@"));
                final onlinePopupAsync onlinePopupAsync = new onlinePopupAsync(context);
                onlinePopupAsync.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (String[]) new String[] { substring });
            }
        }
        catch (NullPointerException ex) {}
        catch (IllegalArgumentException ex2) {}
        catch (Exception ex3) {}
    }

    public static void displayToast(final Context context, final String s, final int n, final int n2) {
        final Toast text = Toast.makeText(context, (CharSequence)s, n);
        text.setGravity(n2, 0, 0);
        text.show();
    }

    private static String getContactName(final Context context, final String s) {
        final String s2 = null;
        final String s3 = null;
        final Cursor query = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(s)), new String[] { "display_name", "_id" }, (String)null, (String[])null, (String)null);
        String string = s2;
        if (query != null) {
            string = s3;
            if (query.moveToFirst()) {
                string = query.getString(query.getColumnIndex("display_name"));
            }
            query.close();
        }
        return string;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }

    private static class onlinePopupAsync extends AsyncTask<String, Void, String>
    {
        private Context mContext;

        public onlinePopupAsync(final Context mContext) {
            this.mContext = mContext;
        }

        protected String doInBackground(String... access$10) {
            while (true) {
                access$10 = (String[])(Object)access$10[0];
                try {
                    final Cursor query = this.mContext.getContentResolver().query(Uri.withAppendedPath(Contacts.Phones.CONTENT_FILTER_URL, Uri.encode((String)(Object)access$10)), new String[] { "display_name", "number" }, (String)null, (String[])null, (String)null);
                    Label_0076: {
                        if (!query.moveToFirst()) {
                            break Label_0076;
                        }
                        final Object string = query.getString(query.getColumnIndex("display_name"));
                        if (string == null) {
                            break Label_0076;
                        }
                        access$10 = (String[])string;
                        return (String)(Object)access$10;
                    }
                    if (getContactName(this.mContext, (String)(Object)access$10) != null) {
                        access$10 = (String[])(Object)getContactName(this.mContext, (String)(Object)access$10);
                        return (String)(Object)access$10;
                    }
                    return (String)(Object)access$10;
                }
                catch (NullPointerException ex) {
                    if (access$10 == null) {
                        access$10 = (String[])(Object)"";
                        return (String)(Object)access$10;
                    }
                    return (String)(Object)access$10;
                }
            }
        }

        protected void onPostExecute(final String s) {
            super.onPostExecute(s);
            Utils.displayToast(this.mContext, String.valueOf(s) + " " + "Is Now Online.", 0, 48);
        }
    }
}
