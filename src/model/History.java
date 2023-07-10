package model;

import config.InputMethods;

import java.io.Serializable;
import java.util.Date;

import static config.ColorConsole.*;

public class History implements Serializable {
	private String id; // id
	private long money; // số tiền
	private User user1; // người gửi
	private User user2; // người nhận
	private Date time; // thời gian gửi
	private boolean status;
	
	public History() {
		status = false;
	}
	
	public History(String id, long money, User user1, User user2, Date time) {
		this.id = id;
		this.money = money;
		this.user1 = user1;
		this.user2 = user2;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getMoney() {
		return money;
	}
	
	public void setMoney(long money) {
		this.money = money;
	}
	
	public User getUser1() {
		return user1;
	}
	
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void contentSend() {
		System.out.println(RED + user1.getUsername().toUpperCase() + GREEN + " Đã Gửi: " + RED + InputMethods.formatNumber().format(money) + GREEN + " Đến tài khoản: " + RED + user2.getUsername().toUpperCase());
		System.out.println(GREEN + "Lúc: " + RED + time);
	}
	
	public void contentReceive() {
		System.out.println(RED + user1.getUsername().toUpperCase() + GREEN + " Đã Nhận: " + RED + InputMethods.formatNumber().format(money) + GREEN + " Từ tài khoản: " + RED + user2.getUsername().toUpperCase());
		System.out.println(GREEN + "Lúc: " + RED + time);
	}
	
	public void contentChanged() {
		System.out.println(RED + user1.getUsername().toUpperCase() + GREEN + " Đã Nạp: " + RED + InputMethods.formatNumber().format(money));
		System.out.println(GREEN + "Lúc: " + RED + time);
	}
	
}
