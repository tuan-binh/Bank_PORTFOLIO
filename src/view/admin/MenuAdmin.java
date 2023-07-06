package view.admin;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.UserController;
import model.Roles;
import model.User;
import view.Navbar;
import view.admin.EmployeeManager;
import view.admin.InterestRateManager;
import view.admin.MoneyManager;
import view.admin.UserManager;

import java.util.HashMap;
import java.util.Map;

import static config.ColorConsole.*;

public class MenuAdmin {
	private static User admin;
	private static UserController userController;
	private static PresentController presentController;
	
	public MenuAdmin(User user, UserController userController, PresentController presentController) {
		this.admin = user;
		this.userController = userController;
		this.presentController = presentController;
		while (true) {
			System.out.println();
			showInformation();
			Navbar.MenuAdmin();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					new EmployeeManager(userController);
					break;
				case 2:
					new UserManager(userController);
					break;
				case 3:
					new MoneyManager(admin);
					break;
				case 4:
					new InterestRateManager(presentController);
					break;
				case 0:
					return;
				default:
					System.err.println("Try again 0 to 4");
					break;
			}
		}
		
	}
	
	public static void showInformation() {
		Map<Roles, Integer> myList = new HashMap<>();
		myList.put(Roles.EMPLOYEE, 0);
		myList.put(Roles.USER, 0);
		for (Map.Entry<Roles, Integer> entry : myList.entrySet()) {
			for (User u : userController.getAll()) {
				if (entry.getKey().equals(u.getRoles())) {
					entry.setValue(entry.getValue() + 1);
				}
			}
		}
		for (Map.Entry<Roles, Integer> entry : myList.entrySet()) {
			System.out.println(BLUE+" *> " + entry.getKey() + " -> Số Lượng: " + entry.getValue());
		}
		System.out.println(" *> CAPITAL FUNDS: " + InputMethods.formatNumber().format(admin.getMoney()));
	}
	
}
