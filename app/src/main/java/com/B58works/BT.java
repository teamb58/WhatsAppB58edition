package com.B58works;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import static com.B58works.B58.getColor;
import static com.B58works.B58.getIntofList;

public class BT {
	
	public static String style_str;

    public static void chatscrcontname(final View view, final int n, final int size) {
        String name="chatcontname";
        textcolorwsize(n, name, view, size);
        TextView t=(view.findViewById(n));
        hidename(t);
    }

    public static void hidename(TextView t)
    {
        if(BooleanMethods.hidename())
        {
            //t.setText("Contact name Hidden.");
            //t.setTypeface(null, Typeface.ITALIC);
            t.setVisibility(View.GONE);
        }
    }

    public static void chatscrdate(final View view, final int n, final int size) {
        String name="chatdate";
        textcolorwsize(n, name, view, size);
    }

    public static void chatscrmsgfrom(final View view, final int n, final int size) {
        String name="chatfrom";
        textcolorwsize(n, name, view, size);
    }

    public static void chatscrmsg(final View view, final int n, final int size) {
        String name="chatmsg";
        textcolorwsize(n, name, view, size);
        if(BooleanMethods.hidemsg())
        {
            final FrameLayout f = view.findViewById(R.id.hidemsg);
            if (f != null) {
                f.setVisibility(View.GONE);
            }
        }
    }

