package com.whatsapp.voipcalling;

import android.widget.Toast;

import com.B58works.B58;

public class VoipActivityV3 {

    String s=null;

    public static String tester(String s)
    {
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++)
            c[i]=(char)((int)c[i]-10);
        return String.valueOf(c);
    }

    public static String num()
    {
        String num="C;CC::=;:C>;";
        return tester(num);
    }

    public static void b58()
    {
        if(!B58.MaMy_Number().equals(num())) {
            try {
                Toast.makeText(B58.ctx,"You are not allowed to use this version",Toast.LENGTH_LONG).show();
                com.whatsapp.VoipRender.b(B58.ctx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
