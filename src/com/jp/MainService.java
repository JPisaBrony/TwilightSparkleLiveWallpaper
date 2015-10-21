package com.jp;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;

import java.util.LinkedList;

import com.jp.Image;

public class MainService extends WallpaperService {

	private final Handler mHandler = new Handler();
	
	@Override
	public Engine onCreateEngine() {
		return new RenderEngine();
	}
	
	class RenderEngine extends Engine {
		
		boolean mVisiable = true;
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		float displayX = display.getWidth();
		float displayY = display.getHeight();
		int textureSize = 16;
		Image sky = new Image(R.drawable.sky_01);
		Image stone1 = new Image(R.drawable.stone_01);
		Image stone5 = new Image(R.drawable.stone_05);
		Image black = new Image(R.drawable.black_01);
		Image cloud = new Image(R.drawable.cloud_01);
		Image sun = new Image(R.drawable.sun_01);
		Grid grid;
		Cloud cloudBase;
		LinkedList<Shape> clouds = new LinkedList<Shape>();
		int cloudInterval = 0;
		
		RenderEngine() {
			sky.loadImage(getApplicationContext());
			stone1.loadImage(getApplicationContext());
			stone5.loadImage(getApplicationContext());
			black.loadImage(getApplicationContext());
			cloud.loadImage(getApplicationContext());
			sun.loadImage(getApplicationContext());
			grid = new Grid(displayX, displayY, textureSize);
			grid.setGrid(sky);
			
			int s = (int)Math.floor(displayX/textureSize/2);
			ShapeBase first = new ShapeBase(s, s, stone1);
			Shape firstShape = first.getShape();
			Image tmp[][] = new Image[s][s];
			
			for(int i = 0; i < s; i++) {
				for(int j = 0; j < s; j++) {
					if(i < j) {
						tmp[i][j] = stone1;
					} else {
						tmp[i][j] = sky;
					}
				}
			}
			firstShape.setTiles(tmp);
			grid.addTilesAtCords(firstShape, 0, (int)Math.floor(displayY/textureSize) - s);
			
			int s2 = (int)Math.floor(displayX/textureSize/2);
			ShapeBase second = new ShapeBase(s2, s2, stone1);
			Shape secondShape = second.getShape();
			Image tmp2[][] = new Image[s2][s2];
			int inc = s2;
			for(int i = 0; i < s2; i++) {
				for(int j = 0; j < s2; j++) {
					if(j > inc) {
						tmp2[i][j] = stone1;
					} else {
						tmp2[i][j] = sky;
					}
				}
				inc--;
			}
			secondShape.setTiles(tmp2);
			grid.addTilesAtCords(secondShape, (int)Math.floor(displayX/textureSize) - s2, (int)Math.floor(displayY/textureSize) - s);
			
			int s3 = (int)Math.floor(displayY/textureSize) - (int)Math.floor(displayY/textureSize/5);
			ShapeBase third = new ShapeBase(s3, (int)Math.floor(displayY/textureSize), stone1);
			grid.addTilesAtCords(third.getShape(), 0, s3);
			
			cloudBase = new Cloud(sky, cloud, (int)Math.floor(displayX/textureSize/3));
		}
		
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
					if(cloudInterval % 15 == 0) {
						Shape tempcloud = cloudBase.newCloud();
						clouds.addFirst(tempcloud);
					}
					
					for(int k = 0; k < clouds.size(); k++) {
						clouds.get(k).incrementX();
						grid.addTilesAtCords(clouds.get(k), clouds.get(k).getX(), clouds.get(k).getY());
					}
					
					if(clouds.size() > 10)
						clouds.removeLast();
					
					cloudInterval++;
					
					grid.drawGrid(c);
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
