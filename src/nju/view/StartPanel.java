package nju.view;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;
import nju.model.UpdateMessage;
import nju.view.buttons.ButtonClean;
import nju.view.buttons.ButtonInfor;
import nju.view.buttons.ButtonSignIn;
import nju.view.buttons.ButtonSignUp;

public class StartPanel extends JPanel{
	private List<Component> components= null;
	private JTextField firstName = null;
	private JTextField lastName = null;
	private JPasswordField passWord = null;
	private ButtonSignUp signUp = null;
	private ButtonClean clean = null;
	private ButtonInfor infor = null;
	private ButtonSignIn signIn = null;
	private boolean isSignIn=false;
	
	public StartPanel(){
		this.setLayout(null);
		initComponent();
	}
	public void initComponent(){
		//获得游戏配置
		FrameConfig fCfg = ConfigReader.getFrameConfig();
		//获得参数配置
		List<ComponentsConfig> layersCfg = fCfg.getStartLayersConfig();
		components  = new ArrayList<Component>(layersCfg.size());
		for(int i=0;i<layersCfg.size();i++){
			ComponentsConfig cfg = layersCfg.get(i);
			//调用构造函数创建对象
			Component layer;
			try {
				//获得类对象
				Class<?> cls = Class.forName("nju.view.Component");
				//获得构造函数
				Constructor ctr = cls.getConstructor(int.class,int.class,int.class,int.class,String.class);
				layer = (Component) ctr.newInstance(
						cfg.getX(),cfg.getY(),cfg.getW(),cfg.getH(),cfg.getName());
				//把创建的Layer对象放入集合中
				components.add(layer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
        //初始化组件
		firstName = new JTextField(10);
		lastName = new JTextField(10);
		passWord = new JPasswordField(10);
	    
		firstName.setBounds(layersCfg.get(4).getX(),layersCfg.get(4).getY(),
				layersCfg.get(4).getW(),layersCfg.get(4).getH());
		lastName.setBounds(layersCfg.get(5).getX(),layersCfg.get(5).getY(),
				layersCfg.get(5).getW(),layersCfg.get(5).getH());
		passWord.setBounds(layersCfg.get(6).getX(),layersCfg.get(6).getY(),
				layersCfg.get(6).getW(),layersCfg.get(6).getH());
        passWord.setEchoChar('*');
		
		signUp = new ButtonSignUp(components.get(1));
		clean = new ButtonClean(components.get(2));
		infor = new ButtonInfor(components.get(3));
		
		add(firstName);
		add(lastName);
		add(passWord);
		add(signUp);
		add(clean);
		add(infor);
		
		signUp.addMouseListener(signUp.new ButtonListener(firstName,lastName,passWord));
		clean.addMouseListener(clean.new ButtonListener(firstName,lastName,passWord));
		infor.addMouseListener(infor.new ButtonListener(this));
	}


	
	public void paintComponent(Graphics g){
		FrameConfig fc = ConfigReader.getFrameConfig();
		g.drawImage(Images.BACKGROUND_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
        if(isSignIn==false){
        	components.get(0).createComponent(g);
        }else{
        	components.get(7).createComponent(g);
        }
	}
	
	public void clearComponents(Graphics g){
		remove(signUp);
		remove(infor);
		components.get(7).createComponent(g);
		isSignIn=true;
		signIn = new ButtonSignIn(components.get(8));
		add(signIn);
		signIn.addMouseListener(signIn.new ButtonListener(firstName,lastName,passWord));
		repaint();
	}
	
	
}
