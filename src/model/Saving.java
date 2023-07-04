package model;

import java.util.Date;

public class Saving {
	private int id;
	private double moneySaving;
	private double present;
	private int month;
	private Date sentDate;
	private Date dueDate;
	
	public Saving() {
	}
	
	public Saving(int id, double moneySaving, double present, int month, Date sentDate, Date dueDate) {
		this.id = id;
		this.moneySaving = moneySaving;
		this.present = present;
		this.month = month;
		this.sentDate = sentDate;
		this.dueDate = dueDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getMoneySaving() {
		return moneySaving;
	}
	
	public void setMoneySaving(double moneySaving) {
		this.moneySaving = moneySaving;
	}
	
	public double getPresent() {
		return present;
	}
	
	public void setPresent(double present) {
		this.present = present;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public Date getSentDate() {
		return sentDate;
	}
	
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + " | Money: " + moneySaving + " | present: " + present + " | month: " + month + " | sentDate: " + sentDate + " | dueDate: " + dueDate;
	}
}
