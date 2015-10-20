package com.jp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Image {
	
	private int name;
	private Bitmap image;
	
	public Image(int n) {
		name = n;
	}
	
	public void loadImage(Context cx) {
		image = BitmapFactory.decodeResource(cx.getResources(), name);
	}
	
	public void drawImage(Canvas c, int x, int y) {
		c.drawBitmap(image, x, y, null);
	}
	
}