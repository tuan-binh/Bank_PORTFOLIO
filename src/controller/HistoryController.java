package controller;

import config.Message;
import model.History;
import service.HistoryService;

import java.util.LinkedList;
import java.util.List;

public class HistoryController {
	private HistoryService historyService = new HistoryService();
	
	public void save(LinkedList<History> list, History history) {
		historyService.save(list, history);
	}
	
	public void delete(LinkedList<History> list, String id) {
		historyService.delete(list, id);
	}
	
	public History findById(LinkedList<History> list, String id) {
		return historyService.findById(list, id);
	}
	
	public String getNewIdWithG(LinkedList<History> list) {
		return historyService.getNewIdWithG(list);
	}
	
	public String getNewIdWithN(LinkedList<History> list) {
		return historyService.getNewIdWithN(list);
	}
	
	public String getNewIdWithNAP(LinkedList<History> list) {
		return historyService.getNewIdWithNAP(list);
	}
	
	public String getNewIdWithRUT(LinkedList<History> list) {
		return historyService.getNewIdWithRUT(list);
	}
}
