import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Parrot extends GameObject3{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
	Parrot(int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 5;
		if (needImage) {
		    loadImage ("parrot.png");
		}
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g){
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	void update() {
		if(y<375) {
			y+=1;
		}
	}
	public void up() {
        y-=speed;
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
