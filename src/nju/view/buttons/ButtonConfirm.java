package nju.view.buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import nju.model.po.RecordKind;
import nju.view.Component;
import nju.view.buttons.ButtonAdd.AddPanel;

public class ButtonConfirm extends MyButton{
	public ButtonConfirm(Component c) {
		super(c);
	}
	
	class ButtonListener extends MyButton.ButtonListener{
		private int amountNum;
		private JComboBox kindBox;
		private String selected;
		private JTextField amount;
		private ButtonAdd.AddPanel addPanel;
		public ButtonListener(JTextField amount,JComboBox box,ButtonAdd.AddPanel addPanel){
			this.kindBox = box;
			this.amount = amount;
			this.addPanel = addPanel;
		}
		
//		@Override
//		public void itemStateChanged(ItemEvent arg0) {
//			
//				selected = (String) kindBox.getSelectedItem();
//			
//			
//		}
		
		public void mouseReleased(MouseEvent e) {
			selected = (String) kindBox.getSelectedItem();
			amountNum =Integer.parseInt(amount.getText());
			RecordKind kind = null;
			switch(selected){
				case "娱乐" : kind = RecordKind.ENTERTAINMENT;
					break;
				case "交通" : kind = RecordKind.TRANSPORTATION;
				    break;
				case "饮食" : kind = RecordKind.CATERING;
					break;
				case "汇款" : kind = RecordKind.TRANSFERACOUNTS;
					break;
				case "工资" : kind = RecordKind.WAGE;
					break;
			}
			
			dataController.addRecord(kind, amountNum);
			addPanel.setVisible(false);
			
		}
	}
}
