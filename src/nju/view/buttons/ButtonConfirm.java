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
				case "����" : kind = RecordKind.ENTERTAINMENT;
					break;
				case "��ͨ" : kind = RecordKind.TRANSPORTATION;
				    break;
				case "��ʳ" : kind = RecordKind.CATERING;
					break;
				case "���" : kind = RecordKind.TRANSFERACOUNTS;
					break;
				case "����" : kind = RecordKind.WAGE;
					break;
			}
			
			dataController.addRecord(kind, amountNum);
			addPanel.setVisible(false);
			
		}
	}
}
