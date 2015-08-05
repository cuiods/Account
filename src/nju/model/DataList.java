package nju.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import nju.model.po.RecordPO;
import nju.model.po.UserPO;
import nju.model.vo.RecordVO;

public class DataList {
	
	private ArrayList<RecordPO> records = new ArrayList<RecordPO>();
	private ObjectInputStream reader= null;
	private ObjectOutputStream writer = null;
	public final String DATAPATH = "data/data.seq";
	
	public DataList() {
		try {
			reader = new ObjectInputStream(new FileInputStream(DATAPATH));
			Object record = null;
			while((record = reader.readObject())!=null){
				records.add((RecordPO)record);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: can't find data file");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public boolean saveData(){
		try {
			writer = new ObjectOutputStream(new FileOutputStream(DATAPATH));
			for(RecordPO record: records){
				writer.writeObject(record);
			}
		} catch (IOException e) {
			System.out.println("Error:fail to save data");
			e.printStackTrace();
			return false;
		} finally {
			try {
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean addRecord(RecordPO record){
		records.add(record);
		return true;
	}
	
	public RecordVO startStatistic(int year, int month, UserPO user){
		RecordVO recordView = new RecordVO();
		for(RecordPO record: records){
			if(record.getName().equals(user)&&record.getDate().get(Calendar.YEAR)==year
					&&record.getDate().get(Calendar.MONTH)==month){
				float amount = 0f;
				if((amount = record.getAmount())>0){
					recordView.addIncome(amount);
				}else{
					recordView.addExpense(amount); 
				}
				switch(record.getKind()){
				case TRANSPORTATION:recordView.addTransportation(amount);break;
				case CATERING:recordView.addCatering(amount);break;
				case ENTERTAINMENT:recordView.addTransportation(amount);break;
				case TRANSFERACOUNTS:recordView.addTransferaccounts(amount);break;
				case WAGE:recordView.addWage(amount);
				}
			}
		}
		return recordView;
	}
}
