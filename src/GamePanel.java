
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	  final int MENU = 0;
	  final int GAME = 1;
	  final int END = 2;
	  int currentState = MENU;
	  Font titleFont = new Font("Futura", Font.BOLD, 45);  
	  Font font = new Font("Chalkboard", Font.PLAIN, 30);
	  Parrot parrot=new Parrot(10,200,50,50);
	  ObjectManager manager = new ObjectManager(parrot);
	  public static BufferedImage image;
	  public static boolean needImage = true;
	  public static boolean gotImage = false;	
	  public static Timer obstacleSpawn;
	  GamePanel(){
			Timer frameDraw = new Timer (1000/60, this);
			frameDraw.start();
			if (needImage) {
			    loadImage ("rainforest.png");
			}
			
	  }

	  
	  void updateMenuState() { 
		  
	  }
	  void updateGameState() { 
		manager.update(); 
		if(parrot.isActive==false) {
			currentState++;
		}
	  }
	  void updateEndState()  { 
		 
	  }
	  void drawMenuState(Graphics g) { 
		  g.setColor(Color.GREEN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
		  g.setFont(titleFont);
		  g.setColor(Color.BLACK);
		  g.drawString("Flappy Parrot", 250, 100);
		  g.setFont(font);
		  g.drawString("Press Enter to start and Space to fly up", 120, 250);
		  g.drawString("...and remember to watch your tail feathers.", 85, 350);
	  }
	  void drawGameState(Graphics g) {
		  if (gotImage) {
				g.drawImage(image, 0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT,null);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
			}
		  manager.draw(g);
		  
	  }
	  void drawEndState(Graphics g)  { 
		  g.setColor(Color.GREEN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
		  g.setColor(Color.BLACK);
		  g.setFont(titleFont);
		  g.drawString("Game Over", 250, 150);
	  }
	  
	  void startGame() {
		  
		  obstacleSpawn = new Timer(5000 , manager);
		  obstacleSpawn.start();
	  }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        parrot=new Parrot(10,200,50,50);
		        manager = new ObjectManager(parrot);
		    } else {
		        currentState++;
		        if (currentState==GAME) {
		        	startGame();
		        	
		        }else if(currentState==END) {
		        	obstacleSpawn.stop();
		        	
		        }
		        
		    }
		}
		if(currentState==GAME) {
			if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			    if(parrot.y>0) {
			    	parrot.up();
			    }
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
		
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