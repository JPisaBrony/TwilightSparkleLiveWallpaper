package com.jp;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
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
		Image background = new Image(R.drawable.stone_01);
		
		RenderEngine() {
			background.loadImage(getApplicationContext());
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
					background.drawImage(c, 100, 100);

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
