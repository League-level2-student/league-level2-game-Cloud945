import java.awt.Rectangle;

public class GameObject3 {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive = true;
	Rectangle collisionBox;


	

	public GameObject3(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
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
