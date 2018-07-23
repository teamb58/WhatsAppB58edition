package com.B58works.settings;

import android.os.Bundle;
import android.os.Environment;
import android.widget.LinearLayout;

import com.B58works.B58;
import com.whatsapp.auc;

import java.io.File;

import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getResID;
import static com.B58works.settings.getDrawable.getbg;

public class WishPage extends auc {

    LinearLayout r;
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(B58.getResID("wish", "layout"));
        r =findViewById(getResID("special","id"));
        final File file = new File(Environment.getExternalStorageDirectory()+"/"+"B58wishes"+"/special.jpg");
        if(!getBoolean("special"))
        {
            if(file.exists())
                r.setBackgroundDrawable(getbg());
            else
                r.setBackgroundResource(getResID("wall","drawable"));
        }
        else
            r.setBackgroundColor(-1);
        super.setTitle("Wishes from TeamB58.");
    }
}
