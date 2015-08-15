package nju.model;

import nju.controller.msqueue.OperationQueue;
import nju.model.po.UserPO;

/**
 * handle sign in, sign up and check out operation
 * @author 
 *
 */
public class SystemModel extends BaseModel{

	public SystemModel() {
		
	}
	
	/**
	 * open method to sign up a user
	 * @param user:UserPO
	 */
	public boolean signUp(UserPO user){
		boolean result = IOhelper.signUp(user);
		updateChange(new UpdateMessage("signUp", result));
		return result;
	}
	
	/**
	 * open method to sign in
	 * @param user:UserPO
	 */
	public boolean signIn(UserPO user){
		boolean result = IOhelper.signIn(user);
		updateChange(new UpdateMessage("signIn", result));
		return result;
	}
	
	/**
	 * warning
	 */
	public void checkOut(){
		DataModel data = OperationQueue.getData();
		data.setUser(null);
		updateChange(new UpdateMessage("checkout", true));
	}
}
