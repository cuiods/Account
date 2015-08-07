package nju.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import nju.config.ConfigReader;
import nju.config.FrameConfig;
import nju.model.UpdateMessage;

public class MainFrame implements Observer{
	private JFrame mainFrame;
	private StartPanel startPanel;
	private MainPanel mainPanel;
	
	public MainFrame(){
		componentsInstantiation();
		initComponents();
		mainFrame.setVisible(true);
	}
	
	
	private void initComponents() {
		FrameConfig fc = ConfigReader.getFrameConfig();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		mainFrame.setSize(fc.getWidth(), fc.getHeight());
		mainFrame.setLocation((screenSize.width - fc.getWidth()) / 2,screenSize.height-fc.getHeight()/2-400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().add(startPanel);
	}
	private void componentsInstantiation() {
		mainFrame = new JFrame("My account");
		startPanel = new StartPanel();
		mainPanel = new MainPanel();
	}
    public MainPanel getMainPanel(){
    	return mainPanel;
    }
	@Override
	public void update(Observable o, Object arg) {
		UpdateMessage notifingObject = (UpdateMessage)arg;
		if(notifingObject.getKey().equals("signUp")){
			if(notifingObject.getValue().equals(false)){
				
			}else{
				
			}
		}else if(notifingObject.getKey().equals("signIn")){
			if(notifingObject.getValue().equals(false)){
				System.out.println("return false");
			}else{
				startPanel.setVisible(false);
				mainFrame.getContentPane().add(mainPanel);
				System.out.println("return true");
			}
		}
		
	}
}
