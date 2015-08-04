package nju.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import nju.model.po.RecordPO;

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
}
