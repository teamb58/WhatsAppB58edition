package com.B58works.settings.textmods;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.B58works.B58;
import com.B58works.Privacy;
import com.B58works.R;
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
        setContentView(com.B58works.R.layout.text_settingsl);
        findViewById(com.B58works.R.id.tprivacy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Privacy.class));
            }
        });
        findViewById(com.B58works.R.id.thome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Homescreen.class));
            }
        });
        findViewById(com.B58works.R.id.tchat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Chatscreen.class));
            }
        });
        findViewById(com.B58works.R.id.tmedia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Mediamods.class));
            }
        });
        findViewById(com.B58works.R.id.tlog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Logscreen.class));
            }
        });
        /*findViewById(com.B58works.R.id.tpass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(ctx,com.B58works.pass.class));
                Toast.makeText(ctx,"Work in progress",Toast.LENGTH_SHORT).show();
            }
        });*/
        findViewById(com.B58works.R.id.tchooser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx,Choosers.class));
            }
        });
        findViewById(com.B58works.R.id.aboutb58).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, About.class));
            }
        });
        ll =findViewById(com.B58works.R.id.vsl);

        /*final File file = new File(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        if(getBoolean("special"))
        {
            if(file.exists())
                ll.setBackgroundDrawable(getbg());
            else
                ll.setBackgroundResource(getResID("wall","drawable"));
        }
        else
            ll.setBackgroundColor(-1);*/
        ll.setBackgroundColor(sn1.getColor("bgcolor",-1));
        super.setTitle("B58 Text mods");
        setviews();
        TextView t=findViewById(com.B58works.R.id.aboutus);

        t.setText(ctx.getString(com.B58works.R.string.hitext,B58.MaMy_Name2()));
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

        String[] names = {"t1", "t2", "t3", "t4", "t5", "t6", "t7", "aboutus", "aboutus2"};
        for (String name : names) {
            setcolor((TextView) findViewById(getApplicationContext().getResources().getIdentifier(name,"id",getPackageName())));
        }
    }

}
