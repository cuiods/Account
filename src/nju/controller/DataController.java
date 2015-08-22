package nju.controller;

import java.util.Calendar;

import nju.controller.msqueue.OperationQueue;
import nju.controller.operation.Operation;
import nju.controller.operation.addRecordOperation;
import nju.controller.operation.deleteOperation;
import nju.controller.operation.searchRecordOperation;
import nju.model.po.RecordKind;
import nju.model.po.RecordPO;

/**
 * control data of the system
 * @author Cui
 *
 */
public class DataController {

	/**
	 * add a new record to data list
	 * @param record
	 * @return
	 */
	public boolean addRecord(RecordKind kind, float num){
		Calendar date = Calendar.getInstance();
		RecordPO record = new RecordPO(OperationQueue.getData().getUser(), kind, date, num);
		Operation op = new addRecordOperation(record);
		op.execute();
		return true;
	}
	
	/**
	 * search a record statistic
	 * @param year
	 * @param month
	 * @return
	 */
	public boolean searchRecord(int year,int month){
		Operation op = new searchRecordOperation(year, month);
		op.execute();
		return true;
	}
	
	/**
	 * delete all the records
	 */
	public boolean deleteRecord(){
		Operation op = new deleteOperation();
		op.execute();
		return true;
	}
	
	
}
