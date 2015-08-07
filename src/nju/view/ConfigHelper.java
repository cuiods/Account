package nju.view;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;

public class ConfigHelper {

	public static List<Component> createComponents(List<ComponentsConfig> layersCfg){
		       
				List<Component>components  = new ArrayList<Component>(layersCfg.size());
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
		return components;
	}
}
