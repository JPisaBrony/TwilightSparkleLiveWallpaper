package com.jp;

class AnimationPoint {
	private float xStart;
	private float yStart;
	private float xEnd;
	private float yEnd;
	private int animationX;
	private int animationY;
	private int multiplierX;
	private int multiplierY;
	
	AnimationPoint(float x1, float y1, float x2, float y2, int aX, int aY, int mx, int my) {
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;
		animationX = aX;
		animationY = aY;
		multiplierX = mx;
		multiplierY = my;
	}
	
	public void drawAnimation(int speed, int length) {
		this.setXStart(this.getAnimationX());
		this.setYStart(this.getAnimationY());
		this.setAnimationX(animationX += speed * multiplierX);
		this.setAnimationY(animationY += speed * multiplierY);
		this.setXEnd(this.getAnimationX() - length * multiplierX);
		this.setYEnd(this.getAnimationY() - length * multiplierY);
	}
	
	public float getXStart() {
		return xStart;
	}
	
	public float getYStart() {
		return yStart;
	}
	
	public float getXEnd() {
		return xEnd;
	}
	
	public float getYEnd() {
		return yEnd;
	}
	public int getAnimationX() {
		return animationX;
	}

	public void setAnimationX(int aX) {
		animationX = aX;
	}

	public int getAnimationY() {
		return animationY;
	}

	public void setAnimationY(int aY) {
		animationY = aY;
	}

	public void setXStart(float x) {
		xStart = x;
	}
	
	public void setYStart(float y) {
		yStart = y;
	}
	
	public void setXEnd(float x) {
		xEnd = x;
	}
	
	public void setYEnd(float y) {
		yEnd = y;
	}
	
}
