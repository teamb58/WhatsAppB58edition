package com.B58works.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.B58;


public class About extends Superpref{

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(IDGen.xml.about);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
    }

    public static void setcolor(TextView t)
    {
        t.setTextColor(B58.getColor("Textcolor", 0xff000000));
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
        onStart();
    }
}
