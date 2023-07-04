package controller;

import model.User;
import service.UserService;

import java.util.List;

public class UserController implements IController<User, Integer> {
    private UserService userService = new UserService();

    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @Override
    public void save(User element) {
        userService.save(element);
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public Integer getNewId() {
        return userService.getNewId();
    }

    public void changeStatus(Integer id) {
        userService.changeStatus(id);
    }

    public User login(String username, String password) {
        return userService.login(username, password);
    }

    public boolean register(String username) {
        return userService.register(username);
    }
}
