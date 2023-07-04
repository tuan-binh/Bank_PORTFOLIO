package controller;

import config.Message;
import model.Saving;
import service.SavingService;

import java.util.List;

public class SavingController {

    private SavingService savingService = new SavingService();

    private void save(List<Saving> list, Saving element) {
        savingService.save(list, element);
    }

    public void delete(List<Saving> list, int id) {
        savingService.delete(list, id);
    }

    public Saving findById(List<Saving> list, int id) {
        return savingService.findById(list, id);
    }

    public int getNewId(List<Saving> list) {
        return savingService.getNewId(list);
    }
}
