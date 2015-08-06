package nju.model.po;

import java.io.Serializable;
import java.util.Calendar;

/**
 * to describe a record
 * @author Cui
 *
 */
public class RecordPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserPO user;
	private RecordKind kind;
	private Calendar date;
	private float amount;
	
	public RecordPO(UserPO user,RecordKind kind,Calendar date,int amount) {
		this.user = user;
		this.kind = kind;
		this.date = date;
		this.amount = amount;
	}
	
	public UserPO getName() {
		return user;
	}
	public void setName(UserPO user) {
		this.user = user;
	}
	public RecordKind getKind() {
		return kind;
	}
	public void setKind(RecordKind kind) {
		this.kind = kind;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
		
}
