package model;

import config.InputMethods;

import java.io.Serializable;

import static config.ColorConsole.*;

public class Present implements Serializable {
	private int id;
	private double present;
	private int limitMonth;
	
	public Present() {
	}
	
	public Present(int id, double present, int limitMonth) {
		this.id = id;
		this.present = present;
		this.limitMonth = limitMonth;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPresent() {
		return present;
	}
	
	public void setPresent(double present) {
		this.present = present;
	}
	
	public int getLimitMonth() {
		return limitMonth;
	}
	
	public void setLimitMonth(int limitMonth) {
		this.limitMonth = limitMonth;
	}
	
	public void inputData() {
		System.out.print("Nhập phần trăm (1 đến 10): ");
		this.present = InputMethods.getPresent();
		System.out.print("Nhập tháng: ");
		this.limitMonth = InputMethods.getMonth();
	}
	
	@Override
	public String toString() {
		return "( ID: " + RED + id + BLUE + " | presents: " + RED + present + BLUE + " % / năm | Month: " + RED + limitMonth + BLUE + " )";
	}
}
