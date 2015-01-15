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
	private float animationStartX;
	private float animationStartY;
	private float animationEndX;
	private float animationEndY;
	private float multiplierX;
	private float multiplierY;
	private float slopeX;
	private float slopeY;
	
	AnimationPoint(float x1, float y1, float x2, float y2, float mx, float my, float length) {
		defaultXStart = xStart = x1;
		defaultYStart = yStart = y1;
		defaultXEnd = xEnd = x2;
		defaultYEnd = yEnd = y2;
		animationStartX = x1;
		animationStartY = y1;
		animationEndX = x1 + length * mx;
		animationEndY = y1 + length * my;
		multiplierX = mx;
		multiplierY = my;
		slopeX = ((x1 - x2) / (y1 - y2));
		slopeY = ((y1 - y2) / (x1 - x2));
	}
	/*
	public void drawAnimation(int speedX, int speedY, int length) {
		this.setXStart(this.getAnimationX());
		this.setYStart(this.getAnimationY());
		//this.setAnimationX(animationX += speedX * multiplierX);
		//this.setAnimationY(animationY += speedY * multiplierY);
		this.setXEnd(this.getAnimationX() - length * multiplierX);
		this.setYEnd(this.getAnimationY() - length * multiplierY);
	}
	
	public void drawAnimation2(float speed, float rotationX, float rotationY, int length) {
		this.setXStart(this.getAnimationX() * rotationX + length);
		this.setYStart(this.getAnimationY() * rotationY + length);
		//this.setAnimationX(animationX += speed * multiplierX);
		//this.setAnimationY(animationY += speed * multiplierY);
		this.setXEnd(this.getAnimationX() * rotationX + length);
		this.setYEnd(this.getAnimationY() * rotationY + length);
	}
	*/
	public void drawAnimation3(float speed, float rotationX, float rotationY) {
		this.setAnimationStartX(animationStartX += speed * multiplierX);
		this.setAnimationStartY(animationStartY += speed * multiplierY);
		this.setXStart(this.getAnimationStartX() * rotationX);
		this.setYStart(this.getAnimationStartY() * rotationY);
		this.setAnimationEndX(animationEndX += speed * multiplierX);
		this.setAnimationEndY(animationEndY += speed * multiplierY);
		this.setXEnd(this.getAnimationEndX() * rotationX);
		this.setYEnd(this.getAnimationEndY() * rotationY);
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
	public float getAnimationStartX() {
		return animationStartX;
	}

	public void setAnimationStartX(float aX) {
		animationStartX = aX;
	}

	public float getAnimationStartY() {
		return animationStartY;
	}

	public void setAnimationStartY(float aY) {
		animationStartY = aY;
	}
	
	public float getAnimationEndX() {
		return animationEndX;
	}

	public void setAnimationEndX(float aX) {
		animationEndX = aX;
	}

	public float getAnimationEndY() {
		return animationEndY;
	}

	public void setAnimationEndY(float aY) {
		animationEndY = aY;
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
