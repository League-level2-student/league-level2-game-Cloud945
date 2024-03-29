import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class LowObstacle extends GameObject2 {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	LowObstacle(int x, int y, int widtha, int heighta) {
		super(x, y, widtha, heighta);
		speed = 2;
		if (needImage) {
		    loadImage ("ground obstacle.png");
		}
		// TODO Auto-generated constructor stub
	}
	void update() {
		x-=speed;
	    super.update();
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, widtha, heighta, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, widtha, heighta);
		}


	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
