

import javafx.scene.paint.Color;

public class Ball {
	private int x;// ballのx座標
	private int y;// ballのy座標
	private int dx;// ballのx方向への速度
	private int dy;// ballのy方向への速度
	private int rad;// ballの半径
	private boolean flag;// ballが存在するか
	private Color color;// ballの色
	private int hp;

	public Ball() {// コンストラクタ
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDx() {
		return dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getDy() {
		return dy;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int getRad() {
		return rad;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public int getHp() {
		return hp;
	}

	public void update() {
		x += dx;
		y += dy;
	}
}
