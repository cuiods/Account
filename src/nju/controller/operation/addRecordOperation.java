package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.DataModel;
import nju.model.po.RecordPO;

/**
 * operation: add a new record
 * first we need to get a parameter: record, then we add it to the list
 * @author Cui
 *
 */
public class addRecordOperation extends Operation{

	private RecordPO record = null;
	
	public addRecordOperation(RecordPO record) {
		this.record = record;
	}
	
	@Override
	public void execute() {
		DataModel data = OperationQueue.getData();
		data.addRecord(record);
		System.out.println("Add a reord !!!");
	}

}
