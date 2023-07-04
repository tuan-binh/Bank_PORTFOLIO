package view.employee;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.UserController;
import model.Present;
import model.Roles;
import model.User;
import view.Navbar;

public class MenuEmployee {
	private UserController userController;
	private PresentController presentController;
	
	public MenuEmployee(UserController userController, PresentController presentController) {
		this.userController = userController;
		this.presentController = presentController;
		while (true) {
			Navbar.MenuEmployee();
			System.out.print("Enter choice: ");
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
				case 5:
					return;
				default:
					break;
			}
		}
	}
	
	public void changeMoneyUser() {
	
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
	
	}
}
