package view.user;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.Present;
import model.Saving;
import model.User;
import view.Menu;
import view.Navbar;

import java.util.Calendar;
import java.util.Date;

public class UserInterestRate {
	private User data;
	private UserController userController;
	private PresentController presentController;
	private SavingController savingController;
	
	public UserInterestRate(User data, UserController userController, PresentController presentController, SavingController savingController) {
		this.data = data;
		this.userController = userController;
		this.presentController = presentController;
		this.savingController = savingController;
		while (true) {
			MenuUser.showName(data);
			Navbar.UserInterestRate();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					showListInterestRate();
					break;
				case 2:
					showMyListInterestRate();
					break;
				case 0:
					return;
				default:
					break;
			}
		}
	}
	
	public void showListInterestRate() {
		if (presentController.getAll().size() == 0) {
			System.err.println(Message.EMPTY);
			return;
		}
		System.out.println("=========================================");
		for (Present p : presentController.getAll()) {
			System.out.println(p);
		}
		System.out.println("=========================================");
		System.out.print("Lựa chọn ID gói ( 0 : Để Thoát ): ");
		int id = InputMethods.getInteger();
		Present present = presentController.findById(id);
		if (present == null) {
			return;
		}
		while (true) {
			// khởi tạo ngày sau 3 tháng
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, present.getLimitMonth());
			Date newDate = cal.getTime();
			
			// khởi tạo đối tượng saving
			Saving saving = new Saving();
			saving.setId(savingController.getNewId(data.getList()));
			System.out.print("Nhập vào số tiền: ");
			long money = InputMethods.getLong();
			if (money == 0) {
				System.err.println(Message.YOU_WRONG);
				break;
			}
			if (money <= data.getMoney()) {
				System.out.print("Nhập mật khẩu: ");
				String pass = InputMethods.getString();
				pass = Menu.getHashCodePassword(pass);
				if (pass.equals(data.getPassword())) {
					saving.setMoneySaving(money);
					data.setMoney(data.getMoney() - money);
					saving.setPresent(present.getPresent());
					saving.setMonth(present.getLimitMonth());
					saving.setSentDate(date);
					saving.setDueDate(newDate);
					savingController.save(data.getList(), saving);
					userController.save(data);
					System.out.println(Message.SUCCESS);
				} else {
					System.err.println(Message.YOU_WRONG);
				}
				break;
			} else {
				System.err.println(Message.NOT_ENOUGH);
			}
			
		}
	}
	
	public void showMyListInterestRate() {
		if (data.getList().size() == 0) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		showMyList();
		MenuUser.showName(data);
		Navbar.ShowMyInterestRate();
		System.out.print(Message.CHOICE);
		int choice = InputMethods.getInteger();
		switch (choice) {
			case 1:
				minusAPart();
				break;
			case 2:
				minusAll();
				break;
			case 0:
				return;
			default:
				System.err.println("Try again 0 to 2");
				break;
		}
	}
	
	public void minusAPart() {
		Date nowDate = new Date();
		System.out.print("Nhập vào ID bạn muốn rút: ");
		int id = InputMethods.getInteger();
		Saving saving = savingController.findById(data.getList(), id);
		if (saving == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		while (true) {
			System.out.print("Nhập vào số tiền: ");
			double money = InputMethods.getPositiveLong();
			if (money == 0) {
				System.err.println(Message.YOU_WRONG);
				break;
			}
			System.out.print("Nhập mật khẩu: ");
			String pass = InputMethods.getString();
			pass = Menu.getHashCodePassword(pass);
			if (pass.equals(data.getPassword())) {
				long result = 0;
				if (money < saving.getMoneySaving()) {
					result = (long) (money + getMoneyAfterSaving(saving.getSentDate(), nowDate, saving));
				}
				if (money == saving.getMoneySaving()) {
					result = removeSaving(id);
				}
//				System.out.println(result);
				data.setMoney(data.getMoney() + result);
				saving.setMoneySaving((long) (saving.getMoneySaving() - money));
				savingController.save(data.getList(), saving);
				userController.save(data);
				break;
			} else {
				System.err.println(Message.YOU_WRONG);
			}
		}
	}
	
	public void minusAll() {
		System.out.print("Nhập vào ID bạn muốn rút: ");
		int id = InputMethods.getInteger();
		Saving saving = savingController.findById(data.getList(), id);
		if (saving != null) {
			while (true) {
				System.out.print("Nhập mật khẩu: ");
				String pass = InputMethods.getString();
				pass = Menu.getHashCodePassword(pass);
				if (pass.equals(data.getPassword())) {
					long result = removeSaving(id);
					data.setMoney(data.getMoney() + result);
					userController.save(data);
					break;
				} else {
					System.err.println(Message.YOU_WRONG);
				}
			}
		}
	}
	
	public long removeSaving(int id) {
		Date date = new Date();
		Saving saving = savingController.findById(data.getList(), id);
		long result = saving.getMoneySaving() + getMoneyAfterSaving(saving.getSentDate(), date, saving);
		savingController.delete(data.getList(), id);
		return result;
	}
	
	public long getMoneyAfterSaving(Date date1, Date date2, Saving saving) {
		long result = 0;
		try {
			long dayDiff = date2.getTime() - date1.getTime();
			long day = dayDiff / (24 * 60 * 60 * 1000);
			if (day == 0) {
				result = saving.getMoneySaving();
			}
			result = (long) (saving.getMoneySaving() * (saving.getPresent() / 100) * day / 365);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void showMyList() {
		System.out.println("═══════════════════════════════════════════════════════════");
		for (Saving s : data.getList()) {
			System.out.println(s);
			System.out.println("═══════════════════════════════════════════════════════════");
		}
	}
	
}
