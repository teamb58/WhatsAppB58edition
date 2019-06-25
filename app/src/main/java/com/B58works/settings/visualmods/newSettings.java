package com.B58works.settings.visualmods;

import android.annotation.TargetApi;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.B58works.B58;
import com.B58works.IDGen;
import com.B58works.settings.About;
import com.whatsapp.Settings;
import com.whatsapp.sn1;


import static com.B58works.B58.ctx;
import static com.B58works.settings.About.setcolor;


public class newSettings extends Settings {

    ScrollView ll;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        //setContentView(B58.getResID("visual_settingsl", "layout"));
        setContentView(IDGen.layout.visual_settingsl);
        findViewById(IDGen.id.vfab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Fabscreen.class));
            }
        });
        findViewById(IDGen.id.vhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Homescreen.class));
            }
        });
        findViewById(IDGen.id.vchat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Chatscreen.class));
            }
        });
        findViewById(IDGen.id.vthemes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Themescreen.class));
            }
        });
        findViewById(IDGen.id.vuniversal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Universal.class));
            }
        });
        findViewById(IDGen.id.vconpick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,ContactPicker.class));
            }
        });
        findViewById(IDGen.id.aboutb58).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, About.class));
            }
        });
        ll =findViewById(IDGen.id.vsl);
        ll.setBackgroundColor(sn1.getColor("bgcolor",-1));
        super.setTitle("B58 Visual mods");
        setviews();
        TextView t=findViewById(IDGen.id.aboutus);
        t.setText(getApplicationContext().getString(com.B58works.IDGen.string.hitext,B58.MaMy_Name2()));
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void setviews()
    {
        String[] names = {"v1", "v2", "v3", "v4", "v5", "v6", "aboutus", "aboutus2"};
        for (String name : names) {
            setcolor((TextView) findViewById(getApplicationContext().getResources().getIdentifier(name,"id",getPackageName())));
        }


    }


}
