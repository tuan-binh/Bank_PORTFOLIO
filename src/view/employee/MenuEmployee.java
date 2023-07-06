package view.employee;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.Present;
import model.Roles;
import model.Saving;
import model.User;
import view.Navbar;

import java.util.Calendar;
import java.util.Date;

import static config.ColorConsole.BLUE;
import static config.ColorConsole.PURPLE;

public class MenuEmployee {
	private UserController userController;
	private PresentController presentController;
	
	private SavingController savingController;
	
	public MenuEmployee(UserController userController, PresentController presentController, SavingController savingController) {
		this.userController = userController;
		this.presentController = presentController;
		this.savingController = savingController;
		while (true) {
			Navbar.MenuEmployee();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					changeMoneyUser();
					break;
				case 2:
					showInformationUser();
					break;
				case 3:
					showInterestRate();
					break;
				case 4:
					addInterestRateToUser();
					break;
				case 0:
					return;
				default:
					break;
			}
		}
	}
	
	public void changeMoneyUser() {
		System.out.print("Nhập vào ID: ");
		int id = InputMethods.getInteger();
		User user = userController.findById(id);
		if (user == null || user.getRoles().equals(Roles.EMPLOYEE) || user.getRoles().equals(Roles.ADMIN)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		System.out.println("╔═════════════════╗");
		System.out.println("║   " + PURPLE + "1. Nạp Tiền   " + BLUE + "║");
		System.out.println("║   " + PURPLE + "2. Rút Tiền   " + BLUE + "║");
		System.out.println("╚═════════════════╝");
		System.out.print(Message.CHOICE);
		int choice = InputMethods.getInteger();
		switch (choice) {
			case 1:
				addMoney(user);
				break;
			case 2:
				minusMoney(user);
				break;
			default:
				System.err.println(Message.YOU_WRONG);
				break;
		}
	}
	
	public void addMoney(User user) {
		System.out.print("Bạn muốn nạp bao nhiêu: ");
		long money = InputMethods.getPositiveLong();
		user.setMoney(user.getMoney() + money);
		userController.save(user);
	}
	
	public void minusMoney(User user) {
		System.out.print("Bạn muốn rút bao nhiêu: ");
		long money = InputMethods.getPositiveLong();
		if (money > user.getMoney()) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		user.setMoney(user.getMoney() - money);
		userController.save(user);
	}
	
	public void showInformationUser() {
		System.out.println("============================================================");
		for (User u : userController.getAll()) {
			if (u.getRoles().equals(Roles.USER)) {
				System.out.println(u);
			}
		}
		System.out.println("============================================================");
	}
	
	public void showInterestRate() {
		if (presentController.getAll().size() == 0) {
			System.err.println(Message.EMPTY);
			return;
		}
		System.out.println("====================================");
		for (Present p : presentController.getAll()) {
			System.out.println(p);
		}
		System.out.println("====================================");
	}
	
	public void addInterestRateToUser() {
		Date date = new Date();
		System.out.print("Nhập vào ID người dùng: ");
		int id = InputMethods.getInteger();
		User user = userController.findById(id);
		if (user == null || user.getRoles().equals(Roles.ADMIN) || user.getRoles().equals(Roles.EMPLOYEE)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		showInterestRate();
		while (true) {
			System.out.print("Nhập vào ID lãi xuất: ");
			int idInterestRate = InputMethods.getInteger();
			Present interestRate = presentController.findById(idInterestRate);
			if (interestRate != null) {
				// khởi tạo ngày sau 3 tháng
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.MONTH, interestRate.getLimitMonth());
				Date newDate = cal.getTime();
				
				// khởi tạo đối tượng saving
				Saving saving = new Saving();
				saving.setId(savingController.getNewId(user.getList()));
				System.out.print("Nhập vào số tiền muốn gửi: ");
				long money = InputMethods.getLong();
				if (money <= user.getMoney()) {
					saving.setMoneySaving(money);
					user.setMoney((long) (user.getMoney() - money));
				} else {
					System.err.println(Message.NOT_ENOUGH);
				}
				saving.setPresent(interestRate.getPresent());
				saving.setMonth(interestRate.getLimitMonth());
				saving.setSentDate(date);
				saving.setDueDate(newDate);
				savingController.save(user.getList(), saving);
				userController.save(user);
			} else {
				System.err.println(Message.NOT_FOUND);
			}
		}
		
	}
}
