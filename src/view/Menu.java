package view;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.UserController;
import model.Roles;
import model.User;
import view.admin.MenuAdmin;
import view.employee.MenuEmployee;
import view.user.MenuUser;

public class Menu {
	static final UserController userController = new UserController();
	static final PresentController presentController = new PresentController();
	
	
	public static void main(String[] args) {
		while (true) {
			Navbar.Menu();
			System.out.print("Vui lòng chọn: ");
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
					return;
				default:
					System.err.println("Try again 1 to 3");
					break;
			}
		}
	}
	
	public static void login() {
		System.out.print("Enter your username: ");
		String username = InputMethods.getString();
		System.out.print("Enter your password: ");
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
				new MenuEmployee(userController, presentController);
			} else {
				if (user.isStatus()) {
					// user open
					new MenuUser();
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
		boolean check = userController.register(user.getUsername());
		if (check) {
			userController.save(user);
			System.out.println(Message.REGISTER_SUCCESS);
		} else {
			System.err.println(Message.REGISTER_FAILED);
		}
	}
}
