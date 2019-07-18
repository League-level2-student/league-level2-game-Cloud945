import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive = true;
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.collisionBox=new Rectangle(x,y,width,height);
		
	}
	
	void update() {
		collisionBox.setBounds(x+15, y+15, width-30, height-30);
	}
}
