package com.jp;

import android.graphics.Canvas;

public class Grid {
	
	private Image[][] grid;
	private int gridWidth;
	private int gridHeight;
	private int textureSize;
	
	public Grid(float sw, float sh, int t) {
		int w = (int)sw/t;
		int h = (int)sh/t;
		grid = new Image[w][h];
		gridWidth = w;
		gridHeight = h;
		textureSize = t;
	}
	
	public Image[][] getGrid() {
		return grid;
	}
	
	public Image getImageAtCoords(int x, int y) {
		return grid[x][y];
	}
	
	public void setImageAtCoords(Image img, int x, int y) {
		grid[x][y] = img;
	}
	
	public void setGrid(Image image) {
		for(int i = 0; i < gridWidth; i++) {
			for(int j = 0; j < gridHeight; j++) {
				grid[i][j] = image;
			}
		}
	}
	
	public void drawGrid(Canvas c) {
		for(int i = 0; i < gridWidth; i++) {
			for(int j = 0; j < gridHeight; j++) {
				grid[i][j].drawImage(c, i*textureSize, j*textureSize);
			}
		}
	}
	
	public void addTilesAtCords(Shape tiles, int x, int y) {
		int y2 = y;
		for(int i = 0; i < tiles.getW(); i++) {
			for(int j = 0; j < tiles.getH(); j++) {
				if(x > -1 && x < gridWidth && y2 > -1 && y2 < gridHeight)
					grid[x][y2] = tiles.getTileAtCords(i, j);
				y2++;
			}
			x++;
			y2 = y;
		}
	}
	
	public void drawTilesAtCords(Canvas c, Shape tiles, int x, int y) {
		int y2 = y;
		for(int i = 0; i < gridWidth; i++) {
			for(int j = 0; j < gridHeight; j++) {
				if(x > -1 && x < gridWidth && y2 > -1 && y2 < gridHeight)
					grid[x][y2].drawImage(c, i*textureSize, j*textureSize);
				y2++;
			}
			x++;
			y2 = y;
		}
	}
}
