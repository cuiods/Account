package nju.view;

import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;
import nju.model.vo.RecordVO;

public class MainPanel extends JPanel implements Observer{
	private List<Component> components;
	private FrameConfig fc;
	private float income;
	private float expense;
	private int transport;
	private int catering;
	private int  entertain;
	private int parent;
	private int wage;

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
		g.drawImage(Images.BACK_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
		for(Component c:components){
			c.createComponent(g);
		}
		g.drawImage(Images.BASE_IMAGE, 210, 206, entertain, 17, this);
		g.drawImage(Images.BASE_IMAGE, 210, 258, catering, 17, this);
		g.drawImage(Images.BASE_IMAGE, 210, 310, transport, 17, this);
		g.drawImage(Images.BASE1_IMAGE, 640, 206, parent, 17, this);
		g.drawImage(Images.BASE1_IMAGE, 640, 258, wage, 17, this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0.equals("statistic")){
			RecordVO record =(RecordVO) arg1;
			income = record.getIncome();
			expense = record.getExpense();
			if(expense!=0&&income!=0){
				transport = (int)(record.getTransportation()*300/expense);
				catering = (int)(record.getCatering()*300/expense);
				entertain = (int)(record.getEntertainment()*300/expense);
				parent = (int)(record.getTransferaccounts()*300/income);
				wage = (int)(record.getWage()*300/income);
			}
		}
		
	}

	 

}
