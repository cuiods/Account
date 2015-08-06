package nju.controller;

import nju.controller.operation.Operation;
import nju.controller.operation.addRecordOperation;
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
	public boolean addRecord(RecordPO record){
		Operation op = new addRecordOperation(record);
		op.execute();
		return true;
	}
}
