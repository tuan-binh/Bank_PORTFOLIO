package view.admin;

import config.InputMethods;
import config.Message;
import controller.UserController;
import model.Roles;
import model.User;
import view.Navbar;

public class UserManager {
	
	private UserController userController;
	
	public UserManager(UserController userController) {
		this.userController = userController;
		while (true) {
			MenuAdmin.showInformation();
			Navbar.User();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					showListUsers();
					break;
				case 2:
					searchUsers();
					break;
				case 3:
					changeStatusUser();
					break;
				case 4:
					getNewPassword();
					break;
				case 0:
					return;
				default:
					System.err.println("Try again 0 to 3");
					break;
			}
		}
	}
	
	public void showListUsers() {
		System.out.println("==============================================================================");
		for (User u : userController.getAll()) {
			if (u.getRoles().equals(Roles.USER)) {
				System.out.println(u);
				System.out.println("==============================================================================");
			}
		}
		System.out.println();
	}
	
	public void searchUsers() {
		System.out.print("Nhập từ tìm người dùng: ");
		String text = InputMethods.getString();
		System.out.println("============================================================");
		for (User u : userController.getAll()) {
			if (u.getFullName().toLowerCase().contains(text.toLowerCase()) && u.getRoles().equals(Roles.USER)) {
				System.out.println(u);
				System.out.println("============================================================");
			}
		}
		System.out.println();
	}
	
	public void changeStatusUser() {
		System.out.print("Nhập ID người dùng để thay đổi trạng thái: ");
		int id = InputMethods.getInteger();
		User user = userController.findById(id);
		if (user == null || user.getRoles().equals(Roles.ADMIN) || user.getRoles().equals(Roles.EMPLOYEE)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		userController.changeStatus(id);
	}
	
	public void getNewPassword() {
		System.out.print("Nhập ID người dùng cấp lại mật khẩu: ");
		int id = InputMethods.getInteger();
		User user = userController.findById(id);
		if (user == null || user.getRoles().equals(Roles.ADMIN) || user.getRoles().equals(Roles.EMPLOYEE)) {
			System.err.println(Message.NOT_ENOUGH);
			return;
		}
		String newPassword = newPassword();
		user.setPassword(newPassword);
		userController.save(user);
		System.out.println("Mật khẩu mới: " + newPassword);
	}
	
	public String newPassword() {
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
