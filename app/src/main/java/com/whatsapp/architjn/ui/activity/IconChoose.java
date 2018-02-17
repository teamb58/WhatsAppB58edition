package com.whatsapp.architjn.ui.activity;

import android.app.*;
import android.os.*;
import com.whatsapp.architjn.*;
import android.widget.*;
import android.view.*;
import com.B58works.*;
import android.content.*;

public class IconChoose extends Activity
{
    Button applyChangeButton;
    int choosenIcon;
    RadioButton iconEight;
    RadioButton iconEighteen;
    RadioButton iconEleven;
    RadioButton iconFifteen;
    RadioButton iconFive;
    RadioButton iconFour;
    RadioButton iconFourteen;
    RadioButton iconNine;
    RadioButton iconNineteen;
    RadioButton iconOne;
    RadioButton iconSeven;
    RadioButton iconSeventeen;
    RadioButton iconSix;
    RadioButton iconSixteen;
    RadioButton iconTen;
    RadioButton iconThirteen;
    RadioButton iconThree;
    RadioButton iconTwelve;
    RadioButton iconTwenty;
    RadioButton iconTwo;
    
    public IconChoose() {
        this.choosenIcon = 0;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(others.getResId((Context)this, "activity_icon_choose", "layout"));
        this.iconOne = (RadioButton)this.findViewById(others.getResId((Context)this, "iconOne_radio", "id"));
        this.iconTwo = (RadioButton)this.findViewById(others.getResId((Context)this, "iconTwo_radio", "id"));
        this.iconThree = (RadioButton)this.findViewById(others.getResId((Context)this, "iconThree_radio", "id"));
        this.iconFour = (RadioButton)this.findViewById(others.getResId((Context)this, "iconFour_radio", "id"));
        this.iconFive = (RadioButton)this.findViewById(others.getResId((Context)this, "iconFive_radio", "id"));
        this.iconSix = (RadioButton)this.findViewById(others.getResId((Context)this, "iconSix_radio", "id"));
        this.iconSeven = (RadioButton)this.findViewById(others.getResId((Context)this, "iconSeven_radio", "id"));
        this.iconEight = (RadioButton)this.findViewById(others.getResId((Context)this, "iconEight_radio", "id"));
        this.iconNine = (RadioButton)this.findViewById(others.getResId((Context)this, "iconNine_radio", "id"));
        this.iconTen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconTen_radio", "id"));
        this.iconEleven = (RadioButton)this.findViewById(others.getResId((Context)this, "iconEleven_radio", "id"));
        this.iconTwelve = (RadioButton)this.findViewById(others.getResId((Context)this, "iconTwelve_radio", "id"));
        this.iconThirteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconThirteen_radio", "id"));
        this.iconFourteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconFourteen_radio", "id"));
        this.iconFifteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconFifteen_radio", "id"));
        this.iconSixteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconSixteen_radio", "id"));
        this.iconSeventeen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconSeventeen_radio", "id"));
        this.iconEighteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconEighteen_radio", "id"));
        this.iconNineteen = (RadioButton)this.findViewById(others.getResId((Context)this, "iconNineteen_radio", "id"));
        this.iconTwenty = (RadioButton)this.findViewById(others.getResId((Context)this, "iconTwenty_radio", "id"));
        this.applyChangeButton = (Button)this.findViewById(others.getResId((Context)this, "applyIcon", "id"));
        this.iconOne.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 1;
                    IconChoose.this.iconOne.setChecked(true);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconTwo.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 2;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(true);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconThree.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 3;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(true);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconFour.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 4;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(true);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconFive.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 5;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(true);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconSix.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 6;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(true);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconSeven.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 7;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(true);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconEight.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 8;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(true);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconNine.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 9;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(true);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconTen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 10;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(true);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconEleven.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 11;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(true);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconTwelve.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 12;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(true);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconThirteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 13;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(true);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconFourteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 14;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(true);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconFifteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 15;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(true);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconSixteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 16;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(true);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconSeventeen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 17;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(true);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconEighteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 18;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(true);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconNineteen.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 19;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(true);
                    IconChoose.this.iconTwenty.setChecked(false);
                }
            }
        });
        this.iconTwenty.setOnCheckedChangeListener((CompoundButton$OnCheckedChangeListener)new CompoundButton$OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                if (b) {
                    IconChoose.this.choosenIcon = 20;
                    IconChoose.this.iconOne.setChecked(false);
                    IconChoose.this.iconTwo.setChecked(false);
                    IconChoose.this.iconThree.setChecked(false);
                    IconChoose.this.iconFour.setChecked(false);
                    IconChoose.this.iconFive.setChecked(false);
                    IconChoose.this.iconSix.setChecked(false);
                    IconChoose.this.iconSeven.setChecked(false);
                    IconChoose.this.iconEight.setChecked(false);
                    IconChoose.this.iconNine.setChecked(false);
                    IconChoose.this.iconTen.setChecked(false);
                    IconChoose.this.iconEleven.setChecked(false);
                    IconChoose.this.iconTwelve.setChecked(false);
                    IconChoose.this.iconThirteen.setChecked(false);
                    IconChoose.this.iconFourteen.setChecked(false);
                    IconChoose.this.iconFifteen.setChecked(false);
                    IconChoose.this.iconSixteen.setChecked(false);
                    IconChoose.this.iconSeventeen.setChecked(false);
                    IconChoose.this.iconEighteen.setChecked(false);
                    IconChoose.this.iconNineteen.setChecked(false);
                    IconChoose.this.iconTwenty.setChecked(true);
                }
            }
        });
        this.applyChangeButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (IconChoose.this.choosenIcon == 1) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconone"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 2) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwo"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 3) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthree"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 4) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfour"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 5) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfive"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 6) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsix"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 7) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseven"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 8) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeight"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 9) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnine"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 10) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconten"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 11) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeleven"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 12) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwelve"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 13) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthirteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 14) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfourteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 15) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfifteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 16) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsixteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 17) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseventeen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 18) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeighteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 19) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnineteen"), 1, 1);
                }
                else if (IconChoose.this.choosenIcon == 20) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwenty"), 1, 1);
                }
                IconChoose.this.startActivity(new Intent((Context)IconChoose.this, (Class)Settings.class));
                IconChoose.this.finish();
            }
        });
    }
    
    public void removeAll() {
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconone"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwo"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthree"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfour"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfive"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsix"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseven"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeight"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnine"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconten"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeleven"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwelve"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthirteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfourteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfifteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsixteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseventeen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeighteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnineteen"), 2, 1);
        this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwenty"), 2, 1);
    }
}
