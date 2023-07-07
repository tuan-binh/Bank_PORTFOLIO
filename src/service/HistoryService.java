package service;

import config.Message;
import model.History;

import java.util.LinkedList;
import java.util.List;

public class HistoryService {
	public void save(LinkedList<History> list, History history) {
		if (findById(list, history.getId()) == null) {
			list.addFirst(history);
		} else {
			list.set(list.indexOf(findById(list, history.getId())), history);
		}
	}
	
	public void delete(LinkedList<History> list, String id) {
		if (findById(list, id) != null) {
			list.remove(findById(list, id));
		} else {
			System.err.println(Message.NOT_FOUND);
		}
	}
	
	public History findById(LinkedList<History> list, String id) {
		for (History h : list) {
			if (h.getId().equals(id)) {
				return h;
			}
		}
		return null;
	}
	
	public String getNewIdWithG(LinkedList<History> list) {
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
	
	public String getNewIdWithN(LinkedList<History> list) {
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
	
	public String getNewIdWithNAP(LinkedList<History> list) {
		String id = "R";
		int idMax = 0;
		for (History h : list) {
			if (h.getId().startsWith("R")) {
				int myId = Integer.parseInt(h.getId().replace("R", "0"));
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
