package service;

import model.Saving;

import java.util.List;

public class SavingService {
	private void save(List<Saving> list, Saving element) {
	
	}
	
	public void delete(List<Saving> list, int id) {
	
	}
	
	public Saving findById(List<Saving> list, int id) {
		for (Saving s : list) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	
}
