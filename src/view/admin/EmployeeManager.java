package view.admin;

import config.InputMethods;
import config.Message;
import controller.UserController;
import model.Roles;
import model.User;
import view.Navbar;

public class EmployeeManager {
	private UserController userController;
	
	public EmployeeManager(UserController userController) {
		this.userController = userController;
		while (true) {
			MenuAdmin.showInformation();
			Navbar.Employee();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					editEmployee();
					break;
				case 3:
					layoffEmployee();
					break;
				case 4:
					searchEmployee();
					break;
				case 5:
					showListEmployees();
					break;
				case 0:
					return;
				default:
					System.err.println("Try again 1 to 6");
					break;
			}
		}
	}
	
	public void addEmployee() {
		User employee = new User();
		employee.setId(userController.getNewId());
		employee.inputData();
		employee.setRoles(Roles.EMPLOYEE);
		boolean check = userController.register(employee.getUsername());
		if (check) {
			userController.save(employee);
			System.out.println(Message.REGISTER_SUCCESS);
		} else {
			System.err.println(Message.REGISTER_FAILED);
		}
	}
	
	public void editEmployee() {
		System.out.print("Enter ID you want to edit: ");
		int id = InputMethods.getInteger();
		User user = userController.findById(id);
		if (user == null || user.getRoles().equals(Roles.ADMIN) || user.getRoles().equals(Roles.USER)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.inputData();
		newUser.setRoles(Roles.EMPLOYEE);
		userController.save(newUser);
	}
	
	public void layoffEmployee() {
		System.out.print("Enter ID you want to layoff: ");
		int id = InputMethods.getInteger();
		User employee = userController.findById(id);
		if (employee == null || employee.getRoles().equals(Roles.ADMIN) || employee.getRoles().equals(Roles.USER)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		userController.delete(id);
	}
	
	public void searchEmployee() {
		System.out.print("Enter text your want search: ");
		String text = InputMethods.getString();
		System.out.println("============================================================");
		for (User u : userController.getAll()) {
			if (u.getFullName().toLowerCase().contains(text.toLowerCase())) {
				if (u.getRoles().equals(Roles.EMPLOYEE)) {
					System.out.println(u);
				}
			}
		}
		System.out.println("============================================================");
	}
	
	public void showListEmployees() {
		System.out.println("============================================================");
		for (User e : userController.getAll()) {
			if (e.getRoles().equals(Roles.EMPLOYEE)) {
				System.out.println(e);
			}
		}
		System.out.println("============================================================");
	}
	
}
