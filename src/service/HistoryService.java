package service;

import config.Message;
import model.History;

import java.util.List;

public class HistoryService {
	public void save(List<History> list, History history) {
		if (findById(list, history.getId()) == null) {
			list.add(history);
		} else {
			list.set(list.indexOf(findById(list, history.getId())), history);
		}
	}
	
	public void delete(List<History> list, String id) {
		if (findById(list, id) != null) {
			list.remove(findById(list, id));
		} else {
			System.err.println(Message.NOT_FOUND);
		}
	}
	
	public History findById(List<History> list, String id) {
		for (History h : list) {
			if (h.getId().equals(id)) {
				return h;
			}
		}
		return null;
	}
	
	public String getNewIdWithG(List<History> list) {
		String id = "G";
		int idMax = 0;
		for (History h : list) {
			if (h.getId().startsWith("G")) {
				int myId = Integer.parseInt(h.getId().replace("G", "0"));
				if (idMax < myId) {
					idMax = myId;
				}
			}
		}
		idMax += 1;
		String newId = Integer.toString(idMax);
		if (newId.length() == 1) {
			id += "0" + 0 + newId;
		}
		if (newId.length() == 2) {
			id += "0" + newId;
		}
		if (newId.length() == 3) {
			id = newId;
		}
		
		return id;
	}
	
	public String getNewIdWithN(List<History> list) {
		String id = "N";
		int idMax = 0;
		for (History h : list) {
			if (h.getId().startsWith("N")) {
				int myId = Integer.parseInt(h.getId().replace("N", "0"));
				if (idMax < myId) {
					idMax = myId;
				}
			}
		}
		idMax += 1;
		String newId = Integer.toString(idMax);
		if (newId.length() == 1) {
			id += "0" + 0 + newId;
		}
		if (newId.length() == 2) {
			id += "0" + newId;
		}
		if (newId.length() == 3) {
			id = newId;
		}
		
		return id;
	}
	
}
