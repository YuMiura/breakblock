package bar;

import java.awt.Color;

public class Bar {
	private int x;//barのx座標
	private int y;//barのy座標
	private int width;//barの幅
	private int height;//barの高さ
	private Color color;//barの色

	public Bar(int x,int y, int width, int height, Color color){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(color);
	}

	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public int getWidth(){
		return width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public Color getColor(){
	return color;
	}
}
