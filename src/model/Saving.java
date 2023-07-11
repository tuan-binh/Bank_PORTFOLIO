package model;

import config.InputMethods;

import java.io.Serializable;
import java.util.Date;

import static config.ColorConsole.*;

public class Saving implements Serializable {
	private int id;
	private long moneySaving;  // số tiền gửi
	private double present;  // phẩn trăm lãi xuất
	private int month;        // số tháng
	private Date sentDate; // Ngày gửi
	private Date dueDate;  // Ngày đáo hạn
	
	public Saving() {
	}
	
	public Saving(int id, long moneySaving, double present, int month, Date sentDate, Date dueDate) {
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
	
	public long getMoneySaving() {
		return moneySaving;
	}
	
	public void setMoneySaving(long moneySaving) {
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
		return "ID: " + RED + id + BLUE + " | Money: " + RED + InputMethods.formatNumber().format(moneySaving) + BLUE + " | present: " + RED + present + BLUE + " % / năm | month: " + RED + month + BLUE +
				  "\nSentDate: " + RED + sentDate + BLUE +
				  "\nDueDate: " + RED + dueDate + BLUE;
	}
}
