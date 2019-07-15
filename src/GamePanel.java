
import java.awt.Color;
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
	  
	  void updateMenuState() { 
		  
	  }
	  void updateGameState() { 
		  
	  }
	  void updateEndState()  { 
		 
	  }
	  void drawMenuState(Graphics g) { 
		  g.setColor(Color.CYAN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
	  }
	  void drawGameState(Graphics g) { 
		  g.setColor(Color.GREEN);
		  g.fillRect(0, 0, RainforestRescue.WIDTH, RainforestRescue.HEIGHT);
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
			













}	