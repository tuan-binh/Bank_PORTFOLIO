package view.admin;

import config.InputMethods;
import config.Message;
import model.User;
import view.Navbar;

public class MoneyManager {
	private User admin;
	
	public MoneyManager(User admin) {
		this.admin = admin;
		while (true) {
			MenuAdmin.showInformation();
			Navbar.Money();
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			System.out.println();
			switch (choice) {
				case 1:
					addCapitalFunds();
					break;
				case 2:
					minusCapitalFunds();
					break;
				case 0:
					return;
				default:
					System.err.println("Try again 0 to 2");
					break;
			}
		}
	}
	
	public void addCapitalFunds() {
		System.out.print("Nhập tiền bạn muốn cho vào ");
		long amount = InputMethods.getPositiveLong();
		admin.setMoney(admin.getMoney() + amount);
	}
	
	public void minusCapitalFunds() {
		System.out.print("Nhập tiền bạn muốn rút ra: ");
		long amount = InputMethods.getPositiveLong();
		if (amount > admin.getMoney()) {
			System.err.println(Message.YOU_WRONG);
			return;
		}
		admin.setMoney(admin.getMoney() - amount);
	}
	
}
