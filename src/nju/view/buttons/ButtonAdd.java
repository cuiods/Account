package nju.view.buttons;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;
import nju.view.Component;
import nju.view.ConfigHelper;
import nju.view.Images;
import nju.view.MainPanel;

public class ButtonAdd extends MyButton{
	private List<Component> components;
	private AddPanel addPanel;
	private JTextField amountField;
	private JComboBox kindBox;
	public ButtonAdd(Component c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
    public class ButtonListener extends MyButton.ButtonListener{
    	
    	private String[] kinds ={"娱乐","交通","饮食","汇款","工资"};
        private MainPanel mainPanel;
        
        public ButtonListener(MainPanel mainPanel){
        	//获得参数配置
    		FrameConfig fc= ConfigReader.getFrameConfig();
    		List<ComponentsConfig>layersCfg = fc.getLayersConfig("addPanel");
    		components = ConfigHelper.createComponents(layersCfg);
    		
        	this.mainPanel = mainPanel;
        	kindBox = new JComboBox(kinds);
        	amountField = new JTextField();
        	addPanel = new AddPanel();
        	
        	kindBox.setSelectedIndex(0);
        	
        	addPanel.add(kindBox);
        	addPanel.add(amountField);
        	
        	setBounds();
        	
        	addPanel.addMouseListener(addPanel);
        	addPanel.setLayout(null);
        }
        
        public void setBounds(){
    		
    		int w = components.get(0).getWidth();
    		int h = components.get(0).getHeight();
    		int x = components.get(0).getX();
    		int y = components.get(0).getY();
    		
    		addPanel.setBounds(x,y,w,h);
            kindBox.setBounds(100,45,60,20);
            amountField.setBounds(100,125,60,20);
        }

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			addPanel.setVisible(false);
			repaint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			mainPanel.add(addPanel);
			addPanel.setVisible(true);
			addPanel.setOpaque(false);
			mainPanel.repaint();
		}
        
    }
    
     class AddPanel extends JPanel implements MouseListener{
    	private ButtonConfirm confirmButton;
    	
    	public AddPanel(){
    		confirmButton = new ButtonConfirm(components.get(1));
    	    this.add(confirmButton);
    	    nju.view.buttons.ButtonConfirm.ButtonListener listener = confirmButton.new ButtonListener(amountField,kindBox,this);
    	    confirmButton.addMouseListener(listener);
    	   // kindBox.addItemListener(listener);
    	}
    	public void paintComponent(Graphics g){
    		g.drawImage(Images.ADD_IMAGE, 0, 0, this.getWidth(),this.getHeight(),null);
    		g.drawImage(Images.AMOUNT_IMAGE, 20, 40, 50,25,null);
    		g.drawImage(Images.KIND_IMAGE, 20, 120, 50,25,null);
    	}

		

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			addPanel.setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
    }
    
  
    	
    
}
