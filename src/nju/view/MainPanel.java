package nju.view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;
import nju.model.UpdateMessage;
import nju.model.vo.RecordVO;
import nju.view.buttons.*;

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
    private ButtonAdd addButton;
    private ButtonDelete deleteButton;
    private int[] expenseLen;
    private int[] incomeLen;
    
    public static final int EXPENSE_X=210;
    public static final int INCOME_X=640;
    public static final int KIND_Y=206;
    public static final int KIND_D=52;
    
	public MainPanel(){
		//warning !! not safe !!
		expenseLen = new int[3];
		incomeLen = new int[2];
		this.setLayout(null);
		initComponent();
	}
	public void initComponent(){
		//获得参数配置
		fc= ConfigReader.getFrameConfig();
		List<ComponentsConfig>layersCfg = fc.getLayersConfig("mainPanel");
		components = ConfigHelper.createComponents(layersCfg);
		
		addButton = new ButtonAdd(components.get(8));
		deleteButton = new ButtonDelete(components.get(9));
		
		this.add(addButton);
		this.add(deleteButton);
		
		addButton.addMouseListener(addButton.new ButtonListener(this));
		deleteButton.addMouseListener(deleteButton.new ButtonListener());
	}

	public void paintComponent(Graphics g){
		
		g.drawImage(Images.BACKGROUND_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
		g.drawImage(Images.BACK_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
		for(int i=0;i<8;i++){
			Component c = components.get(i);
			c.createComponent(g);
		}
		
		for(int i=0;i<expenseLen.length;i++){
			g.drawImage(Images.BASE_01, EXPENSE_X, KIND_Y+KIND_D*i, 20,17, this);
			g.drawImage(Images.BASE_03, EXPENSE_X+expenseLen[i]+20, KIND_Y+KIND_D*i, 20,17, this);
			g.drawImage(Images.BASE_02, EXPENSE_X+20, KIND_Y+KIND_D*i, expenseLen[i],17, this);
		}
		for(int i=0;i<incomeLen.length;i++){
			g.drawImage(Images.BASE1_01, INCOME_X, KIND_Y+KIND_D*i, 20,17, this);
			g.drawImage(Images.BASE1_03, INCOME_X+incomeLen[i]+20, KIND_Y+KIND_D*i, 20,17, this);
			g.drawImage(Images.BASE1_02, INCOME_X+20, KIND_Y+KIND_D*i, incomeLen[i],17, this);
		}
		
//		g.drawImage(Images.BASE_IMAGE, 210, 258, catering,17, this);
//		g.drawImage(Images.BASE_IMAGE, 210, 310, transport, 17, this);
//		g.drawImage(Images.BASE1_IMAGE, 640, 206, parent, 17, this);
//		g.drawImage(Images.BASE1_IMAGE, 640, 258, wage, 17, this);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		UpdateMessage updateMessage = (UpdateMessage) arg1;
		if(updateMessage.getKey().equals("statistic")){
			RecordVO record =(RecordVO) (updateMessage.getValue()) ;
			income = record.getIncome();
			expense = record.getExpense();
			if(expense!=0&&income!=0){
				expenseLen[0] = -(int)(record.getEntertainment()*300/expense);
				expenseLen[1] = -(int)(record.getCatering()*300/expense);
				expenseLen[2] = -(int)(record.getTransportation()*300/expense);
				incomeLen[0] = (int)(record.getTransferaccounts()*300/income);
				incomeLen[1] = (int)(record.getWage()*300/income);
			}
			repaint();
		}
		
	}

	 

}
