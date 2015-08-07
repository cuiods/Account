package nju.view;

import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;

public class MainPanel extends JPanel implements Observer{
	private List<Component> components;
	private FrameConfig fc;
	
	public MainPanel(){
		this.setLayout(null);
		initComponent();
	}
	public void initComponent(){
		 //获得游戏配置
		fc= ConfigReader.getFrameConfig();
		//获得参数配置
		List<ComponentsConfig>layersCfg = fc.getMainLayersConfig();
		components = ConfigHelper.createComponents(layersCfg);
	}

	public void paintComponent(Graphics g){
		
		g.drawImage(Images.BACKGROUND_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
		for(Component c:components){
			c.createComponent(g);
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	 

}
