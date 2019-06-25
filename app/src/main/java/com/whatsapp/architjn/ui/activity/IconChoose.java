package com.whatsapp.architjn.ui.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.B58works.IDGen;
import com.B58works.R;
import com.B58works.settings.textmods.newSettings;

public class IconChoose extends Activity {
    Button applyChangeButton;
    int choosenIcon = 0;
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(IDGen.layout.activity_icon_choose);
        this.iconOne =  findViewById(IDGen.id.iconOne_radio);
        this.iconTwo =  findViewById(IDGen.id.iconTwo_radio);
        this.iconThree =  findViewById(IDGen.id.iconThree_radio);
        this.iconFour =  findViewById(IDGen.id.iconFour_radio);
        this.iconFive =  findViewById(IDGen.id.iconFive_radio);
        this.iconSix =  findViewById(IDGen.id.iconSix_radio);
        this.iconSeven =  findViewById(IDGen.id.iconSeven_radio);
        this.iconEight =  findViewById(IDGen.id.iconEight_radio);
        this.iconNine =  findViewById(IDGen.id.iconNine_radio);
        this.iconTen =  findViewById(IDGen.id.iconTen_radio);
        this.iconEleven =  findViewById(IDGen.id.iconEleven_radio);
        this.iconTwelve =  findViewById(IDGen.id.iconTwelve_radio);
        this.iconThirteen =  findViewById(IDGen.id.iconThirteen_radio);
        this.iconFourteen =  findViewById(IDGen.id.iconFourteen_radio);
        this.iconFifteen =  findViewById(IDGen.id.iconFifteen_radio);
        this.iconSixteen =  findViewById(IDGen.id.iconSixteen_radio);
        this.iconSeventeen =  findViewById(IDGen.id.iconSeventeen_radio);
        this.iconEighteen =  findViewById(IDGen.id.iconEighteen_radio);
        this.iconNineteen =  findViewById(IDGen.id.iconNineteen_radio);
        this.iconTwenty =  findViewById(IDGen.id.iconTwenty_radio);
        this.applyChangeButton =  findViewById(IDGen.id.applyIcon);
        this.iconOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconFive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconSix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconSeven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconEight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconNine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconTen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconEleven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconTwelve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconThirteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconFourteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconFifteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconSixteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconSeventeen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconEighteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconNineteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.iconTwenty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
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
        this.applyChangeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (IconChoose.this.choosenIcon == 1) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconone"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 2) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwo"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 3) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthree"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 4) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfour"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 5) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfive"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 6) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsix"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 7) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseven"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 8) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeight"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 9) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnine"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 10) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconten"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 11) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeleven"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 12) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwelve"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 13) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthirteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 14) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfourteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 15) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfifteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 16) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsixteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 17) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseventeen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 18) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeighteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 19) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnineteen"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else if (IconChoose.this.choosenIcon == 20) {
                    IconChoose.this.removeAll();
                    IconChoose.this.getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwenty"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                }
                IconChoose.this.startActivity(new Intent(IconChoose.this, newSettings.class));
                IconChoose.this.finish();
            }
        });
    }

    public void removeAll() {
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconone"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwo"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthree"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfour"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfive"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsix"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseven"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeight"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnine"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconten"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeleven"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwelve"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconthirteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfourteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconfifteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconsixteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconseventeen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconeighteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.iconnineteen"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.whatsapp", "com.whatsapp.icontwenty"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
