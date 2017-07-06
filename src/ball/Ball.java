package ball;

import java.awt.Color;

public class Ball {
	private int x;//ballのx座標
	private int y;//ballのy座標
	private int dx;//ballのx方向への速度
	private int dy;//ballのy方向への速度
	private int rad;//ballの半径
	private boolean flag;//ballが存在するか
	private Color color;//ballの色

	
	public Ball(int x,int y, int rad, Color color){//コンストラクタ
		setFlag(true);//ballを存在させる
		setX(x);//ballのx座標を指定
		setY(y);//ballのy座標を指定
		setDx(0);//ballのx座標の初速度を0にする
		setDy(0);//ballのy座標の初速度を0にする
		setRad(rad);//ballの半径を指定
		setColor(color);//ballの色を指定
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
	public void setDx(int dx){
		this.dx = dx;
	}
	public int getDx(){
		return dx;
	}	
	public void setDy(int dy){
		this.dy = dy;
	}
	public int getDy(){
		return dy;
	}
	public void setRad(int rad){
		this.rad = rad;
	}
	public int getRad(){
		return rad;
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
