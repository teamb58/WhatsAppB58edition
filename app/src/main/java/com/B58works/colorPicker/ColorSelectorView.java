package com.B58works.colorPicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

import com.B58works.R;

public class ColorSelectorView extends LinearLayout {
	private static final String HSV_TAG = "HSV";
	private static final String RGB_TAG = "RGB";
	private static final String HEX_TAG = "HEX";

	private RgbSelectorView rgbSelector;
	private HsvSelectorView hsvSelector;
	private HexSelectorView hexSelector;
	private TabHost tabs;
	
	private int maxHeight = 0;
	private int maxWidth = 0;

	private int color;
	
	private OnColorChangedListener listener;

	public ColorSelectorView(Context context) {
		super(context);
		init();
	}

	public ColorSelectorView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void setColor(int color) {
		setColor(color, null);
	}

	private void setColor(int color, View sender) {
		if (this.color == color)
			return;
		this.color = color;
		if (sender != hsvSelector)
			hsvSelector.setColor(color);
		if (sender != rgbSelector)
			rgbSelector.setColor(color);
		if (sender != hexSelector)
			hexSelector.setColor(color);
		onColorChanged();
	}

	public int getColor() {
		return color;
	}

	private void init() {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View contentView = inflater.inflate(R.layout.color_colorselectview,
				null);

		addView(contentView, new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));

		hsvSelector = new HsvSelectorView(getContext());
		hsvSelector.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		hsvSelector
				.setOnColorChangedListener(new HsvSelectorView.OnColorChangedListener() {
					@Override
					public void colorChanged(int color) {
						setColor(color);
					}
				});
		rgbSelector = new RgbSelectorView(getContext());
		rgbSelector.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		rgbSelector
				.setOnColorChangedListener(new RgbSelectorView.OnColorChangedListener() {
					@Override
					public void colorChanged(int color) {
						setColor(color);
					}
				});
		hexSelector = new HexSelectorView(getContext());
		hexSelector.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		hexSelector
				.setOnColorChangedListener(new HexSelectorView.OnColorChangedListener() {
					@Override
					public void colorChanged(int color) {
						setColor(color);
					}
				});

		tabs = (TabHost) contentView
				.findViewById(R.id.colorview_tabColors);
		tabs.setup();
		ColorTabContentFactory factory = new ColorTabContentFactory();
		TabSpec hsvTab = tabs.newTabSpec(HSV_TAG).setIndicator("HSV", getContext().getResources().getDrawable(R.drawable.hsv32))
				.setContent(factory);
		TabSpec rgbTab = tabs.newTabSpec(RGB_TAG).setIndicator("RGB", getContext().getResources().getDrawable(R.drawable.rgb32))
				.setContent(factory);
		TabSpec hexTab = tabs.newTabSpec(HEX_TAG).setIndicator("HEX", getContext().getResources().getDrawable(R.drawable.hex32))
				.setContent(factory);
		tabs.addTab(hsvTab);
		tabs.addTab(rgbTab);
		tabs.addTab(hexTab);
	}

	class ColorTabContentFactory implements TabContentFactory {
		@Override
		public View createTabContent(String tag) {
			if (HSV_TAG.equals(tag)) {
				return hsvSelector;
			}
			if (RGB_TAG.equals(tag)) {
				return rgbSelector;
			}
			if (HEX_TAG.equals(tag)) {
				return hexSelector;
			}
			return null;
		}
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
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if(HSV_TAG.equals(tabs.getCurrentTabTag()))
		{
			maxHeight = getMeasuredHeight();
			maxWidth = getMeasuredWidth();
		}
		setMeasuredDimension(maxWidth, maxHeight);
	}
}
