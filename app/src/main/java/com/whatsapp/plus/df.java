package com.whatsapp.plus;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.B58works.IDGen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class df extends AsyncTask {

    final ReadLogFile a;
    private String b;

    private df(ReadLogFile readLogFile) {
        this.a = readLogFile;
    }

    df(ReadLogFile readLogFile, byte b) {
        this(readLogFile);
    }

    private String a(String str) {
        try {
            String[] split;
            String str2;
            String replace = str.replace(str.substring(str.indexOf("[") - 12, str.indexOf("]") + 1), "");
            String[] split2 = replace.split(" ");
            if (split2[0].equals(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()))) {
                replace = replace.substring(11);
                split = replace.split(" ");
                str2 = replace;
            } else {
                split = split2;
                str2 = replace;
            }
            if (split[2].contains("handle_available") || split[2].contains("handle_unavailable") || split[2].contains("/available") || split[2].contains("/unavailable")) {
                return null;
            }
            String str3;
            if (split[1].contains("handle_available")) {
                split[2] = this.c(split[2].replace("@s.whatsapp.net", "")) + " " + this.a.getString(IDGen.string.conversation_contact_online);
                str2 = split[0] + " " + split[2];
            }
            if (split[1].contains("/available")) {
                if (this.a.i) {
                    return null;
                }
                if (split[2].contains("@g.us")) {
                    return null;
                }
                split[2] = this.c(split[2].replace("@s.whatsapp.net", "")) + " " + this.a.getString(IDGen.string.conversation_contact_online);
                str2 = split[0] + " " + split[2];
            }
            if (split[1].contains("/unavailable")) {
                if (this.a.h) {
                    return null;
                }
                if (!split[4].equals("0")) {
                    str2 = this.a(split[4], split[0]);
                    if (str2 == null) {
                        return null;
                    }
                    split[4] = (this.a.getString(IDGen.string.conversation_last_seen)) + " " + str2;
                } else if (this.a.h) {
                    return null;
                } else {
                    split[4] = (this.a.getString(IDGen.string.conversation_last_seen)) + " " + this.a.getString(IDGen.string.offline_str);
                }
                split[2] = this.c(split[2].replace("@s.whatsapp.net", ""));
                str2 = split[0] + " " + split[2] + " " + split[4];
            }
            if (split[1].contains("handle_unavailable")) {
                if (this.a.h) {
                    return null;
                }
                if (split[4].equals("last:0")) {
                    return null;
                }
                split[4] = split[4].replace("last:", "");
                str2 = this.a(split[4], split[0]);
                if (str2 == null) {
                    return null;
                }
                split[4] = (this.a.getString(IDGen.string.conversation_last_seen)) + " " + str2;
                split[2] = this.c(split[2].replace("@s.whatsapp.net", ""));
                str2 = split[0] + " " + split[2] + " " + split[4];
            }
            if (this.b.contains("db_write") && split[3].contains("status")) {
                split[4] = this.c(split[4].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[5] = this.b(split[5].replace("status_timestamp=", ""));
                if (split[5] == null) {
                    return null;
                }
                split[6] = str2.substring(str2.indexOf(" status=") + 8, str2.indexOf("|"));
                str2 = split[0] + " " + split[4] + "\n" + this.a.getString(IDGen.string.contact_status) + ": " + split[6] + " " + split[5];
            }
            if (this.b.contains("db_write") && split[4].contains("status")) {
                split[5] = this.c(split[5].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[6] = this.b(split[6].replace("status_timestamp=", ""));
                if (split[6] == null) {
                    return null;
                }
                split[7] = str2.substring(str2.indexOf(" status=") + 8, str2.indexOf("|"));
                str2 = split[0] + " " + split[1] + " " + split[5] + "\n" + this.a.getString(IDGen.string.contact_status) + ": " + split[7] + " " + split[6];
            }
            if (this.b.contains("db_write") && split[2].contains("photo")) {
                if (split[9].equals("thumb_ts=0") || split[9].equals("thumb_ts=-1")) {
                    return null;
                }
                split[6] = this.c(split[6].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[9] = this.b(new StringBuilder(String.valueOf(split[9].replace("thumb_ts=", ""))).append("000").toString());
                if (split[9] == null) {
                    return null;
                }
                str3 = split[0] + " " + split[6] + "\n" + this.a.getString(IDGen.string.profile_photo_updated) + " " + split[9];
                if (this.a.d.size() > 0 && str3.substring(10).equals(((String) this.a.d.get(this.a.d.size() - 1)).substring(10, ((String) this.a.d.get(this.a.d.size() - 1)).length()))) {
                    return null;
                }
                str2 = str3;
            }
            if (this.b.contains("db_write") && split[3].contains("photo")) {
                if (split[10].equals("thumb_ts=0") || split[10].equals("thumb_ts=-1")) {
                    return null;
                }
                split[7] = this.c(split[7].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[10] = this.b(new StringBuilder(String.valueOf(split[10].replace("thumb_ts=", ""))).append("000").toString());
                if (split[10] == null) {
                    return null;
                }
                str3 = split[0] + " " + split[1] + " " + split[7] + "\n" + this.a.getString(IDGen.string.profile_photo_updated) + " " + split[10];
                if (this.a.d.size() > 0 && str3.substring(10).equals(((String) this.a.d.get(this.a.d.size() - 1)).substring(10))) {
                    return null;
                }
                str2 = str3;
            }
            if (this.b.contains("db_write") && split[3].contains("name")) {
                split[6] = this.c(split[6].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[7] = str2.substring(str2.indexOf("wa_name=") + 8, str2.indexOf("|"));
                str2 = split[0] + " " + split[6] + "\n" + this.a.getString(IDGen.string.profile_name) + " " + split[7];
            }
            if (this.b.contains("db_write") && split[4].contains("name")) {
                split[7] = this.c(split[7].replace("@s.whatsapp.net", "").replace("jid=", ""));
                split[8] = str2.substring(str2.indexOf("wa_name=") + 8, str2.indexOf("|"));
                str2 = split[0] + " " + split[1] + " " + split[7] + "\n" + this.a.getString(IDGen.string.profile_name) + " " + split[8];
            }
            return (this.a.d.size() <= 0 || !str2.equals(this.a.d.get(this.a.d.size() - 1))) ? str2 : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            instance.setTimeInMillis(Long.parseLong(str));
            String[] split = simpleDateFormat.format(instance.getTime()).split(" ");
            if (!split[1].equals(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()))) {
                return null;
            }
            if (str2.equals(split[0])) {
                return split[0];
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
            instance.add(13, -1);
            if (str2.equals(simpleDateFormat2.format(instance.getTime()))) {
                return split[0];
            }
            instance.add(13, -1);
            return str2.equals(simpleDateFormat2.format(instance.getTime())) ? split[0] : null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private StringBuilder a(File... fileArr) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileArr[0]));
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!(!readLine.contains("@") || readLine.contains("getMediaMessages") || readLine.contains("contact fetched") || readLine.contains("/subscription") || readLine.contains("/blocklist") || readLine.length() < 19)) {
                    try {
                        Date parse = simpleDateFormat.parse(readLine.substring(0, 19));
                        if (this.a.j && date.getTime() - 7200000 > parse.getTime()) {
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (readLine.contains("@") && !readLine.contains("found 0")) {
                        if (this.a.k || ((readLine.contains("db_write") && !readLine.contains("unseen")) || ((readLine.contains("/available") && !this.a.i) || (readLine.contains("unavailable") && !this.a.h)))) {
                            this.b = readLine;
                            String a = a(readLine);
                            publishProgress(new String[]{a});
                            if (a != null) {
                                this.a.d.add(a);
                                this.a.e.add(this.b);
                            }
                        }
                    }
                }
            }
            bufferedReader.close();
        } catch (OutOfMemoryError e2) {
            this.a.finish();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return this.a.a;
    }

    private static String b(String str) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            instance.setTimeInMillis(Long.parseLong(str));
            String format = simpleDateFormat.format(instance.getTime());
            String[] split = format.split(" ");
            return split[1].equals(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime())) ? split[0] : format;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String c(String str) {
        if (!this.a.l) {
            return str;
        }
        String string;
        String str2;
        Cursor query = this.a.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name", "_id"}, null, null, null);
        if (query != null) {
            string = query.moveToFirst() ? query.getString(query.getColumnIndex("display_name")) : null;
            query.close();
            if (string != null) {
                return string.length() < 24 ? string : string.substring(0, 24) + ".";
            } else {
                str2 = string;
            }
        } else {
            str2 = null;
        }
        Cursor query2 = this.a.getContentResolver().query(Uri.withAppendedPath(Contacts.Phones.CONTENT_FILTER_URL, Uri.encode(str)), new String[]{"display_name", "number"}, null, null, null);
        string = query2.moveToFirst() ? query2.getString(query2.getColumnIndex("display_name")) : str2;
        return string != null ? string : str;
    }

    public final /* synthetic */ Object doInBackground(Object... objArr) {
        return a((File[]) objArr);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCancelled() {
        super.onCancelled();
        this.a.b.setProgress(0);
        this.a.f.notifyDataSetChanged();
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        try {
            if (this.a.b != null && this.a.b.isShowing()) {
                this.a.b.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.reverse(this.a.d);
        Collections.reverse(this.a.e);
        this.a.f = new ArrayAdapter(this.a, IDGen.layout.readlogrow, this.a.d);
        this.a.c.setAdapter(this.a.f);
        this.a.c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] split = ((String) a.e.get(position)).split("@")[0].split(" ");
                String replace = split[split.length - 1].replace("jid=", "");
                Utils.openChat(a,replace.contains("-") ? (replace) + "@g.us" : (replace) + "@s.whatsapp.net");

            }
        });
        this.a.c.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(a, (CharSequence) a.e.get(position), Toast.LENGTH_LONG).show();
                return true;

            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPreExecute() {
        super.onPreExecute();
        this.a.b = new ProgressDialog(this.a);
        this.a.b.setMessage("Loading");
        this.a.b.setIndeterminate(false);
        this.a.b.setCancelable(true);
        if (!this.a.isFinishing()) {
            this.a.b.show();
        }
    }

    /* Access modifiers changed, original: protected|final|varargs|synthetic */
    public final /* synthetic */ void onProgressUpdate(Object... objArr) {
        this.a.b.setMessage(((String[]) objArr)[0]);
    }


}
