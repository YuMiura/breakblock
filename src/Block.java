
import javafx.scene.paint.Color;

public class Block implements Rect {
	private int x;// blockのx座標
	private int y;// blockのy座標
	private int width;// blockの幅
	private int height;// blockの高さ
	private Color color;// blockの色
	private boolean flag;// blockが存在するか

	public Block() {
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

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isTouch(Ball ball) {
		int x1 = getX();
		int x2 = getX() + getWidth();
		int y1 = getY();
		int y2 = getY() + getHeight();
		double bx=0;
		double by=0;
		for(int i=0; i<360; i++){
				bx = ball.getRad()*Math.cos(i) + ball.getX();
				by = ball.getRad()*Math.sin(i) + ball.getY();
				//System.out.println("bx:" + bx + "by" + by);
				if(x1 < bx && bx < x2 &&
				   y1 < by && by < y2) {
					return true;
				}
		}
		return false;
	}
}
