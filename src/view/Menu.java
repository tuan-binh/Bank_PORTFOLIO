package view;

import config.InputMethods;
import config.Message;
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
	
	static User dataAdmin;
	
	public static void main(String[] args) {
		if (userController.getAll().size() > 0) {
			dataAdmin = userController.findById(0);
		}
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
				case 0:
					return;
				default:
					System.err.println("Try again 1 to 3");
					break;
			}
		}
	}
	
	public static void login() {
		System.out.print("Nhập tên đăng nhập: ");
		String username = InputMethods.getString();
		System.out.print("Nhập mật khẩu: ");
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
				new MenuEmployee(dataAdmin,userController, presentController, savingController);
			} else {
				if (user.isStatus()) {
					// user open
					new MenuUser(user, userController, presentController, savingController);
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
		if (user.getPassword().equals(confirmPassword)) {
			boolean check = userController.register(user.getUsername());
			if (check) {
				userController.save(user);
				System.out.println(Message.REGISTER_SUCCESS);
			} else {
				System.err.println(Message.REGISTER_FAILED);
			}
		} else {
			System.err.println("Mật khẩu không trùng nhau");
		}
	}
}
