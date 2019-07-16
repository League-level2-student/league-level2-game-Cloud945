import java.awt.Graphics;

public class LowObstacle extends GameObject {

	LowObstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO Auto-generated constructor stub
	}
	void update() {
		x-=speed;
	}
	void draw(Graphics g) {
		
	}
}
