package nju.model;

import nju.model.po.UserPO;

public class DataModel extends BaseModel{

	private UserPO user = null;
	
	public void setUser(UserPO user){
		this.user = user;
	}
}
