package view;

import controller.UserController;
import model.Roles;
import model.User;

public class Datatest {
	static final UserController userController = new UserController();
	
	public static void main(String[] args) {
		User admin = new User(1, "john", "admin", "123", 1200000000, Roles.ADMIN);
		userController.save(admin);
	}
}
