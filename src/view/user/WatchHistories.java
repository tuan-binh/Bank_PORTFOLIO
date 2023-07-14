package view.user;

import config.InputMethods;
import config.Message;
import controller.UserController;
import model.History;
import model.User;

import java.util.ArrayList;
import java.util.List;

import static config.ColorConsole.*;

public class WatchHistories {
	private int page = 1;
	private int limit = 4;
	
	private int count;
	private int myPage;
	
	private User data;
	private UserController userController;
	
	public WatchHistories(User data, UserController userController) {
		this.data = data;
		this.userController = userController;
		count = 0;
		myPage = limit;
		int pages = data.getHistories().size() / limit + ((data.getHistories().size() % limit == 0) ? 0 : 1);
		while (true) {
			if (data.getHistories().size() == 0) {
				System.err.println(Message.EMPTY);
				return;
			}
			showHistories();
			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.printf("┃       <<(" + RED + " 1 " + BLUE + ")<<        ┃  " + RED + "%d " + GREEN + "/ " + RED + "%d  " + BLUE + "┃        >>(" + RED + " 2 " + BLUE + ")>>       ┃\n", page, pages);
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print(Message.CHOICE);
			int choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					if (page != 1) {
						--page;
						count -= limit;
						myPage -= limit;
					}
					break;
				case 2:
					if (page != pages) {
						++page;
						count += limit;
						myPage += limit;
					}
					break;
				default:
					return;
			}
		}
	}
	
	
	public void showHistories() {
		List<History> list = new ArrayList<>(data.getHistories());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		for (int i = count; i < myPage; i++) {
			try {
				if (list.get(i).getId().startsWith("G")) {
					list.get(i).contentSend();
				}
				if (list.get(i).getId().startsWith("N")) {
					list.get(i).contentReceive();
				}
				if (list.get(i).getId().startsWith("R")) {
					list.get(i).contentChanged();
				}
				if (list.get(i).getId().startsWith("P")) {
					list.get(i).contentWithdrawals();
				}
				if (list.get(i).getId().startsWith("S")) {
					list.get(i).contentSaving();
				}
				if (list.get(i).getId().startsWith("K")) {
					list.get(i).contentRUTSavings();
				}
				System.out.println(BLUE + "-------------------------------------------------------------");
			} catch (IndexOutOfBoundsException e) {
			
			}
		}
		System.out.println();
		for (History h : data.getHistories()) {
			if (!h.isStatus()) {
				h.setStatus(true);
			}
		}
		userController.save(data);
	}
}
