package com.B58works.settings.visualmods;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.Superpref;


public class Fabscreen extends Superpref{

    SwitchPreference p;
    Preference p1;
    Preference p2;
    Preference p3;
    Preference p4;

    public void init()
    {
        p = (SwitchPreference) findPreference("hidefab");
        p1 = findPreference("fabnormal");
        p2 = findPreference("fabpressed");
        p3 = findPreference("fabbg");
        p4 = findPreference("fabpos");
    }

    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.addPreferencesFromResource(IDGen.xml.vfab);
        init();
        p4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                dialogForFabAnimationPoints();
                return true;
            }
        });
    }

    protected void onStart()
    {
        super.onStart();
        b58();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        super.onSharedPreferenceChanged(sharedPreferences, s);
    }

    private void b58()
    {
        p.setTitle(IDGen.string.hidefab);
        p.setSummaryOff(IDGen.string.stockfabd);
        p.setSummaryOn(IDGen.string.stockfabe);
        p1.setTitle(IDGen.string.fabnormal);
        p1.setSummary(IDGen.string.fabnormalsum);
        p2.setTitle(IDGen.string.fabpressed);
        p2.setSummary(IDGen.string.fabpressedsum);
        p3.setTitle(IDGen.string.fabbg);
        p3.setSummary(IDGen.string.fabbgsum);
        p4.setTitle(IDGen.string.fabpos);
        p4.setSummary(IDGen.string.fabpossum);
    }

    private void dialogForFabAnimationPoints() {
        final SharedPreferences shp = getSharedPreferences("B58", Context.MODE_PRIVATE);
        Context context = Fabscreen.this;
        Configuration config = getResources().getConfiguration();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        double screenWidthInPixels = (double) config.screenWidthDp * dm.density;
        double screenHeightInPixels = screenWidthInPixels * dm.heightPixels / dm.widthPixels;
        float scale = getResources().getDisplayMetrics().density;
        final int dpAsPixelsTop = (int) (25 * scale + 0.5f);
        final int dpAsPixelsLeft = (int) (10 * scale + 0.5f);
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setPadding(dpAsPixelsLeft, dpAsPixelsTop, dpAsPixelsLeft, dpAsPixelsTop);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText titleBox = new EditText(context);
        titleBox.setHint("x point");
        titleBox.setText(shp.getString("PosX", screenWidthInPixels + ""));
        layout.addView(titleBox);

        final EditText descriptionBox = new EditText(context);
        descriptionBox.setHint("y point");
        descriptionBox.setText(shp.getString("PosY", screenHeightInPixels + ""));
        layout.addView(descriptionBox);
        dialog.setView(layout);
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if (!titleBox.getText().toString().matches("") && !descriptionBox.getText().toString().matches("")) {
                        Integer.parseInt(titleBox.getText().toString());
                        Integer.parseInt(descriptionBox.getText().toString());

                        shp.edit().putString("PosX", titleBox.getText().toString()).apply();
                        shp.edit().putString("PosY", descriptionBox.getText().toString()).apply();
                    }
                } catch (Exception e) {

                }
            }
        });
        dialog.show();
    }
}
