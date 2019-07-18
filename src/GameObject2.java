import java.awt.Rectangle;

public class GameObject2 {
	int x;
	int y;
	
	int speed;
	int widtha;
	int heighta;
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
		collisionBox.setBounds(x+15, y+15, widtha-30, heighta-30);
	}
}