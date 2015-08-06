package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.DataModel;
import nju.model.SystemModel;
import nju.model.po.UserPO;

/**
 * similar to sign in operation
 * @author Cui
 *
 */
public class SignUpOperation extends Operation{

	UserPO user = null;
	
	public SignUpOperation(UserPO user) {
		this.user = user;
	}
	
	@Override
	public void execute() {
		SystemModel system = OperationQueue.getSystem();
		if(system.signUp(user)){
			DataModel data = OperationQueue.getData();
			data.setUser(user);
		}
	}

}
