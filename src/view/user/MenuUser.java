package view.user;

import config.InputMethods;
import config.Message;
import config.Validate;
import controller.HistoryController;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.History;
import model.Roles;
import model.User;
import view.Menu;
import view.Navbar;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Date;

import static config.ColorConsole.BLUE;
import static config.ColorConsole.PURPLE;

public class MenuUser {
	
	private User data;
	private UserController userController;
	private PresentController presentController;
	private SavingController savingController;
	private HistoryController historyController;
	
	public MenuUser(User data, UserController userController, PresentController presentController, SavingController savingController, HistoryController historyController) {
		this.data = data;
		this.userController = userController;
		this.presentController = presentController;
		this.savingController = savingController;
		this.historyController = historyController;
		System.out.println();
		while (true) {
			showName(data);
			Navbar.MenuUser(getNotification());
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					// xem thông tin tài khoản
					showInformation();
					break;
				case 2:
					// chuyển tiền
					sentMoneyToUser();
					break;
				case 3:
					// gửi tiền tiết kiệm
					new UserInterestRate(data, userController, presentController, savingController, historyController);
					break;
				case 4:
					// nạp tiền
					System.out.println("╔═════════════════╗");
					System.out.println("║   " + PURPLE + "1. Nạp Tiền   " + BLUE + "║");
					System.out.println("║   " + PURPLE + "2. Rút Tiền   " + BLUE + "║");
					System.out.println("╚═════════════════╝");
					System.out.print(Message.CHOICE);
					int choose = InputMethods.getInteger();
					switch (choose) {
						case 1:
							deposit();
							break;
						case 2:
							withdrawals();
							break;
						default:
							break;
					}
					break;
				case 5:
					// history
					new WatchHistories(data, userController);
					break;
				case 6:
					// change tài khoản với tên
					changeInformation();
					break;
				case 7:
					// change mật khẩu
					changePassword();
					break;
				case 0:
					return;
				default:
					System.err.print("Try again 0 to 5");
					break;
			}
		}
	}
	
	public void showInformation() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃ " + PURPLE + "Name: %50s " + BLUE + "┃", data.getFullName().toUpperCase());
		System.out.printf("\n┃ " + PURPLE + "Username: %46s " + BLUE + "┃", data.getUsername());
		System.out.printf("\n┃ " + PURPLE + "Account Number: %40s " + BLUE + "┃", data.getAN());
		System.out.printf("\n┃ " + PURPLE + "Money: %49s " + BLUE + "┃\n", InputMethods.formatNumber().format(data.getMoney()));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public void sentMoneyToUser() {
		while (true) {
			if (data.getMoney() == 0) {
				System.err.println(Message.NOT_ENOUGH);
				break;
			}
			System.out.print("Nhập vào số tài khoản muốn chuyển đến: ");
			String an = InputMethods.getString();
			User check = null;
			for (User user : userController.getAll()) {
				if (user.getAN() != null && user.getAN().equals(an) && user.getRoles().equals(Roles.USER) && !user.getUsername().equals(data.getUsername())) {
					check = user;
				}
			}
			if (check != null) {
				while (true) {
					System.out.print("Nhập số tiền bạn muốn chuyển: ");
					long money = InputMethods.getPositiveLong();
					if (money == 0) {
						System.err.println(Message.YOU_WRONG);
						break;
					}
					if (money < data.getMoney()) {
						System.out.print("Nhập mật khẩu: ");
						String password = InputMethods.getString();
						password = Menu.getHashCodePassword(password);
						if (password.equals(data.getPassword())) {
							data.setMoney(data.getMoney() - money);
							check.setMoney(check.getMoney() + money);
							// khởi tạo đối tượng lịch sử
							History me = getMyHistory(historyController.getNewIdWithG(data.getHistories()), data, check, money);
							History friend = getMyHistory(historyController.getNewIdWithN(check.getHistories()), check, data, money);
							// lưu đối tượng vào lịch sử của thằng đấy
							historyController.save(data.getHistories(), me);
							historyController.save(check.getHistories(), friend);
							// lưu đối tượng
							userController.save(check);
							userController.save(data);
						} else {
							continue;
						}
						break;
					} else {
						System.err.println(Message.NOT_ENOUGH);
					}
				}
				break;
			} else {
				System.err.println(Message.NOT_FOUND);
				break;
			}
		}
	}
	
	public static History getMyHistory(String id, User user1, User user2, long money) {
		Date date = new Date();
		History history = new History();
		history.setId(id);
		history.setMoney(money);
		history.setUser1(user1);
		history.setUser2(user2);
		history.setTime(date);
		return history;
	}
	
	public void deposit() {
		while (true) {
			showName(data);
			Navbar.showDeposit();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					addMoney(200000);
					break;
				case 2:
					addMoney(500000);
					break;
				case 3:
					addMoney(1000000);
					break;
				case 4:
					addMoney(2000000);
					break;
				case 0:
					return;
				default:
					System.err.println(Message.YOU_WRONG);
					break;
			}
		}
	}
	
	public void withdrawals() {
		while (true) {
			showName(data);
			Navbar.showDeposit();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					if (200000 < data.getMoney()) {
						minusMoney(200000);
					} else {
						System.err.println(Message.NOT_ENOUGH);
					}
					break;
				case 2:
					if (500000 < data.getMoney()) {
						minusMoney(500000);
					} else {
						System.err.println(Message.NOT_ENOUGH);
					}
					break;
				case 3:
					if (1000000 < data.getMoney()) {
						minusMoney(1000000);
					} else {
						System.err.println(Message.NOT_ENOUGH);
					}
					break;
				case 4:
					if (2000000 < data.getMoney()) {
						minusMoney(2000000);
					} else {
						System.err.println(Message.NOT_ENOUGH);
					}
					break;
				case 0:
					return;
				default:
					System.err.println(Message.YOU_WRONG);
					break;
			}
		}
	}
	
	public void addMoney(long money) {
		System.out.print("Nhập mật khẩu: ");
		String password = InputMethods.getString();
		password = Menu.getHashCodePassword(password);
		if (password.equals(data.getPassword())) {
			data.setMoney(data.getMoney() + money);
			History hisNAP = getMyHistory(historyController.getNewIdWithNAP(data.getHistories()), data, null, money);
			historyController.save(data.getHistories(), hisNAP);
			userController.save(data);
			System.out.println(Message.SUCCESS);
		} else {
			System.err.println(Message.YOU_WRONG);
		}
	}
	
	public void minusMoney(long money) {
		System.out.print("Nhập mật khẩu: ");
		String password = InputMethods.getString();
		password = Menu.getHashCodePassword(password);
		if (password.equals(data.getPassword())) {
			data.setMoney(data.getMoney() - money);
			History hisRUT = getMyHistory(historyController.getNewIdWithRUT(data.getHistories()), data, null, money);
			historyController.save(data.getHistories(), hisRUT);
			userController.save(data);
			System.out.println(Message.SUCCESS);
		} else {
			System.err.println(Message.YOU_WRONG);
		}
	}
	
	public void changeInformation() {
		User newUser = new User();
		newUser.setId(data.getId());
		newUser.setPassword(data.getPassword());
		newUser.setAN(data.getAN());
		newUser.setMoney(data.getMoney());
		newUser.setList(data.getList());
		newUser.setHistories(data.getHistories());
		newUser.setRoles(data.getRoles());
		newUser.setStatus(data.isStatus());
		System.out.printf("\nNhập tên mới (tên cũ: %s): ", data.getFullName());
		String name = InputMethods.getString();
		newUser.setFullName(name);
		data.setFullName(name);
		while (true) {
			boolean check = false;
			System.out.printf("\nNhập username (username cũ: %s): ", data.getUsername());
			String username = InputMethods.getString();
			if (!Validate.username(username)) {
				System.err.println(Message.YOU_WRONG);
				return;
			}
			for (User u : userController.getAll()) {
				if (!u.getUsername().equals(username)) {
					if (u.getUsername().equals(data.getUsername())) {
						check = true;
					}
				}
			}
			if (!check) {
				newUser.setUsername(username);
				userController.save(newUser);
				break;
			} else {
				System.err.println("Tên đăng nhập đã bị trùng");
			}
		}
	}
	
	public void changePassword() {
		User newUser = new User();
		newUser.setId(data.getId());
		newUser.setFullName(data.getFullName());
		newUser.setUsername(data.getUsername());
		newUser.setAN(data.getAN());
		newUser.setMoney(data.getMoney());
		newUser.setList(data.getList());
		newUser.setHistories(data.getHistories());
		newUser.setRoles(data.getRoles());
		newUser.setStatus(data.isStatus());
		while (true) {
			System.out.print("Nhập vào mật khẩu cũ: ");
			String oldPassword = InputMethods.getString();
			oldPassword = Menu.getHashCodePassword(oldPassword);
			if (oldPassword.equals(data.getPassword())) {
				System.out.print("Nhập mật khẩu mới: ");
				String newPassword = InputMethods.getString();
				if (Validate.password(newPassword)) {
					newPassword = Menu.getHashCodePassword(newPassword);
				} else {
					System.err.println(Message.YOU_WRONG);
					break;
				}
				System.out.print("Xác nhận mật khẩu: ");
				String confirmPassword = InputMethods.getString();
				if (Validate.password(confirmPassword)) {
					confirmPassword = Menu.getHashCodePassword(confirmPassword);
				} else {
					System.err.println(Message.YOU_WRONG);
					break;
				}
				if (newPassword.equals(confirmPassword)) {
					newUser.setPassword(newPassword);
					data = newUser;
					userController.save(newUser);
				} else {
					System.out.println();
					continue;
				}
				break;
			} else {
				System.err.println(Message.YOU_WRONG);
			}
		}
	}
	
	public static void showName(User data) {
		System.out.print(BLUE + "┏");
		for (int i = 0; i < data.getFullName().length() + 2; i++) {
			System.out.print("━");
		}
		System.out.print("┓");
		System.out.println();
		System.out.printf("┃ " + PURPLE + "%s " + BLUE + "┃\n", data.getFullName().toUpperCase());
	}
	
	public int getNotification() {
		int result = 0;
		for (History h : data.getHistories()) {
			if (!h.isStatus()) {
				++result;
			}
		}
		return result;
	}
	
}
