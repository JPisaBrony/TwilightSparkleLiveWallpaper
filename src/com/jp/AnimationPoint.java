package com.jp;

class AnimationPoint {
	private float xStart;
	private float yStart;
	private float xEnd;
	private float yEnd;
	private float animationX;
	private float animationY;
	private float multiplierX;
	private float multiplierY;
	private float slope;
	
	AnimationPoint(float x1, float y1, float x2, float y2, float mx, float my) {
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;
		animationX = x1;
		animationY = y1;
		multiplierX = mx;
		multiplierY = my;
		slope = ((y1 - y2) / (x1 - x2));
	}
	
	public void drawAnimation(int speedX, int speedY, int length) {
		this.setXStart(this.getAnimationX());
		this.setYStart(this.getAnimationY());
		this.setAnimationX(animationX += speedX * multiplierX);
		this.setAnimationY(animationY += speedY * multiplierY);
		this.setXEnd(this.getAnimationX() - length * multiplierX);
		this.setYEnd(this.getAnimationY() - length * multiplierY);
	}
	
	public void drawAnimation2(int speedX, int speedY, int length) {
		this.setXStart(this.getAnimationX() * slope);
		this.setYStart(this.getAnimationY() * slope);
		this.setAnimationX(animationX += speedX * slope * multiplierX);
		this.setAnimationY(animationY += speedY * multiplierY);
		this.setXEnd(this.getAnimationX() * slope - length);
		this.setYEnd(this.getAnimationY() * slope - length);
	}
	
	public void rotateLine() {
		
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
	public float getAnimationX() {
		return animationX;
	}

	public void setAnimationX(float aX) {
		animationX = aX;
	}

	public float getAnimationY() {
		return animationY;
	}

	public void setAnimationY(float aY) {
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
