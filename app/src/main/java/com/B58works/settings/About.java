package com.B58works.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.whatsapp.sn1;

import static com.B58works.B58.getResID;

public class About extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(getResID("about", "xml"));
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    public static void setcolor(TextView t)
    {
        t.setTextColor(sn1.getColor("Textcolor", 0xff000000));
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }
}
