package com.B58works;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/**
 * Created by Bharath.R(58) on 28-12-2017.
 */

public class PrivacyL extends LinearLayout implements View.OnClickListener {
    private Dialog dialog;
    private SharedPreferences.Editor edit;
    private SharedPreferences prefs;

    public PrivacyL(final Context context) {
        super(context);
        this.prefs = this.getContext().getSharedPreferences("B58privacy", 0);
        this.edit = this.prefs.edit();
        this.dialog = new Dialog(this.getContext());
        this.init();
    }

    public PrivacyL(final Context context, final AttributeSet set) {
        super(context, set);
        this.prefs = this.getContext().getSharedPreferences("B58privacy", 0);
        this.edit = this.prefs.edit();
        this.dialog = new Dialog(this.getContext());
        this.init();
    }

    private Boolean getSpecific(final String s, final String s2) {
        Boolean b;
        if (s.contains("g.us")) {
            b = Privacy.getPrivacyB("G" + s2);
        } else {
            b = Privacy.getPrivacyB("C" + s2);
        }
        return b;
    }

    private void init() {
        this.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(final View view) {
        this.dialog.setTitle((CharSequence) "Set Custom Privacy");
        this.dialog.setContentView(B58.getResID("custom_privacy", "layout"));
        final SwitchCompat switchCompat = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb", "id"));
        final SwitchCompat switchCompat2 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb1", "id"));
        final SwitchCompat switchCompat3 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb2", "id"));
        final SwitchCompat switchCompat4 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb3", "id"));
        final SwitchCompat switchCompat5 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb4", "id"));
        final SwitchCompat switchCompat6 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb5", "id"));
        final SwitchCompat switchCompat7 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb6", "id"));
        final SwitchCompat switchCompat8 = (SwitchCompat) this.dialog.findViewById(B58.getResID("tb7", "id"));
        switchCompat.setChecked(Privacy.getPrivacyB(Privacy.JID));
        switchCompat.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
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
                if (enabled) {
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRead", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HideRead"));
                    switchCompat2.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideRead"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideReceipt", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HideReceipt"));
                    switchCompat3.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideReceipt"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideCompose", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HideCompose"));
                    switchCompat4.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideCompose"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRecord", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HideRecord"));
                    switchCompat5.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideRecord"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HidePlay", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HidePlay"));
                    switchCompat6.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HidePlay"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideStatus", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_HideStatus"));
                    switchCompat7.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_HideStatus"));
                    PrivacyL.this.edit.putBoolean(Privacy.JID + "_AR", (boolean) PrivacyL.this.getSpecific(Privacy.JID, "_AR"));
                    switchCompat8.setChecked(PrivacyL.this.getSpecific(Privacy.JID, "_AR"));
                    PrivacyL.this.edit.apply();
                }
            }
        });
        if (!switchCompat.isChecked()) {
            this.edit.putBoolean(Privacy.JID + "_HideRead", (boolean) this.getSpecific(Privacy.JID, "_HideRead"));
            this.edit.putBoolean(Privacy.JID + "_HideReceipt", (boolean) this.getSpecific(Privacy.JID, "_HideReceipt"));
            this.edit.putBoolean(Privacy.JID + "_HideCompose", (boolean) this.getSpecific(Privacy.JID, "_HideCompose"));
            this.edit.putBoolean(Privacy.JID + "_HideRecord", (boolean) this.getSpecific(Privacy.JID, "_HideRecord"));
            this.edit.putBoolean(Privacy.JID + "_HidePlay", (boolean) this.getSpecific(Privacy.JID, "_HidePlay"));
            this.edit.putBoolean(Privacy.JID + "_HideStatus", (boolean) this.getSpecific(Privacy.JID, "_HideStatus"));
            this.edit.putBoolean(Privacy.JID + "_AR", (boolean) this.getSpecific(Privacy.JID, "_AR"));
        }
        switchCompat2.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideRead"));
        switchCompat2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRead", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat3.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideReceipt"));
        switchCompat3.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideReceipt", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat4.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideCompose"));
        switchCompat4.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideCompose", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat5.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideRecord"));
        switchCompat5.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideRecord", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat6.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HidePlay"));
        switchCompat6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HidePlay", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat7.setChecked(Privacy.getPrivacyB(Privacy.JID + "_HideStatus"));
        switchCompat7.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_HideStatus", b);
                PrivacyL.this.edit.apply();
            }
        });
        switchCompat8.setChecked(Privacy.getPrivacyB(Privacy.JID + "_AR"));
        switchCompat8.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean b) {
                PrivacyL.this.edit.putBoolean(Privacy.JID + "_AR", b);
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
        }
        this.dialog.show();
    }
}
