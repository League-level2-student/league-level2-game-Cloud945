import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Parrot parrot;
	ArrayList <TopObstacle> topObstacles = new ArrayList <TopObstacle>();
	ArrayList <LowObstacle> lowObstacles = new ArrayList <LowObstacle>();
	ObjectManager(Parrot parrot){
		this.parrot=parrot;
	}
	void addObstacles() {
		Random random = new Random();
		int height = random.nextInt(250);
		int width = height*(25/12);
		int y = random.nextInt(125)+75+height;
		int heighta = RainforestRescue.HEIGHT-y;
		int widtha = heighta*(94/88);
		topObstacles.add(new TopObstacle(RainforestRescue.WIDTH,0,width,height));
		lowObstacles.add(new LowObstacle(RainforestRescue.WIDTH,y,widtha,heighta));
	}
	void update(){
		for(int i = 0; i<topObstacles.size()-1;i++) {
			TopObstacle t = topObstacles.get(i);
			t.update();
		}
		for(int i = 0; i<lowObstacles.size()-1;i++) {
			LowObstacle l = lowObstacles.get(i);
			l.update();
		}
		parrot.update();
		checkCollision();
		
	}
	
	void draw(Graphics g) {
		parrot.draw(g);
		for(int i = 0; i<topObstacles.size()-1;i++) {
			TopObstacle t = topObstacles.get(i);
			t.draw(g);
		}
		for(int i = 0; i<lowObstacles.size()-1;i++) {
			LowObstacle l = lowObstacles.get(i);
			l.draw(g);
		}
	}
	void checkCollision() {
		for(int i = 0; i<topObstacles.size()-1;i++) {
			TopObstacle a = topObstacles.get(i);
			if(parrot.collisionBox.intersects(a.collisionBox)) {
				parrot.isActive = false;
				a.isActive = false;
			}
			for(int j = 0; j<lowObstacles.size()-1;j++) {
				LowObstacle p = lowObstacles.get(j);
				if(p.collisionBox.intersects(a.collisionBox)) {
					p.isActive = false;
					a.isActive = false;
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==GamePanel.obstacleSpawn) {
			addObstacles();
		}
	}
}
