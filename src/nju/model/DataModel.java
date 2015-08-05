package nju.model;

import java.util.Calendar;

import nju.model.po.UserPO;

public class DataModel extends BaseModel{

	private UserPO user = null;
	private DataList datalist = null;
	
	public DataModel() {
		datalist = new DataList();
	}
	
	public void setUser(UserPO user){
		this.user = user;
		initialize();
	}
	
	private boolean initialize(){
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		this.updateChange(new UpdateMessage("initialize",datalist.startStatistic(year, month, user)));
		return true;
	}
}
