package service;

import config.Message;
import model.Roles;
import model.User;
import util.IOFiles;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User, Integer> {
	
	private List<User> listUser;
	
	public UserService() {
		List<User> list = (List<User>) IOFiles.readFromFile(IOFiles.USER_PATH);
		if (list == null) {
			list = new ArrayList<>();
		}
		listUser = list;
	}
	
	@Override
	public List<User> getAll() {
		return listUser;
	}
	
	@Override
	public void save(User element) {
		if (findById(element.getId()) == null) {
			listUser.add(element);
		} else {
			listUser.set(listUser.indexOf(findById(element.getId())), element);
		}
		IOFiles.writeToFile(listUser, IOFiles.USER_PATH);
	}
	
	@Override
	public void delete(Integer id) {
		if (findById(id) == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		listUser.remove(findById(id));
		IOFiles.writeToFile(listUser, IOFiles.USER_PATH);
	}
	
	@Override
	public User findById(Integer id) {
		for (User u : listUser) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public Integer getNewId() {
		int idMax = 0;
		for (User u : listUser) {
			if (idMax < u.getId()) {
				idMax = u.getId();
			}
		}
		return idMax + 1;
	}
	
	public void changeStatus(Integer id) {
		User user = findById(id);
		if (user == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		user.setStatus(!user.isStatus());
		save(user);
	}
	
	public User login(String username, String password) {
		for (User u : listUser) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public boolean register(String username) {
		for (User u : listUser) {
			if (u.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkSTK(String stk) {
		for (User u : listUser) {
			if (u.getAN() != null && u.getAN().equals(stk)) {
				return false;
			}
		}
		return true;
	}
	
}
