package com.B58works;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.whatsapp.sn1;

import static com.B58works.B58.getBoolean;
import static com.B58works.B58.getPrefString;
import static com.B58works.B58.getPrefString1;
import static com.whatsapp.sn1.getColor;
import static com.whatsapp.sn1.mainTextColor;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class BT
{
    public static String style_str;

    public static int BubbleStyle(int n) {

        final int int1 = getPrefString1("bubble_style");
        int n2 = B58.getResID("balloon_incoming_normal", "drawable");
        int n3 = B58.getResID("balloon_incoming_normal_ext", "drawable");
        int n4 = B58.getResID("balloon_outgoing_normal", "drawable");
        int n5 = B58.getResID("balloon_outgoing_normal_ext", "drawable");
        switch (int1) {
            case 0: {
                n2 = B58.getResID("balloon_incoming_normal", "drawable");
                n3 = B58.getResID("balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 1: {
                n2 = B58.getResID("rounded_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("rounded_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("rounded_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("rounded_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 2: {
                n2 = B58.getResID("materialized_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("materialized_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("materialized_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("materialized_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 3: {
                n2 = B58.getResID("hangouts_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("hangouts_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("hangouts_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("hangouts_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 4: {
                n2 = B58.getResID("wapaper_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("wapaper_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("wapaper_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("wapaper_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 5: {
                n2 = B58.getResID("walb_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("walb_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("walb_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("walb_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 6: {
                n2 = B58.getResID("gosms_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("gosms_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("gosms_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("gosms_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 7: {
                n2 = B58.getResID("bdrop_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("bdrop_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("bdrop_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("bdrop_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 8: {
                n2 = B58.getResID("altcr_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("altcr_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("altcr_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("altcr_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 9: {
                n2 = B58.getResID("trans_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("trans_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("trans_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("trans_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 10: {
                n2 = B58.getResID("apple_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("apple_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("apple_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("apple_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 11: {
                n2 = B58.getResID("textra_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("textra_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("textra_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("textra_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 12: {
                n2 = B58.getResID("hike_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("hike_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("hike_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("hike_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 13: {
                n2 = B58.getResID("dual_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("dual_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("dual_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("dual_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 14: {
                n2 = B58.getResID("in_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("in_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("in_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("in_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 15: {
                n2 = B58.getResID("bryed_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("bryed_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("bryed_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("bryed_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 16: {
                n2 = B58.getResID("fold_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("fold_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("fold_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("fold_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 17: {
                n2 = B58.getResID("foldv2_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("foldv2_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("foldv2_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("foldv2_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 18: {
                n2 = B58.getResID("md_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("md_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("md_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("md_balloon_outgoing_normal_ext", "drawable");
                break;
            }
            case 19: {
                n2 = B58.getResID("round_balloon_incoming_normal", "drawable");
                n3 = B58.getResID("round_balloon_incoming_normal_ext", "drawable");
                n4 = B58.getResID("round_balloon_outgoing_normal", "drawable");
                n5 = B58.getResID("round_balloon_outgoing_normal_ext", "drawable");
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
        int n2 = B58.getResID("message_unsent", "drawable");
        int n3 = B58.getResID("message_unsent_onmedia", "drawable");
        int n4 = B58.getResID("message_got_receipt_from_server", "drawable");
        int n5 = B58.getResID("message_got_receipt_from_server_onmedia", "drawable");
        int n6 = B58.getResID("message_got_receipt_from_target", "drawable");
        int n7 = B58.getResID("message_got_receipt_from_target_onmedia", "drawable");
        int n8 = B58.getResID("message_got_read_receipt_from_target", "drawable");
        int n9 = B58.getResID("message_got_read_receipt_from_target_onmedia", "drawable");
        switch (getPrefString1("tick_style")) {
            case 0: {
                style_str = "stock";
                n2 = B58.getResID("message_unsent", "drawable");
                n3 = B58.getResID("message_unsent_onmedia", "drawable");
                n4 = B58.getResID("message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("message_got_receipt_from_target_onmedia", "drawable");
                n8 = B58.getResID("message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("message_got_read_receipt_from_target_onmedia", "drawable");
                break;
            }
            case 1: {
                style_str = "bbm";
                n8 = B58.getResID("bbm_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("bbm_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("bbm_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("bbm_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("bbm_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("bbm_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("bbm_message_unsent", "drawable");
                n3 = B58.getResID("bbm_message_unsent_onmedia", "drawable");
                break;
            }
            case 2: {
                style_str = "bpg";
                n8 = B58.getResID("bpg_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("bpg_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("bpg_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("bpg_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("bpg_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("bpg_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("bpg_message_unsent", "drawable");
                n3 = B58.getResID("bpg_message_unsent_onmedia", "drawable");
                break;
            }
            case 3: {
                style_str = "circle";
                n8 = B58.getResID("circle_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("circle_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("circle_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("circle_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("circle_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("circle_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("circle_message_unsent", "drawable");
                n3 = B58.getResID("circle_message_unsent_onmedia", "drawable");
                break;
            }
            case 4: {
                style_str = "circles";
                n8 = B58.getResID("circles_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("circles_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("circles_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("circles_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("circles_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("circles_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("circles_message_unsent", "drawable");
                n3 = B58.getResID("circles_message_unsent_onmedia", "drawable");
                break;
            }
            case 5: {
                style_str = "joaquins";
                n8 = B58.getResID("coalfield_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("coalfield_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("coalfield_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("coalfield_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("coalfield_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("coalfield_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("coalfield_message_unsent", "drawable");
                n3 = B58.getResID("coalfield_message_unsent_onmedia", "drawable");
                break;
            }
            case 6: {
                style_str = "coalfield";
                n8 = B58.getResID("altcrayon_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("altcrayon_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("altcrayon_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("altcrayon_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("altcrayon_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("altcrayon_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("altcrayon_message_unsent", "drawable");
                n3 = B58.getResID("altcrayon_message_unsent_onmedia", "drawable");
                break;
            }
            case 7: {
                style_str = "bpg";
                n8 = B58.getResID("flatcircles_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("flatcircles_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("flatcircles_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("flatcircles_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("flatcircles_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("flatcircles_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("flatcircles_message_unsent", "drawable");
                n3 = B58.getResID("flatcircles_message_unsent_onmedia", "drawable");
                break;
            }
            case 8: {
                style_str = "flatcircles";
                n8 = B58.getResID("google_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("google_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("google_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("google_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("google_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("google_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("google_message_unsent", "drawable");
                n3 = B58.getResID("google_message_unsent_onmedia", "drawable");
                break;
            }
            case 9: {
                style_str = "circle";
                n8 = B58.getResID("ios_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("ios_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("ios_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("ios_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("ios_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("ios_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("ios_message_unsent", "drawable");
                n3 = B58.getResID("ios_message_unsent_onmedia", "drawable");
                break;
            }
            case 10: {
                style_str = "hike";
                n8 = B58.getResID("hike_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("hike_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("hike_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("hike_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("hike_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("hike_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("hike_message_unsent", "drawable");
                n3 = B58.getResID("hike_message_unsent_onmedia", "drawable");
                break;
            }
            case 11: {
                style_str = "letter";
                n8 = B58.getResID("letter_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("letter_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("letter_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("letter_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("letter_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("letter_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("letter_message_unsent", "drawable");
                n3 = B58.getResID("letter_message_unsent_onmedia", "drawable");
                break;
            }
            case 12: {
                style_str = "messenger";
                n8 = B58.getResID("messenger_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("messenger_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("messenger_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("messenger_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("messenger_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("messenger_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("messenger_message_unsent", "drawable");
                n3 = B58.getResID("messenger_message_unsent_onmedia", "drawable");
                break;
            }
            case 13: {
                style_str = "smiley";
                n8 = B58.getResID("smiley_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("smiley_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("smiley_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("smiley_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("smiley_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("smiley_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("smiley_message_unsent", "drawable");
                n3 = B58.getResID("smiley_message_unsent_onmedia", "drawable");
                break;
            }
            case 14: {
                style_str = "traffic";
                n8 = B58.getResID("traffic_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("traffic_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("traffic_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("traffic_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("traffic_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("traffic_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("traffic_message_unsent", "drawable");
                n3 = B58.getResID("traffic_message_unsent_onmedia", "drawable");
                break;
            }
            case 15: {
                style_str = "twitter";
                n8 = B58.getResID("twitter_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("twitter_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("twitter_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("twitter_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("twitter_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("twitter_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("twitter_message_unsent", "drawable");
                n3 = B58.getResID("twitter_message_unsent_onmedia", "drawable");
                break;
            }
            case 16: {
                style_str = "wbg";
                n8 = B58.getResID("newwaca_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("newwaca_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("newwaca_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("newwaca_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("newwaca_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("newwaca_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("newwaca_message_unsent", "drawable");
                n3 = B58.getResID("newwaca_message_unsent_onmedia", "drawable");
                break;
            }
            case 17: {
                style_str = "wbg";
                n8 = B58.getResID("oldwaca_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("oldwaca_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("oldwaca_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("oldwaca_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("oldwaca_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("oldwaca_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("oldwaca_message_unsent", "drawable");
                n3 = B58.getResID("oldwaca_message_unsent_onmedia", "drawable");
                break;
            }
            case 18: {
                style_str = "wbg";
                n8 = B58.getResID("tb_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("tb_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("tb_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("tb_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("tb_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("tb_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("tb_message_unsent", "drawable");
                n3 = B58.getResID("tb_message_unsent_onmedia", "drawable");
                break;
            }
            case 19: {
                style_str = "wbg";
                n8 = B58.getResID("joaquins_message_got_read_receipt_from_target", "drawable");
                n9 = B58.getResID("joaquins_message_got_read_receipt_from_target_onmedia", "drawable");
                n4 = B58.getResID("joaquins_message_got_receipt_from_server", "drawable");
                n5 = B58.getResID("joaquins_message_got_receipt_from_server_onmedia", "drawable");
                n6 = B58.getResID("joaquins_message_got_receipt_from_target", "drawable");
                n7 = B58.getResID("joaquins_message_got_receipt_from_target_onmedia", "drawable");
                n2 = B58.getResID("joaquins_message_unsent", "drawable");
                n3 = B58.getResID("joaquins_message_unsent_onmedia", "drawable");
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

    public static void chatscrcontname(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Chatcontname";break;}
            case 1:{s="ModContactNameColor";break;}
            case 2:{s="chats_contacts_names_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
        TextView t=(view.findViewById(n));
        hidename(t);
    }

    public static void hidename(TextView t)
    {
        if(getBoolean("hidename"))
        {
            //t.setText("Contact name Hidden.");
           //t.setTypeface(null, Typeface.ITALIC);
            t.setVisibility(View.GONE);
        }
    }

    public static void chatscrdate(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Chatdate";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_date_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void chatscrmsgfrom(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Chatfrom";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_from_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void chatscrmsg(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Chatmsg";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_msg_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
        if(getBoolean("hidemsg"))
        {
            final FrameLayout f = view.findViewById(sn1.zhidemsg());
            if (f != null) {
                f.setVisibility(View.GONE);
            }
        }
    }

    public static void chatscrmsgcount(final View view, final int n) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Chatmsgcount";break;}
            case 1:{s="HomeCounterText";break;}
            case 2:{s="chats_unread_msg_text_color_picker";break;}
        }
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, Color.parseColor("#ffffff")));
    }

    public static void statscrname(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Statcontname";break;}
            case 1:{s="ModContactNameColor";break;}
            case 2:{s="chats_contacts_names_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void statscrdate(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Statdate";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_date_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void callscrname(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Callcontname";break;}
            case 1:{s="ModContactNameColor";break;}
            case 2:{s="chats_contacts_names_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void callscrcount(final View view, final int n) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Callscrcount";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_unread_msg_text_color_picker";break;}
        }
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, mainTextColor()));
        ((TextView)view.findViewById(n)).setTypeface(Typeface.DEFAULT);
    }

    public static void callscrdate(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Callscrdate";break;}
            case 1:{s="ModConTextColor";break;}
            case 2:{s="chats_date_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void convscrname(final View view, final int n) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Convcontname";break;}
            case 2:{s="contact_name_color_picker";break;}
        }
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, -1));
    }

    public static void convscrlastseen(final View view, final int n) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="Convcontls";break;}
            case 2:{s="contact_status_color_picker";break;}
        }
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, -1));
    }

    public static void conpickscrcontname(final View view, final int n, final int size) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="conname";break;}
            case 2:{s="chats_contacts_names_color_picker";break;}
        }
        textcolorwsize(n, s, view, size);
    }

    public static void conpickscrstatus(final View view, final int n, final int size) {
        String s;
        switch (getPrefString("file_type")) {
            default: { s = "constatus";break; }
            case 2: { s = "chats_msg_color_picker";break; }
        }
        textcolorwsize(n, s, view, size);
    }

    public static void conpicktype(final View view, final int n) {
        String s;
        switch(getPrefString("file_type"))
        {
            default:{s="contype";break;}
            case 2:{s="chats_contacts_names_color_picker";break;}
        }
        textcolorwosize(n, s, view);
    }

    private static void textcolorwsize(final int n, final String s, final View view, final int size) {
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, mainTextColor()));
        ((TextView)view.findViewById(n)).setTextSize((float)(B58.ctx.getSharedPreferences("com.whatsapp_preferences", 0).getInt("main_text", 15) - size));
    }

    private static void textcolorwosize(final int n, final String s, final View view) {
        ((TextView)view.findViewById(n)).setTextColor(getColor(s, -1));
    }
}
