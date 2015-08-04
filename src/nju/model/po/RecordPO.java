package nju.model.po;

import java.util.Calendar;

public class RecordPO {

	private UserPO user;
	private RecordKind kind;
	private Calendar date;
	private int amount;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
