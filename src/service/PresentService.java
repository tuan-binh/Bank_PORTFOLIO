package service;

import config.Message;
import model.Present;
import util.IOFiles;

import java.util.ArrayList;
import java.util.List;

public class PresentService implements IService<Present, Integer> {
	
	private List<Present> listPresent;
	
	public PresentService() {
		List<Present> list = (List<Present>) IOFiles.readFromFile(IOFiles.PRESENT_PATH);
		if (list == null) {
			list = new ArrayList<>();
		}
		listPresent = list;
	}
	
	@Override
	public List<Present> getAll() {
		return listPresent;
	}
	
	@Override
	public void save(Present element) {
		if (findById(element.getId()) == null) {
			listPresent.add(element);
		} else {
			listPresent.set(listPresent.indexOf(findById(element.getId())), element);
		}
		IOFiles.writeToFile(listPresent, IOFiles.PRESENT_PATH);
	}
	
	@Override
	public void delete(Integer id) {
		if (findById(id) == null) {
			System.err.println(Message.NOT_FOUND);
			return;
		}
		listPresent.remove(findById(id));
		IOFiles.writeToFile(listPresent, IOFiles.PRESENT_PATH);
	}
	
	@Override
	public Present findById(Integer id) {
		for (Present p : listPresent) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public Integer getNewId() {
		int idMax = 0;
		for (Present p : listPresent) {
			if (p.getId() > idMax) {
				idMax = p.getId();
			}
		}
		return idMax + 1;
	}
}
