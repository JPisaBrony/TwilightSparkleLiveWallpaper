package com.jp;

class AnimationPoint {
	private float defaultXStart;
	private float defaultYStart;
	private float defaultXEnd;
	private float defaultYEnd;
	private float xStart;
	private float yStart;
	private float xEnd;
	private float yEnd;
	private float animationX;
	private float animationY;
	private float multiplierX;
	private float multiplierY;
	private float slopeX;
	private float slopeY;
	
	AnimationPoint(float x1, float y1, float x2, float y2, float mx, float my) {
		defaultXStart = xStart = x1;
		defaultYStart = yStart = y1;
		defaultXEnd = xEnd = x2;
		defaultYEnd = yEnd = y2;
		animationX = x1;
		animationY = y1;
		multiplierX = mx;
		multiplierY = my;
		slopeX = ((x1 - x2) / (y1 - y2));
		slopeY = ((y1 - y2) / (x1 - x2));
	}
	
	public void drawAnimation(int speedX, int speedY, int length) {
		this.setXStart(this.getAnimationX());
		this.setYStart(this.getAnimationY());
		this.setAnimationX(animationX += speedX * multiplierX);
		this.setAnimationY(animationY += speedY * multiplierY);
		this.setXEnd(this.getAnimationX() - length * multiplierX);
		this.setYEnd(this.getAnimationY() - length * multiplierY);
	}
	
	public void drawAnimation2(float speed, float rotationX, float rotationY, int length) {
		this.setXStart(this.getAnimationX() * rotationX * length / 2);
		this.setYStart(this.getAnimationY() * rotationY * length / 2);
		this.setAnimationX(animationX += speed * multiplierX);
		this.setAnimationY(animationY += speed * multiplierY);
		this.setXEnd(this.getAnimationX() * rotationX * length / 2);
		this.setYEnd(this.getAnimationY() * rotationY * length / 2);
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
