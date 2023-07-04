package view.employee;

import config.InputMethods;
import config.Message;
import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.Present;
import model.Roles;
import model.Saving;
import model.User;
import view.Navbar;

import java.util.Date;

public class MenuEmployee {
    private UserController userController;
    private PresentController presentController;

    private SavingController savingController;

    public MenuEmployee(UserController userController, PresentController presentController, SavingController savingController) {
        this.userController = userController;
        this.presentController = presentController;
        this.savingController = savingController;
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
        System.out.print("Enter ID you want: ");
        int id = InputMethods.getInteger();
        userController.changeStatus(id);
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
        Date date = new Date();
        System.out.print("Enter ID you want: ");
        int id = InputMethods.getInteger();
        User user = userController.findById(id);
        if (user == null || user.getRoles().equals(Roles.ADMIN) || user.getRoles().equals(Roles.EMPLOYEE)) {
            System.err.println(Message.YOU_WRONG);
            return;
        }
        showInterestRate();
        while (true) {
            System.out.print("Enter ID you want to add: ");
            int idInterestRate = InputMethods.getInteger();
            Present interestRate = presentController.findById(idInterestRate);
            if (interestRate != null) {
                Saving saving = new Saving();
                saving.setId(savingController.getNewId(user.getList()));
                System.out.print("Enter money you want: ");
                double money = InputMethods.getDouble();
                if (money <= user.getMoney()) {
                    saving.setMoneySaving(money);
                } else {
                    System.err.println(Message.NOT_ENOUGH);
                }
                saving.setPresent(interestRate.getPresent());
                saving.setMonth(interestRate.getLimitMonth());

            }
        }

    }
}
