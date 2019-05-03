package com.B58works.colorPicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.B58works.R;

public class HexSelectorView extends LinearLayout {

	private EditText edit;
	private int color;
	private TextView txtError;
	private Button btnSave;
	
	private OnColorChangedListener listener;
	
	public HexSelectorView(Context context) {
		super(context);
		init();
	}
	
	public HexSelectorView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init()
	{
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View content = inflater.inflate(R.layout.color_hexview, null);
		addView(content, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	
		txtError = (TextView)content.findViewById(R.id.color_hex_txtError);
		
		edit = (EditText)content.findViewById(R.id.color_hex_edit);
		btnSave = (Button)content.findViewById(R.id.color_hex_btnSave);
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try
				{
					String hex = edit.getText().toString();
//					String prefix = "";
					if(hex.startsWith("0x"))
					{
						hex = hex.substring(2);
//						prefix = "0x";
					}
					if(hex.startsWith("#"))
					{
						hex = hex.substring(1);
//						prefix = "#";
					}
					if(hex.length() == 6)
					{
						hex = "FF" + hex;
					}
					if(hex.length() != 8)
						throw new Exception();
					color = (int)Long.parseLong(hex, 16);
					txtError.setVisibility(GONE);
					onColorChanged();
				}
				catch(Exception e)
				{
					txtError.setVisibility(VISIBLE);
				}
			}
		});
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setColor(int color)
	{
		if(color == this.color)
			return;
		this.color = color;
		edit.setText(padLeft(Integer.toHexString(color).toUpperCase(), '0', 8));
		txtError.setVisibility(GONE);
	}
	
	private String padLeft(String string, char padChar, int size)
	{
		if(string.length() >= size)
			return string;
		StringBuilder result = new StringBuilder();
		for(int i=string.length(); i<size; i++)
			result.append(padChar);
		result.append(string);
		return result.toString();
	}
	
	private void onColorChanged()
	{
		if(listener != null)
			listener.colorChanged(getColor());
	}
	
	public void setOnColorChangedListener(OnColorChangedListener listener)
	{
		this.listener = listener;
	}
	
	public interface OnColorChangedListener
	{
		public void colorChanged(int color);
	}
}
