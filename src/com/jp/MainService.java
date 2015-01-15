package com.jp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;

public class MainService extends WallpaperService {

	private final Handler mHandler = new Handler();
	
	@Override
	public Engine onCreateEngine() {
		return new RenderEngine();
	}
	
	class RenderEngine extends Engine {
		
		boolean mVisiable = true;
		private Movie mMovie;
		float r = 100;
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		float displayX = display.getWidth(); 
		float displayY = display.getHeight();
		float x = displayX;
		float y = displayY;
		Point corner1 = new Point(0, 0);
		Point corner2 = new Point(displayX, 0);
		Point corner3 = new Point(0, displayY);
		Point corner4 = new Point(displayX, displayY);
		
		//float slopeToCenter = ((corner1.getY() - corner4.getY()) / (corner1.getX() - corner4.getX()));
		//float slopeToCenter2 = ((corner2.getY() - corner3.getY()) / (corner2.getX() - corner3.getX()));
		
		AnimationPoint one = new AnimationPoint(corner1.getX() - 500, corner1.getY() - 500, displayX/2, displayY/2, 1, 1, 100);
		AnimationPoint five = new AnimationPoint(0 - 500, (corner3.getY() / 2), displayX/2, displayY/2, 1, 0, 200);
		
		AnimationPoint two = new AnimationPoint(corner2.getX() + 500, corner2.getY() - 500, displayX/2, displayY/2, -1, 1, 100);
		//AnimationPoint six = new AnimationPoint(corner2.getX() / 2, 0, displayX/2, displayY/2, 0, 1, 100);
		
		AnimationPoint three = new AnimationPoint(corner3.getX() - 470, corner3.getY() - 470, displayX/2, displayY/2, 1, -1, 100);
		AnimationPoint seven = new AnimationPoint(corner2.getX() + 500, corner4.getY() / 2, displayX/2, displayY/2, -1, 0, 200);
		
		AnimationPoint four = new AnimationPoint(corner4.getX() + 470, corner4.getY() - 470, displayX/2, displayY/2, -1, -1, 100);
		//AnimationPoint eight = new AnimationPoint(corner4.getX() / 2, corner3.getY(), displayX/2, displayY/2, 0, -1, 100);
		
		RenderEngine() {}
		
		@Override
		public void onVisibilityChanged(boolean visible) {
			mVisiable = visible;
			if(visible)
				drawFrame();
		}
		
		private final Runnable mDrawScene = new Runnable() {
			public void run() {
				drawFrame();
			}
		};
		
