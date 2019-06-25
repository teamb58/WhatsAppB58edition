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
            final FrameLayout f = view.findViewById(IDGen.id.hidemsg);
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

        final int int1 = getIntofList("bubblestyle");
        int n2 = IDGen.drawable.balloon_incoming_normal;
        int n3 = IDGen.drawable.balloon_incoming_normal_ext;
        int n4 = IDGen.drawable.balloon_outgoing_normal;
        int n5 = IDGen.drawable.balloon_outgoing_normal_ext;
        switch (int1) {
            case 0: {
                n2 = IDGen.drawable.balloon_incoming_normal;
                n3 = IDGen.drawable.balloon_incoming_normal_ext;
                n4 = IDGen.drawable.balloon_outgoing_normal;
                n5 = IDGen.drawable.balloon_outgoing_normal_ext;
                break;
            }
            case 1: {
                n2 = IDGen.drawable.rounded_balloon_incoming_normal;
                n3 = IDGen.drawable.rounded_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.rounded_balloon_outgoing_normal;
                n5 = IDGen.drawable.rounded_balloon_outgoing_normal_ext;
                break;
            }
            case 2: {
                n2 = IDGen.drawable.materialized_balloon_incoming_normal;
                n3 = IDGen.drawable.materialized_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.materialized_balloon_outgoing_normal;
                n5 = IDGen.drawable.materialized_balloon_outgoing_normal_ext;
                break;
            }
            case 3: {
                n2 = IDGen.drawable.hangouts_balloon_incoming_normal;
                n3 = IDGen.drawable.hangouts_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.hangouts_balloon_outgoing_normal;
                n5 = IDGen.drawable.hangouts_balloon_outgoing_normal_ext;
                break;
            }
            case 4: {
                n2 = IDGen.drawable.wapaper_balloon_incoming_normal;
                n3 = IDGen.drawable.wapaper_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.wapaper_balloon_outgoing_normal;
                n5 = IDGen.drawable.wapaper_balloon_outgoing_normal_ext;
                break;
            }
            case 5: {
                n2 = IDGen.drawable.walb_balloon_incoming_normal;
                n3 = IDGen.drawable.walb_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.walb_balloon_outgoing_normal;
                n5 = IDGen.drawable.walb_balloon_outgoing_normal_ext;
                break;
            }
            case 6: {
                n2 = IDGen.drawable.gosms_balloon_incoming_normal;
                n3 = IDGen.drawable.gosms_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.gosms_balloon_outgoing_normal;
                n5 = IDGen.drawable.gosms_balloon_outgoing_normal_ext;
                break;
            }
            case 7: {
                n2 = IDGen.drawable.bdrop_balloon_incoming_normal;
                n3 = IDGen.drawable.bdrop_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.bdrop_balloon_outgoing_normal;
                n5 = IDGen.drawable.bdrop_balloon_outgoing_normal_ext;
                break;
            }
            case 8: {
                n2 = IDGen.drawable.altcr_balloon_incoming_normal;
                n3 = IDGen.drawable.altcr_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.altcr_balloon_outgoing_normal;
                n5 = IDGen.drawable.altcr_balloon_outgoing_normal_ext;
                break;
            }
            case 9: {
                n2 = IDGen.drawable.trans_balloon_incoming_normal;
                n3 = IDGen.drawable.trans_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.trans_balloon_outgoing_normal;
                n5 = IDGen.drawable.trans_balloon_outgoing_normal_ext;
                break;
            }
            case 10: {
                n2 = IDGen.drawable.apple_balloon_incoming_normal;
                n3 = IDGen.drawable.apple_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.apple_balloon_outgoing_normal;
                n5 = IDGen.drawable.apple_balloon_outgoing_normal_ext;
                break;
            }
            case 11: {
                n2 = IDGen.drawable.textra_balloon_incoming_normal;
                n3 = IDGen.drawable.textra_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.textra_balloon_outgoing_normal;
                n5 = IDGen.drawable.textra_balloon_outgoing_normal_ext;
                break;
            }
            case 12: {
                n2 = IDGen.drawable.hike_balloon_incoming_normal;
                n3 = IDGen.drawable.hike_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.hike_balloon_outgoing_normal;
                n5 = IDGen.drawable.hike_balloon_outgoing_normal_ext;
                break;
            }
            case 13: {
                n2 = IDGen.drawable.dual_balloon_incoming_normal;
                n3 = IDGen.drawable.dual_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.dual_balloon_outgoing_normal;
                n5 = IDGen.drawable.dual_balloon_outgoing_normal_ext;
                break;
            }
            case 14: {
                n2 = IDGen.drawable.in_balloon_incoming_normal;
                n3 = IDGen.drawable.in_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.in_balloon_outgoing_normal;
                n5 = IDGen.drawable.in_balloon_outgoing_normal_ext;
                break;
            }
            case 15: {
                n2 = IDGen.drawable.bryed_balloon_incoming_normal;
                n3 = IDGen.drawable.bryed_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.bryed_balloon_outgoing_normal;
                n5 = IDGen.drawable.bryed_balloon_outgoing_normal_ext;
                break;
            }
            case 16: {
                n2 = IDGen.drawable.fold_balloon_incoming_normal;
                n3 = IDGen.drawable.fold_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.fold_balloon_outgoing_normal;
                n5 = IDGen.drawable.fold_balloon_outgoing_normal_ext;
                break;
            }
            case 17: {
                n2 = IDGen.drawable.foldv2_balloon_incoming_normal;
                n3 = IDGen.drawable.foldv2_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.foldv2_balloon_outgoing_normal;
                n5 = IDGen.drawable.foldv2_balloon_outgoing_normal_ext;
                break;
            }
            case 18: {
                n2 = IDGen.drawable.md_balloon_incoming_normal;
                n3 = IDGen.drawable.md_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.md_balloon_outgoing_normal;
                n5 = IDGen.drawable.md_balloon_outgoing_normal_ext;
                break;
            }
            case 19: {
                n2 = IDGen.drawable.round_balloon_incoming_normal;
                n3 = IDGen.drawable.round_balloon_incoming_normal_ext;
                n4 = IDGen.drawable.round_balloon_outgoing_normal;
                n5 = IDGen.drawable.round_balloon_outgoing_normal_ext;
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
        int n2 = IDGen.drawable.message_unsent;
        int n3 = IDGen.drawable.message_unsent_onmedia;
        int n4 = IDGen.drawable.message_got_receipt_from_server;
        int n5 = IDGen.drawable.message_got_receipt_from_server_onmedia;
        int n6 = IDGen.drawable.message_got_receipt_from_target;
        int n7 = IDGen.drawable.message_got_receipt_from_target_onmedia;
        int n8 = IDGen.drawable.message_got_read_receipt_from_target;
        int n9 = IDGen.drawable.message_got_read_receipt_from_target_onmedia;
        switch (getIntofList("tickstyle")) {
            case 0: {
                style_str = "stock";
                n2 = IDGen.drawable.message_unsent;
                n3 = IDGen.drawable.message_unsent_onmedia;
                n4 = IDGen.drawable.message_got_receipt_from_server;
                n5 = IDGen.drawable.message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.message_got_receipt_from_target;
                n7 = IDGen.drawable.message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.message_got_read_receipt_from_target;
                n9 = IDGen.drawable.message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 1: {
                style_str = "bbm";
                n2 = IDGen.drawable.bbm_message_unsent;
                n3 = IDGen.drawable.bbm_message_unsent_onmedia;
                n4 = IDGen.drawable.bbm_message_got_receipt_from_server;
                n5 = IDGen.drawable.bbm_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.bbm_message_got_receipt_from_target;
                n7 = IDGen.drawable.bbm_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.bbm_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.bbm_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 2: {
                style_str = "bpg";
                n2 = IDGen.drawable.bpg_message_unsent_2;
                n3 = IDGen.drawable.bpg_message_unsent_onmedia;
                n4 = IDGen.drawable.bpg_message_got_receipt_from_server;
                n5 = IDGen.drawable.bpg_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.bpg_message_got_receipt_from_target;
                n7 = IDGen.drawable.bpg_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.bpg_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.bpg_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 3: {
                style_str = "circle";
                n2 = IDGen.drawable.circle_message_unsent;
                n3 = IDGen.drawable.circle_message_unsent_onmedia;
                n4 = IDGen.drawable.circle_message_got_receipt_from_server;
                n5 = IDGen.drawable.circle_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.circle_message_got_receipt_from_target;
                n7 = IDGen.drawable.circle_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.circle_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.circle_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 4: {
                style_str = "circles";
                n2 = IDGen.drawable.circles_message_unsent;
                n3 = IDGen.drawable.circles_message_unsent_onmedia;
                n4 = IDGen.drawable.circles_message_got_receipt_from_server;
                n5 = IDGen.drawable.circles_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.circles_message_got_receipt_from_target;
                n7 = IDGen.drawable.circles_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.circles_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.circles_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 5: {
                style_str = "coalfield";
                n2 = IDGen.drawable.coalfield_message_unsent;
                n3 = IDGen.drawable.coalfield_message_unsent_onmedia;
                n4 = IDGen.drawable.coalfield_message_got_receipt_from_server;
                n5 = IDGen.drawable.coalfield_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.coalfield_message_got_receipt_from_target;
                n7 = IDGen.drawable.coalfield_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.coalfield_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.coalfield_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 6: {
                style_str = "altcrayon";
                n2 = IDGen.drawable.altcrayon_message_unsent;
                n3 = IDGen.drawable.altcrayon_message_unsent_onmedia;
                n4 = IDGen.drawable.altcrayon_message_got_receipt_from_server;
                n5 = IDGen.drawable.altcrayon_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.altcrayon_message_got_receipt_from_target;
                n7 = IDGen.drawable.altcrayon_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.altcrayon_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.altcrayon_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 7: {
                style_str = "flatcircles";
                n2 = IDGen.drawable.flatcircles_message_unsent;
                n3 = IDGen.drawable.flatcircles_message_unsent_onmedia;
                n4 = IDGen.drawable.flatcircles_message_got_receipt_from_server;
                n5 = IDGen.drawable.flatcircles_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.flatcircles_message_got_receipt_from_target;
                n7 = IDGen.drawable.flatcircles_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.flatcircles_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.flatcircles_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 8: {
                style_str = "google";
                n2 = IDGen.drawable.google_message_unsent;
                n3 = IDGen.drawable.google_message_unsent_onmedia;
                n4 = IDGen.drawable.google_message_got_receipt_from_server;
                n5 = IDGen.drawable.google_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.google_message_got_receipt_from_target;
                n7 = IDGen.drawable.google_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.google_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.google_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 9: {
                style_str = "ios";
                n2 = IDGen.drawable.ios_message_unsent;
                n3 = IDGen.drawable.ios_message_unsent_onmedia;
                n4 = IDGen.drawable.ios_message_got_receipt_from_server;
                n5 = IDGen.drawable.ios_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.ios_message_got_receipt_from_target;
                n7 = IDGen.drawable.ios_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.ios_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.ios_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 10: {
                style_str = "hike";
                n2 = IDGen.drawable.hike_message_unsent;
                n3 = IDGen.drawable.hike_message_unsent_onmedia;
                n4 = IDGen.drawable.hike_message_got_receipt_from_server;
                n5 = IDGen.drawable.hike_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.hike_message_got_receipt_from_target;
                n7 = IDGen.drawable.hike_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.hike_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.hike_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 11: {
                style_str = "letter";
                n2 = IDGen.drawable.letter_message_unsent;
                n3 = IDGen.drawable.letter_message_unsent_onmedia;
                n4 = IDGen.drawable.letter_message_got_receipt_from_server;
                n5 = IDGen.drawable.letter_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.letter_message_got_receipt_from_target;
                n7 = IDGen.drawable.letter_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.letter_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.letter_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 12: {
                style_str = "messenger";
                n2 = IDGen.drawable.messenger_message_unsent;
                n3 = IDGen.drawable.messenger_message_unsent_onmedia;
                n4 = IDGen.drawable.messenger_message_got_receipt_from_server;
                n5 = IDGen.drawable.messenger_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.messenger_message_got_receipt_from_target;
                n7 = IDGen.drawable.messenger_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.messenger_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.messenger_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 13: {
                style_str = "smiley";
                n2 = IDGen.drawable.smiley_message_unsent;
                n3 = IDGen.drawable.smiley_message_unsent_onmedia;
                n4 = IDGen.drawable.smiley_message_got_receipt_from_server;
                n5 = IDGen.drawable.smiley_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.smiley_message_got_receipt_from_target;
                n7 = IDGen.drawable.smiley_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.smiley_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.smiley_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 14: {
                style_str = "traffic";
                n2 = IDGen.drawable.traffic_message_unsent;
                n3 = IDGen.drawable.traffic_message_unsent_onmedia;
                n4 = IDGen.drawable.traffic_message_got_receipt_from_server;
                n5 = IDGen.drawable.traffic_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.traffic_message_got_receipt_from_target;
                n7 = IDGen.drawable.traffic_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.traffic_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.traffic_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 15: {
                style_str = "twitter";
                n2 = IDGen.drawable.twitter_message_unsent;
                n3 = IDGen.drawable.twitter_message_unsent_onmedia;
                n4 = IDGen.drawable.twitter_message_got_receipt_from_server;
                n5 = IDGen.drawable.twitter_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.twitter_message_got_receipt_from_target;
                n7 = IDGen.drawable.twitter_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.twitter_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.twitter_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 16: {
                style_str = "newwaca";
                n2 = IDGen.drawable.newwaca_message_unsent;
                n3 = IDGen.drawable.newwaca_message_unsent_onmedia;
                n4 = IDGen.drawable.newwaca_message_got_receipt_from_server;
                n5 = IDGen.drawable.newwaca_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.newwaca_message_got_receipt_from_target;
                n7 = IDGen.drawable.newwaca_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.newwaca_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.newwaca_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 17: {
                style_str = "oldwaca";
                n2 = IDGen.drawable.oldwaca_message_unsent;
                n3 = IDGen.drawable.oldwaca_message_unsent_onmedia;
                n4 = IDGen.drawable.oldwaca_message_got_receipt_from_server;
                n5 = IDGen.drawable.oldwaca_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.oldwaca_message_got_receipt_from_target;
                n7 = IDGen.drawable.oldwaca_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.oldwaca_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.oldwaca_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 18: {
                style_str = "tb";
                n2 = IDGen.drawable.tb_message_unsent;
                n3 = IDGen.drawable.tb_message_unsent_onmedia;
                n4 = IDGen.drawable.tb_message_got_receipt_from_server;
                n5 = IDGen.drawable.tb_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.tb_message_got_receipt_from_target;
                n7 = IDGen.drawable.tb_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.tb_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.tb_message_got_read_receipt_from_target_onmedia;
                break;
            }
            case 19: {
                style_str = "joaquins";
                n2 = IDGen.drawable.joaquins_message_unsent;
                n3 = IDGen.drawable.joaquins_message_unsent_onmedia;
                n4 = IDGen.drawable.joaquins_message_got_receipt_from_server;
                n5 = IDGen.drawable.joaquins_message_got_receipt_from_server_onmedia;
                n6 = IDGen.drawable.joaquins_message_got_receipt_from_target;
                n7 = IDGen.drawable.joaquins_message_got_receipt_from_target_onmedia;
                n8 = IDGen.drawable.joaquins_message_got_read_receipt_from_target;
                n9 = IDGen.drawable.joaquins_message_got_read_receipt_from_target_onmedia;
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
