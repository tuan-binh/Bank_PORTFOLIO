package view.admin;

import config.InputMethods;
import config.Message;
import config.Validate;
import controller.UserController;
import model.Roles;
import model.User;
import view.Navbar;

import java.util.ArrayList;
import java.util.List;

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
					System.err.println("Try again 0 to 5");
					break;
			}
		}
	}
	
	public void addEmployee() {
		User employee = new User();
		employee.setId(userController.getNewId());
		employee.inputData();
		employee.setRoles(Roles.EMPLOYEE);
		if (Validate.username(employee.getUsername())) {
			if (Validate.password(employee.getPassword())) {
				boolean check = userController.register(employee.getUsername());
				if (check) {
					userController.save(employee);
					System.out.println(Message.REGISTER_SUCCESS);
				} else {
					System.err.println(Message.REGISTER_FAILED);
				}
			} else {
				System.err.println(Message.YOU_WRONG);
			}
		} else {
			System.err.println(Message.YOU_WRONG);
		}
	}
	
	public void editEmployee() {
		System.out.print("Nhập ID nhân viên muốn chỉnh sửa: ");
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
		System.out.print("Nhập ID nhân viên muốn sa thải: ");
		int id = InputMethods.getInteger();
		User employee = userController.findById(id);
		if (employee == null || employee.getRoles().equals(Roles.ADMIN) || employee.getRoles().equals(Roles.USER)) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		userController.delete(id);
	}
	
	public void searchEmployee() {
		System.out.print("Nhập từ để tìm nhân viên: ");
		String text = InputMethods.getString();
		boolean check = false;
		System.out.println("============================================================");
		for (User u : userController.getAll()) {
			if (u.getFullName().toLowerCase().contains(text.toLowerCase())) {
				if (u.getRoles().equals(Roles.EMPLOYEE)) {
					System.out.println(u);
					check = true;
				}
			}
		}
		if(!check) {
			System.err.println(Message.NOT_FOUND);
		}
		System.out.println("============================================================");
	}
	
	public void showListEmployees() {
		List<User> employees = new ArrayList<>();
		for (User e : userController.getAll()) {
			if (e.getRoles().equals(Roles.EMPLOYEE)) {
				employees.add(e);
			}
		}
		if (employees.size() == 0) {
			System.err.println(Message.EMPTY);
			return;
		}
		System.out.println("============================================================");
		for (User e : employees) {
			if (e.getRoles().equals(Roles.EMPLOYEE)) {
				System.out.println(e);
				System.out.println("============================================================");
			}
		}
	}
	
}