		void drawFrame() {
			if(!mVisiable)
				return;
			
			final SurfaceHolder holder = getSurfaceHolder();
			Canvas c = null;
			
			try {
				c = holder.lockCanvas();

				if(c != null) {
					c.drawColor(Color.MAGENTA);
					Paint p = new Paint();
					p.setColor(Color.MAGENTA);
					Paint p2 = new Paint();
					p2.setColor(Color.BLACK);
					p2.setStrokeWidth(15);
					/*
					c.drawLine(x/3, y/3, x/2, y/2, p2);
					c.drawLine(x/6*4, y/3, x/2, y/2, p2);
					c.drawLine(x/5*4, y/2, x/2, y/2, p2);
					c.drawLine(x/5, y/2, x/2, y/2, p2);
					c.drawLine(x/3, y/3*2, x/2, y/2, p2);
					c.drawLine(x/3*2, y/3*2, x/2, y/2, p2);
					*/
					c.drawLine(one.getXStart(), one.getYStart(), one.getXEnd(), one.getYEnd(), p2);
					
					c.drawLine(two.getXStart(), two.getYStart(), two.getXEnd(), two.getYEnd(), p2);
					c.drawLine(three.getXStart(), three.getYStart(), three.getXEnd(), three.getYEnd(), p2);
					c.drawLine(four.getXStart(), four.getYStart(), four.getXEnd(), four.getYEnd(), p2);
					c.drawLine(five.getXStart(), five.getYStart(), five.getXEnd(), five.getYEnd(), p2);
					//c.drawLine(six.getXStart(), six.getYStart(), six.getXEnd(), six.getYEnd(), p2);
					c.drawLine(seven.getXStart(), seven.getYStart(), seven.getXEnd(), seven.getYEnd(), p2);
					//c.drawLine(eight.getXStart(), eight.getYStart(), eight.getXEnd(), eight.getYEnd(), p2);
					
					
					float sides = 1F;
					float corners = 1.647F;
					//seven.drawAnimation3(10, 1, sides);
					//eight.drawAnimation3(10, 1, sides);
			
					if(one.getAnimationEndX() < (displayX/2)) {
						one.drawAnimation3(30, 1, corners);
					}
					if(two.getAnimationEndX() > (displayX/2)) {
						two.drawAnimation3(26, 1, corners);
					}
					if(three.getAnimationEndX() < (displayX/2)) {
						three.drawAnimation3(24, 1, corners);
					}
					if(four.getAnimationEndX() > (displayX/2)) {
						four.drawAnimation3(20, 1, corners);
					}
					if(five.getAnimationEndX() < (displayX/2)) {
						five.drawAnimation3(17, 1, sides);
					}
					if(seven.getAnimationEndX() > (displayX/2)) {
						seven.drawAnimation3(15, 1, sides);
					}
					
					
					/*
					one.drawAnimation2(s, 1, topCorners, l);
					two.drawAnimation2(s, 1, topCorners, l);
					three.drawAnimation2(s, 1, topCorners, l);
					four.drawAnimation2(s, 1, topCorners, l);
					five.drawAnimation2(s, 1, sides, l);
					six.drawAnimation2(s, 1, sides, l);
					seven.drawAnimation2(s, 1, sides, l);
					eight.drawAnimation2(s, 1, sides, l);
					*/
					/*
					two.drawAnimation(50, 50, 500);
					three.drawAnimation(45, 45, 500);
					four.drawAnimation(40, 40, 500);
					five.drawAnimation(70, 70, 500);
					six.drawAnimation(50, 50, 500);
					seven.drawAnimation(45, 45, 500);
					eight.drawAnimation(40, 40, 500);
					*/
					/*
					if(one.getAnimationX() > 1000) {
						one.setAnimationX((int)corner1.getX());
						one.setAnimationY((int)corner1.getY());
						two.setAnimationX((int)corner2.getX());
						two.setAnimationY((int)corner2.getY());
						three.setAnimationX((int)corner3.getX());
						three.setAnimationY((int)corner3.getY());
						four.setAnimationX((int)corner4.getX());
						four.setAnimationY((int)corner4.getY());
						
						five.setAnimationX(0);
						five.setAnimationY((int)corner3.getY() / 2);
						six.setAnimationX((int)corner2.getX() / 2);
						six.setAnimationY(0);
						seven.setAnimationX((int)corner2.getX());
						seven.setAnimationY((int)corner4.getY() / 2);
						eight.setAnimationX((int)corner4.getX() / 2);
						eight.setAnimationY((int)corner3.getY());
					}
					*/
					/*
					float radius = 50F;
					c.drawLine(x/5, y/4, (x/2) + radius * 4, (y/2) + radius * 3, p2);
					c.drawLine(x/5, y/4, (x/2) + radius * 4, (y/2) + radius * 3, p2);
					c.drawLine(x/5, y/2, (x/2) + radius, y/2 - radius, p2);
					c.drawLine(x/5, (y/4)*3, (x/2) + radius * 4, (y/2) - radius * 3, p2);
					c.drawLine(x/2, (y/4)*3, (x/2) + radius, (y/2) - radius, p2);
					c.drawLine((x/5)*4, y/4, (x/2) - radius * 4, (y/2) + radius * 3, p2);
					c.drawLine((x/5)*4, y/2, (x/2) - radius, (y/2) + radius, p2);
					c.drawLine((x/5)*4, (y/4)*3, (x/2) - radius * 4, (y/2) - radius * 3, p2);
					c.drawLine(x/2, y/4, (x/2) - radius, (y/2) + radius, p2);
					
					x += 50;
					y += 50;
					
					if(x > 2000 && y > 2000) {
						x = 2000;
						y = 2000;
						/*
						c.drawCircle(x/2, y/2, r, p);
						r += 30;
						if(r >= 2000) {
							r = 100;
						}*/
						
					//}
					//try {
						//File file = new File("/sdcard/Download/test.gif");
						//FileInputStream in = new FileInputStream(file);
				        //InputStream is = file.getResourceAsStream();
						//mMovie = Movie.decodeStream(is);
				        //mMovie = Movie.decodeFile("/sdcard/Download/wanted.gif");
						//mMovie.draw(c, 0, 0);
					//} catch (FileNotFoundException e) {
					//	e.printStackTrace();
					//}

				}
			} finally {
				if(c != null)
					holder.unlockCanvasAndPost(c);
			}
			
			mHandler.removeCallbacks(mDrawScene);
			if(mVisiable)
				mHandler.postDelayed(mDrawScene, 1000 / 30);
		}
		
		
		
	}
	
	
}
