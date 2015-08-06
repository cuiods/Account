package nju.model.po;

import java.io.Serializable;

/**
 * to describe a user
 * @author Cui
 *
 */
public class UserPO implements Serializable{

	private String name;
	private String password;
	
	public UserPO(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object o){
		UserPO user = (UserPO) o;
		if(this.name.equals(user.getName())){
			return true;
		}else{
			return false;
		}
	}
	
}
