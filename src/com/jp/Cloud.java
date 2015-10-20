package com.jp;

public class Cloud {
	
	Image background;
	Image cloud;
	int height;
	ShapeBase[] arr;
	
	public Cloud(Image b, Image c, int h) {
		background = b;
		cloud = c;
		height = h;
		arr = cloudDesign();
	}
	
	private ShapeBase[] cloudDesign() {
		int s3x = 6;
		int s3y = 3;
		int startXPosition = -10;
		ShapeBase cloud1 = new ShapeBase(startXPosition, 0, s3x, s3y, background);
		cloud1.crossBase(cloud);
		Image cloud1Tiles[][] = cloud1.getTilesFromShape();
		cloud1Tiles[2][2] = cloud;
		cloud1.setTilesInShape(cloud1Tiles);
		
		ShapeBase cloud2 = new ShapeBase(startXPosition, 0, s3x, s3y, background);
		cloud2.crossBase(cloud);
		Image cloud2Tiles[][] = cloud2.getTilesFromShape();
		cloud2Tiles[2][2] = cloud;
		cloud2Tiles[1][2] = cloud;
		cloud2Tiles[4][0] = cloud;
		cloud2.setTilesInShape(cloud2Tiles);
		
		ShapeBase cloud3 = new ShapeBase(startXPosition, 0, s3x, s3y, background);
		cloud3.crossBase(cloud);
		Image cloud3Tiles[][] = cloud3.getTilesFromShape();
		cloud3Tiles[3][2] = cloud;
		cloud3Tiles[2][2] = cloud;
		cloud3.setTilesInShape(cloud3Tiles);
		
		ShapeBase[] arr  = { cloud1, cloud2, cloud3 };
		return arr;
	}
	
	public Shape newCloud() {
		int randHeight = (int)Math.floor(Math.random() * 10);
		int randCloud = (int)Math.floor(Math.random() * 2);
		Shape s = arr[randCloud].getShape().copyShape();
		s.setY(height - randHeight);
		return s;
	}
	
}
