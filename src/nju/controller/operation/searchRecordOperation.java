package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.DataModel;

public class searchRecordOperation extends Operation{
	private int year;
	private int month;
	public searchRecordOperation(int year, int month) {
		this.year = year;
		this.month = month;
	}

	@Override
	public void execute() {
		DataModel dataModel = OperationQueue.getData();
		dataModel.searchRecord(year, month);
	}

}
