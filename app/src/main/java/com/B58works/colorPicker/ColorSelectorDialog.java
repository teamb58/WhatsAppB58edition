package com.B58works.colorPicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.B58works.R;

public class ColorSelectorDialog extends Dialog {
	private ColorSelectorView content;
	private OnColorChangedListener listener;
	private int initColor;
	private int color;
	private Button btnOld;
	private Button btnNew;
	
	public ColorSelectorDialog(Context context, OnColorChangedListener listener, int initColor) {
		super(context);
		this.listener = listener;
		this.initColor = initColor;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout mainContent = new LinearLayout(getContext());
		mainContent.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout buttonsLL = new LinearLayout(getContext());
		buttonsLL.setBackgroundResource(R.drawable.transparentbackrepeat);
		btnOld = new Button(getContext());
		btnOld.setText(getContext().getResources().getString(R.string.color_old_color));
		LinearLayout.LayoutParams paramsOld = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		paramsOld.weight = 1;
		buttonsLL.addView(btnOld, paramsOld);
		
		btnOld.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		
		btnNew = new Button(getContext());
		btnNew.setText(getContext().getResources().getString(R.string.color_new_color));
		LinearLayout.LayoutParams paramsNew = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		paramsNew.weight = 1;
		buttonsLL.addView(btnNew, paramsNew);
		
		btnNew.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.colorChanged(color);
				dismiss();
			}
		});
		
		content = new ColorSelectorView(getContext());
		content.setOnColorChangedListener(new ColorSelectorView.OnColorChangedListener() {
			@Override
			public void colorChanged(int color) {
				colorChangedInternal(color);
			}
		});
		
		LinearLayout.LayoutParams paramsContent = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		paramsContent.weight = 1;
		LinearLayout.LayoutParams paramsButtons = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		paramsButtons.weight = 0;
		
		mainContent.addView(content, paramsContent);
		mainContent.addView(buttonsLL, paramsButtons);
		
		setContentView(mainContent);

		btnOld.setBackgroundColor(initColor);
		btnOld.setTextColor(~initColor | 0xFF000000);
		
		content.setColor(initColor);
	}
	
	private void colorChangedInternal(int color)
	{
		btnNew.setBackgroundColor(color);
		btnNew.setTextColor(~color | 0xFF000000); //without alpha
		this.color = color;
	}
	
	public void setColor(int color)
	{
		content.setColor(color);
	}
	
	public interface OnColorChangedListener
	{
		public void colorChanged(int color);
	}
}
