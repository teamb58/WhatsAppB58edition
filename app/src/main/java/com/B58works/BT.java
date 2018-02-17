package com.B58works;

/**
 * Created by Bharath.R(58) on 16-02-2018.
 */

public class BT
{
    public static String style_str;

    public static int BubbleStyle(int n) {
        final int int1 = Integer.parseInt(B58.ctx.getSharedPreferences("B58", 0).getString("bubble_style", "0"));
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
        switch (Integer.parseInt(B58.ctx.getSharedPreferences("B58", 0).getString("tick_style", "0"))) {
            case 0: {
                BT.style_str = "stock";
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
                BT.style_str = "bbm";
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
                BT.style_str = "bpg";
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
                BT.style_str = "circle";
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
                BT.style_str = "circles";
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
                BT.style_str = "joaquins";
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
                BT.style_str = "coalfield";
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
                BT.style_str = "bpg";
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
                BT.style_str = "flatcircles";
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
                BT.style_str = "circle";
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
                BT.style_str = "hike";
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
                BT.style_str = "letter";
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
                BT.style_str = "messenger";
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
                BT.style_str = "smiley";
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
                BT.style_str = "traffic";
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
                BT.style_str = "twitter";
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
                BT.style_str = "wbg";
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
                BT.style_str = "wbg";
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
                BT.style_str = "wbg";
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
                BT.style_str = "wbg";
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
}
