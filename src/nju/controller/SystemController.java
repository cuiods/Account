package nju.controller;

import nju.controller.msqueue.OperationQueue;
import nju.controller.operation.Operation;
import nju.controller.operation.SignInOperation;
import nju.controller.operation.SignUpOperation;
import nju.model.po.UserPO;

/**
 * control basic function of the system
 * @author Cui
 * 2015Äê7ÔÂ27ÈÕ11:25:57
 */
public class SystemController {
	
	/**
	 * sign in a user
	 * @param user
	 * @return
	 */
	public boolean signIn(UserPO user){
		Operation signIn = new SignInOperation(user);
		OperationQueue.addOperation(signIn);
		return true;
	}

	/**
	 * sign up a user
	 * @param user
	 * @return
	 */
	public boolean signUp(UserPO user){
		Operation signUp = new SignUpOperation(user);
		OperationQueue.addOperation(signUp);
		return true;
	}
	
	/**
	 * check out (maybe change a account)
	 * @return
	 */
	public boolean checkOut(){
		return false;
	}
}
