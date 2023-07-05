package view.user;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.User;
import view.Navbar;

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
					break;
				case 2:
					break;
				case 0:
					return;
				default:
					break;
			}
		}
	}
}
