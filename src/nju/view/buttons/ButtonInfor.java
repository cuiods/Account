package nju.view.buttons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.view.Component;
import nju.view.StartPanel;

public class ButtonInfor extends MyButton{

	public ButtonInfor(Component c) {
		super(c);
	}

	public class ButtonListener implements MouseListener{
		StartPanel panel;
		public ButtonListener(StartPanel panel){
			this.panel=panel;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			isIn=true;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			isIn=false;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			panel.clearComponents(panel.getGraphics());
			
		}
		
	}
}
