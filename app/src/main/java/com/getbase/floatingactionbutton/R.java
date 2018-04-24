package com.getbase.floatingactionbutton;

/**
 * Created by Bharath.R(58) on 31-03-2018.
 */

import static com.B58works.B58.getResID;

public final class R
{
    public static final class attr
    {
        public static final int fab_addButtonColorNormal = getResID("fab_addButtonColorNormal","attr");
        public static final int fab_addButtonColorPressed = getResID("fab_addButtonColorPressed","attr");
        public static final int fab_addButtonPlusIconColor = getResID("fab_addButtonPlusIconColor","attr");
        public static final int fab_colorNormal = getResID("fab_colorNormal","attr");
        public static final int fab_colorPressed = getResID("fab_colorPressed","attr");
        public static final int fab_expandDirection = getResID("fab_expandDirection","attr");
        public static final int fab_icon = getResID("fab_icon","attr");
        public static final int fab_labelStyle = getResID("fab_labelStyle","attr");
        public static final int fab_plusIconColor = getResID("fab_plusIconColor","attr");
        public static final int fab_size = getResID("fab_size","attr");
        public static final int fab_title = getResID("fab_title","attr");
    }

    public static final class dimen
    {
        public static final int fab_actions_spacing = getResID("fab_actions_spacing","dimen");
        public static final int fab_icon_size = getResID("fab_icon_size","dimen");;
        public static final int fab_labels_margin = getResID("fab_labels_margin","dimen");
        public static final int fab_plus_icon_size = getResID("fab_plus_icon_size","dimen");
        public static final int fab_plus_icon_stroke = getResID("fab_plus_icon_stroke","dimen");
        public static final int fab_shadow_offset = getResID("fab_shadow_offset","dimen");
        public static final int fab_shadow_radius = getResID("fab_shadow_radius","dimen");
        public static final int fab_size_mini = getResID("fab_size_mini","dimen");
        public static final int fab_size_normal = getResID("fab_size_normal","dimen");
        public static final int fab_stroke_width = getResID("fab_stroke_width","dimen");
    }

    public static final class drawable
    {
        public static final int fab_bg_mini = getResID("fab_bg_mini","drawable");
        public static final int fab_bg_normal = getResID("fab_bg_normal","drawable");
    }

    public static final class id
    {
        public static final int down = getResID("down","id");
        public static final int fab_expand_menu_button = getResID("fab_expand_menu_button","id");
        public static final int fab_label = getResID("fab_label","id");
        public static final int left = getResID("left","id");
        public static final int mini = getResID("mini","id");
        public static final int normal = getResID("normal","id");
        public static final int right = getResID("right","id");
        public static final int up = getResID("up","id");
    }

    public static final class styleable
    {
        public static final int[] AddFloatingActionButton;
        public static final int AddFloatingActionButton_fab_plusIconColor = 0;
        public static final int[] FloatingActionButton;
        public static final int FloatingActionButton_fab_colorNormal = 1;
        public static final int FloatingActionButton_fab_colorPressed = 0;
        public static final int FloatingActionButton_fab_icon = 2;
        public static final int FloatingActionButton_fab_size = 3;
        public static final int FloatingActionButton_fab_title = 4;
        public static final int[] FloatingActionsMenu;
        public static final int FloatingActionsMenu_fab_addButtonColorNormal = 1;
        public static final int FloatingActionsMenu_fab_addButtonColorPressed = 0;
        public static final int FloatingActionsMenu_fab_addButtonPlusIconColor = 2;
        public static final int FloatingActionsMenu_fab_expandDirection = 4;
        public static final int FloatingActionsMenu_fab_labelStyle = 3;

        static {
            AddFloatingActionButton = new int[] { getResID("fab_colorNormal","attr") };
            FloatingActionButton = new int[] { getResID("fab_plusIconColor","attr"), getResID("fab_colorPressed","attr"), getResID("fab_icon","attr"), getResID("fab_size","attr"), getResID("fab_title","attr") };
            FloatingActionsMenu = new int[] { getResID("fab_addButtonColorPressed","attr"), getResID("fab_addButtonColorNormal","attr"), getResID("fab_addButtonPlusIconColor","attr"), getResID("fab_labelStyle","attr"), getResID("fab_expandDirection","attr") };
        }
    }
}

