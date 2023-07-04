package service;

import config.Message;
import model.Saving;

import java.util.List;

public class SavingService {
	public void save(List<Saving> list, Saving element) {
		if (findById(list, element.getId()) == null) {
			list.add(element);
		} else {
			list.set(list.indexOf(findById(list, element.getId())), element);
		}
	}
	
	public void delete(List<Saving> list, int id) {
		if (findById(list, id) == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		list.remove(findById(list, id));
		System.out.println(Message.DELETE_SUCCESS);
	}
	
	public Saving findById(List<Saving> list, int id) {
		for (Saving s : list) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	public int getNewId(List<Saving> list) {
		int idMax = 0;
		for (Saving s : list) {
			if (s.getId() > idMax) {
				idMax = s.getId();
			}
		}
		return idMax + 1;
	}
}
