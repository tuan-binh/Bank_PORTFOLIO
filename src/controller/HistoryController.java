package controller;

import config.Message;
import model.History;
import service.HistoryService;

import java.util.List;

public class HistoryController {
	private HistoryService historyService = new HistoryService();
	
	public void save(List<History> list, History history) {
		historyService.save(list, history);
	}
	
	public void delete(List<History> list, String id) {
		historyService.delete(list, id);
	}
	
	public History findById(List<History> list, String id) {
		return historyService.findById(list, id);
	}
	
	public String getNewIdWithG(List<History> list) {
		return historyService.getNewIdWithG(list);
	}
	
	public String getNewIdWithN(List<History> list) {
		return historyService.getNewIdWithN(list);
	}
}
