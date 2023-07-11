package model;

import config.InputMethods;

import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static config.ColorConsole.*;

public class User implements Serializable {
	private int id;
	private String fullName;
	private String username;
	private String password;
	private String AN;
	private long money;
	private List<Saving> list;
	private LinkedList<History> histories;
	private Roles roles;
	private boolean status;
	
	public User() {
		list = new ArrayList<>();
		histories = new LinkedList<>();
		roles = Roles.USER;
		status = true;
	}
	
	public User(int id, String fullName, String username, String password, long money, Roles roles) {
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.money = money;
		this.roles = roles;
	}
	
	public User(int id, String fullName, String username, String password, String AN, long money, List<Saving> list, LinkedList<History> histories, Roles roles, boolean status) {
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.AN = AN;
		this.money = money;
		this.list = list;
		this.histories = histories;
		this.roles = roles;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAN() {
		return AN;
	}
	
	public void setAN(String AN) {
		this.AN = AN;
	}
	
	public long getMoney() {
		return money;
	}
	
	public void setMoney(long money) {
		this.money = money;
	}
	
	public List<Saving> getList() {
		return list;
	}
	
	public void setList(List<Saving> list) {
		this.list = list;
	}
	
	public LinkedList<History> getHistories() {
		return histories;
	}
	
	public void setHistories(LinkedList<History> histories) {
		this.histories = histories;
	}
	
	public Roles getRoles() {
		return roles;
	}
	
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void inputData() {
		System.out.print("Nhập tên của bạn: ");
		this.fullName = InputMethods.getString();
		System.out.print("Nhập tên đăng nhập của bạn (Không được có dấu cách): ");
		this.username = InputMethods.getString();
		System.out.print("Nhập mật khẩu của bạn (Không được có dấu cách và lớn hơn 6): ");
		this.password = InputMethods.getString();
	}
	
	
	@Override
	public String toString() {
		return "ID: " + RED + id + BLUE + " | Name: " + RED + fullName + BLUE + " | Username: " + RED + username + BLUE + " | Password: " + RED + password + BLUE +
				  "\nAccount Number: " + RED + AN + BLUE + " | Money: " + RED + InputMethods.formatNumber().format(money) + BLUE + " | Status: " + RED + (status ? "Unblock" : "Block") + BLUE;
	}
}
