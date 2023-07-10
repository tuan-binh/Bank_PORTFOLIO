package view;

import controller.PresentController;
import controller.SavingController;
import controller.UserController;
import model.Present;
import model.Roles;
import model.Saving;
import model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Datatest {
	static final UserController userController = new UserController();
	static final PresentController presentController = new PresentController();
	
	static final SavingController savingController = new SavingController();
	
	public static void main(String[] args) {
		User admin = new User(1, "john", "admin", "123", 1200000000, Roles.ADMIN);
		userController.save(admin);
//		User user = userController.findById(2);
//		List<Saving> list = user.getList();
//		System.out.println(user);
//		System.out.println(list);
//		Present present = presentController.findById(1);
//
//		Date nowDate = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MONTH, -3);
//		System.out.println(nowDate.getMonth() + 1);
//		Date oldDate = cal.getTime();
//		System.out.println(oldDate.getMonth() + 1);
//
//		Saving saving = new Saving(1, 1000000, present.getPresent(), present.getLimitMonth(), oldDate, nowDate,false);
//		System.out.println(saving);
//		savingController.save(user.getList(), saving);
//		userController.save(user);
	}
}
