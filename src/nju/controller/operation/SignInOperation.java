package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.DataModel;
import nju.model.SystemModel;
import nju.model.po.UserPO;

public class SignInOperation extends Operation{

	UserPO user = null;
	
	public SignInOperation(UserPO user) {
		this.user = user;
	}
	
	@Override
	public void execute() {
		SystemModel system = OperationQueue.getSystem();
		if(system.signIn(user)){
			DataModel data = OperationQueue.getData();
			data.setUser(user);
		}
	}

}
