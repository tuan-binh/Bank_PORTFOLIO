package model;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
	private String id; // id
	private long money; // số tiền
	private User user1; // người gửi
	private User user2; // người nhận
	private Date time; // thời gian gửi
	
	public History() {
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
	
	public void contentSend() {
		System.out.println(user1.getUsername() + " Đã Gửi: " + money + " Đến tài khoản: " + user2.getUsername());
		System.out.println("Lúc: " + time);
	}
	
	public void contentReceive() {
		System.out.println(user1.getUsername() + " Đã Nhận: " + money + " Từ tài khoản: " + user2.getUsername());
		System.out.println("Lúc: " + time);
	}
	
}
