package com.B58works;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class PrivacyL extends LinearLayout implements View.OnClickListener {
    private Dialog dialog;
    private SharedPreferences.Editor edit;
    private SharedPreferences prefs;

    public PrivacyL(final Context context) {
        super(context);
        prefs = getContext().getSharedPreferences("B58privacy", 0);
        edit = prefs.edit();
        dialog = new Dialog(getContext());
        init();
    }

    public PrivacyL(final Context context, final AttributeSet set) {
        super(context, set);
        prefs = getContext().getSharedPreferences("B58privacy", 0);
        edit = prefs.edit();
        dialog = new Dialog(getContext());
        init();
    }

    private Boolean getSpecific(final String s, final String s2) {
        if (s.contains("g.us"))
            return Privacy.getPrivacyB("G" + s2);
        else
            return Privacy.getPrivacyB("C" + s2);

    }

    private void init() {
        this.setOnClickListener( this);
    }

    public void onClick(final View view) {
        this.dialog.setTitle( "Set Custom Privacy");
        this.dialog.setContentView(R.layout.custom_privacy);
        final SwitchCompat switchCompat =  this.dialog.findViewById(R.id.tb);
        final SwitchCompat switchCompat2 = this.dialog.findViewById(R.id.tb1);
        final SwitchCompat switchCompat3 = this.dialog.findViewById(R.id.tb2);
        final SwitchCompat switchCompat4 = this.dialog.findViewById(R.id.tb3);
        final SwitchCompat switchCompat5 = this.dialog.findViewById(R.id.tb4);
        final SwitchCompat switchCompat6 = this.dialog.findViewById(R.id.tb5);
        final SwitchCompat switchCompat7 = this.dialog.findViewById(R.id.tb6);
        final SwitchCompat switchCompat8 = this.dialog.findViewById(R.id.tb7);
        final SwitchCompat switchCompat9 = this.dialog.findViewById(R.id.tb8);
        switchCompat.setChecked(Privacy.getPrivacyB(Privacy.JID));
        switchCompat.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean enabled) {
                PrivacyL.this.edit.putBoolean(Privacy.JID, enabled);
                PrivacyL.this.edit.apply();
                switchCompat2.setEnabled(enabled);
                switchCompat3.setEnabled(enabled);
                switchCompat4.setEnabled(enabled);
                switchCompat5.setEnabled(enabled);
                switchCompat6.setEnabled(enabled);
                switchCompat7.setEnabled(enabled);
                switchCompat8.setEnabled(enabled);
                switchCompat9.setEnabled(enabled);
                if (enabled) {
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRead",  PrivacyL.this.getSpecific(Privacy.JID, "_HideRead"));
                    switchCompat2.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideRead"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideReceipt",  PrivacyL.this.getSpecific(Privacy.JID, "_HideReceipt"));
                    switchCompat3.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideReceipt"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideCompose",  PrivacyL.this.getSpecific(Privacy.JID, "_HideCompose"));
                    switchCompat4.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideCompose"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRecord",  PrivacyL.this.getSpecific(Privacy.JID, "_HideRecord"));
                    switchCompat5.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideRecord"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HidePlay",  PrivacyL.this.getSpecific(Privacy.JID, "_HidePlay"));
                    switchCompat6.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HidePlay"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideStatus",  PrivacyL.this.getSpecific(Privacy.JID, "_HideStatus"));
                    switchCompat7.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideStatus"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_AR",  PrivacyL.this.getSpecific(Privacy.JID, "_AR"));
                    switchCompat8.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_AR"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideForward",  PrivacyL.this.getSpecific(Privacy.JID, "_HideForward"));
                    switchCompat9.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideForward"));
                    PrivacyL.this.edit.apply();
                }
            }
        });
        if (!switchCompat.isChecked()) {
            this.edit.putBoolean(Privacy.JID + "_HideRead",  this.getSpecific(Privacy.JID, "_HideRead"));
            this.edit.putBoolean(Privacy.JID + "_HideReceipt",  this.getSpecific(Privacy.JID, "_HideReceipt"));
            this.edit.putBoolean(Privacy.JID + "_HideCompose",  this.getSpecific(Privacy.JID, "_HideCompose"));
            this.edit.putBoolean(Privacy.JID + "_HideRecord",  this.getSpecific(Privacy.JID, "_HideRecord"));
            this.edit.putBoolean(Privacy.JID + "_HidePlay",  this.getSpecific(Privacy.JID, "_HidePlay"));
            this.edit.putBoolean(Privacy.JID + "_HideStatus",  this.getSpecific(Privacy.JID, "_HideStatus"));
            this.edit.putBoolean(Privacy.JID + "_AR",  this.getSpecific(Privacy.JID, "_AR"));
            this.edit.putBoolean(Privacy.JID + "_HideForward",  this.getSpecific(Privacy.JID, "_HideForward"));
        }
        switchCompat2.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideRead"));
        switchCompat2.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRead", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat3.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideReceipt"));
        switchCompat3.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideReceipt", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat4.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideCompose"));
        switchCompat4.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideCompose", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat5.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideRecord"));
        switchCompat5.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRecord", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat6.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HidePlay"));
        switchCompat6.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HidePlay", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat7.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideStatus"));
        switchCompat7.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideStatus", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat8.setChecked(Privacy.getPrivacyB(Privacy.JID + "_AR"));
        switchCompat8.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_AR", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat9.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideForward"));
        switchCompat9.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideForward", b);
                PrivacyL.this.edit.apply();
            }
        });
        if (!switchCompat.isChecked()) {
            switchCompat2.setEnabled(false);
            switchCompat3.setEnabled(false);
            switchCompat4.setEnabled(false);
            switchCompat5.setEnabled(false);
            switchCompat6.setEnabled(false);
            switchCompat7.setEnabled(false);
            switchCompat8.setEnabled(false);
            switchCompat9.setEnabled(false);
        }
        this.dialog.show();
    }
}
