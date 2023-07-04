package controller;

import model.Present;
import service.PresentService;

import java.util.List;

public class PresentController implements IController<Present, Integer> {
    private PresentService presentService = new PresentService();

    @Override
    public List<Present> getAll() {
        return presentService.getAll();
    }

    @Override
    public void save(Present element) {
        presentService.save(element);
    }

    @Override
    public void delete(Integer id) {
        presentService.delete(id);
    }

    @Override
    public Present findById(Integer id) {
        return presentService.findById(id);
    }

    @Override
    public Integer getNewId() {
        return presentService.getNewId();
    }
}
