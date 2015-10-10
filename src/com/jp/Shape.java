package com.jp;

public class Shape {
	
	private int x;
	private int y;
	private Image[][] tiles;
	
	public Shape(int x, int y, int w, int h, Image img) {
		this.x = x;
		this.y = y;
		tiles = new Image[w][h];
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				tiles[i][j] = img;
			}
		}
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void incrementX() {
		this.x++;
	}
	
	public void incrementY() {
		this.y++;
	}
	
	public int getW() {
        return tiles.length;
    }
	
	public int getH() {
		return tiles[0].length;
	}
	
    public void setTiles(Image[][] t) {
    	tiles = t;
    }
    
    public Image[][] getTiles() {
    	return tiles;
    }
    
    public Image getTileAtCords(int x, int y) {
    	return tiles[x][y];
    }
}