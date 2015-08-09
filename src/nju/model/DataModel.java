package nju.model;

import java.util.Calendar;

import nju.model.po.RecordPO;
import nju.model.po.UserPO;
/**
 * model to deal with data, get data statistics
 * @author Cui
 * 2015Äê8ÔÂ6ÈÕ17:05:17
 */
public class DataModel extends BaseModel{

	private UserPO user = null;
	private DataList datalist = null;
	
	public DataModel() {
	}
	
	/**
	 * when a user is logged in, the model must know the user to choose which record 
	 * is right
	 * @param user
	 */
	public void setUser(UserPO user){
		this.user = user;
		datalist = new DataList();
		statistic();
	}
	
	public UserPO getUser(){
		return user;
	}
	
	/**
	 * give main frame the data
	 * @return
	 */
	private boolean statistic(){
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		this.updateChange(new UpdateMessage("statistic",datalist.startStatistic(year, month, user)));
		return true;
	}
	
	/**
	 * add a new data
	 * @param record
	 * @return
	 */
	public boolean addRecord(RecordPO record){
		datalist.addRecord(record);
		datalist.saveData();
		return statistic();
	}
	
	/**
	 * search a record
	 * @param year
	 * @param month
	 * @return
	 */
	public boolean searchRecord(int year,int month){
		this.updateChange(new UpdateMessage("search", datalist.startStatistic(year, month, user)));
		return true;
	}
}
