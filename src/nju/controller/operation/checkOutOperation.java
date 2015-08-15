package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.SystemModel;

public class checkOutOperation extends Operation{

	@Override
	public void execute() {
		SystemModel systemModel = OperationQueue.getSystem();
		systemModel.checkOut();
		
	}

	
}
