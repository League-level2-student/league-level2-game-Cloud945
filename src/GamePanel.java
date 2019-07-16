
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	  final int MENU = 0;
	  final int GAME = 1;
	  final int END = 2;
	  int currentState = MENU;
	  Font titleFont = new Font("Arial", Font.PLAIN, 20);  
	  Parrot parrot=new Parrot(10,200,50,50);
	  ObjectManager manager = new ObjectManager(parrot);
	  
	  GamePanel(){
			Timer frameDraw = new Timer (1000/60, this);
			frameDraw.start();
			
	  }

	  
	  void updateMenuState() { 
		  
	  }
	  void updateGameState() { 
		manager.update();  
	  }
	  void updateEndState()  { 
		 
	  }
	  void drawMenuState(Graphics g) { 
		  g.setColor(Color.CYAN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
		  g.setFont(titleFont);
		  g.setColor(Color.BLACK);
		  g.drawString("[Insert Instructions Here]", 50, 100);
	  }
	  void drawGameState(Graphics g) { 
		  g.setColor(Color.GREEN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
		  manager.draw(g);
	  }
	  void drawEndState(Graphics g)  { 
		  g.setColor(Color.CYAN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
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
		    } 
		    else {
		        currentState++;
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
			













}	