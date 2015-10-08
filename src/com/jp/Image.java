package com.jp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Image {
	
	private int name;
	private Bitmap image;
	
	public Image(int n) {
		name = n;
	}
	
	public void loadImage(Context cx) {
		image = BitmapFactory.decodeResource(cx.getResources(), name);
		
		/*
		ImageView imageView = new ImageView(c.getApplicationContext());
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		Bitmap image = BitmapFactory.decodeResource(c.getResources(), name);
		imageView.setImageBitmap(image);
		RelativeLayout rl = (RelativeLayout) findViewById(R.layout.livewallpaper);
		rl.addView(imageView, lp);
		*/
	}
	
	public void drawImage(Canvas c, int x, int y) {
		c.drawBitmap(image, x, y, null);
	}
	
}
