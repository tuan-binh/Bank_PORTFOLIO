package model;

import config.InputMethods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private long money;
    private List<Saving> list;
    private Roles roles;
    private boolean status;

    public User() {
        list = new ArrayList<>();
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

    public User(int id, String fullName, String username, String password, long money, List<Saving> list, Roles roles, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.money = money;
        this.list = list;
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
        System.out.print("Enter your name: ");
        this.fullName = InputMethods.getString();
        System.out.print("Enter your username: ");
        this.username = InputMethods.getString();
        System.out.print("Enter your password: ");
        this.password = InputMethods.getString();
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | Name: " + fullName + " | Username: " + username + " | Money: " + money + " | Status: " + (status ? "Unblock" : "Block") + " ]";
    }
}
