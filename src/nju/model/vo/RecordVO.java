package nju.model.vo;

import java.util.Calendar;

import nju.model.po.RecordPO;

public class RecordVO {

	private Calendar date;
	private float income;
	private float expense;
	private float transportation;
	private float catering;
	private float entertainment;
	private float transferaccounts;
	private float wage;
	
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public void addIncome(float income) {
		this.income += income;
	}
	public float getExpense() {
		return expense;
	}
	public void setExpense(float expense) {
		this.expense = expense;
	}
	public void addExpense(float expense) {
		this.expense += expense;
	}
	public float getTransportation() {
		return transportation;
	}
	public void setTransportation(float transportation) {
		this.transportation = transportation;
	}
	public void addTransportation(float transportation) {
		this.transportation += transportation;
	}
	public float getCatering() {
		return catering;
	}
	public void setCatering(float catering) {
		this.catering = catering;
	}
	public void addCatering(float catering) {
		this.catering += catering;
	}
	public float getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(float entertainment) {
		this.entertainment = entertainment;
	}
	public void addEntertainment(float entertainment) {
		this.entertainment += entertainment;
	}
	public float getTransferaccounts() {
		return transferaccounts;
	}
	public void setTransferaccounts(float transferaccounts) {
		this.transferaccounts = transferaccounts;
	}
	public void addTransferaccounts(float transferaccounts) {
		this.transferaccounts += transferaccounts;
	}
	public float getWage() {
		return wage;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public void addWage(float wage) {
		this.wage += wage;
	}
	
	
}
