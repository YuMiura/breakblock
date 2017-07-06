package block;

import java.awt.Color;

public class Block {
	private int x;//blockのx座標
	private int y;//blockのy座標
	private int width;//blockの幅
	private int height;//blockの高さ
	private Color color;//blockの色
	private boolean flag;//blockが存在するか
	
	public Block(int x, int y, int dx, int dy, Color color){
		setFlag(true);//blockを存在させる
		setX(x);//blockのx座標を指定
		setY(y);//blockのy座標を指定
		setWidth(width);//blockの幅を指定
		setHeight(height);//blockの高さを指定
		setColor(color);//blockの色を指定
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
	public void setFlag(boolean flag){
		this.flag = flag;
	}	
	public boolean isFlag(){
		return flag;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public Color getColor(){
		return color;
	}
}
