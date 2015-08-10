package nju.view.buttons;

import java.awt.Graphics;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nju.controller.SystemController;
import nju.view.Component;


public class MyButton extends JLabel {
	protected ImageIcon image;
	protected Component component;
	protected boolean isIn;
	protected SystemController systemController;
	public MyButton(Component c){
		systemController = new SystemController();
		this.component = c;
		this.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		component.setX(0);
		component.setY(0);
		
	}
	
	public void paintComponent(Graphics g){
		if(isIn){
    		component.changePath();
    	}else{
    		component.setPath();
    	}
    	component.createComponent(g);
	}
	public class ButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
		    repaint();
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
