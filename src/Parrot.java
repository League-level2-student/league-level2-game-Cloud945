import java.awt.Color;
import java.awt.Graphics;

public class Parrot extends GameObject{
	
	
	
	Parrot(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g){
		 g.setColor(Color.RED);
		 g.fillRect(x, y, width, height);
	}
	public void up() {
        y-=speed;
    }

}
