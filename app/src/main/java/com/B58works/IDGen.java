package com.B58works;

public class IDGen {

    public static int layoutid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"layout",B58.ctx.getPackageName());
    }

    public static int idid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"id",B58.ctx.getPackageName());
    }

    public static int stringid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"string",B58.ctx.getPackageName());
    }

    private static int drawableid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"drawable",B58.ctx.getPackageName());
    }

    private static int attrid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"attr",B58.ctx.getPackageName());
    }

    private static int dimenid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"dimen",B58.ctx.getPackageName());
    }

    private static int xmlid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"xml",B58.ctx.getPackageName());
    }

    private static int arrayid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"array",B58.ctx.getPackageName());
    }

    private static int colorid(String s)
    {
        return B58.ctx.getResources().getIdentifier(s,"color",B58.ctx.getPackageName());
    }

    public static final class array {
        public static final int actionbarStyleListValues = arrayid("actionbarStyleListValues");
        public static final int conversation_bubbleStyleList = arrayid("conversation_bubbleStyleList");
        public static final int conversation_bubbleStyleListP = arrayid("conversation_bubbleStyleListP");
        public static final int conversation_bubbleStyleListValues = arrayid("conversation_bubbleStyleListValues");
        public static final int gr_style = arrayid("gr_style");
        public static final int notifybar_colors = arrayid("notifybar_colors");
        public static final int notifybar_icons = arrayid("notifybar_icons");
        public static final int notifybar_values = arrayid("notifybar_values");
        public static final int subtitile_names = arrayid("subtitile_names");
        public static final int subtitle_values = arrayid("subtitle_values");
        public static final int tick_i = arrayid("tick_i");
        public static final int tick_n = arrayid("tick_n");
        public static final int tick_v = arrayid("tick_v");
    }

    public static final class attr {

        public static int entryImages = attrid("entryImages");
        public static int fab_colorNormal = attrid("fab_colorNormal");
        public static int fab_plusIconColor = attrid("fab_plusIconColor");
        public static int fab_colorPressed = attrid("fab_colorPressed");
        public static int fab_icon = attrid("fab_icon");
        public static int fab_size = attrid("fab_size");
        public static int fab_title = attrid("fab_title");
        public static int fab_addButtonColorPressed = attrid("fab_addButtonColorPressed");
        public static int fab_addButtonColorNormal = attrid("fab_addButtonColorNormal");
        public static int fab_addButtonPlusIconColor = attrid("fab_addButtonPlusIconColor");
        public static int fab_labelStyle = attrid("fab_labelStyle");
        public static int fab_expandDirection = attrid("fab_expandDirection");

    }

    public static final class color {

        public static int colorPrimary = colorid("colorPrimary");
    }

    public static final class dimen {

        public static int fab_shadow_offset = dimenid("fab_shadow_offset");
        public static int fab_shadow_radius = dimenid("fab_shadow_radius");
        public static int fab_actions_spacing = dimenid("fab_actions_spacing");
        public static int fab_icon_size = dimenid("fab_icon_size");
        public static int fab_plus_icon_size = dimenid("fab_plus_icon_size");
        public static int fab_plus_icon_stroke = dimenid("fab_plus_icon_stroke");
        public static int fab_size_normal = dimenid("fab_size_normal");
        public static int fab_size_mini = dimenid("fab_size_mini");
        public static int fab_stroke_width = dimenid("fab_stroke_width");
        public static int fab_labels_margin = dimenid("fab_labels_margin");
        public static int abc_action_bar_default_height_material = dimenid("abc_action_bar_default_height_material");

    }

    public static final class drawable {

        public static int balloon_incoming_normal = drawableid("balloon_incoming_normal");
        public static int balloon_incoming_normal_ext = drawableid("balloon_incoming_normal_ext");
        public static int balloon_outgoing_normal = drawableid("balloon_outgoing_normal");
        public static int balloon_outgoing_normal_ext = drawableid("balloon_outgoing_normal_ext");
        public static int rounded_balloon_incoming_normal = drawableid("rounded_balloon_incoming_normal");
        public static int rounded_balloon_incoming_normal_ext = drawableid("rounded_balloon_incoming_normal_ext");
        public static int rounded_balloon_outgoing_normal = drawableid("rounded_balloon_outgoing_normal");
        public static int rounded_balloon_outgoing_normal_ext = drawableid("rounded_balloon_outgoing_normal_ext");
        public static int materialized_balloon_incoming_normal = drawableid("materialized_balloon_incoming_normal");
        public static int materialized_balloon_incoming_normal_ext = drawableid("materialized_balloon_incoming_normal_ext");
        public static int materialized_balloon_outgoing_normal = drawableid("materialized_balloon_outgoing_normal");
        public static int materialized_balloon_outgoing_normal_ext = drawableid("materialized_balloon_outgoing_normal_ext");
        public static int hangouts_balloon_incoming_normal = drawableid("hangouts_balloon_incoming_normal");
        public static int hangouts_balloon_incoming_normal_ext = drawableid("hangouts_balloon_incoming_normal_ext");
        public static int hangouts_balloon_outgoing_normal = drawableid("hangouts_balloon_outgoing_normal");
        public static int hangouts_balloon_outgoing_normal_ext = drawableid("hangouts_balloon_outgoing_normal_ext");
        public static int wapaper_balloon_incoming_normal = drawableid("wapaper_balloon_incoming_normal");
        public static int wapaper_balloon_incoming_normal_ext = drawableid("wapaper_balloon_incoming_normal_ext");
        public static int wapaper_balloon_outgoing_normal = drawableid("wapaper_balloon_outgoing_normal");
        public static int wapaper_balloon_outgoing_normal_ext = drawableid("wapaper_balloon_outgoing_normal_ext");
        public static int walb_balloon_incoming_normal = drawableid("walb_balloon_incoming_normal");
        public static int walb_balloon_incoming_normal_ext = drawableid("walb_balloon_incoming_normal_ext");
        public static int walb_balloon_outgoing_normal = drawableid("walb_balloon_outgoing_normal");
        public static int walb_balloon_outgoing_normal_ext = drawableid("walb_balloon_outgoing_normal_ext");
        public static int gosms_balloon_incoming_normal = drawableid("gosms_balloon_incoming_normal");
        public static int gosms_balloon_incoming_normal_ext = drawableid("gosms_balloon_incoming_normal_ext");
        public static int gosms_balloon_outgoing_normal = drawableid("gosms_balloon_outgoing_normal");
        public static int gosms_balloon_outgoing_normal_ext = drawableid("gosms_balloon_outgoing_normal_ext");
        public static int bdrop_balloon_incoming_normal = drawableid("bdrop_balloon_incoming_normal");
        public static int bdrop_balloon_incoming_normal_ext = drawableid("bdrop_balloon_incoming_normal_ext");
        public static int bdrop_balloon_outgoing_normal = drawableid("bdrop_balloon_outgoing_normal");
        public static int bdrop_balloon_outgoing_normal_ext = drawableid("bdrop_balloon_outgoing_normal_ext");
        public static int altcr_balloon_incoming_normal = drawableid("altcr_balloon_incoming_normal");
        public static int altcr_balloon_incoming_normal_ext = drawableid("altcr_balloon_incoming_normal_ext");
        public static int altcr_balloon_outgoing_normal = drawableid("altcr_balloon_outgoing_normal");
        public static int altcr_balloon_outgoing_normal_ext = drawableid("altcr_balloon_outgoing_normal_ext");
        public static int trans_balloon_incoming_normal = drawableid("trans_balloon_incoming_normal");
        public static int trans_balloon_incoming_normal_ext = drawableid("trans_balloon_incoming_normal_ext");
        public static int trans_balloon_outgoing_normal = drawableid("trans_balloon_outgoing_normal");
        public static int trans_balloon_outgoing_normal_ext = drawableid("trans_balloon_outgoing_normal_ext");
        public static int apple_balloon_incoming_normal = drawableid("apple_balloon_incoming_normal");
        public static int apple_balloon_incoming_normal_ext = drawableid("apple_balloon_incoming_normal_ext");
        public static int apple_balloon_outgoing_normal = drawableid("apple_balloon_outgoing_normal");
        public static int apple_balloon_outgoing_normal_ext = drawableid("apple_balloon_outgoing_normal_ext");
        public static int textra_balloon_incoming_normal = drawableid("textra_balloon_incoming_normal");
        public static int textra_balloon_incoming_normal_ext = drawableid("textra_balloon_incoming_normal_ext");
        public static int textra_balloon_outgoing_normal = drawableid("textra_balloon_outgoing_normal");
        public static int textra_balloon_outgoing_normal_ext = drawableid("textra_balloon_outgoing_normal_ext");
        public static int hike_balloon_incoming_normal = drawableid("hike_balloon_incoming_normal");
        public static int hike_balloon_incoming_normal_ext = drawableid("hike_balloon_incoming_normal_ext");
        public static int hike_balloon_outgoing_normal = drawableid("hike_balloon_outgoing_normal");
        public static int hike_balloon_outgoing_normal_ext = drawableid("hike_balloon_outgoing_normal_ext");
        public static int dual_balloon_incoming_normal = drawableid("dual_balloon_incoming_normal");
        public static int dual_balloon_incoming_normal_ext = drawableid("dual_balloon_incoming_normal_ext");
        public static int dual_balloon_outgoing_normal = drawableid("dual_balloon_outgoing_normal");
        public static int dual_balloon_outgoing_normal_ext = drawableid("dual_balloon_outgoing_normal_ext");
        public static int in_balloon_incoming_normal = drawableid("in_balloon_incoming_normal");
        public static int in_balloon_incoming_normal_ext = drawableid("in_balloon_incoming_normal_ext");
        public static int in_balloon_outgoing_normal = drawableid("in_balloon_outgoing_normal");
        public static int in_balloon_outgoing_normal_ext = drawableid("in_balloon_outgoing_normal_ext");
        public static int bryed_balloon_incoming_normal = drawableid("bryed_balloon_incoming_normal");
        public static int bryed_balloon_incoming_normal_ext = drawableid("bryed_balloon_incoming_normal_ext");
        public static int bryed_balloon_outgoing_normal = drawableid("bryed_balloon_outgoing_normal");
        public static int bryed_balloon_outgoing_normal_ext = drawableid("bryed_balloon_outgoing_normal_ext");
        public static int fold_balloon_incoming_normal = drawableid("fold_balloon_incoming_normal");
        public static int fold_balloon_incoming_normal_ext = drawableid("fold_balloon_incoming_normal_ext");
        public static int fold_balloon_outgoing_normal = drawableid("fold_balloon_outgoing_normal");
        public static int fold_balloon_outgoing_normal_ext = drawableid("fold_balloon_outgoing_normal_ext");
        public static int foldv2_balloon_incoming_normal = drawableid("foldv2_balloon_incoming_normal");
        public static int foldv2_balloon_incoming_normal_ext = drawableid("foldv2_balloon_incoming_normal_ext");
        public static int foldv2_balloon_outgoing_normal = drawableid("foldv2_balloon_outgoing_normal");
        public static int foldv2_balloon_outgoing_normal_ext = drawableid("foldv2_balloon_outgoing_normal_ext");
        public static int md_balloon_incoming_normal = drawableid("md_balloon_incoming_normal");
        public static int md_balloon_incoming_normal_ext = drawableid("md_balloon_incoming_normal_ext");
        public static int md_balloon_outgoing_normal = drawableid("md_balloon_outgoing_normal");
        public static int md_balloon_outgoing_normal_ext = drawableid("md_balloon_outgoing_normal_ext");
        public static int round_balloon_incoming_normal = drawableid("round_balloon_incoming_normal");
        public static int round_balloon_incoming_normal_ext = drawableid("round_balloon_incoming_normal_ext");
        public static int round_balloon_outgoing_normal = drawableid("round_balloon_outgoing_normal");
        public static int round_balloon_outgoing_normal_ext = drawableid("round_balloon_outgoing_normal_ext");
        public static int message_unsent = drawableid("message_unsent");
        public static int message_unsent_onmedia = drawableid("message_unsent_onmedia");
        public static int message_got_receipt_from_server = drawableid("message_got_receipt_from_server");
        public static int message_got_receipt_from_server_onmedia = drawableid("message_got_receipt_from_server_onmedia");
        public static int message_got_receipt_from_target = drawableid("message_got_receipt_from_target");
        public static int message_got_receipt_from_target_onmedia = drawableid("message_got_receipt_from_target_onmedia");
        public static int message_got_read_receipt_from_target = drawableid("message_got_read_receipt_from_target");
        public static int message_got_read_receipt_from_target_onmedia = drawableid("message_got_read_receipt_from_target_onmedia");
        public static int bbm_message_unsent = drawableid("bbm_message_unsent");
        public static int bbm_message_unsent_onmedia = drawableid("bbm_message_unsent_onmedia");
        public static int bbm_message_got_receipt_from_server = drawableid("bbm_message_got_receipt_from_server");
        public static int bbm_message_got_receipt_from_server_onmedia = drawableid("bbm_message_got_receipt_from_server_onmedia");
        public static int bbm_message_got_receipt_from_target = drawableid("bbm_message_got_receipt_from_target");
        public static int bbm_message_got_receipt_from_target_onmedia = drawableid("bbm_message_got_receipt_from_target_onmedia");
        public static int bbm_message_got_read_receipt_from_target = drawableid("bbm_message_got_read_receipt_from_target");
        public static int bbm_message_got_read_receipt_from_target_onmedia = drawableid("bbm_message_got_read_receipt_from_target_onmedia");
        public static int bpg_message_unsent_2 = drawableid("bpg_message_unsent");
        public static int bpg_message_unsent_onmedia = drawableid("bpg_message_unsent_onmedia");
        public static int bpg_message_got_receipt_from_server = drawableid("bpg_message_got_receipt_from_server");
        public static int bpg_message_got_receipt_from_server_onmedia = drawableid("bpg_message_got_receipt_from_server_onmedia");
        public static int bpg_message_got_receipt_from_target = drawableid("bpg_message_got_receipt_from_target");
        public static int bpg_message_got_receipt_from_target_onmedia = drawableid("bpg_message_got_receipt_from_target_onmedia");
        public static int bpg_message_got_read_receipt_from_target = drawableid("bpg_message_got_read_receipt_from_target");
        public static int bpg_message_got_read_receipt_from_target_onmedia = drawableid("bpg_message_got_read_receipt_from_target_onmedia");
        public static int circle_message_unsent = drawableid("circle_message_unsent");
        public static int circle_message_unsent_onmedia = drawableid("circle_message_unsent_onmedia");
        public static int circle_message_got_receipt_from_server = drawableid("circle_message_got_receipt_from_server");
        public static int circle_message_got_receipt_from_server_onmedia = drawableid("circle_message_got_receipt_from_server_onmedia");
        public static int circle_message_got_receipt_from_target = drawableid("circle_message_got_receipt_from_target");
        public static int circle_message_got_receipt_from_target_onmedia = drawableid("circle_message_got_receipt_from_target_onmedia");
        public static int circle_message_got_read_receipt_from_target = drawableid("circle_message_got_read_receipt_from_target");
        public static int circle_message_got_read_receipt_from_target_onmedia = drawableid("circle_message_got_read_receipt_from_target_onmedia");
        public static int circles_message_unsent = drawableid("circles_message_unsent");
        public static int circles_message_unsent_onmedia = drawableid("circles_message_unsent_onmedia");
        public static int circles_message_got_receipt_from_server = drawableid("circles_message_got_receipt_from_server");
        public static int circles_message_got_receipt_from_server_onmedia = drawableid("circles_message_got_receipt_from_server_onmedia");
        public static int circles_message_got_receipt_from_target = drawableid("circles_message_got_receipt_from_target");
        public static int circles_message_got_receipt_from_target_onmedia = drawableid("circles_message_got_receipt_from_target_onmedia");
        public static int circles_message_got_read_receipt_from_target = drawableid("circles_message_got_read_receipt_from_target");
        public static int circles_message_got_read_receipt_from_target_onmedia = drawableid("circles_message_got_read_receipt_from_target_onmedia");
        public static int coalfield_message_unsent = drawableid("coalfield_message_unsent");
        public static int coalfield_message_unsent_onmedia = drawableid("coalfield_message_unsent_onmedia");
        public static int coalfield_message_got_receipt_from_server = drawableid("coalfield_message_got_receipt_from_server");
        public static int coalfield_message_got_receipt_from_server_onmedia = drawableid("coalfield_message_got_receipt_from_server_onmedia");
        public static int coalfield_message_got_receipt_from_target = drawableid("coalfield_message_got_receipt_from_target");
        public static int coalfield_message_got_receipt_from_target_onmedia = drawableid("coalfield_message_got_receipt_from_target_onmedia");
        public static int coalfield_message_got_read_receipt_from_target = drawableid("coalfield_message_got_read_receipt_from_target");
        public static int coalfield_message_got_read_receipt_from_target_onmedia = drawableid("coalfield_message_got_read_receipt_from_target_onmedia");
        public static int altcrayon_message_unsent = drawableid("altcrayon_message_unsent");
        public static int altcrayon_message_unsent_onmedia = drawableid("altcrayon_message_unsent_onmedia");
        public static int altcrayon_message_got_receipt_from_server = drawableid("altcrayon_message_got_receipt_from_server");
        public static int altcrayon_message_got_receipt_from_server_onmedia = drawableid("altcrayon_message_got_receipt_from_server_onmedia");
        public static int altcrayon_message_got_receipt_from_target = drawableid("altcrayon_message_got_receipt_from_target");
        public static int altcrayon_message_got_receipt_from_target_onmedia = drawableid("altcrayon_message_got_receipt_from_target_onmedia");
        public static int altcrayon_message_got_read_receipt_from_target = drawableid("altcrayon_message_got_read_receipt_from_target");
        public static int altcrayon_message_got_read_receipt_from_target_onmedia = drawableid("altcrayon_message_got_read_receipt_from_target_onmedia");
        public static int flatcircles_message_unsent = drawableid("flatcircles_message_unsent");
        public static int flatcircles_message_unsent_onmedia = drawableid("flatcircles_message_unsent_onmedia");
        public static int flatcircles_message_got_receipt_from_server = drawableid("flatcircles_message_got_receipt_from_server");
        public static int flatcircles_message_got_receipt_from_server_onmedia = drawableid("flatcircles_message_got_receipt_from_server_onmedia");
        public static int flatcircles_message_got_receipt_from_target = drawableid("flatcircles_message_got_receipt_from_target");
        public static int flatcircles_message_got_receipt_from_target_onmedia = drawableid("flatcircles_message_got_receipt_from_target_onmedia");
        public static int flatcircles_message_got_read_receipt_from_target = drawableid("flatcircles_message_got_read_receipt_from_target");
        public static int flatcircles_message_got_read_receipt_from_target_onmedia = drawableid("flatcircles_message_got_read_receipt_from_target_onmedia");
        public static int google_message_unsent = drawableid("google_message_unsent");
        public static int google_message_unsent_onmedia = drawableid("google_message_unsent_onmedia");
        public static int google_message_got_receipt_from_server = drawableid("google_message_got_receipt_from_server");
        public static int google_message_got_receipt_from_server_onmedia = drawableid("google_message_got_receipt_from_server_onmedia");
        public static int google_message_got_receipt_from_target = drawableid("google_message_got_receipt_from_target");
        public static int google_message_got_receipt_from_target_onmedia = drawableid("google_message_got_receipt_from_target_onmedia");
        public static int google_message_got_read_receipt_from_target = drawableid("google_message_got_read_receipt_from_target");
        public static int google_message_got_read_receipt_from_target_onmedia = drawableid("google_message_got_read_receipt_from_target_onmedia");
        public static int ios_message_unsent = drawableid("ios_message_unsent");
        public static int ios_message_unsent_onmedia = drawableid("ios_message_unsent_onmedia");
        public static int ios_message_got_receipt_from_server = drawableid("ios_message_got_receipt_from_server");
        public static int ios_message_got_receipt_from_server_onmedia = drawableid("ios_message_got_receipt_from_server_onmedia");
        public static int ios_message_got_receipt_from_target = drawableid("ios_message_got_receipt_from_target");
        public static int ios_message_got_receipt_from_target_onmedia = drawableid("ios_message_got_receipt_from_target_onmedia");
        public static int ios_message_got_read_receipt_from_target = drawableid("ios_message_got_read_receipt_from_target");
        public static int ios_message_got_read_receipt_from_target_onmedia = drawableid("ios_message_got_read_receipt_from_target_onmedia");
        public static int hike_message_unsent = drawableid("hike_message_unsent");
        public static int hike_message_unsent_onmedia = drawableid("hike_message_unsent_onmedia");
        public static int hike_message_got_receipt_from_server = drawableid("hike_message_got_receipt_from_server");
        public static int hike_message_got_receipt_from_server_onmedia = drawableid("hike_message_got_receipt_from_server_onmedia");
        public static int hike_message_got_receipt_from_target = drawableid("hike_message_got_receipt_from_target");
        public static int hike_message_got_receipt_from_target_onmedia = drawableid("hike_message_got_receipt_from_target_onmedia");
        public static int hike_message_got_read_receipt_from_target = drawableid("hike_message_got_read_receipt_from_target");
        public static int hike_message_got_read_receipt_from_target_onmedia = drawableid("hike_message_got_read_receipt_from_target_onmedia");
        public static int letter_message_unsent = drawableid("letter_message_unsent");
        public static int letter_message_unsent_onmedia = drawableid("letter_message_unsent_onmedia");
        public static int letter_message_got_receipt_from_server = drawableid("letter_message_got_receipt_from_server");
        public static int letter_message_got_receipt_from_server_onmedia = drawableid("letter_message_got_receipt_from_server_onmedia");
        public static int letter_message_got_receipt_from_target = drawableid("letter_message_got_receipt_from_target");
        public static int letter_message_got_receipt_from_target_onmedia = drawableid("letter_message_got_receipt_from_target_onmedia");
        public static int letter_message_got_read_receipt_from_target = drawableid("letter_message_got_read_receipt_from_target");
        public static int letter_message_got_read_receipt_from_target_onmedia = drawableid("letter_message_got_read_receipt_from_target_onmedia");
        public static int messenger_message_unsent = drawableid("messenger_message_unsent");
        public static int messenger_message_unsent_onmedia = drawableid("messenger_message_unsent_onmedia");
        public static int messenger_message_got_receipt_from_server = drawableid("messenger_message_got_receipt_from_server");
        public static int messenger_message_got_receipt_from_server_onmedia = drawableid("messenger_message_got_receipt_from_server_onmedia");
        public static int messenger_message_got_receipt_from_target = drawableid("messenger_message_got_receipt_from_target");
        public static int messenger_message_got_receipt_from_target_onmedia = drawableid("messenger_message_got_receipt_from_target_onmedia");
        public static int messenger_message_got_read_receipt_from_target = drawableid("messenger_message_got_read_receipt_from_target");
        public static int messenger_message_got_read_receipt_from_target_onmedia = drawableid("messenger_message_got_read_receipt_from_target_onmedia");
        public static int smiley_message_unsent = drawableid("smiley_message_unsent");
        public static int smiley_message_unsent_onmedia = drawableid("smiley_message_unsent_onmedia");
        public static int smiley_message_got_receipt_from_server = drawableid("smiley_message_got_receipt_from_server");
        public static int smiley_message_got_receipt_from_server_onmedia = drawableid("smiley_message_got_receipt_from_server_onmedia");
        public static int smiley_message_got_receipt_from_target = drawableid("smiley_message_got_receipt_from_target");
        public static int smiley_message_got_receipt_from_target_onmedia = drawableid("smiley_message_got_receipt_from_target_onmedia");
        public static int smiley_message_got_read_receipt_from_target = drawableid("smiley_message_got_read_receipt_from_target");
        public static int smiley_message_got_read_receipt_from_target_onmedia = drawableid("smiley_message_got_read_receipt_from_target_onmedia");
        public static int traffic_message_unsent = drawableid("traffic_message_unsent");
        public static int traffic_message_unsent_onmedia = drawableid("traffic_message_unsent_onmedia");
        public static int traffic_message_got_receipt_from_server = drawableid("traffic_message_got_receipt_from_server");
        public static int traffic_message_got_receipt_from_server_onmedia = drawableid("traffic_message_got_receipt_from_server_onmedia");
        public static int traffic_message_got_receipt_from_target = drawableid("traffic_message_got_receipt_from_target");
        public static int traffic_message_got_receipt_from_target_onmedia = drawableid("traffic_message_got_receipt_from_target_onmedia");
        public static int traffic_message_got_read_receipt_from_target = drawableid("traffic_message_got_read_receipt_from_target");
        public static int traffic_message_got_read_receipt_from_target_onmedia = drawableid("traffic_message_got_read_receipt_from_target_onmedia");
        public static int twitter_message_unsent = drawableid("twitter_message_unsent");
        public static int twitter_message_unsent_onmedia = drawableid("twitter_message_unsent_onmedia");
        public static int twitter_message_got_receipt_from_server = drawableid("twitter_message_got_receipt_from_server");
        public static int twitter_message_got_receipt_from_server_onmedia = drawableid("twitter_message_got_receipt_from_server_onmedia");
        public static int twitter_message_got_receipt_from_target = drawableid("twitter_message_got_receipt_from_target");
        public static int twitter_message_got_receipt_from_target_onmedia = drawableid("twitter_message_got_receipt_from_target_onmedia");
        public static int twitter_message_got_read_receipt_from_target = drawableid("twitter_message_got_read_receipt_from_target");
        public static int twitter_message_got_read_receipt_from_target_onmedia = drawableid("twitter_message_got_read_receipt_from_target_onmedia");
        public static int newwaca_message_unsent = drawableid("newwaca_message_unsent");
        public static int newwaca_message_unsent_onmedia = drawableid("newwaca_message_unsent_onmedia");
        public static int newwaca_message_got_receipt_from_server = drawableid("newwaca_message_got_receipt_from_server");
        public static int newwaca_message_got_receipt_from_server_onmedia = drawableid("newwaca_message_got_receipt_from_server_onmedia");
        public static int newwaca_message_got_receipt_from_target = drawableid("newwaca_message_got_receipt_from_target");
        public static int newwaca_message_got_receipt_from_target_onmedia = drawableid("newwaca_message_got_receipt_from_target_onmedia");
        public static int newwaca_message_got_read_receipt_from_target = drawableid("newwaca_message_got_read_receipt_from_target");
        public static int newwaca_message_got_read_receipt_from_target_onmedia = drawableid("newwaca_message_got_read_receipt_from_target_onmedia");
        public static int oldwaca_message_unsent = drawableid("oldwaca_message_unsent");
        public static int oldwaca_message_unsent_onmedia = drawableid("oldwaca_message_unsent_onmedia");
        public static int oldwaca_message_got_receipt_from_server = drawableid("oldwaca_message_got_receipt_from_server");
        public static int oldwaca_message_got_receipt_from_server_onmedia = drawableid("oldwaca_message_got_receipt_from_server_onmedia");
        public static int oldwaca_message_got_receipt_from_target = drawableid("oldwaca_message_got_receipt_from_target");
        public static int oldwaca_message_got_receipt_from_target_onmedia = drawableid("oldwaca_message_got_receipt_from_target_onmedia");
        public static int oldwaca_message_got_read_receipt_from_target = drawableid("oldwaca_message_got_read_receipt_from_target");
        public static int oldwaca_message_got_read_receipt_from_target_onmedia = drawableid("oldwaca_message_got_read_receipt_from_target_onmedia");
        public static int tb_message_unsent = drawableid("tb_message_unsent");
        public static int tb_message_unsent_onmedia = drawableid("tb_message_unsent_onmedia");
        public static int tb_message_got_receipt_from_server = drawableid("tb_message_got_receipt_from_server");
        public static int tb_message_got_receipt_from_server_onmedia = drawableid("tb_message_got_receipt_from_server_onmedia");
        public static int tb_message_got_receipt_from_target = drawableid("tb_message_got_receipt_from_target");
        public static int tb_message_got_receipt_from_target_onmedia = drawableid("tb_message_got_receipt_from_target_onmedia");
        public static int tb_message_got_read_receipt_from_target = drawableid("tb_message_got_read_receipt_from_target");
        public static int tb_message_got_read_receipt_from_target_onmedia = drawableid("tb_message_got_read_receipt_from_target_onmedia");
        public static int joaquins_message_unsent = drawableid("joaquins_message_unsent");
        public static int joaquins_message_unsent_onmedia = drawableid("joaquins_message_unsent_onmedia");
        public static int joaquins_message_got_receipt_from_server = drawableid("joaquins_message_got_receipt_from_server");
        public static int joaquins_message_got_receipt_from_server_onmedia = drawableid("joaquins_message_got_receipt_from_server_onmedia");
        public static int joaquins_message_got_receipt_from_target = drawableid("joaquins_message_got_receipt_from_target");
        public static int joaquins_message_got_receipt_from_target_onmedia = drawableid("joaquins_message_got_receipt_from_target_onmedia");
        public static int joaquins_message_got_read_receipt_from_target = drawableid("joaquins_message_got_read_receipt_from_target");
        public static int joaquins_message_got_read_receipt_from_target_onmedia = drawableid("joaquins_message_got_read_receipt_from_target_onmedia");
        public static int fab_bg_normal = drawableid("fab_bg_normal");
        public static int fab_bg_mini = drawableid("fab_bg_mini");
        public static int input_circle_green = drawableid("input_circle_green");
        public static int input_circle = drawableid("input_circle");
        public static int transparentbackrepeat = drawableid("transparentbackrepeat");
        public static int hsv32 = drawableid("hsv32");
        public static int rgb32 = drawableid("rgb32");
        public static int hex32 = drawableid("hex32");
        public static int color_seekselector = drawableid("color_seekselector");
        public static int color_selector = drawableid("color_selector");
        public static int color_hue = drawableid("color_hue");
        public static int ic_action_compose = drawableid("ic_action_compose");
        public static int ic_folder = drawableid("ic_folder");
        public static int ic_file = drawableid("ic_file");
        public static int list_selector_background = drawableid("list_selector_background");
        public static int list_selector_background_gray = drawableid("list_selector_background_gray");
    }

    public static final class id {

        public static int conversation_contact_photo_frame = idid("conversation_contact_photo_frame");
        public static int counter = idid("counter");
        public static int conversation_contact_global_status = idid("conversation_contact_global_status");
        public static int B58textmods = idid("B58textmods");
        public static int B58visualmods = idid("B58visualmods");
        public static int restart = idid("restart");
        public static int openc = idid("openc");
        public static int status = idid("status");
        public static int conversations_contact_status1 = idid("conversations_contact_status1");
        public static int hidemsg = idid("hidemsg");
        public static int imageViewIcon = idid("imageViewIcon");
        public static int image = idid("image");
        public static int submenu_showname = idid("submenu_showname");
        public static int submenu_showall = idid("submenu_showall");
        public static int submenu_hideonline = idid("submenu_hideonline");
        public static int submenu_hidelastseen = idid("submenu_hidelastseen");
        public static int submenu_limit = idid("submenu_limit");
        public static int readlog_mn = idid("readlog_mn");
        public static int input_circle = idid("input_circle");
        static int check = idid("check");
        public static int tb = idid("tb");
        public static int tb1 = idid("tb1");
        public static int tb2 = idid("tb2");
        public static int tb3 = idid("tb3");
        public static int tb4 = idid("tb4");
        public static int tb5 = idid("tb5");
        public static int tb6 = idid("tb6");
        public static int tb7 = idid("tb7");
        public static int seekBarPrefBarContainer = idid("seekBarPrefBarContainer");
        public static int seekBarPrefValue = idid("seekBarPrefValue");
        public static int seekBarPrefUnitsRight = idid("seekBarPrefUnitsRight");
        public static int seekBarPrefUnitsLeft = idid("seekBarPrefUnitsLeft");
        public static int fab_label = idid("fab_label");
        public static int fab_expand_menu_button = idid("fab_expand_menu_button");
        public static int iconOne_radio = idid("iconOne_radio");
        public static int iconTwo_radio = idid("iconTwo_radio");
        public static int iconThree_radio = idid("iconThree_radio");
        public static int iconFour_radio = idid("iconFour_radio");
        public static int iconFive_radio = idid("iconFive_radio");
        public static int iconSix_radio = idid("iconSix_radio");
        public static int iconSeven_radio = idid("iconSeven_radio");
        public static int iconEight_radio = idid("iconEight_radio");
        public static int iconNine_radio = idid("iconNine_radio");
        public static int iconTen_radio = idid("iconTen_radio");
        public static int iconEleven_radio = idid("iconEleven_radio");
        public static int iconTwelve_radio = idid("iconTwelve_radio");
        public static int iconThirteen_radio = idid("iconThirteen_radio");
        public static int iconFourteen_radio = idid("iconFourteen_radio");
        public static int iconFifteen_radio = idid("iconFifteen_radio");
        public static int iconSixteen_radio = idid("iconSixteen_radio");
        public static int iconSeventeen_radio = idid("iconSeventeen_radio");
        public static int iconEighteen_radio = idid("iconEighteen_radio");
        public static int iconNineteen_radio = idid("iconNineteen_radio");
        public static int iconTwenty_radio = idid("iconTwenty_radio");
        public static int applyIcon = idid("applyIcon");
        public static int footer_toolbar = idid("footer_toolbar");
        public static int emoji_group_layout = idid("emoji_group_layout");
        public static int etname = idid("etname");
        public static int quoted_title = idid("quoted_title");
        public static int quoted_text = idid("quoted_text");
        public static int tprivacy = idid("tprivacy");
        public static int thome = idid("thome");
        public static int tchat = idid("tchat");
        public static int tmedia = idid("tmedia");
        public static int tlog = idid("tlog");
        public static int tchooser = idid("tchooser");
        public static int aboutb58 = idid("aboutb58");
        public static int vsl = idid("vsl");
        public static int aboutus = idid("aboutus");
        public static int vfab = idid("vfab");
        public static int vhome = idid("vhome");
        public static int vchat = idid("vchat");
        public static int vthemes = idid("vthemes");
        public static int vuniversal = idid("vuniversal");
        public static int vconpick = idid("vconpick");
        public static int colorview_tabColors = idid("colorview_tabColors");
        public static int color_hex_txtError = idid("color_hex_txtError");
        public static int color_hex_edit = idid("color_hex_edit");
        public static int color_hex_btnSave = idid("color_hex_btnSave");
        public static int color_hsv_alpha = idid("color_hsv_alpha");
        public static int color_hsv_value = idid("color_hsv_value");
        public static int color_hsv_hue = idid("color_hsv_hue");
        public static int color_rgb_seekRed = idid("color_rgb_seekRed");
        public static int color_rgb_seekGreen = idid("color_rgb_seekGreen");
        public static int color_rgb_seekBlue = idid("color_rgb_seekBlue");
        public static int color_rgb_seekAlpha = idid("color_rgb_seekAlpha");
        public static int color_rgb_imgpreview = idid("color_rgb_imgpreview");
        public static int menuitem_new_conversation = idid("menuitem_new_conversation");
        public static int action_mode_bar = idid("action_mode_bar");
        public static int folder_layout = idid("folder_layout");
        public static int folder_name = idid("folder_name");
        public static int folder_icon = idid("folder_icon");
        public static int loglist = idid("loglist");
    }

    public static final class layout {

        public static final int conversations =layoutid("conversations");
        public static final int conversations_fab = layoutid("conversations_fab");
        public static final int homeo = layoutid("homeo");
        public static final int home = layoutid("home");
        public static int wamod_style_stockcentered_conversation_actionbar = layoutid("wamod_style_stockcentered_conversation_actionbar");
        public static int conversation_actionbar = layoutid("conversation_actionbar");
        public static int color_pref = layoutid("color_pref");
        public static int listitem = layoutid("listitem");
        public static int custom_privacy = layoutid("custom_privacy");
        public static int seek_bar_preference = layoutid("seek_bar_preference");
        public static int activity_icon_choose = layoutid("activity_icon_choose");
        public static int editbox_dialog = layoutid("editbox_dialog");
        public static int text_settingsl = layoutid("text_settingsl");
        public static int visual_settingsl = layoutid("visual_settingsl");
        public static int color_colorselectview = layoutid("color_colorselectview");
        public static int color_hexview = layoutid("color_hexview");
        public static int color_hsvview = layoutid("color_hsvview");
        public static int color_rgbview = layoutid("color_rgbview");
        public static int file = layoutid("file");
        public static int readlogrow = layoutid("readlogrow");
        public static int explorer = layoutid("explorer");
        public static int readlog = layoutid("readlog");
    }

    public static final class menu {
        public static final int menu_main = 2131427328;
        public static final int readlog_menu = 2131427329;
    }

    public static final class string {

        public static int B58ShareBdy = stringid("B58ShareBdy");
        public static int B58ShareSbj = stringid("B58ShareSbj");
        public static int B58Share = stringid("B58Share");
        public static int B58save = stringid("B58save");
        public static int B58cancel = stringid("B58cancel");
        public static int hidedt = stringid("hidedt");
        public static int hidedtsum = stringid("hidedtsum");
        public static int swhides = stringid("swhides");
        public static int swshows = stringid("swshows");
        public static int txtselect = stringid("txtselect");
        public static int txtselectsum = stringid("txtselectsum");
        public static int callbtn = stringid("callbtn");
        public static int callbtnsum = stringid("callbtnsum");
        public static int profpic = stringid("profpic");
        public static int profpicsum = stringid("profpicsum");
        public static int gifchoose = stringid("gifchoose");
        public static int giftenor = stringid("giftenor");
        public static int gifgiphy = stringid("gifgiphy");
        public static int chatstatus = stringid("chatstatus");
        public static int chatstatussum = stringid("chatstatussum");
        public static int centeraction = stringid("centeraction");
        public static int centeractionsum = stringid("centeractionsum");
        public static int notifychoose = stringid("notifychoose");
        public static int launcherchoose = stringid("launcherchoose");
        public static int bubblechoose = stringid("bubblechoose");
        public static int tickchoose = stringid("tickchoose");
        public static int oldui = stringid("oldui");
        public static int olduisum = stringid("olduisum");
        public static int lsmain = stringid("lsmain");
        public static int lsmainsum = stringid("lsmainsum");
        public static int actbartitle = stringid("actbartitle");
        public static int actbartitlesum = stringid("actbartitlesum");
        public static int actbarsubtitle = stringid("actbarsubtitle");
        public static int archvchat = stringid("archvchat");
        public static int archvchatsum = stringid("archvchatsum");
        public static int onlinetoast = stringid("onlinetoast");
        public static int onlinetoastsum = stringid("onlinetoastsum");
        public static int hidemsg = stringid("hidemsg");
        public static int hidemsgsum = stringid("hidemsgsum");
        public static int hidename = stringid("hidename");
        public static int hidenamesum = stringid("hidenamesum");
        public static int openlog = stringid("openlog");
        public static int clearlog = stringid("clearlog");
        public static int statusquality = stringid("statusquality");
        public static int statusimg = stringid("statusimg");
        public static int statusduration = stringid("statusduration");
        public static int imgsize = stringid("imgsize");
        public static int imgquality = stringid("imgquality");
        public static int imgresolution = stringid("imgresolution");
        public static int mediaprox = stringid("mediaprox");
        public static int mediaopswitch = stringid("mediaopswitch");
        public static int hitext = stringid("hitext");
        public static int chatcontname = stringid("chatcontname");
        public static int chatcontnamesum = stringid("chatcontnamesum");
        public static int chatscrls = stringid("chatscrls");
        public static int chatscrlssum = stringid("chatscrlssum");
        public static int chatscrstatusbg = stringid("chatscrstatusbg");
        public static int chatscrstatusbgsum = stringid("chatscrstatusbgsum");
        public static int chatscrstatus = stringid("chatscrstatus");
        public static int chatscrstatussum = stringid("chatscrstatussum");
        public static int chatscrrightb = stringid("chatscrrightb");
        public static int chatscrrightbsum = stringid("chatscrrightbsum");
        public static int chatscrrtime = stringid("chatscrrtime");
        public static int chatscrrtimesum = stringid("chatscrrtimesum");
        public static int chatscrrtext = stringid("chatscrrtext");
        public static int chatscrrtextsum = stringid("chatscrrtextsum");
        public static int chatscrleftb = stringid("chatscrleftb");
        public static int chatscrleftbsum = stringid("chatscrleftbsum");
        public static int chatscrltime = stringid("chatscrltime");
        public static int chatscrltimesum = stringid("chatscrltimesum");
        public static int chatscrltext = stringid("chatscrltext");
        public static int chatscrltextsum = stringid("chatscrltextsum");
        public static int chatscrtextentry = stringid("chatscrtextentry");
        public static int chatscrtextentrysum = stringid("chatscrtextentrysum");
        public static int chatscrentryhint = stringid("chatscrentryhint");
        public static int chatscrentryhintsum = stringid("chatscrentryhintsum");
        public static int chatscrentrybg = stringid("chatscrentrybg");
        public static int chatscrentrybgsum = stringid("chatscrentrybgsum");
        public static int chatscrsendbtn = stringid("chatscrsendbtn");
        public static int chatscrsendbtnsum = stringid("chatscrsendbtnsum");
        public static int chatscrsendbg = stringid("chatscrsendbg");
        public static int chatscrsendbgsum = stringid("chatscrsendbgsum");
        public static int chatscrquotname = stringid("chatscrquotname");
        public static int chatscrquotnamesum = stringid("chatscrquotnamesum");
        public static int chatscrquottext = stringid("chatscrquottext");
        public static int chatscrquottextsum = stringid("chatscrquottextsum");
        public static int chatscrquotbg = stringid("chatscrquotbg");
        public static int chatscrquotbgsum = stringid("chatscrquotbgsum");
        public static int chatscremojihf = stringid("chatscremojihf");
        public static int chatscremojihfsum = stringid("chatscremojihfsum");
        public static int chatscremojibg = stringid("chatscremojibg");
        public static int chatscremojibgsum = stringid("chatscremojibgsum");
        public static int conpickgr = stringid("conpickgr");
        public static int conpickgrsum = stringid("conpickgrsum");
        public static int conpickname = stringid("conpickname");
        public static int conpicknamesum = stringid("conpicknamesum");
        public static int conpickstatus = stringid("conpickstatus");
        public static int conpickstatussum = stringid("conpickstatussum");
        public static int conpicktype = stringid("conpicktype");
        public static int conpicktypesum = stringid("conpicktypesum");
        public static int hidefab = stringid("hidefab");
        public static int stockfabd = stringid("stockfabd");
        public static int stockfabe = stringid("stockfabe");
        public static int fabnormal = stringid("fabnormal");
        public static int fabnormalsum = stringid("fabnormalsum");
        public static int fabpressed = stringid("fabpressed");
        public static int fabpressedsum = stringid("fabpressedsum");
        public static int fabbg = stringid("fabbg");
        public static int fabbgsum = stringid("fabbgsum");
        public static int fabpos = stringid("fabpos");
        public static int fabpossum = stringid("fabpossum");
        public static int enablegr = stringid("enablegr");
        public static int startcolor = stringid("startcolor");
        public static int univactionbarstartsum = stringid("univactionbarstartsum");
        public static int endcolor = stringid("endcolor");
        public static int univactionbarendsum = stringid("univactionbarendsum");
        public static int gradient = stringid("gradient");
        public static int grstyle = stringid("grstyle");
        public static int disabled = stringid("disabled");
        public static int disableoption = stringid("disableoption");
        public static int univactionbar = stringid("univactionbar");
        public static int univactionbarsum = stringid("univactionbarsum");
        public static int callsinglebg = stringid("callsinglebg");
        public static int callsinglebgsum = stringid("callsinglebgsum");
        public static int enablegrsum = stringid("enablegrsum");
        public static int altrows = stringid("altrows");
        public static int altrowsbg = stringid("altrowsbg");
        public static int callsaltbggr = stringid("callsaltbggr");
        public static int callsaltbggrsum = stringid("callsaltbggrsum");
        public static int enableoption = stringid("enableoption");
        public static int callsfsbgstartsum = stringid("callsfsbgstartsum");
        public static int callsfsbgendsum = stringid("callsfsbgendsum");
        public static int callsscrbg = stringid("callsscrbg");
        public static int callsscrfsbgsum = stringid("callsscrfsbgsum");
        public static int callsbgstartsum = stringid("callsbgstartsum");
        public static int callsbgendsum = stringid("callsbgendsum");
        public static int callsscrbgsum = stringid("callsscrbgsum");
        public static int callsaltbgstartsum = stringid("callsaltbgstartsum");
        public static int callsaltbgendsum = stringid("callsaltbgendsum");
        public static int callsscraltbg = stringid("callsscraltbg");
        public static int callsscraltbgsum = stringid("callsscraltbgsum");
        public static int chatsinglebg = stringid("chatsinglebg");
        public static int chatsinglebgsum = stringid("chatsinglebgsum");
        public static int chatsaltbggr = stringid("chatsaltbggr");
        public static int chatsaltbggrsum = stringid("chatsaltbggrsum");
        public static int chatsbgstartsum = stringid("chatsbgstartsum");
        public static int chatsbgendsum = stringid("chatsbgendsum");
        public static int chatsscrbg = stringid("chatsscrbg");
        public static int chatsscrbgsum = stringid("chatsscrbgsum");
        public static int chatsaltbgstartsum = stringid("chatsaltbgstartsum");
        public static int chatsaltbgendsum = stringid("chatsaltbgendsum");
        public static int chatsscraltbg = stringid("chatsscraltbg");
        public static int chatsscraltbgsum = stringid("chatsscraltbgsum");
        public static int chatsfsbgstartsum = stringid("chatsfsbgstartsum");
        public static int chatsfsbgendsum = stringid("chatsfsbgendsum");
        public static int chatsscrfullbg = stringid("chatsscrfullbg");
        public static int chatsscrfsbgsum = stringid("chatsscrfsbgsum");
        public static int conpickbgstartsum = stringid("conpickbgstartsum");
        public static int conpickbgendsum = stringid("conpickbgendsum");
        public static int conpickbg = stringid("conpickbg");
        public static int conpickbgsum = stringid("conpickbgsum");
        public static int emojibgstartsum = stringid("emojibgstartsum");
        public static int emojibgendsum = stringid("emojibgendsum");
        public static int emojibg = stringid("emojibg");
        public static int emojibgsum = stringid("emojibgsum");
        public static int emojihfstartsum = stringid("emojihfstartsum");
        public static int emojihfendsum = stringid("emojihfendsum");
        public static int emojihf = stringid("emojihf");
        public static int emojihfsum = stringid("emojihfsum");
        public static int homebgstartsum = stringid("homebgstartsum");
        public static int homebgendsum = stringid("homebgendsum");
        public static int homebg = stringid("homebg");
        public static int homebgsum = stringid("homebgsum");
        public static int grfortabs = stringid("grfortabs");
        public static int grfortabssum = stringid("grfortabssum");
        public static int tabsbgstartsum = stringid("tabsbgstartsum");
        public static int tabsbgendsum = stringid("tabsbgendsum");
        public static int tabsbg = stringid("tabsbg");
        public static int tabsbgsum = stringid("tabsbgsum");
        public static int lbubblestartsum = stringid("lbubblestartsum");
        public static int lbubbleendsum = stringid("lbubbleendsum");
        public static int lbubble = stringid("lbubble");
        public static int lbubblesum = stringid("lbubblesum");
        public static int rbubblestartsum = stringid("rbubblestartsum");
        public static int rbubbleendsum = stringid("rbubbleendsum");
        public static int rbubble = stringid("rbubble");
        public static int rbubblesum = stringid("rbubblesum");
        public static int statussinglebg = stringid("statussinglebg");
        public static int statussinglebgsum = stringid("statussinglebgsum");
        public static int statusaltbggr = stringid("statusaltbggr");
        public static int statusaltbggrsum = stringid("statusaltbggrsum");
        public static int statussfsbgstartsum = stringid("statussfsbgstartsum");
        public static int statussfsbgendsum = stringid("statussfsbgendsum");
        public static int statussscrbg = stringid("statussscrbg");
        public static int statussscrfsbgsum = stringid("statussscrfsbgsum");
        public static int statussbgstartsum = stringid("statussbgstartsum");
        public static int statussbgendsum = stringid("statussbgendsum");
        public static int statussscrbgsum = stringid("statussscrbgsum");
        public static int statussaltbgstartsum = stringid("statussaltbgstartsum");
        public static int statussaltbgendsum = stringid("statussaltbgendsum");
        public static int statussscraltbg = stringid("statussscraltbg");
        public static int statussscraltbgsum = stringid("statussscraltbgsum");
        public static int singlebg = stringid("singlebg");
        public static int singlebgsum = stringid("singlebgsum");
        public static int globalbg = stringid("globalbg");
        public static int globalbgsum = stringid("globalbgsum");
        public static int chatscrbg = stringid("chatscrbg");
        public static int chatscrbgsum = stringid("chatscrbgsum");
        public static int statscrbg = stringid("statscrbg");
        public static int statscrbgsum = stringid("statscrbgsum");
        public static int callscrbg = stringid("callscrbg");
        public static int callscrbgsum = stringid("callscrbgsum");
        public static int tabcolor = stringid("tabcolor");
        public static int tabcolorsum = stringid("tabcolorsum");
        public static int tabtitle = stringid("tabtitle");
        public static int tabtitlesum = stringid("tabtitlesum");
        public static int textsize = stringid("textsize");
        public static int textsizesum = stringid("textsizesum");
        public static int unreadcounttab = stringid("unreadcounttab");
        public static int unreadcounttabsum = stringid("unreadcounttabsum");
        public static int unreadcounttabbg = stringid("unreadcounttabbg");
        public static int unreadcounttabbgsum = stringid("unreadcounttabbgsum");
        public static int onlinecolor = stringid("onlinecolor");
        public static int onlinecolorsum = stringid("onlinecolorsum");
        public static int lastseencolor = stringid("lastseencolor");
        public static int lastseencolorsum = stringid("lastseencolorsum");
        public static int unreadcount = stringid("unreadcount");
        public static int unreadcountsum = stringid("unreadcountsum");
        public static int unreadcountbg = stringid("unreadcountbg");
        public static int unreadcountbgsum = stringid("unreadcountbgsum");
        public static int contname = stringid("contname");
        public static int contnamesum = stringid("contnamesum");
        public static int contdate = stringid("contdate");
        public static int contdatesum = stringid("contdatesum");
        public static int sender = stringid("sender");
        public static int sendersum = stringid("sendersum");
        public static int msgcolor = stringid("msgcolor");
        public static int msgcolorsum = stringid("msgcolorsum");
        public static int stattime = stringid("stattime");
        public static int stattimesum = stringid("stattimesum");
        public static int callcount = stringid("callcount");
        public static int callcountsum = stringid("callcountsum");
        public static int calltime = stringid("calltime");
        public static int calltimesum = stringid("calltimesum");
        public static int callicon = stringid("callicon");
        public static int calliconsum = stringid("calliconsum");
        public static int savetheme = stringid("savetheme");
        public static int savethemesum = stringid("savethemesum");
        public static int loadtheme = stringid("loadtheme");
        public static int loadthemesum = stringid("loadthemesum");
        public static int cleartheme = stringid("cleartheme");
        public static int clearthemesum = stringid("clearthemesum");
        public static int downloadtheme = stringid("downloadtheme");
        public static int downloadthemesum = stringid("downloadthemesum");
        public static int actionbarc = stringid("actionbarc");
        public static int actionbarcsum = stringid("actionbarcsum");
        public static int univactionbartext = stringid("univactionbartext");
        public static int univactionbartextsum = stringid("univactionbartextsum");
        public static int univstatusbar = stringid("univstatusbar");
        public static int univstatusbarsum = stringid("univstatusbarsum");
        public static int univnavbar = stringid("univnavbar");
        public static int univnavbarsum = stringid("univnavbarsum");
        public static int color_old_color = stringid("color_old_color");
        public static int color_new_color = stringid("color_new_color");
        public static int opench = stringid("opench");
        public static int B58Restart = stringid("B58Restart");
        public static int B58textsettingstitle = stringid("B58textsettingstitle");
        public static int B58visualsettingstitle = stringid("B58visualsettingstitle");
        public static int menuitem_new = stringid("menuitem_new");
        public static int video_call_confirmation_text = stringid("video_call_confirmation_text");
        public static int cancel = stringid("cancel");
        public static int call = stringid("call");
        public static int B58copy = stringid("B58copy");
        public static int conversation_contact_online = stringid("conversation_contact_online");
        public static int conversation_last_seen = stringid("conversation_last_seen");
        public static int offline_str = stringid("offline_str");
        public static int contact_status = stringid("contact_status");
        public static int profile_photo_updated = stringid("profile_photo_updated");
        public static int profile_name = stringid("profile_name");
        public static int select_file = stringid("select_file");
        public static int saved_to = stringid("saved_to");
        public static int save_error_msg0 = stringid("save_error_msg0");
        public static int save_error_msg1 = stringid("save_error_msg1");
        public static int never = stringid("never");
        public static int restore_ok_msg = stringid("restore_ok_msg");
        public static int restore_error_msg0 = stringid("restore_error_msg0");
        public static int error_adding_participant_401 = stringid("error_adding_participant_401");
        public static int force_stop_msg = stringid("force_stop_msg");
        public static int yes = stringid("yes");
        public static int force_stop_title = stringid("force_stop_title");
        public static int no = stringid("no");
        public static int register_wait_message = stringid("register_wait_message");
    }

    public static final class style {

    }

    public static final class xml {

        public static int about = xmlid("about");
        public static int tchat = xmlid("tchat");
        public static int tchooser = xmlid("tchooser");
        public static int thome = xmlid("thome");
        public static int tlog = xmlid("tlog");
        public static int tmedia = xmlid("tmedia");
        public static int vchat = xmlid("vchat");
        public static int vconpick = xmlid("vconpick");
        public static int vfab = xmlid("vfab");
        public static int vgractionbar = xmlid("vgractionbar");
        public static int vgrcallscr = xmlid("vgrcallscr");
        public static int vgrchatscr = xmlid("vgrchatscr");
        public static int vgrconpickbg = xmlid("vgrconpickbg");
        public static int vgremojibg = xmlid("vgremojibg");
        public static int vgremojihf = xmlid("vgremojihf");
        public static int vgrglobalbg = xmlid("vgrglobalbg");
        public static int vgrglobaltabs = xmlid("vgrglobaltabs");
        public static int vgrlbubble = xmlid("vgrlbubble");
        public static int vgrrbubble = xmlid("vgrrbubble");
        public static int vgrstatusscr = xmlid("vgrstatusscr");
        public static int vhome = xmlid("vhome");
        public static int vtheme = xmlid("vtheme");
        public static int vuniversal = xmlid("vuniversal");
        public static int tprivacy = xmlid("tprivacy");

    }

}