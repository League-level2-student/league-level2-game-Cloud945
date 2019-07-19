import java.awt.Rectangle;

public class GameObject2 {
	int x;
	int y;
	int widtha;
	int heighta;
	int speed;
	
	boolean isActive = true;
	Rectangle collisionBox;

	GameObject2(int x, int y, int widtha, int heighta){
		this.x = x;
		this.y=y;
		this.widtha=widtha;
		this.heighta=heighta;
		this.collisionBox=new Rectangle(x,y,widtha,heighta);
		
	}
	
	void update() {
		collisionBox.setBounds(x+15, ObjectManager.y+15, ObjectManager.widtha-30, ObjectManager.heighta-30);
	}
}