package nju.config;


import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	private List<ComponentsConfig> ComponentsConfig;
;
	private Element frame;
	
	/**
	 * ���ڿ��
	 */
	private int width;
	/**
	 * ���ڸ߶�
	 */
	private int height;
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public FrameConfig(Element frame) {
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.frame = frame;
		
		
	}
	public List<ComponentsConfig> getLayersConfig(String elementName) {
		Element panel = frame.element(elementName);
		List<Element> components = panel.elements("component");
		ComponentsConfig =new ArrayList<ComponentsConfig>(components.size());
		for(Element layer:components){
			ComponentsConfig lc = new ComponentsConfig(
					layer.attributeValue("name"), 
					Integer.parseInt(layer.attributeValue("x")), 
					Integer.parseInt(layer.attributeValue("y")), 
					Integer.parseInt(layer.attributeValue("width")), 
					Integer.parseInt(layer.attributeValue("height")));
			ComponentsConfig.add(lc);
		}
		return ComponentsConfig;
	}
	
}
