package view.admin;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import model.Present;
import view.Navbar;

public class InterestRateManager {
	private static PresentController presentController;
	
	public InterestRateManager(PresentController presentController) {
		this.presentController = presentController;
		while (true) {
			Navbar.Interest();
			System.out.print("Vui lòng chọn: ");
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					showListInterestRate();
					break;
				case 2:
					addInterestRate();
					break;
				case 3:
					editInterestRate();
					break;
				case 4:
					deleteInterestRate();
					break;
				case 5:
					return;
				default:
					break;
			}
		}
	}
	
	public void showListInterestRate() {
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
	
	public void addInterestRate() {
		Present present = new Present();
		present.setId(presentController.getNewId());
		present.inputData();
		presentController.save(present);
	}
	
	public void editInterestRate() {
		System.out.print("Enter ID you want: ");
		int id = InputMethods.getInteger();
		Present present = presentController.findById(id);
		if (present == null) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		Present newPresent = new Present();
		newPresent.setId(present.getId());
		newPresent.inputData();
		presentController.save(newPresent);
	}
	
	public void deleteInterestRate() {
		System.out.print("Enter ID you want: ");
		int id = InputMethods.getInteger();
		presentController.delete(id);
	}
	
}
