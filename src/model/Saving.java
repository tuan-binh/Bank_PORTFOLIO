package model;

import java.util.Calendar;
import java.util.Date;

public class Saving {
    private int id;
    private double moneySaving;  // số tiền gửi
    private double present;  // phẩn trăm lãi xuất
    private int month;        // số tháng
    private Calendar sentDate; // Ngày gửi
    private Calendar dueDate;  // Ngày đáo hạn

    public Saving() {
    }

    public Saving(int id, double moneySaving, double present, int month, Calendar sentDate, Calendar dueDate) {
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

    public Calendar getSentDate() {
        return sentDate;
    }

    public void setSentDate(Calendar sentDate) {
        this.sentDate = sentDate;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Money: " + moneySaving + " | present: " + present + " | month: " + month + " | sentDate: " + sentDate + " | dueDate: " + dueDate;
    }
}
