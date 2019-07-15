import javax.swing.*;

public class RainforestRescue {
	JFrame frame = new JFrame();
	static final int WIDTH = 805;
	static final int HEIGHT = 450;
	GamePanel panel = new GamePanel();
	RainforestRescue(JFrame frame){
		this.frame = frame;	
	}
	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.addKeyListener(panel);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RainforestRescue game = new RainforestRescue(frame);
		game.setup();
	}


}
