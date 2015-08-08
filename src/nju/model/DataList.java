package nju.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import nju.model.po.RecordKind;
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
			//BufferedReader br = new BufferedReader(new FileReader(DATAPATH));
			//if(br.readLine()!=null){
				//br.close();
				FileInputStream fr = new FileInputStream(DATAPATH);
				reader = new ObjectInputStream(fr);
				while(fr.available()>0){
					RecordPO record = (RecordPO) reader.readObject();
					records.add(record);
				}
				reader.close();
			//}else{
				//br.close();
			//}
		} catch (FileNotFoundException e) {
			System.out.println("Error: can't find data file");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
				case TRANSPORTATION:recordView.addTransportation(-amount);break;
				case CATERING:recordView.addCatering(-amount);break;
				case ENTERTAINMENT:recordView.addTransportation(-amount);break;
				case TRANSFERACOUNTS:recordView.addTransferaccounts(amount);break;
				case WAGE:recordView.addWage(amount);
				}
			}
		}
		return recordView;
	}
	
	public ArrayList<RecordPO> getRecords(){
		return records;
	}
	
//	public static void main(String[] args){
//		DataList list = new DataList();
//		UserPO user = new UserPO("aa aa", "aa");
//		Calendar c = Calendar.getInstance();
//		RecordPO record1 = new RecordPO(user, RecordKind.CATERING, c, -100);
//		RecordPO record2 = new RecordPO(user, RecordKind.ENTERTAINMENT, c, -100);
//		RecordPO record3 = new RecordPO(user, RecordKind.TRANSFERACOUNTS, c, 1000);
//		RecordPO record4 = new RecordPO(user, RecordKind.TRANSPORTATION, c, -100);
//		RecordPO record5 = new RecordPO(user, RecordKind.WAGE, c, 100);
//		list.addRecord(record1);
//		list.addRecord(record2);
//		list.addRecord(record3);
//		list.addRecord(record4);
//		list.addRecord(record5);
//		list.saveData();
//		try {
//			ObjectInputStream input = new ObjectInputStream(new FileInputStream("data/data.seq"));
//			RecordPO record1 = (RecordPO)input.readObject();
//			RecordPO record2 = (RecordPO)input.readObject();
//			RecordPO record3 = (RecordPO)input.readObject();
//			RecordPO record4 = (RecordPO)input.readObject();
//			RecordPO record5 = (RecordPO)input.readObject();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
