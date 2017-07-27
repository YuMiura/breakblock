import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class World extends Application {
	private int width = 600;
	private int height = 900;

	public List<Block> st1BlockList = new ArrayList<Block>();// インスタンス変数の定義
	public List<Ball> st1BallList = new ArrayList<Ball>();// インスタンス変数の定義
	public Bar bar = new Bar();
	int blockNum = 30;
	int ballNum = 1;

	Color stroke = Color.WHITE;

	int count = 0;// どうにかできないものか

	int ballCount = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Label label = new Label("game window");// 背景

		Label borad = new Label();// 上部ラベル
		borad.setId("borad");

		BorderPane pane = new BorderPane();

		pane.setCenter(label);
		pane.setTop(borad);

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				createRect(pane, 0, 30, width, height, Color.GRAY, Color.GRAY);

				// 衝突判定
				for (Ball ba : st1BallList) {
					// System.out.println("ball x: " + ba.getX() + ", y: " + ba.getY());

					// 壁との衝突判定
					switch (isTouch(ba)) {
					case 1:
						ba.setDy(Math.abs(ba.getDy()));
						break;
					case 2:
						ba.setDx(Math.abs(ba.getDx()) * -1);
						break;
					case 3:
						ba.setDy(Math.abs(ba.getDy()) * -1);
						borad.setText("ゲームオーバー");
						ba.setFlag(false);
						break;
					case 4:
						ba.setDx(Math.abs(ba.getDx()));
						break;

					}

					for (Block bl : st1BlockList) {// blockとの衝突判定
						if (bl.isFlag()) {
							if (bl.getX() < ba.getX() - ba.getRad() && ba.getX() + ba.getRad() < bl.getX2()) {
								if (bl.getY() < ba.getY() + ba.getRad()
										&& ba.getY() + ba.getRad() < bl.getY() + ba.getRad()) {
									// 上側に衝突した
									bl.setFlag(false);
									ba.setDy(Math.abs(ba.getDy()) * -1);
								} else if (bl.getY2() - ba.getRad() / 2 < ba.getY() - ba.getRad()
										&& ba.getY() - ba.getRad() < bl.getY2()) {
									// 下側に衝突した
									bl.setFlag(false);
									ba.setDy(Math.abs(ba.getDy()));
								}

							}
							if (bl.getY() < ba.getY() - ba.getRad() && ba.getY() + ba.getRad() < bl.getY2()) {
								if (bl.getX() < ba.getX() + ba.getRad()
										&& ba.getX() - ba.getRad() < bl.getX() + ba.getRad()) {
									// 左側に衝突した
									bl.setFlag(false);
									ba.setDx(Math.abs(ba.getDx()) * -1);

								} else if (bl.getX2() - ba.getRad() < ba.getX() + ba.getRad()
										&& ba.getX() - ba.getRad() < bl.getX2()) {
									// 右側に衝突した
									bl.setFlag(false);
									ba.setDx(Math.abs(ba.getDx()));

								}

							}

						}

						// barとの衝突判定
						if (bar.getX() < ba.getX() - ba.getRad() && ba.getX() + ba.getRad() < bar.getX2()) {
							if (bar.getY() < ba.getY() + ba.getRad()
									&& ba.getY() + ba.getRad() < bar.getY() + ba.getRad()) {
								// 上側に衝突した
								ba.setDy(Math.abs(ba.getDy()) * -1);
							}

						}

					}
				}

				// ブロックが存在するか
				for (Block bl : st1BlockList) {
					if (bl.isFlag()) {
						break;
					} else {
						borad.setText("ゲームクリア");
						for (Ball ba : st1BallList) {
							ba.setFlag(false);
						}

					}
				}

				// ball位置更新
				for (Ball ba : st1BallList) {
					if (ba.isFlag())
						ba.update();
				}

				// object生成
				// block
				for (Block bl : st1BlockList) {
					if (bl.isFlag())
						createRect(pane, bl.getX(), bl.getY(), bl.getWidth(), bl.getHeight(), bl.getColor(), stroke);
				}

				// ball
				for (Ball ba : st1BallList) {
					creatEllipse(pane, ba.getX(), ba.getY(), ba.getRad(), ba.getColor(), stroke);
				}
				// bar
				createRect(pane, bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight(), Color.BLUE, stroke);

			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();

		Scene scene = new Scene(pane, width, height);

		EventHandler<KeyEvent> sceneKeyFilter = (event) -> {
			System.out.println("key input(" + event.getText() + ")");
			if (event.getText().matches("a")) {
				if (bar.getX() - 50 < 0) {
					bar.setX(0);
				} else {
					bar.setX(bar.getX() - 50);
				}
			} else if (event.getText().matches("d")) {
				if (width < bar.getX() + bar.getWidth() + 50) {
					bar.setX(width - bar.getWidth());
				} else {
					bar.setX(bar.getX() + 50);
				}
			} else if (event.getText().matches("z")) {
				int tmpx = 0;
				for (Ball ba : st1BallList) {
					tmpx += ba.getX();
				}
				tmpx /= st1BallList.size();
				bar.setX(tmpx - bar.getWidth() / 2);
			} else if (event.getText().matches("x")) {

				int x = st1BallList.get(0).getX();
				int y = st1BallList.get(0).getY();
				int dx = st1BallList.get(0).getDx();
				int dy = st1BallList.get(0).getDy();
				int tmp = 0;
				tmp = (2*y-(dy/dx)*x)/(dy/dx);
				System.out.println(tmp);
				if (0 < tmp && tmp < width) {
				}

			}
		};
		scene.addEventFilter(KeyEvent.KEY_PRESSED, sceneKeyFilter);

		scene.getStylesheets().add(getClass().getResource("World.css").toExternalForm());
		stage.setTitle("ブロック崩し");
		stage.setScene(scene);
		borad.setText("ブロック崩し");
		stage.show();
	}

	private void createRect(Pane root, int x, int y, int width, int height, Color fill, Color stroke) {
		Rectangle r = new Rectangle(x, y, width, height);
		r.setFill(fill);
		r.setStroke(stroke);
		root.getChildren().add(r);
	}

	private void creatEllipse(Pane root, int x, int y, int rad, Color fill, Color stroke) {
		Circle c = new Circle(x, y, rad);
		c.setFill(fill);
		c.setStroke(stroke);
		root.getChildren().add(c);
	}

	public void init() {
		Block[] block = new Block[blockNum];
		for (Block bl : block) {
			bl = new Block();
			addBlockObject(bl);
		}

		Ball[] ball = new Ball[ballNum];
		for (Ball ba : ball) {
			ba = new Ball();
			addBallObject(ba);
		}

		bar.setX(60);
		bar.setY(700);
		bar.setWidth(100);
		bar.setHeight(30);
		bar.setColor(Color.BLUE);
	}

	private void addBlockObject(Block bl) {
		Color fill = Color.WHITE;
		switch ((int) (count / 5) % 4) {
		case 0:
			fill = Color.GREEN;
			break;
		case 1:
			fill = Color.RED;
			break;
		case 2:
			fill = Color.YELLOW;
			break;
		case 3:
			fill = Color.BLUE;
			break;
		}
		bl.setX(width / 7 * (1 + count % 5));
		bl.setY(60 + height / 30 * (int) (count / 5));
		bl.setWidth(width / 7);
		bl.setHeight(height / 30);
		bl.setColor(fill);
		bl.setFlag(true);

		st1BlockList.add(bl);

		count++;

	}

	private void addBallObject(Ball ball) {

		ball.setX(300);
		ball.setY(400);
		ball.setRad(10);
		ball.setColor(Color.RED);
		ball.setDx(6);
		ball.setDy(8);
		ball.setFlag(true);
		ball.setHP(3);

		st1BallList.add(ball);
	}

	public int isTouch(Ball ball) {
		if (ball.getX() - ball.getRad() < 0) {
			return 4;
		} else if (width < ball.getX() + ball.getRad()) {
			return 2;
		} else if (ball.getY() - ball.getRad() < 40) {
			return 1;
		} else if (height < ball.getY() + ball.getRad()) {
			return 3;
		} else {
			return 0;
		}

	}
}
