package view;

import config.InputMethods;
import config.Message;
import config.Validate;
import controller.HistoryController;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.Roles;
import model.User;
import view.admin.MenuAdmin;
import view.employee.MenuEmployee;
import view.user.MenuUser;

public class Menu {
	static final UserController userController = new UserController();
	static final PresentController presentController = new PresentController();
	static final SavingController savingController = new SavingController();
	static final HistoryController historyController = new HistoryController();
	
	public static void main(String[] args) {
		while (true) {
			Navbar.Menu();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					login();
					break;
				case 2:
					register();
					break;
				case 3:
					forgetPassword();
					break;
				case 0:
					return;
				default:
					System.err.println("Try again 1 to 3");
					break;
			}
		}
	}
	
	public static void login() {
		System.out.print("Nhập tên đăng nhập : ");
		String username = InputMethods.getString();
		System.out.print("Nhập mật khẩu : ");
		String password = InputMethods.getString();
		User user = userController.login(username, password);
		if (user == null) {
			System.err.println(Message.SIGNIN_FAILED);
		} else {
			if (user.getRoles().equals(Roles.ADMIN)) {
				// admin
				new MenuAdmin(user, userController, presentController);
			} else if (user.getRoles().equals(Roles.EMPLOYEE)) {
				// employee
				new MenuEmployee(userController, presentController, savingController);
			} else {
				if (user.isStatus()) {
					// user open
					new MenuUser(user, userController, presentController, savingController, historyController);
				} else {
					// user blocked
					System.err.println(Message.ACCOUNT_BLOCKS);
				}
			}
		}
		System.out.println();
	}
	
	public static void register() {
		User user = new User();
		user.setId(userController.getNewId());
		user.inputData();
		System.out.print("Xác nhận mật khẩu: ");
		String confirmPassword = InputMethods.getString();
		// check username
		if (Validate.username(user.getUsername())) {
			// check password
			if (Validate.password(user.getPassword())) {
				// check 2 password có trùng nhau không
				if (user.getPassword().equals(confirmPassword)) {
					// check xem có bị trùng tên đăng nhập với người khác
					boolean check = userController.register(user.getUsername());
					while (true) {
						String an = getRandomSTK();
						boolean checkSTK = userController.checkSTK(an);
						if (checkSTK) {
							user.setAN(an);
							break;
						}
					}
					if (check) {
						userController.save(user);
						System.out.println(Message.REGISTER_SUCCESS);
					} else {
						System.err.println(Message.REGISTER_FAILED);
					}
				} else {
					System.err.println("Mật khẩu không trùng nhau");
				}
			} else {
				System.err.println("Mật khẩu không được có dấu cách");
			}
		} else {
			System.err.println("Tên đăng nhập không được có dấu cách");
		}
	}
	
	public static String getRandomSTK() {
		String result = "1001";
		for (int i = 0; i < 8; i++) {
			result += String.valueOf((int) Math.ceil(Math.random() * 9));
		}
		return result;
	}
	
	public static void forgetPassword() {
		System.out.print("Nhập tên đăng nhập: ");
		String username = InputMethods.getString();
		User myUser = null;
		for (User u : userController.getAll()) {
			if (u.getUsername().equals(username)) {
				myUser = u;
			}
		}
		
		if (myUser == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		String newPassword = newPassword();
		myUser.setPassword(newPassword);
		userController.save(myUser);
		System.out.println("Mật khẩu mới là: " + newPassword);
	}
	
	public static String newPassword() {
		String result = null;
		for (int i = 0; i < 5; i++) {
			if (result == null) {
				result = String.valueOf((int) Math.ceil(Math.random() * 9));
			}
			result += String.valueOf((int) Math.ceil(Math.random() * 9));
		}
		return result;
	}
	
}
