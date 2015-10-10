package com.jp;

public class ShapeBase {
	
	Shape shape;
	
	public ShapeBase(int w, int h, Image img) {
		shape = new Shape(0, 0, w, h, img);
	}
	
	public void crossBase(Image img) {
		int[] vals = findCenter();
		Image[][] s = shape.getTiles();
		s[vals[0]][vals[1]] = img;
		s[vals[0] + 1][vals[1]] = img;
		s[vals[0]][vals[1] + 1] = img;
		s[vals[0]][vals[1] - 1] = img;
		s[vals[0] - 1][vals[1]] = img;
		shape.setTiles(s);
	}
	
	public int[] findCenter() {
		int[] vals = new int[2];
		vals[0] = (int)Math.floor(shape.getH()/2);
		vals[1] = (int)Math.floor(shape.getW()/2);
		return vals;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape s) {
		shape = s;
	}
}