    public static void chatscrmsgcount(final View view, final int n) {
        String s="unreadcount";
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, Color.parseColor("#ffffff")));
    }

    public static void statscrname(final View view, final int n, final int size) {
        String name="statcontname";
        textcolorwsize(n, name, view, size);
    }

    public static void statscrdate(final View view, final int n, final int size) {
        String name="stattime";
        textcolorwsize(n, name, view, size);
    }

    public static void callscrname(final View view, final int n, final int size) {
        String name="callcontname";
        textcolorwsize(n, name, view, size);
    }

    public static void callscrcount(final View view, final int n) {
        String name="callcount";
        ((TextView)view.findViewById(n)).setTextColor(getColor(name, Color.parseColor("#de000000")));
    }

    public static void callscrdate(final View view, final int n, final int size) {
        String name="calldate";
        textcolorwsize(n, name, view, size);
    }

    public static void convscrname(final View view, final int n) {
        String name="contname";
        ((TextView)view.findViewById(n)).setTextColor(getColor(name, -1));
    }

    public static void convscrlastseen(final View view, final int n) {
        String name="contls";
        ((TextView)view.findViewById(n)).setTextColor(getColor(name, -1));
    }

    public static void conpickscrcontname(final View view, final int n, final int size) {
        String s="conpickname";
        textcolorwsize(n, s, view, size);
    }

    public static void conpickscrstatus(final View view, final int n, final int size) {
        String s="conpickstatus";
        textcolorwsize(n, s, view, size);
    }

    public static void conpicktype(final View view, final int n) {
        String s="conpicktype";
        textcolorwosize(n, s, view);
    }

    private static void textcolorwsize(final int n, final String s, final View view, final int size) {
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, Color.parseColor("#de000000")));
        ((TextView)view.findViewById(n)).setTextSize((float)(B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getInt("main_text", 15) - size));
    }

    private static void textcolorwosize(final int n, final String s, final View view) {
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, Color.parseColor("#de000000")));
    }
	
	
	
	public static int BubbleStyle(int n) {

        final int int1 = getIntofList("bubble_style");
        int n2 = R.drawable.balloon_incoming_normal;
        int n3 = R.drawable.balloon_incoming_normal_ext;
        int n4 = R.drawable.balloon_outgoing_normal;
        int n5 = R.drawable.balloon_outgoing_normal_ext;
        switch (int1) {
            case 0: {
                n2 = R.drawable.balloon_incoming_normal;
                n3 = R.drawable.balloon_incoming_normal_ext;
                n4 = R.drawable.balloon_outgoing_normal;
                n5 = R.drawable.balloon_outgoing_normal_ext;
                break;
            }
            case 1: {
                n2 = R.drawable.rounded_balloon_incoming_normal;
                n3 = R.drawable.rounded_balloon_incoming_normal_ext;
                n4 = R.drawable.rounded_balloon_outgoing_normal;
                n5 = R.drawable.rounded_balloon_outgoing_normal_ext;
                break;
            }
            case 2: {
                n2 = R.drawable.materialized_balloon_incoming_normal;
                n3 = R.drawable.materialized_balloon_incoming_normal_ext;
                n4 = R.drawable.materialized_balloon_outgoing_normal;
                n5 = R.drawable.materialized_balloon_outgoing_normal_ext;
                break;
            }
            case 3: {
                n2 = R.drawable.hangouts_balloon_incoming_normal;
                n3 = R.drawable.hangouts_balloon_incoming_normal_ext;
                n4 = R.drawable.hangouts_balloon_outgoing_normal;
                n5 = R.drawable.hangouts_balloon_outgoing_normal_ext;
                break;
            }
            case 4: {
                n2 = R.drawable.wapaper_balloon_incoming_normal;
                n3 = R.drawable.wapaper_balloon_incoming_normal_ext;
                n4 = R.drawable.wapaper_balloon_outgoing_normal;
                n5 = R.drawable.wapaper_balloon_outgoing_normal_ext;
                break;
            }
            case 5: {
                n2 = R.drawable.walb_balloon_incoming_normal;
                n3 = R.drawable.walb_balloon_incoming_normal_ext;
                n4 = R.drawable.walb_balloon_outgoing_normal;
                n5 = R.drawable.walb_balloon_outgoing_normal_ext;
                break;
            }
            case 6: {
                n2 = R.drawable.gosms_balloon_incoming_normal;
                n3 = R.drawable.gosms_balloon_incoming_normal_ext;
                n4 = R.drawable.gosms_balloon_outgoing_normal;
                n5 = R.drawable.gosms_balloon_outgoing_normal_ext;
                break;
            }
            case 7: {
                n2 = R.drawable.bdrop_balloon_incoming_normal;
                n3 = R.drawable.bdrop_balloon_incoming_normal_ext;
                n4 = R.drawable.bdrop_balloon_outgoing_normal;
                n5 = R.drawable.bdrop_balloon_outgoing_normal_ext;
                break;
            }
            case 8: {
                n2 = R.drawable.altcr_balloon_incoming_normal;
                n3 = R.drawable.altcr_balloon_incoming_normal_ext;
                n4 = R.drawable.altcr_balloon_outgoing_normal;
                n5 = R.drawable.altcr_balloon_outgoing_normal_ext;
                break;
            }
            case 9: {
                n2 = R.drawable.trans_balloon_incoming_normal;
                n3 = R.drawable.trans_balloon_incoming_normal_ext;
                n4 = R.drawable.trans_balloon_outgoing_normal;
                n5 = R.drawable.trans_balloon_outgoing_normal_ext;
                break;
            }
            case 10: {
                n2 = R.drawable.apple_balloon_incoming_normal;
                n3 = R.drawable.apple_balloon_incoming_normal_ext;
                n4 = R.drawable.apple_balloon_outgoing_normal;
                n5 = R.drawable.apple_balloon_outgoing_normal_ext;
                break;
            }
            case 11: {
                n2 = R.drawable.textra_balloon_incoming_normal;
                n3 = R.drawable.textra_balloon_incoming_normal_ext;
                n4 = R.drawable.textra_balloon_outgoing_normal;
                n5 = R.drawable.textra_balloon_outgoing_normal_ext;
                break;
            }
            case 12: {
                n2 = R.drawable.hike_balloon_incoming_normal;
                n3 = R.drawable.hike_balloon_incoming_normal_ext;
                n4 = R.drawable.hike_balloon_outgoing_normal;
                n5 = R.drawable.hike_balloon_outgoing_normal_ext;
                break;
            }
            case 13: {
                n2 = R.drawable.dual_balloon_incoming_normal;
                n3 = R.drawable.dual_balloon_incoming_normal_ext;
                n4 = R.drawable.dual_balloon_outgoing_normal;
                n5 = R.drawable.dual_balloon_outgoing_normal_ext;
                break;
            }
            case 14: {
                n2 = R.drawable.in_balloon_incoming_normal;
                n3 = R.drawable.in_balloon_incoming_normal_ext;
                n4 = R.drawable.in_balloon_outgoing_normal;
                n5 = R.drawable.in_balloon_outgoing_normal_ext;
                break;
            }
            case 15: {
                n2 = R.drawable.bryed_balloon_incoming_normal;
                n3 = R.drawable.bryed_balloon_incoming_normal_ext;
                n4 = R.drawable.bryed_balloon_outgoing_normal;
                n5 = R.drawable.bryed_balloon_outgoing_normal_ext;
                break;
            }
            case 16: {
                n2 = R.drawable.fold_balloon_incoming_normal;
                n3 = R.drawable.fold_balloon_incoming_normal_ext;
                n4 = R.drawable.fold_balloon_outgoing_normal;
                n5 = R.drawable.fold_balloon_outgoing_normal_ext;
                break;
            }
            case 17: {
                n2 = R.drawable.foldv2_balloon_incoming_normal;
                n3 = R.drawable.foldv2_balloon_incoming_normal_ext;
                n4 = R.drawable.foldv2_balloon_outgoing_normal;
                n5 = R.drawable.foldv2_balloon_outgoing_normal_ext;
                break;
            }
            case 18: {
                n2 = R.drawable.md_balloon_incoming_normal;
                n3 = R.drawable.md_balloon_incoming_normal_ext;
                n4 = R.drawable.md_balloon_outgoing_normal;
                n5 = R.drawable.md_balloon_outgoing_normal_ext;
                break;
            }
            case 19: {
                n2 = R.drawable.round_balloon_incoming_normal;
                n3 = R.drawable.round_balloon_incoming_normal_ext;
                n4 = R.drawable.round_balloon_outgoing_normal;
                n5 = R.drawable.round_balloon_outgoing_normal_ext;
                break;
            }
        }
        switch (n) {
            case 3: {
                n = n3;
                break;
            }
            case 2: {
                n = n5;
                break;
            }
            case 1: {
                n2 = n4;
            }
            case 0: {
                n = n2;
                break;
            }
        }
        return n;
    }

    public static int TickStyle(final int n) {
        int n2 = R.drawable.message_unsent;
        int n3 = R.drawable.message_unsent_onmedia;
        int n4 = R.drawable.message_got_receipt_from_server;
        int n5 = R.drawable.message_got_receipt_from_server_onmedia;
        int n6 = R.drawable.message_got_receipt_from_target;
        int n7 = R.drawable.message_got_receipt_from_target_onmedia;
        int n8 = R.drawable.message_got_read_receipt_from_target;
        int n9 = R.drawable.message_got_read_receipt_from_target_onmedia;
        switch (getIntofList("tick_style")) {
            case 0: {
                style_str = "stock";
                n2 = R.drawable.message_unsent;
                n3 = R.drawable.message_unsent_onmedia;
                n4 = R.drawable.message_got_receipt_from_server;
                n5 = R.drawable.message_got_receipt_from_server_onmedia;
                n6 = R.drawable.message_got_receipt_from_target;
                n7 = R.drawable.message_got_receipt_from_target_onmedia;
                n8 = R.drawable.message_got_read_receipt_from_target;
                n9 = R.drawable.message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 1: {
                style_str = "bbm";
                n2 = R.drawable.bbm_message_unsent;
                n3 = R.drawable.bbm_message_unsent_onmedia;
                n4 = R.drawable.bbm_message_got_receipt_from_server;
                n5 = R.drawable.bbm_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.bbm_message_got_receipt_from_target;
                n7 = R.drawable.bbm_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.bbm_message_got_read_receipt_from_target;
                n9 = R.drawable.bbm_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 2: {
                style_str = "bpg";
                n2 = R.drawable.bpg_message_unsent_2;
                n3 = R.drawable.bpg_message_unsent_onmedia;
                n4 = R.drawable.bpg_message_got_receipt_from_server;
                n5 = R.drawable.bpg_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.bpg_message_got_receipt_from_target;
                n7 = R.drawable.bpg_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.bpg_message_got_read_receipt_from_target;
                n9 = R.drawable.bpg_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 3: {
                style_str = "circle";
                n2 = R.drawable.circle_message_unsent;
                n3 = R.drawable.circle_message_unsent_onmedia;
                n4 = R.drawable.circle_message_got_receipt_from_server;
                n5 = R.drawable.circle_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.circle_message_got_receipt_from_target;
                n7 = R.drawable.circle_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.circle_message_got_read_receipt_from_target;
                n9 = R.drawable.circle_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 4: {
                style_str = "circles";
                n2 = R.drawable.circles_message_unsent;
                n3 = R.drawable.circles_message_unsent_onmedia;
                n4 = R.drawable.circles_message_got_receipt_from_server;
                n5 = R.drawable.circles_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.circles_message_got_receipt_from_target;
                n7 = R.drawable.circles_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.circles_message_got_read_receipt_from_target;
                n9 = R.drawable.circles_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 5: {
                style_str = "coalfield";
                n2 = R.drawable.coalfield_message_unsent;
                n3 = R.drawable.coalfield_message_unsent_onmedia;
                n4 = R.drawable.coalfield_message_got_receipt_from_server;
                n5 = R.drawable.coalfield_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.coalfield_message_got_receipt_from_target;
                n7 = R.drawable.coalfield_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.coalfield_message_got_read_receipt_from_target;
                n9 = R.drawable.coalfield_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 6: {
                style_str = "altcrayon";
                n2 = R.drawable.altcrayon_message_unsent;
                n3 = R.drawable.altcrayon_message_unsent_onmedia;
                n4 = R.drawable.altcrayon_message_got_receipt_from_server;
                n5 = R.drawable.altcrayon_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.altcrayon_message_got_receipt_from_target;
                n7 = R.drawable.altcrayon_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.altcrayon_message_got_read_receipt_from_target;
                n9 = R.drawable.altcrayon_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 7: {
                style_str = "flatcircles";
                n2 = R.drawable.flatcircles_message_unsent;
                n3 = R.drawable.flatcircles_message_unsent_onmedia;
                n4 = R.drawable.flatcircles_message_got_receipt_from_server;
                n5 = R.drawable.flatcircles_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.flatcircles_message_got_receipt_from_target;
                n7 = R.drawable.flatcircles_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.flatcircles_message_got_read_receipt_from_target;
                n9 = R.drawable.flatcircles_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 8: {
                style_str = "google";
                n2 = R.drawable.google_message_unsent;
                n3 = R.drawable.google_message_unsent_onmedia;
                n4 = R.drawable.google_message_got_receipt_from_server;
                n5 = R.drawable.google_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.google_message_got_receipt_from_target;
                n7 = R.drawable.google_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.google_message_got_read_receipt_from_target;
                n9 = R.drawable.google_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 9: {
                style_str = "ios";
                n2 = R.drawable.ios_message_unsent;
                n3 = R.drawable.ios_message_unsent_onmedia;
                n4 = R.drawable.ios_message_got_receipt_from_server;
                n5 = R.drawable.ios_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.ios_message_got_receipt_from_target;
                n7 = R.drawable.ios_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.ios_message_got_read_receipt_from_target;
                n9 = R.drawable.ios_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 10: {
                style_str = "hike";
                n2 = R.drawable.hike_message_unsent;
                n3 = R.drawable.hike_message_unsent_onmedia;
                n4 = R.drawable.hike_message_got_receipt_from_server;
                n5 = R.drawable.hike_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.hike_message_got_receipt_from_target;
                n7 = R.drawable.hike_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.hike_message_got_read_receipt_from_target;
                n9 = R.drawable.hike_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 11: {
                style_str = "letter";
                n2 = R.drawable.letter_message_unsent;
                n3 = R.drawable.letter_message_unsent_onmedia;
                n4 = R.drawable.letter_message_got_receipt_from_server;
                n5 = R.drawable.letter_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.letter_message_got_receipt_from_target;
                n7 = R.drawable.letter_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.letter_message_got_read_receipt_from_target;
                n9 = R.drawable.letter_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 12: {
                style_str = "messenger";
                n2 = R.drawable.messenger_message_unsent;
                n3 = R.drawable.messenger_message_unsent_onmedia;
                n4 = R.drawable.messenger_message_got_receipt_from_server;
                n5 = R.drawable.messenger_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.messenger_message_got_receipt_from_target;
                n7 = R.drawable.messenger_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.messenger_message_got_read_receipt_from_target;
                n9 = R.drawable.messenger_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 13: {
                style_str = "smiley";
                n2 = R.drawable.smiley_message_unsent;
                n3 = R.drawable.smiley_message_unsent_onmedia;
                n4 = R.drawable.smiley_message_got_receipt_from_server;
                n5 = R.drawable.smiley_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.smiley_message_got_receipt_from_target;
                n7 = R.drawable.smiley_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.message_got_read_receipt_from_target;
                n9 = R.drawable.message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 14: {
                style_str = "traffic";
                n2 = R.drawable.traffic_message_unsent;
                n3 = R.drawable.traffic_message_unsent_onmedia;
                n4 = R.drawable.traffic_message_got_receipt_from_server;
                n5 = R.drawable.traffic_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.traffic_message_got_receipt_from_target;
                n7 = R.drawable.traffic_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.traffic_message_got_read_receipt_from_target;
                n9 = R.drawable.traffic_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 15: {
                style_str = "twitter";
                n2 = R.drawable.twitter_message_unsent;
                n3 = R.drawable.twitter_message_unsent_onmedia;
                n4 = R.drawable.twitter_message_got_receipt_from_server;
                n5 = R.drawable.twitter_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.twitter_message_got_receipt_from_target;
                n7 = R.drawable.twitter_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.twitter_message_got_read_receipt_from_target;
                n9 = R.drawable.twitter_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 16: {
                style_str = "newwaca";
                n2 = R.drawable.newwaca_message_unsent;
                n3 = R.drawable.newwaca_message_unsent_onmedia;
                n4 = R.drawable.newwaca_message_got_receipt_from_server;
                n5 = R.drawable.newwaca_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.newwaca_message_got_receipt_from_target;
                n7 = R.drawable.newwaca_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.newwaca_message_got_read_receipt_from_target;
                n9 = R.drawable.newwaca_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 17: {
                style_str = "oldwaca";
                n2 = R.drawable.oldwaca_message_unsent;
                n3 = R.drawable.oldwaca_message_unsent_onmedia;
                n4 = R.drawable.oldwaca_message_got_receipt_from_server;
                n5 = R.drawable.oldwaca_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.oldwaca_message_got_receipt_from_target;
                n7 = R.drawable.oldwaca_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.oldwaca_message_got_read_receipt_from_target;
                n9 = R.drawable.oldwaca_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 18: {
                style_str = "tb";
                n2 = R.drawable.tb_message_unsent;
                n3 = R.drawable.tb_message_unsent_onmedia;
                n4 = R.drawable.tb_message_got_receipt_from_server;
                n5 = R.drawable.tb_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.tb_message_got_receipt_from_target;
                n7 = R.drawable.tb_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.tb_message_got_read_receipt_from_target;
                n9 = R.drawable.tb_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 19: {
                style_str = "joaquins";
                n2 = R.drawable.joaquins_message_unsent;
                n3 = R.drawable.joaquins_message_unsent_onmedia;
                n4 = R.drawable.joaquins_message_got_receipt_from_server;
                n5 = R.drawable.joaquins_message_got_receipt_from_server_onmedia;
                n6 = R.drawable.joaquins_message_got_receipt_from_target;
                n7 = R.drawable.joaquins_message_got_receipt_from_target_onmedia;
                n8 = R.drawable.joaquins_message_got_read_receipt_from_target;
                n9 = R.drawable.joaquins_message_got_read_receipt_from_target_onmedia;
                break;
            }
        }
        switch (n) {
            case 1: {
                n9 = n2;
                break;
            }
            case 2: {
                n9 = n3;
                break;
            }
            case 3: {
                n9 = n4;
                break;
            }
            case 4: {
                n9 = n5;
                break;
            }
            case 5: {
                n9 = n6;
                break;
            }
            case 6: {
                n9 = n7;
                break;
            }
            case 7: {
                n9 = n8;
                break;
            }
        }
        return n9;
    }
}
